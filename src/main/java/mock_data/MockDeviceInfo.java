package mock_data;

import com.alibaba.fastjson.JSONObject;
import common.Physical;
import common.Position;
import common.Posture;
import datasource.Sensor;
import entity.DeviceInfo;

import org.zeromq.ZMQ;

import java.util.*;

public class MockDeviceInfo {
    private static final Map<String, String> nodeDeviceMap = new HashMap<>();
    private static final Random random = new Random();

    public static Sensor generateSensor(String nodeId) {
        String deviceId = nodeDeviceMap.computeIfAbsent(nodeId, k -> generateDeviceId());
        return new Sensor(nodeId, deviceId, generateDeviceInfo(nodeId, deviceId));
    }

    private static DeviceInfo generateDeviceInfo(String nodeId, String deviceId) {
        String type = random.nextBoolean() ?  "Sensor" : "InfoSystem";      // 增加为三个
        String status = random.nextBoolean() ? "ACTIVE" : "INACTIVE";
        Position position = new Position(randomDouble(20, 50), randomDouble(100, 150), randomDouble(0, 1000));
        Posture posture = new Posture(randomDouble(0, 360), randomDouble(0, 360), randomDouble(0, 360));
        List<Physical> physicals = generatePhysicalAttributes();
        return new DeviceInfo(type, status, position, posture, physicals);
    }

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
            String nodeId = "Node-" + random.nextInt(10);
            Sensor sensor = generateSensor(nodeId);
            String message = JSONObject.toJSONString(sensor);
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




