package link_alone;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import source_control.real_client.ListAllSourcesClient;
import utils.EquipmentMapper;
import utils.EquipmentXmlParser;
import utils.NetworkDomainBuilder;
import zb.dcts.Dcts;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
import zb.dcts.fusion.networkDomain.NetworkDomain;
import zb.dcts.scenario.detection.Detection;
import zb.dcts.source.Source;
import zb.dcts.source.SourceControlServiceGrpc;

import java.io.File;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * @author 林跃
 * @file FusionDataPublisherByGRPC.java
 * @comment 该类负责从gRPC接口订阅总线上的装备目标和频域信号的消息，并按照指定规则进行关联
 * @date 2025/7/22
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class FusionDataPublisherByGRPC {
    // 目标缓存：用于暂存近期的目标（按时间滑动窗口）
    private final ConcurrentLinkedQueue<Aeronaval.Target> targetCache = new ConcurrentLinkedQueue<>();
    // 信号缓存：用于暂存近期的信号列表（每条 Survey 来自某个测向站）
    private final ConcurrentLinkedQueue<Detection.SignalLayerSurvey> surveyCache = new ConcurrentLinkedQueue<>();
    //
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    AtomicBoolean publishStarted = new AtomicBoolean(false);

    private static final long TIME_WINDOW = 1;

    Dcts.ThreatLevel[] levels = {
            Dcts.ThreatLevel.LOW,
            Dcts.ThreatLevel.MIDDLE,
            Dcts.ThreatLevel.HIGH
    };


    private final List<EquipmentXmlParser.EquipmentConfig> configs =
            EquipmentXmlParser.parseConfig(new File("src/main/resources/equipment.xml"));

    private ZMQ.Socket fusionAirPublisher;
    private ZMQ.Socket fusionNetPublisher;

    public void start() throws InterruptedException {
        ZMQ.Context context = ZMQ.context(1);
        fusionAirPublisher = context.socket(SocketType.PUB);
        fusionAirPublisher.bind("tcp://*:5560");
        fusionNetPublisher = context.socket(SocketType.PUB);
        fusionNetPublisher.bind("tcp://*:5561");

        startGrpcSubscriptions();

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            cleanExpiredTargets();
            cleanExpiredSurveys();
        }, 1, 10, TimeUnit.SECONDS);

        System.out.println("[FusionMatcher] Started.");
    }

    /**
     * 查询所有源的状态信息
     *
     * @throws InterruptedException
     */
    private void startGrpcSubscriptions() throws InterruptedException {
        Source.SourceSetInfo sources = ListAllSourcesClient.listAllSources();
        for (Source.SourceInfo sourceInfo : sources.getSourceInfoList()) {
            int sid = sourceInfo.getSourceId().getValue();
            for (Dcts.Topic topic : sourceInfo.getTopicsList()) {
                String topicStr = topic.getValue();
                if (!topicStr.isEmpty()) {
                    System.out.println("sourceId: " + String.format("%x", sid) + ", Topic: " + topicStr);
                    subscribeGrpcStream(sid, topicStr);
                }
            }
        }
    }

    /**
     * 根据源的id和主题字符串订阅源发布的消息
     *
     * @param sourceId
     * @param topicStr
     */
    private void subscribeGrpcStream(long sourceId, String topicStr) {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.1.21", 6161).usePlaintext().build();
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6161).usePlaintext().build();
        SourceControlServiceGrpc.SourceControlServiceStub stub = SourceControlServiceGrpc.newStub(channel);

        Source.SubscribeRequest req = Source.SubscribeRequest.newBuilder()
                .setSourceId(Source.SourceId.newBuilder().setValue((int) sourceId))
                .setTopic(Dcts.Topic.newBuilder().setValue(topicStr)).build();

        stub.subscribeSourceMessage(req, new StreamObserver<Any>() {
            @Override
            public void onNext(Any msg) {
                // 只在第一次消息触发调度
                if (publishStarted.compareAndSet(false, true)) {
                    scheduler.scheduleAtFixedRate(() -> {
                        try {
                            publishNetFusion(); // 定时发布
                        } catch (Exception e) {
                            System.err.println("[NetDomain 发布异常] " + e.getMessage());
                        }
                    }, 1, 1, TimeUnit.SECONDS); // 每 1 秒一次
                }

                try {
                    if (msg.is(Aeronaval.Target.class)) {
                        Aeronaval.Target tgt = msg.unpack(Aeronaval.Target.class);
//                        System.out.println(tgt);
                        targetCache.add(tgt);
                        processAirFusion(tgt);
                    } else if (msg.is(Detection.SignalLayerSurvey.class)) {
                        Detection.SignalLayerSurvey survey = msg.unpack(Detection.SignalLayerSurvey.class);
//                        System.out.println(survey.getResultFrom());
                        surveyCache.add(survey);
                    }
                } catch (InvalidProtocolBufferException e) {
                    System.err.printf("消息解包失败: %s%n", e.getMessage());
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.printf("订阅异常 [%d-%s]: %s%n", sourceId, topicStr, t.getMessage());
                channel.shutdown();
            }

            @Override
            public void onCompleted() {
                System.out.printf("订阅完成 [%d-%s]%n", sourceId, topicStr);
                channel.shutdown();
            }
        });
    }

    private void publishNetFusion() throws Exception {
        NetworkDomain.NetworkList netList = NetworkDomainBuilder.buildFromXml("src/main/resources/网络配置.xml");
        byte[] payload = netList.toByteArray();

        fusionNetPublisher.sendMore("Fusion_NetDomain");
        fusionNetPublisher.send(payload);
    }

    private void processAirFusion(Aeronaval.Target tgt) {
        Instant tgtTime = Instant.ofEpochSecond(tgt.getTime().getSeconds(), tgt.getTime().getNanos());
//        System.out.println(tgtTime);

//        List<Detection.SignalLayerSurvey> validSurveys = surveyCache.stream()
//                .filter(s -> Math.abs(Duration.between(tgtTime,
//                        Instant.ofEpochSecond(s.getFixSignalList(0).getEmitTimeSpan().getStopTime().getSeconds(), s.getFixSignalList(0).getEmitTimeSpan().getStopTime().getNanos())).getSeconds()) <= TIME_WINDOW)
//                .collect(Collectors.toList());
        List<Detection.SignalLayerSurvey> validSurveys = surveyCache.stream()
                .filter(s -> {
                    Instant stopTime = Instant.ofEpochSecond(
                            s.getFixSignalList(0).getEmitTimeSpan().getStopTime().getSeconds(),
                            s.getFixSignalList(0).getEmitTimeSpan().getStopTime().getNanos()
                    );
                    long diffNanos = Math.abs(Duration.between(tgtTime, stopTime).toNanos());
                    return diffNanos <= TIME_WINDOW;  // 转为纳秒比较
                })
                .collect(Collectors.toList());
//        System.out.println(validSurveys.size() + " valid surveys found for target at " + tgtTime);
        Map<Integer, Detection.SignalLayerSurvey> uniqueStations = new HashMap<>();
//        System.out.println("signal.size():" + validSurveys.get(0).getFixSignalListList().size())

        for (Detection.SignalLayerSurvey s : validSurveys) {
            int stationId = s.getResultFrom().getValue();
//            uniqueStations.putIfAbsent(stationId, s);
//            System.out.println(uniqueStations.size());
            if (!uniqueStations.containsKey(stationId)) {
                uniqueStations.put(stationId, s);
            }
            if (uniqueStations.size() >= 2) break;
        }

//        System.out.println("uniqueStations:" + uniqueStations.size());

        if (uniqueStations.size() < 2) return;

        List<Detection.SignalLayerSurvey> selected = new ArrayList<>(uniqueStations.values());
//        for (Detection.SignalDigest signalDigest : selected.get(0).getFixSignalListList()) {
//            System.out.println("信号编号：" + signalDigest.getId());
//            System.out.println("信号DOA：" + signalDigest.getDirOfArrival());
//        }
        double doa1 = selected.get(0).getFixSignalList(0).getDirOfArrival().getAzimuth();
        double doa2 = selected.get(1).getFixSignalList(0).getDirOfArrival().getAzimuth();
        Dcts.Position p1 = selected.get(0).getPosition();
        Dcts.Position p2 = selected.get(1).getPosition();

//        Dcts.Position p1 = Dcts.Position.newBuilder().setLongitude(116.3).setLatitude(39.8).setAltitude(50).build();
//        Dcts.Position p2 = Dcts.Position.newBuilder().setLongitude(116.5).setLatitude(40.0).setAltitude(60).build();

//        System.out.println("doa1: " + doa1 + ", doa2: " + doa2);
//        System.out.println("p1: " + p1.getLatitude() + ", " + p1.getLongitude());
//        System.out.println("p2: " + p2.getLatitude() + ", " + p2.getLongitude());


        LatLon est = estimateFromDOA(p1, doa1, p2, doa2);
//        System.out.println("Estimated position: " + est.lat + ", " + est.lon);
        BigDecimal errKm = haversine(tgt.getPosition().getLatitude(), tgt.getPosition().getLongitude(), est.lat, est.lon);
//        System.out.println("tgt position: " + tgt.getPosition().getLatitude() + ", " + tgt.getPosition().getLongitude());
//        System.out.printf("Estimated position error: %.20f km%n", errKm);
        BigDecimal tolerance = new BigDecimal("0.001"); // 1 微米
        if (errKm.abs().compareTo(tolerance) < 0) { //定位误差小于1m
            TargetOuterClass.FusionTargetList.Builder builder = TargetOuterClass.FusionTargetList.newBuilder()
                    .setAeronavalTarget(tgt)
                    .addAllSignalLayerSurveys(selected);
            if (tgt.getCampValue() == 1) {
                builder.setReliability(ThreadLocalRandom.current().nextInt(5) + 1)
                        .setImportance(ThreadLocalRandom.current().nextInt(5) + 1) // 随机重要性 1-5
                        .setPurpose("RED CAMP");
            } else if (tgt.getCampValue() == 2){
                builder.setReliability(ThreadLocalRandom.current().nextInt(5) + 1)
                        .setThrtLvl(levels[ThreadLocalRandom.current().nextInt(levels.length)])
                        .setPurpose("BLUE CAMP");
            }
            Set<String> types = collectEquipmentTypes(selected);
            configs.stream().filter(cfg -> types.contains(cfg.type.toUpperCase()))
                    .forEach(cfg -> {
                        if (isLink(cfg.type)) {
                            builder.addLinkEquipments(EquipmentMapper.toLinkEquipment(cfg));
                        } else {
                            builder.addStationEquipments(EquipmentMapper.toStationEquipment(cfg));
                        }
                    });

            fusionAirPublisher.sendMore("Fusion_AirDomain");
            fusionAirPublisher.send(builder.build().toByteArray());
        }
    }

    private static Set<String> collectEquipmentTypes(List<Detection.SignalLayerSurvey> surveys) {
        Set<String> types = new HashSet<>();
        for (Detection.SignalLayerSurvey s : surveys) {
            for (Detection.SignalDigest f : s.getFixSignalListList()) extractType(f.getDescription(), types);
            for (Detection.HopSignalCluster h : s.getHopSignalListList()) extractType(h.getName(), types);
        }
        return types;
    }

    private static void extractType(String desc, Set<String> types) {
        if (desc != null) {
            String key = desc.trim().split("[\\s/\\-]+")[0].toUpperCase();
            types.add(key);
        }
    }

    private void cleanExpiredTargets() {
        Instant now = Instant.now();
        targetCache.removeIf(tgt -> Duration.between(Instant.ofEpochSecond(
                tgt.getTime().getSeconds(), tgt.getTime().getNanos()), now).getSeconds() > TIME_WINDOW);
    }

    private void cleanExpiredSurveys() {
        Instant now = Instant.now();
        surveyCache.removeIf(s -> Duration.between(Instant.ofEpochSecond(
                s.getTimeStamp().getSeconds(), s.getTimeStamp().getNanos()), now).getSeconds() > TIME_WINDOW);
    }

    private static BigDecimal haversine(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371.0;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        return new BigDecimal(2 * R * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
    }

    private static LatLon estimateFromDOA(Dcts.Position p1, double doa1, Dcts.Position p2, double doa2) {
        double theta1 = Math.toRadians(doa1), theta2 = Math.toRadians(doa2);
        double x1 = p1.getLongitude(), y1 = p1.getLatitude();
        double x2 = p2.getLongitude(), y2 = p2.getLatitude();
        double dx1 = Math.sin(theta1), dy1 = Math.cos(theta1);
        double dx2 = Math.sin(theta2), dy2 = Math.cos(theta2);
        double denom = dx1 * dy2 - dy1 * dx2;
        if (Math.abs(denom) < 1e-6) return new LatLon((y1 + y2) / 2, (x1 + x2) / 2);
        double t1 = ((x2 - x1) * dy2 - (y2 - y1) * dx2) / denom;
        return new LatLon(y1 + t1 * dy1, x1 + t1 * dx1);
    }

    private static boolean isLink(String type) {
        return type.startsWith("LINK") || type.equals("JIDS") || type.equals("VU");
    }

    static class LatLon {
        double lat, lon;

        LatLon(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }
    }
}
