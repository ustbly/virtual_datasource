package utils;

import datasource.DataSource;
import datasource.InfoSystem;
import datasource.ReconStation;
import datasource.Sensor;

/**
 * @file DeviceFactory.java
 * @comment 数据源工厂类
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

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
