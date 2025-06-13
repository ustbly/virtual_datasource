package zb.dcts.scenario.FFP;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/FFP/comSystemIdentify.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ComSystemIdentifyServiceGrpc {

  private ComSystemIdentifyServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.FFP.ComSystemIdentifyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartComSystemIdentifyTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartComSystemIdentifyTask",
      requestType = zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartComSystemIdentifyTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemRequest, zb.dcts.scenario.Scenario.ScenarioReply> getStartComSystemIdentifyTaskMethod;
    if ((getStartComSystemIdentifyTaskMethod = ComSystemIdentifyServiceGrpc.getStartComSystemIdentifyTaskMethod) == null) {
      synchronized (ComSystemIdentifyServiceGrpc.class) {
        if ((getStartComSystemIdentifyTaskMethod = ComSystemIdentifyServiceGrpc.getStartComSystemIdentifyTaskMethod) == null) {
          ComSystemIdentifyServiceGrpc.getStartComSystemIdentifyTaskMethod = getStartComSystemIdentifyTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartComSystemIdentifyTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new ComSystemIdentifyServiceMethodDescriptorSupplier("StartComSystemIdentifyTask"))
              .build();
        }
      }
    }
    return getStartComSystemIdentifyTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getStopComSystemIdentifyTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopComSystemIdentifyTask",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getStopComSystemIdentifyTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply> getStopComSystemIdentifyTaskMethod;
    if ((getStopComSystemIdentifyTaskMethod = ComSystemIdentifyServiceGrpc.getStopComSystemIdentifyTaskMethod) == null) {
      synchronized (ComSystemIdentifyServiceGrpc.class) {
        if ((getStopComSystemIdentifyTaskMethod = ComSystemIdentifyServiceGrpc.getStopComSystemIdentifyTaskMethod) == null) {
          ComSystemIdentifyServiceGrpc.getStopComSystemIdentifyTaskMethod = getStopComSystemIdentifyTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopComSystemIdentifyTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new ComSystemIdentifyServiceMethodDescriptorSupplier("StopComSystemIdentifyTask"))
              .build();
        }
      }
    }
    return getStopComSystemIdentifyTaskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ComSystemIdentifyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComSystemIdentifyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ComSystemIdentifyServiceStub>() {
        @java.lang.Override
        public ComSystemIdentifyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ComSystemIdentifyServiceStub(channel, callOptions);
        }
      };
    return ComSystemIdentifyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ComSystemIdentifyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComSystemIdentifyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ComSystemIdentifyServiceBlockingStub>() {
        @java.lang.Override
        public ComSystemIdentifyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ComSystemIdentifyServiceBlockingStub(channel, callOptions);
        }
      };
    return ComSystemIdentifyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ComSystemIdentifyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComSystemIdentifyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ComSystemIdentifyServiceFutureStub>() {
        @java.lang.Override
        public ComSystemIdentifyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ComSystemIdentifyServiceFutureStub(channel, callOptions);
        }
      };
    return ComSystemIdentifyServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ComSystemIdentifyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void startComSystemIdentifyTask(zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartComSystemIdentifyTaskMethod(), responseObserver);
    }

    /**
     * <pre>
     *rpc GetComSystemIdentifyResult(ScenarioTaskId) returns (ComSystemIdentifyResult) {}
     * </pre>
     */
    public void stopComSystemIdentifyTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopComSystemIdentifyTaskMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStartComSystemIdentifyTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_START_COM_SYSTEM_IDENTIFY_TASK)))
          .addMethod(
            getStopComSystemIdentifyTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_STOP_COM_SYSTEM_IDENTIFY_TASK)))
          .build();
    }
  }

  /**
   */
  public static final class ComSystemIdentifyServiceStub extends io.grpc.stub.AbstractAsyncStub<ComSystemIdentifyServiceStub> {
    private ComSystemIdentifyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComSystemIdentifyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComSystemIdentifyServiceStub(channel, callOptions);
    }

    /**
     */
    public void startComSystemIdentifyTask(zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartComSystemIdentifyTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *rpc GetComSystemIdentifyResult(ScenarioTaskId) returns (ComSystemIdentifyResult) {}
     * </pre>
     */
    public void stopComSystemIdentifyTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopComSystemIdentifyTaskMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ComSystemIdentifyServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ComSystemIdentifyServiceBlockingStub> {
    private ComSystemIdentifyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComSystemIdentifyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComSystemIdentifyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply startComSystemIdentifyTask(zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartComSystemIdentifyTaskMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *rpc GetComSystemIdentifyResult(ScenarioTaskId) returns (ComSystemIdentifyResult) {}
     * </pre>
     */
    public zb.dcts.scenario.Scenario.ScenarioReply stopComSystemIdentifyTask(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopComSystemIdentifyTaskMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ComSystemIdentifyServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ComSystemIdentifyServiceFutureStub> {
    private ComSystemIdentifyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComSystemIdentifyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComSystemIdentifyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> startComSystemIdentifyTask(
        zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartComSystemIdentifyTaskMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *rpc GetComSystemIdentifyResult(ScenarioTaskId) returns (ComSystemIdentifyResult) {}
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> stopComSystemIdentifyTask(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopComSystemIdentifyTaskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_COM_SYSTEM_IDENTIFY_TASK = 0;
  private static final int METHODID_STOP_COM_SYSTEM_IDENTIFY_TASK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ComSystemIdentifyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ComSystemIdentifyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_COM_SYSTEM_IDENTIFY_TASK:
          serviceImpl.startComSystemIdentifyTask((zb.dcts.scenario.FFP.ComSystemIdentify.ComSystemRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_STOP_COM_SYSTEM_IDENTIFY_TASK:
          serviceImpl.stopComSystemIdentifyTask((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
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

  private static abstract class ComSystemIdentifyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ComSystemIdentifyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.FFP.ComSystemIdentify.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ComSystemIdentifyService");
    }
  }

  private static final class ComSystemIdentifyServiceFileDescriptorSupplier
      extends ComSystemIdentifyServiceBaseDescriptorSupplier {
    ComSystemIdentifyServiceFileDescriptorSupplier() {}
  }

  private static final class ComSystemIdentifyServiceMethodDescriptorSupplier
      extends ComSystemIdentifyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ComSystemIdentifyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ComSystemIdentifyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ComSystemIdentifyServiceFileDescriptorSupplier())
              .addMethod(getStartComSystemIdentifyTaskMethod())
              .addMethod(getStopComSystemIdentifyTaskMethod())
              .build();
        }
      }
    }
    return result;
  }
}
