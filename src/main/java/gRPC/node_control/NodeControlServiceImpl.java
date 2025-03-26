package gRPC.node_control;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import datasource.DataSource;
import datasource.DeviceManager;
import io.grpc.stub.StreamObserver;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceGrpc;
import redis.clients.jedis.Jedis;
import utils.RedisClient;

import java.util.Map;

public class NodeControlServiceImpl extends NodeControlServiceGrpc.NodeControlServiceImplBase {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 获取整个设备列表
     * @return
     */
    public static Map<String, DataSource> getDeviceMap() {
        Map<String, DataSource> deviceMap = null;
        try (Jedis jedis = RedisClient.getJedis()) {
            // 从 Redis 读取 deviceMap
            String json = jedis.get("deviceMap");
            if (json != null) {
                try {
                    deviceMap = objectMapper.readValue(json, new TypeReference<Map<String, DataSource>>(){});
                    System.out.println("deviceMap from Redis: " + deviceMap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No deviceMap found in Redis.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceMap;
    }


    /**
     * 获取某个特定设备
     * @return
     */
    public static DataSource getSpecificDevice(String nodeDeviceId) {
        Map<String, DataSource> deviceMap = null;
        DataSource dataSource = null;
        try (Jedis jedis = RedisClient.getJedis()) {
            // 从 Redis 读取 deviceMap
            String json = jedis.get("deviceMap");
            if (json != null) {
                try {
                    deviceMap = objectMapper.readValue(json, new TypeReference<Map<String, DataSource>>(){});
                    // 获取数据源实例对象
                    dataSource = deviceMap.get(nodeDeviceId);
                    System.out.println("dataSource:" + dataSource);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No dataSource found in Redis.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }


    @Override
    public void postNodeControl(NodeControlServiceApi.NodeControl request, StreamObserver<NodeControlServiceApi.NodeControlResponse> responseObserver) {
        String nodeId = request.getNodeId().getValue();
        String deviceId = request.getDeviceId().getValue();
        NodeControlServiceApi.NodeControlType type = request.getControlType();
        String detail = request.getDetail();

        String key = nodeId + "-" + deviceId;
        DataSource ds = getSpecificDevice(key);
        System.out.println(ds);



        // 执行设备控制逻辑
        String message = "ok";
        boolean success = true;

//        if (ds != null) {
//            message = ds.executeCommand(type,detail);
//            success = true;
//        } else {
//            message = "未知设备 ID: " + nodeId;
//            success = false;
//        }

//        System.out.println("执行操作: " + message);

        // 返回响应
        NodeControlServiceApi.NodeControlResponse response = NodeControlServiceApi.NodeControlResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
