package datasource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeviceManager {
    private static final DeviceManager INSTANCE = new DeviceManager();
    private final Map<String, DataSource> deviceMap = new ConcurrentHashMap<>();
    private static final ObjectMapper objectMapper = new ObjectMapper();


    private DeviceManager() {}

    public static DeviceManager getInstance() {
        return INSTANCE;
    }

    public Map<String, DataSource> getDeviceMap() {
        return Collections.unmodifiableMap(deviceMap);
    }

    public DataSource getDevice(String key) {
        return deviceMap.get(key);
    }

    public void updateDevice(String key, DataSource device) {
        deviceMap.put(key, device);
        System.out.println("DeviceMap Updated: " + deviceMap);
    }

    // **从 JSON 更新或添加设备**
    public void updateDeviceFromJson(JsonNode jsonNode) throws Exception {
        String nodeId = jsonNode.get("node_id").asText();
        String deviceId = jsonNode.get("device_id").asText();
        String type = jsonNode.get("device_type").asText(); // 设备类型
        String key = nodeId + "-" + deviceId;

        if (deviceMap.containsKey(key)) {
            DataSource existingDevice = deviceMap.get(key);
//            existingDevice.updateFromJson(jsonNode);
        } else {
            DataSource newDevice = createDeviceFromJson(type, jsonNode);
            if (newDevice != null) {
                deviceMap.put(key, newDevice);
            }
        }
    }

    // **创建设备对象**
    private DataSource createDeviceFromJson(String type, JsonNode jsonNode) throws Exception {
        switch (type) {
            case "Sensor":
                return objectMapper.treeToValue(jsonNode, Sensor.class);
            case "InfoSystem":
                return objectMapper.treeToValue(jsonNode, InfoSystem.class);
            case "ReconStation":
                return objectMapper.treeToValue(jsonNode, ReconStation.class);
            default:
                return null;
        }
    }
}
