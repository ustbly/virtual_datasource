package mock_data;

import com.alibaba.fastjson.JSONObject;
import common.Physical;
import common.Position;
import common.Posture;
import datasource.Sensor;
import datasource.InfoSystem;
import datasource.ReconStation;
import entity.DeviceInfo;
import org.zeromq.ZMQ;

import java.util.*;

public class MockDeviceInfo {
    private static final Map<String, String> nodeDeviceMap = new HashMap<>();
    private static final Random random = new Random();

    // 统一的设备生成方法
    public static Object generateDevice(String nodeId) {
        int type = random.nextInt(3); // 0: Sensor, 1: InfoSystem, 2: ReconStation
        String deviceId = nodeDeviceMap.computeIfAbsent(nodeId, k -> generateDeviceId());

        if (type == 0) {
            return new Sensor(nodeId, deviceId, "Sensor", generateDeviceInfo(nodeId, deviceId));
        } else if (type == 1) {
            return new InfoSystem(nodeId, deviceId, "InfoSystem", generateDeviceInfo(nodeId, deviceId));
        } else {
            return new ReconStation(nodeId, deviceId, "ReconStation", generateDeviceInfo(nodeId, deviceId));
        }
    }

    // 设备信息生成逻辑
    private static DeviceInfo generateDeviceInfo(String nodeId, String deviceId) {
        String[] types = {"3900A", "3900F", "3900X"};
        String type = types[random.nextInt(types.length)]; // 随机类型
        String status = random.nextBoolean() ? "ACTIVE" : "INACTIVE";

        Position position = new Position(randomDouble(20, 50), randomDouble(100, 150), randomDouble(0, 1000));
        Posture posture = new Posture(randomDouble(0, 360), randomDouble(0, 360), randomDouble(0, 360));

        List<Physical> physicals = generatePhysicalAttributes();
        return new DeviceInfo(type, status, position, posture, physicals);
    }

    // 生成物理属性
    private static List<Physical> generatePhysicalAttributes() {
        List<Physical> physicals = new ArrayList<>();
        String[] types = {"Temperature", "Pressure", "Humidity"};
        String[] units = {"C", "Pa", "%"};
        for (int i = 0; i < types.length; i++) {
            physicals.add(new Physical(types[i], randomDouble(10, 100), units[i]));
        }
        return physicals;
    }

    private static double randomDouble(double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    private static String generateDeviceId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket publisher = context.socket(ZMQ.PUB);
        publisher.bind("tcp://*:5556");

        while (true) {
            String nodeId = "" + random.nextInt(10);
            Object device = generateDevice(nodeId); // 可能是 Sensor、InfoSystem、ReconStation
            String message = JSONObject.toJSONString(device);
            publisher.send(message);
            System.out.println("Published: " + message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
