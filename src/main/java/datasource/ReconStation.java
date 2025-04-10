package datasource;

import common.Physical;
import common.Position;
import common.Posture;
import entity.SignalList;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;

import java.util.List;

public class ReconStation extends DataSource {

    public ReconStation() {
    }

    public ReconStation(String device_id, String device_name, String device_type, String status, Position position, Posture posture, List<Physical> physicalList, SignalList signalList) {
        super(device_id, device_name, device_type, status, position, posture, physicalList, signalList);
    }


    @Override
    public String executeCommand(NodeControlServiceApi.NodeControlType type, String detail) {
        switch (type) {
            case REBOOT_NODE:
                return "侦察站 " + this.getDevice_id() + " 正在重启...";
            case SHUTDOWN_NODE:
                return "侦察站 " + this.getDevice_id() + " 正在关闭...";
            case ABORT_ALL:
                return "侦察站 " + this.getDevice_id() + " 正在停止所有任务...";
            case SELF_TEST:
                return "侦察站 " + this.getDevice_id() + " 正在自检...";
            case RENAME:
                return "侦察站 " + this.getDevice_id() + " 被更名为: " + detail;
            default:
                return "侦察站 " + this.getDevice_id() + " 不支持此操作";
        }
    }

    @Override
    public String executeCommand(int commandFunction, long commandParam) {
        switch (commandFunction) {
            case 1:
                return "device_id: " + this.getDevice_id() + " 正在重启...";
            case 2:
                return "device_id: " + this.getDevice_id() + " 正在关闭...";
            case 3:
                return "device_id: " + this.getDevice_id() + " 正在停止所有任务...";
            case 4:
                return "device_id: " + this.getDevice_id() + " 正在自检...";
            case 5:
                return "device_id: " + this.getDevice_id() + " 正在开机...";
            case 6:
                return "device_id: " + this.getDevice_id() + " 正在关机...";
            default:
                return "device_id: " + this.getDevice_id() + " 不支持此操作";
        }
    }
}

