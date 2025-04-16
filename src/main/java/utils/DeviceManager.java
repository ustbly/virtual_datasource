package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sun.xml.internal.ws.encoding.xml.XMLMessage;
import datasource.DataSource;
import datasource.InfoSystem;
import datasource.ReconStation;
import datasource.Sensor;
import entity.NodeInfo;
import redis.clients.jedis.Jedis;
import service.NodeControlService;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
class NodeFileWrapper {
    public List<RawNodeInfo> nodes;
}

class RawNodeInfo {
    public IdWrapper node_id;
    public String node_name;
    public String node_type;
    public TimeWrapper last_heard;
    public List<RawDevice> dataSourceList;
    public boolean is_physical;
}

class RawDevice {
    public IdWrapper device_id;
    public String device_name;
    public String device_type;
    public String status;
}

class IdWrapper {
    public String value;
}

class TimeWrapper {
    public long seconds;
    public int nanos;
}

class DataSourceFactory {
    public static DataSource createDataSource(String type) {
        switch (type) {
            case "Sensor":
                return new Sensor();
            case "InfoSystem":
                return new InfoSystem();
            case "ReconStation":
                return new ReconStation();
            default:
                return null; // 或抛出异常
        }
    }
}

public class DeviceManager {

    public static List<DataSource> getOnlineDevices() {
        List<DataSource> onlineDevices = new ArrayList<>();
        try {
            List<NodeInfo> nodeInfoList = NodeControlService.getNodeInfoFromRedis();
            for (NodeInfo nodeInfo : nodeInfoList) {
                for (DataSource dataSource : nodeInfo.getDataSourceList()) {
                    if ("online".equals(dataSource.getStatus())) {
                        onlineDevices.add(dataSource);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return onlineDevices;
    }

    public static void main(String[] args) {
        List<DataSource> list = getOnlineDevices();
        for (DataSource d : list) {
            System.out.println("Online Device: " + d.getDevice_id() + " - " + d.getDevice_name());
        }
    }
}
