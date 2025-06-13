package zb.dcts.scenario.FFP;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/FFP/demodulate.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DemodulationServiceGrpc {

  private DemodulationServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.FFP.DemodulationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.FFP.Demodulate.AnalogDemodRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartAnalogDemodTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartAnalogDemodTask",
      requestType = zb.dcts.scenario.FFP.Demodulate.AnalogDemodRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.FFP.Demodulate.AnalogDemodRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartAnalogDemodTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.FFP.Demodulate.AnalogDemodRequest, zb.dcts.scenario.Scenario.ScenarioReply> getStartAnalogDemodTaskMethod;
    if ((getStartAnalogDemodTaskMethod = DemodulationServiceGrpc.getStartAnalogDemodTaskMethod) == null) {
      synchronized (DemodulationServiceGrpc.class) {
        if ((getStartAnalogDemodTaskMethod = DemodulationServiceGrpc.getStartAnalogDemodTaskMethod) == null) {
          DemodulationServiceGrpc.getStartAnalogDemodTaskMethod = getStartAnalogDemodTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.FFP.Demodulate.AnalogDemodRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartAnalogDemodTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.FFP.Demodulate.AnalogDemodRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new DemodulationServiceMethodDescriptorSupplier("StartAnalogDemodTask"))
              .build();
        }
      }
    }
    return getStartAnalogDemodTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.FFP.Demodulate.ChangeDemodChannelRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getChangeDemodChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeDemodChannel",
      requestType = zb.dcts.scenario.FFP.Demodulate.ChangeDemodChannelRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.FFP.Demodulate.ChangeDemodChannelRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getChangeDemodChannelMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.FFP.Demodulate.ChangeDemodChannelRequest, zb.dcts.scenario.Scenario.ScenarioReply> getChangeDemodChannelMethod;
    if ((getChangeDemodChannelMethod = DemodulationServiceGrpc.getChangeDemodChannelMethod) == null) {
      synchronized (DemodulationServiceGrpc.class) {
        if ((getChangeDemodChannelMethod = DemodulationServiceGrpc.getChangeDemodChannelMethod) == null) {
          DemodulationServiceGrpc.getChangeDemodChannelMethod = getChangeDemodChannelMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.FFP.Demodulate.ChangeDemodChannelRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ChangeDemodChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.FFP.Demodulate.ChangeDemodChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new DemodulationServiceMethodDescriptorSupplier("ChangeDemodChannel"))
              .build();
        }
      }
    }
    return getChangeDemodChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.FFP.Demodulate.AnalogDemodResult> getGetAnalogDemodResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnalogDemodResult",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.FFP.Demodulate.AnalogDemodResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.FFP.Demodulate.AnalogDemodResult> getGetAnalogDemodResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.FFP.Demodulate.AnalogDemodResult> getGetAnalogDemodResultMethod;
    if ((getGetAnalogDemodResultMethod = DemodulationServiceGrpc.getGetAnalogDemodResultMethod) == null) {
      synchronized (DemodulationServiceGrpc.class) {
        if ((getGetAnalogDemodResultMethod = DemodulationServiceGrpc.getGetAnalogDemodResultMethod) == null) {
          DemodulationServiceGrpc.getGetAnalogDemodResultMethod = getGetAnalogDemodResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.FFP.Demodulate.AnalogDemodResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnalogDemodResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.FFP.Demodulate.AnalogDemodResult.getDefaultInstance()))
              .setSchemaDescriptor(new DemodulationServiceMethodDescriptorSupplier("GetAnalogDemodResult"))
              .build();
        }
      }
    }
    return getGetAnalogDemodResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getStopAnalogDemodTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopAnalogDemodTask",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getStopAnalogDemodTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply> getStopAnalogDemodTaskMethod;
    if ((getStopAnalogDemodTaskMethod = DemodulationServiceGrpc.getStopAnalogDemodTaskMethod) == null) {
      synchronized (DemodulationServiceGrpc.class) {
        if ((getStopAnalogDemodTaskMethod = DemodulationServiceGrpc.getStopAnalogDemodTaskMethod) == null) {
          DemodulationServiceGrpc.getStopAnalogDemodTaskMethod = getStopAnalogDemodTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopAnalogDemodTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new DemodulationServiceMethodDescriptorSupplier("StopAnalogDemodTask"))
              .build();
        }
      }
    }
    return getStopAnalogDemodTaskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DemodulationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DemodulationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DemodulationServiceStub>() {
        @java.lang.Override
        public DemodulationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DemodulationServiceStub(channel, callOptions);
        }
      };
    return DemodulationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DemodulationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DemodulationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DemodulationServiceBlockingStub>() {
        @java.lang.Override
        public DemodulationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DemodulationServiceBlockingStub(channel, callOptions);
        }
      };
    return DemodulationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DemodulationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DemodulationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DemodulationServiceFutureStub>() {
        @java.lang.Override
        public DemodulationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DemodulationServiceFutureStub(channel, callOptions);
        }
      };
    return DemodulationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DemodulationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void startAnalogDemodTask(zb.dcts.scenario.FFP.Demodulate.AnalogDemodRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartAnalogDemodTaskMethod(), responseObserver);
    }

    /**
     */
    public void changeDemodChannel(zb.dcts.scenario.FFP.Demodulate.ChangeDemodChannelRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChangeDemodChannelMethod(), responseObserver);
    }

    /**
     */
    public void getAnalogDemodResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.FFP.Demodulate.AnalogDemodResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnalogDemodResultMethod(), responseObserver);
    }

    /**
     */
    public void stopAnalogDemodTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopAnalogDemodTaskMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStartAnalogDemodTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.FFP.Demodulate.AnalogDemodRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_START_ANALOG_DEMOD_TASK)))
          .addMethod(
            getChangeDemodChannelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.FFP.Demodulate.ChangeDemodChannelRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CHANGE_DEMOD_CHANNEL)))
          .addMethod(
            getGetAnalogDemodResultMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.FFP.Demodulate.AnalogDemodResult>(
                  this, METHODID_GET_ANALOG_DEMOD_RESULT)))
          .addMethod(
            getStopAnalogDemodTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_STOP_ANALOG_DEMOD_TASK)))
          .build();
    }
  }

  /**
   */
  public static final class DemodulationServiceStub extends io.grpc.stub.AbstractAsyncStub<DemodulationServiceStub> {
    private DemodulationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DemodulationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DemodulationServiceStub(channel, callOptions);
    }

    /**
     */
    public void startAnalogDemodTask(zb.dcts.scenario.FFP.Demodulate.AnalogDemodRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartAnalogDemodTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeDemodChannel(zb.dcts.scenario.FFP.Demodulate.ChangeDemodChannelRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChangeDemodChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAnalogDemodResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.FFP.Demodulate.AnalogDemodResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAnalogDemodResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stopAnalogDemodTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopAnalogDemodTaskMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DemodulationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DemodulationServiceBlockingStub> {
    private DemodulationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DemodulationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DemodulationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply startAnalogDemodTask(zb.dcts.scenario.FFP.Demodulate.AnalogDemodRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartAnalogDemodTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply changeDemodChannel(zb.dcts.scenario.FFP.Demodulate.ChangeDemodChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChangeDemodChannelMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<zb.dcts.scenario.FFP.Demodulate.AnalogDemodResult> getAnalogDemodResult(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAnalogDemodResultMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply stopAnalogDemodTask(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopAnalogDemodTaskMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DemodulationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DemodulationServiceFutureStub> {
    private DemodulationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DemodulationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DemodulationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> startAnalogDemodTask(
        zb.dcts.scenario.FFP.Demodulate.AnalogDemodRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartAnalogDemodTaskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> changeDemodChannel(
        zb.dcts.scenario.FFP.Demodulate.ChangeDemodChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChangeDemodChannelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> stopAnalogDemodTask(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopAnalogDemodTaskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_ANALOG_DEMOD_TASK = 0;
  private static final int METHODID_CHANGE_DEMOD_CHANNEL = 1;
  private static final int METHODID_GET_ANALOG_DEMOD_RESULT = 2;
  private static final int METHODID_STOP_ANALOG_DEMOD_TASK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DemodulationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DemodulationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_ANALOG_DEMOD_TASK:
          serviceImpl.startAnalogDemodTask((zb.dcts.scenario.FFP.Demodulate.AnalogDemodRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_CHANGE_DEMOD_CHANNEL:
          serviceImpl.changeDemodChannel((zb.dcts.scenario.FFP.Demodulate.ChangeDemodChannelRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_GET_ANALOG_DEMOD_RESULT:
          serviceImpl.getAnalogDemodResult((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.FFP.Demodulate.AnalogDemodResult>) responseObserver);
          break;
        case METHODID_STOP_ANALOG_DEMOD_TASK:
          serviceImpl.stopAnalogDemodTask((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
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

  private static abstract class DemodulationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DemodulationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.FFP.Demodulate.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DemodulationService");
    }
  }

  private static final class DemodulationServiceFileDescriptorSupplier
      extends DemodulationServiceBaseDescriptorSupplier {
    DemodulationServiceFileDescriptorSupplier() {}
  }

  private static final class DemodulationServiceMethodDescriptorSupplier
      extends DemodulationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DemodulationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DemodulationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DemodulationServiceFileDescriptorSupplier())
              .addMethod(getStartAnalogDemodTaskMethod())
              .addMethod(getChangeDemodChannelMethod())
              .addMethod(getGetAnalogDemodResultMethod())
              .addMethod(getStopAnalogDemodTaskMethod())
              .build();
        }
      }
    }
    return result;
  }
}
