package datasource;

import common.Physical;
import common.Position;
import common.Posture;
import entity.SignalList;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import utils.DeviceMapUtils;

import java.util.List;


public class Sensor extends DataSource {
    public Sensor() {
    }


    public Sensor(String device_id, String device_name, String device_type, String status, Position position, Posture posture, List<Physical> physicalList, SignalList signalList) {
        super(device_id, device_name, device_type, status, position, posture, physicalList, signalList);
    }

    @Override
    public String toString() {
        return "Sensor{" +
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
                return "device_id: " + this.getDevice_id() + " 正在重启...";
            case SHUTDOWN_NODE:
                return "device_id: " + this.getDevice_id() + " 正在关闭...";
            case ABORT_ALL:
                return "device_id: " + this.getDevice_id() + " 正在停止所有任务...";
            case SELF_TEST:
                return "device_id: " + this.getDevice_id() + " 正在自检...";
            case RENAME:
                String message = DeviceMapUtils.updateDevice(device_id, detail);
                return message;
            default:
                return "device_id: " + this.getDevice_id() + " 不支持此操作";
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

