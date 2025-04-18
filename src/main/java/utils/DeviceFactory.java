package utils;

import datasource.DataSource;
import datasource.InfoSystem;
import datasource.ReconStation;
import datasource.Sensor;

public class DeviceFactory {
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
