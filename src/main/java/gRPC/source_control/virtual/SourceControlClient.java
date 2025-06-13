package gRPC.source_control.virtual;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import zb.dcts.Dcts;
import zb.dcts.source.Source;
import zb.dcts.source.SourceControlServiceGrpc;
import zb.dcts.source.seqGene.SeqGene;

/**
 * @file SourceControlClient.java
 * @comment 设备控制指令接口的测试客户端
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class SourceControlClient {
    private final SourceControlServiceGrpc.SourceControlServiceBlockingStub blockingStub;

    public SourceControlClient(ManagedChannel channel) {
        blockingStub = SourceControlServiceGrpc.newBlockingStub(channel);
    }


    public zb.dcts.source.Source.SourceCommandReply sendSourceCommand(zb.dcts.source.Source.SourceId sourceId, zb.dcts.Dcts.Command command) {
        zb.dcts.source.Source.SourceCommand sourceCommand = zb.dcts.source.Source.SourceCommand.newBuilder()
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
        zb.dcts.source.Source.SourceId deviceId = zb.dcts.source.Source.SourceId.newBuilder().setValue(1).build();

        // 创建命令（例如关机命令）
        zb.dcts.Dcts.Integer shutdownParam = zb.dcts.Dcts.Integer.newBuilder().setValue(123).build();
        Any commandParam = Any.pack(shutdownParam);

        Dcts.Command command = Dcts.Command.newBuilder()
                .setCommandFunction(commandNum)  // 功能编号
                .setCommandParam(commandParam)
                .build();

        // 发送命令
        Source.SourceCommandReply reply = client.sendSourceCommand(deviceId, command);
        StringValue result = reply.getReply().getAttachment().unpack(StringValue.class);
        System.out.println("Command reply result: " + result.getValue());

        // 关闭通道
        channel.shutdown();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        sourceControl(SeqGene.CmdType.RESTART_AT.getNumber());
        // sourceControl(NodeControlServiceApi.CmdType.START.getNumber());
    }
}

