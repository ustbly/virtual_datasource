package gRPC.node_control;

import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.InvalidProtocolBufferException;
import datasource.DataSource;
import io.grpc.stub.StreamObserver;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceGrpc;
import service.ListAllNodes;
import utils.DeviceMapUtils;

import java.util.List;


public class NodeControlServiceImpl extends NodeControlServiceGrpc.NodeControlServiceImplBase {
    @Override
    public void postNodeControl(NodeControlServiceApi.NodeControl request, StreamObserver<NodeControlServiceApi.NodeControlResponse> responseObserver) {


        String nodeId = request.getNodeId().getValue();
        String deviceId = request.getDeviceId().getValue();
        NodeControlServiceApi.NodeControlType type = request.getControlType();
        String detail = request.getDetail();

        // 获取设备唯一标识node_device_id
        String key = nodeId + "-" + deviceId;
        DataSource ds = DeviceMapUtils.getSpecificDevice(key);
        System.out.println(ds);



        // 执行设备控制逻辑
        String message;
        boolean success;

        if (ds != null) {
            message = ds.executeCommand(type,detail);
            success = true;
        } else {
            message = "未知设备 ID: " + nodeId;
            success = false;
        }

        System.out.println("执行操作: " + message);

        // 返回响应
        NodeControlServiceApi.NodeControlResponse response = NodeControlServiceApi.NodeControlResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    /**
     * 获取所有设备的信息
     * @param request
     * @param responseObserver
     */
    @Override
    public void listAllNodes(Empty request, StreamObserver<NodeControlServiceApi.NodesInfo> responseObserver) {

//        List<NodeControlServiceApi.NodeInfo> nodeInfos = ListAllNodes.readNodesFromJson("src/main/resources/nodes.json");
        List<NodeControlServiceApi.NodeInfo> nodeInfos = ListAllNodes.getNodesInfo();
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

        // 模拟执行命令
        NodeControlServiceApi.CommandReply commandReply = NodeControlServiceApi.CommandReply.newBuilder()
                .setErrorCode(DCTSServiceApi.ErrorType.ERR_ABORTED)
                .setAttachment(Any.getDefaultInstance())  // 可根据需求填充
                .build();

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
