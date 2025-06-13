package zb.dcts.scenario.kh.commSpectrum;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/kh/KhCommFixSpectrum.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FixSpectrumServiceGrpc {

  private FixSpectrumServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.kh.commSpectrum.FixSpectrumService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixTaskRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartTask",
      requestType = zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixTaskRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixTaskRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixTaskRequest, zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod;
    if ((getStartTaskMethod = FixSpectrumServiceGrpc.getStartTaskMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getStartTaskMethod = FixSpectrumServiceGrpc.getStartTaskMethod) == null) {
          FixSpectrumServiceGrpc.getStartTaskMethod = getStartTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixTaskRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("StartTask"))
              .build();
        }
      }
    }
    return getStartTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixResult> getGetResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetResult",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixResult> getGetResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixResult> getGetResultMethod;
    if ((getGetResultMethod = FixSpectrumServiceGrpc.getGetResultMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getGetResultMethod = FixSpectrumServiceGrpc.getGetResultMethod) == null) {
          FixSpectrumServiceGrpc.getGetResultMethod = getGetResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixResult.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("GetResult"))
              .build();
        }
      }
    }
    return getGetResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getStopTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopTask",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getStopTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply> getStopTaskMethod;
    if ((getStopTaskMethod = FixSpectrumServiceGrpc.getStopTaskMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getStopTaskMethod = FixSpectrumServiceGrpc.getStopTaskMethod) == null) {
          FixSpectrumServiceGrpc.getStopTaskMethod = getStopTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("StopTask"))
              .build();
        }
      }
    }
    return getStopTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getOpenZoomInMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OpenZoomIn",
      requestType = zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getOpenZoomInMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest, zb.dcts.scenario.Scenario.ScenarioReply> getOpenZoomInMethod;
    if ((getOpenZoomInMethod = FixSpectrumServiceGrpc.getOpenZoomInMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getOpenZoomInMethod = FixSpectrumServiceGrpc.getOpenZoomInMethod) == null) {
          FixSpectrumServiceGrpc.getOpenZoomInMethod = getOpenZoomInMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenZoomIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("OpenZoomIn"))
              .build();
        }
      }
    }
    return getOpenZoomInMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getCloseZoomInMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloseZoomIn",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getCloseZoomInMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply> getCloseZoomInMethod;
    if ((getCloseZoomInMethod = FixSpectrumServiceGrpc.getCloseZoomInMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getCloseZoomInMethod = FixSpectrumServiceGrpc.getCloseZoomInMethod) == null) {
          FixSpectrumServiceGrpc.getCloseZoomInMethod = getCloseZoomInMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseZoomIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("CloseZoomIn"))
              .build();
        }
      }
    }
    return getCloseZoomInMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getOpenDataHoldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OpenDataHold",
      requestType = zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getOpenDataHoldMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply> getOpenDataHoldMethod;
    if ((getOpenDataHoldMethod = FixSpectrumServiceGrpc.getOpenDataHoldMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getOpenDataHoldMethod = FixSpectrumServiceGrpc.getOpenDataHoldMethod) == null) {
          FixSpectrumServiceGrpc.getOpenDataHoldMethod = getOpenDataHoldMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenDataHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("OpenDataHold"))
              .build();
        }
      }
    }
    return getOpenDataHoldMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getResetDataHoldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetDataHold",
      requestType = zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getResetDataHoldMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply> getResetDataHoldMethod;
    if ((getResetDataHoldMethod = FixSpectrumServiceGrpc.getResetDataHoldMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getResetDataHoldMethod = FixSpectrumServiceGrpc.getResetDataHoldMethod) == null) {
          FixSpectrumServiceGrpc.getResetDataHoldMethod = getResetDataHoldMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetDataHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("ResetDataHold"))
              .build();
        }
      }
    }
    return getResetDataHoldMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getCloseDataHoldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloseDataHold",
      requestType = zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getCloseDataHoldMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply> getCloseDataHoldMethod;
    if ((getCloseDataHoldMethod = FixSpectrumServiceGrpc.getCloseDataHoldMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getCloseDataHoldMethod = FixSpectrumServiceGrpc.getCloseDataHoldMethod) == null) {
          FixSpectrumServiceGrpc.getCloseDataHoldMethod = getCloseDataHoldMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseDataHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("CloseDataHold"))
              .build();
        }
      }
    }
    return getCloseDataHoldMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.detection.Detection.DetectionRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getOpenDetectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OpenDetection",
      requestType = zb.dcts.scenario.detection.Detection.DetectionRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.detection.Detection.DetectionRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getOpenDetectionMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.detection.Detection.DetectionRequest, zb.dcts.scenario.Scenario.ScenarioReply> getOpenDetectionMethod;
    if ((getOpenDetectionMethod = FixSpectrumServiceGrpc.getOpenDetectionMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getOpenDetectionMethod = FixSpectrumServiceGrpc.getOpenDetectionMethod) == null) {
          FixSpectrumServiceGrpc.getOpenDetectionMethod = getOpenDetectionMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.detection.Detection.DetectionRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenDetection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.detection.Detection.DetectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("OpenDetection"))
              .build();
        }
      }
    }
    return getOpenDetectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getCloseDetectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloseDetection",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getCloseDetectionMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply> getCloseDetectionMethod;
    if ((getCloseDetectionMethod = FixSpectrumServiceGrpc.getCloseDetectionMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getCloseDetectionMethod = FixSpectrumServiceGrpc.getCloseDetectionMethod) == null) {
          FixSpectrumServiceGrpc.getCloseDetectionMethod = getCloseDetectionMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseDetection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("CloseDetection"))
              .build();
        }
      }
    }
    return getCloseDetectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.detection.Detection.SignalTableQueryRequest,
      zb.dcts.scenario.detection.Detection.SignalTableQueryResponse> getQuerySignalTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QuerySignalTable",
      requestType = zb.dcts.scenario.detection.Detection.SignalTableQueryRequest.class,
      responseType = zb.dcts.scenario.detection.Detection.SignalTableQueryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.detection.Detection.SignalTableQueryRequest,
      zb.dcts.scenario.detection.Detection.SignalTableQueryResponse> getQuerySignalTableMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.detection.Detection.SignalTableQueryRequest, zb.dcts.scenario.detection.Detection.SignalTableQueryResponse> getQuerySignalTableMethod;
    if ((getQuerySignalTableMethod = FixSpectrumServiceGrpc.getQuerySignalTableMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getQuerySignalTableMethod = FixSpectrumServiceGrpc.getQuerySignalTableMethod) == null) {
          FixSpectrumServiceGrpc.getQuerySignalTableMethod = getQuerySignalTableMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.detection.Detection.SignalTableQueryRequest, zb.dcts.scenario.detection.Detection.SignalTableQueryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QuerySignalTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.detection.Detection.SignalTableQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.detection.Detection.SignalTableQueryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("QuerySignalTable"))
              .build();
        }
      }
    }
    return getQuerySignalTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getClearSignalTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClearSignalTable",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getClearSignalTableMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply> getClearSignalTableMethod;
    if ((getClearSignalTableMethod = FixSpectrumServiceGrpc.getClearSignalTableMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getClearSignalTableMethod = FixSpectrumServiceGrpc.getClearSignalTableMethod) == null) {
          FixSpectrumServiceGrpc.getClearSignalTableMethod = getClearSignalTableMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClearSignalTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("ClearSignalTable"))
              .build();
        }
      }
    }
    return getClearSignalTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.detection.Detection.SignalGatheringRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getSignalGatheringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SignalGathering",
      requestType = zb.dcts.scenario.detection.Detection.SignalGatheringRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.detection.Detection.SignalGatheringRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getSignalGatheringMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.detection.Detection.SignalGatheringRequest, zb.dcts.scenario.Scenario.ScenarioReply> getSignalGatheringMethod;
    if ((getSignalGatheringMethod = FixSpectrumServiceGrpc.getSignalGatheringMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getSignalGatheringMethod = FixSpectrumServiceGrpc.getSignalGatheringMethod) == null) {
          FixSpectrumServiceGrpc.getSignalGatheringMethod = getSignalGatheringMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.detection.Detection.SignalGatheringRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SignalGathering"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.detection.Detection.SignalGatheringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("SignalGathering"))
              .build();
        }
      }
    }
    return getSignalGatheringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.detection.Detection.SignalSampleList> getGetGatheringResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGatheringResult",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.detection.Detection.SignalSampleList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.detection.Detection.SignalSampleList> getGetGatheringResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.detection.Detection.SignalSampleList> getGetGatheringResultMethod;
    if ((getGetGatheringResultMethod = FixSpectrumServiceGrpc.getGetGatheringResultMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getGetGatheringResultMethod = FixSpectrumServiceGrpc.getGetGatheringResultMethod) == null) {
          FixSpectrumServiceGrpc.getGetGatheringResultMethod = getGetGatheringResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.detection.Detection.SignalSampleList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGatheringResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.detection.Detection.SignalSampleList.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("GetGatheringResult"))
              .build();
        }
      }
    }
    return getGetGatheringResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.IQRecordRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getIQRecordCmdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IQRecordCmd",
      requestType = zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.IQRecordRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.IQRecordRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getIQRecordCmdMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.IQRecordRequest, zb.dcts.scenario.Scenario.ScenarioReply> getIQRecordCmdMethod;
    if ((getIQRecordCmdMethod = FixSpectrumServiceGrpc.getIQRecordCmdMethod) == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        if ((getIQRecordCmdMethod = FixSpectrumServiceGrpc.getIQRecordCmdMethod) == null) {
          FixSpectrumServiceGrpc.getIQRecordCmdMethod = getIQRecordCmdMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.IQRecordRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "IQRecordCmd"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.IQRecordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new FixSpectrumServiceMethodDescriptorSupplier("IQRecordCmd"))
              .build();
        }
      }
    }
    return getIQRecordCmdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FixSpectrumServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FixSpectrumServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FixSpectrumServiceStub>() {
        @java.lang.Override
        public FixSpectrumServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FixSpectrumServiceStub(channel, callOptions);
        }
      };
    return FixSpectrumServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FixSpectrumServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FixSpectrumServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FixSpectrumServiceBlockingStub>() {
        @java.lang.Override
        public FixSpectrumServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FixSpectrumServiceBlockingStub(channel, callOptions);
        }
      };
    return FixSpectrumServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FixSpectrumServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FixSpectrumServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FixSpectrumServiceFutureStub>() {
        @java.lang.Override
        public FixSpectrumServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FixSpectrumServiceFutureStub(channel, callOptions);
        }
      };
    return FixSpectrumServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FixSpectrumServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void startTask(zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixTaskRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartTaskMethod(), responseObserver);
    }

    /**
     */
    public void getResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetResultMethod(), responseObserver);
    }

    /**
     */
    public void stopTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopTaskMethod(), responseObserver);
    }

    /**
     * <pre>
     *-----zoomin/datahold/detection-----
     * </pre>
     */
    public void openZoomIn(zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOpenZoomInMethod(), responseObserver);
    }

    /**
     */
    public void closeZoomIn(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseZoomInMethod(), responseObserver);
    }

    /**
     */
    public void openDataHold(zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOpenDataHoldMethod(), responseObserver);
    }

    /**
     */
    public void resetDataHold(zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResetDataHoldMethod(), responseObserver);
    }

    /**
     */
    public void closeDataHold(zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseDataHoldMethod(), responseObserver);
    }

    /**
     */
    public void openDetection(zb.dcts.scenario.detection.Detection.DetectionRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOpenDetectionMethod(), responseObserver);
    }

    /**
     */
    public void closeDetection(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseDetectionMethod(), responseObserver);
    }

    /**
     */
    public void querySignalTable(zb.dcts.scenario.detection.Detection.SignalTableQueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.detection.Detection.SignalTableQueryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQuerySignalTableMethod(), responseObserver);
    }

    /**
     */
    public void clearSignalTable(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getClearSignalTableMethod(), responseObserver);
    }

    /**
     */
    public void signalGathering(zb.dcts.scenario.detection.Detection.SignalGatheringRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSignalGatheringMethod(), responseObserver);
    }

    /**
     */
    public void getGatheringResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.detection.Detection.SignalSampleList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGatheringResultMethod(), responseObserver);
    }

    /**
     * <pre>
     *IQ记录命令
     * </pre>
     */
    public void iQRecordCmd(zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.IQRecordRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIQRecordCmdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStartTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixTaskRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_START_TASK)))
          .addMethod(
            getGetResultMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixResult>(
                  this, METHODID_GET_RESULT)))
          .addMethod(
            getStopTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_STOP_TASK)))
          .addMethod(
            getOpenZoomInMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_OPEN_ZOOM_IN)))
          .addMethod(
            getCloseZoomInMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CLOSE_ZOOM_IN)))
          .addMethod(
            getOpenDataHoldMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_OPEN_DATA_HOLD)))
          .addMethod(
            getResetDataHoldMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_RESET_DATA_HOLD)))
          .addMethod(
            getCloseDataHoldMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CLOSE_DATA_HOLD)))
          .addMethod(
            getOpenDetectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.detection.Detection.DetectionRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_OPEN_DETECTION)))
          .addMethod(
            getCloseDetectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CLOSE_DETECTION)))
          .addMethod(
            getQuerySignalTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.detection.Detection.SignalTableQueryRequest,
                zb.dcts.scenario.detection.Detection.SignalTableQueryResponse>(
                  this, METHODID_QUERY_SIGNAL_TABLE)))
          .addMethod(
            getClearSignalTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CLEAR_SIGNAL_TABLE)))
          .addMethod(
            getSignalGatheringMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.detection.Detection.SignalGatheringRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_SIGNAL_GATHERING)))
          .addMethod(
            getGetGatheringResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.detection.Detection.SignalSampleList>(
                  this, METHODID_GET_GATHERING_RESULT)))
          .addMethod(
            getIQRecordCmdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.IQRecordRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_IQRECORD_CMD)))
          .build();
    }
  }

  /**
   */
  public static final class FixSpectrumServiceStub extends io.grpc.stub.AbstractAsyncStub<FixSpectrumServiceStub> {
    private FixSpectrumServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FixSpectrumServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FixSpectrumServiceStub(channel, callOptions);
    }

    /**
     */
    public void startTask(zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixTaskRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stopTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *-----zoomin/datahold/detection-----
     * </pre>
     */
    public void openZoomIn(zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOpenZoomInMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeZoomIn(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseZoomInMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void openDataHold(zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOpenDataHoldMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void resetDataHold(zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetDataHoldMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeDataHold(zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseDataHoldMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void openDetection(zb.dcts.scenario.detection.Detection.DetectionRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOpenDetectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeDetection(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseDetectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void querySignalTable(zb.dcts.scenario.detection.Detection.SignalTableQueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.detection.Detection.SignalTableQueryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQuerySignalTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void clearSignalTable(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getClearSignalTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void signalGathering(zb.dcts.scenario.detection.Detection.SignalGatheringRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSignalGatheringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getGatheringResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.detection.Detection.SignalSampleList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGatheringResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *IQ记录命令
     * </pre>
     */
    public void iQRecordCmd(zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.IQRecordRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIQRecordCmdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FixSpectrumServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FixSpectrumServiceBlockingStub> {
    private FixSpectrumServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FixSpectrumServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FixSpectrumServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply startTask(zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixResult> getResult(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetResultMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply stopTask(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopTaskMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *-----zoomin/datahold/detection-----
     * </pre>
     */
    public zb.dcts.scenario.Scenario.ScenarioReply openZoomIn(zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenZoomInMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply closeZoomIn(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseZoomInMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply openDataHold(zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenDataHoldMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply resetDataHold(zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetDataHoldMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply closeDataHold(zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseDataHoldMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply openDetection(zb.dcts.scenario.detection.Detection.DetectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenDetectionMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply closeDetection(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseDetectionMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.detection.Detection.SignalTableQueryResponse querySignalTable(zb.dcts.scenario.detection.Detection.SignalTableQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQuerySignalTableMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply clearSignalTable(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getClearSignalTableMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply signalGathering(zb.dcts.scenario.detection.Detection.SignalGatheringRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSignalGatheringMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.detection.Detection.SignalSampleList getGatheringResult(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGatheringResultMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *IQ记录命令
     * </pre>
     */
    public zb.dcts.scenario.Scenario.ScenarioReply iQRecordCmd(zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.IQRecordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIQRecordCmdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FixSpectrumServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FixSpectrumServiceFutureStub> {
    private FixSpectrumServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FixSpectrumServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FixSpectrumServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> startTask(
        zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartTaskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> stopTask(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopTaskMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *-----zoomin/datahold/detection-----
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> openZoomIn(
        zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOpenZoomInMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> closeZoomIn(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloseZoomInMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> openDataHold(
        zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOpenDataHoldMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> resetDataHold(
        zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetDataHoldMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> closeDataHold(
        zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloseDataHoldMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> openDetection(
        zb.dcts.scenario.detection.Detection.DetectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOpenDetectionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> closeDetection(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloseDetectionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.detection.Detection.SignalTableQueryResponse> querySignalTable(
        zb.dcts.scenario.detection.Detection.SignalTableQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQuerySignalTableMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> clearSignalTable(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getClearSignalTableMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> signalGathering(
        zb.dcts.scenario.detection.Detection.SignalGatheringRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSignalGatheringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.detection.Detection.SignalSampleList> getGatheringResult(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGatheringResultMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *IQ记录命令
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> iQRecordCmd(
        zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.IQRecordRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIQRecordCmdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_TASK = 0;
  private static final int METHODID_GET_RESULT = 1;
  private static final int METHODID_STOP_TASK = 2;
  private static final int METHODID_OPEN_ZOOM_IN = 3;
  private static final int METHODID_CLOSE_ZOOM_IN = 4;
  private static final int METHODID_OPEN_DATA_HOLD = 5;
  private static final int METHODID_RESET_DATA_HOLD = 6;
  private static final int METHODID_CLOSE_DATA_HOLD = 7;
  private static final int METHODID_OPEN_DETECTION = 8;
  private static final int METHODID_CLOSE_DETECTION = 9;
  private static final int METHODID_QUERY_SIGNAL_TABLE = 10;
  private static final int METHODID_CLEAR_SIGNAL_TABLE = 11;
  private static final int METHODID_SIGNAL_GATHERING = 12;
  private static final int METHODID_GET_GATHERING_RESULT = 13;
  private static final int METHODID_IQRECORD_CMD = 14;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FixSpectrumServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FixSpectrumServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_TASK:
          serviceImpl.startTask((zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixTaskRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_GET_RESULT:
          serviceImpl.getResult((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.FixResult>) responseObserver);
          break;
        case METHODID_STOP_TASK:
          serviceImpl.stopTask((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_OPEN_ZOOM_IN:
          serviceImpl.openZoomIn((zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_CLOSE_ZOOM_IN:
          serviceImpl.closeZoomIn((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_OPEN_DATA_HOLD:
          serviceImpl.openDataHold((zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_RESET_DATA_HOLD:
          serviceImpl.resetDataHold((zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_CLOSE_DATA_HOLD:
          serviceImpl.closeDataHold((zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_OPEN_DETECTION:
          serviceImpl.openDetection((zb.dcts.scenario.detection.Detection.DetectionRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_CLOSE_DETECTION:
          serviceImpl.closeDetection((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_QUERY_SIGNAL_TABLE:
          serviceImpl.querySignalTable((zb.dcts.scenario.detection.Detection.SignalTableQueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.detection.Detection.SignalTableQueryResponse>) responseObserver);
          break;
        case METHODID_CLEAR_SIGNAL_TABLE:
          serviceImpl.clearSignalTable((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_SIGNAL_GATHERING:
          serviceImpl.signalGathering((zb.dcts.scenario.detection.Detection.SignalGatheringRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_GET_GATHERING_RESULT:
          serviceImpl.getGatheringResult((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.detection.Detection.SignalSampleList>) responseObserver);
          break;
        case METHODID_IQRECORD_CMD:
          serviceImpl.iQRecordCmd((zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.IQRecordRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FixSpectrumServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FixSpectrumServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.kh.commSpectrum.KhCommFixSpectrum.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FixSpectrumService");
    }
  }

  private static final class FixSpectrumServiceFileDescriptorSupplier
      extends FixSpectrumServiceBaseDescriptorSupplier {
    FixSpectrumServiceFileDescriptorSupplier() {}
  }

  private static final class FixSpectrumServiceMethodDescriptorSupplier
      extends FixSpectrumServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FixSpectrumServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FixSpectrumServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FixSpectrumServiceFileDescriptorSupplier())
              .addMethod(getStartTaskMethod())
              .addMethod(getGetResultMethod())
              .addMethod(getStopTaskMethod())
              .addMethod(getOpenZoomInMethod())
              .addMethod(getCloseZoomInMethod())
              .addMethod(getOpenDataHoldMethod())
              .addMethod(getResetDataHoldMethod())
              .addMethod(getCloseDataHoldMethod())
              .addMethod(getOpenDetectionMethod())
              .addMethod(getCloseDetectionMethod())
              .addMethod(getQuerySignalTableMethod())
              .addMethod(getClearSignalTableMethod())
              .addMethod(getSignalGatheringMethod())
              .addMethod(getGetGatheringResultMethod())
              .addMethod(getIQRecordCmdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
