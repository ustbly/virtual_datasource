package utils;


import entity.FixSignal;
import entity.HoppingSignal;
import entity.HoppingSignalCluster;

import java.sql.*;
import java.util.List;

public class DorisUtils {
    private static final String URL = "jdbc:mysql://node1:9030/testdb"; // 替换为你的地址和库名
    private static final String USER = "admin";
    private static final String PASSWORD = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Doris 使用 MySQL 协议
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("未找到 JDBC 驱动", e);
        }
    }


    public static void insertFixSignals(int sourceId, List<FixSignal> fixSignals) {
        String sql = "INSERT INTO fix_signal_data (source_id, signal_id, ts, activity, center_freq, band_width, amplitude, count_num, azimuth, quality, classification, encoding) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (FixSignal fs : fixSignals) {
                ps.setInt(1, sourceId);
                ps.setString(2, fs.getSignalId());
                ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                ps.setString(4, fs.getActivity());
                ps.setDouble(5, fs.getCenter_freq());
                ps.setDouble(6, fs.getBand_width());
                ps.setDouble(7, fs.getAmplitude());
                ps.setInt(8, fs.getCount_num());
                ps.setDouble(9, fs.getDir_of_arrival().getAzimuth());
                ps.setDouble(10, fs.getDir_of_arrival().getQuality());
                ps.setString(11, fs.getClassification());
                ps.setString(12, fs.getExtraInfo().getOrDefault("encoding", ""));
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {
            System.err.println("插入定频信号失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void insertHoppingSignals(int sourceId, List<HoppingSignalCluster> clusters) {
        String sql = "INSERT INTO hopping_signal_data (source_id, cluster_name, ts, center_freq, activity, band_width, amplitude, count_num) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (HoppingSignalCluster cluster : clusters) {
                for (HoppingSignal signal : cluster.getFreq_set()) {
                    ps.setInt(1, sourceId);
                    ps.setString(2, cluster.getName());
                    ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                    ps.setDouble(4, signal.getCenter_freq());
                    ps.setString(5, cluster.getActivity());
                    ps.setDouble(6, signal.getBand_width());
                    ps.setDouble(7, signal.getAmplitude());
                    ps.setInt(8, signal.getCount_num());
                    ps.addBatch();
                }
            }
            ps.executeBatch();
        } catch (Exception e) {
            System.err.println("插入跳频信号失败: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

