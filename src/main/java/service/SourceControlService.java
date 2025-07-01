package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Any;
import com.google.protobuf.StringValue;
import com.google.protobuf.util.JsonFormat;
import common.Physical;
import common.SourceType;
import datasource.DataSource;
import datasource.InfoSystem;
import datasource.ReconStation;
import datasource.Sensor;
import redis.clients.jedis.Jedis;
import utils.RedisClient;
import zb.dcts.Dcts;
import zb.dcts.source.Source;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static common.SourceType.*;

/**
 * @file SourceControlService.java
 * @comment 服务端接口实现的中间层
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class SourceControlService {

    /**
     * 从JSON中获取节点列表
     *
     * @param filePath
     * @return
     */
    public static List<Source.SourceInfo> readDevicesFromJson(String filePath) {
        List<Source.SourceInfo> sourceInfoList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            JsonNode devicesArray = rootNode.get("devices");

            if (devicesArray != null && devicesArray.isArray()) {
                for (JsonNode device : devicesArray) {
                    // 确保 JSON 格式正确
                    String jsonString = objectMapper.writeValueAsString(device);
                    // System.out.println(device);

                    // 解析 JSON 为 Protobuf
                    Source.SourceInfo.Builder deviceBuilder = Source.SourceInfo.newBuilder();
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
                    // System.out.println(deviceData);
                    if (deviceData == null) continue;



                    // 将设备数据转换为 JsonNode
                    JsonNode jsonNode = objectMapper.readTree(deviceData);
                    // System.out.println(jsonNode);
                    // 假设返回的数据是一个数组
                    for (int i = 0; i < jsonNode.size(); i++) {
                        JsonNode device = jsonNode.get(i);
                        // System.out.println(device);

                        // 获取 device_type 字段来决定使用哪个子类
                        String deviceType = device.get("type").asText();

                        // 根据 device_type 动态反序列化成不同的子类
                        DataSource source = null;
                        if (SENSOR_3900.equals(SourceType.valueOf(deviceType))) {
                            source = objectMapper.treeToValue(device, Sensor.class);
                        } else if (KH_CZ_COMM.equals(SourceType.valueOf(deviceType))) {
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
    public static List<Source.SourceInfo> getDeviceInfo() {
        List<DataSource> dataSourceList = getDeviceInfoFromRedis();
        List<Source.SourceInfo> deviceInfoList = new ArrayList<>();

        for (DataSource device : dataSourceList) {
            Source.SourceId sourceId = Source.SourceId.newBuilder()
                    .setValue(device.getSource_id())
                    .build();


            Source.SourceInfo.Builder deviceBuilder = Source.SourceInfo.newBuilder()
                    .setSourceId(sourceId)
                    .setType(Source.SourceType.valueOf(device.getType().name()))
                    .setStatus(Source.SourceStatus.valueOf(device.getStatus().name()));

            if (device.getPosition() != null) {
                Dcts.Position position = Dcts.Position.newBuilder()
                        .setLatitude(device.getPosition().getLatitude())
                        .setLongitude(device.getPosition().getLongitude())
                        .setAltitude(device.getPosition().getAltitude())
                        .build();
                deviceBuilder.setPosition(position);
            }

            // 添加 metrics 映射
            if (device.getMetrics() != null && !device.getMetrics().isEmpty()) {
                Dcts.Metrics.Builder metricsBuilder = Dcts.Metrics.newBuilder();

                for (Map.Entry<String, Physical> entry : device.getMetrics().entrySet()) {
                    String key = entry.getKey();
                    Physical value = entry.getValue();

                    Dcts.Physical physical = Dcts.Physical.newBuilder()
                            .setType(Dcts.Physical.Type.forNumber(value.getType()))
                            .setValue(value.getValue())
                            .setUnit(value.getUnit())
                            .build();

                    metricsBuilder.putIndices(key, physical);
                }

                deviceBuilder.setMetrics(metricsBuilder.build());
            }

            if (device.getTopics() != null && !device.getTopics().isEmpty()) {
                List<Dcts.Topic> topicList = new ArrayList<>();
                for (Map<String, String> topicMap : device.getTopics()) {
                    for (Map.Entry<String, String> entry : topicMap.entrySet()) {
                        Dcts.Topic topic = Dcts.Topic.newBuilder()
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
    public static Dcts.CommandReply sendSourceCommand(int sourceId, int commandFunction, long commandParam) {
        List<DataSource> dataSourceList = SourceControlService.getDeviceInfoFromRedis();
        // System.out.println(dataSourceList);
        String result = "设备" + sourceId +"不存在或设备不在线！"; // 默认值
        boolean found = false;


        for (DataSource dataSource : dataSourceList) {
            // System.out.println(dataSource.getSource_id());
            if (sourceId == dataSource.getSource_id() && "S_ENGAGED".equals(dataSource.getStatus().name())) {
                result = dataSource.executeCommand(commandFunction, commandParam);
                found = true;
                // break; // 找到后就不再继续遍历当前 Node 的设备
            }
            else if (sourceId == dataSource.getSource_id() && "S_OFFLINE".equals(dataSource.getStatus().name())) {
                result = dataSource.executeCommand(commandFunction, commandParam);
                found = true;
                // break; // 找到后就不再继续遍历当前 Node 的设备
            }
        }


        Dcts.CommandReply commandReply = Dcts.CommandReply.newBuilder()
                .setErrorCode(Dcts.ErrorType.ERR_ABORTED)
                .setAttachment(Any.pack(StringValue.newBuilder().setValue(result).build()))  // 可根据需求填充
                .build();

        return commandReply;
    }



    public static void main(String[] args) {
        sendSourceCommand(1,6,5);
    }
}
