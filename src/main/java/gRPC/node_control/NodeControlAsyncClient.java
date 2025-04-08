package gRPC.node_control;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceGrpc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NodeControlAsyncClient {

    public static void main(String[] args) {
        // 创建 gRPC 连接通道
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050)
                .usePlaintext() // 不使用 TLS
                .build();

        // 创建异步 Stub
        NodeControlServiceGrpc.NodeControlServiceStub asyncStub = NodeControlServiceGrpc.newStub(channel);

        // 定时任务调度器：每 2 秒发送一次请求
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("发送异步请求...");
            asyncStub.listAllNodes(Empty.newBuilder().build(), new StreamObserver<NodeControlServiceApi.NodesInfo>() {
                @Override
                public void onNext(NodeControlServiceApi.NodesInfo response) {
                    System.out.println("接收到响应:");
                    System.out.println(response);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("请求失败: " + t.getMessage());
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    System.out.println("调用完成\n");
                }
            });
        }, 0, 2, TimeUnit.SECONDS);

        // 保持主线程活跃
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("关闭客户端连接...");
            channel.shutdown();
            scheduler.shutdown();
        }));

        try {
            Thread.currentThread().join(); // 阻塞主线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
