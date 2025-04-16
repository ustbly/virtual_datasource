package gRPC.node_control.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import com.google.protobuf.Any;
import com.google.protobuf.StringValue;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceGrpc;

import java.util.concurrent.CountDownLatch;

public class SubscribeMessageClient {

    public static void main(String[] args) throws InterruptedException {
        // 创建 gRPC 通道和 stub
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050)
                .usePlaintext()  // 禁用加密
                .build();

        NodeControlServiceGrpc.NodeControlServiceStub stub = NodeControlServiceGrpc.newStub(channel);

        // 创建订阅请求
        NodeControlServiceApi.SubscribeRequest request = NodeControlServiceApi.SubscribeRequest.newBuilder()
                .setDeviceId(NodeControlServiceApi.DeviceId.newBuilder().setValue("Device_01"))
                .setTopic(DCTSServiceApi.Topic.newBuilder().setKey("signal_list").build())
                .build();

        // 使用 CountDownLatch 来等待客户端接收到消息
        CountDownLatch latch = new CountDownLatch(1);

        // 订阅数据并处理
        stub.subscribeSourceMessage(request, new StreamObserver<Any>() {
            @Override
            public void onNext(Any any) {
                try {
                    StringValue value = any.unpack(StringValue.class);
                    System.out.println("[客户端] 收到数据: " + value.getValue());
                } catch (Exception e) {
                    System.err.println("解析失败: " + e.getMessage());
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("错误: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("订阅完成");
                latch.countDown();  // 完成时调用 latch，表示结束
            }
        });

        // 等待消息接收
        System.out.println("等待接收数据...");
        latch.await();  // 等待 onCompleted 或 onError 调用，确保主线程在此处阻塞直到完成

        // 关闭通道
        channel.shutdown();
    }
}
