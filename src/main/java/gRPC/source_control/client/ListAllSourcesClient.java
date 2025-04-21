package gRPC.source_control.client;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto_compile.cetc41.nodecontrol.SourceControlServiceApi;
import proto_compile.cetc41.nodecontrol.SourceControlServiceGrpc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ListAllSourcesClient {

    public static void main(String[] args) throws InterruptedException {
        // 连接 gRPC 服务器
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050)
                .usePlaintext()
                .build();

        // 创建 Stub
        SourceControlServiceGrpc.SourceControlServiceBlockingStub stub = SourceControlServiceGrpc.newBlockingStub(channel);

        // 创建定时任务调度器
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

        // 定义每 3 秒调用一次服务端获取数据
        scheduler.scheduleWithFixedDelay(() -> {
            try {
                SourceControlServiceApi.SourceSetInfo response = stub.listAllSources(Empty.newBuilder().build());
                System.out.println("返回的设备状态数据: " + response.getSourceInfoList());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 3, TimeUnit.SECONDS); // 3秒一次请求一次设备状态数据
    }
}

