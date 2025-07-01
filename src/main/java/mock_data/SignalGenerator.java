package mock_data;

import org.zeromq.ZMQ;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.scenario.detection.Detection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SignalGenerator {
    private static final int[] SOURCE_IDS = {1001, 1002};  // 固定的两个 sourceId
    private static final zb.dcts.Dcts.Position[] STATION_POS = {
            zb.dcts.Dcts.Position.newBuilder().setLongitude(116.3).setLatitude(39.8).setAltitude(50).build(),
            zb.dcts.Dcts.Position.newBuilder().setLongitude(116.5).setLatitude(40.0).setAltitude(60).build()
    };

    public static void main(String[] args) throws IOException {
        // 创建 ZeroMQ 上下文和订阅者
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        // 连接到目标消息发布者
        subscriber.connect("tcp://localhost:5555");
        // 订阅目标消息
        subscriber.subscribe("Target".getBytes());
        // 创建发布者
        ZMQ.Socket publisher = context.socket(ZMQ.PUB);
        // 绑定到发布地址
        publisher.bind("tcp://*:5556");

        while (true) {
            subscriber.recvStr();
            byte[] data = subscriber.recv();
            // 解析目标消息
            // 用 ByteArrayInputStream + parseDelimitedFrom 正确读取
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            Aeronaval.Target target = Aeronaval.Target.parseDelimitedFrom(in);

            if (target == null) {
                System.err.println("Failed to parse Target message.");
                continue;
            }
//            System.out.println("[Processor] Received Target#" + target);
            // 生成信号列表
            List<Detection.SignalLayerSurvey> list = generateSignalList(target);
            System.out.println("信号列表：" + list);
            // 构造组合消息
//            TargetOuterClass.CombinedMessage msg = TargetOuterClass.CombinedMessage.newBuilder()
//                    .setAeronavalTarget(target)
//                    .addAllSignalLayerSurveys(list)
//                    .build();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            // 发布组合消息
            for (Detection.SignalLayerSurvey survey : list) {
                survey.writeDelimitedTo(out);
            }
            publisher.send(out.toByteArray());
            publisher.sendMore("SignalList");
            System.out.println("[Processor] Published SignalList message for Target#" + target.getId());
        }
    }

    private static List<Detection.SignalLayerSurvey> generateSignalList(Aeronaval.Target tgt) {
        List<Detection.SignalLayerSurvey> out = new ArrayList<>();
        Instant t0 = Instant.ofEpochSecond(tgt.getTime().getSeconds(), tgt.getTime().getNanos());
        int surveysPerSource = 3;  // 每个 source 采集 3 条 survey
        for (int i = 0; i < SOURCE_IDS.length; i++) {
            int sourceId = SOURCE_IDS[i];
            zb.dcts.Dcts.Position station = STATION_POS[i % STATION_POS.length];

            for (int j = 0; j < surveysPerSource; j++) {
                String signalId = UUID.randomUUID().toString();
                zb.dcts.Dcts.StatisticVal freq = freqByEquType(tgt.getEquType());
                zb.dcts.Dcts.DOA doa = computeDOA(tgt.getPosition(), station);
                int emitStartSec = (int) (t0.getEpochSecond() - 1);
                int emitEndSec = (int) t0.getEpochSecond() + 1;

                Detection.SignalDigest fixSignal = Detection.SignalDigest.newBuilder()
                        .setId(signalId)
                        .setActivity(Detection.SignalActivity.ACTIVE)
                        .setCenterFreq(freq)
                        .setBandWidth(statVal(freq.getMean() * 0.1))
                        .setAmplitude(statVal(50 + Math.random() * 30))
                        .setEmitTimeSpan(
                                zb.dcts.Dcts.TimeSpan.newBuilder()
                                        .setStartTime(zb.dcts.Dcts.Timestamp.newBuilder().setSeconds(emitStartSec).setNanos(0))
                                        .setStopTime(zb.dcts.Dcts.Timestamp.newBuilder().setSeconds(emitEndSec).setNanos(0))
                        )
                        .setNumFeatures(10 + new Random().nextInt(10))
                        .setDirOfArrival(doa)
                        .setClassification("QPSK") // 示例调制方式
                        .setDescription("X波段信号")
                        .build();

                // 跳频集群
//            Detection.HopSignalCluster.Builder hopCluster = Detection.HopSignalCluster.newBuilder()
//                    .setName("Link16-HoppingSystem")
//                    .setActivity(Detection.SignalActivity.ACTIVE)
//                    .setEmitTimeSpan(
//                            zb.dcts.Dcts.TimeSpan.newBuilder()
//                                    .setStartTime(zb.dcts.Dcts.Timestamp.newBuilder().setSeconds(emitStartSec))
//                                    .setStopTime(zb.dcts.Dcts.Timestamp.newBuilder().setSeconds(emitEndSec))
//                    );

//            for (int j = 0; j < 5; j++) { // 每个集群 5 个频点
//                double baseFreq = freq.getMean() + (j - 2) * 1e6; // ±偏移
//                Detection.HopSignalDigest digest = Detection.HopSignalDigest.newBuilder()
//                        .setCenterFreq(statVal(baseFreq))
//                        .setBandWidth(statVal(500e3 + Math.random() * 200e3))
//                        .setAmplitude(statVal(40 + Math.random() * 20))
//                        .setNumFeatures(5 + new Random().nextInt(5))
//                        .build();
//                hopCluster.addFreqSet(digest);
//            }

                // 组合为一次 Survey
                Detection.SignalLayerSurvey survey = Detection.SignalLayerSurvey.newBuilder()
                        .setTimeStamp(tgt.getTime())
                        .setPosition(station)
                        .setResultFrom(zb.dcts.source.Source.SourceId.newBuilder().setValue(sourceId))
                        .addFixSignalList(fixSignal)
//                    .addHopSignalList(hopCluster.build())
                        .build();

                out.add(survey);
        }

        }
        return out;
    }

    private static zb.dcts.Dcts.StatisticVal statVal(double mean) {
        return zb.dcts.Dcts.StatisticVal.newBuilder()
                .setMean(mean)
                .setCur(mean)
                .setUp(mean * 1.05)
                .setDown(mean * 0.95)
                .build();
    }


    private static zb.dcts.Dcts.StatisticVal freqByEquType(Aeronaval.EquType type) {
        double min, max;
        switch (type) {
            case AIRCAFT_EUT:
            case SU27_EUT:
                min = 300; max = 1500; break;
            case RADAR_EUT:
                min = 1000; max = 18000; break;
            case JC_SHJJ_EUT:
                min = 2; max = 400; break;
            default:
                min = 700; max = 2700;
        }
        double f = min + Math.random() * (max - min);
        return zb.dcts.Dcts.StatisticVal.newBuilder().setMean(f).build();
    }

    private static zb.dcts.Dcts.DOA computeDOA(zb.dcts.Dcts.Position target, zb.dcts.Dcts.Position station) {
        double lat1 = Math.toRadians(station.getLatitude());
        double lon1 = Math.toRadians(station.getLongitude());
        double lat2 = Math.toRadians(target.getLatitude());
        double lon2 = Math.toRadians(target.getLongitude());

        double dLon = lon2 - lon1;
        double y = Math.sin(dLon) * Math.cos(lat2);
        double x = Math.cos(lat1) * Math.sin(lat2)
                - Math.sin(lat1) * Math.cos(lat2) * Math.cos(dLon);

        double azimuth = Math.toDegrees(Math.atan2(y, x));
        double result = (azimuth + 360) % 360;  // 归一化到 0~360°
        return zb.dcts.Dcts.DOA.newBuilder().setAzimuth((int) result).build();
    }
}
