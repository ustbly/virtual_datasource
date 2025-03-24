package mock_data;

import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class MockSignalList {
    public static void main(String[] args) {
        try (ZContext context = new ZContext()) {
            // 创建订阅套接字，连接到发布者
            ZMQ.Socket subscriber = context.createSocket(ZMQ.SUB);
            subscriber.connect("tcp://localhost:5556");

            // 订阅 "sensorA" 主题
            String topic = "sensorA";
            subscriber.subscribe(topic.getBytes(ZMQ.CHARSET));
            System.out.println("Subscribed to: " + topic);

            while (true) {
                String message = subscriber.recvStr();
                System.out.println("Received: " + message);
            }
        }
    }
}
