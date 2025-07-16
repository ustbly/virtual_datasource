package utils;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
import zb.dcts.scenario.detection.Detection;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @file MessageToJsonUtil.java
 * @comment 该工具类用于将Protobuf的Any类型消息转换为JSON字符串。
 * @date 2025/7/9
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class MessageToJsonUtil {
    // 注册支持的消息类型解析函数
    private static final Map<String, Function<Any, String>> parserRegistry = new HashMap<>();

    static {
        // 注册 Target 类型
        parserRegistry.put(Aeronaval.Target.getDescriptor().getFullName(), any -> {
            try {
                // 尝试将 Any 类型解析为 Target
                Aeronaval.Target target = any.unpack(Aeronaval.Target.class);
                return toJson(target);
            } catch (InvalidProtocolBufferException e) {
                return "[Error] Failed to parse Target: " + e.getMessage();
            }
        });

        // 注册 SignalLayerSurvey 类型
        parserRegistry.put(Detection.SignalLayerSurvey.getDescriptor().getFullName(), any -> {
            try {
                // 尝试将 Any 类型解析为 SignalLayerSurvey
                Detection.SignalLayerSurvey survey = any.unpack(Detection.SignalLayerSurvey.class);
                return toJson(survey);
            } catch (InvalidProtocolBufferException e) {
                return "[Error] Failed to parse SignalLayerSurvey: " + e.getMessage();
            }
        });

        // 注册 FusionTargetList 类型
        parserRegistry.put(TargetOuterClass.FusionTargetList.getDescriptor().getFullName(), any -> {
            try {
                // 尝试将 Any 类型解析为 FusionTargetList
                TargetOuterClass.FusionTargetList msg = any.unpack(TargetOuterClass.FusionTargetList.class);
                return toJson(msg);
            } catch (InvalidProtocolBufferException e) {
                return "[Error] Failed to parse CombinedMessage: " + e.getMessage();
            }
        });
    }

    /**
     * 将 Any 类型解析为 JSON 字符串。
     */
    public static String parseAnyToJson(Any any) {
        // 检查 Any 是否为 null
        if (any == null) {
            return "[Error] Any message is null.";
        }
        // 检查 Any 是否包含有效的消息
        String typeUrl = any.getTypeUrl();  // type.googleapis.com/xxx.MsgType
//        System.out.println("Parsing Any type: " + typeUrl);
        // 提取类型名称
        String typeName = typeUrl.substring(typeUrl.lastIndexOf("/") + 1);
        // 查找注册的解析函数
        for (Map.Entry<String, Function<Any, String>> entry : parserRegistry.entrySet()) {
            if (entry.getKey().endsWith(typeName)) {
                return entry.getValue().apply(any);
            }
        }
        // 如果没有找到对应的解析函数，返回警告信息
        return "[Warning] Unregistered type: " + typeName;
    }

    /**
     * @param msg 待转换的 Protobuf Message
     * @return 格式化后的 JSON 字符串
     * 将 Protobuf Message 转为格式化 JSON 字符串。
     */
    public static String toJson(Message msg) {
        try {
            // 使用 JsonFormat 将 Protobuf Message 转为 JSON 字符串
            return JsonFormat.printer()
                    .includingDefaultValueFields()
                    .preservingProtoFieldNames()
                    .print(msg);
        } catch (Exception e) {
            // 捕获异常并返回错误信息
            return "[Error] Failed to convert to JSON: " + e.getMessage();
        }
    }

    /**
     * 将 JSON 字符串解析为指定类型的 Protobuf Message
     * @param json 待解析的 JSON 字符串
     * @param builder 对应类型的 builder（例如 Target.newBuilder()）
     * @return 构建完成的 Protobuf Message
     */
    public static Message fromJson(String json, Message.Builder builder) {
        try {
            // 使用 JsonFormat 将 JSON 字符串解析为 Protobuf Message
            JsonFormat.parser().ignoringUnknownFields().merge(json, builder);
            return builder.build();
        } catch (Exception e) {
            // 捕获异常并抛出运行时异常
            throw new RuntimeException("[Error] Failed to parse JSON to Protobuf: " + e.getMessage(), e);
        }
    }
}

