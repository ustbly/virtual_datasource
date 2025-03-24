package datasource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.DeviceInfo;
import entity.SignalList;

import java.util.List;

public class Sensor extends DataSource {

    @Override
    public void updateFromJson(JsonNode jsonNode) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.deviceInfo = objectMapper.treeToValue(jsonNode.get("deviceInfo"), DeviceInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Sensor() {
    }

    public Sensor(String node_id, String device_id, DeviceInfo deviceInfo) {
        super(node_id, device_id, deviceInfo);
    }

    public Sensor(String node_id, String device_id, DeviceInfo deviceInfo, SignalList signalList) {
        super(node_id, device_id, deviceInfo, signalList);
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "node_id='" + node_id + '\'' +
                ", device_id='" + device_id + '\'' +
                ", deviceInfo=" + deviceInfo +
                ", signalList=" + signalList +
                '}';
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Sensor-specific initialization...");
    }

    @Override
    public void shutdown() {
        super.shutdown();
        System.out.println("Sensor-specific cleanup...");
    }
}

