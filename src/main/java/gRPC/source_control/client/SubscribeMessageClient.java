package gRPC.source_control.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import com.google.protobuf.Any;
import com.google.protobuf.StringValue;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.SourceControlServiceApi;
import proto_compile.cetc41.nodecontrol.SourceControlServiceGrpc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @file SubscribeMessageClient.java
 * @comment 任务数据订阅的测试客户端
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class SubscribeMessageClient {

    private static final Map<Integer, StreamControl> activeStreams = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        // 模拟订阅多个设备的任务类型 signal_list
        subscribeDevice(1, "signal_list");
        subscribeDevice(2, "signal_list");
        subscribeDevice(3, "signal_list");

        // 模拟在 15 秒后取消某个订阅
//        Executors.newSingleThreadScheduledExecutor().schedule(() -> unsubscribeDevice(2), 10, TimeUnit.SECONDS);

        // 保持主线程运行
        new CountDownLatch(1).await();
    }

    public static void subscribeDevice(int sourceId, String topicKey) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050).usePlaintext().build();
        SourceControlServiceGrpc.SourceControlServiceStub stub = SourceControlServiceGrpc.newStub(channel);

        // 构建订阅请求
        SourceControlServiceApi.SubscribeRequest request = SourceControlServiceApi.SubscribeRequest.newBuilder()
                .setSourceId(SourceControlServiceApi.SourceId.newBuilder().setValue(sourceId))
                .setTopic(DCTSServiceApi.Topic.newBuilder().setKey(topicKey)) // value 可选
                .build();

        // 创建并保存 observer 控制对象
        DeviceStreamObserver observer = new DeviceStreamObserver(sourceId, channel);
        activeStreams.put(sourceId, new StreamControl(channel, observer));
        stub.subscribeSourceMessage(request, observer);

        System.out.printf("已订阅：设备 %s 的任务 %s%n", sourceId, topicKey);
    }

    public static void unsubscribeDevice(int sourceId) {
        StreamControl control = activeStreams.remove(sourceId);
        if (control != null) {
            System.out.println("取消订阅设备: " + sourceId);
            control.observer.complete();
        } else {
            System.out.println("设备 " + sourceId + " 没有活跃订阅");
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
        private final int sourceId;
        private final ManagedChannel channel;
        private volatile boolean active = true;

        public DeviceStreamObserver(int sourceId, ManagedChannel channel) {
            this.sourceId = sourceId;
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
                System.out.printf("[%s] 收到任务数据: %s%n", sourceId, message.getValue());
            } catch (Exception e) {
                System.err.printf("[%s] 消息解析失败: %s%n", sourceId, e.getMessage());
            }
        }

        @Override
        public void onError(Throwable t) {
            System.err.printf("[%s] 流异常: %s%n", sourceId, t.getMessage());
            complete();
        }

        @Override
        public void onCompleted() {
            System.out.printf("[%s] 任务流已结束%n", sourceId);
            complete();
        }
    }
}

