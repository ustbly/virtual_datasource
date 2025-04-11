package proto_compile.cetc41.nodecontrol;

import com.google.protobuf.InvalidProtocolBufferException;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 通用管理的API
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: nodeServer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NodeControlServiceGrpc {

  private NodeControlServiceGrpc() {}

  public static final String SERVICE_NAME = "NodeControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodesInfo> getListAllNodesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAllNodes",
      requestType = com.google.protobuf.Empty.class,
      responseType = proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodesInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodesInfo> getListAllNodesMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodesInfo> getListAllNodesMethod;
    if ((getListAllNodesMethod = NodeControlServiceGrpc.getListAllNodesMethod) == null) {
      synchronized (NodeControlServiceGrpc.class) {
        if ((getListAllNodesMethod = NodeControlServiceGrpc.getListAllNodesMethod) == null) {
          NodeControlServiceGrpc.getListAllNodesMethod = getListAllNodesMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodesInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAllNodes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodesInfo.getDefaultInstance()))
              .setSchemaDescriptor(new NodeControlServiceMethodDescriptorSupplier("ListAllNodes"))
              .build();
        }
      }
    }
    return getListAllNodesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommand,
      proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommandReply> getSendSourceCommandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendSourceCommand",
      requestType = proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommand.class,
      responseType = proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommandReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommand,
      proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommandReply> getSendSourceCommandMethod() {
    io.grpc.MethodDescriptor<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommand, proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommandReply> getSendSourceCommandMethod;
    if ((getSendSourceCommandMethod = NodeControlServiceGrpc.getSendSourceCommandMethod) == null) {
      synchronized (NodeControlServiceGrpc.class) {
        if ((getSendSourceCommandMethod = NodeControlServiceGrpc.getSendSourceCommandMethod) == null) {
          NodeControlServiceGrpc.getSendSourceCommandMethod = getSendSourceCommandMethod =
              io.grpc.MethodDescriptor.<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommand, proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommandReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendSourceCommand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommand.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommandReply.getDefaultInstance()))
              .setSchemaDescriptor(new NodeControlServiceMethodDescriptorSupplier("SendSourceCommand"))
              .build();
        }
      }
    }
    return getSendSourceCommandMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SubscribeRequest,
      com.google.protobuf.Any> getSubscribeSourceMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeSourceMessage",
      requestType = proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SubscribeRequest.class,
      responseType = com.google.protobuf.Any.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SubscribeRequest,
      com.google.protobuf.Any> getSubscribeSourceMessageMethod() {
    io.grpc.MethodDescriptor<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SubscribeRequest, com.google.protobuf.Any> getSubscribeSourceMessageMethod;
    if ((getSubscribeSourceMessageMethod = NodeControlServiceGrpc.getSubscribeSourceMessageMethod) == null) {
      synchronized (NodeControlServiceGrpc.class) {
        if ((getSubscribeSourceMessageMethod = NodeControlServiceGrpc.getSubscribeSourceMessageMethod) == null) {
          NodeControlServiceGrpc.getSubscribeSourceMessageMethod = getSubscribeSourceMessageMethod =
              io.grpc.MethodDescriptor.<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SubscribeRequest, com.google.protobuf.Any>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeSourceMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Any.getDefaultInstance()))
              .setSchemaDescriptor(new NodeControlServiceMethodDescriptorSupplier("SubscribeSourceMessage"))
              .build();
        }
      }
    }
    return getSubscribeSourceMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NodeControlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NodeControlServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NodeControlServiceStub>() {
        @java.lang.Override
        public NodeControlServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NodeControlServiceStub(channel, callOptions);
        }
      };
    return NodeControlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NodeControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NodeControlServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NodeControlServiceBlockingStub>() {
        @java.lang.Override
        public NodeControlServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NodeControlServiceBlockingStub(channel, callOptions);
        }
      };
    return NodeControlServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NodeControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NodeControlServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NodeControlServiceFutureStub>() {
        @java.lang.Override
        public NodeControlServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NodeControlServiceFutureStub(channel, callOptions);
        }
      };
    return NodeControlServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 通用管理的API
   * </pre>
   */
  public static abstract class NodeControlServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void listAllNodes(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodesInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAllNodesMethod(), responseObserver);
    }

    /**
     */
    public void sendSourceCommand(proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommand request,
        io.grpc.stub.StreamObserver<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommandReply> responseObserver) throws InvalidProtocolBufferException {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendSourceCommandMethod(), responseObserver);
    }

    /**
     */
    public void subscribeSourceMessage(proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SubscribeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Any> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeSourceMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListAllNodesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodesInfo>(
                  this, METHODID_LIST_ALL_NODES)))
          .addMethod(
            getSendSourceCommandMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommand,
                proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommandReply>(
                  this, METHODID_SEND_SOURCE_COMMAND)))
          .addMethod(
            getSubscribeSourceMessageMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SubscribeRequest,
                com.google.protobuf.Any>(
                  this, METHODID_SUBSCRIBE_SOURCE_MESSAGE)))
          .build();
    }
  }

  /**
   * <pre>
   * 通用管理的API
   * </pre>
   */
  public static final class NodeControlServiceStub extends io.grpc.stub.AbstractAsyncStub<NodeControlServiceStub> {
    private NodeControlServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NodeControlServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NodeControlServiceStub(channel, callOptions);
    }

    /**
     */
    public void listAllNodes(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodesInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAllNodesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendSourceCommand(proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommand request,
        io.grpc.stub.StreamObserver<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommandReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendSourceCommandMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribeSourceMessage(proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SubscribeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Any> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeSourceMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 通用管理的API
   * </pre>
   */
  public static final class NodeControlServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<NodeControlServiceBlockingStub> {
    private NodeControlServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NodeControlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NodeControlServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodesInfo listAllNodes(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllNodesMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommandReply sendSourceCommand(proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommand request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendSourceCommandMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.google.protobuf.Any> subscribeSourceMessage(
        proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SubscribeRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeSourceMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 通用管理的API
   * </pre>
   */
  public static final class NodeControlServiceFutureStub extends io.grpc.stub.AbstractFutureStub<NodeControlServiceFutureStub> {
    private NodeControlServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NodeControlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NodeControlServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodesInfo> listAllNodes(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAllNodesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommandReply> sendSourceCommand(
        proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SourceCommand request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendSourceCommandMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ALL_NODES = 0;
  private static final int METHODID_SEND_SOURCE_COMMAND = 1;
  private static final int METHODID_SUBSCRIBE_SOURCE_MESSAGE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NodeControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NodeControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ALL_NODES:
          serviceImpl.listAllNodes((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodesInfo>) responseObserver);
          break;
        case METHODID_SEND_SOURCE_COMMAND:
          try {
            serviceImpl.sendSourceCommand((NodeControlServiceApi.SourceCommand) request,
                (io.grpc.stub.StreamObserver<NodeControlServiceApi.SourceCommandReply>) responseObserver);
          } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
          }
          break;
        case METHODID_SUBSCRIBE_SOURCE_MESSAGE:
          serviceImpl.subscribeSourceMessage((proto_compile.cetc41.nodecontrol.NodeControlServiceApi.SubscribeRequest) request,
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

  private static abstract class NodeControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NodeControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto_compile.cetc41.nodecontrol.NodeControlServiceApi.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NodeControlService");
    }
  }

  private static final class NodeControlServiceFileDescriptorSupplier
      extends NodeControlServiceBaseDescriptorSupplier {
    NodeControlServiceFileDescriptorSupplier() {}
  }

  private static final class NodeControlServiceMethodDescriptorSupplier
      extends NodeControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NodeControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (NodeControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NodeControlServiceFileDescriptorSupplier())
              .addMethod(getListAllNodesMethod())
              .addMethod(getSendSourceCommandMethod())
              .addMethod(getSubscribeSourceMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
