package source_control.real_client;

import com.google.protobuf.Any;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;

/**
 * @author 林跃
 * @file FusionDataClient.java
 * @comment 融合数据订阅的测试客户端
 * @date 2025/7/01
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class FusionDataClient {

    public static void main(String[] args) throws InterruptedException {
        // 1. 建立 gRPC 连接（localhost:9090 为服务地址）
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50050)
                .usePlaintext()
                .build();

        zb.dcts.fusion.fusiondata.FusionDataControlServiceGrpc.FusionDataControlServiceStub stub =
                zb.dcts.fusion.fusiondata.FusionDataControlServiceGrpc.newStub(channel);

        // 2. 构造请求（订阅 "Fusion_AirDomain"）
        zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest request = zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest.newBuilder()
                .setTopic("Fusion_AirDomain")
                .build();

        // 3. 发起订阅
        stub.subscribeFusionData(request, new StreamObserver<Any>() {
            @Override
            public void onNext(Any value) {
                try {
                    if (value.is(TargetOuterClass.CombinedMessage.class)) {
                        TargetOuterClass.CombinedMessage cm = value.unpack(TargetOuterClass.CombinedMessage.class);
                        System.out.printf("[✓] 接收到 CombinedMessage：TargetID=%d, Signals=%s%n",
                                cm.getAeronavalTarget().getId(),
                                cm.getSignalLayerSurveysList());
                    } else {
                        System.out.println("[×] 未识别的消息类型");
                    }
                } catch (Exception e) {
                    System.err.println("[异常] 解包失败：" + e.getMessage());
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("[客户端错误] " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("[完成] 服务端已关闭连接");
            }
        });

        // 阻塞主线程，防止退出
        Thread.currentThread().join();
    }
}
