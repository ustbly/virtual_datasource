package link_alone;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import zb.dcts.Dcts;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
import zb.dcts.scenario.detection.Detection;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @file FusionMatcher.java
 * @comment 该类负责从 ZeroMQ 总线接收装备目标和频域信号的消息，并按照指定规则进行关联
 * @date 2025/7/4
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class FusionMatcher {
    // 目标缓存：用于暂存近期的目标（按时间滑动窗口）
    private final ConcurrentLinkedQueue<Aeronaval.Target> targetCache = new ConcurrentLinkedQueue<>();
    // 信号缓存：用于暂存近期的信号列表（每条 Survey 来自某个测向站）
    private final ConcurrentLinkedQueue<Detection.SignalLayerSurvey> surveyCache = new ConcurrentLinkedQueue<>();

    private static final long TIME_WINDOW_SEC = 3;                      // 时间滑动窗口（秒）
    private static final String ZMQ_SUB_ADDR = "tcp://localhost:5556";  // ZMQ 订阅地址
    private static final String ZMQ_PUB_ADDR = "tcp://*:5560";          // ZMQ 发布地址

    // ZMQ组件 & 状态控制
    private ZMQ.Context context;
    private ZMQ.Socket subscriber;
    private ZMQ.Socket fusionPublisher;
    private ExecutorService matcherExecutor;

    private volatile boolean running = false;

    // 启动 FusionMatcher，连接 ZMQ、启动线程监听数据并执行匹配
    public void start() {
        context = ZMQ.context(1);
        subscriber = context.socket(SocketType.SUB);
        subscriber.connect(ZMQ_SUB_ADDR);
        subscriber.subscribe("Target".getBytes());
        subscriber.subscribe("SignalLayerSurvey".getBytes());

        fusionPublisher = context.socket(SocketType.PUB);
        fusionPublisher.bind(ZMQ_PUB_ADDR);

        matcherExecutor = Executors.newSingleThreadExecutor();
        running = true;

        matcherExecutor.submit(this::listenAndProcess);
        System.out.println("[FusionMatcher] Started.");
    }

    // 停止组件：关闭线程池与 ZMQ
    public void stop() {
        running = false;
        if (matcherExecutor != null) matcherExecutor.shutdownNow();
        if (subscriber != null) subscriber.close();
        if (fusionPublisher != null) fusionPublisher.close();
        if (context != null) context.term();
        System.out.println("[FusionMatcher] Stopped.");
    }

    // 核心处理线程：监听 ZMQ 数据，并按主题进行解码与处理
    private void listenAndProcess() {
        while (running && !Thread.currentThread().isInterrupted()) {
            String topic = subscriber.recvStr();    // 主题名
            byte[] payload = subscriber.recv();     // 内容
            ByteArrayInputStream in = new ByteArrayInputStream(payload);

            try {
                switch (topic) {
                    case "Target":
                        Aeronaval.Target tgt = Aeronaval.Target.parseDelimitedFrom(in);
                        if (tgt != null) {
                            targetCache.add(tgt);
                            cleanExpiredTargets();  // 清除过期目标
                            processFusion(tgt);     // 针对该目标尝试做匹配
                        }
                        break;
                    case "SignalLayerSurvey":
                        Detection.SignalLayerSurvey survey = Detection.SignalLayerSurvey.parseDelimitedFrom(in);
                        if (survey != null) {
                            surveyCache.add(survey);
                            cleanExpiredSurveys();  // 清除过期信号
                        }
                        break;
                    default:
                        System.out.println("[FusionMatcher] Unknown topic: " + topic);
                }
            } catch (Exception e) {
                System.err.println("[FusionMatcher] Exception: " + e.getMessage());
            }
        }
    }

    // 匹配逻辑：对当前输入目标，尝试从 survey 中找出两个不同测向站的数据进行 DOA 交叉定位
    private void processFusion(Aeronaval.Target tgt) {
        Instant tgtTime = Instant.ofEpochSecond(tgt.getTime().getSeconds(), tgt.getTime().getNanos());

        // 1. 找出时间上接近该目标的 Survey（滑动窗口内）
        List<Detection.SignalLayerSurvey> validSurveys = new ArrayList<>();
        for (Detection.SignalLayerSurvey s : surveyCache) {
            Instant ts = Instant.ofEpochSecond(s.getTimeStamp().getSeconds(), s.getTimeStamp().getNanos());
            if (Math.abs(Duration.between(tgtTime, ts).getSeconds()) <= TIME_WINDOW_SEC) {
                validSurveys.add(s);
            }
        }

        // 2. 筛选出来自两个不同测向站的 Survey
        Map<Integer, Detection.SignalLayerSurvey> stationSurveyMap = new HashMap<>();
        for (Detection.SignalLayerSurvey s : validSurveys) {
            int sid = s.getResultFrom().getValue();     // 测向站 ID
            if (!stationSurveyMap.containsKey(sid)) {
                stationSurveyMap.put(sid, s);
            }
            if (stationSurveyMap.size() >= 2) break;
        }

        // 不足两个测向站，跳过处理
        if (stationSurveyMap.size() < 2) return;

        // 3. 从两个测向站中提取位置与 DOA
        List<Detection.SignalLayerSurvey> selected = new ArrayList<>(stationSurveyMap.values());
        Dcts.Position pos1 = selected.get(0).getPosition();
        Dcts.Position pos2 = selected.get(1).getPosition();
//        System.out.println("pos1: " + pos1 + ",pos2: " + pos2);

        double doa1 = selected.get(0).getFixSignalList(0).getDirOfArrival().getAzimuth();
        double doa2 = selected.get(1).getFixSignalList(0).getDirOfArrival().getAzimuth();
//        System.out.println("doa1: " + doa1 + ",doa2: " + doa2);

        // 4. 执行 DOA 反算定位
        LatLon est = estimateFromDOA(pos1, doa1, pos2, doa2);
//        System.out.println("est.lat: " + est.lat + ", est.lon: " + est.lon);

        // 5. 计算与真实位置误差
        Dcts.Position tgtPos = tgt.getPosition();
        double errKm = haversine(
                tgtPos.getLatitude(), tgtPos.getLongitude(),
                est.lat, est.lon);

        // 6. 若误差在容忍范围内，发布匹配结果
        if (errKm <= 200.0) {
            TargetOuterClass.CombinedMessage msg = TargetOuterClass.CombinedMessage.newBuilder()
                    .setAeronavalTarget(tgt)
                    .addAllSignalLayerSurveys(selected)
                    .build();
            fusionPublisher.sendMore("Fusion_AirDomain");
            fusionPublisher.send(msg.toByteArray());
        }
    }

    // 清理缓存中超过时间窗口的目标
    private void cleanExpiredTargets() {
        Instant now = Instant.now();
        targetCache.removeIf(tgt ->
                Duration.between(
                        Instant.ofEpochSecond(tgt.getTime().getSeconds(), tgt.getTime().getNanos()),
                        now
                ).getSeconds() > TIME_WINDOW_SEC
        );
    }

    // 清理缓存中超过时间窗口的信号列表
    private void cleanExpiredSurveys() {
        Instant now = Instant.now();
        surveyCache.removeIf(s ->
                Duration.between(
                        Instant.ofEpochSecond(s.getTimeStamp().getSeconds(), s.getTimeStamp().getNanos()),
                        now
                ).getSeconds() > TIME_WINDOW_SEC
        );
    }

    // Haversine 距离计算（单位 km）
    private static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371.0;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        return 2 * R * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }

    // 经纬度结果包装结构
    static class LatLon {
        double lat, lon;
        LatLon(double lat, double lon) { this.lat = lat; this.lon = lon; }
    }

    // 基于两个测向站的位置与 DOA 角度反算目标位置（交叉定位）
    private static LatLon estimateFromDOA(Dcts.Position p1, double doa1,
                                          Dcts.Position p2, double doa2) {
        double theta1 = Math.toRadians(doa1);
        double theta2 = Math.toRadians(doa2);
        double x1 = p1.getLongitude(), y1 = p1.getLatitude();
        double x2 = p2.getLongitude(), y2 = p2.getLatitude();
        double dx1 = Math.sin(theta1), dy1 = Math.cos(theta1);
        double dx2 = Math.sin(theta2), dy2 = Math.cos(theta2);

        double denom = dx1 * dy2 - dy1 * dx2;
        if (Math.abs(denom) < 1e-6) return new LatLon((y1 + y2) / 2, (x1 + x2) / 2);

        double t1 = ((x2 - x1) * dy2 - (y2 - y1) * dx2) / denom;
        return new LatLon(y1 + t1 * dy1, x1 + t1 * dx1);
    }
}
