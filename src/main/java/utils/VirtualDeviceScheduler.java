package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import datasource.DataSource;
import entity.FixSignal;
import entity.SignalList;
import mock_data.SourceInfoGenerator;
import org.zeromq.ZMQ;
import redis.clients.jedis.Jedis;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static common.SourceStatus.S_ENGAGED;
import static mock_data.SourceInfoGenerator.generateHoppingSignalCluster;

public class VirtualDeviceScheduler {
    private static final ZMQ.Context context = ZMQ.context(1);
    private static final ZMQ.Socket publisher = context.socket(ZMQ.PUB);
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(100);
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
                System.err.println("[定时更新] Redis 写入失败: " + e.getMessage());
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);
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
                signalList.setFixSignalList(generateFixSignals(3));
                signalList.setHoppingSignalList(generateHoppingSignalCluster());

                // 构造 ZMQ 消息内容
                ObjectMapper mapper = new ObjectMapper();
                ObjectNode json = mapper.createObjectNode();
                json.put("source_id", sourceId);
                json.set("data", mapper.valueToTree(signalList));  // payload 嵌入整个 SignalList

                String topic = "signal_list";
                publisher.sendMore(topic);
                publisher.send(json.toString());

                System.out.println("[ZMQ] 发送: " + topic + " -> " + json);
            }
        }, 0, 2, TimeUnit.SECONDS);
    }

    private static List<FixSignal> generateFixSignals(int count) {
        List<FixSignal> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(SourceInfoGenerator.generateFixSignal("fix-" + i));
        }
        return list;
    }
}
