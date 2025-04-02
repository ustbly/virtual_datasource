package datasource;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import common.Physical;
import common.Position;
import common.Posture;
import entity.SignalList;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;

import java.util.List;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, // 使用字符串来标识子类
        include = JsonTypeInfo.As.EXISTING_PROPERTY, // 这里使用已有属性（手动设置）
        property = "device_type", // 指定 device_type 作为类型标识
        visible = true // 让 type 仍然可见，避免反序列化后丢失该字段
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = InfoSystem.class, name = "InfoSystem"),
        @JsonSubTypes.Type(value = Sensor.class, name = "Sensor"),
        @JsonSubTypes.Type(value = ReconStation.class, name = "ReconStation")
})
public abstract class DataSource {
    protected String device_id;       // 设备编号
    protected String device_name;     // 设备名称
    protected String device_type;     // 设备编号类型：3900/3900F/...
    protected String status;          // 设备状态
    protected Position position;      // 设备位置
    protected Posture posture;        // 设备姿态
    protected List<Physical> physicalList;// 设备的物理属性
    protected SignalList signalList;    // 信号列表

    public DataSource(String device_id, String device_name, String device_type, String status, Position position, Posture posture, List<Physical> physicalList, SignalList signalList) {
        this.device_id = device_id;
        this.device_name = device_name;
        this.device_type = device_type;
        this.status = status;
        this.position = position;
        this.posture = posture;
        this.physicalList = physicalList;
        this.signalList = signalList;
    }

    public DataSource() {
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Posture getPosture() {
        return posture;
    }

    public void setPosture(Posture posture) {
        this.posture = posture;
    }

    public List<Physical> getPhysicalList() {
        return physicalList;
    }

    public void setPhysical(List<Physical> physicalList) {
        this.physicalList = physicalList;
    }

    public SignalList getSignalList() {
        return signalList;
    }

    public void setSignalList(SignalList signalList) {
        this.signalList = signalList;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "device_id='" + device_id + '\'' +
                ", device_name='" + device_name + '\'' +
                ", device_type='" + device_type + '\'' +
                ", status='" + status + '\'' +
                ", position=" + position +
                ", posture=" + posture +
                ", physicalList=" + physicalList +
                ", signalList=" + signalList +
                '}';
    }

    // 设备执行指令的方法（子类实现）
    public abstract String executeCommand(NodeControlServiceApi.NodeControlType type, String detail);
}