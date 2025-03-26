package gRPC.test;

import io.grpc.stub.StreamObserver;
import proto_compile.RPCDateServiceApi;
import proto_compile.RPCDateServiceGrpc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RPCDateServiceImpl extends RPCDateServiceGrpc.RPCDateServiceImplBase {
    @Override
    public void getDate(RPCDateServiceApi.RPCDateRequest request, StreamObserver<RPCDateServiceApi.RPCDateResponse> responseObserver) {
        //请求结果，我们定义的
        RPCDateServiceApi.RPCDateResponse rpcDateResponse = null;
        //
        String userName = request.getUserName();
        String response = String.format("你好:%s,今天是%s.", userName, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        try {
            // 定义响应,是一个builder构造器.
            rpcDateResponse = RPCDateServiceApi.RPCDateResponse.newBuilder()
                    .setServerDate(response)
                    .build();
            //int i = 10/0;
        } catch (Exception e) {
            responseObserver.onError(e);
        } finally {
            responseObserver.onNext(rpcDateResponse);
        }

        responseObserver.onCompleted();
    }
}
