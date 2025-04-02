package service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.util.JsonFormat;
import common.Physical;
import datasource.DataSource;
import datasource.InfoSystem;
import datasource.ReconStation;
import datasource.Sensor;
import entity.NodeInfo;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import redis.clients.jedis.Jedis;
import utils.RedisClient;
import utils.RuntimeTypeAdapterFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListAllNodes {

    public static List<NodeControlServiceApi.NodeInfo> readNodesFromJson(String filePath) {
        List<NodeControlServiceApi.NodeInfo> nodeInfoList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            JsonNode nodesArray = rootNode.get("nodes");

            if (nodesArray != null && nodesArray.isArray()) {
                for (JsonNode node : nodesArray) {
                    // 确保 JSON 格式正确
                    String jsonString = objectMapper.writeValueAsString(node);

                    // 解析 JSON 为 Protobuf
                    NodeControlServiceApi.NodeInfo.Builder nodeBuilder = NodeControlServiceApi.NodeInfo.newBuilder();
                    JsonFormat.parser().ignoringUnknownFields().merge(jsonString, nodeBuilder);

                    nodeInfoList.add(nodeBuilder.build());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nodeInfoList;
    }

    public static List<NodeControlServiceApi.NodeInfo> getNodesInfo() {
        List<NodeControlServiceApi.NodeInfo> nodeInfoList = new ArrayList<>();
        // 创建 ObjectMapper 实例
        ObjectMapper objectMapper = new ObjectMapper();


        // 创建 Redis 连接
        Jedis jedis = RedisClient.getJedis();

        Set<String> nodeKeys = jedis.keys("N*");  // 获取所有以 "node:" 开头的键（所有节点的标识符）
        System.out.println(nodeKeys);
        for (String nodeKey : nodeKeys) {
            // 读取每个节点的哈希数据（假设每个节点存储在 Redis 哈希中）
            System.out.println("Reading data for Node: " + nodeKey);

            // 获取哈希表字段（根据你的数据结构选择字段）
            String nodeData = jedis.get(nodeKey);

            // 将 JSON 字符串转换为 Java 对象
            NodeInfo nodeInfo = null;
            try {
                nodeInfo = objectMapper.readValue(nodeData, NodeInfo.class);
                NodeControlServiceApi.NodeId nodeId= NodeControlServiceApi.NodeId.newBuilder()
                        .setValue(nodeInfo.getNode_id())  // ✅ 将 String 转换为 Protobuf NodeId
                        .build();


                // 转换为 Protobuf 格式
                NodeControlServiceApi.NodeInfo.Builder node = NodeControlServiceApi.NodeInfo.newBuilder()
                        .setNodeId(nodeId)
                        .setNodeName(nodeInfo.getNode_name())
                        .setNodeType(nodeInfo.getNode_type())
                        .setIsPhysical(nodeInfo.getIs_physical());

                // 构造 DataSource 列表
                List<NodeControlServiceApi.DeviceInfo> dataSourceList = new ArrayList<>();

                for (DataSource device : nodeInfo.getDataSourceList()) {
                    NodeControlServiceApi.DeviceId deviceId = NodeControlServiceApi.DeviceId.newBuilder()
                            .setValue(device.getDevice_id())  // ✅ 将 String 转换为 Protobuf deviceId
                            .build();

                    DCTSServiceApi.Position position = DCTSServiceApi.Position.newBuilder()
                            .setLatitude(device.getPosition().getLatitude())
                            .setAltitude(device.getPosition().getAltitude())
                            .setLongitude(device.getPosition().getLongitude())
                            .build();

                    DCTSServiceApi.Posture posture = DCTSServiceApi.Posture.newBuilder()
                            .setPitch(device.getPosture().getPitch())
                            .setRoll(device.getPosture().getRoll())
                            .setYaw(device.getPosture().getYaw())
                            .build();


                    // 创建 Physical 对象
                    List<DCTSServiceApi.Physical> physicalList = new ArrayList<>();
                    for (Physical physical : device.getPhysicalList()) { // 假设 device.getPhysical() 返回一个 Physical 对象的列表
                        DCTSServiceApi.Physical.Type type = DCTSServiceApi.Physical.Type.forNumber(physical.getType());  // 将整数值转换为枚举常量

                        DCTSServiceApi.Physical physicalProto = DCTSServiceApi.Physical.newBuilder()
                                .setValue(physical.getValue())
                                .setType(type)
                                .setUnit(physical.getUnit())
                                .build();
                        physicalList.add(physicalProto);
                    }


                    NodeControlServiceApi.DeviceInfo dataSource = NodeControlServiceApi.DeviceInfo.newBuilder()
                            .setDeviceId(deviceId)
                            .setDeviceName(device.getDevice_name())
                            .setDeviceType(device.getDevice_type())
                            .setStatus(device.getStatus())
                            .setPosition(position)
                            .setPosture(posture)
                            .addAllPhysicalList(physicalList)
                            .build();
                    dataSourceList.add(dataSource);
                }

                // 设置 DataSource 列表
                node.addAllDataSourceList(dataSourceList);

                // 构建 NodeInfo 对象
                NodeControlServiceApi.NodeInfo nodeBuilder = node.build();

                nodeInfoList.add(nodeBuilder);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return nodeInfoList;
    }

    public static void main(String[] args) {
//        List<NodeControlServiceApi.NodeInfo> nodesInfo = ListAllNodes.getNodesInfo();
//        System.out.println(nodesInfo);
        while (true) {
            System.out.println((int) (Math.random() * 9));
        }
    }

}
