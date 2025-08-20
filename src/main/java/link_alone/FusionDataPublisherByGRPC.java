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
import zb.dcts.fusion.airDomain.target.Target;
import zb.dcts.fusion.networkDomain.NetworkDomain;
import zb.dcts.scenario.detection.Detection;
import zb.dcts.source.Source;
import zb.dcts.source.SourceControlServiceGrpc;

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
 * @comment 该类负责从 gRPC 接口订阅总线上的装备目标和频域信号的消息，并按照指定规则进行关联
 * —— 单 channel、多订阅、自动重连、优雅 shutdown
 * @date 2025/7/22
 */
public class FusionDataPublisherByGRPC {
    // 目标缓存：用于暂存近期的目标（按时间滑动窗口）
    private final ConcurrentLinkedQueue<Aeronaval.Target> targetCache = new ConcurrentLinkedQueue<>();
    // 信号缓存：用于暂存近期的信号列表（每条 Survey 来自某个测向站）
    private final ConcurrentLinkedQueue<Detection.SignalLayerSurvey> surveyCache = new ConcurrentLinkedQueue<>();
    //
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);
    private final ExecutorService subscribeExecutor = Executors.newCachedThreadPool();
    private final AtomicBoolean publishStarted = new AtomicBoolean(false);

    private static final long TIME_WINDOW = 1; // 纳秒比较（代码中按需要调整）

    public static final Map<String, String> TYPE_TARGET_MAP;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("LINK4A", "E2D_EUT");
        map.put("LINK11", "CARRIER_EUT");
        map.put("LINK16", "FA18EF_EUT");
        map.put("LINK22", "F35_EUT");
        map.put("JIDS", "J20_EUT");
        map.put("VU", "J16D_EUT");
        map.put("SINCGARS", "KJ500_EUT");
        map.put("HAVE QUICK", "J11_EUT");
        map.put("SW", "VEHICLE_LAND_EUT");
        TYPE_TARGET_MAP = Collections.unmodifiableMap(map);
    }

    Dcts.ThreatLevel[] levels = {
            Dcts.ThreatLevel.LOW,
            Dcts.ThreatLevel.MIDDLE,
            Dcts.ThreatLevel.HIGH
    };

    private final List<utils.EquipmentXmlParser.EquipmentConfig> configs =
            EquipmentXmlParser.parseConfig("equipment.xml");

    private ZMQ.Socket fusionAirPublisher;
    private ZMQ.Socket fusionNetPublisher;

    // single shared channel + stub for all subscriptions
    private ManagedChannel sharedChannel;
    private SourceControlServiceGrpc.SourceControlServiceStub sharedStub;

    // 管理订阅状态与重试
    private static class SubscriptionKey {
        final long sourceId;
        final String topic;

        SubscriptionKey(long sid, String topic) {
            this.sourceId = sid;
            this.topic = topic;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof SubscriptionKey)) return false;
            SubscriptionKey k = (SubscriptionKey) o;
            return sourceId == k.sourceId && Objects.equals(topic, k.topic);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sourceId, topic);
        }

        @Override
        public String toString() {
            return String.format("%d-%s", sourceId, topic);
        }
    }

    // subscriptionStatus: true = active (received messages recently), false = not active / in-retry
    private final Map<SubscriptionKey, Boolean> subscriptionStatus = new ConcurrentHashMap<>();
    // track last failure time to avoid频繁重试
    private final Map<SubscriptionKey, Long> lastFailureTime = new ConcurrentHashMap<>();
    private final long RETRY_DELAY_SEC = 3L;

    public void start() throws InterruptedException {
        // 初始化 ZMQ 发布端（原样保留）
        ZMQ.Context context = ZMQ.context(1);
        fusionAirPublisher = context.socket(SocketType.PUB);
        fusionAirPublisher.bind("tcp://*:5560");
        fusionNetPublisher = context.socket(SocketType.PUB);
        fusionNetPublisher.bind("tcp://*:5561");

        // 初始化共享 gRPC channel + stub（仅一次）
//        sharedChannel = ManagedChannelBuilder.forAddress("localhost", 6161)
        sharedChannel = ManagedChannelBuilder.forAddress("192.168.1.40", 6161)
                .usePlaintext()
                .build();
        sharedStub = SourceControlServiceGrpc.newStub(sharedChannel);

        // 启动订阅（单 channel 多订阅）
        startGrpcSubscriptions();

        // 定期清理缓存（原逻辑）
        scheduler.scheduleAtFixedRate(() -> {
            try {
                cleanExpiredTargets();
                cleanExpiredSurveys();
            } catch (Exception e) {
                System.err.println("[Cleaner] 异常: " + e.getMessage());
            }
        }, 1, 10, TimeUnit.SECONDS);

        System.out.println("[FusionMatcher] Started.");
    }

    /**
     * 查询所有源的状态信息，并对每个 topic 注册订阅（使用 sharedChannel）
     */
    private void startGrpcSubscriptions() throws InterruptedException {
        Source.SourceSetInfo sources = ListAllSourcesClient.listAllSources();
        for (Source.SourceInfo sourceInfo : sources.getSourceInfoList()) {
            int sid = sourceInfo.getSourceId().getValue();
            for (Dcts.Topic topic : sourceInfo.getTopicsList()) {
                String topicStr = topic.getValue();
                if (!topicStr.isEmpty()) {
//                    System.out.println("sourceId: " + String.format("%x", sid) + ", Topic: " + topicStr);
                    SubscriptionKey key = new SubscriptionKey(sid, topicStr);
                    if (!subscriptionStatus.containsKey(key)) {
                        subscriptionStatus.put(key, false);
                        // 使用 scheduler 提交任务以便控制并发和重试
                        scheduler.execute(() -> subscribeGrpcStreamWithRetry(key));
                    }
                }
            }
        }
    }

    /**
     * 使用共享 stub 订阅单个 sourceId/topic，失败后自动重连（延迟重试）
     */
    private void subscribeGrpcStreamWithRetry(SubscriptionKey key) {
        // 防止热循环：若最近失败则延迟
        Long lastFail = lastFailureTime.get(key);
        if (lastFail != null) {
            long since = System.currentTimeMillis() - lastFail;
            if (since < RETRY_DELAY_SEC * 1000L) {
                long wait = RETRY_DELAY_SEC * 1000L - since;
                try {
                    Thread.sleep(wait);
                } catch (InterruptedException ignored) {
                }
            }
        }

        // 构建请求
        Source.SubscribeRequest req = Source.SubscribeRequest.newBuilder()
                .setSourceId(Source.SourceId.newBuilder().setValue((int) key.sourceId))
                .setTopic(Dcts.Topic.newBuilder().setValue(key.topic)).build();

        System.out.printf("[SUBSCRIBE] 启动订阅 %s%n", key);

        // 订阅（sharedStub 是非阻塞的 async stub）
        try {
            sharedStub.subscribeSourceMessage(req, new StreamObserver<Any>() {
                @Override
                public void onNext(Any msg) {
                    // 标记活动
                    subscriptionStatus.put(key, true);

                    // 第一次收到消息时启动 publish 定时任务
                    if (publishStarted.compareAndSet(false, true)) {
                        scheduler.scheduleAtFixedRate(() -> {
                            try {
                                publishNetFusion();
                            } catch (Exception e) {
                                System.err.println("[NetDomain 发布异常] " + e.getMessage());
                            }
                        }, 1, 1, TimeUnit.SECONDS);
                    }

                    // 处理消息（unpack）
                    try {
                        if (msg.is(Aeronaval.Target.class)) {
                            Aeronaval.Target tgt = msg.unpack(Aeronaval.Target.class);
                            targetCache.add(tgt);
                            processAirFusion(tgt);
                        } else if (msg.is(Detection.SignalLayerSurvey.class)) {
                            Detection.SignalLayerSurvey survey = msg.unpack(Detection.SignalLayerSurvey.class);
//                            System.out.println("survey:" + survey);
                            surveyCache.add(survey);
                        } else if (msg.is(Target.FusionTarget.class)) {
                            // 如果也可能收到 FusionTarget，可按需处理
                            // Target.FusionTarget fusion = msg.unpack(Target.FusionTarget.class);
                        }
                    } catch (InvalidProtocolBufferException e) {
                        System.err.printf("消息解包失败 (%s): %s%n", key, e.getMessage());
                    } catch (Throwable t) {
                        System.err.printf("消息处理异常 (%s): %s%n", key, t.getMessage());
                    }
                }

                @Override
                public void onError(Throwable t) {
                    System.err.printf("订阅异常 %s: %s%n", key, t.getMessage());
                    subscriptionStatus.put(key, false);
                    lastFailureTime.put(key, System.currentTimeMillis());
                    // 延迟重试
                    scheduler.schedule(() -> subscribeGrpcStreamWithRetry(key), RETRY_DELAY_SEC, TimeUnit.SECONDS);
                }

                @Override
                public void onCompleted() {
                    System.out.printf("订阅完成 %s%n", key);
                    subscriptionStatus.put(key, false);
                    // 完成后重连
                    scheduler.schedule(() -> subscribeGrpcStreamWithRetry(key), RETRY_DELAY_SEC, TimeUnit.SECONDS);
                }
            });
        } catch (Throwable e) {
            System.err.printf("订阅启动失败 %s: %s%n", key, e.getMessage());
            subscriptionStatus.put(key, false);
            lastFailureTime.put(key, System.currentTimeMillis());
            scheduler.schedule(() -> subscribeGrpcStreamWithRetry(key), RETRY_DELAY_SEC, TimeUnit.SECONDS);
        }
    }

    private void publishNetFusion() throws Exception {
        NetworkDomain.NetworkList netList = NetworkDomainBuilder.buildFromXml("网络配置.xml");
        byte[] payload = netList.toByteArray();

        fusionNetPublisher.sendMore("Fusion_NetDomain");
        fusionNetPublisher.send(payload);
    }

//    private void processAirFusion(Aeronaval.Target tgt) throws Exception {
//        Instant tgtTime = Instant.ofEpochSecond(tgt.getTime().getSeconds(), tgt.getTime().getNanos());
//
//        List<Detection.SignalLayerSurvey> validSurveys = surveyCache.stream()
//                .filter(s -> {
//                    Instant stopTime = Instant.ofEpochSecond(
//                            s.getFixSignalList(0).getEmitTimeSpan().getStopTime().getSeconds(),
//                            s.getFixSignalList(0).getEmitTimeSpan().getStopTime().getNanos()
//                    );
//                    long diffNanos = Math.abs(Duration.between(tgtTime, stopTime).toNanos());
//                    return diffNanos <= TIME_WINDOW;  // 转为纳秒比较
//                })
//                .collect(Collectors.toList());
//        Map<Integer, Detection.SignalLayerSurvey> uniqueStations = new HashMap<>();
//
//        for (Detection.SignalLayerSurvey s : validSurveys) {
//            int stationId = s.getResultFrom().getValue();
//            if (!uniqueStations.containsKey(stationId)) {
//                uniqueStations.put(stationId, s);
//            }
//            if (uniqueStations.size() >= 2) break;
//        }
//
//
//        if (uniqueStations.size() < 2) return;
//
//        List<Detection.SignalLayerSurvey> selected = new ArrayList<>(uniqueStations.values());
//
//        double doa1 = selected.get(0).getFixSignalList(0).getDirOfArrival().getAzimuth();
//        double doa2 = selected.get(1).getFixSignalList(0).getDirOfArrival().getAzimuth();
//        Dcts.Position p1 = selected.get(0).getPosition();
//        Dcts.Position p2 = selected.get(1).getPosition();
//
////        Dcts.Position p1 = Dcts.Position.newBuilder().setLongitude(116.3).setLatitude(39.8).setAltitude(50).build();
////        Dcts.Position p2 = Dcts.Position.newBuilder().setLongitude(116.5).setLatitude(40.0).setAltitude(60).build();
//
////        System.out.println("doa1: " + doa1 + ", doa2: " + doa2);
////        System.out.println("p1: " + p1.getLatitude() + ", " + p1.getLongitude());
////        System.out.println("p2: " + p2.getLatitude() + ", " + p2.getLongitude());
//
//
//        LatLon est = estimateFromDOA(p1, doa1, p2, doa2);
////        System.out.println("Estimated position: " + est.lat + ", " + est.lon);
//        BigDecimal errKm = haversine(tgt.getPosition().getLatitude(), tgt.getPosition().getLongitude(), est.lat, est.lon);
//        System.out.println("tgt position: " + tgt.getPosition().getLatitude() + ", " + tgt.getPosition().getLongitude());
//        System.out.printf("Estimated position error: %.20f km%n", errKm);
//        BigDecimal tolerance = new BigDecimal("0.001");
//        if (errKm.abs().compareTo(tolerance) < 0) { //定位误差小于1m
//            Target.FusionTarget.Builder builder = Target.FusionTarget.newBuilder()
//                    .setAeronavalTarget(tgt)
//                    .addAllSignalLayerSurveys(selected);
//            if (tgt.getCampValue() == 1) {
//                // 清空已有的LinkEquipments
//                builder.setReliability(ThreadLocalRandom.current().nextInt(5) + 1)
//                        .setImportance(ThreadLocalRandom.current().nextInt(5) + 1) // 随机重要性 1-5
//                        .setPurpose("RED CAMP");
//
//                Set<String> types = collectEquipmentTypes(selected);
//                configs.stream()
//                        .filter(cfg -> types.contains(cfg.type.toUpperCase()))
//                        .forEach(cfg -> {
//                            if (isLink(cfg.type)) {
//                                builder.addLinkEquipments(EquipmentMapper.toLinkEquipment(cfg));
//                            } else {
//                                builder.addStationEquipments(EquipmentMapper.toStationEquipment(cfg));
//                            }
//                        });
//            } else if (tgt.getCampValue() == 2) {
//                builder.setReliability(ThreadLocalRandom.current().nextInt(5) + 1)
//                        .setThrtLvl(levels[ThreadLocalRandom.current().nextInt(levels.length)])
//                        .setPurpose("BLUE CAMP");
//
//                Set<String> types = collectEquipmentTypes(selected);
//                configs.stream()
//                        .filter(cfg -> types.contains(cfg.type.toUpperCase()))
//                        .forEach(cfg -> {
//                            if (isLink(cfg.type)) {
//                                builder.addLinkEquipments(EquipmentMapper.toLinkEquipment(cfg));
//                            } else {
//                                builder.addStationEquipments(EquipmentMapper.toStationEquipment(cfg));
//                            }
//                        });
//            }
//
//            fusionAirPublisher.sendMore("Fusion_AirDomain");
//            fusionAirPublisher.send(builder.build().toByteArray());
//        }
//    }

    private void processAirFusion(Aeronaval.Target tgt) throws Exception {
        Instant tgtTime = Instant.ofEpochSecond(tgt.getTime().getSeconds(), tgt.getTime().getNanos());

        // 筛选时间窗口内的信号
        List<Detection.SignalLayerSurvey> timeMatchedSurveys = surveyCache.stream()
                .filter(s -> {
                    Any sig = getFirstAvailableSignal(s);
                    if (sig == null) return false;
                    String typeUrl = sig.getTypeUrl();
                    if (typeUrl.endsWith("SignalDigest")) {
                        try {
                            Detection.SignalDigest signalDigest = sig.unpack(Detection.SignalDigest.class);
                            Instant stopTime = Instant.ofEpochSecond(
                                    signalDigest.getEmitTimeSpan().getStopTime().getSeconds(),
                                    signalDigest.getEmitTimeSpan().getStopTime().getNanos()
                            );
                            long diffNanos = Math.abs(Duration.between(tgtTime, stopTime).toNanos());
                            return diffNanos <= TIME_WINDOW;
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    } else if (typeUrl.endsWith("HopSignalCluster")) {
                        try {
                            Detection.HopSignalCluster hopSignalCluster = sig.unpack(Detection.HopSignalCluster.class);
                            Instant stopTime = Instant.ofEpochSecond(
                                    hopSignalCluster.getEmitTimeSpan().getStopTime().getSeconds(),
                                    hopSignalCluster.getEmitTimeSpan().getStopTime().getNanos()
                            );
                            long diffNanos = Math.abs(Duration.between(tgtTime, stopTime).toNanos());
                            return diffNanos <= TIME_WINDOW;
                        } catch (InvalidProtocolBufferException e) {
                            e.printStackTrace();
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());

        // 分类：定频 vs 跳频
        List<Detection.SignalLayerSurvey> fixFreqSurveys = timeMatchedSurveys.stream()
                .filter(s -> s.getFixSignalListCount() > 0)
                .collect(Collectors.toList());

        List<Detection.SignalLayerSurvey> hopFreqSurveys = timeMatchedSurveys.stream()
                .filter(s -> s.getHopSignalListCount() > 0 && s.getFixSignalListCount() == 0) // 纯跳频
                .collect(Collectors.toList());

        // --- 定频信号处理（双站定位） ---
        if (fixFreqSurveys.size() >= 2) {
            Map<Integer, Detection.SignalLayerSurvey> uniqueStations = new HashMap<>();
            for (Detection.SignalLayerSurvey s : fixFreqSurveys) {
                int stationId = s.getResultFrom().getValue();
                if (!uniqueStations.containsKey(stationId)) {
                    uniqueStations.put(stationId, s);
                }
                if (uniqueStations.size() >= 2) break;
            }

            if (uniqueStations.size() >= 2) {
                List<Detection.SignalLayerSurvey> selected = new ArrayList<>(uniqueStations.values());
                Detection.SignalDigest sig1 = selected.get(0).getFixSignalList(0);
                Detection.SignalDigest sig2 = selected.get(1).getFixSignalList(0);

                double doa1 = sig1.getDirOfArrival().getAzimuth();
                double doa2 = sig2.getDirOfArrival().getAzimuth();
                Dcts.Position p1 = selected.get(0).getPosition();
                Dcts.Position p2 = selected.get(1).getPosition();

                LatLon est = estimateFromDOA(p1, doa1, p2, doa2);

                BigDecimal errKm = haversine(tgt.getPosition().getLatitude(), tgt.getPosition().getLongitude(), est.lat, est.lon);

                System.out.println("tgt position: " + tgt.getPosition().getLatitude() + ", " + tgt.getPosition().getLongitude());
                System.out.printf("Estimated position error: %.20f km%n", errKm);

                BigDecimal tolerance = new BigDecimal("0.001"); // 1米
                if (errKm.abs().compareTo(tolerance) < 0) {
                    bindTargetWithSurveys(tgt, selected);
                }
            }
        }

        // --- 跳频信号处理（仅时间匹配） ---
        if (!hopFreqSurveys.isEmpty()) {
            bindTargetWithSurveys(tgt, hopFreqSurveys);
        }
    }

    /**
     * 绑定信号与目标并发布
     */
    private void bindTargetWithSurveys(Aeronaval.Target tgt, List<Detection.SignalLayerSurvey> surveys) {
        Target.FusionTarget.Builder builder = Target.FusionTarget.newBuilder()
                .setAeronavalTarget(tgt)
                .addAllSignalLayerSurveys(surveys);

        if (tgt.getCampValue() == 1) {
            builder.setReliability(ThreadLocalRandom.current().nextInt(5) + 1)
                    .setImportance(ThreadLocalRandom.current().nextInt(5) + 1)
                    .setPurpose("RED CAMP");
        } else if (tgt.getCampValue() == 2) {
            builder.setReliability(ThreadLocalRandom.current().nextInt(5) + 1)
                    .setThrtLvl(levels[ThreadLocalRandom.current().nextInt(levels.length)])
                    .setPurpose("BLUE CAMP");
        }

        Set<String> types = collectEquipmentTypes(surveys);
        configs.stream()
                .filter(cfg -> types.contains(cfg.type.toUpperCase()))
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

    /**
     * 获取第一个可用信号
     */
    private Any getFirstAvailableSignal(Detection.SignalLayerSurvey survey) {
        if (survey.getFixSignalListCount() > 0) {
//            System.out.println("有定频！");
            Detection.SignalDigest fixSignalList = survey.getFixSignalList(0);
            return Any.pack(fixSignalList);
        } else if (survey.getHopSignalListCount() > 0) {
//            System.out.println("有跳频！");
            Detection.HopSignalCluster hopSignalList = survey.getHopSignalList(0);
            return Any.pack(hopSignalList);
        }
        return null;
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

    /**
     * 优雅关闭：停止 scheduler、关闭订阅线程池、关闭 sharedChannel 并等待终止
     */
    public void shutdown() {
        System.out.println("[Shutdown] 开始关闭 FusionDataPublisherByGRPC ...");

        // 停止接受新的订阅任务
        try {
            scheduler.shutdownNow();
        } catch (Throwable ignored) {
        }

        try {
            subscribeExecutor.shutdownNow();
        } catch (Throwable ignored) {
        }

        // 清理 ZMQ sockets
        try {
            if (fusionAirPublisher != null) fusionAirPublisher.close();
            if (fusionNetPublisher != null) fusionNetPublisher.close();
        } catch (Throwable ignored) {
        }

        // 关闭 gRPC channel（优雅等待）
        if (sharedChannel != null) {
            try {
                sharedChannel.shutdown();
                if (!sharedChannel.awaitTermination(5, TimeUnit.SECONDS)) {
                    sharedChannel.shutdownNow();
                }
                System.out.println("[Shutdown] sharedChannel 已关闭");
            } catch (InterruptedException e) {
                System.err.println("[Shutdown] channel 关闭被中断");
                Thread.currentThread().interrupt();
            } catch (Throwable e) {
                System.err.println("[Shutdown] channel 关闭异常: " + e.getMessage());
            }
        }

        System.out.println("[Shutdown] 完成");
    }
}



