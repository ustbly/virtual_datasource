package datasource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import common.Physical;
import common.Position;
import common.Posture;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import utils.DeviceMapUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Sensor extends DataSource {
    public Sensor() {
    }


    public Sensor(String device_id, String device_name, String device_type, String status, Position position, Posture posture, List<Physical> physicalList, List<Map<String, String>> topics) {
        super(device_id, device_name, device_type, status, position, posture, physicalList, topics);
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
                ", topics=" + topics +
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

    /**
     * 公共方法：根据 device_id 修改 JSON 文件中对应设备的 status
     * @param deviceId
     * @param newStatus
     */
    private void updateDeviceStatusInJson(String deviceId, String newStatus) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/main/resources/nodes.json");

        try {
            // 1. 读取 JSON 文件为 JsonNode
            JsonNode root = mapper.readTree(file);

            JsonNode nodesArray = root.get("nodes");
            if (nodesArray != null && nodesArray.isArray()) {
                for (JsonNode node : nodesArray) {
                    JsonNode dataSourceList = node.get("dataSourceList");
                    if (dataSourceList != null && dataSourceList.isArray()) {
                        for (JsonNode device : dataSourceList) {
                            if (deviceId.equals(device.get("device_id").get("value").asText())) {
                                ((ObjectNode) device).put("status", newStatus);
                                System.out.println("设备 " + deviceId + " 状态已更新为 " + newStatus);
                                break;
                            }
                        }
                    }
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
        updateDeviceStatusInJson(device_id, "offline");
    }

    public void startup() {
        updateDeviceStatusInJson(device_id, "online");
    }

    @Override
    public String executeCommand(int commandFunction, long commandParam) {
        switch (commandFunction) {
            case 1:
                return "Sensor:" + this.getDevice_id() + " 正在重启...";
            case 2:
                return "Sensor:" + this.getDevice_id() + " 正在关闭...";
            case 3:
                return "Sensor:" + this.getDevice_id() + " 正在停止所有任务...";
            case 4:
                return "Sensor:" + this.getDevice_id() + " 正在自检...";
            case 5:
                startup();
                return "Sensor:" + this.getDevice_id() + " 正在开机...";
            case 6:
                shutdown();
                return "Sensor:" + this.getDevice_id() + " 正在关机...";
            default:
                return "Sensor:" + this.getDevice_id() + " 不支持此操作";
        }
    }
}

