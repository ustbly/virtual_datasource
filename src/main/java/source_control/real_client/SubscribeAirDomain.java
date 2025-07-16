package source_control.real_client;

import org.zeromq.ZMQ;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
import zb.dcts.scenario.detection.Detection;

/**
 * @file SubscribeAirDomain.java
 * @comment 订阅融合后的空域数据
 * @date 2025/7/1
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class SubscribeAirDomain {
    // ZeroMQ 订阅地址和主题
    private static final String SUB_ADDR = "tcp://localhost:5560";
    private static final String TOPIC = "Fusion_AirDomain";

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect(SUB_ADDR);
        subscriber.subscribe(TOPIC.getBytes());

        System.out.println("[Subscriber] 启动，监听端口: " + SUB_ADDR + "，主题: " + TOPIC);

        while (!Thread.currentThread().isInterrupted()) {
            try {
                String topic = subscriber.recvStr();
                byte[] data = subscriber.recv();

                if (!TOPIC.equals(topic)) {
                    System.out.println("[警告] 收到未知主题: " + topic);
                    continue;
                }

//                ByteArrayInputStream in = new ByteArrayInputStream(data);
//                CombinedMessage msg = CombinedMessage.parseDelimitedFrom(in);
                TargetOuterClass.FusionTargetList msg = TargetOuterClass.FusionTargetList.parseFrom(data);
                if (msg == null) {
                    System.err.println("[错误] 无法解析 CombinedMessage");
                    continue;
                }

                Aeronaval.Target tgt = msg.getAeronavalTarget();
                System.out.printf("[✔] 接收到融合目标：ID = %d，Name = %s，SignalLayerSurvey数量 = %d%n",
                        tgt.getId(), tgt.getName(), msg.getSignalLayerSurveysCount());

                for (Detection.SignalLayerSurvey survey : msg.getSignalLayerSurveysList()) {
//                    System.out.printf("  ↪ 来自源 %d，信号数 = %d， 信号列表%s：%n",
//                            survey.getResultFrom().getValue(), survey.getFixSignalListCount(), survey.getFixSignalListList());
                    System.out.printf("  ↪ 来自源 %d，信号数 = %d%n",
                            survey.getResultFrom().getValue(), survey.getFixSignalListCount());
                }
            } catch (Exception e) {
                System.err.println("[错误] 接收或解析失败: " + e.getMessage());
                e.printStackTrace();
            }
        }

        subscriber.close();
        context.term();
    }
}
