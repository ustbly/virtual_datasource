package utils;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import zb.dcts.fusion.airDomain.communLink.CommunLinkOuterClass;

/**
 * @file ZmqSubscriber.java
 * @comment 接受 ZeroMQ 发布的消息，并解析为 NetworkCommunLikResult 对象。
 * @date 2025/8/13
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class ZmqSubscriber {

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(SocketType.SUB);

        subscriber.connect("tcp://localhost:9999");
        subscriber.subscribe("NetworkCommunLikResult"); // 订阅指定主题

        System.out.println("Subscriber connected and listening for 'NetworkCommunLikResult'...");

        while (true) {
            try {
                String topic = subscriber.recvStr();
                byte[] message = subscriber.recv();

                // 解析为单个 NetworkCommunLikResult
                CommunLinkOuterClass.NetworkCommunLikResult result =
                        CommunLinkOuterClass.NetworkCommunLikResult.parseFrom(message);

                // 手动格式化输出
                System.out.println("---- Received Topic: " + topic + " ----");
                System.out.println("Network ID: " + result.getId());
                System.out.println("Network Type: " + result.getType());

                if (result.getCommunLinkResultCount() > 0) {
                    System.out.println("CommunLink Results:");
                    for (CommunLinkOuterClass.CommunLink link : result.getCommunLinkResultList()) {
                        System.out.printf("  Src ID: %d, Dest ID: %d%n",
                                link.getSrcId(), link.getDesId());

                        CommunLinkOuterClass.ConnectParam state = link.getCommunState();
                        System.out.printf("    Connect: %d,%n",
                                state.getConnet());
                    }
                } else {
                    System.out.println("No CommunLink Results.");
                }
                System.out.println("-----------------------------------");

            } catch (Exception e) {
                System.err.println("Failed to parse message: " + e.getMessage());
            }
        }
    }
}
