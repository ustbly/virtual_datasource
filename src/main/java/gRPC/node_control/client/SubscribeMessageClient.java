package gRPC.node_control.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import com.google.protobuf.Any;
import com.google.protobuf.StringValue;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceGrpc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SubscribeMessageClient {

    private static final Map<String, StreamControl> activeStreams = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        // 模拟订阅多个设备的任务类型 signal_list
        subscribeDevice("Device_01", "signal_list");
        subscribeDevice("Device_02", "signal_list");
        subscribeDevice("Device_03", "signal_list");

        // 模拟在 15 秒后取消某个订阅
        Executors.newSingleThreadScheduledExecutor().schedule(() -> unsubscribeDevice("Device_02"), 10, TimeUnit.SECONDS);

        // 保持主线程运行
        new CountDownLatch(1).await();
    }

    public static void subscribeDevice(String deviceId, String topicKey) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050).usePlaintext().build();
        NodeControlServiceGrpc.NodeControlServiceStub stub = NodeControlServiceGrpc.newStub(channel);

        // 构建订阅请求
        NodeControlServiceApi.SubscribeRequest request = NodeControlServiceApi.SubscribeRequest.newBuilder()
                .setDeviceId(NodeControlServiceApi.DeviceId.newBuilder().setValue(deviceId))
                .setTopic(DCTSServiceApi.Topic.newBuilder().setKey(topicKey)) // value 可选
                .build();

        // 创建并保存 observer 控制对象
        DeviceStreamObserver observer = new DeviceStreamObserver(deviceId, channel);
        activeStreams.put(deviceId, new StreamControl(channel, observer));
        stub.subscribeSourceMessage(request, observer);

        System.out.printf("已订阅：设备 %s 的任务 %s%n", deviceId, topicKey);
    }

    public static void unsubscribeDevice(String deviceId) {
        StreamControl control = activeStreams.remove(deviceId);
        if (control != null) {
            System.out.println("取消订阅设备: " + deviceId);
            control.observer.complete();
        } else {
            System.out.println("设备 " + deviceId + " 没有活跃订阅");
        }
    }

    // 控制通道关闭
    private static class StreamControl {
        final ManagedChannel channel;
        final DeviceStreamObserver observer;

        StreamControl(ManagedChannel channel, DeviceStreamObserver observer) {
            this.channel = channel;
            this.observer = observer;
        }
    }

    // 每个设备的订阅流处理
    private static class DeviceStreamObserver implements StreamObserver<Any> {
        private final String deviceId;
        private final ManagedChannel channel;
        private volatile boolean active = true;

        public DeviceStreamObserver(String deviceId, ManagedChannel channel) {
            this.deviceId = deviceId;
            this.channel = channel;
        }

        public void complete() {
            active = false;
            channel.shutdown();
        }

        @Override
        public void onNext(Any value) {
            if (!active) return;
            try {
                StringValue message = value.unpack(StringValue.class);
                System.out.printf("[%s] 收到任务数据: %s%n", deviceId, message.getValue());
            } catch (Exception e) {
                System.err.printf("[%s] 消息解析失败: %s%n", deviceId, e.getMessage());
            }
        }

        @Override
        public void onError(Throwable t) {
            System.err.printf("[%s] 流异常: %s%n", deviceId, t.getMessage());
            complete();
        }

        @Override
        public void onCompleted() {
            System.out.printf("[%s] 任务流已结束%n", deviceId);
            complete();
        }
    }
}

