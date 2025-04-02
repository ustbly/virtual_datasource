package gRPC.node_control;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceGrpc;

public class NodeControlClient {
    /*
    public static void main(String[] args) {
        // 连接 gRPC 服务器
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050)
                .usePlaintext()
                .build();

        // 创建 Stub
        NodeControlServiceGrpc.NodeControlServiceBlockingStub stub = NodeControlServiceGrpc.newBlockingStub(channel);

        // 构造请求
        NodeControlServiceApi.NodeControl request = NodeControlServiceApi.NodeControl.newBuilder()
                .setNodeId(NodeControlServiceApi.NodeId.newBuilder().setValue("3").build())
                .setDeviceId(NodeControlServiceApi.DeviceId.newBuilder().setValue("39e0ee83").build())
                .setControlType(NodeControlServiceApi.NodeControlType.RENAME)
                .setDetail("device_111")
                .build();

        // 发送请求并获取响应
        NodeControlServiceApi.NodeControlResponse response = stub.postNodeControl(request);
        System.out.println("返回结果: " + response.getMessage());

        // 关闭通道
        channel.shutdown();
    }
    */

    public static void main(String[] args) {
        // 连接 gRPC 服务器
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050)
                .usePlaintext()
                .build();

        // 创建 Stub
        NodeControlServiceGrpc.NodeControlServiceBlockingStub stub = NodeControlServiceGrpc.newBlockingStub(channel);

        NodeControlServiceApi.NodesInfo response = stub.listAllNodes(Empty.newBuilder().build());
        System.out.println("返回结果: " + response.getNodeInfosList());

        // 关闭通道
        channel.shutdown();
    }
}

