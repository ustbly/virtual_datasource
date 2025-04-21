package datasource;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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


/**
 * @file DataSource.java
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, // 使用字符串来标识子类
        include = JsonTypeInfo.As.EXISTING_PROPERTY, // 这里使用已有属性（手动设置）
        property = "type", // 指定 device_type 作为类型标识
        visible = true // 让 type 仍然可见，避免反序列化后丢失该字段
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = InfoSystem.class, name = "REMOTE"),
        @JsonSubTypes.Type(value = Sensor.class, name = "SENSOR_3900"),
        @JsonSubTypes.Type(value = ReconStation.class, name = "FILE")
})
public abstract class DataSource {
    protected int source_id;                    // 设备编号
    protected SourceType type;                  // 设备编号类型：3900/3900F/...
    protected SourceStatus status;              // 设备状态
    protected Position position;                // 设备位置
    protected Map<String, Physical> metrics;    // 设备的物理属性
    protected List<Map<String,String>> topics;  // 设备发布的主题


    public DataSource(int source_id, SourceType type, SourceStatus status, Position position, Map<String, Physical> metrics, List<Map<String, String>> topics) {
        this.source_id = source_id;
        this.type = type;
        this.status = status;
        this.position = position;
        this.metrics = metrics;
        this.topics = topics;
    }

    public DataSource() {
    }

    public int getSource_id() {
        return source_id;
    }

    public void setSource_id(int source_id) {
        this.source_id = source_id;
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    public SourceStatus getStatus() {
        return status;
    }

    public void setStatus(SourceStatus status) {
        this.status = status;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Map<String, Physical> getMetrics() {
        return metrics;
    }

    public void setMetrics(Map<String, Physical> metrics) {
        this.metrics = metrics;
    }

    public List<Map<String, String>> getTopics() {
        return topics;
    }

    public void setTopics(List<Map<String, String>> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "DataSource{" +
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

    public String getSourceIdAsString() {
        return String.valueOf(this.getSource_id());
    }


    public void shutdown() {
        updateDeviceStatusInJson(source_id, "S_OFFLINE");
    }

    public void startup() {
        updateDeviceStatusInJson(source_id, "S_ENGAGED");
    }

    // 设备执行指令的方法（子类实现）
    public abstract String executeCommand(int commandFunction, long commandParam);
}