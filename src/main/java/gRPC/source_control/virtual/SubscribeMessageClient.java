package gRPC.source_control.virtual;

import datasource.DataSource;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import com.google.protobuf.Any;
import com.google.protobuf.StringValue;
import service.SourceControlService;
import zb.dcts.Dcts;
import zb.dcts.source.Source;
import zb.dcts.source.SourceControlServiceGrpc;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @file SubscribeMessageClient.java
 * @comment 任务数据订阅的测试客户端
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class SubscribeMessageClient {

    // 用于管理每个设备和 topic 的订阅
    private static final Map<String, StreamControl> activeStreams = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        List<DataSource> dataSourceList = SourceControlService.getDeviceInfoFromRedis();
        for (DataSource dataSource : dataSourceList) {
            int sourceId = dataSource.getSource_id();
            for (Map<String, String> topicMap : dataSource.getTopics()) {
                for (String topic : topicMap.keySet()) {
                    subscribeDevice(sourceId, topic);
                }
            }
        }

        // 模拟 10 秒后取消某个订阅
        Executors.newSingleThreadScheduledExecutor().schedule(() ->
                unsubscribeDevice(2, "signal_list"), 10, TimeUnit.SECONDS);
        Executors.newSingleThreadScheduledExecutor().schedule(() ->
                unsubscribeDevice(3, "signal_list"), 15, TimeUnit.SECONDS);

        // 主线程保持运行
        new CountDownLatch(1).await();
    }

    /**
     * 发起设备任务订阅
     */
    public static void subscribeDevice(int sourceId, String topicKey) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050).usePlaintext().build();
        SourceControlServiceGrpc.SourceControlServiceStub stub = SourceControlServiceGrpc.newStub(channel);

        // 构建订阅请求
        zb.dcts.source.Source.SubscribeRequest request = zb.dcts.source.Source.SubscribeRequest.newBuilder()
                .setSourceId(Source.SourceId.newBuilder().setValue(sourceId))
                .setTopic(Dcts.Topic.newBuilder().setKey(topicKey))
                .build();

        String streamKey = sourceId + "-" + topicKey;
        DeviceStreamObserver observer = new DeviceStreamObserver(sourceId, topicKey, channel);
        activeStreams.put(streamKey, new StreamControl(channel, observer));

        stub.subscribeSourceMessage(request, observer);
        System.out.printf("✅ 已订阅: [%s] 任务: %s%n", sourceId, topicKey);
    }

    /**
     * 取消订阅某个设备某个 topic
     */
    public static void unsubscribeDevice(int sourceId, String topicKey) {
        String streamKey = sourceId + "-" + topicKey;
        StreamControl control = activeStreams.remove(streamKey);
        if (control != null) {
            System.out.printf("❌ 取消订阅: [%s] 任务: %s%n", sourceId, topicKey);
            control.observer.complete();
        } else {
            System.out.printf("⚠️ 无法取消：未找到订阅 [%s-%s]%n", sourceId, topicKey);
        }
    }

    // 控制每个流的 observer 和通道
    private static class StreamControl {
        final ManagedChannel channel;
        final DeviceStreamObserver observer;

        StreamControl(ManagedChannel channel, DeviceStreamObserver observer) {
            this.channel = channel;
            this.observer = observer;
        }
    }

    // 每个设备-topic 的 observer
    private static class DeviceStreamObserver implements StreamObserver<Any> {
        private final int sourceId;
        private final String topicKey;
        private final ManagedChannel channel;
        private volatile boolean active = true;

        public DeviceStreamObserver(int sourceId, String topicKey, ManagedChannel channel) {
            this.sourceId = sourceId;
            this.topicKey = topicKey;
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
                System.out.printf("📩 [%s/%s] 收到任务数据: %s%n", sourceId, topicKey, message.getValue());
            } catch (Exception e) {
                System.err.printf("❌ [%s/%s] 消息解析失败: %s%n", sourceId, topicKey, e.getMessage());
            }
        }

        @Override
        public void onError(Throwable t) {
            System.err.printf("💥 [%s/%s] 订阅异常: %s%n", sourceId, topicKey, t.getMessage());
            complete();
        }

        @Override
        public void onCompleted() {
            System.out.printf("✅ [%s/%s] 订阅结束%n", sourceId, topicKey);
            complete();
        }
    }
}

