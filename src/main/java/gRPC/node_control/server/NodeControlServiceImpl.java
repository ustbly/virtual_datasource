package gRPC.node_control.server;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.*;
import datasource.DataSource;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceGrpc;
import service.NodeControlService;
import utils.DeviceMapUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;


public class NodeControlServiceImpl extends NodeControlServiceGrpc.NodeControlServiceImplBase {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);
    private final Map<StreamObserver<Any>, ScheduledFuture<?>> streamTasks = new ConcurrentHashMap<>();

    @Override
    public void subscribeSourceMessage(NodeControlServiceApi.SubscribeRequest request,
                                       StreamObserver<Any> responseObserver) {
        String deviceId = request.getDeviceId().getValue();
        String topicKey = request.getTopic().getKey();
        String topicValue = request.getTopic().getValue();

        System.out.printf("新订阅请求: 设备=%s 主题=%s/%s%n", deviceId, topicKey, topicValue);

        Context ctx = Context.current();

        // 发送数据的定时任务
        ScheduledFuture<?> task = scheduler.scheduleAtFixedRate(() -> {
            if (ctx.isCancelled()) {
                System.out.printf("[%s] 客户端取消订阅，停止数据发送%n", deviceId);
                cancelStream(responseObserver);
                return;
            }
            String msg = String.format("[%s] %s/%s 数据: %d", deviceId, topicKey, topicValue, System.currentTimeMillis() % 1000);
            Any data = Any.pack(StringValue.of(msg));
            try {
                responseObserver.onNext(data);
            } catch (Exception e) {
                cancelStream(responseObserver);
            }
        }, 0, 2, TimeUnit.SECONDS);

        streamTasks.put(responseObserver, task);

        // 监听上下文取消事件
        ctx.addListener(c -> {
            System.out.printf("[%s] 检测到上下文取消%n", deviceId);
            cancelStream(responseObserver);
        }, MoreExecutors.directExecutor());
    }

    private void cancelStream(StreamObserver<Any> observer) {
        ScheduledFuture<?> task = streamTasks.remove(observer);
        if (task != null) {
            task.cancel(true);
        }
        try {
            observer.onCompleted();
        } catch (Exception ignored) {
        }
    }



    /**
     * 订阅所有设备的任务数据
     * @param request
     * @param responseObserver
     */
//    @Override
//    public void subscribeSourceMessage(NodeControlServiceApi.SubscribeRequest request,
//                                       StreamObserver<Any> responseObserver) {
//
//        String deviceId = request.getDeviceId().getValue();
//        String topicKey = request.getTopic().getKey();
//        String topicValue = request.getTopic().getValue();
//
//        System.out.println("客户端订阅了设备: " + deviceId + "，主题: " + topicKey + "=" + topicValue);
//
//        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
//            try {
//                String message = "设备 " + deviceId + " 发送的模拟消息，主题: " + topicKey + "=" + topicValue;
//                Any anyMsg = Any.pack(StringValue.of(message));
//                responseObserver.onNext(anyMsg);
//            } catch (Exception e) {
//                responseObserver.onError(e);
//            }
//        }, 0, 3, TimeUnit.SECONDS);
//    }


    /**
     * 获取所有设备的信息
     *
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
     *
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

        NodeControlServiceApi.CommandReply commandReply = NodeControlService.sendSourceCommand(device_id, commandFunction, commandParam);
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
