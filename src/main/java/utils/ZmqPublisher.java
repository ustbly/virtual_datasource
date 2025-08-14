package utils;

import org.zeromq.ZMQ;
import org.zeromq.SocketType;

/**
 * @file ZmqPublisher.java
 * @comment 发布 ZeroMQ 消息，模拟实时消息发布，可选择特定端口进行发布。
 * @date 2025/8/13
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class ZmqPublisher {

    private final ZMQ.Context context;
    private final ZMQ.Socket publisher;

    public ZmqPublisher(int port) {
        context = ZMQ.context(1);
        publisher = context.socket(SocketType.PUB);
        publisher.bind("tcp://*:" + port);
        System.out.println("Publisher started on port " + port);
    }

    public void publish(String topic, byte[] data) {
        publisher.sendMore(topic);
        publisher.send(data);
    }

    public void close() {
        publisher.close();
        context.close();
    }

    public static void main(String[] args) throws InterruptedException {
//        ZmqPublisher zmqPublisher = new ZmqPublisher(5560);
//
//        // 模拟实时发布
//        int counter = 1;
//        while (true) {
//            String topic = "NetworkControl";
//            String message = "ControlMessage_" + counter++;
//            zmqPublisher.publish(topic, message.getBytes());
//            System.out.println("Published: [" + topic + "] " + message);
//
//            Thread.sleep(1000); // 每秒发布一次
//        }
    }
}
