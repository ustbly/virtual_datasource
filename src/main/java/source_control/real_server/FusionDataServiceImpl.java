package source_control.real_server;

import com.google.protobuf.Any;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import link_alone.FusionMatcherByGRPC;
import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
import zb.dcts.fusion.networkDomain.NetworkDomain;
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
public class FusionDataServiceImpl extends SourceControlServiceGrpc.SourceControlServiceImplBase {
    private static final FusionMatcherByGRPC matcher = new FusionMatcherByGRPC();
    private final ExecutorService listenerPool = Executors.newCachedThreadPool();
    private static final String ZMQ_ADDRESS1 = "tcp://localhost:5560";
    private static final String ZMQ_ADDRESS2 = "tcp://localhost:5561";

    static {
        try {
            matcher.start(); // 启动融合处理器
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

        // 设置取消监听器
        serverObserver.setOnCancelHandler(() -> {
            System.out.printf("[取消订阅] 客户端断开连接，topic = %s%n", topic);
        });

        // 启动 ZMQ 监听线程
        listenerPool.submit(() -> {
            ZMQ.Context context = ZMQ.context(1);
            ZMQ.Socket subscriber = context.socket(SocketType.SUB);

            String zmqAddress;
            switch (topic) {
                case "Fusion_AirDomain":
                    zmqAddress = ZMQ_ADDRESS1;
                    break;
                case "Fusion_NetDomain":
                    zmqAddress = ZMQ_ADDRESS2;
                    break;
                default:
                    System.err.println("[错误] 不支持的订阅主题：" + topic);
                    return;
            }

            subscriber.connect(zmqAddress);
            subscriber.subscribe(topic.getBytes(StandardCharsets.UTF_8));

            try {
                while (!Thread.currentThread().isInterrupted()) {
                    if (serverObserver.isCancelled()) {
                        break;
                    }

                    String recvTopic = subscriber.recvStr();
                    byte[] payload = subscriber.recv();

                    Any fusionMsg;
                    try {
                        switch (topic) {
                            case "Fusion_AirDomain":
//                                System.out.printf("[AirDomain] 收到 ZMQ 消息，长度: %d 字节%n", payload.length);
                                TargetOuterClass.FusionTargetList airMsg = TargetOuterClass.FusionTargetList.parseFrom(payload);
                                fusionMsg = Any.pack(airMsg);
                                break;
                            case "Fusion_NetDomain":
//                                System.out.printf("[NetDomain] 收到 ZMQ 消息，长度: %d 字节%n", payload.length);
                                NetworkDomain.NetworkList netMsg = NetworkDomain.NetworkList.parseFrom(payload);
                                fusionMsg = Any.pack(netMsg);
                                break;
                            default:
                                System.err.println("[错误] 不支持的订阅主题：" + topic);
                                return;
                        }

//                        if (serverObserver.isCancelled()) {
//                            System.out.printf("[终止发送] 客户端不可写或连接取消，跳过发送，topic=%s%n", topic);
//                            break;
//                        }
                        responseObserver.onNext(fusionMsg);

                    } catch (Exception ex) {
                        System.err.printf("[发送失败] topic=%s, err=%s%n", topic, ex.getMessage());
                        break;
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
