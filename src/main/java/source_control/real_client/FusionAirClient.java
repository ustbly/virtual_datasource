package source_control.real_client;

import com.google.protobuf.Any;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import utils.MessageAndJsonUtil;
import zb.dcts.Dcts;
import zb.dcts.source.Source;
import zb.dcts.source.SourceControlServiceGrpc;

/**
 * @author 林跃
 * @file FusionAirClient.java
 * @comment 订阅融合数据空域的测试客户端
 * @date 2025/7/01
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class FusionAirClient {

    public static void main(String[] args) throws InterruptedException {
        // 1. 建立 gRPC 连接（localhost:50050 为服务地址）
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50050)
                .usePlaintext()
                .build();

        SourceControlServiceGrpc.SourceControlServiceStub stub = SourceControlServiceGrpc.newStub(channel);

        // 2. 构造请求（订阅 "Fusion_AirDomain/Fusion_NetDomain"）
        Source.SubscribeRequest request = Source.SubscribeRequest.newBuilder()
                .setTopic(
                        Dcts.Topic.newBuilder()
                                .setKey("")
                                .setValue("Fusion_AirDomain")
                                .build()
                )
                .build();

        // 3. 发起订阅
        stub.subscribeSourceMessage(request, new StreamObserver<Any>() {
            @Override
            public void onNext(Any value) {
                try {
//                    if (value.is(TargetOuterClass.CombinedMessage.class)) {
//                        TargetOuterClass.CombinedMessage cm = value.unpack(TargetOuterClass.CombinedMessage.class);
//                        System.out.printf("[✓] 接收到 CombinedMessage：%s%n", cm);
//                    } else {
//                        System.out.println("[×] 未识别的消息类型");
//                    }

                    // 解包 Any 类型的消息
                    String json = MessageAndJsonUtil.parseAnyToJson(value);
                    System.out.println("解析结果: \n" + json);
                } catch (Exception e) {
                    System.err.println("[异常] 解包失败：" + e.getMessage());
                }
            }

            // 处理错误
            @Override
            public void onError(Throwable t) {
                System.err.println("[客户端错误] " + t.getMessage());
            }

            // 处理完成事件
            @Override
            public void onCompleted() {
                System.out.println("[完成] 服务端已关闭连接");
            }
        });

        // 阻塞主线程，防止退出
        Thread.currentThread().join();
    }
}
