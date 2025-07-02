package mock_data;
//
//import com.google.protobuf.InvalidProtocolBufferException;
//import org.zeromq.ZMQ;
//import zb.dcts.fusion.airDomain.target.TargetOuterClass;
//import zb.dcts.scenario.detection.Detection;
//
//public class SubscriberAll {
//    private static final zb.dcts.Dcts.Position[] STATION_POS = {
//            zb.dcts.Dcts.Position.newBuilder().setLongitude(116.3).setLatitude(39.8).setAltitude(50).build(),
//            zb.dcts.Dcts.Position.newBuilder().setLongitude(116.5).setLatitude(40.0).setAltitude(60).build()
//    };
//
//    private static final String SUB_ADDR = "tcp://localhost:5556";
//
//    public static void main(String[] args) throws InvalidProtocolBufferException {
//        ZMQ.Context context = ZMQ.context(1);
//        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
//        subscriber.connect(SUB_ADDR);
//        subscriber.subscribe("Target".getBytes());
//        subscriber.subscribe("SignalList".getBytes());
//
//        while (!Thread.currentThread().isInterrupted()) {
//            String topic = subscriber.recvStr();
//            byte[] data = subscriber.recv();
//
//            switch (topic) {
//                case "Target":
//                    TargetOuterClass.TargetList targetList = TargetOuterClass.TargetList.parseFrom(data);
//                    for (TargetOuterClass.Target tgt : targetList.getTargetsList()) {
//                        System.out.printf("[Subscriber] Target ID: %d, Name: %s%n", tgt.getId(), tgt.getName());
//                    }
//                    break;
//
//                case "SignalList":
//                    Detection.SignalLayerSurvey sigList = Detection.SignalLayerSurvey.parseFrom(data);
//                    for (Detection.SignalDigest sig : sigList.getFixSignalListList()) {
//                        System.out.println(sig);
//                    }
//                    break;
//
//                default:
//                    System.out.println("[Subscriber] Unknown topic: " + topic);
//                    break;
//            }
//        }
//    }
//
//
//}


//public class TargetSignalProcessor {
//
//    private static final String SUB_ADDR = "tcp://localhost:5555";
//    private static final String SUB_ADDR1 = "tcp://localhost:5556";
//    private static final String PUB_ADDR = "tcp://*:5560";
//
//
//    // 数据缓存
//    private static final List<Aeronaval.Target> targetCache = Collections.synchronizedList(new ArrayList<>());
//    private static final List<Detection.SignalLayerSurvey> surveyCache = Collections.synchronizedList(new ArrayList<>());
//
//    public static void main(String[] args) throws IOException {
//        // 1. 初始化 ZMQ
//        ZMQ.Context context = ZMQ.context(10);
//        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
//        subscriber.connect(SUB_ADDR);
//        subscriber.connect(SUB_ADDR1);
//        subscriber.subscribe("Target".getBytes());
//        subscriber.subscribe("SignalList".getBytes());
//
//        // 2. 初始化匹配器
//        Map<Aeronaval.EquType, double[]> freqMap = new HashMap<>();
//        freqMap.put(Aeronaval.EquType.AIRCAFT_EUT, new double[]{850e6, 950e6});
//        freqMap.put(Aeronaval.EquType.SU27_EUT, new double[]{2.3e9, 2.5e9});
//        freqMap.put(Aeronaval.EquType.JC_SHJJ_EUT, new double[]{1.1e9, 1.3e9});
//
//        SignalTargetMatcher matcher = new SignalTargetMatcher(
//                0.1, 200.0, 200.0,
//                freqMap, 4, PUB_ADDR
//        );
//
//        // 3. 定时任务：每5秒触发一次匹配
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
//        scheduler.scheduleAtFixedRate(() -> {
//            if (!targetCache.isEmpty() && !surveyCache.isEmpty()) {
//                System.out.printf("[Matcher] Start matching: %d targets, %d surveys%n", targetCache.size(), surveyCache.size());
//                List<Aeronaval.Target> targetsCopy = new ArrayList<>(targetCache);
//                List<Detection.SignalLayerSurvey> surveysCopy = new ArrayList<>(surveyCache);
//                List<TargetOuterClass.CombinedMessage> combinedMessages = matcher.matchAndPublish(surveysCopy, targetsCopy);
//                System.out.println(combinedMessages);
//
//                // 可选择清空或缓存更多
//                targetCache.clear();
//                surveyCache.clear();
//            }
//        }, 5, 5, TimeUnit.SECONDS);
//
//        // 4. 主循环：接收 TargetList 和 SignalList
//        while (!Thread.currentThread().isInterrupted()) {
//            String topic = subscriber.recvStr();
//            byte[] data = subscriber.recv();
//
//            if ("Target".equals(topic)) {
//                parseDelimitedTargets(data).forEach(targetCache::add);
//                System.out.printf("[Subscriber] 接收到 TargetList，累计目标数：%d%n", targetCache.size());
//            } else if ("SignalList".equals(topic)) {
//                parseDelimitedSurveys(data).forEach(surveyCache::add);
//                System.out.printf("[Subscriber] 接收到 SignalList，累计信号数：%d%n", surveyCache.size());
//            } else {
//                System.out.println("[Subscriber] 未知主题：" + topic);
//            }
//        }
//
//        matcher.shutdown();
//        subscriber.close();
//        context.term();
//    }
//
//    private static List<Aeronaval.Target> parseDelimitedTargets(byte[] data) {
//        List<Aeronaval.Target> result = new ArrayList<>();
//        try (ByteArrayInputStream in = new ByteArrayInputStream(data)) {
//            while (in.available() > 0) {
//                Aeronaval.Target t = Aeronaval.Target.parseDelimitedFrom(in);
//                if (t != null) result.add(t);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    private static List<Detection.SignalLayerSurvey> parseDelimitedSurveys(byte[] data) {
//        List<Detection.SignalLayerSurvey> result = new ArrayList<>();
//        try (ByteArrayInputStream in = new ByteArrayInputStream(data)) {
//            while (in.available() > 0) {
//                Detection.SignalLayerSurvey s = Detection.SignalLayerSurvey.parseDelimitedFrom(in);
//                if (s != null) result.add(s);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//}

import org.zeromq.ZMQ;
import utils.SignalTargetMatcher;
import zb.dcts.scenario.detection.Detection;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 林跃
 * @file TargetSignalProcessor.java
 * @comment 解析目标和信号的组合数据，并调用SignalTargetMatcher类进行关联处理
 * @date 2025/7/1
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class TargetSignalProcessor {
    private static final String SUB_ADDR = "tcp://localhost:5558";
    private static final String PUB_ADDR = "tcp://*:5560";

    // 数据缓存
    private static final List<zb.dcts.aeronaval.Aeronaval.Target> targetCache = Collections.synchronizedList(new ArrayList<>());
    private static final List<Detection.SignalLayerSurvey> surveyCache = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        // 1. 初始化 ZMQ
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect(SUB_ADDR);
        subscriber.subscribe("Combined".getBytes());

        // 2. 初始化匹配器
        Map<zb.dcts.aeronaval.Aeronaval.EquType, double[]> freqMap = new HashMap<>();
        freqMap.put(zb.dcts.aeronaval.Aeronaval.EquType.AIRCAFT_EUT, new double[]{850e6, 950e6});
        freqMap.put(zb.dcts.aeronaval.Aeronaval.EquType.SU27_EUT, new double[]{2.3e9, 2.5e9});
        freqMap.put(zb.dcts.aeronaval.Aeronaval.EquType.JC_SHJJ_EUT, new double[]{1.1e9, 1.3e9});

        // 3. 传入各关联规则所需的参数，可根据实际需求调整
        SignalTargetMatcher matcher = new SignalTargetMatcher(
                1, 200.0, 200.0,
                freqMap, 4, PUB_ADDR
        );

        // 4. 定时任务：每5秒触发一次匹配
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        scheduler.scheduleAtFixedRate(() -> {
            if (!targetCache.isEmpty() && !surveyCache.isEmpty()) {
                System.out.printf("[Matcher] Start matching: %d targets, %d surveys%n", targetCache.size(), surveyCache.size());
                List<zb.dcts.aeronaval.Aeronaval.Target> targetsCopy = new ArrayList<>(targetCache);
                List<Detection.SignalLayerSurvey> surveysCopy = new ArrayList<>(surveyCache);
                List<zb.dcts.fusion.airDomain.target.TargetOuterClass.CombinedMessage> combinedMessages = matcher.matchAndPublish(surveysCopy, targetsCopy);
                System.out.println(combinedMessages);

                // 可选择清空或缓存更多
                targetCache.clear();
                surveyCache.clear();
            }
        }, 0, 1, TimeUnit.SECONDS);

        // 5. 主循环：接收 Combined 消息并拆分为 Target 与 SignalList
        while (!Thread.currentThread().isInterrupted()) {
            String topic = subscriber.recvStr();
            byte[] data = subscriber.recv();

            if ("Combined".equals(topic)) {
                try (ByteArrayInputStream in = new ByteArrayInputStream(data)) {
                    zb.dcts.fusion.airDomain.target.TargetOuterClass.CombinedMessage combined = zb.dcts.fusion.airDomain.target.TargetOuterClass.CombinedMessage.parseDelimitedFrom(in); // ✅ 正确方法
                    if (combined != null) {
                        zb.dcts.aeronaval.Aeronaval.Target target = combined.getAeronavalTarget();
                        List<Detection.SignalLayerSurvey> surveys = combined.getSignalLayerSurveysList();

                        targetCache.add(target);
                        surveyCache.addAll(surveys);

                        System.out.printf("[Subscriber] 接收到 Combined：目标 ID = %d，信号数 = %d，累计目标数：%d，累计信号数：%d%n",
                                target.getId(), surveys.size(), targetCache.size(), surveyCache.size());
                    }
                } catch (Exception e) {
                    System.err.println("[Subscriber] CombinedMessage 解析失败: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        // 6. 清理资源
        matcher.shutdown();
        subscriber.close();
        context.term();
    }
}
