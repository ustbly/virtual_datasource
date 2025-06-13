package zb.dcts.scenario.kh.commDirection;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/kh/KhCommFixDirection.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CommFixDirectionServiceGrpc {

  private CommFixDirectionServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.kh.commDirection.CommFixDirectionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommFixDirection.CommFixDirectionTaskRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartTask",
      requestType = zb.dcts.scenario.kh.commDirection.KhCommFixDirection.CommFixDirectionTaskRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommFixDirection.CommFixDirectionTaskRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommFixDirection.CommFixDirectionTaskRequest, zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod;
    if ((getStartTaskMethod = CommFixDirectionServiceGrpc.getStartTaskMethod) == null) {
      synchronized (CommFixDirectionServiceGrpc.class) {
        if ((getStartTaskMethod = CommFixDirectionServiceGrpc.getStartTaskMethod) == null) {
          CommFixDirectionServiceGrpc.getStartTaskMethod = getStartTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.commDirection.KhCommFixDirection.CommFixDirectionTaskRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commDirection.KhCommFixDirection.CommFixDirectionTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommFixDirectionServiceMethodDescriptorSupplier("StartTask"))
              .build();
        }
      }
    }
    return getStartTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult> getGetFixResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFixResult",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult> getGetFixResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult> getGetFixResultMethod;
    if ((getGetFixResultMethod = CommFixDirectionServiceGrpc.getGetFixResultMethod) == null) {
      synchronized (CommFixDirectionServiceGrpc.class) {
        if ((getGetFixResultMethod = CommFixDirectionServiceGrpc.getGetFixResultMethod) == null) {
          CommFixDirectionServiceGrpc.getGetFixResultMethod = getGetFixResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFixResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult.getDefaultInstance()))
              .setSchemaDescriptor(new CommFixDirectionServiceMethodDescriptorSupplier("GetFixResult"))
              .build();
        }
      }
    }
    return getGetFixResultMethod;
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
    if ((getStopTaskMethod = CommFixDirectionServiceGrpc.getStopTaskMethod) == null) {
      synchronized (CommFixDirectionServiceGrpc.class) {
        if ((getStopTaskMethod = CommFixDirectionServiceGrpc.getStopTaskMethod) == null) {
          CommFixDirectionServiceGrpc.getStopTaskMethod = getStopTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommFixDirectionServiceMethodDescriptorSupplier("StopTask"))
              .build();
        }
      }
    }
    return getStopTaskMethod;
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
    if ((getChangeMethod = CommFixDirectionServiceGrpc.getChangeMethod) == null) {
      synchronized (CommFixDirectionServiceGrpc.class) {
        if ((getChangeMethod = CommFixDirectionServiceGrpc.getChangeMethod) == null) {
          CommFixDirectionServiceGrpc.getChangeMethod = getChangeMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Change"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.DirectionChangeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommFixDirectionServiceMethodDescriptorSupplier("Change"))
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
    if ((getOpenZoomInMethod = CommFixDirectionServiceGrpc.getOpenZoomInMethod) == null) {
      synchronized (CommFixDirectionServiceGrpc.class) {
        if ((getOpenZoomInMethod = CommFixDirectionServiceGrpc.getOpenZoomInMethod) == null) {
          CommFixDirectionServiceGrpc.getOpenZoomInMethod = getOpenZoomInMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenZoomIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.ZoomInRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommFixDirectionServiceMethodDescriptorSupplier("OpenZoomIn"))
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
    if ((getCloseZoomInMethod = CommFixDirectionServiceGrpc.getCloseZoomInMethod) == null) {
      synchronized (CommFixDirectionServiceGrpc.class) {
        if ((getCloseZoomInMethod = CommFixDirectionServiceGrpc.getCloseZoomInMethod) == null) {
          CommFixDirectionServiceGrpc.getCloseZoomInMethod = getCloseZoomInMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseZoomIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommFixDirectionServiceMethodDescriptorSupplier("CloseZoomIn"))
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
    if ((getOpenDataHoldMethod = CommFixDirectionServiceGrpc.getOpenDataHoldMethod) == null) {
      synchronized (CommFixDirectionServiceGrpc.class) {
        if ((getOpenDataHoldMethod = CommFixDirectionServiceGrpc.getOpenDataHoldMethod) == null) {
          CommFixDirectionServiceGrpc.getOpenDataHoldMethod = getOpenDataHoldMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenDataHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommFixDirectionServiceMethodDescriptorSupplier("OpenDataHold"))
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
    if ((getResetDataHoldMethod = CommFixDirectionServiceGrpc.getResetDataHoldMethod) == null) {
      synchronized (CommFixDirectionServiceGrpc.class) {
        if ((getResetDataHoldMethod = CommFixDirectionServiceGrpc.getResetDataHoldMethod) == null) {
          CommFixDirectionServiceGrpc.getResetDataHoldMethod = getResetDataHoldMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetDataHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommFixDirectionServiceMethodDescriptorSupplier("ResetDataHold"))
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
    if ((getCloseDataHoldMethod = CommFixDirectionServiceGrpc.getCloseDataHoldMethod) == null) {
      synchronized (CommFixDirectionServiceGrpc.class) {
        if ((getCloseDataHoldMethod = CommFixDirectionServiceGrpc.getCloseDataHoldMethod) == null) {
          CommFixDirectionServiceGrpc.getCloseDataHoldMethod = getCloseDataHoldMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseDataHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.spectrum.Spectrum.DataHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommFixDirectionServiceMethodDescriptorSupplier("CloseDataHold"))
              .build();
        }
      }
    }
    return getCloseDataHoldMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommFixDirectionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommFixDirectionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommFixDirectionServiceStub>() {
        @java.lang.Override
        public CommFixDirectionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommFixDirectionServiceStub(channel, callOptions);
        }
      };
    return CommFixDirectionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommFixDirectionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommFixDirectionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommFixDirectionServiceBlockingStub>() {
        @java.lang.Override
        public CommFixDirectionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommFixDirectionServiceBlockingStub(channel, callOptions);
        }
      };
    return CommFixDirectionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommFixDirectionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommFixDirectionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommFixDirectionServiceFutureStub>() {
        @java.lang.Override
        public CommFixDirectionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommFixDirectionServiceFutureStub(channel, callOptions);
        }
      };
    return CommFixDirectionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CommFixDirectionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void startTask(zb.dcts.scenario.kh.commDirection.KhCommFixDirection.CommFixDirectionTaskRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartTaskMethod(), responseObserver);
    }

    /**
     */
    public void getFixResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFixResultMethod(), responseObserver);
    }

    /**
     */
    public void stopTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopTaskMethod(), responseObserver);
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
            getStartTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.kh.commDirection.KhCommFixDirection.CommFixDirectionTaskRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_START_TASK)))
          .addMethod(
            getGetFixResultMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult>(
                  this, METHODID_GET_FIX_RESULT)))
          .addMethod(
            getStopTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_STOP_TASK)))
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
  public static final class CommFixDirectionServiceStub extends io.grpc.stub.AbstractAsyncStub<CommFixDirectionServiceStub> {
    private CommFixDirectionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommFixDirectionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommFixDirectionServiceStub(channel, callOptions);
    }

    /**
     */
    public void startTask(zb.dcts.scenario.kh.commDirection.KhCommFixDirection.CommFixDirectionTaskRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFixResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetFixResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stopTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopTaskMethod(), getCallOptions()), request, responseObserver);
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
  public static final class CommFixDirectionServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CommFixDirectionServiceBlockingStub> {
    private CommFixDirectionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommFixDirectionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommFixDirectionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply startTask(zb.dcts.scenario.kh.commDirection.KhCommFixDirection.CommFixDirectionTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult> getFixResult(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetFixResultMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply stopTask(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopTaskMethod(), getCallOptions(), request);
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
  public static final class CommFixDirectionServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CommFixDirectionServiceFutureStub> {
    private CommFixDirectionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommFixDirectionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommFixDirectionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> startTask(
        zb.dcts.scenario.kh.commDirection.KhCommFixDirection.CommFixDirectionTaskRequest request) {
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

  private static final int METHODID_START_TASK = 0;
  private static final int METHODID_GET_FIX_RESULT = 1;
  private static final int METHODID_STOP_TASK = 2;
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
    private final CommFixDirectionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommFixDirectionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_TASK:
          serviceImpl.startTask((zb.dcts.scenario.kh.commDirection.KhCommFixDirection.CommFixDirectionTaskRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_GET_FIX_RESULT:
          serviceImpl.getFixResult((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult>) responseObserver);
          break;
        case METHODID_STOP_TASK:
          serviceImpl.stopTask((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
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

  private static abstract class CommFixDirectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommFixDirectionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.kh.commDirection.KhCommFixDirection.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommFixDirectionService");
    }
  }

  private static final class CommFixDirectionServiceFileDescriptorSupplier
      extends CommFixDirectionServiceBaseDescriptorSupplier {
    CommFixDirectionServiceFileDescriptorSupplier() {}
  }

  private static final class CommFixDirectionServiceMethodDescriptorSupplier
      extends CommFixDirectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommFixDirectionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommFixDirectionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommFixDirectionServiceFileDescriptorSupplier())
              .addMethod(getStartTaskMethod())
              .addMethod(getGetFixResultMethod())
              .addMethod(getStopTaskMethod())
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
