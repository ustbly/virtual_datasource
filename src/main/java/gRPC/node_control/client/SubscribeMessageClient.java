package gRPC.node_control.client;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceGrpc;

public class SubscribeMessageClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        NodeControlServiceGrpc.NodeControlServiceStub asyncStub = NodeControlServiceGrpc.newStub(channel);

        NodeControlServiceApi.SubscribeRequest request = NodeControlServiceApi.SubscribeRequest.newBuilder()
                .setDeviceId(NodeControlServiceApi.DeviceId.newBuilder().setValue("device-001").build())
                .setTopic(DCTSServiceApi.Topic.newBuilder().setKey("status").setValue("active").build())
                .build();

        asyncStub.subscribeSourceMessage(request, new StreamObserver<Any>() {
            @Override
            public void onNext(Any value) {
                try {
                    StringValue message = value.unpack(StringValue.class);
                    System.out.println("收到消息: " + message.getValue());
                } catch (Exception e) {
                    System.err.println("解析消息失败: " + e.getMessage());
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("流错误: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("消息流结束");
            }
        });

        // 阻止 main 线程退出
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
