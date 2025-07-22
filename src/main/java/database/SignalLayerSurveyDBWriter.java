package database;

import zb.dcts.Dcts;
import zb.dcts.scenario.detection.Detection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class SignalLayerSurveyDBWriter {

    public static void batchInsertSurveys(Connection conn, List<Detection.SignalLayerSurvey> surveys) throws SQLException {
        for (Detection.SignalLayerSurvey survey : surveys) {
            String surveyId = UUID.randomUUID().toString().substring(0,8);
            insertSurveyMain(conn, survey, surveyId);
            batchInsertFixSignals(conn, survey.getFixSignalListList(), surveyId);
            batchInsertHopSignals(conn, survey.getHopSignalListList(), surveyId);
        }
    }

    private static void insertSurveyMain(Connection conn, Detection.SignalLayerSurvey survey, String surveyId) throws SQLException {
        String sql = "INSERT INTO signal_layer_survey (survey_id, result_from, time_seconds, time_nanos, latitude, longitude, altitude) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Dcts.Position pos = survey.getPosition();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, surveyId);
            ps.setString(2, String.format("%x",survey.getResultFrom().getValue()));
            ps.setLong(3, survey.getTimeStamp().getSeconds());
            ps.setInt(4, survey.getTimeStamp().getNanos());
            ps.setDouble(5, pos.getLatitude());
            ps.setDouble(6, pos.getLongitude());
            ps.setDouble(7, pos.getAltitude());
            ps.executeUpdate();
        }
    }

    private static void batchInsertFixSignals(Connection conn, List<Detection.SignalDigest> signals, String surveyId) throws SQLException {
        String sql = "INSERT INTO fix_signal_digest (" +
                "survey_id, signal_id, activity, center_freq_up, center_freq_down, center_freq_cur, center_freq_mean, " +
                "band_width_up, band_width_down, band_width_cur, band_width_mean, " +
                "amplitude_up, amplitude_down, amplitude_cur, amplitude_mean, " +
                "emit_start_sec, emit_start_ns, emit_end_sec, emit_end_ns, num_features, doa_azimuth, doa_quality, classification, description" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (Detection.SignalDigest sig : signals) {
                ps.setString(1, surveyId);
                ps.setString(2, sig.getId());

                Detection.SignalActivity activity = sig.getActivity();
                int activityValue;

                if (activity == Detection.SignalActivity.UNRECOGNIZED) {
                    activityValue = Detection.SignalActivity.UNKNOWN.getNumber(); // 回退
                } else {
                    int rawValue = activity.getNumber();
                    switch (rawValue) {
                        case 1: case 2: case 4: case 8:
                            activityValue = rawValue;
                            break;
                        default:
                            activityValue = Detection.SignalActivity.UNKNOWN.getNumber();
                    }
                }

                ps.setInt(3, activityValue);

                // 频率
                ps.setDouble(4, sig.getCenterFreq().getUp());
                ps.setDouble(5, sig.getCenterFreq().getDown());
                ps.setDouble(6, sig.getCenterFreq().getCur());
                ps.setDouble(7, sig.getCenterFreq().getMean());
                // 带宽
                ps.setDouble(8, sig.getBandWidth().getUp());
                ps.setDouble(9, sig.getBandWidth().getDown());
                ps.setDouble(10, sig.getBandWidth().getCur());
                ps.setDouble(11, sig.getBandWidth().getMean());
                // 振幅
                ps.setDouble(12, sig.getAmplitude().getUp());
                ps.setDouble(13, sig.getAmplitude().getDown());
                ps.setDouble(14, sig.getAmplitude().getCur());
                ps.setDouble(15, sig.getAmplitude().getMean());
                // 发射时间范围
                ps.setLong(16, sig.getEmitTimeSpan().getStartTime().getSeconds());
                ps.setInt(17, sig.getEmitTimeSpan().getStartTime().getNanos());
                ps.setLong(18, sig.getEmitTimeSpan().getStopTime().getSeconds());
                ps.setInt(19, sig.getEmitTimeSpan().getStopTime().getNanos());
                // 其他信息
                ps.setInt(20, sig.getNumFeatures());
                ps.setDouble(21, sig.getDirOfArrival().getAzimuth());
                ps.setDouble(22, sig.getDirOfArrival().getQuality());
                ps.setString(23, sig.getClassification());
                ps.setString(24, sig.getDescription());

                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private static void batchInsertHopSignals(Connection conn, List<Detection.HopSignalCluster> clusters, String surveyId) throws SQLException {
        String clusterSql = "INSERT INTO hop_signal_cluster (survey_id, cluster_name, activity, emit_start_sec, emit_start_ns, emit_end_sec, emit_end_ns) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String digestSql = "INSERT INTO hop_signal_digest (" +
                "survey_id, cluster_name, center_freq_up, center_freq_down, center_freq_cur, center_freq_mean, " +
                "band_width_up, band_width_down, band_width_cur, band_width_mean, " +
                "amplitude_up, amplitude_down, amplitude_cur, amplitude_mean, num_features" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                PreparedStatement clusterPs = conn.prepareStatement(clusterSql);
                PreparedStatement digestPs = conn.prepareStatement(digestSql)
        ) {
            for (Detection.HopSignalCluster cluster : clusters) {
                String clusterName = cluster.getName();
                clusterPs.setString(1, surveyId);
                clusterPs.setString(2, clusterName);
                clusterPs.setInt(3, cluster.getActivity().getNumber());
                clusterPs.setLong(4, cluster.getEmitTimeSpan().getStartTime().getSeconds());
                clusterPs.setInt(5, cluster.getEmitTimeSpan().getStartTime().getNanos());
                clusterPs.setLong(6, cluster.getEmitTimeSpan().getStopTime().getSeconds());
                clusterPs.setInt(7, cluster.getEmitTimeSpan().getStopTime().getNanos());
                clusterPs.addBatch();

                for (Detection.HopSignalDigest hopSig : cluster.getFreqSetList()) {
                    digestPs.setString(1, surveyId);
                    digestPs.setString(2, clusterName);

                    digestPs.setDouble(3, hopSig.getCenterFreq().getUp());
                    digestPs.setDouble(4, hopSig.getCenterFreq().getDown());
                    digestPs.setDouble(5, hopSig.getCenterFreq().getCur());
                    digestPs.setDouble(6, hopSig.getCenterFreq().getMean());

                    digestPs.setDouble(7, hopSig.getBandWidth().getUp());
                    digestPs.setDouble(8, hopSig.getBandWidth().getDown());
                    digestPs.setDouble(9, hopSig.getBandWidth().getCur());
                    digestPs.setDouble(10, hopSig.getBandWidth().getMean());

                    digestPs.setDouble(11, hopSig.getAmplitude().getUp());
                    digestPs.setDouble(12, hopSig.getAmplitude().getDown());
                    digestPs.setDouble(13, hopSig.getAmplitude().getCur());
                    digestPs.setDouble(14, hopSig.getAmplitude().getMean());

                    digestPs.setInt(15, hopSig.getNumFeatures());

                    digestPs.addBatch();
                }
            }

            clusterPs.executeBatch();
            digestPs.executeBatch();
        }
    }
}
