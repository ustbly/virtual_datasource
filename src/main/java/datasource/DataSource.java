package datasource;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import entity.DeviceInfo;
import entity.SignalList;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, // 使用字符串来标识子类
        include = JsonTypeInfo.As.EXISTING_PROPERTY, // 这里使用已有属性（手动设置）
        property = "device_type", // 指定 type 作为类型标识
        visible = true // 让 type 仍然可见，避免反序列化后丢失该字段
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = InfoSystem.class, name = "InfoSystem"),
        @JsonSubTypes.Type(value = Sensor.class, name = "Sensor"),
        @JsonSubTypes.Type(value = ReconStation.class, name = "ReconStation")
})

public abstract class DataSource {
    protected String node_id;  // 节点ID
    protected String device_id;  // 设备ID
    protected String device_type; // 设备类型

    protected DeviceInfo deviceInfo;  // 设备状态
    protected SignalList signalList;  // 信号列表

    public DataSource(String node_id, String device_id, String device_type, DeviceInfo deviceInfo) {
        this.node_id = node_id;
        this.device_id = device_id;
        this.device_type = device_type;
        this.deviceInfo = deviceInfo;
    }

    public abstract void updateFromJson(JsonNode jsonNode);

    // 关键：新增 type 字段，并在 `deviceInfo` 赋值时填充它
//    public String getType() {
//        return deviceInfo != null ? deviceInfo.getType() : null;
//    }

    public DataSource() {
    }

    // 用来测试发布节点信息
    public DataSource(String node_id, String device_id) {
        this.node_id = node_id;
        this.device_id = device_id;
    }


    // 用来测试发布节点信息
    public DataSource(String node_id, String device_id, DeviceInfo deviceInfo) {
        this.node_id = node_id;
        this.device_id = device_id;
        this.deviceInfo = deviceInfo;
    }


    public DataSource(String node_id, String device_id, String device_type, DeviceInfo deviceInfo, SignalList signalList) {
        this.node_id = node_id;
        this.device_id = device_id;
        this.device_type = device_type;
        this.deviceInfo = deviceInfo;
        this.signalList = signalList;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public SignalList getSignalList() {
        return signalList;
    }

    public void setSignalList(SignalList signalList) {
        this.signalList = signalList;
    }

    // 设备执行指令的方法（子类实现）
    public abstract String executeCommand(NodeControlServiceApi.NodeControlType type, String detail);
}