package gRPC.node_control;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class NodeControlSever {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50050)
                .addService(new NodeControlServiceImpl())
                .build()
                .start();

        System.out.println("gRPC 服务器已启动，端口: 50050");
        server.awaitTermination();
    }
}
