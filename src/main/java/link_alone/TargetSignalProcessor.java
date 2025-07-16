package link_alone;

import org.zeromq.ZMQ;
import utils.SignalTargetMatcher;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
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

    private final List<Aeronaval.Target> targetCache = Collections.synchronizedList(new ArrayList<>());
    private final List<Detection.SignalLayerSurvey> surveyCache = Collections.synchronizedList(new ArrayList<>());
    private final SignalTargetMatcher matcher;

    public TargetSignalProcessor() {
        Map<Aeronaval.EquType, double[]> freqMap = new HashMap<>();
        freqMap.put(Aeronaval.EquType.AIRCAFT_EUT, new double[]{850e6, 950e6});
        freqMap.put(Aeronaval.EquType.SU27_EUT, new double[]{2.3e9, 2.5e9});
        freqMap.put(Aeronaval.EquType.JC_SHJJ_EUT, new double[]{1.1e9, 1.3e9});

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
                    List<Aeronaval.Target> targetsCopy = new ArrayList<>(targetCache);
                    List<Detection.SignalLayerSurvey> surveysCopy = new ArrayList<>(surveyCache);
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
                        TargetOuterClass.FusionTargetList combined = TargetOuterClass.FusionTargetList.parseDelimitedFrom(new ByteArrayInputStream(data));
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
