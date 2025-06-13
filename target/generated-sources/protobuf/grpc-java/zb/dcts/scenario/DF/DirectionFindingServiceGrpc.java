package zb.dcts.scenario.DF;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/DF.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DirectionFindingServiceGrpc {

  private DirectionFindingServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.DF.DirectionFindingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.DF.DF.DirectionFindingRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartDFTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartDFTask",
      requestType = zb.dcts.scenario.DF.DF.DirectionFindingRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.DF.DF.DirectionFindingRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartDFTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.DF.DF.DirectionFindingRequest, zb.dcts.scenario.Scenario.ScenarioReply> getStartDFTaskMethod;
    if ((getStartDFTaskMethod = DirectionFindingServiceGrpc.getStartDFTaskMethod) == null) {
      synchronized (DirectionFindingServiceGrpc.class) {
        if ((getStartDFTaskMethod = DirectionFindingServiceGrpc.getStartDFTaskMethod) == null) {
          DirectionFindingServiceGrpc.getStartDFTaskMethod = getStartDFTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.DF.DF.DirectionFindingRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartDFTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.DF.DF.DirectionFindingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new DirectionFindingServiceMethodDescriptorSupplier("StartDFTask"))
              .build();
        }
      }
    }
    return getStartDFTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.DF.DF.ChangeSignalsRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getChangeDFSignalsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeDFSignals",
      requestType = zb.dcts.scenario.DF.DF.ChangeSignalsRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.DF.DF.ChangeSignalsRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getChangeDFSignalsMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.DF.DF.ChangeSignalsRequest, zb.dcts.scenario.Scenario.ScenarioReply> getChangeDFSignalsMethod;
    if ((getChangeDFSignalsMethod = DirectionFindingServiceGrpc.getChangeDFSignalsMethod) == null) {
      synchronized (DirectionFindingServiceGrpc.class) {
        if ((getChangeDFSignalsMethod = DirectionFindingServiceGrpc.getChangeDFSignalsMethod) == null) {
          DirectionFindingServiceGrpc.getChangeDFSignalsMethod = getChangeDFSignalsMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.DF.DF.ChangeSignalsRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ChangeDFSignals"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.DF.DF.ChangeSignalsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new DirectionFindingServiceMethodDescriptorSupplier("ChangeDFSignals"))
              .build();
        }
      }
    }
    return getChangeDFSignalsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.DF.DF.DirectionFindingResult> getGetDFResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDFResult",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.DF.DF.DirectionFindingResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.DF.DF.DirectionFindingResult> getGetDFResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.DF.DF.DirectionFindingResult> getGetDFResultMethod;
    if ((getGetDFResultMethod = DirectionFindingServiceGrpc.getGetDFResultMethod) == null) {
      synchronized (DirectionFindingServiceGrpc.class) {
        if ((getGetDFResultMethod = DirectionFindingServiceGrpc.getGetDFResultMethod) == null) {
          DirectionFindingServiceGrpc.getGetDFResultMethod = getGetDFResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.DF.DF.DirectionFindingResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDFResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.DF.DF.DirectionFindingResult.getDefaultInstance()))
              .setSchemaDescriptor(new DirectionFindingServiceMethodDescriptorSupplier("GetDFResult"))
              .build();
        }
      }
    }
    return getGetDFResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getStopDFTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopDFTask",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getStopDFTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply> getStopDFTaskMethod;
    if ((getStopDFTaskMethod = DirectionFindingServiceGrpc.getStopDFTaskMethod) == null) {
      synchronized (DirectionFindingServiceGrpc.class) {
        if ((getStopDFTaskMethod = DirectionFindingServiceGrpc.getStopDFTaskMethod) == null) {
          DirectionFindingServiceGrpc.getStopDFTaskMethod = getStopDFTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopDFTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new DirectionFindingServiceMethodDescriptorSupplier("StopDFTask"))
              .build();
        }
      }
    }
    return getStopDFTaskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DirectionFindingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DirectionFindingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DirectionFindingServiceStub>() {
        @java.lang.Override
        public DirectionFindingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DirectionFindingServiceStub(channel, callOptions);
        }
      };
    return DirectionFindingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DirectionFindingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DirectionFindingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DirectionFindingServiceBlockingStub>() {
        @java.lang.Override
        public DirectionFindingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DirectionFindingServiceBlockingStub(channel, callOptions);
        }
      };
    return DirectionFindingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DirectionFindingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DirectionFindingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DirectionFindingServiceFutureStub>() {
        @java.lang.Override
        public DirectionFindingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DirectionFindingServiceFutureStub(channel, callOptions);
        }
      };
    return DirectionFindingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DirectionFindingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void startDFTask(zb.dcts.scenario.DF.DF.DirectionFindingRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartDFTaskMethod(), responseObserver);
    }

    /**
     */
    public void changeDFSignals(zb.dcts.scenario.DF.DF.ChangeSignalsRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChangeDFSignalsMethod(), responseObserver);
    }

    /**
     */
    public void getDFResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.DF.DF.DirectionFindingResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDFResultMethod(), responseObserver);
    }

    /**
     */
    public void stopDFTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopDFTaskMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStartDFTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.DF.DF.DirectionFindingRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_START_DFTASK)))
          .addMethod(
            getChangeDFSignalsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.DF.DF.ChangeSignalsRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CHANGE_DFSIGNALS)))
          .addMethod(
            getGetDFResultMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.DF.DF.DirectionFindingResult>(
                  this, METHODID_GET_DFRESULT)))
          .addMethod(
            getStopDFTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_STOP_DFTASK)))
          .build();
    }
  }

  /**
   */
  public static final class DirectionFindingServiceStub extends io.grpc.stub.AbstractAsyncStub<DirectionFindingServiceStub> {
    private DirectionFindingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DirectionFindingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DirectionFindingServiceStub(channel, callOptions);
    }

    /**
     */
    public void startDFTask(zb.dcts.scenario.DF.DF.DirectionFindingRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartDFTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeDFSignals(zb.dcts.scenario.DF.DF.ChangeSignalsRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChangeDFSignalsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDFResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.DF.DF.DirectionFindingResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetDFResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stopDFTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopDFTaskMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DirectionFindingServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DirectionFindingServiceBlockingStub> {
    private DirectionFindingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DirectionFindingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DirectionFindingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply startDFTask(zb.dcts.scenario.DF.DF.DirectionFindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartDFTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply changeDFSignals(zb.dcts.scenario.DF.DF.ChangeSignalsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChangeDFSignalsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<zb.dcts.scenario.DF.DF.DirectionFindingResult> getDFResult(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetDFResultMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply stopDFTask(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopDFTaskMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DirectionFindingServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DirectionFindingServiceFutureStub> {
    private DirectionFindingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DirectionFindingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DirectionFindingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> startDFTask(
        zb.dcts.scenario.DF.DF.DirectionFindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartDFTaskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> changeDFSignals(
        zb.dcts.scenario.DF.DF.ChangeSignalsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChangeDFSignalsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> stopDFTask(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopDFTaskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_DFTASK = 0;
  private static final int METHODID_CHANGE_DFSIGNALS = 1;
  private static final int METHODID_GET_DFRESULT = 2;
  private static final int METHODID_STOP_DFTASK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DirectionFindingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DirectionFindingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_DFTASK:
          serviceImpl.startDFTask((zb.dcts.scenario.DF.DF.DirectionFindingRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_CHANGE_DFSIGNALS:
          serviceImpl.changeDFSignals((zb.dcts.scenario.DF.DF.ChangeSignalsRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_GET_DFRESULT:
          serviceImpl.getDFResult((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.DF.DF.DirectionFindingResult>) responseObserver);
          break;
        case METHODID_STOP_DFTASK:
          serviceImpl.stopDFTask((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
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

  private static abstract class DirectionFindingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DirectionFindingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.DF.DF.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DirectionFindingService");
    }
  }

  private static final class DirectionFindingServiceFileDescriptorSupplier
      extends DirectionFindingServiceBaseDescriptorSupplier {
    DirectionFindingServiceFileDescriptorSupplier() {}
  }

  private static final class DirectionFindingServiceMethodDescriptorSupplier
      extends DirectionFindingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DirectionFindingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DirectionFindingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DirectionFindingServiceFileDescriptorSupplier())
              .addMethod(getStartDFTaskMethod())
              .addMethod(getChangeDFSignalsMethod())
              .addMethod(getGetDFResultMethod())
              .addMethod(getStopDFTaskMethod())
              .build();
        }
      }
    }
    return result;
  }
}
