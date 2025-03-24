package datasource;


import com.fasterxml.jackson.databind.JsonNode;
import entity.DeviceInfo;
import entity.SignalList;

public abstract class DataSource {
    protected String node_id;  // 节点ID
    protected String device_id;  // 设备ID
    protected DeviceInfo deviceInfo;  // 设备状态
    protected SignalList signalList;  // 信号列表

    public abstract void updateFromJson(JsonNode jsonNode);


    public DataSource() {
    }

    // 用来测试发布节点信息
    public DataSource(String node_id, String device_id, DeviceInfo deviceInfo) {
        this.node_id = node_id;
        this.device_id = device_id;
        this.deviceInfo = deviceInfo;
    }

    public DataSource(String node_id, String device_id, DeviceInfo deviceInfo, SignalList signalList) {
        this.node_id = node_id;
        this.device_id = device_id;
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

    // 启动/使能数据源
    public void start() {
        System.out.println(node_id + ":" + device_id + " (" + this.getClass().getSimpleName() + ") is now ON.");
    }

    // 关闭/屏蔽数据源
    public void shutdown() {
        System.out.println(node_id + ":" + device_id + " (" + this.getClass().getSimpleName() + ") is now OFF.");
    }
}