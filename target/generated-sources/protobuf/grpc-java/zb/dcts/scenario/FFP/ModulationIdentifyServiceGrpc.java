package zb.dcts.scenario.FFP;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/FFP/modIdentify.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ModulationIdentifyServiceGrpc {

  private ModulationIdentifyServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.FFP.ModulationIdentifyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.FFP.ModIdentify.ModIdentifyRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartModIdentifyTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartModIdentifyTask",
      requestType = zb.dcts.scenario.FFP.ModIdentify.ModIdentifyRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.FFP.ModIdentify.ModIdentifyRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartModIdentifyTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.FFP.ModIdentify.ModIdentifyRequest, zb.dcts.scenario.Scenario.ScenarioReply> getStartModIdentifyTaskMethod;
    if ((getStartModIdentifyTaskMethod = ModulationIdentifyServiceGrpc.getStartModIdentifyTaskMethod) == null) {
      synchronized (ModulationIdentifyServiceGrpc.class) {
        if ((getStartModIdentifyTaskMethod = ModulationIdentifyServiceGrpc.getStartModIdentifyTaskMethod) == null) {
          ModulationIdentifyServiceGrpc.getStartModIdentifyTaskMethod = getStartModIdentifyTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.FFP.ModIdentify.ModIdentifyRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartModIdentifyTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.FFP.ModIdentify.ModIdentifyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new ModulationIdentifyServiceMethodDescriptorSupplier("StartModIdentifyTask"))
              .build();
        }
      }
    }
    return getStartModIdentifyTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getStopModIdentifyTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopModIdentifyTask",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getStopModIdentifyTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply> getStopModIdentifyTaskMethod;
    if ((getStopModIdentifyTaskMethod = ModulationIdentifyServiceGrpc.getStopModIdentifyTaskMethod) == null) {
      synchronized (ModulationIdentifyServiceGrpc.class) {
        if ((getStopModIdentifyTaskMethod = ModulationIdentifyServiceGrpc.getStopModIdentifyTaskMethod) == null) {
          ModulationIdentifyServiceGrpc.getStopModIdentifyTaskMethod = getStopModIdentifyTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopModIdentifyTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new ModulationIdentifyServiceMethodDescriptorSupplier("StopModIdentifyTask"))
              .build();
        }
      }
    }
    return getStopModIdentifyTaskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ModulationIdentifyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModulationIdentifyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ModulationIdentifyServiceStub>() {
        @java.lang.Override
        public ModulationIdentifyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ModulationIdentifyServiceStub(channel, callOptions);
        }
      };
    return ModulationIdentifyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ModulationIdentifyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModulationIdentifyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ModulationIdentifyServiceBlockingStub>() {
        @java.lang.Override
        public ModulationIdentifyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ModulationIdentifyServiceBlockingStub(channel, callOptions);
        }
      };
    return ModulationIdentifyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ModulationIdentifyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModulationIdentifyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ModulationIdentifyServiceFutureStub>() {
        @java.lang.Override
        public ModulationIdentifyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ModulationIdentifyServiceFutureStub(channel, callOptions);
        }
      };
    return ModulationIdentifyServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ModulationIdentifyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void startModIdentifyTask(zb.dcts.scenario.FFP.ModIdentify.ModIdentifyRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartModIdentifyTaskMethod(), responseObserver);
    }

    /**
     * <pre>
     *rpc GetModIdentifyResult(ScenarioTaskId) returns (ModIdentifyResult) {}
     *rpc GetModIdentifySpectrum(ScenarioTaskId) returns (stream ModIdentifyResult) {}
     * </pre>
     */
    public void stopModIdentifyTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopModIdentifyTaskMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStartModIdentifyTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.FFP.ModIdentify.ModIdentifyRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_START_MOD_IDENTIFY_TASK)))
          .addMethod(
            getStopModIdentifyTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_STOP_MOD_IDENTIFY_TASK)))
          .build();
    }
  }

  /**
   */
  public static final class ModulationIdentifyServiceStub extends io.grpc.stub.AbstractAsyncStub<ModulationIdentifyServiceStub> {
    private ModulationIdentifyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModulationIdentifyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModulationIdentifyServiceStub(channel, callOptions);
    }

    /**
     */
    public void startModIdentifyTask(zb.dcts.scenario.FFP.ModIdentify.ModIdentifyRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartModIdentifyTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *rpc GetModIdentifyResult(ScenarioTaskId) returns (ModIdentifyResult) {}
     *rpc GetModIdentifySpectrum(ScenarioTaskId) returns (stream ModIdentifyResult) {}
     * </pre>
     */
    public void stopModIdentifyTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopModIdentifyTaskMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ModulationIdentifyServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ModulationIdentifyServiceBlockingStub> {
    private ModulationIdentifyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModulationIdentifyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModulationIdentifyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply startModIdentifyTask(zb.dcts.scenario.FFP.ModIdentify.ModIdentifyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartModIdentifyTaskMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *rpc GetModIdentifyResult(ScenarioTaskId) returns (ModIdentifyResult) {}
     *rpc GetModIdentifySpectrum(ScenarioTaskId) returns (stream ModIdentifyResult) {}
     * </pre>
     */
    public zb.dcts.scenario.Scenario.ScenarioReply stopModIdentifyTask(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopModIdentifyTaskMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ModulationIdentifyServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ModulationIdentifyServiceFutureStub> {
    private ModulationIdentifyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModulationIdentifyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModulationIdentifyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> startModIdentifyTask(
        zb.dcts.scenario.FFP.ModIdentify.ModIdentifyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartModIdentifyTaskMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *rpc GetModIdentifyResult(ScenarioTaskId) returns (ModIdentifyResult) {}
     *rpc GetModIdentifySpectrum(ScenarioTaskId) returns (stream ModIdentifyResult) {}
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> stopModIdentifyTask(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopModIdentifyTaskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_MOD_IDENTIFY_TASK = 0;
  private static final int METHODID_STOP_MOD_IDENTIFY_TASK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ModulationIdentifyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ModulationIdentifyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_MOD_IDENTIFY_TASK:
          serviceImpl.startModIdentifyTask((zb.dcts.scenario.FFP.ModIdentify.ModIdentifyRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_STOP_MOD_IDENTIFY_TASK:
          serviceImpl.stopModIdentifyTask((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
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

  private static abstract class ModulationIdentifyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ModulationIdentifyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.FFP.ModIdentify.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ModulationIdentifyService");
    }
  }

  private static final class ModulationIdentifyServiceFileDescriptorSupplier
      extends ModulationIdentifyServiceBaseDescriptorSupplier {
    ModulationIdentifyServiceFileDescriptorSupplier() {}
  }

  private static final class ModulationIdentifyServiceMethodDescriptorSupplier
      extends ModulationIdentifyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ModulationIdentifyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ModulationIdentifyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ModulationIdentifyServiceFileDescriptorSupplier())
              .addMethod(getStartModIdentifyTaskMethod())
              .addMethod(getStopModIdentifyTaskMethod())
              .build();
        }
      }
    }
    return result;
  }
}
