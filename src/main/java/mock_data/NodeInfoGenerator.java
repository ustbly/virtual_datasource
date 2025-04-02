package mock_data;

import com.google.gson.Gson;
import common.DOA;
import common.Physical;
import common.Position;
import common.Posture;
import datasource.DataSource;
import datasource.Sensor;
import entity.FixSignal;
import entity.NodeInfo;
import entity.SignalList;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import redis.clients.jedis.Jedis;
import utils.RedisClient;

import java.sql.Timestamp;
import java.util.*;

public class NodeInfoGenerator {
    public static void main(String[] args) {
        // 创建 Redis 连接
        Jedis jedis = RedisClient.getJedis();

        // 创建模拟的 NodeInfo 数据
        NodeInfo node1 = generateNode("N001", "Node-Alpha", "Sensor");
        NodeInfo node2 = generateNode("N002", "Node-Beta", "ReconStation");

        // 序列化数据
        Gson gson = new Gson();
        String node1Json = gson.toJson(node1);
        String node2Json = gson.toJson(node2);

        // 存储到 Redis
        jedis.set(node1.getNode_id(), node1Json);
        jedis.set(node2.getNode_id(), node2Json);

        System.out.println("数据已存入 Redis：");
        System.out.println("N001 -> " + node1Json);
        System.out.println("N002 -> " + node2Json);

        // 关闭 Redis 连接
        jedis.close();
    }

    private static NodeInfo generateNode(String nodeId, String nodeName, String nodeType) {
        NodeInfo node = new NodeInfo();
        node.setNode_id(nodeId);
        node.setNode_name(nodeName);
        node.setNode_type(nodeType);
        node.setLast_heard("170000000");
        node.setIs_physical(false);

        // 创建两个设备
        List<DataSource> devices = new ArrayList<>();
        devices.add(generateDevice(nodeId + "-D1", "Device-1", "Sensor"));
        devices.add(generateDevice(nodeId + "-D2", "Device-2", "InfoSystem"));

        node.setDataSourceList(devices);
        return node;
    }

    private static DataSource generateDevice(String deviceId, String deviceName, String deviceType) {
        DataSource device = new Sensor(); // 假设为 Sensor 设备
        device.setDevice_id(deviceId);
        device.setDevice_name(deviceName);
        device.setDevice_type(deviceType);
        device.setStatus("Online");
        device.setPosition(new Position(16,24,36));
        device.setPosture(new Posture(89,12,45));

        List<Physical> physicalList = new ArrayList<>();


        // 生成信号列表
        SignalList signalList = new SignalList();
        List<FixSignal> fixSignals = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            fixSignals.add(generateFixSignal(deviceId + "-S" + (i + 1)));
        }

        for (int i = 0; i < 3; i++) {
            physicalList.add(generatePhysical(deviceId + "-S" + (i + 1)));
        }

        signalList.setFixSignalList(fixSignals);

        device.setPhysical(physicalList);
        device.setSignalList(signalList);

        return device;
    }

    private static Physical generatePhysical(String signalId) {
        Physical physical = new Physical();
        physical.setType((int) (Math.random() * 8) + 1);
        physical.setValue(100 + Math.random() * 50);
        physical.setUnit("%");
        return physical;
    }

    private static FixSignal generateFixSignal(String signalId) {
        FixSignal signal = new FixSignal();
        signal.setSignalId(signalId);
        signal.setActivity("Active");
        signal.setEnter_freq(1000 + Math.random() * 500);
        signal.setBand_width(100 + Math.random() * 50);
        signal.setAmplitude(-50 + Math.random() * 10);
        signal.setCount_num((int) (Math.random() * 100));
        signal.setDir_of_arrival(new DOA(10.0,20.0));
        signal.setClassification("QAM");

        // 额外信息
        Map<String, String> extraInfo = new HashMap<>();
        extraInfo.put("encoding", "AES-256");
        signal.setExtraInfo(extraInfo);

        return signal;
    }
}
