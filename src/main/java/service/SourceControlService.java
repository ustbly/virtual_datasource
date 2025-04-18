package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import com.google.protobuf.util.JsonFormat;
import common.Physical;
import common.SourceType;
import datasource.DataSource;
import datasource.InfoSystem;
import datasource.ReconStation;
import datasource.Sensor;
import gRPC.node_control.client.SourceControlClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.SeqGene;
import proto_compile.cetc41.nodecontrol.SourceControlServiceApi;
import redis.clients.jedis.Jedis;
import utils.RedisClient;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static common.SourceType.*;

public class SourceControlService {

    /**
     * 从JSON中获取节点列表
     *
     * @param filePath
     * @return
     */
    public static List<SourceControlServiceApi.SourceInfo> readDevicesFromJson(String filePath) {
        List<SourceControlServiceApi.SourceInfo> sourceInfoList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            JsonNode devicesArray = rootNode.get("devices");

            if (devicesArray != null && devicesArray.isArray()) {
                for (JsonNode device : devicesArray) {
                    // 确保 JSON 格式正确
                    String jsonString = objectMapper.writeValueAsString(device);
//                    System.out.println(device);

                    // 解析 JSON 为 Protobuf
                    SourceControlServiceApi.SourceInfo.Builder deviceBuilder = SourceControlServiceApi.SourceInfo.newBuilder();
                    JsonFormat.parser().ignoringUnknownFields().merge(jsonString, deviceBuilder);

                    sourceInfoList.add(deviceBuilder.build());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceInfoList;
    }

    /**
     * 从Redis数据库中获取节点列表
     *
     * @return
     */
    public static List<DataSource> getDeviceInfoFromRedis() {
        List<DataSource> dataSourceList = new ArrayList<>();
        // 创建 ObjectMapper 实例
        ObjectMapper objectMapper = new ObjectMapper();

        try (Jedis jedis = RedisClient.getJedis()) {
            Set<String> deviceKeys = jedis.keys("devices");
            for (String deviceKey : deviceKeys) {
                try {
                    String deviceData = jedis.get(deviceKey);
//                    System.out.println(deviceData);
                    if (deviceData == null) continue;



                    // 将设备数据转换为 JsonNode
                    JsonNode jsonNode = objectMapper.readTree(deviceData);
//                    System.out.println(jsonNode);
                    // 假设返回的数据是一个数组
                    for (int i = 0; i < jsonNode.size(); i++) {
                        JsonNode device = jsonNode.get(i);
                        System.out.println(device);

                        // 获取 device_type 字段来决定使用哪个子类
                        String deviceType = device.get("type").asText();

                        // 根据 device_type 动态反序列化成不同的子类
                        DataSource source = null;
                        if (SENSOR_3900.equals(SourceType.valueOf(deviceType))) {
                            source = objectMapper.treeToValue(device, Sensor.class);
                        } else if (REMOTE.equals(SourceType.valueOf(deviceType))) {
                            source = objectMapper.treeToValue(device, InfoSystem.class);
                        } else if (FILE.equals(SourceType.valueOf(deviceType))) {
                            source = objectMapper.treeToValue(device, ReconStation.class);
                        } else {
                            System.out.println("Unknown device type: " + deviceType);
                        }

                        if (source != null) {
                            dataSourceList.add(source);
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Json processing failed: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Redis operation failed: " + e.getMessage());
            e.printStackTrace();
        }

        return dataSourceList;
    }

    /**
     * 将Redis数据库中的JSON格式转为gRPC的message格式
     *
     * @return
     */
    public static List<SourceControlServiceApi.SourceInfo> getDeviceInfo() {
        List<DataSource> dataSourceList = getDeviceInfoFromRedis();
        System.out.println();
        List<SourceControlServiceApi.SourceInfo> deviceInfoList = new ArrayList<>();

        for (DataSource device : dataSourceList) {
            SourceControlServiceApi.SourceId sourceId = SourceControlServiceApi.SourceId.newBuilder()
                    .setValue(device.getSource_id())
                    .build();


            SourceControlServiceApi.SourceInfo.Builder deviceBuilder = SourceControlServiceApi.SourceInfo.newBuilder()
                    .setSourceId(sourceId)
                    .setType(SourceControlServiceApi.SourceType.valueOf(device.getType().name()))
                    .setStatus(SourceControlServiceApi.SourceStatus.valueOf(device.getStatus().name()));

            if (device.getPosition() != null) {
                DCTSServiceApi.Position position = DCTSServiceApi.Position.newBuilder()
                        .setLatitude(device.getPosition().getLatitude())
                        .setLongitude(device.getPosition().getLongitude())
                        .setAltitude(device.getPosition().getAltitude())
                        .build();
                deviceBuilder.setPosition(position);
            }

            // 添加 metrics 映射
            if (device.getMetrics() != null && !device.getMetrics().isEmpty()) {
                DCTSServiceApi.Metrics.Builder metricsBuilder = DCTSServiceApi.Metrics.newBuilder();

                for (Map.Entry<String, Physical> entry : device.getMetrics().entrySet()) {
                    String key = entry.getKey();
                    Physical value = entry.getValue();

                    DCTSServiceApi.Physical physical = DCTSServiceApi.Physical.newBuilder()
                            .setType(DCTSServiceApi.Physical.Type.forNumber(value.getType()))
                            .setValue(value.getValue())
                            .setUnit(value.getUnit())
                            .build();

                    metricsBuilder.putIndices(key, physical);
                }

                deviceBuilder.setMetrics(metricsBuilder.build());
            }

            if (device.getTopics() != null && !device.getTopics().isEmpty()) {
                List<DCTSServiceApi.Topic> topicList = new ArrayList<>();
                for (Map<String, String> topicMap : device.getTopics()) {
                    for (Map.Entry<String, String> entry : topicMap.entrySet()) {
                        DCTSServiceApi.Topic topic = DCTSServiceApi.Topic.newBuilder()
                                .setKey(entry.getKey())
                                .setValue(entry.getValue())
                                .build();
                        topicList.add(topic);
                    }
                }
                deviceBuilder.addAllTopics(topicList); // 设置到 DeviceInfo 中
            }

            deviceInfoList.add(deviceBuilder.build());
        }

        return deviceInfoList;
    }

    /**
     * 发送控制指令到设备
     * @param sourceId
     * @param commandFunction
     * @param commandParam
     * @return
     */
    public static DCTSServiceApi.CommandReply sendSourceCommand(int sourceId, int commandFunction, long commandParam) {
        List<DataSource> dataSourceList = SourceControlService.getDeviceInfoFromRedis();
//        System.out.println(dataSourceList);
        String result = "设备" + sourceId +"不存在或设备不在线！"; // 默认值
        boolean found = false;


        for (DataSource dataSource : dataSourceList) {
            System.out.println(dataSource.getSource_id());
            if (sourceId == dataSource.getSource_id() && "S_ENGAGED".equals(dataSource.getStatus().name())) {
                result = dataSource.executeCommand(commandFunction, commandParam);
                found = true;
//                break; // 找到后就不再继续遍历当前 Node 的设备
            }
            else if (sourceId == dataSource.getSource_id() && "S_OFFLINE".equals(dataSource.getStatus().name())) {
                result = dataSource.executeCommand(commandFunction, commandParam);
                found = true;
//                break; // 找到后就不再继续遍历当前 Node 的设备
            }
        }


        DCTSServiceApi.CommandReply commandReply = DCTSServiceApi.CommandReply.newBuilder()
                .setErrorCode(DCTSServiceApi.ErrorType.ERR_ABORTED)
                .setAttachment(Any.pack(StringValue.newBuilder().setValue(result).build()))  // 可根据需求填充
                .build();

        return commandReply;
    }

    public static void main(String[] args) {
        sendSourceCommand(1,6,5);
    }
}
