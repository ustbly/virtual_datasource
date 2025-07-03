package source_control.real_server;

import com.google.protobuf.Any;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import mock_data.TargetSignalProcessor;
import org.zeromq.ZMQ;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
import zb.dcts.fusion.fusiondata.Fusion;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @file FusionDataServiceImpl.java
 * @comment 获取融合后数据的gRPC服务器端实现
 * @date 2025/7/1
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class FusionDataServiceImpl extends zb.dcts.fusion.fusiondata.FusionDataControlServiceGrpc.FusionDataControlServiceImplBase {

    private final ExecutorService listenerPool = Executors.newCachedThreadPool();
    private static final String ZMQ_ADDRESS = "tcp://localhost:5560";

    public FusionDataServiceImpl() {
        TargetSignalProcessor processor = new TargetSignalProcessor();
        processor.start();
    }

    @Override
    public void subscribeFusionData(Fusion.FusionDataRequest request, StreamObserver<Any> responseObserver) {
        String topic = request.getTopic().trim();
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

                    Any any = null;
                    try {
                        switch (topic) {
                            case "Fusion_AirDomain":
                                TargetOuterClass.CombinedMessage airMsg = TargetOuterClass.CombinedMessage.parseFrom(payload);
                                any = Any.pack(airMsg);
                                break;
                            case "Fusion_FreqDomain":
                                // var freqMsg = SpectrumOuterClass.SpectrumFusionMessage.parseFrom(payload);
                                // any = Any.pack(freqMsg);
                                break;
                            case "Fusion_NetDomain":
                                // var netMsg = CyberOuterClass.CyberFusionMessage.parseFrom(payload);
                                // any = Any.pack(netMsg);
                                break;
                            default:
                                System.err.println("[错误] 不支持的订阅主题：" + topic);
                                return;
                        }

                        if (!cancelled[0] && any != null) {
                            responseObserver.onNext(any);
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
