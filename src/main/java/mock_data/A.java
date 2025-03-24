package mock_data;

import org.zeromq.ZMQ;

public class A {
    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5557");
        subscriber.subscribe("");

        while (true) {
            String message = subscriber.recvStr();
            System.out.println("New Topic Received: " + message);
        }
    }
}
