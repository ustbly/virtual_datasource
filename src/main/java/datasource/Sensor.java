package datasource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.DeviceInfo;
import entity.SignalList;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;


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

    public Sensor(String node_id, String device_id) {
        super(node_id,device_id);
    }

    public Sensor(String node_id, String device_id, String device_type, DeviceInfo deviceInfo) {
        super(node_id, device_id, device_type, deviceInfo);
    }

    public Sensor(String node_id, String device_id, String device_type, DeviceInfo deviceInfo, SignalList signalList) {
        super(node_id, device_id, device_type, deviceInfo, signalList);
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
    public String executeCommand(NodeControlServiceApi.NodeControlType type, String detail) {
        switch (type) {
            case REBOOT_NODE:
                return "node_id: " + this.getNode_id() + " device_id: " + this.getDevice_id() + " 正在重启...";
            case SHUTDOWN_NODE:
                return "node_id: " + this.getNode_id() + " device_id: " + this.getDevice_id() + " 正在关闭...";
            case ABORT_ALL:
                return "node_id: " + this.getNode_id() + " device_id: " + this.getDevice_id() + " 正在停止所有任务...";
            case SELF_TEST:
                return "node_id: " + this.getNode_id() + " device_id: " + this.getDevice_id() + " 正在自检...";
            case RENAME:
                return "node_id: " + this.getNode_id() + " device_id: " + this.getDevice_id() + " 被更名为: " + detail;
            default:
                return "node_id: " + this.getNode_id() + " device_id: " + this.getDevice_id() + " 不支持此操作";
        }
    }
}

