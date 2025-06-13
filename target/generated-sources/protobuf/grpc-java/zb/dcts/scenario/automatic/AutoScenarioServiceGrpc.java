package zb.dcts.scenario.automatic;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/auto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AutoScenarioServiceGrpc {

  private AutoScenarioServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.automatic.AutoScenarioService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.automatic.Auto.CreateAutoMCPRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getCreateAutoMCPScenarioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAutoMCPScenario",
      requestType = zb.dcts.scenario.automatic.Auto.CreateAutoMCPRequest.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.automatic.Auto.CreateAutoMCPRequest,
      zb.dcts.scenario.Scenario.ScenarioReply> getCreateAutoMCPScenarioMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.automatic.Auto.CreateAutoMCPRequest, zb.dcts.scenario.Scenario.ScenarioReply> getCreateAutoMCPScenarioMethod;
    if ((getCreateAutoMCPScenarioMethod = AutoScenarioServiceGrpc.getCreateAutoMCPScenarioMethod) == null) {
      synchronized (AutoScenarioServiceGrpc.class) {
        if ((getCreateAutoMCPScenarioMethod = AutoScenarioServiceGrpc.getCreateAutoMCPScenarioMethod) == null) {
          AutoScenarioServiceGrpc.getCreateAutoMCPScenarioMethod = getCreateAutoMCPScenarioMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.automatic.Auto.CreateAutoMCPRequest, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAutoMCPScenario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.automatic.Auto.CreateAutoMCPRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new AutoScenarioServiceMethodDescriptorSupplier("CreateAutoMCPScenario"))
              .build();
        }
      }
    }
    return getCreateAutoMCPScenarioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioId,
      zb.dcts.scenario.Scenario.ScenarioReply> getCloseAutoScenarioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloseAutoScenario",
      requestType = zb.dcts.scenario.Scenario.ScenarioId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioId,
      zb.dcts.scenario.Scenario.ScenarioReply> getCloseAutoScenarioMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioId, zb.dcts.scenario.Scenario.ScenarioReply> getCloseAutoScenarioMethod;
    if ((getCloseAutoScenarioMethod = AutoScenarioServiceGrpc.getCloseAutoScenarioMethod) == null) {
      synchronized (AutoScenarioServiceGrpc.class) {
        if ((getCloseAutoScenarioMethod = AutoScenarioServiceGrpc.getCloseAutoScenarioMethod) == null) {
          AutoScenarioServiceGrpc.getCloseAutoScenarioMethod = getCloseAutoScenarioMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseAutoScenario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new AutoScenarioServiceMethodDescriptorSupplier("CloseAutoScenario"))
              .build();
        }
      }
    }
    return getCloseAutoScenarioMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AutoScenarioServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutoScenarioServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutoScenarioServiceStub>() {
        @java.lang.Override
        public AutoScenarioServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutoScenarioServiceStub(channel, callOptions);
        }
      };
    return AutoScenarioServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutoScenarioServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutoScenarioServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutoScenarioServiceBlockingStub>() {
        @java.lang.Override
        public AutoScenarioServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutoScenarioServiceBlockingStub(channel, callOptions);
        }
      };
    return AutoScenarioServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AutoScenarioServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutoScenarioServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutoScenarioServiceFutureStub>() {
        @java.lang.Override
        public AutoScenarioServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutoScenarioServiceFutureStub(channel, callOptions);
        }
      };
    return AutoScenarioServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AutoScenarioServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createAutoMCPScenario(zb.dcts.scenario.automatic.Auto.CreateAutoMCPRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAutoMCPScenarioMethod(), responseObserver);
    }

    /**
     */
    public void closeAutoScenario(zb.dcts.scenario.Scenario.ScenarioId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseAutoScenarioMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateAutoMCPScenarioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.automatic.Auto.CreateAutoMCPRequest,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CREATE_AUTO_MCPSCENARIO)))
          .addMethod(
            getCloseAutoScenarioMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_CLOSE_AUTO_SCENARIO)))
          .build();
    }
  }

  /**
   */
  public static final class AutoScenarioServiceStub extends io.grpc.stub.AbstractAsyncStub<AutoScenarioServiceStub> {
    private AutoScenarioServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoScenarioServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoScenarioServiceStub(channel, callOptions);
    }

    /**
     */
    public void createAutoMCPScenario(zb.dcts.scenario.automatic.Auto.CreateAutoMCPRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAutoMCPScenarioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeAutoScenario(zb.dcts.scenario.Scenario.ScenarioId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseAutoScenarioMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AutoScenarioServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AutoScenarioServiceBlockingStub> {
    private AutoScenarioServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoScenarioServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoScenarioServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply createAutoMCPScenario(zb.dcts.scenario.automatic.Auto.CreateAutoMCPRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAutoMCPScenarioMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply closeAutoScenario(zb.dcts.scenario.Scenario.ScenarioId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseAutoScenarioMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AutoScenarioServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AutoScenarioServiceFutureStub> {
    private AutoScenarioServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoScenarioServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoScenarioServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> createAutoMCPScenario(
        zb.dcts.scenario.automatic.Auto.CreateAutoMCPRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAutoMCPScenarioMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> closeAutoScenario(
        zb.dcts.scenario.Scenario.ScenarioId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloseAutoScenarioMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_AUTO_MCPSCENARIO = 0;
  private static final int METHODID_CLOSE_AUTO_SCENARIO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AutoScenarioServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AutoScenarioServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_AUTO_MCPSCENARIO:
          serviceImpl.createAutoMCPScenario((zb.dcts.scenario.automatic.Auto.CreateAutoMCPRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_CLOSE_AUTO_SCENARIO:
          serviceImpl.closeAutoScenario((zb.dcts.scenario.Scenario.ScenarioId) request,
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

  private static abstract class AutoScenarioServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AutoScenarioServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.automatic.Auto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AutoScenarioService");
    }
  }

  private static final class AutoScenarioServiceFileDescriptorSupplier
      extends AutoScenarioServiceBaseDescriptorSupplier {
    AutoScenarioServiceFileDescriptorSupplier() {}
  }

  private static final class AutoScenarioServiceMethodDescriptorSupplier
      extends AutoScenarioServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AutoScenarioServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AutoScenarioServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AutoScenarioServiceFileDescriptorSupplier())
              .addMethod(getCreateAutoMCPScenarioMethod())
              .addMethod(getCloseAutoScenarioMethod())
              .build();
        }
      }
    }
    return result;
  }
}
