package zb.dcts.fusion.fusiondata;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 获取融合数据的API
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: fusion/fusion.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FusionDataControlServiceGrpc {

  private FusionDataControlServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.fusion.fusiondata.FusionDataControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest,
      com.google.protobuf.Any> getSubscribeFusionDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeFusionData",
      requestType = zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest.class,
      responseType = com.google.protobuf.Any.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest,
      com.google.protobuf.Any> getSubscribeFusionDataMethod() {
    io.grpc.MethodDescriptor<zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest, com.google.protobuf.Any> getSubscribeFusionDataMethod;
    if ((getSubscribeFusionDataMethod = FusionDataControlServiceGrpc.getSubscribeFusionDataMethod) == null) {
      synchronized (FusionDataControlServiceGrpc.class) {
        if ((getSubscribeFusionDataMethod = FusionDataControlServiceGrpc.getSubscribeFusionDataMethod) == null) {
          FusionDataControlServiceGrpc.getSubscribeFusionDataMethod = getSubscribeFusionDataMethod =
              io.grpc.MethodDescriptor.<zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest, com.google.protobuf.Any>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeFusionData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Any.getDefaultInstance()))
              .setSchemaDescriptor(new FusionDataControlServiceMethodDescriptorSupplier("SubscribeFusionData"))
              .build();
        }
      }
    }
    return getSubscribeFusionDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FusionDataControlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FusionDataControlServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FusionDataControlServiceStub>() {
        @java.lang.Override
        public FusionDataControlServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FusionDataControlServiceStub(channel, callOptions);
        }
      };
    return FusionDataControlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FusionDataControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FusionDataControlServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FusionDataControlServiceBlockingStub>() {
        @java.lang.Override
        public FusionDataControlServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FusionDataControlServiceBlockingStub(channel, callOptions);
        }
      };
    return FusionDataControlServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FusionDataControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FusionDataControlServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FusionDataControlServiceFutureStub>() {
        @java.lang.Override
        public FusionDataControlServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FusionDataControlServiceFutureStub(channel, callOptions);
        }
      };
    return FusionDataControlServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 获取融合数据的API
   * </pre>
   */
  public static abstract class FusionDataControlServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void subscribeFusionData(zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Any> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeFusionDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubscribeFusionDataMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest,
                com.google.protobuf.Any>(
                  this, METHODID_SUBSCRIBE_FUSION_DATA)))
          .build();
    }
  }

  /**
   * <pre>
   * 获取融合数据的API
   * </pre>
   */
  public static final class FusionDataControlServiceStub extends io.grpc.stub.AbstractAsyncStub<FusionDataControlServiceStub> {
    private FusionDataControlServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FusionDataControlServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FusionDataControlServiceStub(channel, callOptions);
    }

    /**
     */
    public void subscribeFusionData(zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Any> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeFusionDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 获取融合数据的API
   * </pre>
   */
  public static final class FusionDataControlServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FusionDataControlServiceBlockingStub> {
    private FusionDataControlServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FusionDataControlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FusionDataControlServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.google.protobuf.Any> subscribeFusionData(
        zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeFusionDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 获取融合数据的API
   * </pre>
   */
  public static final class FusionDataControlServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FusionDataControlServiceFutureStub> {
    private FusionDataControlServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FusionDataControlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FusionDataControlServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SUBSCRIBE_FUSION_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FusionDataControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FusionDataControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE_FUSION_DATA:
          serviceImpl.subscribeFusionData((zb.dcts.fusion.fusiondata.Fusion.FusionDataRequest) request,
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

  private static abstract class FusionDataControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FusionDataControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.fusion.fusiondata.Fusion.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FusionDataControlService");
    }
  }

  private static final class FusionDataControlServiceFileDescriptorSupplier
      extends FusionDataControlServiceBaseDescriptorSupplier {
    FusionDataControlServiceFileDescriptorSupplier() {}
  }

  private static final class FusionDataControlServiceMethodDescriptorSupplier
      extends FusionDataControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FusionDataControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FusionDataControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FusionDataControlServiceFileDescriptorSupplier())
              .addMethod(getSubscribeFusionDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
