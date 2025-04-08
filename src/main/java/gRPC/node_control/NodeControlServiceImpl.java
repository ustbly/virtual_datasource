package gRPC.node_control;

import com.google.protobuf.Empty;
import datasource.DataSource;
import io.grpc.stub.StreamObserver;
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


    @Override
    public void getNodeInfo(NodeControlServiceApi.NodeId request, StreamObserver<NodeControlServiceApi.NodeInfo> responseObserver) {
        List<NodeControlServiceApi.NodeInfo> nodeInfos = ListAllNodes.readNodesFromJson("src/main/resources/nodes.json");

        // 构建 NodesInfo
        // 返回响应

    }
}
