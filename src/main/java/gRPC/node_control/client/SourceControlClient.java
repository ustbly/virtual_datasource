package gRPC.node_control.client;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto_compile.cetc41.nodecontrol.DCTSServiceApi;
import proto_compile.cetc41.nodecontrol.SeqGene;
import proto_compile.cetc41.nodecontrol.SourceControlServiceApi;
import proto_compile.cetc41.nodecontrol.SourceControlServiceGrpc;

public class SourceControlClient {
    private final SourceControlServiceGrpc.SourceControlServiceBlockingStub blockingStub;

    public SourceControlClient(ManagedChannel channel) {
        blockingStub = SourceControlServiceGrpc.newBlockingStub(channel);
    }


    public SourceControlServiceApi.SourceCommandReply sendSourceCommand(SourceControlServiceApi.SourceId sourceId, DCTSServiceApi.Command command) {
        SourceControlServiceApi.SourceCommand sourceCommand = SourceControlServiceApi.SourceCommand.newBuilder()
                .setSourceId(sourceId)
                .setCommand(command)
                .build();

        return blockingStub.sendSourceCommand(sourceCommand);
    }

    /**
     * 发送设备控制指令
     * @param commandNum
     * @throws InvalidProtocolBufferException
     */
    public static void sourceControl(int commandNum) throws InvalidProtocolBufferException {
        // 创建 gRPC 通道
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50050)
                .usePlaintext()
                .build();

        SourceControlClient client = new SourceControlClient(channel);

        // 创建设备 ID
        SourceControlServiceApi.SourceId deviceId = SourceControlServiceApi.SourceId.newBuilder().setValue(1).build();

        // 创建命令（例如关机命令）
        DCTSServiceApi.Integer shutdownParam = DCTSServiceApi.Integer.newBuilder().setValue(123).build();
        Any commandParam = Any.pack(shutdownParam);

        DCTSServiceApi.Command command = DCTSServiceApi.Command.newBuilder()
                .setCommandFunction(commandNum)  // 功能编号
                .setCommandParam(commandParam)
                .build();

        // 发送命令
        SourceControlServiceApi.SourceCommandReply reply = client.sendSourceCommand(deviceId, command);
        StringValue result = reply.getReply().getAttachment().unpack(StringValue.class);
        System.out.println("Command reply result: " + result.getValue());

        // 关闭通道
        channel.shutdown();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        sourceControl(SeqGene.CmdType.STARTUP.getNumber());
        // sourceControl(NodeControlServiceApi.CmdType.START.getNumber());
    }
}

