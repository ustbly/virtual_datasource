package proto_compile.cetc41.nodecontrol;

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

  private static volatile io.grpc.MethodDescriptor<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeId,
      proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeInfo> getGetNodeInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNodeInfo",
      requestType = proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeId.class,
      responseType = proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeId,
      proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeInfo> getGetNodeInfoMethod() {
    io.grpc.MethodDescriptor<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeId, proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeInfo> getGetNodeInfoMethod;
    if ((getGetNodeInfoMethod = NodeControlServiceGrpc.getGetNodeInfoMethod) == null) {
      synchronized (NodeControlServiceGrpc.class) {
        if ((getGetNodeInfoMethod = NodeControlServiceGrpc.getGetNodeInfoMethod) == null) {
          NodeControlServiceGrpc.getGetNodeInfoMethod = getGetNodeInfoMethod =
              io.grpc.MethodDescriptor.<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeId, proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNodeInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeInfo.getDefaultInstance()))
              .setSchemaDescriptor(new NodeControlServiceMethodDescriptorSupplier("GetNodeInfo"))
              .build();
        }
      }
    }
    return getGetNodeInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControl,
      proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControlResponse> getPostNodeControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PostNodeControl",
      requestType = proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControl.class,
      responseType = proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControl,
      proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControlResponse> getPostNodeControlMethod() {
    io.grpc.MethodDescriptor<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControl, proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControlResponse> getPostNodeControlMethod;
    if ((getPostNodeControlMethod = NodeControlServiceGrpc.getPostNodeControlMethod) == null) {
      synchronized (NodeControlServiceGrpc.class) {
        if ((getPostNodeControlMethod = NodeControlServiceGrpc.getPostNodeControlMethod) == null) {
          NodeControlServiceGrpc.getPostNodeControlMethod = getPostNodeControlMethod =
              io.grpc.MethodDescriptor.<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControl, proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PostNodeControl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControl.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NodeControlServiceMethodDescriptorSupplier("PostNodeControl"))
              .build();
        }
      }
    }
    return getPostNodeControlMethod;
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
    public void getNodeInfo(proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeId request,
        io.grpc.stub.StreamObserver<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNodeInfoMethod(), responseObserver);
    }

    /**
     */
    public void postNodeControl(proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControl request,
        io.grpc.stub.StreamObserver<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPostNodeControlMethod(), responseObserver);
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
            getGetNodeInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeId,
                proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeInfo>(
                  this, METHODID_GET_NODE_INFO)))
          .addMethod(
            getPostNodeControlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControl,
                proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControlResponse>(
                  this, METHODID_POST_NODE_CONTROL)))
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
    public void getNodeInfo(proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeId request,
        io.grpc.stub.StreamObserver<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNodeInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void postNodeControl(proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControl request,
        io.grpc.stub.StreamObserver<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPostNodeControlMethod(), getCallOptions()), request, responseObserver);
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
    public proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeInfo getNodeInfo(proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNodeInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControlResponse postNodeControl(proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControl request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPostNodeControlMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeInfo> getNodeInfo(
        proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNodeInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControlResponse> postNodeControl(
        proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControl request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPostNodeControlMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ALL_NODES = 0;
  private static final int METHODID_GET_NODE_INFO = 1;
  private static final int METHODID_POST_NODE_CONTROL = 2;

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
        case METHODID_GET_NODE_INFO:
          serviceImpl.getNodeInfo((proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeId) request,
              (io.grpc.stub.StreamObserver<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeInfo>) responseObserver);
          break;
        case METHODID_POST_NODE_CONTROL:
          serviceImpl.postNodeControl((proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControl) request,
              (io.grpc.stub.StreamObserver<proto_compile.cetc41.nodecontrol.NodeControlServiceApi.NodeControlResponse>) responseObserver);
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
              .addMethod(getGetNodeInfoMethod())
              .addMethod(getPostNodeControlMethod())
              .build();
        }
      }
    }
    return result;
  }
}
