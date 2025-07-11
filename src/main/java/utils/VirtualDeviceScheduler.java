package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import common.DOA;
import common.TimeSpan;
import datasource.DataSource;
import entity.FixSignal;
import entity.SignalList;
import mock_data.SourceInfoGenerator;
import org.zeromq.ZMQ;
import redis.clients.jedis.Jedis;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static common.SourceStatus.S_ENGAGED;
import static mock_data.SourceInfoGenerator.generateHoppingSignalCluster;

public class VirtualDeviceScheduler {
    private static final ZMQ.Context context = ZMQ.context(1);
    private static final ZMQ.Socket publisher = context.socket(ZMQ.PUB);
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(100);
    // 全局静态缓存，用于记录历史信号
    private static final Map<String, FixSignal> fixSignalCache = new HashMap<>();
    private static volatile boolean isPublisherBound = false;


    public static void scheduleVirtualDeviceUpdate(int sourceId) {
        scheduler.scheduleWithFixedDelay(() -> {
            List<DataSource> dataSourceList = SourceInfoGenerator.loadDeviceInfosFromJson();
            List<DataSource> updatedDataSourceList = new ArrayList<>();
            for (DataSource ds : dataSourceList) {
                if (sourceId == ds.getSource_id() && S_ENGAGED == ds.getStatus()) {
                    // 重新生成当前设备信息（保持 device_id 不变）
                    DataSource updatedDevice = SourceInfoGenerator.generateDevice(
                            ds.getSource_id(),
                            ds.getType(),
                            ds.getStatus(),
                            true
                    );
                    updatedDataSourceList.add(updatedDevice);
                    System.out.println("[定时更新] 设备" + ds.getSource_id() + "工作中,已更新设备数据: " + updatedDevice);
                } else {
                    updatedDataSourceList.add(ds);
                }
            }
            // 存储更新到 Redis
            try (Jedis jedis = RedisClient.getJedis()) {
                String json = new Gson().toJson(updatedDataSourceList);
                jedis.set("devices", json);
            } catch (Exception e) {
                System.err.println("[设备状态数据] Redis 写入失败: " + e.getMessage());
                e.printStackTrace();
            }
        }, 0, 5, TimeUnit.SECONDS);
    }


    public static void scheduleVirtualDevicePub() {
        if (!isPublisherBound) {
            synchronized (VirtualDeviceScheduler.class) {
                if (!isPublisherBound) {
                    publisher.bind("tcp://*:5555");
                    isPublisherBound = true;
                    System.out.println("[ZMQ] Publisher 成功绑定端口 tcp://*:5555");
                }
            }
        }

        scheduler.scheduleWithFixedDelay(() -> {
            List<DataSource> devices = DeviceManager.getOnlineDevices();

            for (DataSource device : devices) {
                int sourceId = device.getSource_id();

                // 生成模拟信号数据
                SignalList signalList = new SignalList();
                signalList.setFixSignalList(generateFixSignals(2));
                signalList.setHoppingSignalList(generateHoppingSignalCluster());

                // 写入信号数据
//                DorisUtils.insertFixSignals(sourceId, signalList.getFixSignalList());
//                DorisUtils.insertHoppingSignals(sourceId, signalList.getHoppingSignalList());

                // 构造 ZMQ 消息内容
                ObjectMapper mapper = new ObjectMapper();
                ObjectNode json = mapper.createObjectNode();
                json.put("source_id", sourceId);
                json.set("data", mapper.valueToTree(signalList));  // payload 嵌入整个 SignalList

                String topic = "signal_list";
                try {
                    synchronized (publisher) {
                        publisher.sendMore(topic);
                        publisher.send(json.toString());
                    }
                    System.out.println("[ZMQ] 发送: " + topic + " -> " + json);
                } catch (Exception ex) {
                    System.err.println("[ZMQ 发送失败]: " + ex.getMessage());
                    ex.printStackTrace();
                }

                try (Jedis jedis = RedisClient.getJedis()) {
                    // 从 Redis 获取 signal_list（如果存在）
                    String existingJson = jedis.get("signal_list");
                    Map<String, ObjectNode> signalMap;

                    if (existingJson != null) {
                        // 已有数据则解析成 Map
                        signalMap = mapper.readValue(existingJson, new TypeReference<Map<String, ObjectNode>>() {
                        });
                    } else {
                        signalMap = new HashMap<>();
                    }

                    // 添加/更新当前设备数据
                    signalMap.put(device.getSourceIdAsString(), json); // 假设你定义了 device.getSourceIdAsString()

                    // 存回 Redis
                    jedis.set("signal_list", mapper.writeValueAsString(signalMap));
                } catch (Exception e) {
                    System.err.println("[任务数据] Redis 写入失败: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }, 0, 5, TimeUnit.SECONDS);
    }


    //    private static List<FixSignal> generateFixSignals(int count) {
//        List<FixSignal> list = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            list.add(SourceInfoGenerator.generateFixSignal("fix-" + UUID.randomUUID().toString().substring(0,8)));
//        }
//        return list;
//    }
    private static double tweak(double base, double range) {
        return base + (Math.random() * 2 - 1) * range; // 在 ±range 范围内波动
    }

    private static DOA tweakDOA(DOA old) {
        double azimuth = tweak(old.getAzimuth(), 5);
        double quality = tweak(old.getQuality(), 3);
        return new DOA(azimuth, quality);
    }

    private static List<FixSignal> generateFixSignals(int count) {
        List<FixSignal> list = new ArrayList<>();
        List<String> existingIds = new ArrayList<>(fixSignalCache.keySet());

        for (int i = 0; i < count; i++) {
            boolean reuse = !existingIds.isEmpty() && Math.random() < 0.5; // 50% 复用旧信号
            String signalId;
            FixSignal signal;

            if (reuse) {
                // 获取旧信号并克隆 + 微调
                signalId = existingIds.get((int) (Math.random() * existingIds.size()));
                FixSignal old = fixSignalCache.get(signalId);

                signal = new FixSignal();
                signal.setSignalId(signalId);
                signal.setActivity("Active");
                signal.setCenter_freq(tweak(old.getCenter_freq(), 10));  // 微调中心频率 ±10
                signal.setBand_width(tweak(old.getBand_width(), 5));     // 微调带宽 ±5
                signal.setAmplitude(tweak(old.getAmplitude(), 1));       // 微调幅度 ±1
                signal.setCount_num(old.getCount_num() + 1);                    // 增加计数
                signal.setDir_of_arrival(tweakDOA(old.getDir_of_arrival()));
                signal.setClassification("QAM");
                signal.setEmit_time_span(new TimeSpan(new Timestamp(System.currentTimeMillis() - 10000), new Timestamp(System.currentTimeMillis())));
                signal.setExtraInfo(old.getExtraInfo());

            } else {
                // 新信号
                signalId = "fix-" + UUID.randomUUID().toString().substring(0, 8);
                signal = generateFixSignal(signalId);
            }

            fixSignalCache.put(signalId, signal); // 更新缓存
            list.add(signal);
        }

        return list;
    }


    public static FixSignal generateFixSignal(String signalId) {
        double azimuth = RandomUtils.nextDouble(0.0, 360.0, 3);
        double quality = RandomUtils.nextDouble(0.0, 100.0, 3);

        FixSignal signal;

        // 新信号
        signal = new FixSignal();
        signal.setSignalId(signalId);
        signal.setActivity("Active");
        signal.setCenter_freq(1000 + RandomUtils.nextDouble(-500, 500, 3));
        signal.setBand_width(100 + RandomUtils.nextDouble(-50, 50, 3));
        signal.setAmplitude(-50 + RandomUtils.nextDouble(-10, 10, 3));
        signal.setEmit_time_span(new TimeSpan(
                new Timestamp(System.currentTimeMillis() - 10000),
                new Timestamp(System.currentTimeMillis()))
        );
        signal.setCount_num(1);
        signal.setDir_of_arrival(new DOA(azimuth, quality));
        signal.setClassification("QAM");

        Map<String, String> extraInfo = new HashMap<>();
        extraInfo.put("encoding", "AES-256");
        signal.setExtraInfo(extraInfo);

        fixSignalCache.put(signalId, signal);
        return signal;
    }
}
