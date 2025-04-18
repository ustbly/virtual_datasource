package datasource;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import common.Physical;
import common.Position;
import common.SourceStatus;
import common.SourceType;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@JsonTypeName("Sensor")
public class Sensor extends DataSource {
    public Sensor() {
    }


    public Sensor(int source_id, SourceType type, SourceStatus status, Position position, Map<String, Physical> metrics, List<Map<String, String>> topics) {
        super(source_id, type, status, position, metrics, topics);
    }


    @Override
    public String toString() {
        return "Sensor{" +
                "source_id=" + source_id +
                ", type=" + type +
                ", status=" + status +
                ", position=" + position +
                ", metrics=" + metrics +
                ", topics=" + topics +
                '}';
    }

    /**
     * 公共方法：根据 sourceId 修改 JSON 文件中对应设备的 status
     * @param sourceId
     * @param newStatus
     */
    private static void updateDeviceStatusInJson(int sourceId, String newStatus) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/main/resources/devices.json");

        try {
            // 1. 读取 JSON 文件为 JsonNode
            JsonNode root = mapper.readTree(file);

            JsonNode devicesArray = root.get("devices");
            if (devicesArray != null && devicesArray.isArray()) {
                for (JsonNode device : devicesArray) {
                    if (String.valueOf(sourceId).equals(device.get("device_id").get("value").asText())) {
                        ((ObjectNode) device).put("status", newStatus);
                        System.out.println("设备 " + sourceId + " 状态已更新为 " + newStatus);
                        break;
                    }
                    System.out.println(device);
                }
            }

            // 2. 写回 JSON 文件
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, root);

        } catch (IOException e) {
            System.err.println("更新 JSON 文件失败：" + e.getMessage());
            e.printStackTrace();
        }
    }


    public void shutdown() {
        updateDeviceStatusInJson(source_id, "S_OFFLINE");
    }

    public void startup() {
        updateDeviceStatusInJson(source_id, "S_ENGAGED");
    }

    @Override
    public String executeCommand(int commandFunction, long commandParam) {
        switch (commandFunction) {
            case 1:
                return "Sensor:" + this.getSource_id() + " 正在暂停...";
            case 2:
                return "Sensor:" + this.getSource_id() + " 正在恢复...";
            case 3:
                return "Sensor:" + this.getSource_id() + " 正在从某个指定时间点重新启动任务...";
            case 4:
                return "Sensor:" + this.getSource_id() + " 重置采集长度...";
            case 5:
                startup();
                return "Sensor:" + this.getSource_id() + " 正在开机...";
            case 6:
                shutdown();
                return "Sensor:" + this.getSource_id() + " 正在关机...";
            default:
                return "Sensor:" + this.getSource_id() + " 不支持该操作";
        }
    }
}

