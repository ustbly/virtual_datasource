//package service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.protobuf.Any;
//import com.google.protobuf.util.JsonFormat;
//import datasource.DataSource;
//import org.zeromq.ZMQ;
//import proto_compile.SourceControlServiceApi;
//import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
//import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
//import redis.clients.jedis.Jedis;
//import utils.RedisClient;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class NodeControlService {
//    private static final String ZMQ_PUBLISHER_ENDPOINT = "tcp://localhost:5555";  // ZeroMQ 发布地址
//
//    /**
//     * 从JSON中获取节点列表
//     * @param filePath
//     * @return
//     */
//    public static List<SourceControlServiceApi.NodeInfo> readNodesFromJson(String filePath) {
//        List<NodeControlServiceApi.NodeInfo> nodeInfoList = new ArrayList<>();
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        try {
//            JsonNode rootNode = objectMapper.readTree(new File(filePath));
//            JsonNode nodesArray = rootNode.get("nodes");
//
//            if (nodesArray != null && nodesArray.isArray()) {
//                for (JsonNode node : nodesArray) {
//                    // 确保 JSON 格式正确
//                    String jsonString = objectMapper.writeValueAsString(node);
//
//                    // 解析 JSON 为 Protobuf
//                    NodeControlServiceApi.NodeInfo.Builder nodeBuilder = NodeControlServiceApi.NodeInfo.newBuilder();
//                    JsonFormat.parser().ignoringUnknownFields().merge(jsonString, nodeBuilder);
//
//                    nodeInfoList.add(nodeBuilder.build());
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return nodeInfoList;
//    }
//
//    /**
//     * 从Redis数据库中获取节点列表
//     * @return
//     */
//    public static List<NodeInfo> getNodeInfoFromRedis() {
//
//        List<NodeInfo> nodeInfoList = new ArrayList<>();
//        // 创建 ObjectMapper 实例
//        ObjectMapper objectMapper = new ObjectMapper();
//
//
//        // 使用 try-with-resources 自动归还 Jedis 连接
//        try (Jedis jedis = RedisClient.getJedis()) {
//            Set<String> nodeKeys = jedis.keys("N*");
//            // System.out.println("Redis Node Keys: " + nodeKeys);
//
//            for (String nodeKey : nodeKeys) {
//                try {
//                    // System.out.println("Reading data for Node: " + nodeKey);
//                    String nodeData = jedis.get(nodeKey);
//                    if (nodeData == null) continue;
//
//                    NodeInfo nodeInfo = objectMapper.readValue(nodeData, NodeInfo.class);
//
//                    nodeInfoList.add(nodeInfo);
//
//                } catch (JsonProcessingException e) {
//                    System.out.println("Json processing failed: " + e.getMessage());
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("Redis operation failed: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//        return nodeInfoList;
//    }
//
//    /**
//     * 将Redis数据库中的JSON格式转为gRPC的message格式
//     * @return
//     */
//    public static List<NodeControlServiceApi.NodeInfo> getNodesInfo() {
//        List<NodeControlServiceApi.NodeInfo> nodeInfoList = new ArrayList<>();
//        List<NodeInfo> nodeInfos = getNodeInfoFromRedis();
//        for (NodeInfo nodeInfo : nodeInfos) {
//            NodeControlServiceApi.NodeId nodeId = NodeControlServiceApi.NodeId.newBuilder()
//                    .setValue(nodeInfo.getNode_id())
//                    .build();
//
//            NodeControlServiceApi.NodeInfo.Builder nodeBuilder = NodeControlServiceApi.NodeInfo.newBuilder()
//                    .setNodeId(nodeId)
//                    .setNodeName(nodeInfo.getNode_name())
//                    .setNodeType(nodeInfo.getNode_type())
//                    .setIsPhysical(nodeInfo.getIs_physical());
//
//            List<NodeControlServiceApi.DeviceInfo> deviceInfoList = new ArrayList<>();
//
//            for (DataSource device : nodeInfo.getDataSourceList()) {
//                NodeControlServiceApi.DeviceId deviceId = NodeControlServiceApi.DeviceId.newBuilder()
//                        .setValue(device.getDevice_id())
//                        .build();
//
//                NodeControlServiceApi.DeviceInfo.Builder deviceBuilder = NodeControlServiceApi.DeviceInfo.newBuilder()
//                        .setDeviceId(deviceId)
//                        .setDeviceName(device.getDevice_name())
//                        .setDeviceType(device.getDevice_type())
//                        .setStatus(device.getStatus());
//
//                if (device.getPosition() != null) {
//                    DCTSServiceApi.Position position = DCTSServiceApi.Position.newBuilder()
//                            .setLatitude(device.getPosition().getLatitude())
//                            .setLongitude(device.getPosition().getLongitude())
//                            .setAltitude(device.getPosition().getAltitude())
//                            .build();
//                    deviceBuilder.setPosition(position);
//                }
//
//                if (device.getPosture() != null) {
//                    DCTSServiceApi.Posture posture = DCTSServiceApi.Posture.newBuilder()
//                            .setPitch(device.getPosture().getPitch())
//                            .setRoll(device.getPosture().getRoll())
//                            .setYaw(device.getPosture().getYaw())
//                            .build();
//                    deviceBuilder.setPosture(posture);
//                }
//
//                if (device.getPhysicalList() != null && !device.getPhysicalList().isEmpty()) {
//                    List<DCTSServiceApi.Physical> physicalList = device.getPhysicalList().stream().map(p ->
//                            DCTSServiceApi.Physical.newBuilder()
//                                    .setType(DCTSServiceApi.Physical.Type.forNumber(p.getType()))
//                                    .setValue(p.getValue())
//                                    .setUnit(p.getUnit())
//                                    .build()
//                    ).collect(Collectors.toList());
//                    deviceBuilder.addAllPhysicalList(physicalList);
//                }
//
//                if (device.getTopics() != null && !device.getTopics().isEmpty()) {
//                    List<DCTSServiceApi.Topic> topicList = new ArrayList<>();
//                    for (Map<String, String> topicMap : device.getTopics()) {
//                        for (Map.Entry<String, String> entry : topicMap.entrySet()) {
//                            DCTSServiceApi.Topic topic = DCTSServiceApi.Topic.newBuilder()
//                                    .setKey(entry.getKey())
//                                    .setValue(entry.getValue())
//                                    .build();
//                            topicList.add(topic);
//                        }
//                    }
//                    deviceBuilder.addAllTopics(topicList); // 设置到 DeviceInfo 中
//                }
//
//                deviceInfoList.add(deviceBuilder.build());
//            }
//
//
//
//            nodeBuilder.addAllDataSourceList(deviceInfoList);
//            nodeInfoList.add(nodeBuilder.build());
//
//        }
//        return nodeInfoList;
//    }
//
//    /**
//     * 发送控制指令到设备
//     * @param device_id
//     * @param commandFunction
//     * @param commandParam
//     * @return
//     */
//    public static NodeControlServiceApi.CommandReply sendSourceCommand(String device_id, int commandFunction, long commandParam) {
//        List<NodeInfo> nodeInfoList = NodeControlService.getNodeInfoFromRedis();
//        System.out.println("device_id:" + device_id);
//        String result = "设备" + device_id +"不存在或设备不在线！"; // 默认值
//        boolean found = false;
//
//        for (NodeInfo nodeInfo : nodeInfoList) {
//            for (DataSource dataSource : nodeInfo.getDataSourceList()) {
//                if (device_id.equals(dataSource.getDevice_id()) && "online".equals(dataSource.getStatus())) {
//                    result = dataSource.executeCommand(commandFunction, commandParam);
//                    found = true;
//                    break; // 找到后就不再继续遍历当前 Node 的设备
//                }
//                else if (device_id.equals(dataSource.getDevice_id()) && "offline".equals(dataSource.getStatus())) {
//                    result = dataSource.executeCommand(commandFunction, commandParam);
//                    found = true;
//                    break; // 找到后就不再继续遍历当前 Node 的设备
//                }
//            }
//            if (found) break; // 找到后就退出外层 Node 的遍历
//        }
//
//        NodeControlServiceApi.CommandReply commandReply = NodeControlServiceApi.CommandReply.newBuilder()
//                .setErrorCode(DCTSServiceApi.ErrorType.ERR_ABORTED)
//                .setAttachment(Any.pack(DCTSServiceApi.String.newBuilder().setValue(result).build()))  // 可根据需求填充
//                .build();
//
//        return commandReply;
//    }
//
//    /**
//     * 将最新的设备任务数据发布到消息总线上
//     */
//    public static void PublishSourceMessage() {
//        ZMQ.Context context = ZMQ.context(1);
//        ZMQ.Socket publisher = context.socket(ZMQ.PUB);
//        publisher.bind(ZMQ_PUBLISHER_ENDPOINT);
//
//        try {
//            // 延迟以等待订阅端就绪
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        while (true) {
//            List<NodeInfo> nodeInfos = getNodeInfoFromRedis();
//            for (NodeInfo nodeInfo : nodeInfos) {
//                for (DataSource dataSource : nodeInfo.getDataSourceList()) {
//                    String message = dataSource.toString();
//                    publisher.send(message, 0);
//                    System.out.println("发布消息: " + message);
//                }
//            }
//
//            try {
//                Thread.sleep(3000); // 每 3 秒发布一次
//            } catch (InterruptedException e) {
//                break;
//            }
//        }
//
//        publisher.close();
//        context.term();
//    }
//
//    public static void main(String[] args) {
//        PublishSourceMessage();
//    }
//
//}
