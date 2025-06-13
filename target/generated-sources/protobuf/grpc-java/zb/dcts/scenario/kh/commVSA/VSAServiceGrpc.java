package zb.dcts.scenario.kh.commVSA;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/kh/KhVSA.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VSAServiceGrpc {

  private VSAServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.kh.commVSA.VSAService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commVSA.KhVSA.CommVSATaskRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartTask",
      requestType = zb.dcts.scenario.kh.commVSA.KhVSA.CommVSATaskRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commVSA.KhVSA.CommVSATaskRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.kh.commVSA.KhVSA.CommVSATaskRequest, zb.dcts.scenario.Scenario.ScenarioReply> getStartTaskMethod;
    if ((getStartTaskMethod = VSAServiceGrpc.getStartTaskMethod) == null) {
      synchronized (VSAServiceGrpc.class) {
        if ((getStartTaskMethod = VSAServiceGrpc.getStartTaskMethod) == null) {
          VSAServiceGrpc.getStartTaskMethod = getStartTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.kh.commVSA.KhVSA.CommVSATaskRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commVSA.KhVSA.CommVSATaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new VSAServiceMethodDescriptorSupplier("StartTask"))
              .build();
        }
      }
    }
    return getStartTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.kh.commVSA.KhVSA.CommVSAResult> getGetResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetResult",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.kh.commVSA.KhVSA.CommVSAResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.kh.commVSA.KhVSA.CommVSAResult> getGetResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.commVSA.KhVSA.CommVSAResult> getGetResultMethod;
    if ((getGetResultMethod = VSAServiceGrpc.getGetResultMethod) == null) {
      synchronized (VSAServiceGrpc.class) {
        if ((getGetResultMethod = VSAServiceGrpc.getGetResultMethod) == null) {
          VSAServiceGrpc.getGetResultMethod = getGetResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.kh.commVSA.KhVSA.CommVSAResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.kh.commVSA.KhVSA.CommVSAResult.getDefaultInstance()))
              .setSchemaDescriptor(new VSAServiceMethodDescriptorSupplier("GetResult"))
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
    if ((getStopTaskMethod = VSAServiceGrpc.getStopTaskMethod) == null) {
      synchronized (VSAServiceGrpc.class) {
        if ((getStopTaskMethod = VSAServiceGrpc.getStopTaskMethod) == null) {
          VSAServiceGrpc.getStopTaskMethod = getStopTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new VSAServiceMethodDescriptorSupplier("StopTask"))
              .build();
        }
      }
    }
    return getStopTaskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VSAServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VSAServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VSAServiceStub>() {
        @java.lang.Override
        public VSAServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VSAServiceStub(channel, callOptions);
        }
      };
    return VSAServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VSAServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VSAServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VSAServiceBlockingStub>() {
        @java.lang.Override
        public VSAServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VSAServiceBlockingStub(channel, callOptions);
        }
      };
    return VSAServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VSAServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VSAServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VSAServiceFutureStub>() {
        @java.lang.Override
        public VSAServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VSAServiceFutureStub(channel, callOptions);
        }
      };
    return VSAServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class VSAServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void startTask(zb.dcts.scenario.kh.commVSA.KhVSA.CommVSATaskRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartTaskMethod(), responseObserver);
    }

    /**
     */
    public void getResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commVSA.KhVSA.CommVSAResult> responseObserver) {
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
                zb.dcts.scenario.kh.commVSA.KhVSA.CommVSATaskRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_START_TASK)))
          .addMethod(
            getGetResultMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.kh.commVSA.KhVSA.CommVSAResult>(
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
  public static final class VSAServiceStub extends io.grpc.stub.AbstractAsyncStub<VSAServiceStub> {
    private VSAServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VSAServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VSAServiceStub(channel, callOptions);
    }

    /**
     */
    public void startTask(zb.dcts.scenario.kh.commVSA.KhVSA.CommVSATaskRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getResult(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commVSA.KhVSA.CommVSAResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
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
  public static final class VSAServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<VSAServiceBlockingStub> {
    private VSAServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VSAServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VSAServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply startTask(zb.dcts.scenario.kh.commVSA.KhVSA.CommVSATaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<zb.dcts.scenario.kh.commVSA.KhVSA.CommVSAResult> getResult(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
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
  public static final class VSAServiceFutureStub extends io.grpc.stub.AbstractFutureStub<VSAServiceFutureStub> {
    private VSAServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VSAServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VSAServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> startTask(
        zb.dcts.scenario.kh.commVSA.KhVSA.CommVSATaskRequest request) {
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
  }

  private static final int METHODID_START_TASK = 0;
  private static final int METHODID_GET_RESULT = 1;
  private static final int METHODID_STOP_TASK = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VSAServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VSAServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_TASK:
          serviceImpl.startTask((zb.dcts.scenario.kh.commVSA.KhVSA.CommVSATaskRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_GET_RESULT:
          serviceImpl.getResult((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.kh.commVSA.KhVSA.CommVSAResult>) responseObserver);
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

  private static abstract class VSAServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VSAServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.kh.commVSA.KhVSA.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VSAService");
    }
  }

  private static final class VSAServiceFileDescriptorSupplier
      extends VSAServiceBaseDescriptorSupplier {
    VSAServiceFileDescriptorSupplier() {}
  }

  private static final class VSAServiceMethodDescriptorSupplier
      extends VSAServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VSAServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (VSAServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VSAServiceFileDescriptorSupplier())
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
