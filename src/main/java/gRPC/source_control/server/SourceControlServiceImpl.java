package gRPC.source_control.server;

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
import proto_compile.cetc41.nodecontrol.SourceControlServiceGrpc;
import service.SourceControlService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * @file SourceControlServiceImpl.java
 * @comment 虚拟数据源gRPC服务器端实现
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class SourceControlServiceImpl extends SourceControlServiceGrpc.SourceControlServiceImplBase {
    static class SubscriberInfo {
        int sourceId;
        StreamObserver<Any> observer;

        SubscriberInfo(int sourceId, StreamObserver<Any> observer) {
            this.sourceId = sourceId;
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

//            System.out.println("[ZMQ 收到]: topic = " + topic + " | msg = " + msg);

            List<SubscriberInfo> subscribers = activeSubscribers.get(topic);
            if (subscribers != null) {
                for (SubscriberInfo sub : subscribers) {
                    try {
                        JsonNode jsonNode = mapper.readTree(msg);
                        int msgSourceId = jsonNode.get("source_id").asInt();

                        if (sub.sourceId == msgSourceId) {
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
     * 获取所有设备的状态信息
     *
     * @param request
     * @param responseObserver
     */

    @Override
    public void listAllSources(Empty request, StreamObserver<SourceControlServiceApi.SourceSetInfo> responseObserver) {
        List<SourceControlServiceApi.SourceInfo> deviceInfo = SourceControlService.getDeviceInfo();
        System.out.println(deviceInfo);

        // 构建 deviceInfo
        // 返回响应
        SourceControlServiceApi.SourceSetInfo response = SourceControlServiceApi.SourceSetInfo.newBuilder()
                .addAllSourceInfo(deviceInfo)
                .build();
        responseObserver.onNext(response);
        System.out.println("listAllSources接口收到客户端请求，开始返回设备状态数据...");
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

        System.out.println("接收到的客户端的参数为：sourceId: " + sourceId + ", command_function: " + commandFunction + " ,command_param: " + commandParam);

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
