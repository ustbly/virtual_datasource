package gRPC.source_control.client_real;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import zb.dcts.source.Source;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author 林跃
 * @file ListAllSourcesClient.java
 * @comment 同步请求设备信息
 * @date 2025/4/23
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class ListAllSourcesClient {
    public static void main(String[] args) throws InterruptedException {
        Source.SourceSetInfo sources = listAllSources();
//        System.out.println(sources);
    }

    public static Source.SourceSetInfo listAllSources() throws InterruptedException {
        Source.SourceSetInfo sources = null;
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
            sources = stub.listAllSources(Empty.newBuilder().build());
            for (Source.SourceInfo sourceInfo : sources.getSourceInfoList()) {
                System.out.println("数据源ID:" + String.format("%x", sourceInfo.getSourceId().getValue()));
                // System.out.println("数据源ID:" + sourceInfo.getSourceId().getValue());
                System.out.println("数据源类型:" + sourceInfo.getType());
                System.out.println("数据源能力（二进制）: 0b" + String.format("%2s", Integer.toBinaryString(sourceInfo.getCapability().getCapability())).replace(' ', '0'));
                System.out.println("数据源状态:" + sourceInfo.getStatus());
                System.out.println("数据源位置:" + sourceInfo.getPosition());
                System.out.println("数据源指标:" + sourceInfo.getMetrics());
                System.out.println("数据源主题:" + sourceInfo.getTopicsList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        }, 0, 3, TimeUnit.SECONDS); // 3秒一次请求一次设备状态数据

        return sources;
    }
}

