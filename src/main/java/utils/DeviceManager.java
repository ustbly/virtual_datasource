package utils;

import datasource.DataSource;
import datasource.InfoSystem;
import datasource.ReconStation;
import datasource.Sensor;
import service.*;

import java.util.*;

/**
 * @file DeviceManager.java
 * @comment 设备管理工具类
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class DeviceManager {

    public static List<DataSource> getOnlineDevices() {
        List<DataSource> onlineDevices = new ArrayList<>();
        try {
            List<DataSource> dataSourceList = SourceControlService.getDeviceInfoFromRedis();
            for (DataSource ds : dataSourceList) {
                if ("S_ENGAGED".equals(ds.getStatus().name())) {
                    onlineDevices.add(ds);
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
            System.out.println("Online Device: " + d.getSource_id());
        }
    }
}
