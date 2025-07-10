package link_combine;

import org.zeromq.ZMQ;
import zb.dcts.Dcts;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
import zb.dcts.scenario.detection.Detection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 林跃
 * @file CombinePublisher.java
 * @comment 该类负责向 ZeroMQ 总线发布装备目标和频域信号的组合消息，
 * 它模拟了多个测向站对目标的检测，并将结果发布到指定的 ZeroMQ 地址。
 * @date 2025/7/2
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class CombinePublisher {
    private final ZMQ.Context context;
    private final ZMQ.Socket publisher;
    private final ScheduledExecutorService scheduler;
    private final int intervalMillis;
    private final Random rand = new Random();

    // 测向站模拟位置
    private static final Dcts.Position[] STATION_POS = {
            Dcts.Position.newBuilder().setLongitude(116.3).setLatitude(39.8).setAltitude(50).build(),
            Dcts.Position.newBuilder().setLongitude(116.5).setLatitude(40.0).setAltitude(60).build()
    };

    // 构造函数
    public CombinePublisher(String bindAddr, int intervalMillis) {
        this.context = ZMQ.context(1);
        this.publisher = context.socket(ZMQ.PUB);
        this.publisher.bind(bindAddr);
        this.intervalMillis = intervalMillis;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    // 持续性向总线发布数据
    public void start() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                Aeronaval.Target target = buildRandomTarget();
                List<Detection.SignalLayerSurvey> surveyList = generateSignalList(target);

                TargetOuterClass.CombinedMessage msg = TargetOuterClass.CombinedMessage.newBuilder()
                        .setAeronavalTarget(target)
                        .addAllSignalLayerSurveys(surveyList)
                        .build();

                ByteArrayOutputStream out = new ByteArrayOutputStream();
                msg.writeDelimitedTo(out);
                publisher.sendMore("Combined");
                publisher.send(out.toByteArray());

                System.out.printf("[CombinedPublisher] Published Target ID: %d with %d signals%n",
                        target.getId(), surveyList.get(0).getFixSignalListList().size());
                System.out.println(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, intervalMillis, TimeUnit.MILLISECONDS);
    }

    // 发布指定次数的消息
    public void startOnce(int publishTimes) {
        for (int i = 0; i < publishTimes; i++) {
            try {
                Aeronaval.Target target = buildRandomTarget();
                List<Detection.SignalLayerSurvey> surveyList = generateSignalList(target);

                TargetOuterClass.CombinedMessage msg = TargetOuterClass.CombinedMessage.newBuilder()
                        .setAeronavalTarget(target)
                        .addAllSignalLayerSurveys(surveyList)
                        .build();

                ByteArrayOutputStream out = new ByteArrayOutputStream();
                msg.writeDelimitedTo(out);
                publisher.sendMore("Combined");
                publisher.send(out.toByteArray());

                System.out.printf("[CombinedPublisher] 第 %d 次发布，Target ID: %d，Signals: %d 条%n",
                        i + 1, target.getId(), surveyList.get(0).getFixSignalListList().size());

                Thread.sleep(intervalMillis); // 控制发布间隔
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stop(); // 所有消息发布完成后关闭资源
    }

    // 资源的清理和关闭
    public void stop() {
        scheduler.shutdownNow();
        publisher.close();
        context.term();
    }

    // 构造装备目标信息
    private Aeronaval.Target buildRandomTarget() {
        Instant now = Instant.now();
        return Aeronaval.Target.newBuilder()
                .setTime(toTimestamp(now))
                .setId(rand.nextInt(3) + 1)
                .setName("T-" + rand.nextInt(3) + 1)
                .setCamp(Aeronaval.Camp.BLUE_CAMP)
                .setEquType(Aeronaval.EquType.AIRCAFT_EUT)
                .setPosition(Dcts.Position.newBuilder()
                        .setLongitude(116.4 + rand.nextDouble() * 1.5)
                        .setLatitude(39.9 + rand.nextDouble() * 1.5)
                        .setAltitude(10000))
                .build();
    }

    // 构造每个测向站检测到的目标信号列表
    private List<Detection.SignalLayerSurvey> generateSignalList(Aeronaval.Target tgt) {
        List<Detection.SignalLayerSurvey> out = new ArrayList<>();
        Instant t0 = Instant.ofEpochSecond(tgt.getTime().getSeconds(), tgt.getTime().getNanos());

        int emitStartSec = (int) (t0.getEpochSecond() - 1);
        int emitEndSec = (int) (t0.getEpochSecond() + 1);

        for (int i = 0; i < STATION_POS.length; i++) {
            Dcts.Position station = STATION_POS[i];
            Detection.SignalLayerSurvey.Builder surveyBuilder = Detection.SignalLayerSurvey.newBuilder()
                    .setTimeStamp(tgt.getTime())
                    .setPosition(station)
                    .setResultFrom(zb.dcts.source.Source.SourceId.newBuilder().setValue(1001 + i));

            for (int j = 0; j < 1; j++) {
                String signalId = UUID.randomUUID().toString();

                // 每个信号频率略偏移：基础频率 + 偏移量
                double freqMHz = 900.0 + rand.nextDouble() * 50 + j * 2.5; // 加点偏移区分信号

                Dcts.DOA doa = computeDOA(tgt.getPosition(), station);

                Detection.SignalDigest fixSignal = Detection.SignalDigest.newBuilder()
                        .setId(signalId)
                        .setActivity(Detection.SignalActivity.ACTIVE)
                        .setCenterFreq(statVal(freqMHz * 1e6))  // MHz → Hz
                        .setBandWidth(statVal(10e6))
                        .setAmplitude(statVal(50 + rand.nextDouble() * 30))
                        .setEmitTimeSpan(Dcts.TimeSpan.newBuilder()
                                .setStartTime(Dcts.Timestamp.newBuilder().setSeconds(emitStartSec))
                                .setStopTime(Dcts.Timestamp.newBuilder().setSeconds(emitEndSec)))
                        .setNumFeatures(10 + rand.nextInt(10))
                        .setDirOfArrival(doa)
                        .setClassification("QPSK")
                        .setDescription("X波段信号-" + (j + 1))
                        .build();

                surveyBuilder.addFixSignalList(fixSignal);
            }

            out.add(surveyBuilder.build());
        }
        return out;
    }

    // 构造时间戳
    private static Dcts.Timestamp toTimestamp(Instant t) {
        return Dcts.Timestamp.newBuilder().setSeconds((int) t.getEpochSecond()).setNanos(t.getNano()).build();
    }

    // 构造统计值
    private static Dcts.StatisticVal statVal(double mean) {
        return Dcts.StatisticVal.newBuilder()
                .setMean(mean)
                .setCur(mean)
                .setUp(mean * 1.05)
                .setDown(mean * 0.95)
                .build();
    }

    // 计算测向站相对于目标的DOA
    private static Dcts.DOA computeDOA(Dcts.Position target, Dcts.Position station) {
        double lat1 = Math.toRadians(station.getLatitude());
        double lon1 = Math.toRadians(station.getLongitude());
        double lat2 = Math.toRadians(target.getLatitude());
        double lon2 = Math.toRadians(target.getLongitude());

        double dLon = lon2 - lon1;
        double y = Math.sin(dLon) * Math.cos(lat2);
        double x = Math.cos(lat1) * Math.sin(lat2)
                - Math.sin(lat1) * Math.cos(lat2) * Math.cos(dLon);

        double azimuth = Math.toDegrees(Math.atan2(y, x));
        return Dcts.DOA.newBuilder().setAzimuth(((azimuth + 360) % 360)).build();
    }

    // 启动CombinePublisher
    public static void main(String[] args) {
        CombinePublisher publisher = new CombinePublisher("tcp://*:5558", 3000);
        publisher.start();

//        try {
//            Thread.sleep(1000); // 等待 subscriber 完成订阅
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        publisher.startOnce(1); // 发布一次即可
    }
}

