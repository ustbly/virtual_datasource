package source_control.real_client;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import zb.dcts.source.Source;
import zb.dcts.source.SourceControlServiceGrpc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
        for (Source.SourceInfo sourceInfo : sources.getSourceInfoList()) {
            System.out.println("数据源ID:" + String.format("%x", sourceInfo.getSourceId().getValue()));
            System.out.println("数据源类型:" + sourceInfo.getType());
//            System.out.println("数据源能力（二进制）: 0b" + String.format("%2s", Integer.toBinaryString(sourceInfo.getCapability().getCapability())).replace(' ', '0'));
//            System.out.println("数据源属性:" + sourceInfo.getAttribute());
            System.out.println("数据源经纬度:" + sourceInfo.getPosition().getLatitude() + ", " + sourceInfo.getPosition().getLongitude());
            System.out.println("数据源状态:" + sourceInfo.getStatus());
            sourceInfo.getTopicsList().forEach(topic -> {
                System.out.println("数据源主题[key]:" + topic.getKey() + ", [value]:" + topic.getValue());
            });
        }
//        listAllSourcesPeriodical();
    }

    /**
     * 调用一次服务端返回所有数据源信息
     * @return  源信息列表
     * @throws InterruptedException
     */
    public static Source.SourceSetInfo listAllSources() throws InterruptedException {
        Source.SourceSetInfo sources = null;
        // 连接 gRPC 服务器
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6161)
        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.1.40", 6161)
                .usePlaintext()
                .build();

        // 创建 Stub
        SourceControlServiceGrpc.SourceControlServiceBlockingStub stub = SourceControlServiceGrpc.newBlockingStub(channel);
        try {
            sources = stub.listAllSources(Empty.newBuilder().build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sources;
    }


    /**
     * 每3秒定时调用一次服务端获取数据源信息
     */
    public static void listAllSourcesPeriodical() {
        // 连接 gRPC 服务器
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6161)
        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.1.40", 6161)
                .usePlaintext()
                .build();

        // 创建 Stub
        SourceControlServiceGrpc.SourceControlServiceBlockingStub stub = SourceControlServiceGrpc.newBlockingStub(channel);

        // 创建定时任务调度器
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

        // 定义每 3 秒调用一次服务端获取数据
        scheduler.scheduleWithFixedDelay(() -> {
            try {
                Source.SourceSetInfo sources = stub.listAllSources(Empty.newBuilder().build());
                for (Source.SourceInfo sourceInfo : sources.getSourceInfoList()) {
                    System.out.println("数据源ID:" + String.format("%x", sourceInfo.getSourceId().getValue()));
//                 System.out.println("数据源ID:" +  sourceInfo.getSourceId().getValue());
                    System.out.println("数据源类型:" + sourceInfo.getType());
//                System.out.println("数据源能力（二进制）: 0b" + String.format("%2s", Integer.toBinaryString(sourceInfo.getCapability().getCapability())).replace(' ', '0'));
//                System.out.println("数据源属性:" + sourceInfo.getAttribute());
                    System.out.println("数据源状态:" + sourceInfo.getStatus());
//                System.out.println("数据源位置:" + sourceInfo.getPosition());
//                System.out.println("数据源指标:" + sourceInfo.getMetrics());
//                System.out.println("数据源主题:" + sourceInfo.getTopicsList());
                    sourceInfo.getTopicsList().forEach(topic -> {
                        System.out.println("数据源主题[key]:" + topic.getKey() + ", [value]:" + topic.getValue());
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 3, TimeUnit.SECONDS); // 3秒一次请求一次设备状态数据
    }
}

