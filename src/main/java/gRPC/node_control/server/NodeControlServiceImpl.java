package gRPC.node_control.server;

import com.google.protobuf.*;
import datasource.DataSource;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceGrpc;
import service.NodeControlService;
import utils.DeviceMapUtils;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class NodeControlServiceImpl extends NodeControlServiceGrpc.NodeControlServiceImplBase {

    /**
     * 订阅所有设备的任务数据
     * @param request
     * @param responseObserver
     */
    @Override
    public void subscribeSourceMessage(NodeControlServiceApi.SubscribeRequest request,
                                       StreamObserver<Any> responseObserver) {

        String deviceId = request.getDeviceId().getValue();
        String topicKey = request.getTopic().getKey();
        String topicValue = request.getTopic().getValue();

        System.out.println("客户端订阅了设备: " + deviceId + "，主题: " + topicKey + "=" + topicValue);

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            try {
                String message = "设备 " + deviceId + " 发送的模拟消息，主题: " + topicKey + "=" + topicValue;
                Any anyMsg = Any.pack(StringValue.of(message));
                responseObserver.onNext(anyMsg);
            } catch (Exception e) {
                responseObserver.onError(e);
            }
        }, 0, 3, TimeUnit.SECONDS);
    }


    /**
     * 获取所有设备的信息
     * @param request
     * @param responseObserver
     */
    @Override
    public void listAllNodes(Empty request, StreamObserver<NodeControlServiceApi.NodesInfo> responseObserver) {

//        List<NodeControlServiceApi.NodeInfo> nodeInfos = ListAllNodes.readNodesFromJson("src/main/resources/nodes.json");
        List<NodeControlServiceApi.NodeInfo> nodeInfos = NodeControlService.getNodesInfo();
//        System.out.println(nodeInfos);

        // 构建 NodesInfo
        // 返回响应
        NodeControlServiceApi.NodesInfo response = NodeControlServiceApi.NodesInfo.newBuilder()
                .addAllNodeInfos(nodeInfos)
                .build();
        responseObserver.onNext(response);
        System.out.println("收到请求，开始处理...");
        // 处理请求
        responseObserver.onCompleted();
    }

    /**
     * 向设备发送控制指令
     * @param request
     * @param responseObserver
     */
    @Override
    public void sendSourceCommand(NodeControlServiceApi.SourceCommand request, StreamObserver<NodeControlServiceApi.SourceCommandReply> responseObserver) throws InvalidProtocolBufferException {
        // 获取客户端请求参数
        String device_id = request.getDeviceId().getValue();

        NodeControlServiceApi.Command command = request.getCommand();
        int commandFunction = command.getCommandFunction();
        long commandParam = command.getCommandParam().unpack(DCTSServiceApi.Integer.class).getValue();

        System.out.println("接收到的客户端的参数为：device_id: " + device_id + ", command_function: " + commandFunction + " ,command_param: " + commandParam);

        NodeControlServiceApi.CommandReply commandReply = NodeControlService.sendSourceCommand(device_id,commandFunction,commandParam);
        // 模拟执行命令
        NodeControlServiceApi.SourceCommandReply response = NodeControlServiceApi.SourceCommandReply.newBuilder()
                .setDeviceId(request.getDeviceId())
                .setReply(commandReply)
                .build();

        responseObserver.onNext(response);
        System.out.println("收到请求，开始处理...");
        // 处理请求
        responseObserver.onCompleted();
    }
}
