package gRPC.node_control;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceGrpc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ListAllNodesClient {
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

    public static void main(String[] args) throws InterruptedException {
        // 连接 gRPC 服务器
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050)
                .usePlaintext()
                .build();

        // 创建 Stub
        NodeControlServiceGrpc.NodeControlServiceBlockingStub stub = NodeControlServiceGrpc.newBlockingStub(channel);

        // 创建定时任务调度器
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

        // 定义每 3 秒调用一次服务端获取数据
        scheduler.scheduleWithFixedDelay(() -> {
            try {
                NodeControlServiceApi.NodesInfo response = stub.listAllNodes(Empty.newBuilder().build());
                System.out.println("返回结果: " + response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 5, TimeUnit.SECONDS); // 延迟 0 秒开始，3 秒执行一次
    }
}

