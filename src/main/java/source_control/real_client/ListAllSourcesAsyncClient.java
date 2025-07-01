package source_control.real_client;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import zb.dcts.source.Source;
import zb.dcts.source.SourceControlServiceGrpc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @file ListAllSourcesAsyncClient.java
 * @comment 异步请求设备信息
 * @date 2025/4/23
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class ListAllSourcesAsyncClient {

    public static void main(String[] args) {
        // 创建 gRPC 连接通道
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6161)
                .usePlaintext() // 不使用 TLS
                .build();

        // 创建异步 Stub
        SourceControlServiceGrpc.SourceControlServiceStub asyncStub = SourceControlServiceGrpc.newStub(channel);

        // 定时任务调度器：每 2 秒发送一次请求
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("发送异步请求...");
            asyncStub.listAllSources(Empty.newBuilder().build(), new StreamObserver<Source.SourceSetInfo>() {
                @Override
                public void onNext(Source.SourceSetInfo response) {
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
