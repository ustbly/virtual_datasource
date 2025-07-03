package mock_data;


///** 必须启动该程序，下面的非注释版已经集成到 FusionDataServiceImpl.java 中
// * @author 林跃
// * @file TargetSignalProcessor.java
// * @comment 解析目标和信号的组合数据，并调用SignalTargetMatcher类进行关联处理
// * @date 2025/7/1
// * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
// */
//public class TargetSignalProcessor {
//    private static final String SUB_ADDR = "tcp://localhost:5558";
//    private static final String PUB_ADDR = "tcp://*:5560";
//
//    // 数据缓存
//    private static final List<Aeronaval.Target> targetCache = Collections.synchronizedList(new ArrayList<>());
//    private static final List<zb.dcts.scenario.detection.Detection.SignalLayerSurvey> surveyCache = Collections.synchronizedList(new ArrayList<>());
//
//    public static void main(String[] args) throws IOException {
//        // 1. 初始化 ZMQ
//        ZMQ.Context context = ZMQ.context(1);
//        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
//        subscriber.connect(SUB_ADDR);
//        subscriber.subscribe("Combined".getBytes());
//
//        // 2. 初始化匹配器
//        Map<Aeronaval.EquType, double[]> freqMap = new HashMap<>();
//        freqMap.put(zb.dcts.aeronaval.Aeronaval.EquType.AIRCAFT_EUT, new double[]{850e6, 950e6});
//        freqMap.put(zb.dcts.aeronaval.Aeronaval.EquType.SU27_EUT, new double[]{2.3e9, 2.5e9});
//        freqMap.put(zb.dcts.aeronaval.Aeronaval.EquType.JC_SHJJ_EUT, new double[]{1.1e9, 1.3e9});
//
//        // 3. 传入各关联规则所需的参数，可根据实际需求调整
//        SignalTargetMatcher matcher = new SignalTargetMatcher(
//                1, 200.0, 200.0,
//                freqMap, 4, PUB_ADDR
//        );
//
//        // 4. 定时任务：每5秒触发一次匹配
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
//        scheduler.scheduleAtFixedRate(() -> {
//            if (!targetCache.isEmpty() && !surveyCache.isEmpty()) {
//                System.out.printf("[Matcher] Start matching: %d targets, %d surveys%n", targetCache.size(), surveyCache.size());
//                List<zb.dcts.aeronaval.Aeronaval.Target> targetsCopy = new ArrayList<>(targetCache);
//                List<zb.dcts.scenario.detection.Detection.SignalLayerSurvey> surveysCopy = new ArrayList<>(surveyCache);
//                List<zb.dcts.fusion.airDomain.target.TargetOuterClass.CombinedMessage> combinedMessages = matcher.matchAndPublish(surveysCopy, targetsCopy);
//                System.out.println(combinedMessages);
//
//                // 可选择清空或缓存更多
//                targetCache.clear();
//                surveyCache.clear();
//            }
//        }, 0, 1, TimeUnit.SECONDS);
//
//        // 5. 主循环：接收 Combined 消息并拆分为 Target 与 SignalList
//        while (!Thread.currentThread().isInterrupted()) {
//            String topic = subscriber.recvStr();
//            byte[] data = subscriber.recv();
//
//            if ("Combined".equals(topic)) {
//                try (ByteArrayInputStream in = new ByteArrayInputStream(data)) {
//                    zb.dcts.fusion.airDomain.target.TargetOuterClass.CombinedMessage combined = zb.dcts.fusion.airDomain.target.TargetOuterClass.CombinedMessage.parseDelimitedFrom(in); // ✅ 正确方法
//                    if (combined != null) {
//                        zb.dcts.aeronaval.Aeronaval.Target target = combined.getAeronavalTarget();
//                        List<zb.dcts.scenario.detection.Detection.SignalLayerSurvey> surveys = combined.getSignalLayerSurveysList();
//
//                        targetCache.add(target);
//                        surveyCache.addAll(surveys);
//
//                        System.out.printf("[Subscriber] 接收到 Combined：目标 ID = %d，信号数 = %d，累计目标数：%d，累计信号数：%d%n",
//                                target.getId(), surveys.size(), targetCache.size(), surveyCache.size());
//                    }
//                } catch (Exception e) {
//                    System.err.println("[Subscriber] CombinedMessage 解析失败: " + e.getMessage());
//                    e.printStackTrace();
//                }
//            }
//        }
//        // 6. 清理资源
//        matcher.shutdown();
//        subscriber.close();
//        context.term();
//    }
//}


import org.zeromq.ZMQ;
import utils.SignalTargetMatcher;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.scenario.detection.Detection;

import java.io.ByteArrayInputStream;
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

    private final List<zb.dcts.aeronaval.Aeronaval.Target> targetCache = Collections.synchronizedList(new ArrayList<>());
    private final List<Detection.SignalLayerSurvey> surveyCache = Collections.synchronizedList(new ArrayList<>());
    private final SignalTargetMatcher matcher;

    public TargetSignalProcessor() {
        Map<Aeronaval.EquType, double[]> freqMap = new HashMap<>();
        freqMap.put(zb.dcts.aeronaval.Aeronaval.EquType.AIRCAFT_EUT, new double[]{850e6, 950e6});
        freqMap.put(zb.dcts.aeronaval.Aeronaval.EquType.SU27_EUT, new double[]{2.3e9, 2.5e9});
        freqMap.put(zb.dcts.aeronaval.Aeronaval.EquType.JC_SHJJ_EUT, new double[]{1.1e9, 1.3e9});

        matcher = new SignalTargetMatcher(
                1, 200.0, 200.0, freqMap, 4, PUB_ADDR
        );
    }

    public void start() {
        Thread processorThread = new Thread(() -> {
            ZMQ.Context context = ZMQ.context(1);
            ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
            subscriber.connect(SUB_ADDR);
            subscriber.subscribe("Combined".getBytes());

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
            scheduler.scheduleAtFixedRate(() -> {
                if (!targetCache.isEmpty() && !surveyCache.isEmpty()) {
                    List<zb.dcts.aeronaval.Aeronaval.Target> targetsCopy = new ArrayList<>(targetCache);
                    List<zb.dcts.scenario.detection.Detection.SignalLayerSurvey> surveysCopy = new ArrayList<>(surveyCache);
                    matcher.linkAndPublish(surveysCopy, targetsCopy);
                    targetCache.clear();
                    surveyCache.clear();
                }
            }, 0, 1, TimeUnit.SECONDS);

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String topic = subscriber.recvStr();
                    byte[] data = subscriber.recv();

                    if ("Combined".equals(topic)) {
                        zb.dcts.fusion.airDomain.target.TargetOuterClass.CombinedMessage combined = zb.dcts.fusion.airDomain.target.TargetOuterClass.CombinedMessage.parseDelimitedFrom(new ByteArrayInputStream(data));
                        if (combined != null) {
                            targetCache.add(combined.getAeronavalTarget());
                            surveyCache.addAll(combined.getSignalLayerSurveysList());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            subscriber.close();
            context.term();
        });

        processorThread.setDaemon(true);
        processorThread.start();
    }
}
