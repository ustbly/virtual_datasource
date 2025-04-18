//package gRPC.node_control.client;
//
//import com.google.protobuf.Any;
//import com.google.protobuf.StringValue;
//import io.grpc.ManagedChannel;
//import io.grpc.ManagedChannelBuilder;
//import io.grpc.stub.StreamObserver;
//import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
//import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
//import proto_compile.cetc41.nodecontrol.NodeControlServiceGrpc;
//
//import java.util.Map;
//import java.util.concurrent.*;
//
//public class SubscribeMessageClient_test {
//
//    private static final Map<String, StreamControl> activeStreams = new ConcurrentHashMap<>();
//
//    public static void main(String[] args) throws InterruptedException {
//        subscribeDevice("device-001", "status", "active");
//        subscribeDevice("device-002", "location", "gps");
//        subscribeDevice("device-003", "sensor", "temperature");
//
//        Executors.newSingleThreadScheduledExecutor().schedule(() -> unsubscribeDevice("device-002"), 10, TimeUnit.SECONDS);
//
//        new CountDownLatch(1).await(); // 保持主线程运行
//    }
//
//    public static void subscribeDevice(String deviceId, String topicKey, String topicValue) {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050).usePlaintext().build();
//        NodeControlServiceGrpc.NodeControlServiceStub stub = NodeControlServiceGrpc.newStub(channel);
//
//        NodeControlServiceApi.SubscribeRequest request = NodeControlServiceApi.SubscribeRequest.newBuilder()
//                .setDeviceId(NodeControlServiceApi.DeviceId.newBuilder().setValue(deviceId).build())
//                .setTopic(DCTSServiceApi.Topic.newBuilder().setKey(topicKey).setValue(topicValue).build())
//                .build();
//
//        DeviceStreamObserver observer = new DeviceStreamObserver(deviceId, channel);
//        activeStreams.put(deviceId, new StreamControl(channel, observer));
//        stub.subscribeSourceMessage(request, observer);
//    }
//
//    public static void unsubscribeDevice(String deviceId) {
//        StreamControl control = activeStreams.remove(deviceId);
//        if (control != null) {
//            System.out.println("取消订阅设备: " + deviceId);
//            control.observer.complete(); // 通知 observer 停止接收
//        }
//    }
//
//    private static class StreamControl {
//        final ManagedChannel channel;
//        final DeviceStreamObserver observer;
//
//        StreamControl(ManagedChannel channel, DeviceStreamObserver observer) {
//            this.channel = channel;
//            this.observer = observer;
//        }
//    }
//
//    private static class DeviceStreamObserver implements StreamObserver<Any> {
//        private final String deviceId;
//        private final ManagedChannel channel;
//        private volatile boolean active = true;
//
//        public DeviceStreamObserver(String deviceId, ManagedChannel channel) {
//            this.deviceId = deviceId;
//            this.channel = channel;
//        }
//
//        public void complete() {
//            active = false;
//            channel.shutdown();
//        }
//
//        @Override
//        public void onNext(Any value) {
//            if (!active) return;
//            try {
//                StringValue message = value.unpack(StringValue.class);
//                System.out.printf("[%s] 收到消息: %s%n", deviceId, message.getValue());
//            } catch (Exception e) {
//                System.err.printf("[%s] 消息解析失败: %s%n", deviceId, e.getMessage());
//            }
//        }
//
//        @Override
//        public void onError(Throwable t) {
//            System.err.printf("[%s] 流异常: %s%n", deviceId, t.getMessage());
//            complete();
//        }
//
//        @Override
//        public void onCompleted() {
//            System.out.printf("[%s] 流已关闭%n", deviceId);
//            complete();
//        }
//    }
//}
