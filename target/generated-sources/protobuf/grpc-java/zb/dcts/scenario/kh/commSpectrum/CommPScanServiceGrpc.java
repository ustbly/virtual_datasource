package zb.dcts.scenario.kh.commSpectrum;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/kh/KhCommPScan.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CommPScanServiceGrpc {

  private CommPScanServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.kh.commSpectrum.CommPScanService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanCreateScenarioRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getCreateScenarioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateScenario",
      requestType = zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanCreateScenarioRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanCreateScenarioRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getCreateScenarioMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanCreateScenarioRequest, zb.dcts.scenario.Scenario.ScenarioReply> getCreateScenarioMethod;
    if ((getCreateScenarioMethod = CommPScanServiceGrpc.getCreateScenarioMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getCreateScenarioMethod = CommPScanServiceGrpc.getCreateScenarioMethod) == null) {
          CommPScanServiceGrpc.getCreateScenarioMethod = getCreateScenarioMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanCreateScenarioRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateScenario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanCreateScenarioRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("CreateScenario"))
              .build();
        }
      }
    }
    return getCreateScenarioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanResult> getGetPScanResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPScanResult",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanResult> getGetPScanResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanResult> getGetPScanResultMethod;
    if ((getGetPScanResultMethod = CommPScanServiceGrpc.getGetPScanResultMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getGetPScanResultMethod = CommPScanServiceGrpc.getGetPScanResultMethod) == null) {
          CommPScanServiceGrpc.getGetPScanResultMethod = getGetPScanResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPScanResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanResult.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("GetPScanResult"))
              .build();
        }
      }
    }
    return getGetPScanResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioId,
      zb.dcts.scenario.Scenario.ScenarioReply> getCloseScenarioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloseScenario",
      requestType = zb.dcts.scenario.Scenario.ScenarioId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioId,
      zb.dcts.scenario.Scenario.ScenarioReply> getCloseScenarioMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioId, zb.dcts.scenario.Scenario.ScenarioReply> getCloseScenarioMethod;
    if ((getCloseScenarioMethod = CommPScanServiceGrpc.getCloseScenarioMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getCloseScenarioMethod = CommPScanServiceGrpc.getCloseScenarioMethod) == null) {
          CommPScanServiceGrpc.getCloseScenarioMethod = getCloseScenarioMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseScenario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("CloseScenario"))
              .build();
        }
      }
    }
    return getCloseScenarioMethod;
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
    if ((getOpenZoomInMethod = CommPScanServiceGrpc.getOpenZoomInMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getOpenZoomInMethod = CommPScanServiceGrpc.getOpenZoomInMethod) == null) {
          CommPScanServiceGrpc.getOpenZoomInMethod = getOpenZoomInMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenZoomIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("OpenZoomIn"))
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
    if ((getCloseZoomInMethod = CommPScanServiceGrpc.getCloseZoomInMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getCloseZoomInMethod = CommPScanServiceGrpc.getCloseZoomInMethod) == null) {
          CommPScanServiceGrpc.getCloseZoomInMethod = getCloseZoomInMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseZoomIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("CloseZoomIn"))
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
    if ((getOpenDataHoldMethod = CommPScanServiceGrpc.getOpenDataHoldMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getOpenDataHoldMethod = CommPScanServiceGrpc.getOpenDataHoldMethod) == null) {
          CommPScanServiceGrpc.getOpenDataHoldMethod = getOpenDataHoldMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenDataHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("OpenDataHold"))
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
    if ((getResetDataHoldMethod = CommPScanServiceGrpc.getResetDataHoldMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getResetDataHoldMethod = CommPScanServiceGrpc.getResetDataHoldMethod) == null) {
          CommPScanServiceGrpc.getResetDataHoldMethod = getResetDataHoldMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetDataHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("ResetDataHold"))
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
    if ((getCloseDataHoldMethod = CommPScanServiceGrpc.getCloseDataHoldMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getCloseDataHoldMethod = CommPScanServiceGrpc.getCloseDataHoldMethod) == null) {
          CommPScanServiceGrpc.getCloseDataHoldMethod = getCloseDataHoldMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseDataHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("CloseDataHold"))
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
    if ((getOpenDetectionMethod = CommPScanServiceGrpc.getOpenDetectionMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getOpenDetectionMethod = CommPScanServiceGrpc.getOpenDetectionMethod) == null) {
          CommPScanServiceGrpc.getOpenDetectionMethod = getOpenDetectionMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.detection.Detection.DetectionRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenDetection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.detection.Detection.DetectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("OpenDetection"))
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
    if ((getCloseDetectionMethod = CommPScanServiceGrpc.getCloseDetectionMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getCloseDetectionMethod = CommPScanServiceGrpc.getCloseDetectionMethod) == null) {
          CommPScanServiceGrpc.getCloseDetectionMethod = getCloseDetectionMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseDetection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("CloseDetection"))
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
    if ((getQuerySignalTableMethod = CommPScanServiceGrpc.getQuerySignalTableMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getQuerySignalTableMethod = CommPScanServiceGrpc.getQuerySignalTableMethod) == null) {
          CommPScanServiceGrpc.getQuerySignalTableMethod = getQuerySignalTableMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.detection.Detection.SignalTableQueryRequest, zb.dcts.scenario.detection.Detection.SignalTableQueryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QuerySignalTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.detection.Detection.SignalTableQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.detection.Detection.SignalTableQueryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("QuerySignalTable"))
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
    if ((getClearSignalTableMethod = CommPScanServiceGrpc.getClearSignalTableMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getClearSignalTableMethod = CommPScanServiceGrpc.getClearSignalTableMethod) == null) {
          CommPScanServiceGrpc.getClearSignalTableMethod = getClearSignalTableMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClearSignalTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("ClearSignalTable"))
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
    if ((getSignalGatheringMethod = CommPScanServiceGrpc.getSignalGatheringMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getSignalGatheringMethod = CommPScanServiceGrpc.getSignalGatheringMethod) == null) {
          CommPScanServiceGrpc.getSignalGatheringMethod = getSignalGatheringMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.detection.Detection.SignalGatheringRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SignalGathering"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.detection.Detection.SignalGatheringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("SignalGathering"))
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
    if ((getGetGatheringResultMethod = CommPScanServiceGrpc.getGetGatheringResultMethod) == null) {
      synchronized (CommPScanServiceGrpc.class) {
        if ((getGetGatheringResultMethod = CommPScanServiceGrpc.getGetGatheringResultMethod) == null) {
          CommPScanServiceGrpc.getGetGatheringResultMethod = getGetGatheringResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.detection.Detection.SignalSampleList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGatheringResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.detection.Detection.SignalSampleList.getDefaultInstance()))
              .setSchemaDescriptor(new CommPScanServiceMethodDescriptorSupplier("GetGatheringResult"))
              .build();
        }
      }
    }
    return getGetGatheringResultMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommPScanServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommPScanServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommPScanServiceStub>() {
        @java.lang.Override
        public CommPScanServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommPScanServiceStub(channel, callOptions);
        }
      };
    return CommPScanServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommPScanServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommPScanServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommPScanServiceBlockingStub>() {
        @java.lang.Override
        public CommPScanServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommPScanServiceBlockingStub(channel, callOptions);
        }
      };
    return CommPScanServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommPScanServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommPScanServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommPScanServiceFutureStub>() {
        @java.lang.Override
        public CommPScanServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommPScanServiceFutureStub(channel, callOptions);
        }
      };
    return CommPScanServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CommPScanServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createScenario(zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanCreateScenarioRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateScenarioMethod(), responseObserver);
    }

    /**
     */
    public void getPScanResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPScanResultMethod(), responseObserver);
    }

    /**
     */
    public void closeScenario(zb.dcts.scenario.Scenario.ScenarioId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseScenarioMethod(), responseObserver);
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

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateScenarioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanCreateScenarioRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CREATE_SCENARIO)))
          .addMethod(
            getGetPScanResultMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanResult>(
                  this, METHODID_GET_PSCAN_RESULT)))
          .addMethod(
            getCloseScenarioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CLOSE_SCENARIO)))
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
          .build();
    }
  }

  /**
   */
  public static final class CommPScanServiceStub extends io.grpc.stub.AbstractAsyncStub<CommPScanServiceStub> {
    private CommPScanServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommPScanServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommPScanServiceStub(channel, callOptions);
    }

    /**
     */
    public void createScenario(zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanCreateScenarioRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateScenarioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPScanResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetPScanResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeScenario(zb.dcts.scenario.Scenario.ScenarioId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseScenarioMethod(), getCallOptions()), request, responseObserver);
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
  }

  /**
   */
  public static final class CommPScanServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CommPScanServiceBlockingStub> {
    private CommPScanServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommPScanServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommPScanServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply createScenario(zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanCreateScenarioRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateScenarioMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanResult> getPScanResult(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetPScanResultMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply closeScenario(zb.dcts.scenario.Scenario.ScenarioId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseScenarioMethod(), getCallOptions(), request);
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
  }

  /**
   */
  public static final class CommPScanServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CommPScanServiceFutureStub> {
    private CommPScanServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommPScanServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommPScanServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> createScenario(
        zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanCreateScenarioRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateScenarioMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> closeScenario(
        zb.dcts.scenario.Scenario.ScenarioId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloseScenarioMethod(), getCallOptions()), request);
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
  }

  private static final int METHODID_CREATE_SCENARIO = 0;
  private static final int METHODID_GET_PSCAN_RESULT = 1;
  private static final int METHODID_CLOSE_SCENARIO = 2;
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

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommPScanServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommPScanServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SCENARIO:
          serviceImpl.createScenario((zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanCreateScenarioRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_GET_PSCAN_RESULT:
          serviceImpl.getPScanResult((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commSpectrum.KhCommPScan.CommPScanResult>) responseObserver);
          break;
        case METHODID_CLOSE_SCENARIO:
          serviceImpl.closeScenario((zb.dcts.scenario.Scenario.ScenarioId) request,
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

  private static abstract class CommPScanServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommPScanServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.kh.commSpectrum.KhCommPScan.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommPScanService");
    }
  }

  private static final class CommPScanServiceFileDescriptorSupplier
      extends CommPScanServiceBaseDescriptorSupplier {
    CommPScanServiceFileDescriptorSupplier() {}
  }

  private static final class CommPScanServiceMethodDescriptorSupplier
      extends CommPScanServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommPScanServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommPScanServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommPScanServiceFileDescriptorSupplier())
              .addMethod(getCreateScenarioMethod())
              .addMethod(getGetPScanResultMethod())
              .addMethod(getCloseScenarioMethod())
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
              .build();
        }
      }
    }
    return result;
  }
}
