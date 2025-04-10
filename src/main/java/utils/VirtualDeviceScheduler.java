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

    public static void scheduleVirtualDeviceUpdate(NodeInfo node) {
        scheduler.scheduleWithFixedDelay(() -> {
            List<DataSource> updatedDevices = new ArrayList<>();
            for (DataSource device : node.getDataSourceList()) {
                DataSource updated = NodeInfoGenerator.generateDevice(
                        device.getDevice_id(),
                        device.getDevice_name(),
                        device.getDevice_type(),
                        "online",
                        true
                );
                updatedDevices.add(updated);
            }

            node.setDataSourceList(updatedDevices);

            // ✅ 同步更新时间戳
            node.setLast_heard(String.valueOf(Instant.now().getEpochSecond()));

            System.out.println("node updated:" + node.hashCode());


            // 存储更新到 Redis
            try (Jedis jedis = RedisClient.getJedis()) {
                String json = new Gson().toJson(node);
                jedis.set(node.getNode_id(), json);
                System.out.println("[定时更新] 节点 " + node.getNode_id() + " 已更新设备数据: " + json);
            } catch (Exception e) {
                System.err.println("[定时更新] Redis 写入失败: " + e.getMessage());
                e.printStackTrace();
            }
        }, 0, 3, TimeUnit.SECONDS);
    }
}
