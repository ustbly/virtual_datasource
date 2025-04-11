package mock_data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import common.DOA;
import common.Physical;
import common.Position;
import common.Posture;
import datasource.DataSource;
import datasource.InfoSystem;
import datasource.ReconStation;
import datasource.Sensor;
import entity.FixSignal;
import entity.NodeInfo;
import entity.SignalList;
import redis.clients.jedis.Jedis;
import utils.RedisClient;
import utils.VirtualDeviceScheduler;

import java.io.File;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class NodeInfoGenerator {
    public static void main(String[] args) {
        MockVirtualDataSourceData();

    }

    public static List<NodeInfo> loadNodeInfosFromJson() {
        List<NodeInfo> nodeInfoList = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File("src/main/resources/nodes.json"));
            JsonNode nodesArray = root.get("nodes");

            if (nodesArray != null && nodesArray.isArray()) {
                for (JsonNode node : nodesArray) {
                    String node_id = node.get("node_id").get("value").asText();
                    String node_name = node.get("node_name").asText();
                    String node_type = node.get("node_type").asText();
                    JsonNode dataSourceList = node.get("dataSourceList");
                    boolean is_physical = node.get("is_physical").asBoolean();

                    NodeInfo nodeInfo = generateNode(node_id, node_name, node_type, dataSourceList, is_physical);
                    nodeInfoList.add(nodeInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nodeInfoList;
    }

    /**
     * 模拟生成虚拟设备的状态数据
     */
    public static void MockVirtualDataSourceData() {
        List<NodeInfo> nodeInfoList = loadNodeInfosFromJson();
        try (Jedis jedis = RedisClient.getJedis()) {
            for (NodeInfo nodeInfo : nodeInfoList) {
                String nodeInfoJson = new Gson().toJson(nodeInfo);
                jedis.set(nodeInfo.getNode_id(), nodeInfoJson);
                /*
                if (nodeInfo.getIs_physical()) {
                    VirtualDeviceScheduler.scheduleVirtualDeviceUpdate(nodeInfo.getNode_id());
                    System.out.println("物理设备虚拟节点更新入 Redis: " + nodeInfo.getNode_id());
                } else {
                    System.out.println("纯虚拟设备节点更新入 Redis: " + nodeInfo.getNode_id());
                }
                */
                // 更新设备状态
                VirtualDeviceScheduler.scheduleVirtualDeviceUpdate(nodeInfo.getNode_id());
                System.out.println("设备信息更新入 Redis: " + nodeInfo.getNode_id());
            }
        } catch (Exception e) {
            System.err.println("Redis 更新失败: " + e.getMessage());
        }
    }

    private static NodeInfo generateNode(String nodeId, String nodeName, String nodeType, JsonNode dataSourceList, boolean is_physical) {
        NodeInfo node = new NodeInfo();
        node.setNode_id(nodeId);
        node.setNode_name(nodeName);
        node.setNode_type(nodeType);
        node.setLast_heard(String.valueOf(Instant.now().getEpochSecond()));
        node.setIs_physical(is_physical);

        // 创建设备
        List<DataSource> devices = new ArrayList<>();
        for (JsonNode device : dataSourceList) {
            String device_id = device.get("device_id").get("value").asText();
            String device_name = device.get("device_name").asText();
            String device_type = device.get("device_type").asText();
            String status = device.get("status").asText();
            devices.add(generateDevice(device_id, device_name, device_type, status, is_physical));
        }

        node.setDataSourceList(devices);
        return node;
    }

    public static DataSource generateDevice(String deviceId, String deviceName, String deviceType, String status, boolean is_physical) {
        DataSource device = null;
        switch (deviceType) {
            case "Sensor":
                device = new Sensor();
                break;
            case "InfoSystem":
                device = new InfoSystem();
                break;
            case "ReconStation":
                device = new ReconStation();
                break;
        }

        device.setDevice_id(deviceId);
        device.setDevice_name(deviceName);
        device.setDevice_type(deviceType);
        device.setStatus(status);

        if ("online".equals(status)) {
            // 生成随机位置数据
            double latitude = ThreadLocalRandom.current().nextDouble(-90.0, 90.0);
            double longitude = ThreadLocalRandom.current().nextDouble(-180.0, 180.0);
            double altitude = ThreadLocalRandom.current().nextDouble(0, 10000);  // 海拔 0 - 10000 米
            device.setPosition(new Position(latitude, longitude, altitude));

            // 生成随机姿态数据
            double roll = ThreadLocalRandom.current().nextDouble(0, 360);  // 滚转角 0 - 360 度
            double pitch = ThreadLocalRandom.current().nextDouble(-90, 90); // 俯仰角 -90 到 90 度
            double yaw = ThreadLocalRandom.current().nextDouble(0, 360);   // 偏航角 0 - 360 度
            device.setPosture(new Posture(roll, pitch, yaw));

            List<Physical> physicalList = new ArrayList<>();
            List<FixSignal> fixSignals = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                physicalList.add(generatePhysical(deviceId + "-P" + (i + 1)));
            }
            for (int i = 0; i < 3; i++) {
                fixSignals.add(generateFixSignal(deviceId + "-S" + (i + 1)));
            }

            SignalList signalList = new SignalList();
            signalList.setFixSignalList(fixSignals);
            device.setPhysical(physicalList);
            device.setSignalList(signalList);
        }

        return device;
    }

    private static Physical generatePhysical(String signalId) {
        Physical physical = new Physical();
        physical.setType((int) (Math.random() * 8) + 1);
        physical.setValue(100 + Math.random() * 50);
        physical.setUnit("%");
        return physical;
    }

    private static FixSignal generateFixSignal(String signalId) {
        double azimuth = ThreadLocalRandom.current().nextDouble(0.0, 360.0);
        double quality = ThreadLocalRandom.current().nextDouble(0.0, 100.0);

        FixSignal signal = new FixSignal();
        signal.setSignalId(signalId);
        signal.setActivity("Active");
        signal.setEnter_freq(1000 + Math.random() * 500);
        signal.setBand_width(100 + Math.random() * 50);
        signal.setAmplitude(-50 + Math.random() * 10);
        signal.setCount_num((int) (Math.random() * 100));
        signal.setDir_of_arrival(new DOA(azimuth, quality));
        signal.setClassification("QAM");

        // 额外信息
        Map<String, String> extraInfo = new HashMap<>();
        extraInfo.put("encoding", "AES-256");
        signal.setExtraInfo(extraInfo);

        return signal;
    }
}
