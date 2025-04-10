package utils;

import com.google.gson.Gson;
import datasource.DataSource;
import entity.NodeInfo;
import mock_data.NodeInfoGenerator;
import redis.clients.jedis.Jedis;
import utils.RedisClient;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VirtualDeviceScheduler {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(100);

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

                    System.out.println("nodeInfo updated:" + nodeInfo.hashCode());

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

        }, 0, 3, TimeUnit.SECONDS);
    }
}
