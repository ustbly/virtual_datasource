package zb.dcts.scenario.kh.commDirection;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/kh/KhCommDirectionCali.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CommDirectionCaliServiceGrpc {

  private CommDirectionCaliServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.kh.commDirection.CommDirectionCaliService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CommDirectionCaliTaskRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartTask",
      requestType = zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CommDirectionCaliTaskRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CommDirectionCaliTaskRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CommDirectionCaliTaskRequest, zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod;
    if ((getStartTaskMethod = CommDirectionCaliServiceGrpc.getStartTaskMethod) == null) {
      synchronized (CommDirectionCaliServiceGrpc.class) {
        if ((getStartTaskMethod = CommDirectionCaliServiceGrpc.getStartTaskMethod) == null) {
          CommDirectionCaliServiceGrpc.getStartTaskMethod = getStartTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CommDirectionCaliTaskRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CommDirectionCaliTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommDirectionCaliServiceMethodDescriptorSupplier("StartTask"))
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
    if ((getGetFixResultMethod = CommDirectionCaliServiceGrpc.getGetFixResultMethod) == null) {
      synchronized (CommDirectionCaliServiceGrpc.class) {
        if ((getGetFixResultMethod = CommDirectionCaliServiceGrpc.getGetFixResultMethod) == null) {
          CommDirectionCaliServiceGrpc.getGetFixResultMethod = getGetFixResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFixResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commDirection.KhCommDirectionAcq.CommDirectionResult.getDefaultInstance()))
              .setSchemaDescriptor(new CommDirectionCaliServiceMethodDescriptorSupplier("GetFixResult"))
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
    if ((getStopTaskMethod = CommDirectionCaliServiceGrpc.getStopTaskMethod) == null) {
      synchronized (CommDirectionCaliServiceGrpc.class) {
        if ((getStopTaskMethod = CommDirectionCaliServiceGrpc.getStopTaskMethod) == null) {
          CommDirectionCaliServiceGrpc.getStopTaskMethod = getStopTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommDirectionCaliServiceMethodDescriptorSupplier("StopTask"))
              .build();
        }
      }
    }
    return getStopTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CaliChangeRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getChangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Change",
      requestType = zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CaliChangeRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CaliChangeRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getChangeMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CaliChangeRequest, zb.dcts.scenario.Scenario.ScenarioReply> getChangeMethod;
    if ((getChangeMethod = CommDirectionCaliServiceGrpc.getChangeMethod) == null) {
      synchronized (CommDirectionCaliServiceGrpc.class) {
        if ((getChangeMethod = CommDirectionCaliServiceGrpc.getChangeMethod) == null) {
          CommDirectionCaliServiceGrpc.getChangeMethod = getChangeMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CaliChangeRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Change"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CaliChangeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new CommDirectionCaliServiceMethodDescriptorSupplier("Change"))
              .build();
        }
      }
    }
    return getChangeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommDirectionCaliServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommDirectionCaliServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommDirectionCaliServiceStub>() {
        @java.lang.Override
        public CommDirectionCaliServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommDirectionCaliServiceStub(channel, callOptions);
        }
      };
    return CommDirectionCaliServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommDirectionCaliServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommDirectionCaliServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommDirectionCaliServiceBlockingStub>() {
        @java.lang.Override
        public CommDirectionCaliServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommDirectionCaliServiceBlockingStub(channel, callOptions);
        }
      };
    return CommDirectionCaliServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommDirectionCaliServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommDirectionCaliServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommDirectionCaliServiceFutureStub>() {
        @java.lang.Override
        public CommDirectionCaliServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommDirectionCaliServiceFutureStub(channel, callOptions);
        }
      };
    return CommDirectionCaliServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CommDirectionCaliServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void startTask(zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CommDirectionCaliTaskRequest request,
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
    public void change(zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CaliChangeRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChangeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStartTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CommDirectionCaliTaskRequest,
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
                zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CaliChangeRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CHANGE)))
          .build();
    }
  }

  /**
   */
  public static final class CommDirectionCaliServiceStub extends io.grpc.stub.AbstractAsyncStub<CommDirectionCaliServiceStub> {
    private CommDirectionCaliServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommDirectionCaliServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommDirectionCaliServiceStub(channel, callOptions);
    }

    /**
     */
    public void startTask(zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CommDirectionCaliTaskRequest request,
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
    public void change(zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CaliChangeRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChangeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommDirectionCaliServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CommDirectionCaliServiceBlockingStub> {
    private CommDirectionCaliServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommDirectionCaliServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommDirectionCaliServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply startTask(zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CommDirectionCaliTaskRequest request) {
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
    public zb.dcts.scenario.Scenario.ScenarioReply change(zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CaliChangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChangeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommDirectionCaliServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CommDirectionCaliServiceFutureStub> {
    private CommDirectionCaliServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommDirectionCaliServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommDirectionCaliServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> startTask(
        zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CommDirectionCaliTaskRequest request) {
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
        zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CaliChangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChangeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_TASK = 0;
  private static final int METHODID_GET_FIX_RESULT = 1;
  private static final int METHODID_STOP_TASK = 2;
  private static final int METHODID_CHANGE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommDirectionCaliServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommDirectionCaliServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_TASK:
          serviceImpl.startTask((zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CommDirectionCaliTaskRequest) request,
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
          serviceImpl.change((zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.CaliChangeRequest) request,
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

  private static abstract class CommDirectionCaliServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommDirectionCaliServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.kh.commDirection.KhCommDirectionCali.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommDirectionCaliService");
    }
  }

  private static final class CommDirectionCaliServiceFileDescriptorSupplier
      extends CommDirectionCaliServiceBaseDescriptorSupplier {
    CommDirectionCaliServiceFileDescriptorSupplier() {}
  }

  private static final class CommDirectionCaliServiceMethodDescriptorSupplier
      extends CommDirectionCaliServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommDirectionCaliServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommDirectionCaliServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommDirectionCaliServiceFileDescriptorSupplier())
              .addMethod(getStartTaskMethod())
              .addMethod(getGetFixResultMethod())
              .addMethod(getStopTaskMethod())
              .addMethod(getChangeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
