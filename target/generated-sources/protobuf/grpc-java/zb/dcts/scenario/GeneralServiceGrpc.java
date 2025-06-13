package zb.dcts.scenario;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 通用管理的API
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: scenario/scenario.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GeneralServiceGrpc {

  private GeneralServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.scenario.GeneralService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      zb.dcts.scenario.Scenario.ScenariosInfo> getListAllScenariosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAllScenarios",
      requestType = com.google.protobuf.Empty.class,
      responseType = zb.dcts.scenario.Scenario.ScenariosInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      zb.dcts.scenario.Scenario.ScenariosInfo> getListAllScenariosMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, zb.dcts.scenario.Scenario.ScenariosInfo> getListAllScenariosMethod;
    if ((getListAllScenariosMethod = GeneralServiceGrpc.getListAllScenariosMethod) == null) {
      synchronized (GeneralServiceGrpc.class) {
        if ((getListAllScenariosMethod = GeneralServiceGrpc.getListAllScenariosMethod) == null) {
          GeneralServiceGrpc.getListAllScenariosMethod = getListAllScenariosMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, zb.dcts.scenario.Scenario.ScenariosInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAllScenarios"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenariosInfo.getDefaultInstance()))
              .setSchemaDescriptor(new GeneralServiceMethodDescriptorSupplier("ListAllScenarios"))
              .build();
        }
      }
    }
    return getListAllScenariosMethod;
  }

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
    if ((getListAllSourcesMethod = GeneralServiceGrpc.getListAllSourcesMethod) == null) {
      synchronized (GeneralServiceGrpc.class) {
        if ((getListAllSourcesMethod = GeneralServiceGrpc.getListAllSourcesMethod) == null) {
          GeneralServiceGrpc.getListAllSourcesMethod = getListAllSourcesMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, zb.dcts.source.Source.SourceSetInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAllSources"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.source.Source.SourceSetInfo.getDefaultInstance()))
              .setSchemaDescriptor(new GeneralServiceMethodDescriptorSupplier("ListAllSources"))
              .build();
        }
      }
    }
    return getListAllSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioId,
      zb.dcts.scenario.Scenario.ScenarioInfo> getGetScenarioInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScenarioInfo",
      requestType = zb.dcts.scenario.Scenario.ScenarioId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioId,
      zb.dcts.scenario.Scenario.ScenarioInfo> getGetScenarioInfoMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioId, zb.dcts.scenario.Scenario.ScenarioInfo> getGetScenarioInfoMethod;
    if ((getGetScenarioInfoMethod = GeneralServiceGrpc.getGetScenarioInfoMethod) == null) {
      synchronized (GeneralServiceGrpc.class) {
        if ((getGetScenarioInfoMethod = GeneralServiceGrpc.getGetScenarioInfoMethod) == null) {
          GeneralServiceGrpc.getGetScenarioInfoMethod = getGetScenarioInfoMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioId, zb.dcts.scenario.Scenario.ScenarioInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetScenarioInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioInfo.getDefaultInstance()))
              .setSchemaDescriptor(new GeneralServiceMethodDescriptorSupplier("GetScenarioInfo"))
              .build();
        }
      }
    }
    return getGetScenarioInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioId,
      com.google.protobuf.Empty> getAbortOneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AbortOne",
      requestType = zb.dcts.scenario.Scenario.ScenarioId.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioId,
      com.google.protobuf.Empty> getAbortOneMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioId, com.google.protobuf.Empty> getAbortOneMethod;
    if ((getAbortOneMethod = GeneralServiceGrpc.getAbortOneMethod) == null) {
      synchronized (GeneralServiceGrpc.class) {
        if ((getAbortOneMethod = GeneralServiceGrpc.getAbortOneMethod) == null) {
          GeneralServiceGrpc.getAbortOneMethod = getAbortOneMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioId, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AbortOne"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new GeneralServiceMethodDescriptorSupplier("AbortOne"))
              .build();
        }
      }
    }
    return getAbortOneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getAbortAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AbortAll",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getAbortAllMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getAbortAllMethod;
    if ((getAbortAllMethod = GeneralServiceGrpc.getAbortAllMethod) == null) {
      synchronized (GeneralServiceGrpc.class) {
        if ((getAbortAllMethod = GeneralServiceGrpc.getAbortAllMethod) == null) {
          GeneralServiceGrpc.getAbortAllMethod = getAbortAllMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AbortAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new GeneralServiceMethodDescriptorSupplier("AbortAll"))
              .build();
        }
      }
    }
    return getAbortAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getPauseTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PauseTask",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getPauseTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply> getPauseTaskMethod;
    if ((getPauseTaskMethod = GeneralServiceGrpc.getPauseTaskMethod) == null) {
      synchronized (GeneralServiceGrpc.class) {
        if ((getPauseTaskMethod = GeneralServiceGrpc.getPauseTaskMethod) == null) {
          GeneralServiceGrpc.getPauseTaskMethod = getPauseTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PauseTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new GeneralServiceMethodDescriptorSupplier("PauseTask"))
              .build();
        }
      }
    }
    return getPauseTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getResumeTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeTask",
      requestType = zb.dcts.scenario.Scenario.ScenarioTaskId.class,
      responseType = zb.dcts.scenario.Scenario.ScenarioReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId,
      zb.dcts.scenario.Scenario.ScenarioReply> getResumeTaskMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply> getResumeTaskMethod;
    if ((getResumeTaskMethod = GeneralServiceGrpc.getResumeTaskMethod) == null) {
      synchronized (GeneralServiceGrpc.class) {
        if ((getResumeTaskMethod = GeneralServiceGrpc.getResumeTaskMethod) == null) {
          GeneralServiceGrpc.getResumeTaskMethod = getResumeTaskMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.ScenarioTaskId, zb.dcts.scenario.Scenario.ScenarioReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumeTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioTaskId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.ScenarioReply.getDefaultInstance()))
              .setSchemaDescriptor(new GeneralServiceMethodDescriptorSupplier("ResumeTask"))
              .build();
        }
      }
    }
    return getResumeTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.SubscribeRequest,
      com.google.protobuf.Any> getSubscribeScenarioMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeScenarioMessage",
      requestType = zb.dcts.scenario.Scenario.SubscribeRequest.class,
      responseType = com.google.protobuf.Any.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.SubscribeRequest,
      com.google.protobuf.Any> getSubscribeScenarioMessageMethod() {
    io.grpc.MethodDescriptor<zb.dcts.scenario.Scenario.SubscribeRequest, com.google.protobuf.Any> getSubscribeScenarioMessageMethod;
    if ((getSubscribeScenarioMessageMethod = GeneralServiceGrpc.getSubscribeScenarioMessageMethod) == null) {
      synchronized (GeneralServiceGrpc.class) {
        if ((getSubscribeScenarioMessageMethod = GeneralServiceGrpc.getSubscribeScenarioMessageMethod) == null) {
          GeneralServiceGrpc.getSubscribeScenarioMessageMethod = getSubscribeScenarioMessageMethod =
              io.grpc.MethodDescriptor.<zb.dcts.scenario.Scenario.SubscribeRequest, com.google.protobuf.Any>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeScenarioMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.scenario.Scenario.SubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Any.getDefaultInstance()))
              .setSchemaDescriptor(new GeneralServiceMethodDescriptorSupplier("SubscribeScenarioMessage"))
              .build();
        }
      }
    }
    return getSubscribeScenarioMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GeneralServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeneralServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GeneralServiceStub>() {
        @java.lang.Override
        public GeneralServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GeneralServiceStub(channel, callOptions);
        }
      };
    return GeneralServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GeneralServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeneralServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GeneralServiceBlockingStub>() {
        @java.lang.Override
        public GeneralServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GeneralServiceBlockingStub(channel, callOptions);
        }
      };
    return GeneralServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GeneralServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeneralServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GeneralServiceFutureStub>() {
        @java.lang.Override
        public GeneralServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GeneralServiceFutureStub(channel, callOptions);
        }
      };
    return GeneralServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 通用管理的API
   * </pre>
   */
  public static abstract class GeneralServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void listAllScenarios(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenariosInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAllScenariosMethod(), responseObserver);
    }

    /**
     */
    public void listAllSources(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<zb.dcts.source.Source.SourceSetInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAllSourcesMethod(), responseObserver);
    }

    /**
     */
    public void getScenarioInfo(zb.dcts.scenario.Scenario.ScenarioId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetScenarioInfoMethod(), responseObserver);
    }

    /**
     */
    public void abortOne(zb.dcts.scenario.Scenario.ScenarioId request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAbortOneMethod(), responseObserver);
    }

    /**
     */
    public void abortAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAbortAllMethod(), responseObserver);
    }

    /**
     */
    public void pauseTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPauseTaskMethod(), responseObserver);
    }

    /**
     */
    public void resumeTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResumeTaskMethod(), responseObserver);
    }

    /**
     */
    public void subscribeScenarioMessage(zb.dcts.scenario.Scenario.SubscribeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Any> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeScenarioMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListAllScenariosMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                zb.dcts.scenario.Scenario.ScenariosInfo>(
                  this, METHODID_LIST_ALL_SCENARIOS)))
          .addMethod(
            getListAllSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                zb.dcts.source.Source.SourceSetInfo>(
                  this, METHODID_LIST_ALL_SOURCES)))
          .addMethod(
            getGetScenarioInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioId,
                zb.dcts.scenario.Scenario.ScenarioInfo>(
                  this, METHODID_GET_SCENARIO_INFO)))
          .addMethod(
            getAbortOneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioId,
                com.google.protobuf.Empty>(
                  this, METHODID_ABORT_ONE)))
          .addMethod(
            getAbortAllMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.google.protobuf.Empty>(
                  this, METHODID_ABORT_ALL)))
          .addMethod(
            getPauseTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_PAUSE_TASK)))
          .addMethod(
            getResumeTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.ScenarioTaskId,
                zb.dcts.scenario.Scenario.ScenarioReply>(
                  this, METHODID_RESUME_TASK)))
          .addMethod(
            getSubscribeScenarioMessageMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                zb.dcts.scenario.Scenario.SubscribeRequest,
                com.google.protobuf.Any>(
                  this, METHODID_SUBSCRIBE_SCENARIO_MESSAGE)))
          .build();
    }
  }

  /**
   * <pre>
   * 通用管理的API
   * </pre>
   */
  public static final class GeneralServiceStub extends io.grpc.stub.AbstractAsyncStub<GeneralServiceStub> {
    private GeneralServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneralServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeneralServiceStub(channel, callOptions);
    }

    /**
     */
    public void listAllScenarios(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenariosInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAllScenariosMethod(), getCallOptions()), request, responseObserver);
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
    public void getScenarioInfo(zb.dcts.scenario.Scenario.ScenarioId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScenarioInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void abortOne(zb.dcts.scenario.Scenario.ScenarioId request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAbortOneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void abortAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAbortAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pauseTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPauseTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void resumeTask(zb.dcts.scenario.Scenario.ScenarioTaskId request,
        io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribeScenarioMessage(zb.dcts.scenario.Scenario.SubscribeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Any> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeScenarioMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 通用管理的API
   * </pre>
   */
  public static final class GeneralServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GeneralServiceBlockingStub> {
    private GeneralServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneralServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeneralServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenariosInfo listAllScenarios(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllScenariosMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.source.Source.SourceSetInfo listAllSources(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllSourcesMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioInfo getScenarioInfo(zb.dcts.scenario.Scenario.ScenarioId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScenarioInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty abortOne(zb.dcts.scenario.Scenario.ScenarioId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAbortOneMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty abortAll(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAbortAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply pauseTask(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.scenario.Scenario.ScenarioReply resumeTask(zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.google.protobuf.Any> subscribeScenarioMessage(
        zb.dcts.scenario.Scenario.SubscribeRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeScenarioMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 通用管理的API
   * </pre>
   */
  public static final class GeneralServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GeneralServiceFutureStub> {
    private GeneralServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeneralServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeneralServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenariosInfo> listAllScenarios(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAllScenariosMethod(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioInfo> getScenarioInfo(
        zb.dcts.scenario.Scenario.ScenarioId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScenarioInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> abortOne(
        zb.dcts.scenario.Scenario.ScenarioId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAbortOneMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> abortAll(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAbortAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> pauseTask(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPauseTaskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.scenario.Scenario.ScenarioReply> resumeTask(
        zb.dcts.scenario.Scenario.ScenarioTaskId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeTaskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ALL_SCENARIOS = 0;
  private static final int METHODID_LIST_ALL_SOURCES = 1;
  private static final int METHODID_GET_SCENARIO_INFO = 2;
  private static final int METHODID_ABORT_ONE = 3;
  private static final int METHODID_ABORT_ALL = 4;
  private static final int METHODID_PAUSE_TASK = 5;
  private static final int METHODID_RESUME_TASK = 6;
  private static final int METHODID_SUBSCRIBE_SCENARIO_MESSAGE = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GeneralServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GeneralServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ALL_SCENARIOS:
          serviceImpl.listAllScenarios((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenariosInfo>) responseObserver);
          break;
        case METHODID_LIST_ALL_SOURCES:
          serviceImpl.listAllSources((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<zb.dcts.source.Source.SourceSetInfo>) responseObserver);
          break;
        case METHODID_GET_SCENARIO_INFO:
          serviceImpl.getScenarioInfo((zb.dcts.scenario.Scenario.ScenarioId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioInfo>) responseObserver);
          break;
        case METHODID_ABORT_ONE:
          serviceImpl.abortOne((zb.dcts.scenario.Scenario.ScenarioId) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ABORT_ALL:
          serviceImpl.abortAll((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_PAUSE_TASK:
          serviceImpl.pauseTask((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_RESUME_TASK:
          serviceImpl.resumeTask((zb.dcts.scenario.Scenario.ScenarioTaskId) request,
              (io.grpc.stub.StreamObserver<zb.dcts.scenario.Scenario.ScenarioReply>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_SCENARIO_MESSAGE:
          serviceImpl.subscribeScenarioMessage((zb.dcts.scenario.Scenario.SubscribeRequest) request,
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

  private static abstract class GeneralServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GeneralServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.scenario.Scenario.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GeneralService");
    }
  }

  private static final class GeneralServiceFileDescriptorSupplier
      extends GeneralServiceBaseDescriptorSupplier {
    GeneralServiceFileDescriptorSupplier() {}
  }

  private static final class GeneralServiceMethodDescriptorSupplier
      extends GeneralServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GeneralServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GeneralServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GeneralServiceFileDescriptorSupplier())
              .addMethod(getListAllScenariosMethod())
              .addMethod(getListAllSourcesMethod())
              .addMethod(getGetScenarioInfoMethod())
              .addMethod(getAbortOneMethod())
              .addMethod(getAbortAllMethod())
              .addMethod(getPauseTaskMethod())
              .addMethod(getResumeTaskMethod())
              .addMethod(getSubscribeScenarioMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
