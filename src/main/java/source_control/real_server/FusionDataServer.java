package source_control.real_server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @file FusionDataSever.java
 * @comment 获取融合后数据的gRPC服务器启动程序入口
 * @date 2025/7/1
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class FusionDataServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50050)
                .addService(new FusionDataServiceImpl())
                .build()
                .start();

        System.out.println("gRPC 服务器已启动，端口: 50050");
        server.awaitTermination();
    }
}
