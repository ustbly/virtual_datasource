package datasource;


import com.fasterxml.jackson.databind.JsonNode;

import org.zeromq.ZMQ;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Main {
    private static final Map<String, DataSource> deviceMap = new HashMap<>();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5556");
        subscriber.subscribe("");


        // 作为新发布者，发布到新的主题到态势展示分系统
        ZMQ.Socket publisher = context.socket(ZMQ.PUB);
        publisher.bind("tcp://*:5557");

        System.out.println("Subscriber started...");

        while (!Thread.currentThread().isInterrupted()) {
            try {
                String message = subscriber.recvStr();
                System.out.println("Received and forwarding: " + message);

                // 解析 JSON 数据
                JsonNode jsonNode = objectMapper.readTree(message);
                String nodeId = jsonNode.get("node_id").asText();
                String deviceId = jsonNode.get("device_id").asText();
                String type = jsonNode.get("deviceInfo").get("type").asText(); // 确定设备类型

                String key = nodeId + "-" + deviceId;

                // 设备已存在则更新
                if (deviceMap.containsKey(key)) {
                    DataSource existingDevice = deviceMap.get(key);
                    existingDevice.updateFromJson(jsonNode);
                    System.out.println("Updated: " + existingDevice);
                } else {
                    // 创建新设备
                    DataSource newDevice = createDeviceFromJson(type, jsonNode);
                    if (newDevice != null) {
                        deviceMap.put(key, newDevice);
                        System.out.println("New Device Created: " + newDevice);
                    } else {
                        System.out.println("Unknown device type: " + type);
                    }
                }
                // 直接转发到新主题
                publisher.send(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        subscriber.close();
        publisher.close();
        context.term();
    }

    private static DataSource createDeviceFromJson(String type, JsonNode jsonNode) throws Exception {
        switch (type) {
            case "Sensor":
                return objectMapper.treeToValue(jsonNode, Sensor.class);
            case "InfoSystem":
                return objectMapper.treeToValue(jsonNode, InfoSystem.class);
            case "ReconStation":
                return objectMapper.treeToValue(jsonNode, ReconStation.class);
            default:
                return null; // 未知类型，返回 null
        }
    }
}

