package mock_data;

import org.zeromq.ZMQ;
import zb.dcts.Dcts;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
import zb.dcts.scenario.detection.Detection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;

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

    public CombinePublisher(String bindAddr, int intervalMillis) {
        this.context = ZMQ.context(1);
        this.publisher = context.socket(ZMQ.PUB);
        this.publisher.bind(bindAddr);
        this.intervalMillis = intervalMillis;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void start() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                Aeronaval.Target target = buildRandomTarget();
                List<Detection.SignalLayerSurvey> signalList = generateSignalList(target);

                TargetOuterClass.CombinedMessage msg = TargetOuterClass.CombinedMessage.newBuilder()
                        .setAeronavalTarget(target)
                        .addAllSignalLayerSurveys(signalList)
                        .build();

                ByteArrayOutputStream out = new ByteArrayOutputStream();
                msg.writeDelimitedTo(out);
                publisher.sendMore("Combined");
                publisher.send(out.toByteArray());

                System.out.printf("[CombinedPublisher] Published Target ID: %d with %d signals%n",
                        target.getId(), signalList.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, intervalMillis, TimeUnit.MILLISECONDS);
    }

    public void stop() {
        scheduler.shutdownNow();
        publisher.close();
        context.term();
    }

    private Aeronaval.Target buildRandomTarget() {
        Instant now = Instant.now();
        return Aeronaval.Target.newBuilder()
                .setTime(toTimestamp(now))
                .setId(rand.nextInt(3) + 1)
                .setName("T-" + rand.nextInt(3) + 1)
                .setCamp(Aeronaval.Camp.BLUE_CAMP)
                .setEquType(Aeronaval.EquType.AIRCAFT_EUT)
                .setPosition(Dcts.Position.newBuilder()
                        .setLongitude(116.4 + rand.nextDouble() * 2)
                        .setLatitude(39.9 + rand.nextDouble() * 2)
                        .setAltitude(10000))
                .build();
    }

    private List<Detection.SignalLayerSurvey> generateSignalList(Aeronaval.Target tgt) {
        List<Detection.SignalLayerSurvey> out = new ArrayList<>();
        Instant t0 = Instant.ofEpochSecond(tgt.getTime().getSeconds(), tgt.getTime().getNanos());
        double freqMHz = 900.0 + rand.nextDouble() * 50;


        int emitStartSec = (int) (t0.getEpochSecond() - 1);
        int emitEndSec = (int) (t0.getEpochSecond() + 1);

        for (int i = 0; i < STATION_POS.length; i++) {
            Dcts.Position station = STATION_POS[i];
            Detection.SignalLayerSurvey.Builder surveyBuilder = Detection.SignalLayerSurvey.newBuilder()
                    .setTimeStamp(tgt.getTime())
                    .setPosition(station)
                    .setResultFrom(zb.dcts.source.Source.SourceId.newBuilder().setValue(1001 + i));

            for (int j = 0; j < 2; j++) {  // 每个 station 添加 2 条 signal
                String signalId = UUID.randomUUID().toString();
                Dcts.DOA doa = computeDOA(tgt.getPosition(), station);

                Detection.SignalDigest fixSignal = Detection.SignalDigest.newBuilder()
                        .setId(signalId)
                        .setActivity(Detection.SignalActivity.ACTIVE)
                        .setCenterFreq(statVal(freqMHz * 1e6))
                        .setBandWidth(statVal(10e6))
                        .setAmplitude(statVal(50 + Math.random() * 30))
                        .setEmitTimeSpan(Dcts.TimeSpan.newBuilder()
                                .setStartTime(Dcts.Timestamp.newBuilder().setSeconds(emitStartSec).setNanos(0))
                                .setStopTime(Dcts.Timestamp.newBuilder().setSeconds(emitEndSec).setNanos(0)))
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


    private static Dcts.Timestamp toTimestamp(Instant t) {
        return Dcts.Timestamp.newBuilder().setSeconds((int) t.getEpochSecond()).setNanos(t.getNano()).build();
    }

    private static Dcts.StatisticVal statVal(double mean) {
        return Dcts.StatisticVal.newBuilder()
                .setMean(mean)
                .setCur(mean)
                .setUp(mean * 1.05)
                .setDown(mean * 0.95)
                .build();
    }

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
        return Dcts.DOA.newBuilder().setAzimuth((int) ((azimuth + 360) % 360)).build();
    }

    public static void main(String[] args) {
        CombinePublisher publisher = new CombinePublisher("tcp://*:5558", 3000);
        publisher.start();
    }
}

