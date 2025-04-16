package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import datasource.DataSource;
import entity.FixSignal;
import entity.NodeInfo;
import entity.SignalList;
import mock_data.NodeInfoGenerator;
import org.zeromq.ZMQ;
import redis.clients.jedis.Jedis;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static mock_data.NodeInfoGenerator.generateHoppingSignalCluster;

public class VirtualDeviceScheduler {
    private static final ZMQ.Context context = ZMQ.context(1);
    private static final ZMQ.Socket publisher = context.socket(ZMQ.PUB);
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(100);
    private static volatile boolean isPublisherBound = false;


    public static void scheduleVirtualDeviceUpdate(String nodeId) {
        scheduler.scheduleWithFixedDelay(() -> {
            List<NodeInfo> nodeInfoList = NodeInfoGenerator.loadNodeInfosFromJson();
            for (NodeInfo nodeInfo : nodeInfoList) {
                if (nodeId.equals(nodeInfo.getNode_id())) {
                    List<DataSource> originalList = nodeInfo.getDataSourceList();
                    List<DataSource> updatedList = new ArrayList<>();

                    for (DataSource device : originalList) {
                        if ("online".equals(device.getStatus())) {
                            // 重新生成当前设备信息（保持 device_id 不变）
                            DataSource updatedDevice = NodeInfoGenerator.generateDevice(
                                    device.getDevice_id(),
                                    device.getDevice_name(),
                                    device.getDevice_type(),
                                    "online",
                                    true
                            );
                            updatedList.add(updatedDevice); // 替换为新生成的更新对象
                        } else {
                            updatedList.add(device); // 保留原本的设备（如 status 为 offline）
                        }
                    }

                    nodeInfo.setDataSourceList(updatedList);

                    // ✅ 同步更新时间戳
                    nodeInfo.setLast_heard(String.valueOf(Instant.now().getEpochSecond()));
                    //System.out.println("nodeInfo updated:" + nodeInfo.hashCode());

                    // 存储更新到 Redis
                    try (Jedis jedis = RedisClient.getJedis()) {
                        String json = new Gson().toJson(nodeInfo);
                        jedis.set(nodeInfo.getNode_id(), json);
                        System.out.println("[定时更新] 节点 " + nodeInfo.getNode_id() + " 已更新设备数据: " + json);
                    } catch (Exception e) {
                        System.err.println("[定时更新] Redis 写入失败: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
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
                String deviceId = device.getDevice_id();

                // 生成模拟信号数据
                SignalList signalList = new SignalList();
                signalList.setFixSignalList(generateFixSignals(3));
                signalList.setHoppingSignalList(generateHoppingSignalCluster());

                // 构造 ZMQ 消息内容
                ObjectMapper mapper = new ObjectMapper();
                ObjectNode json = mapper.createObjectNode();
                json.put("device_id", deviceId);
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
            list.add(NodeInfoGenerator.generateFixSignal("fix-" + i));
        }
        return list;
    }
}
