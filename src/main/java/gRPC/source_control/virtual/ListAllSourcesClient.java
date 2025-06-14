package gRPC.source_control.virtual;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import zb.dcts.source.Source;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @file ListAllSourcesClient.java
 * @comment 同步请求设备信息
 * @date 2025/4/23
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class ListAllSourcesClient {

    public static void main(String[] args) throws InterruptedException {
        // 连接 gRPC 服务器
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6161)
                .usePlaintext()
                .build();

        // 创建 Stub
        zb.dcts.source.SourceControlServiceGrpc.SourceControlServiceBlockingStub stub = zb.dcts.source.SourceControlServiceGrpc.newBlockingStub(channel);

        // 创建定时任务调度器
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

        // 定义每 3 秒调用一次服务端获取数据
//        scheduler.scheduleWithFixedDelay(() -> {
        try {
            Source.SourceSetInfo response = stub.listAllSources(Empty.newBuilder().build());
            System.out.println("返回的设备状态数据: " + response.getSourceInfoList());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        }, 0, 3, TimeUnit.SECONDS); // 3秒一次请求一次设备状态数据
    }
}

