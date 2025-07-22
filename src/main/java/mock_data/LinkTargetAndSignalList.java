package mock_data;

import org.zeromq.ZMQ;
import zb.dcts.Dcts;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
import zb.dcts.scenario.detection.Detection;

import static java.lang.Math.*;

public class LinkTargetAndSignalList {
    private static final Dcts.Position[] STATION_POS = {
            Dcts.Position.newBuilder().setLongitude(116.3).setLatitude(39.8).setAltitude(50).build(),
            Dcts.Position.newBuilder().setLongitude(116.5).setLatitude(40.0).setAltitude(60).build()
    };

    private static final String SUB_ADDR = "tcp://localhost:5556";
    private static final double POSITION_THRESHOLD_KM = 15.0; // 可接受的近似范围（公里）

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect(SUB_ADDR);
        subscriber.subscribe("Combined".getBytes());

        while (!Thread.currentThread().isInterrupted()) {
            subscriber.recv(); // topic
            byte[] msgBytes = subscriber.recv();
            try {
                TargetOuterClass.FusionTargetList fusionTargetList = TargetOuterClass.FusionTargetList.parseFrom(msgBytes);
                Aeronaval.Target target = fusionTargetList.getAeronavalTarget();
                System.out.printf("Received Target ID %d at (%.4f, %.4f)\n",
                        target.getId(),
                        target.getPosition().getLongitude(),
                        target.getPosition().getLatitude());

                for (Detection.SignalLayerSurvey survey : fusionTargetList.getSignalLayerSurveysList()) {
                    for (Detection.SignalDigest sig : survey.getFixSignalListList()) {
                        // 计算反向估计位置
                        Dcts.Position est = estimateTargetPosition(sig.getDirOfArrival(), survey.getPosition());
                        double dist = haversineKm(est, target.getPosition());
                        if (dist < POSITION_THRESHOLD_KM) {
                            System.out.printf("[Match] DOA %.1f° @ Station (%.4f, %.4f) -> estimated %.4f, %.4f | Δ=%.2f km\n",
                                    sig.getDirOfArrival().getAzimuth(),
                                    survey.getPosition().getLongitude(),
                                    survey.getPosition().getLatitude(),
                                    est.getLongitude(), est.getLatitude(), dist);
                        } else {
                            System.out.printf("[NoMatch] DOA %.1f° -> estimated %.4f, %.4f | Δ=%.2f km\n",
                                    sig.getDirOfArrival().getAzimuth(),
                                    est.getLongitude(), est.getLatitude(), dist);
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("Failed to parse CombinedMessage");
                e.printStackTrace();
            }
        }
    }

    // 简化反解目标位置：假设距离为 10km，按 DOA 方向延长向量
    private static Dcts.Position estimateTargetPosition(Dcts.DOA doa, Dcts.Position stationPos) {
        double distanceKm = 10.0; // 假设距离
        double azimuthRad = toRadians(doa.getAzimuth());

        // 简化为平面近似，经纬度单位换算（1 deg ≈ 111 km）
        double dLat = cos(azimuthRad) * distanceKm / 111.0;
        double dLon = sin(azimuthRad) * distanceKm / (111.0 * cos(toRadians(stationPos.getLatitude())));

        return Dcts.Position.newBuilder()
                .setLatitude(stationPos.getLatitude() + dLat)
                .setLongitude(stationPos.getLongitude() + dLon)
                .setAltitude(0)
                .build();
    }

    // Haversine 距离公式：返回 km 级距离
    private static double haversineKm(Dcts.Position a, Dcts.Position b) {
        double R = 6371.0; // 地球半径，单位 km
        double lat1 = toRadians(a.getLatitude());
        double lat2 = toRadians(b.getLatitude());
        double dLat = lat2 - lat1;
        double dLon = toRadians(b.getLongitude() - a.getLongitude());

        double h = pow(sin(dLat / 2), 2)
                + cos(lat1) * cos(lat2) * pow(sin(dLon / 2), 2);
        return 2 * R * asin(sqrt(h));
    }
}
