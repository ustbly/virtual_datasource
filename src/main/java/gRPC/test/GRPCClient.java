package gRPC.test;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto_compile.RPCDateServiceApi;
import proto_compile.RPCDateServiceGrpc;

public class GRPCClient {
    private static final String host = "localhost";
    private static final int serverPort = 9999;
    public static void main(String[] args) {
        //1,拿到一个通信channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, serverPort).
                usePlaintext()//无需加密或认证
                .build();
        try {
            //2.拿到stub对象
            RPCDateServiceGrpc.RPCDateServiceBlockingStub rpcDateService = RPCDateServiceGrpc.newBlockingStub(channel);
            RPCDateServiceApi.RPCDateRequest rpcDateRequest = RPCDateServiceApi.RPCDateRequest.newBuilder()
                    .setUserName("JACK")
                    .build();
            //3,请求
            RPCDateServiceApi.RPCDateResponse rpcDateResponse = rpcDateService.getDate(rpcDateRequest);
            //4,输出结果
            System.out.println(rpcDateResponse.getServerDate());
        } finally {
            // 5.关闭channel, 释放资源.
            channel.shutdown();
        }

    }
}
