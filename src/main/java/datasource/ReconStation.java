package datasource;

import com.fasterxml.jackson.databind.JsonNode;
import entity.DeviceInfo;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;

public class ReconStation extends DataSource {

    public ReconStation() {
    }

    public ReconStation(String nodeId, String deviceId, String device_type, DeviceInfo deviceInfo) {
        super(nodeId,deviceId,device_type,deviceInfo);
    }


    @Override
    public void updateFromJson(JsonNode jsonNode) {

    }

    @Override
    public String toString() {
        return "ReconStation{" +
                "node_id='" + node_id + '\'' +
                ", device_id='" + device_id + '\'' +
                ", device_type='" + device_type + '\'' +
                ", deviceInfo=" + deviceInfo +
                ", signalList=" + signalList +
                '}';
    }

    @Override
    public String executeCommand(NodeControlServiceApi.NodeControlType type, String detail) {
        switch (type) {
            case REBOOT_NODE:
                return "侦察站 " + this.getNode_id() + " 正在重启...";
            case SHUTDOWN_NODE:
                return "侦察站 " + this.getNode_id() + " 正在关闭...";
            case ABORT_ALL:
                return "侦察站 " + this.getNode_id() + " 正在停止所有任务...";
            case SELF_TEST:
                return "侦察站 " + this.getNode_id() + " 正在自检...";
            case RENAME:
                return "侦察站 " + this.getNode_id() + " 被更名为: " + detail;
            default:
                return "侦察站 " + this.getNode_id() + " 不支持此操作";
        }
    }
}

