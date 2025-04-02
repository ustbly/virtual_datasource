package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import redis.clients.jedis.Jedis;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class DeviceManager {
    private static final String FILE_PATH = "devices.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Jedis REDIS = RedisClient.getJedis();

    public static synchronized List<Device> loadDevices() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();
        try (Reader reader = new FileReader(file)) {
            Type listType = new TypeToken<List<Device>>(){}.getType();
            return GSON.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static synchronized void saveDevices(List<Device> devices) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            GSON.toJson(devices, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Device getDeviceById(String id) {
        String cachedDevice = REDIS.get("device:" + id);
        if (cachedDevice != null) {
            return GSON.fromJson(cachedDevice, Device.class);
        }

        List<Device> devices = loadDevices();
        for (Device device : devices) {
            if (device.getId().equals(id)) {
                REDIS.setex("device:" + id, 3600, GSON.toJson(device)); // 缓存 1 小时
                return device;
            }
        }
        return null;
    }

    public static void addDevice(Device device) {
        List<Device> devices = loadDevices();
        devices.add(device);
        saveDevices(devices);
        REDIS.setex("device:" + device.getId(), 3600, GSON.toJson(device));
    }

    public static void updateDevice(Device updatedDevice) {
        List<Device> devices = loadDevices();
        for (int i = 0; i < devices.size(); i++) {
            if (devices.get(i).getId().equals(updatedDevice.getId())) {
                devices.set(i, updatedDevice);
                saveDevices(devices);
                REDIS.setex("device:" + updatedDevice.getId(), 3600, GSON.toJson(updatedDevice));
                return;
            }
        }
    }

    public static void deleteDevice(String id) {
        List<Device> devices = loadDevices();
        devices.removeIf(device -> device.getId().equals(id));
        saveDevices(devices);
        REDIS.del("device:" + id);
    }

    public static List<Device> getAllDevices() {
        return loadDevices();
    }

    public static void main(String[] args) {
        Device device1 = new Device("1", "Sensor1", "Sensor");
        Device device2 = new Device("2", "ReconStation1", "ReconStation");
        addDevice(device1);
        addDevice(device2);

        System.out.println("All Devices: " + getAllDevices());
        System.out.println("Device 1: " + getDeviceById("1"));
    }
}

class Device {
    private String id;
    private String name;
    private String type;

    public Device(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

