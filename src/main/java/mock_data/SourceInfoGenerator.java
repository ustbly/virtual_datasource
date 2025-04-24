package mock_data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import common.*;
import datasource.DataSource;
import datasource.InfoSystem;
import datasource.ReconStation;
import datasource.Sensor;
import entity.*;
import redis.clients.jedis.Jedis;
import utils.RandomUtils;
import utils.RedisClient;
import utils.VirtualDeviceScheduler;

import java.io.File;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static common.SourceStatus.S_ENGAGED;

/**
 * @file SourceInfoGenerator.java
 * @comment 模拟生成设备状态和任务数据的工具类
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class SourceInfoGenerator {

    public static void main(String[] args) {
        MockAndPubVirtualDataSourceData();
    }

    /**
     * 模拟生成并发布虚拟设备的状态数据
     */
    public static void MockAndPubVirtualDataSourceData() {
        List<DataSource> dataSourceList = loadDeviceInfosFromJson();
        try (Jedis jedis = RedisClient.getJedis()) {
            for (DataSource dataSource : dataSourceList) {
                String deviceInfoJson = new Gson().toJson(dataSource);
                jedis.set("devices", deviceInfoJson);
                // 更新设备状态
                VirtualDeviceScheduler.scheduleVirtualDeviceUpdate(dataSource.getSource_id());
                VirtualDeviceScheduler.scheduleVirtualDevicePub();
            }
            System.out.println("设备信息更新入 Redis");
        } catch (Exception e) {
            System.err.println("Redis 更新失败: " + e.getMessage());
        }
    }


    /**
     * 从JSON中加载节点设备数据
     * @return List<NodeInfo>
     */
    public static List<DataSource> loadDeviceInfosFromJson() {
        List<DataSource> dataSourceList = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File("src/main/resources/devices.json"));
            JsonNode devicesArray = root.get("devices");

            if (devicesArray != null && devicesArray.isArray()) {
                for (JsonNode device : devicesArray) {
                    int device_id = device.get("device_id").get("value").asInt();
                    SourceType device_type = SourceType.valueOf(device.get("device_type").asText());
                    SourceStatus status = SourceStatus.valueOf(device.get("status").asText());
                    boolean is_physical = device.get("is_physical").asBoolean();


                    DataSource deviceInfo = generateDevice(device_id, device_type, status, is_physical);
                    dataSourceList.add(deviceInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSourceList;
    }


    /**
     * 模拟生成 DataSource 数据结构
     * @param deviceId
     * @param deviceType
     * @param status
     * @param is_physical
     * @return DataSource
     */
    public static DataSource generateDevice(int deviceId,  SourceType deviceType, SourceStatus status, boolean is_physical) {
        DataSource device = null;
        Map<String,Physical> metrics = new HashMap<>();
        List<Map<String, String>> topics = new ArrayList<>();
        List<String> dataType = new ArrayList<>();
        dataType.add("signal_list");
        dataType.add("spectrum");

        for (String data : dataType) {
            Map<String, String> map = new HashMap<>();
            map.put(data,"");
            topics.add(map);
        }

        switch (deviceType) {
            case SENSOR_3900:
                device = new Sensor();
                break;
            case FILE:
                device = new InfoSystem();
                break;
            case REMOTE:
                device = new ReconStation();
                break;
        }

        device.setSource_id(deviceId);
        device.setType(deviceType);
        device.setStatus(status);
        metrics.put("metrics",generatePhysical());
        device.setMetrics(metrics);
        device.setTopics(topics);


        if (S_ENGAGED == status) {
            // 生成随机位置数据
            double latitude = RandomUtils.nextDouble(-90.0, 90.0, 3);
            double longitude = RandomUtils.nextDouble(-180.0, 180.0, 3);
            double altitude = RandomUtils.nextDouble(0, 10000, 3);  // 海拔 0 - 10000 米
            device.setPosition(new Position(latitude, longitude, altitude));

            List<Physical> physicalList = new ArrayList<>();
            List<FixSignal> fixSignals = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                physicalList.add(generatePhysical());
            }
            for (int i = 0; i < 3; i++) {
                fixSignals.add(generateFixSignal(deviceId + "-S" + (i + 1)));
            }


        }

        return device;
    }

    /**
     * 模拟生成物理指标数据
     * @return Physical
     */
    private static Physical generatePhysical() {
        Physical physical = new Physical();
        physical.setType((int) (Math.random() * 8) + 1);
        physical.setValue(100 + Math.random() * 50);
        physical.setUnit("%");
        return physical;
    }

    /**
     * 模拟生成定频信号
     * @param signalId
     * @return FixSignal
     */
    public static FixSignal generateFixSignal(String signalId) {
        double azimuth = RandomUtils.nextDouble(0.0, 360.0, 3);
        double quality = RandomUtils.nextDouble(0.0, 100.0, 3);

        FixSignal signal = new FixSignal();
        signal.setSignalId(signalId);
        signal.setActivity("Active");
        signal.setCenter_freq(1000 + RandomUtils.nextDouble(-500,500,3));
        signal.setBand_width(100 + RandomUtils.nextDouble(-50,50,3));
        signal.setAmplitude(-50 + RandomUtils.nextDouble(-10,10,3));
        signal.setCount_num((int) (Math.random() * 100));
        signal.setDir_of_arrival(new DOA(azimuth, quality));
        signal.setClassification("QAM");

        // 额外信息
        Map<String, String> extraInfo = new HashMap<>();
        extraInfo.put("encoding", "AES-256");
        signal.setExtraInfo(extraInfo);

        return signal;
    }


    /**
     * 模拟生成跳频信号数据集
     * @return List<HoppingSignalCluster>
     */
    public static List<HoppingSignalCluster> generateHoppingSignalCluster() {
        List<HoppingSignal> hoppingSignalList = new ArrayList<>();
        List<HoppingSignalCluster> hoppingSignalClusterList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            double center_freq = RandomUtils.nextDouble(-50.0, 100.0,3);
            double band_width = RandomUtils.nextDouble(-20.0, 20.0,3);
            double amplitude = RandomUtils.nextDouble(20.0, 200.0,3);

            HoppingSignal signal = new HoppingSignal(center_freq, band_width, amplitude, 5);

            hoppingSignalList.add(signal);
        }

        HoppingSignalCluster hoppingSignalCluster = new HoppingSignalCluster();
        hoppingSignalCluster.setName("hopSignalCluster-" + UUID.randomUUID().toString().substring(0,8));
        hoppingSignalCluster.setActivity("Active");
        hoppingSignalCluster.setTimeSpan(new TimeSpan());
        hoppingSignalCluster.setFreq_set(hoppingSignalList);

        hoppingSignalClusterList.add(hoppingSignalCluster);

        return hoppingSignalClusterList;
    }
}
