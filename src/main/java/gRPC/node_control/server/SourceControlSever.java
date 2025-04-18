package gRPC.node_control.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class SourceControlSever {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50050)
                .addService(new SourceControlServiceImpl())
                .build()
                .start();

        System.out.println("gRPC 服务器已启动，端口: 50050");
        server.awaitTermination();
    }
}
