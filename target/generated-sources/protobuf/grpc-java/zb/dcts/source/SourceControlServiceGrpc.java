package zb.dcts.source;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 源控制的API
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: source/source.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SourceControlServiceGrpc {

  private SourceControlServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.source.SourceControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      zb.dcts.source.Source.SourceSetInfo> getListAllSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAllSources",
      requestType = com.google.protobuf.Empty.class,
      responseType = zb.dcts.source.Source.SourceSetInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      zb.dcts.source.Source.SourceSetInfo> getListAllSourcesMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, zb.dcts.source.Source.SourceSetInfo> getListAllSourcesMethod;
    if ((getListAllSourcesMethod = SourceControlServiceGrpc.getListAllSourcesMethod) == null) {
      synchronized (SourceControlServiceGrpc.class) {
        if ((getListAllSourcesMethod = SourceControlServiceGrpc.getListAllSourcesMethod) == null) {
          SourceControlServiceGrpc.getListAllSourcesMethod = getListAllSourcesMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, zb.dcts.source.Source.SourceSetInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAllSources"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.source.Source.SourceSetInfo.getDefaultInstance()))
              .setSchemaDescriptor(new SourceControlServiceMethodDescriptorSupplier("ListAllSources"))
              .build();
        }
      }
    }
    return getListAllSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.source.Source.SourceCommand,
      zb.dcts.source.Source.SourceCommandReply> getSendSourceCommandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendSourceCommand",
      requestType = zb.dcts.source.Source.SourceCommand.class,
      responseType = zb.dcts.source.Source.SourceCommandReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.source.Source.SourceCommand,
      zb.dcts.source.Source.SourceCommandReply> getSendSourceCommandMethod() {
    io.grpc.MethodDescriptor<zb.dcts.source.Source.SourceCommand, zb.dcts.source.Source.SourceCommandReply> getSendSourceCommandMethod;
    if ((getSendSourceCommandMethod = SourceControlServiceGrpc.getSendSourceCommandMethod) == null) {
      synchronized (SourceControlServiceGrpc.class) {
        if ((getSendSourceCommandMethod = SourceControlServiceGrpc.getSendSourceCommandMethod) == null) {
          SourceControlServiceGrpc.getSendSourceCommandMethod = getSendSourceCommandMethod =
              io.grpc.MethodDescriptor.<zb.dcts.source.Source.SourceCommand, zb.dcts.source.Source.SourceCommandReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendSourceCommand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.source.Source.SourceCommand.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.source.Source.SourceCommandReply.getDefaultInstance()))
              .setSchemaDescriptor(new SourceControlServiceMethodDescriptorSupplier("SendSourceCommand"))
              .build();
        }
      }
    }
    return getSendSourceCommandMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.source.Source.SubscribeRequest,
      com.google.protobuf.Any> getSubscribeSourceMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeSourceMessage",
      requestType = zb.dcts.source.Source.SubscribeRequest.class,
      responseType = com.google.protobuf.Any.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<zb.dcts.source.Source.SubscribeRequest,
      com.google.protobuf.Any> getSubscribeSourceMessageMethod() {
    io.grpc.MethodDescriptor<zb.dcts.source.Source.SubscribeRequest, com.google.protobuf.Any> getSubscribeSourceMessageMethod;
    if ((getSubscribeSourceMessageMethod = SourceControlServiceGrpc.getSubscribeSourceMessageMethod) == null) {
      synchronized (SourceControlServiceGrpc.class) {
        if ((getSubscribeSourceMessageMethod = SourceControlServiceGrpc.getSubscribeSourceMessageMethod) == null) {
          SourceControlServiceGrpc.getSubscribeSourceMessageMethod = getSubscribeSourceMessageMethod =
              io.grpc.MethodDescriptor.<zb.dcts.source.Source.SubscribeRequest, com.google.protobuf.Any>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeSourceMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.source.Source.SubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Any.getDefaultInstance()))
              .setSchemaDescriptor(new SourceControlServiceMethodDescriptorSupplier("SubscribeSourceMessage"))
              .build();
        }
      }
    }
    return getSubscribeSourceMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SourceControlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SourceControlServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SourceControlServiceStub>() {
        @java.lang.Override
        public SourceControlServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SourceControlServiceStub(channel, callOptions);
        }
      };
    return SourceControlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SourceControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SourceControlServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SourceControlServiceBlockingStub>() {
        @java.lang.Override
        public SourceControlServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SourceControlServiceBlockingStub(channel, callOptions);
        }
      };
    return SourceControlServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SourceControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SourceControlServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SourceControlServiceFutureStub>() {
        @java.lang.Override
        public SourceControlServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SourceControlServiceFutureStub(channel, callOptions);
        }
      };
    return SourceControlServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 源控制的API
   * </pre>
   */
  public static abstract class SourceControlServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void listAllSources(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<zb.dcts.source.Source.SourceSetInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAllSourcesMethod(), responseObserver);
    }

    /**
     */
    public void sendSourceCommand(zb.dcts.source.Source.SourceCommand request,
        io.grpc.stub.StreamObserver<zb.dcts.source.Source.SourceCommandReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendSourceCommandMethod(), responseObserver);
    }

    /**
     */
    public void subscribeSourceMessage(zb.dcts.source.Source.SubscribeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Any> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeSourceMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListAllSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                zb.dcts.source.Source.SourceSetInfo>(
                  this, METHODID_LIST_ALL_SOURCES)))
          .addMethod(
            getSendSourceCommandMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.source.Source.SourceCommand,
                zb.dcts.source.Source.SourceCommandReply>(
                  this, METHODID_SEND_SOURCE_COMMAND)))
          .addMethod(
            getSubscribeSourceMessageMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                zb.dcts.source.Source.SubscribeRequest,
                com.google.protobuf.Any>(
                  this, METHODID_SUBSCRIBE_SOURCE_MESSAGE)))
          .build();
    }
  }

  /**
   * <pre>
   * 源控制的API
   * </pre>
   */
  public static final class SourceControlServiceStub extends io.grpc.stub.AbstractAsyncStub<SourceControlServiceStub> {
    private SourceControlServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SourceControlServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SourceControlServiceStub(channel, callOptions);
    }

    /**
     */
    public void listAllSources(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<zb.dcts.source.Source.SourceSetInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAllSourcesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendSourceCommand(zb.dcts.source.Source.SourceCommand request,
        io.grpc.stub.StreamObserver<zb.dcts.source.Source.SourceCommandReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendSourceCommandMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribeSourceMessage(zb.dcts.source.Source.SubscribeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Any> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeSourceMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 源控制的API
   * </pre>
   */
  public static final class SourceControlServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SourceControlServiceBlockingStub> {
    private SourceControlServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SourceControlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SourceControlServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.source.Source.SourceSetInfo listAllSources(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllSourcesMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.source.Source.SourceCommandReply sendSourceCommand(zb.dcts.source.Source.SourceCommand request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendSourceCommandMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.google.protobuf.Any> subscribeSourceMessage(
        zb.dcts.source.Source.SubscribeRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeSourceMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 源控制的API
   * </pre>
   */
  public static final class SourceControlServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SourceControlServiceFutureStub> {
    private SourceControlServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SourceControlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SourceControlServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.source.Source.SourceSetInfo> listAllSources(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAllSourcesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.source.Source.SourceCommandReply> sendSourceCommand(
        zb.dcts.source.Source.SourceCommand request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendSourceCommandMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ALL_SOURCES = 0;
  private static final int METHODID_SEND_SOURCE_COMMAND = 1;
  private static final int METHODID_SUBSCRIBE_SOURCE_MESSAGE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SourceControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SourceControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ALL_SOURCES:
          serviceImpl.listAllSources((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<zb.dcts.source.Source.SourceSetInfo>) responseObserver);
          break;
        case METHODID_SEND_SOURCE_COMMAND:
          serviceImpl.sendSourceCommand((zb.dcts.source.Source.SourceCommand) request,
              (io.grpc.stub.StreamObserver<zb.dcts.source.Source.SourceCommandReply>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_SOURCE_MESSAGE:
          serviceImpl.subscribeSourceMessage((zb.dcts.source.Source.SubscribeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Any>) responseObserver);
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

  private static abstract class SourceControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SourceControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.source.Source.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SourceControlService");
    }
  }

  private static final class SourceControlServiceFileDescriptorSupplier
      extends SourceControlServiceBaseDescriptorSupplier {
    SourceControlServiceFileDescriptorSupplier() {}
  }

  private static final class SourceControlServiceMethodDescriptorSupplier
      extends SourceControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SourceControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SourceControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SourceControlServiceFileDescriptorSupplier())
              .addMethod(getListAllSourcesMethod())
              .addMethod(getSendSourceCommandMethod())
              .addMethod(getSubscribeSourceMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
