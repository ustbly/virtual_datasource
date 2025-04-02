package datasource;

import common.Physical;
import common.Position;
import common.Posture;
import entity.SignalList;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;

import java.util.List;

public class InfoSystem extends DataSource {

    public InfoSystem() {
    }

    public InfoSystem(String device_id, String device_name, String device_type, String status, Position position, Posture posture, List<Physical> physicalList, SignalList signalList) {
        super(device_id, device_name, device_type, status, position, posture, physicalList, signalList);
    }

    @Override
    public String toString() {
        return "InfoSystem{" +
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

    @Override
    public String executeCommand(NodeControlServiceApi.NodeControlType type, String detail) {
        switch (type) {
            case REBOOT_NODE:
                return "信息系统 " + this.getDevice_id() + " 正在重启...";
            case SHUTDOWN_NODE:
                return "信息系统 " + this.getDevice_id() + " 正在关闭...";
            case ABORT_ALL:
                return "信息系统 " + this.getDevice_id() + " 正在停止所有任务...";
            case SELF_TEST:
                return "信息系统 " + this.getDevice_id() + " 正在自检...";
            case RENAME:
                return "信息系统 " + this.getDevice_id() + " 被更名为: " + detail;
            default:
                return "信息系统 " + this.getDevice_id() + " 不支持此操作";
        }
    }
}

