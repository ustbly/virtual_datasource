package gRPC.node_control;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceApi;
import proto_compile.cetc41.nodecontrol.NodeControlServiceGrpc;

public class SourceControlClient {
    private final NodeControlServiceGrpc.NodeControlServiceBlockingStub blockingStub;

    public SourceControlClient(ManagedChannel channel) {
        blockingStub = NodeControlServiceGrpc.newBlockingStub(channel);
    }


    public NodeControlServiceApi.SourceCommandReply sendSourceCommand(NodeControlServiceApi.DeviceId deviceId, NodeControlServiceApi.Command command) {
        NodeControlServiceApi.SourceCommand sourceCommand = NodeControlServiceApi.SourceCommand.newBuilder()
                .setDeviceId(deviceId)
                .setCommand(command)
                .build();

        return blockingStub.sendSourceCommand(sourceCommand);
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        // 创建 gRPC 通道
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050)
                .usePlaintext()
                .build();

        SourceControlClient client = new SourceControlClient(channel);

        // 创建设备 ID
        NodeControlServiceApi.DeviceId deviceId = NodeControlServiceApi.DeviceId.newBuilder().setValue("Device_02").build();

        // 创建命令（例如关机命令）
        DCTSServiceApi.Integer shutdownParam = DCTSServiceApi.Integer.newBuilder().setValue(123).build();
        Any commandParam = Any.pack(shutdownParam);

        NodeControlServiceApi.Command command = NodeControlServiceApi.Command.newBuilder()
                .setCommandFunction(NodeControlServiceApi.CmdType.SHUTDOWN.getNumber())  // 功能编号
                .setCommandParam(commandParam)
                .build();

        // 发送命令
        NodeControlServiceApi.SourceCommandReply reply = client.sendSourceCommand(deviceId, command);
        DCTSServiceApi.String result = reply.getReply().getAttachment().unpack(DCTSServiceApi.String.class);
        System.out.println("Command reply result: " + result.getValue());

        // 关闭通道
        channel.shutdown();
    }
}

