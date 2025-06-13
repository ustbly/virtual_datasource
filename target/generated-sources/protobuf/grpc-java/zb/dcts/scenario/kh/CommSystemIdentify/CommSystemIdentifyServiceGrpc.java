package zb.dcts.scenario.kh.CommSystemIdentify;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/kh/KhComSystemIdentify.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CommSystemIdentifyServiceGrpc {

  private CommSystemIdentifyServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.CommSystemIdentifyTaskRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartTask",
      requestType = zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.CommSystemIdentifyTaskRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.CommSystemIdentifyTaskRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.CommSystemIdentifyTaskRequest, zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod;
    if ((getStartTaskMethod = CommSystemIdentifyServiceGrpc.getStartTaskMethod) == null) {
      synchronized (CommSystemIdentifyServiceGrpc.class) {
        if ((getStartTaskMethod = CommSystemIdentifyServiceGrpc.getStartTaskMethod) == null) {
          CommSystemIdentifyServiceGrpc.getStartTaskMethod = getStartTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.CommSystemIdentifyTaskRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.CommSystemIdentifyTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommSystemIdentifyServiceMethodDescriptorSupplier("StartTask"))
              .build();
        }
      }
    }
    return getStartTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemIdentifyResult> getGetResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetResult",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemIdentifyResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemIdentifyResult> getGetResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemIdentifyResult> getGetResultMethod;
    if ((getGetResultMethod = CommSystemIdentifyServiceGrpc.getGetResultMethod) == null) {
      synchronized (CommSystemIdentifyServiceGrpc.class) {
        if ((getGetResultMethod = CommSystemIdentifyServiceGrpc.getGetResultMethod) == null) {
          CommSystemIdentifyServiceGrpc.getGetResultMethod = getGetResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemIdentifyResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemIdentifyResult.getDefaultInstance()))
              .setSchemaDescriptor(new CommSystemIdentifyServiceMethodDescriptorSupplier("GetResult"))
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
    if ((getStopTaskMethod = CommSystemIdentifyServiceGrpc.getStopTaskMethod) == null) {
      synchronized (CommSystemIdentifyServiceGrpc.class) {
        if ((getStopTaskMethod = CommSystemIdentifyServiceGrpc.getStopTaskMethod) == null) {
          CommSystemIdentifyServiceGrpc.getStopTaskMethod = getStopTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommSystemIdentifyServiceMethodDescriptorSupplier("StopTask"))
              .build();
        }
      }
    }
    return getStopTaskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommSystemIdentifyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommSystemIdentifyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommSystemIdentifyServiceStub>() {
        @java.lang.Override
        public CommSystemIdentifyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommSystemIdentifyServiceStub(channel, callOptions);
        }
      };
    return CommSystemIdentifyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommSystemIdentifyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommSystemIdentifyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommSystemIdentifyServiceBlockingStub>() {
        @java.lang.Override
        public CommSystemIdentifyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommSystemIdentifyServiceBlockingStub(channel, callOptions);
        }
      };
    return CommSystemIdentifyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommSystemIdentifyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommSystemIdentifyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommSystemIdentifyServiceFutureStub>() {
        @java.lang.Override
        public CommSystemIdentifyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommSystemIdentifyServiceFutureStub(channel, callOptions);
        }
      };
    return CommSystemIdentifyServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CommSystemIdentifyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void startTask(zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.CommSystemIdentifyTaskRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartTaskMethod(), responseObserver);
    }

    /**
     */
    public void getResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemIdentifyResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetResultMethod(), responseObserver);
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
                zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.CommSystemIdentifyTaskRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_START_TASK)))
          .addMethod(
            getGetResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemIdentifyResult>(
                  this, METHODID_GET_RESULT)))
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
  public static final class CommSystemIdentifyServiceStub extends io.grpc.stub.AbstractAsyncStub<CommSystemIdentifyServiceStub> {
    private CommSystemIdentifyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommSystemIdentifyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommSystemIdentifyServiceStub(channel, callOptions);
    }

    /**
     */
    public void startTask(zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.CommSystemIdentifyTaskRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemIdentifyResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetResultMethod(), getCallOptions()), request, responseObserver);
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
  public static final class CommSystemIdentifyServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CommSystemIdentifyServiceBlockingStub> {
    private CommSystemIdentifyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommSystemIdentifyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommSystemIdentifyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply startTask(zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.CommSystemIdentifyTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemIdentifyResult getResult(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResultMethod(), getCallOptions(), request);
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
  public static final class CommSystemIdentifyServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CommSystemIdentifyServiceFutureStub> {
    private CommSystemIdentifyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommSystemIdentifyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommSystemIdentifyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> startTask(
        zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.CommSystemIdentifyTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartTaskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemIdentifyResult> getResult(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetResultMethod(), getCallOptions()), request);
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
  private static final int METHODID_STOP_TASK = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommSystemIdentifyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommSystemIdentifyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_TASK:
          serviceImpl.startTask((zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.CommSystemIdentifyTaskRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_GET_RESULT:
          serviceImpl.getResult((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemIdentifyResult>) responseObserver);
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

  private static abstract class CommSystemIdentifyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommSystemIdentifyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.kh.CommSystemIdentify.KhComSystemIdentify.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommSystemIdentifyService");
    }
  }

  private static final class CommSystemIdentifyServiceFileDescriptorSupplier
      extends CommSystemIdentifyServiceBaseDescriptorSupplier {
    CommSystemIdentifyServiceFileDescriptorSupplier() {}
  }

  private static final class CommSystemIdentifyServiceMethodDescriptorSupplier
      extends CommSystemIdentifyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommSystemIdentifyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommSystemIdentifyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommSystemIdentifyServiceFileDescriptorSupplier())
              .addMethod(getStartTaskMethod())
              .addMethod(getGetResultMethod())
              .addMethod(getStopTaskMethod())
              .build();
        }
      }
    }
    return result;
  }
}
