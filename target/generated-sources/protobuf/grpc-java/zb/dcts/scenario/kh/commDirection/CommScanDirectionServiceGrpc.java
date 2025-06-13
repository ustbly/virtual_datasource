package zb.dcts.scenario.kh.commDirection;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/kh/KhCommScanDirection.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CommScanDirectionServiceGrpc {

  private CommScanDirectionServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.kh.commDirection.CommScanDirectionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommScanDirection.CommScanDirectionCreateScenarioRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getCreateScenarioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateScenario",
      requestType = zb.dcts.scenario.kh.commDirection.KhCommScanDirection.CommScanDirectionCreateScenarioRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommScanDirection.CommScanDirectionCreateScenarioRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getCreateScenarioMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommScanDirection.CommScanDirectionCreateScenarioRequest, zb.dcts.scenario.Scenario.ScenarioReply> getCreateScenarioMethod;
    if ((getCreateScenarioMethod = CommScanDirectionServiceGrpc.getCreateScenarioMethod) == null) {
      synchronized (CommScanDirectionServiceGrpc.class) {
        if ((getCreateScenarioMethod = CommScanDirectionServiceGrpc.getCreateScenarioMethod) == null) {
          CommScanDirectionServiceGrpc.getCreateScenarioMethod = getCreateScenarioMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.commDirection.KhCommScanDirection.CommScanDirectionCreateScenarioRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateScenario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commDirection.KhCommScanDirection.CommScanDirectionCreateScenarioRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommScanDirectionServiceMethodDescriptorSupplier("CreateScenario"))
              .build();
        }
      }
    }
    return getCreateScenarioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult> getGetScanResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScanResult",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult> getGetScanResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult> getGetScanResultMethod;
    if ((getGetScanResultMethod = CommScanDirectionServiceGrpc.getGetScanResultMethod) == null) {
      synchronized (CommScanDirectionServiceGrpc.class) {
        if ((getGetScanResultMethod = CommScanDirectionServiceGrpc.getGetScanResultMethod) == null) {
          CommScanDirectionServiceGrpc.getGetScanResultMethod = getGetScanResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetScanResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult.getDefaultInstance()))
              .setSchemaDescriptor(new CommScanDirectionServiceMethodDescriptorSupplier("GetScanResult"))
              .build();
        }
      }
    }
    return getGetScanResultMethod;
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
    if ((getCloseScenarioMethod = CommScanDirectionServiceGrpc.getCloseScenarioMethod) == null) {
      synchronized (CommScanDirectionServiceGrpc.class) {
        if ((getCloseScenarioMethod = CommScanDirectionServiceGrpc.getCloseScenarioMethod) == null) {
          CommScanDirectionServiceGrpc.getCloseScenarioMethod = getCloseScenarioMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseScenario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommScanDirectionServiceMethodDescriptorSupplier("CloseScenario"))
              .build();
        }
      }
    }
    return getCloseScenarioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getChangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Change",
      requestType = zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getChangeMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest, zb.dcts.scenario.Scenario.ScenarioReply> getChangeMethod;
    if ((getChangeMethod = CommScanDirectionServiceGrpc.getChangeMethod) == null) {
      synchronized (CommScanDirectionServiceGrpc.class) {
        if ((getChangeMethod = CommScanDirectionServiceGrpc.getChangeMethod) == null) {
          CommScanDirectionServiceGrpc.getChangeMethod = getChangeMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Change"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommScanDirectionServiceMethodDescriptorSupplier("Change"))
              .build();
        }
      }
    }
    return getChangeMethod;
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
    if ((getOpenZoomInMethod = CommScanDirectionServiceGrpc.getOpenZoomInMethod) == null) {
      synchronized (CommScanDirectionServiceGrpc.class) {
        if ((getOpenZoomInMethod = CommScanDirectionServiceGrpc.getOpenZoomInMethod) == null) {
          CommScanDirectionServiceGrpc.getOpenZoomInMethod = getOpenZoomInMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenZoomIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommScanDirectionServiceMethodDescriptorSupplier("OpenZoomIn"))
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
    if ((getCloseZoomInMethod = CommScanDirectionServiceGrpc.getCloseZoomInMethod) == null) {
      synchronized (CommScanDirectionServiceGrpc.class) {
        if ((getCloseZoomInMethod = CommScanDirectionServiceGrpc.getCloseZoomInMethod) == null) {
          CommScanDirectionServiceGrpc.getCloseZoomInMethod = getCloseZoomInMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseZoomIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommScanDirectionServiceMethodDescriptorSupplier("CloseZoomIn"))
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
    if ((getOpenDataHoldMethod = CommScanDirectionServiceGrpc.getOpenDataHoldMethod) == null) {
      synchronized (CommScanDirectionServiceGrpc.class) {
        if ((getOpenDataHoldMethod = CommScanDirectionServiceGrpc.getOpenDataHoldMethod) == null) {
          CommScanDirectionServiceGrpc.getOpenDataHoldMethod = getOpenDataHoldMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenDataHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommScanDirectionServiceMethodDescriptorSupplier("OpenDataHold"))
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
    if ((getResetDataHoldMethod = CommScanDirectionServiceGrpc.getResetDataHoldMethod) == null) {
      synchronized (CommScanDirectionServiceGrpc.class) {
        if ((getResetDataHoldMethod = CommScanDirectionServiceGrpc.getResetDataHoldMethod) == null) {
          CommScanDirectionServiceGrpc.getResetDataHoldMethod = getResetDataHoldMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetDataHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommScanDirectionServiceMethodDescriptorSupplier("ResetDataHold"))
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
    if ((getCloseDataHoldMethod = CommScanDirectionServiceGrpc.getCloseDataHoldMethod) == null) {
      synchronized (CommScanDirectionServiceGrpc.class) {
        if ((getCloseDataHoldMethod = CommScanDirectionServiceGrpc.getCloseDataHoldMethod) == null) {
          CommScanDirectionServiceGrpc.getCloseDataHoldMethod = getCloseDataHoldMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseDataHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommScanDirectionServiceMethodDescriptorSupplier("CloseDataHold"))
              .build();
        }
      }
    }
    return getCloseDataHoldMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommScanDirectionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommScanDirectionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommScanDirectionServiceStub>() {
        @java.lang.Override
        public CommScanDirectionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommScanDirectionServiceStub(channel, callOptions);
        }
      };
    return CommScanDirectionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommScanDirectionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommScanDirectionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommScanDirectionServiceBlockingStub>() {
        @java.lang.Override
        public CommScanDirectionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommScanDirectionServiceBlockingStub(channel, callOptions);
        }
      };
    return CommScanDirectionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommScanDirectionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommScanDirectionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommScanDirectionServiceFutureStub>() {
        @java.lang.Override
        public CommScanDirectionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommScanDirectionServiceFutureStub(channel, callOptions);
        }
      };
    return CommScanDirectionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CommScanDirectionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createScenario(zb.dcts.scenario.kh.commDirection.KhCommScanDirection.CommScanDirectionCreateScenarioRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateScenarioMethod(), responseObserver);
    }

    /**
     */
    public void getScanResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetScanResultMethod(), responseObserver);
    }

    /**
     */
    public void closeScenario(zb.dcts.scenario.Scenario.ScenarioId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseScenarioMethod(), responseObserver);
    }

    /**
     */
    public void change(zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChangeMethod(), responseObserver);
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

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateScenarioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.kh.commDirection.KhCommScanDirection.CommScanDirectionCreateScenarioRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CREATE_SCENARIO)))
          .addMethod(
            getGetScanResultMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult>(
                  this, METHODID_GET_SCAN_RESULT)))
          .addMethod(
            getCloseScenarioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CLOSE_SCENARIO)))
          .addMethod(
            getChangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CHANGE)))
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
          .build();
    }
  }

  /**
   */
  public static final class CommScanDirectionServiceStub extends io.grpc.stub.AbstractAsyncStub<CommScanDirectionServiceStub> {
    private CommScanDirectionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommScanDirectionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommScanDirectionServiceStub(channel, callOptions);
    }

    /**
     */
    public void createScenario(zb.dcts.scenario.kh.commDirection.KhCommScanDirection.CommScanDirectionCreateScenarioRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateScenarioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getScanResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetScanResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeScenario(zb.dcts.scenario.Scenario.ScenarioId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseScenarioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void change(zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChangeMethod(), getCallOptions()), request, responseObserver);
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
  }

  /**
   */
  public static final class CommScanDirectionServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CommScanDirectionServiceBlockingStub> {
    private CommScanDirectionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommScanDirectionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommScanDirectionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply createScenario(zb.dcts.scenario.kh.commDirection.KhCommScanDirection.CommScanDirectionCreateScenarioRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateScenarioMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult> getScanResult(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetScanResultMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply closeScenario(zb.dcts.scenario.Scenario.ScenarioId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseScenarioMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply change(zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChangeMethod(), getCallOptions(), request);
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
  }

  /**
   */
  public static final class CommScanDirectionServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CommScanDirectionServiceFutureStub> {
    private CommScanDirectionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommScanDirectionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommScanDirectionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> createScenario(
        zb.dcts.scenario.kh.commDirection.KhCommScanDirection.CommScanDirectionCreateScenarioRequest request) {
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
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> change(
        zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChangeMethod(), getCallOptions()), request);
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
  }

  private static final int METHODID_CREATE_SCENARIO = 0;
  private static final int METHODID_GET_SCAN_RESULT = 1;
  private static final int METHODID_CLOSE_SCENARIO = 2;
  private static final int METHODID_CHANGE = 3;
  private static final int METHODID_OPEN_ZOOM_IN = 4;
  private static final int METHODID_CLOSE_ZOOM_IN = 5;
  private static final int METHODID_OPEN_DATA_HOLD = 6;
  private static final int METHODID_RESET_DATA_HOLD = 7;
  private static final int METHODID_CLOSE_DATA_HOLD = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommScanDirectionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommScanDirectionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SCENARIO:
          serviceImpl.createScenario((zb.dcts.scenario.kh.commDirection.KhCommScanDirection.CommScanDirectionCreateScenarioRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_GET_SCAN_RESULT:
          serviceImpl.getScanResult((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult>) responseObserver);
          break;
        case METHODID_CLOSE_SCENARIO:
          serviceImpl.closeScenario((zb.dcts.scenario.Scenario.ScenarioId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_CHANGE:
          serviceImpl.change((zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest) request,
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

  private static abstract class CommScanDirectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommScanDirectionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.kh.commDirection.KhCommScanDirection.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommScanDirectionService");
    }
  }

  private static final class CommScanDirectionServiceFileDescriptorSupplier
      extends CommScanDirectionServiceBaseDescriptorSupplier {
    CommScanDirectionServiceFileDescriptorSupplier() {}
  }

  private static final class CommScanDirectionServiceMethodDescriptorSupplier
      extends CommScanDirectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommScanDirectionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommScanDirectionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommScanDirectionServiceFileDescriptorSupplier())
              .addMethod(getCreateScenarioMethod())
              .addMethod(getGetScanResultMethod())
              .addMethod(getCloseScenarioMethod())
              .addMethod(getChangeMethod())
              .addMethod(getOpenZoomInMethod())
              .addMethod(getCloseZoomInMethod())
              .addMethod(getOpenDataHoldMethod())
              .addMethod(getResetDataHoldMethod())
              .addMethod(getCloseDataHoldMethod())
              .build();
        }
      }
    }
    return result;
  }
}
