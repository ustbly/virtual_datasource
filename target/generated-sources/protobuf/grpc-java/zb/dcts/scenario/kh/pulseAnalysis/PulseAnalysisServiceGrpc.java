package zb.dcts.scenario.kh.pulseAnalysis;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/kh/KhPulseAnalysis.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PulseAnalysisServiceGrpc {

  private PulseAnalysisServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.kh.pulseAnalysis.PulseAnalysisService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseAnalysisTaskRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartTask",
      requestType = zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseAnalysisTaskRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseAnalysisTaskRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseAnalysisTaskRequest, zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod;
    if ((getStartTaskMethod = PulseAnalysisServiceGrpc.getStartTaskMethod) == null) {
      synchronized (PulseAnalysisServiceGrpc.class) {
        if ((getStartTaskMethod = PulseAnalysisServiceGrpc.getStartTaskMethod) == null) {
          PulseAnalysisServiceGrpc.getStartTaskMethod = getStartTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseAnalysisTaskRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseAnalysisTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new PulseAnalysisServiceMethodDescriptorSupplier("StartTask"))
              .build();
        }
      }
    }
    return getStartTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseResult> getGetResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetResult",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseResult> getGetResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseResult> getGetResultMethod;
    if ((getGetResultMethod = PulseAnalysisServiceGrpc.getGetResultMethod) == null) {
      synchronized (PulseAnalysisServiceGrpc.class) {
        if ((getGetResultMethod = PulseAnalysisServiceGrpc.getGetResultMethod) == null) {
          PulseAnalysisServiceGrpc.getGetResultMethod = getGetResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseResult.getDefaultInstance()))
              .setSchemaDescriptor(new PulseAnalysisServiceMethodDescriptorSupplier("GetResult"))
              .build();
        }
      }
    }
    return getGetResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.ChangePulseRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getChangeParamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeParam",
      requestType = zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.ChangePulseRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.ChangePulseRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getChangeParamMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.ChangePulseRequest, zb.dcts.scenario.Scenario.ScenarioReply> getChangeParamMethod;
    if ((getChangeParamMethod = PulseAnalysisServiceGrpc.getChangeParamMethod) == null) {
      synchronized (PulseAnalysisServiceGrpc.class) {
        if ((getChangeParamMethod = PulseAnalysisServiceGrpc.getChangeParamMethod) == null) {
          PulseAnalysisServiceGrpc.getChangeParamMethod = getChangeParamMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.ChangePulseRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ChangeParam"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.ChangePulseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new PulseAnalysisServiceMethodDescriptorSupplier("ChangeParam"))
              .build();
        }
      }
    }
    return getChangeParamMethod;
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
    if ((getStopTaskMethod = PulseAnalysisServiceGrpc.getStopTaskMethod) == null) {
      synchronized (PulseAnalysisServiceGrpc.class) {
        if ((getStopTaskMethod = PulseAnalysisServiceGrpc.getStopTaskMethod) == null) {
          PulseAnalysisServiceGrpc.getStopTaskMethod = getStopTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new PulseAnalysisServiceMethodDescriptorSupplier("StopTask"))
              .build();
        }
      }
    }
    return getStopTaskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PulseAnalysisServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PulseAnalysisServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PulseAnalysisServiceStub>() {
        @java.lang.Override
        public PulseAnalysisServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PulseAnalysisServiceStub(channel, callOptions);
        }
      };
    return PulseAnalysisServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PulseAnalysisServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PulseAnalysisServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PulseAnalysisServiceBlockingStub>() {
        @java.lang.Override
        public PulseAnalysisServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PulseAnalysisServiceBlockingStub(channel, callOptions);
        }
      };
    return PulseAnalysisServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PulseAnalysisServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PulseAnalysisServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PulseAnalysisServiceFutureStub>() {
        @java.lang.Override
        public PulseAnalysisServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PulseAnalysisServiceFutureStub(channel, callOptions);
        }
      };
    return PulseAnalysisServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PulseAnalysisServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void startTask(zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseAnalysisTaskRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartTaskMethod(), responseObserver);
    }

    /**
     */
    public void getResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetResultMethod(), responseObserver);
    }

    /**
     */
    public void changeParam(zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.ChangePulseRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChangeParamMethod(), responseObserver);
    }

    /**
     */
    public void stopTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopTaskMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStartTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseAnalysisTaskRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_START_TASK)))
          .addMethod(
            getGetResultMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseResult>(
                  this, METHODID_GET_RESULT)))
          .addMethod(
            getChangeParamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.ChangePulseRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CHANGE_PARAM)))
          .addMethod(
            getStopTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_STOP_TASK)))
          .build();
    }
  }

  /**
   */
  public static final class PulseAnalysisServiceStub extends io.grpc.stub.AbstractAsyncStub<PulseAnalysisServiceStub> {
    private PulseAnalysisServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PulseAnalysisServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PulseAnalysisServiceStub(channel, callOptions);
    }

    /**
     */
    public void startTask(zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseAnalysisTaskRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeParam(zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.ChangePulseRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChangeParamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stopTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopTaskMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PulseAnalysisServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PulseAnalysisServiceBlockingStub> {
    private PulseAnalysisServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PulseAnalysisServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PulseAnalysisServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply startTask(zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseAnalysisTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseResult> getResult(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetResultMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply changeParam(zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.ChangePulseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChangeParamMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply stopTask(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopTaskMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PulseAnalysisServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PulseAnalysisServiceFutureStub> {
    private PulseAnalysisServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PulseAnalysisServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PulseAnalysisServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> startTask(
        zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseAnalysisTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartTaskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> changeParam(
        zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.ChangePulseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChangeParamMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> stopTask(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopTaskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_TASK = 0;
  private static final int METHODID_GET_RESULT = 1;
  private static final int METHODID_CHANGE_PARAM = 2;
  private static final int METHODID_STOP_TASK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PulseAnalysisServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PulseAnalysisServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_TASK:
          serviceImpl.startTask((zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseAnalysisTaskRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_GET_RESULT:
          serviceImpl.getResult((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.CommPulseResult>) responseObserver);
          break;
        case METHODID_CHANGE_PARAM:
          serviceImpl.changeParam((zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.ChangePulseRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_STOP_TASK:
          serviceImpl.stopTask((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
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

  private static abstract class PulseAnalysisServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PulseAnalysisServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.kh.pulseAnalysis.KhPulseAnalysis.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PulseAnalysisService");
    }
  }

  private static final class PulseAnalysisServiceFileDescriptorSupplier
      extends PulseAnalysisServiceBaseDescriptorSupplier {
    PulseAnalysisServiceFileDescriptorSupplier() {}
  }

  private static final class PulseAnalysisServiceMethodDescriptorSupplier
      extends PulseAnalysisServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PulseAnalysisServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PulseAnalysisServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PulseAnalysisServiceFileDescriptorSupplier())
              .addMethod(getStartTaskMethod())
              .addMethod(getGetResultMethod())
              .addMethod(getChangeParamMethod())
              .addMethod(getStopTaskMethod())
              .build();
        }
      }
    }
    return result;
  }
}
