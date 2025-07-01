package utils;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MatcherTest {

    private static final zb.dcts.Dcts.Position[] STATION_POS = {
            zb.dcts.Dcts.Position.newBuilder().setLatitude(39.8).setLongitude(116.3).setAltitude(50).build(),
            zb.dcts.Dcts.Position.newBuilder().setLatitude(40.0).setLongitude(116.5).setAltitude(60).build()
    };

    public static void main(String[] args) {
        int totalTargets = 10;
        int matchedTotal = 0;
        double maxErr = 0, minErr = Double.MAX_VALUE, sumErr = 0;
        int totalComparisons = 0;

        for (int i = 0; i < totalTargets; i++) {
            zb.dcts.aeronaval.Aeronaval.Target tgt = randomTarget(i);
            List<zb.dcts.scenario.detection.Detection.SignalLayerSurvey> surveys = generateMockSurveys(tgt, i);

            List<Double> errs = matchTarget(tgt, surveys);
            totalComparisons += errs.size();

            for (double err : errs) {
                sumErr += err;
                if (err <= 10.0) matchedTotal++;
                maxErr = Math.max(maxErr, err);
                minErr = Math.min(minErr, err);
            }
        }

        double avgErr = totalComparisons > 0 ? sumErr / totalComparisons : 0;

        System.out.printf("%n===== 匹配统计 =====%n");
        System.out.printf("目标数: %d%n", totalTargets);
        System.out.printf("总匹配尝试: %d%n", totalComparisons);
        System.out.printf("成功匹配数: %d%n", matchedTotal);
        System.out.printf("匹配成功率: %.2f%%%n", 100.0 * matchedTotal / totalComparisons);
        System.out.printf("平均误差: %.2f km, 最大: %.2f km, 最小: %.2f km%n", avgErr, maxErr, minErr);
    }

    private static zb.dcts.aeronaval.Aeronaval.Target randomTarget(int id) {
        double lat = 39.85 + Math.random() * 0.3;
        double lon = 116.25 + Math.random() * 0.3;
        return zb.dcts.aeronaval.Aeronaval.Target.newBuilder()
                .setId(id)
                .setName("Target-" + id)
                .setTime(currentProtoTime())
                .setEquType(zb.dcts.aeronaval.Aeronaval.EquType.AIRCAFT_EUT)
                .setPosition(zb.dcts.Dcts.Position.newBuilder().setLatitude(lat).setLongitude(lon).setAltitude(9000 + id * 100))
                .build();
    }

    private static List<zb.dcts.scenario.detection.Detection.SignalLayerSurvey> generateMockSurveys(zb.dcts.aeronaval.Aeronaval.Target tgt, int seed) {
        List<zb.dcts.scenario.detection.Detection.SignalLayerSurvey> list = new ArrayList<>();
        zb.dcts.Dcts.Timestamp ts = tgt.getTime();
        double tgtAz1 = computeAzimuth(STATION_POS[0], tgt.getPosition());
        double tgtAz2 = computeAzimuth(STATION_POS[1], tgt.getPosition());

        for (int i = 0; i < 2; i++) {
            zb.dcts.Dcts.Position station = STATION_POS[i];
            double baseAz = i == 0 ? tgtAz1 : tgtAz2;
            double perturb = (Math.random() - 0.5) * 10; // ±5°扰动

            list.add(
                    zb.dcts.scenario.detection.Detection.SignalLayerSurvey.newBuilder()
                            .setTimeStamp(ts)
                            .setResultFrom(zb.dcts.source.Source.SourceId.newBuilder().setValue(i))
                            .setPosition(station)
                            .addFixSignalList(zb.dcts.scenario.detection.Detection.SignalDigest.newBuilder()
                                    .setId(UUID.randomUUID().toString())
                                    .setCenterFreq(statVal(900e6 + seed * 1e5))
                                    .setBandWidth(statVal(10e6))
                                    .setAmplitude(statVal(-50))
                                    .setDirOfArrival(zb.dcts.Dcts.DOA.newBuilder().setAzimuth(baseAz + perturb))
                                    .setClassification("QPSK")
                                    .setDescription("信号" + seed + "-" + i))
                            .build()
            );
        }
        return list;
    }

    private static List<Double> matchTarget(zb.dcts.aeronaval.Aeronaval.Target tgt, List<zb.dcts.scenario.detection.Detection.SignalLayerSurvey> surveys) {
        List<Double> matchedErrors = new ArrayList<>();
        zb.dcts.Dcts.Position tgtPos = tgt.getPosition();
        Instant t0 = Instant.ofEpochSecond(tgt.getTime().getSeconds(), tgt.getTime().getNanos());

        for (zb.dcts.scenario.detection.Detection.SignalLayerSurvey survey : surveys) {
            Instant surveyTime = Instant.ofEpochSecond(survey.getTimeStamp().getSeconds(), survey.getTimeStamp().getNanos());
            long timeDiff = Math.abs(Duration.between(t0, surveyTime).getSeconds());
            if (timeDiff > 5) continue;

            boolean freqMatch = false;
            for (zb.dcts.scenario.detection.Detection.SignalDigest sig : survey.getFixSignalListList()) {
                if (isFreqMatch(sig.getCenterFreq().getMean(), tgt.getEquType())) {
                    freqMatch = true;
                    break;
                }
            }
            if (!freqMatch) continue;

            List<DOAMeasurement> meas = new ArrayList<>();
            for (zb.dcts.Dcts.Position stationPo : STATION_POS) {
                for (zb.dcts.scenario.detection.Detection.SignalDigest sig : survey.getFixSignalListList()) {
                    meas.add(new DOAMeasurement(
                            stationPo.getLatitude(), stationPo.getLongitude(),
                            sig.getDirOfArrival().getAzimuth()
                    ));
                }
            }

            if (meas.size() >= 2) {
                LatLon est = estimatePositionFromDOA(meas.get(0), meas.get(1));
                double err = haversine(tgtPos.getLatitude(), tgtPos.getLongitude(), est.lat, est.lon);
                System.out.println(err);
                matchedErrors.add(err);
            }
        }
        return matchedErrors;
    }

    // ---------- 其余辅助函数保持不变 ----------

    private static double computeAzimuth(zb.dcts.Dcts.Position from, zb.dcts.Dcts.Position to) {
        double dLon = to.getLongitude() - from.getLongitude();
        double dLat = to.getLatitude() - from.getLatitude();
        double azimuth = Math.toDegrees(Math.atan2(dLon, dLat));
        return (azimuth + 360) % 360;
    }

    private static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371.0;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        return R * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }

    private static zb.dcts.Dcts.StatisticVal statVal(double mean) {
        return zb.dcts.Dcts.StatisticVal.newBuilder()
                .setMean(mean).setCur(mean)
                .setUp(mean * 1.05).setDown(mean * 0.95).build();
    }

    private static zb.dcts.Dcts.Timestamp currentProtoTime() {
        Instant now = Instant.now();
        return zb.dcts.Dcts.Timestamp.newBuilder().setSeconds((int) now.getEpochSecond()).setNanos(now.getNano()).build();
    }

    private static boolean isFreqMatch(double freqHz, zb.dcts.aeronaval.Aeronaval.EquType type) {
        switch (type) {
            case AIRCAFT_EUT:
                return freqHz >= 850e6 && freqHz <= 950e6;
            default:
                return true;
        }
    }

    static class DOAMeasurement {
        double lat, lon, az;

        DOAMeasurement(double lat, double lon, double az) {
            this.lat = lat;
            this.lon = lon;
            this.az = az;
        }
    }

    static class LatLon {
        double lat, lon;

        LatLon(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }
    }

    private static LatLon estimatePositionFromDOA(DOAMeasurement m1, DOAMeasurement m2) {
        double theta1 = Math.toRadians(m1.az);
        double theta2 = Math.toRadians(m2.az);
        double x1 = m1.lon, y1 = m1.lat;
        double x2 = m2.lon, y2 = m2.lat;
        double dx1 = Math.sin(theta1), dy1 = Math.cos(theta1);
        double dx2 = Math.sin(theta2), dy2 = Math.cos(theta2);

        double denominator = dx1 * dy2 - dy1 * dx2;
        if (Math.abs(denominator) < 1e-6) {
            return new LatLon((y1 + y2) / 2, (x1 + x2) / 2);
        }

        double t1 = ((x2 - x1) * dy2 - (y2 - y1) * dx2) / denominator;
        return new LatLon(y1 + t1 * dy1, x1 + t1 * dx1);
    }
}

