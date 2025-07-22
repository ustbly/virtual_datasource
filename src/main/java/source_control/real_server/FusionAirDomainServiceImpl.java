package source_control.real_server;

import com.google.protobuf.Any;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import link_alone.FusionMatcherByGRPC;
import org.zeromq.ZMQ;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
import zb.dcts.source.Source;
import zb.dcts.source.SourceControlServiceGrpc;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 林跃
 * @file FusionDataServiceImpl.java
 * @comment 获取融合后数据的gRPC服务器端实现
 * @date 2025/7/1
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class FusionAirDomainServiceImpl extends SourceControlServiceGrpc.SourceControlServiceImplBase {
    private static final FusionMatcherByGRPC matcher = new FusionMatcherByGRPC();
    private final ExecutorService listenerPool = Executors.newCachedThreadPool();
    private static final String ZMQ_ADDRESS = "tcp://localhost:5560";

    public FusionAirDomainServiceImpl() {
//        TargetSignalProcessor processor = new TargetSignalProcessor();
//        processor.start();

//        FusionMatcher fusionMatcher = new FusionMatcher();
//        fusionMatcher.start();
    }

    static {
        try {
            matcher.start(); // 启动一次即可
        } catch (Exception e) {
            System.err.println("FusionMatcherByGRPC 启动失败: " + e.getMessage());
        }
    }

    @Override
    public void subscribeSourceMessage(Source.SubscribeRequest request, StreamObserver<Any> responseObserver) {
        String topic = request.getTopic().getValue().trim();
        System.out.printf("[订阅请求] 客户端订阅主题: %s%n", topic);

        if (!(responseObserver instanceof ServerCallStreamObserver)) {
            System.err.println("[错误] 非 ServerCallStreamObserver，无法绑定取消监听");
            return;
        }

        ServerCallStreamObserver<Any> serverObserver = (ServerCallStreamObserver<Any>) responseObserver;
        final boolean[] cancelled = {false};

        // 设置取消处理逻辑
        serverObserver.setOnCancelHandler(() -> {
            cancelled[0] = true;
            System.out.printf("[取消订阅] 客户端断开连接，topic = %s%n", topic);
        });

        // 启动 ZMQ 监听线程
        listenerPool.submit(() -> {
            ZMQ.Context context = ZMQ.context(1);
            ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
            subscriber.connect(ZMQ_ADDRESS);
            subscriber.subscribe(topic.getBytes(StandardCharsets.UTF_8));

            try {
                while (!Thread.currentThread().isInterrupted() && !cancelled[0]) {
                    String recvTopic = subscriber.recvStr();
                    byte[] payload = subscriber.recv();

                    Any fusionMsg = null;
                    try {
                        switch (topic) {
                            case "Fusion_AirDomain":
                                TargetOuterClass.FusionTargetList airMsg = TargetOuterClass.FusionTargetList.parseFrom(payload);
                                fusionMsg = Any.pack(airMsg);
                                break;
                            case "Fusion_FreqDomain":
                                // var freqMsg = SpectrumOuterClass.SpectrumFusionMessage.parseFrom(payload);
                                // fusionMsg = Any.pack(freqMsg);
                                break;
                            case "Fusion_NetDomain":
                                // var netMsg = CyberOuterClass.CyberFusionMessage.parseFrom(payload);
                                // fusionMsg = Any.pack(netMsg);
                                break;
                            default:
                                System.err.println("[错误] 不支持的订阅主题：" + topic);
                                return;
                        }

                        if (!cancelled[0] && fusionMsg != null) {
                            responseObserver.onNext(fusionMsg);
                        }
                    } catch (Exception ex) {
                        System.err.printf("[解析/推送异常] topic=%s, err=%s%n", topic, ex.getMessage());
                    }
                }
            } catch (Exception e) {
                System.err.printf("[ZMQ监听异常] topic=%s, err=%s%n", topic, e.getMessage());
            } finally {
                subscriber.close();
                context.term();
                responseObserver.onCompleted();
                System.out.printf("[完成] 关闭订阅线程，topic = %s%n", topic);
            }
        });
    }
}
