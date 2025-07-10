package utils;

import org.zeromq.SocketType;
import zb.dcts.Dcts;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.fusion.airDomain.target.TargetOuterClass.CombinedMessage;
import zb.dcts.scenario.detection.Detection;
import org.zeromq.ZMQ;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author 林跃
 * @file SignalTargetMatcher.java
 * @comment 信号与目标关联算法封装类：支持时间、空间、DOA、频段规则匹配，并将匹配结果自动以 CombinedMessage 推送至 ZeroMQ
 * @date 2025/6/30
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class SignalTargetMatcher {
    // ==== 常量定义 ====
    // 预定义测向站位置（经纬度）
    private static final zb.dcts.Dcts.Position[] STATION_POS = {
            zb.dcts.Dcts.Position.newBuilder().setLongitude(116.3).setLatitude(39.8).build(),
            zb.dcts.Dcts.Position.newBuilder().setLongitude(116.5).setLatitude(40.0).build()
    };
    private final double maxTimeDiffSec;      // 最大时间差（秒）
    private final double maxDistanceKm;       // 最大空间距离（公里）
    private final double maxDoaDiffDeg;       // 最大 DOA 差值（角度）
    private final Map<Aeronaval.EquType, double[]> equFreqMap; // 装备类型 → 合法频段范围映射
    private final ExecutorService executor;   // 用于并行匹配的线程池
    private final ZMQ.Context zmqContext;     // ZeroMQ 上下文
    private final ZMQ.Socket zmqPublisher;    // ZeroMQ 发布器

    // ==== 内部类：测向数据容器 ====
    /**
     * 存储单个测向站的测量数据
     */
    static class DOAMeasurement {
        double lat;   // 测向站纬度
        double lon;   // 测向站经度
        double az; // 测向角度（0~360）

        DOAMeasurement(double lat, double lon, double az) {
            this.lat = lat;
            this.lon = lon;
            this.az = az;
        }
    }

    // ==== 内部类：经纬度坐标 ====
    /**
     * 表示地理坐标的简单容器
     */
    static class LatLon {
        double lat;
        double lon;

        LatLon(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }
    }

    /**
     * 构造函数：初始化匹配参数与ZeroMQ发布通道
     *
     * @param maxTimeDiffSec 最大时间差阈值(秒)
     * @param maxDistanceKm  最大空间距离阈值(公里)
     * @param maxDoaDiffDeg  最大DOA定位误差阈值(公里)
     * @param equFreqMap     装备类型-频段映射表
     * @param threadPoolSize 线程池大小
     * @param zmqBindAddress ZeroMQ绑定地址(如"tcp://*:5560")
     */
    public SignalTargetMatcher(double maxTimeDiffSec, double maxDistanceKm, double maxDoaDiffDeg,
                               Map<Aeronaval.EquType, double[]> equFreqMap,
                               int threadPoolSize, String zmqBindAddress) {
        // 初始化匹配阈值参数
        this.maxTimeDiffSec = maxTimeDiffSec;
        this.maxDistanceKm = maxDistanceKm;
        this.maxDoaDiffDeg = maxDoaDiffDeg;
        this.equFreqMap = equFreqMap;

        // 创建固定大小线程池
        this.executor = Executors.newFixedThreadPool(threadPoolSize);

        // 初始化ZeroMQ PUB-SUB模式
        this.zmqContext = ZMQ.context(1);
        this.zmqPublisher = zmqContext.socket(SocketType.PUB);
        this.zmqPublisher.bind(zmqBindAddress); // 例如 "tcp://*:5560"
    }

    /**
     * 匹配逻辑入口：输入多个 Survey 与多个 Target，输出关联成功的 CombinedMessage 列表
     *
     * @param surveys 信号侦察数据列表
     * @param targets 目标列表
     * @return 关联成功的CombinedMessage集合
     */
    public List<CombinedMessage> linkAndPublish(List<Detection.SignalLayerSurvey> surveys,
                                                List<Aeronaval.Target> targets) {
        List<Future<CombinedMessage>> futures = new ArrayList<>();
        // 并发处理每个目标的匹配任务
        for (Aeronaval.Target tgt : targets) {
            futures.add(executor.submit(() -> matchSingleTarget(tgt, surveys)));
        }

        List<CombinedMessage> results = new ArrayList<>();
        for (Future<CombinedMessage> f : futures) {
            try {
                CombinedMessage cm = f.get();
                // 仅处理有效匹配结果
                if (cm != null && cm.getSignalLayerSurveysCount() > 0) {
                    results.add(cm);
                    String bussinessType = cm.getBussinessType();
                    System.out.println("bussinessType" + bussinessType);
                    // 通过ZeroMQ发布关联结果
                    zmqPublisher.sendMore("Fusion_AirDomain");  // 主题标签
                    zmqPublisher.send(cm.toByteArray());        // 协议缓冲区数据
                    System.out.printf("[推送] 已发布关联结果：Target ID = %d，信号数 = %d%n",
                            cm.getAeronavalTarget().getId(), cm.getSignalLayerSurveysCount());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    /**
     * 双站DOA定位算法
     *
     * @param m1 测向站1的测量数据
     * @param m2 测向站2的测量数据
     * @return 估算的目标位置(LatLon)
     */
    private static LatLon estimatePositionFromDOA(DOAMeasurement m1, DOAMeasurement m2) {
        // 将 azimuth 转为弧度
        double theta1 = Math.toRadians(m1.az);
        double theta2 = Math.toRadians(m2.az);

        // 转为笛卡尔坐标系：x = lon, y = lat
        double x1 = m1.lon, y1 = m1.lat;
        double x2 = m2.lon, y2 = m2.lat;

        // 每个方向的单位向量 (dx, dy)
        double dx1 = Math.sin(theta1), dy1 = Math.cos(theta1);
        double dx2 = Math.sin(theta2), dy2 = Math.cos(theta2);

        // 解两个方向向量组成的射线方程交点
        double denominator = dx1 * dy2 - dy1 * dx2;
        if (Math.abs(denominator) < 1e-6) {
            // 平行或接近平行，无解，用中点近似
            return new LatLon((y1 + y2) / 2, (x1 + x2) / 2);
        }

        // 计算交点坐标
        double t1 = ((x2 - x1) * dy2 - (y2 - y1) * dx2) / denominator;
        double interX = x1 + t1 * dx1;
        double interY = y1 + t1 * dy1;

        return new LatLon(interY, interX); // y = lat, x = lon
    }

    //    private CombinedMessage matchSingleTarget(Aeronaval.Target tgt,
//                                              List<Detection.SignalLayerSurvey> surveys) {
//
//        // 提取目标时间和位置
//        Instant t0 = Instant.ofEpochSecond(tgt.getTime().getSeconds(), tgt.getTime().getNanos());
//        Dcts.Position tgtPos = tgt.getPosition();
//        CombinedMessage.Builder builder = CombinedMessage.newBuilder().setAeronavalTarget(tgt);
//
//        // 用于存放通过时间、空间、频率筛选的 Survey 以及对应的 DOA 信息
//        List<Detection.SignalLayerSurvey> matchedSurveys = new ArrayList<>();
//        List<DOAMeasurement> doaMeasurements = new ArrayList<>();
//
//        for (Detection.SignalLayerSurvey survey : surveys) {
//            // 1. 时间差过滤
//            Instant surveyTime = Instant.ofEpochSecond(survey.getTimeStamp().getSeconds(), survey.getTimeStamp().getNanos());
//            long timeDiff = Math.abs(Duration.between(t0, surveyTime).getSeconds());
//            if (timeDiff > maxTimeDiffSec) continue;
//
//            // 2. 空间距离过滤（目标与测向站位置）
//            double distKm = haversine(
//                    tgtPos.getLatitude(), tgtPos.getLongitude(),
//                    survey.getPosition().getLatitude(), survey.getPosition().getLongitude());
//            if (distKm > maxDistanceKm) continue;
//
//            // 3. 频率匹配过滤
//            boolean freqMatched = false;
//            for (Detection.SignalDigest sig : survey.getFixSignalListList()) {
////                double freq = sig.getCenterFreq().getMean();
////                if (isFreqMatch(freq, tgt.getEquType())) {
////                    freqMatched = true;
//
//                // 提取 DOA 观测信息（一个测向站位置 + 一个 DOA）
//                doaMeasurements.add(new DOAMeasurement(
//                        survey.getPosition().getLatitude(),
//                        survey.getPosition().getLongitude(),
//                        sig.getDirOfArrival().getAzimuth()
//                ));
////                }
//            }
//
//            // 若此 survey 中无频率匹配信号，跳过
////            if (!freqMatched) continue;
//
//            // 添加进匹配列表（最终 DOA 位置匹配成功后统一纳入结果）
//            matchedSurveys.add(survey);
//        }
//
//        // 至少两个测向站的 DOA 才能反算目标位置
//        if (doaMeasurements.size() >= 2) {
//            LatLon est = estimatePositionFromDOA(doaMeasurements.get(0), doaMeasurements.get(1));
//
//            // 与目标位置比对误差
//            double err = haversine(
//                    tgtPos.getLatitude(), tgtPos.getLongitude(),
//                    est.lat, est.lon);
//            System.out.println("err: " + err);
//            System.out.printf("[DOA反算] 目标位置：%.4f, %.4f | 估算位置：%.4f, %.4f | 误差：%.2f km%n",
//                    tgtPos.getLatitude(), tgtPos.getLongitude(),
//                    est.lat, est.lon, err);
//            if (err <= maxDoaDiffDeg) {
//                // 匹配成功，添加所有通过频率+时空过滤的 Survey
//                builder.addAllSignalLayerSurveys(matchedSurveys);
//                System.out.printf("[✓] 目标 %d 匹配成功，定位误差 %.2f km%n", tgt.getId(), err);
//                return builder.build();
//            } else {
//                System.out.printf("[×] 目标 %d 定位误差 %.2f km 超阈值 %.1f km%n", tgt.getId(), err, maxDoaDiffDeg);
//            }
//        } else {
//            System.out.printf("[×] 目标 %d DOA 观测不足，测向数=%d%n", tgt.getId(), doaMeasurements.size());
//        }
//
//        return null;
//    }
    // 关联装备目标与信号列表的逻辑
    /**
     * 单目标匹配核心逻辑
     *
     * @param tgt     待匹配目标
     * @param surveys 可用信号侦察数据
     * @return 包含关联结果的CombinedMessage（匹配失败返回null）
     */
    private CombinedMessage matchSingleTarget(Aeronaval.Target tgt, List<Detection.SignalLayerSurvey> surveys) {
        // 目标时空信息提取
        Instant t0 = Instant.ofEpochSecond(tgt.getTime().getSeconds(), tgt.getTime().getNanos());
        Dcts.Position tgtPos = tgt.getPosition();

        // 构建结果消息（设置业务元数据）
        CombinedMessage.Builder builder = CombinedMessage.newBuilder()
                .setAeronavalTarget(tgt)
                .setBussinessType("Comm")
                .setReliability(2)
                .setImportance(1)
                .setThrtLvl(Dcts.ThreatLevel.LOW)
                .setPurpose("Test");

        // 用于存放通过时间、空间、频率筛选的 Survey 以及对应的 DOA 信息
        List<Detection.SignalLayerSurvey> matchedSurveys = new ArrayList<>();
        List<DOAMeasurement> doaMeasurements = new ArrayList<>();
        Set<Integer> uniqueStations = new HashSet<>();  // 避免重复处理同一测向站

        System.out.printf("%n[Matcher] 开始处理目标 ID=%d，位置=(%.5f, %.5f)%n",
                tgt.getId(), tgtPos.getLatitude(), tgtPos.getLongitude());

        // ==== 多级过滤流程 ====
        for (Detection.SignalLayerSurvey survey : surveys) {
            // 1. 时间过滤
            Instant surveyTime = Instant.ofEpochSecond(
                    survey.getTimeStamp().getSeconds(), survey.getTimeStamp().getNanos());
            long timeDiff = Math.abs(Duration.between(t0, surveyTime).getSeconds());
            if (timeDiff > maxTimeDiffSec) {
                System.out.printf("[跳过] Survey 时间差 %d 秒 超限%n", timeDiff);
                continue;
            }

            // 2. 空间距离过滤
            double dist = haversine(
                    tgtPos.getLatitude(), tgtPos.getLongitude(),
                    survey.getPosition().getLatitude(), survey.getPosition().getLongitude());
            if (dist > maxDistanceKm) {
                System.out.printf("[跳过] Survey 空间距离 %.2f km 超限%n", dist);
                continue;
            }

            // 3. 测向站去重
            int sourceId = survey.getResultFrom().getValue();
            if (uniqueStations.contains(sourceId)) {
                System.out.printf("[跳过] 测向站 %d 已处理过，跳过重复 Survey%n", sourceId);
                continue;
            }
            // 检查是否有信号记录
            if (survey.getFixSignalListCount() == 0) {
                System.out.printf("[跳过] Survey 无信号记录，sourceId = %d%n", sourceId);
                continue;
            }

            // 提取 DOA（默认取第一个）
            Detection.SignalDigest sig = survey.getFixSignalList(0);
            double azimuth = sig.getDirOfArrival().getAzimuth();

            doaMeasurements.add(new DOAMeasurement(
                    survey.getPosition().getLatitude(),
                    survey.getPosition().getLongitude(),
                    azimuth));

            // 记录有效survey
            uniqueStations.add(sourceId);
            matchedSurveys.add(survey);

            System.out.printf("[✓] Survey 来自源 %d，DOA=%.2f°，位置=(%.4f, %.4f)%n",
                    sourceId, azimuth,
                    survey.getPosition().getLatitude(), survey.getPosition().getLongitude());
        }

        // 检查是否有足够的 DOA 来定位
        if (doaMeasurements.size() >= 2) {
            // 双站定位估算
            LatLon est = estimatePositionFromDOA(doaMeasurements.get(0), doaMeasurements.get(1));
            double errDist = haversine(
                    tgtPos.getLatitude(), tgtPos.getLongitude(),
                    est.lat, est.lon);

            System.out.printf("[定位] 目标位置：%.5f, %.5f | 估算位置：%.5f, %.5f | 误差：%.3f km%n",
                    tgtPos.getLatitude(), tgtPos.getLongitude(),
                    est.lat, est.lon, errDist);

            // 误差阈值判断
            if (errDist <= maxDoaDiffDeg) {
                builder.addAllSignalLayerSurveys(matchedSurveys);       // 注入关联信号
                System.out.printf("[✓] 目标 %d 匹配成功，共 %d 条信号，误差 %.3f km%n",
                        tgt.getId(), matchedSurveys.size(), errDist);
                return builder.build();
            } else {
                System.out.printf("[×] 目标 %d 定位误差 %.3f km 超阈值 %.3f km%n",
                        tgt.getId(), errDist, maxDoaDiffDeg);
            }
        } else {
            System.out.printf("[×] 目标 %d DOA 观测不足，仅收集到 %d 条%n",
                    tgt.getId(), doaMeasurements.size());
        }
        // 关联失败
        return null;
    }


    // 判断频率是否符合装备类型的频段限制（目前暂未使用）
    private boolean isFreqMatch(double freqHz, Aeronaval.EquType type) {
        double[] range = equFreqMap.get(type);
        if (range == null) return true;
        return freqHz >= range[0] && freqHz <= range[1];
    }

    // Haversine 计算两个坐标之间的距离（单位：km）
    private static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371.0;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        return 2 * R * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }

//    // 计算两个点之间的方位角（角度）
//    private static double computeAzimuth(Dcts.Position from, Dcts.Position to) {
//        double dLon = to.getLongitude() - from.getLongitude();
//        double dLat = to.getLatitude() - from.getLatitude();
//        double az = Math.toDegrees(Math.atan2(dLon, dLat));
//        return (az + 360) % 360;
//    }

    // 清理线程池与 ZeroMQ 资源
    public void shutdown() {
        executor.shutdownNow();
        zmqPublisher.close();
        zmqContext.term();
    }
}
