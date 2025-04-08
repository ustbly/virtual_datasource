package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.util.JsonFormat;
import common.Physical;
import datasource.DataSource;
import entity.NodeInfo;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import redis.clients.jedis.Jedis;
import utils.RedisClient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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


        // 使用 try-with-resources 自动归还 Jedis 连接
        try (Jedis jedis = RedisClient.getJedis()) {
            Set<String> nodeKeys = jedis.keys("N*");
            System.out.println("Redis Node Keys: " + nodeKeys);

            for (String nodeKey : nodeKeys) {
                try {
                    System.out.println("Reading data for Node: " + nodeKey);
                    String nodeData = jedis.get(nodeKey);
                    if (nodeData == null) continue;

                    NodeInfo nodeInfo = objectMapper.readValue(nodeData, NodeInfo.class);

                    NodeControlServiceApi.NodeId nodeId = NodeControlServiceApi.NodeId.newBuilder()
                            .setValue(nodeInfo.getNode_id())
                            .build();

                    NodeControlServiceApi.NodeInfo.Builder nodeBuilder = NodeControlServiceApi.NodeInfo.newBuilder()
                            .setNodeId(nodeId)
                            .setNodeName(nodeInfo.getNode_name())
                            .setNodeType(nodeInfo.getNode_type())
                            .setIsPhysical(nodeInfo.getIs_physical());

                    List<NodeControlServiceApi.DeviceInfo> deviceInfoList = new ArrayList<>();

                    for (DataSource device : nodeInfo.getDataSourceList()) {
                        NodeControlServiceApi.DeviceId deviceId = NodeControlServiceApi.DeviceId.newBuilder()
                                .setValue(device.getDevice_id())
                                .build();

                        NodeControlServiceApi.DeviceInfo.Builder deviceBuilder = NodeControlServiceApi.DeviceInfo.newBuilder()
                                .setDeviceId(deviceId)
                                .setDeviceName(device.getDevice_name())
                                .setDeviceType(device.getDevice_type())
                                .setStatus(device.getStatus());

                        if (device.getPosition() != null) {
                            DCTSServiceApi.Position position = DCTSServiceApi.Position.newBuilder()
                                    .setLatitude(device.getPosition().getLatitude())
                                    .setLongitude(device.getPosition().getLongitude())
                                    .setAltitude(device.getPosition().getAltitude())
                                    .build();
                            deviceBuilder.setPosition(position);
                        }

                        if (device.getPosture() != null) {
                            DCTSServiceApi.Posture posture = DCTSServiceApi.Posture.newBuilder()
                                    .setPitch(device.getPosture().getPitch())
                                    .setRoll(device.getPosture().getRoll())
                                    .setYaw(device.getPosture().getYaw())
                                    .build();
                            deviceBuilder.setPosture(posture);
                        }

                        if (device.getPhysicalList() != null && !device.getPhysicalList().isEmpty()) {
                            List<DCTSServiceApi.Physical> physicalList = device.getPhysicalList().stream().map(p ->
                                    DCTSServiceApi.Physical.newBuilder()
                                            .setType(DCTSServiceApi.Physical.Type.forNumber(p.getType()))
                                            .setValue(p.getValue())
                                            .setUnit(p.getUnit())
                                            .build()
                            ).collect(Collectors.toList());
                            deviceBuilder.addAllPhysicalList(physicalList);
                        }

                        deviceInfoList.add(deviceBuilder.build());
                    }

                    nodeBuilder.addAllDataSourceList(deviceInfoList);
                    nodeInfoList.add(nodeBuilder.build());

                } catch (JsonProcessingException e) {
                    System.err.println("Failed to parse node data for key " + nodeKey + ": " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Redis operation failed: " + e.getMessage());
            e.printStackTrace();
        }

        return nodeInfoList;
    }

}
