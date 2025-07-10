package link_alone;

import org.zeromq.SocketType;
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

/**
 * @file SignalGenerator.java
 * @comment 该类负责向 ZeroMQ 总线发布测向站监测到装备目标的信号列表
 * @date 2025/7/4
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class SignalGenerator {
    private static final int[] SOURCE_IDS = {1001, 1002};  // 固定的两个 sourceId
    private static final zb.dcts.Dcts.Position[] STATION_POS = {
            zb.dcts.Dcts.Position.newBuilder().setLongitude(116.3).setLatitude(39.8).setAltitude(50).build(),
            zb.dcts.Dcts.Position.newBuilder().setLongitude(116.5).setLatitude(40.0).setAltitude(60).build()
    };

    public static void main(String[] args) throws IOException {
        // 创建 ZeroMQ 上下文和订阅者
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(SocketType.SUB);
        // 连接到目标消息发布者
        subscriber.connect("tcp://localhost:5555");
        // 订阅目标消息
        subscriber.subscribe("Target".getBytes());
        // 创建发布者
        ZMQ.Socket publisher = context.socket(SocketType.PUB);
        // 绑定到发布地址
        publisher.bind("tcp://*:5556");

        while (true) {
            // 1. 接收 Target 消息
            subscriber.recvStr();
            byte[] data = subscriber.recv();
            ByteArrayInputStream in = new ByteArrayInputStream(data);

            Aeronaval.Target target = Aeronaval.Target.parseDelimitedFrom(in);
            if (target == null) {
                System.err.println("Failed to parse Target message.");
                continue;
            }

            // 2. 先发送 Target 消息
            ByteArrayOutputStream targetOut = new ByteArrayOutputStream();
            target.writeDelimitedTo(targetOut);
            publisher.sendMore("Target");
            publisher.send(targetOut.toByteArray());

            // 3. 生成 Survey 列表，每个 survey 中包含多条信号
            List<Detection.SignalLayerSurvey> surveyList = generateSignalList(target,2);
            System.out.printf("目标 %d: 生成 %s%n",
                    target.getId(), surveyList);


            // 4. 将每个完整 Survey 作为一个消息发出（保持结构）
            for (Detection.SignalLayerSurvey survey : surveyList) {
                ByteArrayOutputStream surveyOut = new ByteArrayOutputStream();
                survey.writeDelimitedTo(surveyOut);
                publisher.sendMore("SignalLayerSurvey");
                publisher.send(surveyOut.toByteArray());
            }

            System.out.printf("[发布] Target ID: %d，已发送 Survey 数量: %d%n",
                    target.getId(), surveyList.size());
        }
    }

    // 生成信号列表
    private static List<Detection.SignalLayerSurvey> generateSignalList(Aeronaval.Target tgt, int signalsPerSurvey) {
        List<Detection.SignalLayerSurvey> out = new ArrayList<>();
        Instant t0 = Instant.ofEpochSecond(tgt.getTime().getSeconds(), tgt.getTime().getNanos());

        for (int i = 0; i < SOURCE_IDS.length; i++) {
            int sourceId = SOURCE_IDS[i];
            zb.dcts.Dcts.Position station = STATION_POS[i % STATION_POS.length];

            Detection.SignalLayerSurvey.Builder surveyBuilder = Detection.SignalLayerSurvey.newBuilder()
                    .setTimeStamp(tgt.getTime())
                    .setPosition(station)
                    .setResultFrom(zb.dcts.source.Source.SourceId.newBuilder().setValue(sourceId));

            for (int j = 0; j < signalsPerSurvey; j++) {
                String signalId = UUID.randomUUID().toString().substring(0, 8);
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
                        .setClassification("QPSK")
                        .setDescription("X波段信号")
                        .build();

                surveyBuilder.addFixSignalList(fixSignal);
            }

            out.add(surveyBuilder.build());
        }

        return out;
    }

    // 构造统计值
    private static zb.dcts.Dcts.StatisticVal statVal(double mean) {
        return zb.dcts.Dcts.StatisticVal.newBuilder()
                .setMean(mean)
                .setCur(mean)
                .setUp(mean * 1.05)
                .setDown(mean * 0.95)
                .build();
    }

    // 根据设备类型生成频率范围
    private static zb.dcts.Dcts.StatisticVal freqByEquType(Aeronaval.EquType type) {
        double min, max;
        switch (type) {
            case AIRCAFT_EUT:
            case SU27_EUT:
                min = 300;
                max = 1500;
                break;
            case RADAR_EUT:
                min = 1000;
                max = 18000;
                break;
            case JC_SHJJ_EUT:
                min = 2;
                max = 400;
                break;
            default:
                min = 700;
                max = 2700;
        }
        double freq = min + Math.random() * (max - min);
        return zb.dcts.Dcts.StatisticVal.newBuilder().setMean(freq).build();
    }

    // 计算目标方向
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
