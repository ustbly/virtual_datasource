package gRPC.test;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GRPCServer {
    private static final int port = 9999;

    public static void main(String[] args) throws IOException, InterruptedException {
        //设置service端口
        Server server = ServerBuilder.forPort(port)
                .addService(new RPCDateServiceImpl())
                .build().start();
        System.out.println(String.format("GRpc服务端启动成功, 端口号: %d.", port));
        server.awaitTermination();
    }
}
