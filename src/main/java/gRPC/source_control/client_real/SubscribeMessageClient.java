package gRPC.source_control.client_real;

import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import com.google.protobuf.Any;
import zb.dcts.Dcts;
import zb.dcts.scenario.detection.Detection;
import zb.dcts.source.Source;
import zb.dcts.source.SourceControlServiceGrpc;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 林跃
 * @file SubscribeMessageClient.java
 * @comment 任务数据订阅的测试客户端
 * @date 2025/6/12
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class SubscribeMessageClient {

    // 用于管理每个设备和 topic 的订阅
    private static final Map<String, StreamControl> activeStreams = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Source.SourceSetInfo sources = ListAllSourcesClient.listAllSources();
        List<Source.SourceInfo> sourceInfoList = sources.getSourceInfoList();

        for (Source.SourceInfo sourceInfo : sourceInfoList) {
            long sourceId = sourceInfo.getSourceId().getValue();
            for (Dcts.Topic topic : sourceInfo.getTopicsList()) {
                String topicStr = topic.getValue();
                if (!topicStr.equals("")) {
                    System.out.println("sourceId: " + sourceId);
                    System.out.println("key: " + topic.getKey());
                    System.out.println("value: " + topicStr);
                    System.out.println("topicStr:" + topicStr);
                    // 执行订阅
                    subscribeDevice(sourceId, topicStr);

                    // 为每个订阅安排单独的取消任务
//                    Executors.newSingleThreadScheduledExecutor().schedule(() -> {
//                        unsubscribeDevice(sourceId, topicStr);
//                    }, 400, TimeUnit.SECONDS);
                }
            }
        }

        // 主线程保持运行
        // new CountDownLatch(1).await();

        // 启动后台线程，每 2 秒检查 activeStreams 是否为空
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            if (activeStreams.isEmpty()) {
                System.out.println("所有订阅已取消，程序即将退出...");
                System.exit(0);  // 安全退出程序
            }
        }, 5, 2, TimeUnit.SECONDS);  // 初始5秒后开始，每2秒检查一次
    }


    /**
     * 发起设备任务订阅
     */
    public static void subscribeDevice(long sourceId, String topicStr) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6161).usePlaintext().build();
        SourceControlServiceGrpc.SourceControlServiceStub stub = SourceControlServiceGrpc.newStub(channel);

        // 构建订阅请求
        Source.SubscribeRequest request = Source.SubscribeRequest.newBuilder()
                .setSourceId(Source.SourceId.newBuilder().setValue((int) sourceId))
                .setTopic(zb.dcts.Dcts.Topic.newBuilder().setValue(topicStr))
                .build();

        String streamStr = sourceId + "-" + topicStr;
        DeviceStreamObserver observer = new DeviceStreamObserver(sourceId, topicStr, channel);
        activeStreams.put(streamStr, new StreamControl(channel, observer));

        stub.subscribeSourceMessage(request, observer);
        System.out.printf("已订阅: [%s] 任务: %s%n", sourceId, topicStr);
    }

    /**
     * 取消订阅某个设备某个 topic
     */
    public static void unsubscribeDevice(long sourceId, String topicStr) {
        String streamKey = sourceId + "-" + topicStr;
        StreamControl control = activeStreams.remove(streamKey);
        if (control != null) {
            System.out.printf("取消订阅: [%s] 任务: %s%n", sourceId, topicStr);
            control.observer.complete();
        } else {
            System.out.printf("无法取消：未找到订阅 [%s-%s]%n", sourceId, topicStr);
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
        private final long sourceId;
        private final String topicKey;
        private final ManagedChannel channel;
        private volatile boolean active = true;

        public DeviceStreamObserver(long sourceId, String topicKey, ManagedChannel channel) {
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
                // 尝试将 Any 解包为 SignalLayerSurvey 类型
                Detection.SignalLayerSurvey sigSurvey = value.unpack(Detection.SignalLayerSurvey.class);

                System.out.printf("[%s/%s] 收到任务数据（FixSignalList）:%n", sourceId, topicKey);
                for (Detection.SignalDigest signalDigest : sigSurvey.getFixSignalListList()) {
                    double freqMHz = signalDigest.getCenterFreq().getMean() / 1e6;
                    double bandwidthKHz = signalDigest.getBandWidth().getMean() / 1e3;
                    double azimuthDeg = signalDigest.getDirOfArrival().getAzimuth();
                    System.out.printf(" -> 频率: %.3f MHz, 带宽: %.3f kHz, DOA方位: %.2f°%n", freqMHz, bandwidthKHz, azimuthDeg);
                }
            } catch (InvalidProtocolBufferException e) {
                System.err.printf("[%s/%s] 消息解析失败: %s%n", sourceId, topicKey, e.getMessage());
            }
        }

        @Override
        public void onError(Throwable t) {
            System.err.printf("[%s/%s] 订阅异常: %s%n", sourceId, topicKey, t.getMessage());
            complete();
        }

        @Override
        public void onCompleted() {
            System.out.printf("[%s/%s] 订阅结束%n", sourceId, topicKey);
            complete();
        }
    }
}

