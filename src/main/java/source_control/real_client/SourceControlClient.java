package source_control.real_client;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import zb.dcts.Dcts;
import zb.dcts.scenario.MCP.Trunk;
import zb.dcts.scenario.automatic.Auto;
import zb.dcts.scenario.spectrum.Spectrum;
import zb.dcts.source.Source;
import zb.dcts.source.SourceControlServiceGrpc;

/**
 * @file SourceControlClient.java
 * @comment 设备控制指令接口的测试客户端
 * @date 2025/6/12
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class SourceControlClient {
    private final SourceControlServiceGrpc.SourceControlServiceBlockingStub blockingStub;

    public SourceControlClient(ManagedChannel channel) {
        blockingStub = SourceControlServiceGrpc.newBlockingStub(channel);
    }

    public Source.SourceCommandReply sendSourceCommand(Source.SourceId sourceId, Dcts.Command command) {
        Source.SourceCommand sourceCommand = Source.SourceCommand.newBuilder()
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
    public static void sourceControl(Source.SourceId sourceId, int commandNum) throws InvalidProtocolBufferException {
        // 创建 gRPC 通道
        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.1.21", 6161)
                .usePlaintext()
                .build();

        SourceControlClient client = new SourceControlClient(channel);



        // 1. 构造 FrequencySpan 对象
        Spectrum.FrequencySpan freqSpan = Spectrum.FrequencySpan.newBuilder()
                .setStartFreq(1e3) // 起始频率
                .setStopFreq(1e5) // 终止频率
                .build();

        // 2. 构造 PScanParam 并设置 freq_span
        Trunk.PScanParam pscanParam = Trunk.PScanParam.newBuilder()
                .setFreqSpan(freqSpan)
                .setRbw(1000) // 示例：1kHz 分辨率
                .setResultInterval(500) // 结果回传间隔 500ms
                .setExpectedPoints(0)   // 原始点数
                .build();

        // 3. 封装为 ChangeSweepCommandParam
        Auto.ChangeSweepCommandParam sweepParam = Auto.ChangeSweepCommandParam.newBuilder()
                .setPscanParam(pscanParam)
                .build();

        // 4. 转换为 Any 类型
        Any commandParam = Any.pack(sweepParam);


        Dcts.Command command = Dcts.Command.newBuilder()
                .setCommandFunction(commandNum)  // 功能编号
                .setCommandParam(commandParam)
                .build();

        // 发送命令
        Source.SourceCommandReply reply = client.sendSourceCommand(sourceId, command);
        // Attachment若有内容，则应该使用相应的类进行解包
        // StringValue result = reply.getReply().getAttachment().unpack(XXX.class);
        System.out.println("Command reply result (sourceId): " + reply.getSourceId().getValue());

        if (reply.getSourceId().getValue() == 0) {
            System.err.println("❌ 发送命令失败！");
        } else {
            System.out.println("✅ 命令已发送成功！");
        }
        // 关闭通道
        channel.shutdown();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException, InterruptedException {
        sourceControl(Source.SourceId.newBuilder().setValue(1399540983).build(),2);
        // System.out.println(SeqGene.CmdType.RESTART_AT.getNumber());
    }
}

