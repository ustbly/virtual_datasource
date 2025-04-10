package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import datasource.DataSource;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class DeviceMapUtils {



    private static final ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 获取整个设备列表
     * @return
     */
    public static Map<String, DataSource> getDeviceMap() {
        Map<String, DataSource> deviceMap = null;
        try (Jedis jedis = RedisClient.getJedis()) {
            // 从 Redis 读取 deviceMap
            String json = jedis.get("deviceMap");
            if (json != null) {
                try {
                    deviceMap = objectMapper.readValue(json, new TypeReference<Map<String, DataSource>>(){});
                    System.out.println("deviceMap from Redis: " + deviceMap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No deviceMap found in Redis.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceMap;
    }

    /**
     * 获取某个特定设备
     * @return
     */
    public static DataSource getSpecificDevice(String nodeDeviceId) {
        Map<String, DataSource> deviceMap = null;
        DataSource dataSource = null;
        try (Jedis jedis = RedisClient.getJedis()) {
            // 从 Redis 读取 deviceMap
            String json = jedis.get("deviceMap");
            if (json != null) {
                try {
                    deviceMap = objectMapper.readValue(json, new TypeReference<Map<String, DataSource>>(){});
                    // 获取数据源实例对象
                    dataSource = deviceMap.get(nodeDeviceId);
                    System.out.println("dataSource:" + dataSource);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No dataSource found in Redis.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }


    /**
     * 修改某个特定设备的名字
     * @return
     */
    public static String updateDevice(String nodeDeviceId, String newName) {
//        String DEVICE_MAP_KEY = "deviceMap";
//        String message = null;
//
//        try {
//            // 1. 从 Redis 获取 JSON 字符串
//            Jedis jedis = RedisClient.getJedis();
//            String json = jedis.get(DEVICE_MAP_KEY);
//            if (json == null || json.isEmpty()) {
//                message = "Redis 中 deviceMap 为空";
//            }
//
//            // 2. 解析 JSON
//            JsonNode rootNode = objectMapper.readTree(json);
//            if (rootNode.has(nodeDeviceId)) {
//                // 3. 修改设备名称
//                ObjectNode deviceNode = (ObjectNode) rootNode.get(nodeDeviceId);
//                ObjectNode deviceInfoNode = (ObjectNode) deviceNode.get("deviceInfo");
//                deviceInfoNode.put("name", newName);
//
//                // 4. 序列化回 JSON 并存入 Redis
//                String updatedJson = objectMapper.writeValueAsString(rootNode);
//                jedis.set(DEVICE_MAP_KEY, updatedJson);
//                message = "设备 " + nodeDeviceId + " 名称更新为：" + newName;
//            } else {
//                message = "设备 " + nodeDeviceId + " 不存在";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return message;

        return "";

    }

    public static void main(String[] args) {
//        MockDeviceInfo.updateDeviceName("2cbc9c23","device_111");
    }
}
