package gRPC.node_control.server;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;
import org.zeromq.ZMQ;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.SourceControlServiceApi;
import service.SourceControlService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;


public class SourceControlServiceImpl extends proto_compile.cetc41.nodecontrol.SourceControlServiceGrpc.SourceControlServiceImplBase {
    static class SubscriberInfo {
        int deviceId;
        StreamObserver<Any> observer;

        SubscriberInfo(int deviceId, StreamObserver<Any> observer) {
            this.deviceId = deviceId;
            this.observer = observer;
        }
    }


    private final Map<String, List<SubscriberInfo>> activeSubscribers = new ConcurrentHashMap<>();


    public SourceControlServiceImpl() {
        new Thread(this::listenZmq).start();
    }

    @Override
    public void subscribeSourceMessage(SourceControlServiceApi.SubscribeRequest request, StreamObserver<Any> responseObserver) {
        String topicKey = request.getTopic().getKey(); // e.g. "signal_list"
        int deviceId = request.getSourceId().getValue(); // e.g. 1、2、3

        // 添加订阅者
        activeSubscribers.computeIfAbsent(topicKey, k -> new ArrayList<>())
                .add(new SubscriberInfo(deviceId, responseObserver));

        System.out.println("客户端订阅 topic: " + topicKey + "，sourceId: " + deviceId);

        // 客户端断开时移除
        Context.current().addListener(context -> {
            List<SubscriberInfo> list = activeSubscribers.get(topicKey);
            if (list != null) {
                list.removeIf(sub -> sub.observer.equals(responseObserver));
                System.out.println("取消订阅: " + topicKey + " sourceId: " + deviceId);
            }
        }, Executors.newSingleThreadExecutor());
    }

    private void listenZmq() {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5555");
        subscriber.subscribe("".getBytes());

        ObjectMapper mapper = new ObjectMapper();

        while (!Thread.currentThread().isInterrupted()) {
            String topic = subscriber.recvStr(); // e.g. "signal_list"
            String msg = subscriber.recvStr();

            List<SubscriberInfo> subscribers = activeSubscribers.get(topic);
            if (subscribers != null) {
                for (SubscriberInfo sub : subscribers) {
                    try {
                        JsonNode jsonNode = mapper.readTree(msg);
                        int msgDeviceId = jsonNode.get("source_id").asInt();

                        if (sub.deviceId == msgDeviceId) {
                            sub.observer.onNext(Any.pack(StringValue.of(msg)));
                        }
                    } catch (Exception e) {
                        System.err.println("发送失败: " + e.getMessage());
                    }
                }
            }
        }
    }

    /**
     * 获取所有设备的信息
     *
     * @param request
     * @param responseObserver
     */

    @Override
    public void listAllSources(Empty request, StreamObserver<SourceControlServiceApi.SourceSetInfo> responseObserver) {
        List<SourceControlServiceApi.SourceInfo> deviceInfo = SourceControlService.getDeviceInfo();
        System.out.println(deviceInfo);

        // 构建 NodesInfo
        // 返回响应
        SourceControlServiceApi.SourceSetInfo response = SourceControlServiceApi.SourceSetInfo.newBuilder()
                .addAllSourceInfo(deviceInfo)
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
    public void sendSourceCommand(SourceControlServiceApi.SourceCommand request, StreamObserver<SourceControlServiceApi.SourceCommandReply> responseObserver) {
        // 获取客户端请求参数
        int sourceId = request.getSourceId().getValue();

        DCTSServiceApi.Command command = request.getCommand();
        int commandFunction = command.getCommandFunction();
        long commandParam = 0;
        try {
            commandParam = command.getCommandParam().unpack(DCTSServiceApi.Integer.class).getValue();
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        System.out.println("接收到的客户端的参数为：device_id: " + sourceId + ", command_function: " + commandFunction + " ,command_param: " + commandParam);

        DCTSServiceApi.CommandReply commandReply = SourceControlService.sendSourceCommand(sourceId, commandFunction, commandParam);
        // 模拟执行命令
        SourceControlServiceApi.SourceCommandReply response = SourceControlServiceApi.SourceCommandReply.newBuilder()
                .setSourceId(request.getSourceId())
                .setReply(commandReply)
                .build();

        responseObserver.onNext(response);
        System.out.println("收到请求，开始处理...");
        // 处理请求
        responseObserver.onCompleted();
    }
}
