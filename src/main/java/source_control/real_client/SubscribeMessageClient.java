package source_control.real_client;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import zb.dcts.Dcts;
import zb.dcts.aeronaval.Aeronaval;
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
            System.out.println("数据源经纬度:" + sourceInfo.getPosition().getLatitude() + ", " + sourceInfo.getPosition().getLongitude());
            for (Dcts.Topic topic : sourceInfo.getTopicsList()) {
                String topicStr = topic.getValue();
                if (!topicStr.equals("")) {
                    System.out.println("sourceId: " + String.format("%x", sourceId));
                    System.out.println("key: " + topic.getKey());
                    System.out.println("value: " + topicStr);
                    System.out.println("topicStr:" + topicStr);
                    // 执行订阅
                    subscribeDevice(sourceId,topicStr);
//                    subscribeDevice(1539162205, "Source#5bbdc05d#SignalDigest");
                    // 该源没有在总线发布数据
//                    subscribeDevice(434984621, "Source#19ed56ad#SignalDigest");

                //     为每个订阅安排单独的取消任务
                //    Executors.newSingleThreadScheduledExecutor().schedule(() -> {
                //        unsubscribeDevice(sourceId, topicStr);
                //    }, 400, TimeUnit.SECONDS);
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
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.1.21", 6161).usePlaintext().build();
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

        private void handleSignalLayerSurvey(Detection.SignalLayerSurvey sigSurvey) {
            System.out.println(sigSurvey);
            // 处理定频信号列表
            if (sigSurvey.getFixSignalListCount() != 0) {
//                System.out.printf("源：[%s]， 主题为[%s]的定频数据（FixSignalList）:%n", sigSurvey.getResultFrom().getValue(), topicKey);
//                System.out.printf("源：[%s]，位置[%s,%s]，主题为[%s]的定频数据（FixSignalList）:%n", sourceId,
//                        sigSurvey.getPosition().getLatitude(),sigSurvey.getPosition().getLongitude(),
//                        topicKey);
                for (Detection.SignalDigest signalDigest : sigSurvey.getFixSignalListList()) {
                    double freqMHz = signalDigest.getCenterFreq().getMean() / 1e6;
                    double bandwidthKHz = signalDigest.getBandWidth().getMean() / 1e6;
                    double azimuthDeg = signalDigest.getDirOfArrival().getAzimuth();
//                    System.out.printf(" -> 频率: %.3f MHz, 带宽: %.3f MHz, DOA方位: %.2f°%n", freqMHz, bandwidthKHz, azimuthDeg);
                }
            }

            // 处理跳频信号列表
            if (sigSurvey.getHopSignalListCount() != 0) {
                System.out.printf("[%s/%s] 收到跳频数据（HopSignalList）:%n", sourceId, topicKey);
                for (Detection.HopSignalCluster cluster : sigSurvey.getHopSignalListList()) {
                    System.out.printf("-> [跳频] 系统名称: %s, 活跃度: %s%n", cluster.getName(), cluster.getActivity().name());

                    String emitStart = cluster.getEmitTimeSpan().getStartTime().getSeconds() + "s";
                    String emitEnd = cluster.getEmitTimeSpan().getStopTime().getSeconds() + "s";
                    System.out.printf("发射时间段: [%s ~ %s]%n", emitStart, emitEnd);

                    for (Detection.HopSignalDigest hopSignal : cluster.getFreqSetList()) {
                        double cfMHz = hopSignal.getCenterFreq().getMean() / 1e6;
                        double bwKHz = hopSignal.getBandWidth().getMean() / 1e6;
                        double amp = hopSignal.getAmplitude().getMean(); // 单位 dBm
                        System.out.printf("-> 跳频频点: 频率: %.3f MHz, 带宽: %.3f MHz, 幅度: %.2f dBm%n", cfMHz, bwKHz, amp);
                    }
                }
            }
        }

        private void handleTarget(Aeronaval.Target target) {
            System.out.printf("[%s/%s] 收到Target信息:%n", sourceId, topicKey);

            System.out.printf(" ->时间: %s 目标ID: %d, 名称: %s, 域: %s, 阵营: %s, 类型: %s%n",
                    target.getTime().getSeconds(),
                    target.getId(),
                    target.getName(),
                    target.getAirSpace().name(),
                    target.getCamp().name(),
                    target.getEquType().name());

            // 位置信息
            Dcts.Position pos = target.getPosition();
            System.out.printf("位置: 经度 %.2f°, 纬度 %.2f°, 高度 %.2f m%n",
                    pos.getLongitude(),
                    pos.getLatitude(),
                    pos.getAltitude());

            // 姿态信息
            Dcts.Posture posture = target.getPosture();
            System.out.printf("姿态: 航向 %.2f°, 俯仰 %.2f°, 横滚 %.2f°%n",
                    posture.getYaw(),
                    posture.getPitch(),
                    posture.getRoll());

            // 速度信息
            Aeronaval.Velocity vel = target.getVelocity();
            System.out.printf("速度: 东 %.2f m/s, 北 %.2f m/s, 天 %.2f m/s%n",
                    vel.getEastVelocity(), vel.getNorthVelocity(), vel.getVerticalVelocity());
        }

        @Override
        public void onNext(Any value) {
            if (!active) return;
            try {
                String typeUrl = value.getTypeUrl();
                if (typeUrl.endsWith("SignalLayerSurvey")) {
                    Detection.SignalLayerSurvey sigSurvey = value.unpack(Detection.SignalLayerSurvey.class);
                    handleSignalLayerSurvey(sigSurvey);
                } else if (typeUrl.endsWith("Target")) {
                    Aeronaval.Target target = value.unpack(Aeronaval.Target.class);
//                    handleTarget(target);
                } else {
                    System.out.printf("[%s/%s] 未识别的消息类型: %s%n", sourceId, topicKey, typeUrl);
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
            channel.shutdown();
            complete();
        }
    }
}