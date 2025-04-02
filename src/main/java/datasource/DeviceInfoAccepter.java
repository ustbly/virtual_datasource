package datasource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.zeromq.ZMQ;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class DeviceInfoAccepter {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Jedis redisClient = new Jedis("node1", 6379); // 连接 Redis

    static {
        redisClient.auth("123456");
    }

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5556");
        subscriber.subscribe("");

        System.out.println("Subscriber started...");
        while (!Thread.currentThread().isInterrupted()) {
            try {
                String message = subscriber.recvStr();
                System.out.println("Received: " + message);

                // 解析 JSON 数据并更新设备
                JsonNode jsonNode = objectMapper.readTree(message);
                DeviceManager.getInstance().updateDeviceFromJson(jsonNode);

                // 将 deviceMap 存入 Redis
                saveDeviceMapToRedis();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        subscriber.close();
        context.term();
        redisClient.close();
    }

    // 将 deviceMap 存入 Redis
    private static void saveDeviceMapToRedis() {
        try {
            Map<String, DataSource> deviceMap = DeviceManager.getInstance().getDeviceMap();
            String json = objectMapper.writeValueAsString(deviceMap);
            redisClient.set("deviceMap", json);
            System.out.println("deviceMap saved to Redis: " + json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
