package zb.dcts.database;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: database/DbKgdService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DbKgdServiceGrpc {

  private DbKgdServiceGrpc() {}

  public static final String SERVICE_NAME = "zb.dcts.database.DbKgdService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.SignalPropQueryRequest,
      zb.dcts.database.DbKgd.SignalPropResponse> getQuerySignalPropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QuerySignalProperty",
      requestType = zb.dcts.database.DbKgd.SignalPropQueryRequest.class,
      responseType = zb.dcts.database.DbKgd.SignalPropResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.SignalPropQueryRequest,
      zb.dcts.database.DbKgd.SignalPropResponse> getQuerySignalPropertyMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.SignalPropQueryRequest, zb.dcts.database.DbKgd.SignalPropResponse> getQuerySignalPropertyMethod;
    if ((getQuerySignalPropertyMethod = DbKgdServiceGrpc.getQuerySignalPropertyMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getQuerySignalPropertyMethod = DbKgdServiceGrpc.getQuerySignalPropertyMethod) == null) {
          DbKgdServiceGrpc.getQuerySignalPropertyMethod = getQuerySignalPropertyMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.SignalPropQueryRequest, zb.dcts.database.DbKgd.SignalPropResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QuerySignalProperty"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.SignalPropQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.SignalPropResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("QuerySignalProperty"))
              .build();
        }
      }
    }
    return getQuerySignalPropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgdServiceOuterClass.SpectrumOccupancyResponse> getQuerySpectrumOccupancyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QuerySpectrumOccupancy",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgdServiceOuterClass.SpectrumOccupancyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgdServiceOuterClass.SpectrumOccupancyResponse> getQuerySpectrumOccupancyMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgdServiceOuterClass.SpectrumOccupancyResponse> getQuerySpectrumOccupancyMethod;
    if ((getQuerySpectrumOccupancyMethod = DbKgdServiceGrpc.getQuerySpectrumOccupancyMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getQuerySpectrumOccupancyMethod = DbKgdServiceGrpc.getQuerySpectrumOccupancyMethod) == null) {
          DbKgdServiceGrpc.getQuerySpectrumOccupancyMethod = getQuerySpectrumOccupancyMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgdServiceOuterClass.SpectrumOccupancyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QuerySpectrumOccupancy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgdServiceOuterClass.SpectrumOccupancyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("QuerySpectrumOccupancy"))
              .build();
        }
      }
    }
    return getQuerySpectrumOccupancyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgdServiceOuterClass.SignalVariationResponse> getQuerySignalVariationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QuerySignalVariation",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgdServiceOuterClass.SignalVariationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgdServiceOuterClass.SignalVariationResponse> getQuerySignalVariationMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgdServiceOuterClass.SignalVariationResponse> getQuerySignalVariationMethod;
    if ((getQuerySignalVariationMethod = DbKgdServiceGrpc.getQuerySignalVariationMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getQuerySignalVariationMethod = DbKgdServiceGrpc.getQuerySignalVariationMethod) == null) {
          DbKgdServiceGrpc.getQuerySignalVariationMethod = getQuerySignalVariationMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgdServiceOuterClass.SignalVariationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QuerySignalVariation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgdServiceOuterClass.SignalVariationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("QuerySignalVariation"))
              .build();
        }
      }
    }
    return getQuerySignalVariationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgdServiceOuterClass.SignalTypesResponse> getQuerySignalTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QuerySignalTypes",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgdServiceOuterClass.SignalTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgdServiceOuterClass.SignalTypesResponse> getQuerySignalTypesMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgdServiceOuterClass.SignalTypesResponse> getQuerySignalTypesMethod;
    if ((getQuerySignalTypesMethod = DbKgdServiceGrpc.getQuerySignalTypesMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getQuerySignalTypesMethod = DbKgdServiceGrpc.getQuerySignalTypesMethod) == null) {
          DbKgdServiceGrpc.getQuerySignalTypesMethod = getQuerySignalTypesMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgdServiceOuterClass.SignalTypesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QuerySignalTypes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgdServiceOuterClass.SignalTypesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("QuerySignalTypes"))
              .build();
        }
      }
    }
    return getQuerySignalTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.SignalPropertyRequest,
      zb.dcts.database.DbKgd.SignalPropertyResponse> getAccessSignalPropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AccessSignalProperty",
      requestType = zb.dcts.database.DbKgd.SignalPropertyRequest.class,
      responseType = zb.dcts.database.DbKgd.SignalPropertyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.SignalPropertyRequest,
      zb.dcts.database.DbKgd.SignalPropertyResponse> getAccessSignalPropertyMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.SignalPropertyRequest, zb.dcts.database.DbKgd.SignalPropertyResponse> getAccessSignalPropertyMethod;
    if ((getAccessSignalPropertyMethod = DbKgdServiceGrpc.getAccessSignalPropertyMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getAccessSignalPropertyMethod = DbKgdServiceGrpc.getAccessSignalPropertyMethod) == null) {
          DbKgdServiceGrpc.getAccessSignalPropertyMethod = getAccessSignalPropertyMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.SignalPropertyRequest, zb.dcts.database.DbKgd.SignalPropertyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AccessSignalProperty"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.SignalPropertyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.SignalPropertyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("AccessSignalProperty"))
              .build();
        }
      }
    }
    return getAccessSignalPropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse> getQueryFreqBandOccupancyTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryFreqBandOccupancyTime",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse> getQueryFreqBandOccupancyTimeMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse> getQueryFreqBandOccupancyTimeMethod;
    if ((getQueryFreqBandOccupancyTimeMethod = DbKgdServiceGrpc.getQueryFreqBandOccupancyTimeMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getQueryFreqBandOccupancyTimeMethod = DbKgdServiceGrpc.getQueryFreqBandOccupancyTimeMethod) == null) {
          DbKgdServiceGrpc.getQueryFreqBandOccupancyTimeMethod = getQueryFreqBandOccupancyTimeMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryFreqBandOccupancyTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("QueryFreqBandOccupancyTime"))
              .build();
        }
      }
    }
    return getQueryFreqBandOccupancyTimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse> getQueryFreqBandOccupancyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryFreqBandOccupancy",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse> getQueryFreqBandOccupancyMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse> getQueryFreqBandOccupancyMethod;
    if ((getQueryFreqBandOccupancyMethod = DbKgdServiceGrpc.getQueryFreqBandOccupancyMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getQueryFreqBandOccupancyMethod = DbKgdServiceGrpc.getQueryFreqBandOccupancyMethod) == null) {
          DbKgdServiceGrpc.getQueryFreqBandOccupancyMethod = getQueryFreqBandOccupancyMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryFreqBandOccupancy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("QueryFreqBandOccupancy"))
              .build();
        }
      }
    }
    return getQueryFreqBandOccupancyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgdServiceOuterClass.FreqConflictResponse> getQueryFreqConflictMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryFreqConflict",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgdServiceOuterClass.FreqConflictResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgdServiceOuterClass.FreqConflictResponse> getQueryFreqConflictMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgdServiceOuterClass.FreqConflictResponse> getQueryFreqConflictMethod;
    if ((getQueryFreqConflictMethod = DbKgdServiceGrpc.getQueryFreqConflictMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getQueryFreqConflictMethod = DbKgdServiceGrpc.getQueryFreqConflictMethod) == null) {
          DbKgdServiceGrpc.getQueryFreqConflictMethod = getQueryFreqConflictMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgdServiceOuterClass.FreqConflictResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryFreqConflict"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgdServiceOuterClass.FreqConflictResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("QueryFreqConflict"))
              .build();
        }
      }
    }
    return getQueryFreqConflictMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.FusionTimeResponse> getQueryRecentFusionTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryRecentFusionTime",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgd.FusionTimeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.FusionTimeResponse> getQueryRecentFusionTimeMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.FusionTimeResponse> getQueryRecentFusionTimeMethod;
    if ((getQueryRecentFusionTimeMethod = DbKgdServiceGrpc.getQueryRecentFusionTimeMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getQueryRecentFusionTimeMethod = DbKgdServiceGrpc.getQueryRecentFusionTimeMethod) == null) {
          DbKgdServiceGrpc.getQueryRecentFusionTimeMethod = getQueryRecentFusionTimeMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.FusionTimeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryRecentFusionTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.FusionTimeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("QueryRecentFusionTime"))
              .build();
        }
      }
    }
    return getQueryRecentFusionTimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.FusionProcResponse> getStartFusionCommSignalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartFusionCommSignal",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgd.FusionProcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.FusionProcResponse> getStartFusionCommSignalMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.FusionProcResponse> getStartFusionCommSignalMethod;
    if ((getStartFusionCommSignalMethod = DbKgdServiceGrpc.getStartFusionCommSignalMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getStartFusionCommSignalMethod = DbKgdServiceGrpc.getStartFusionCommSignalMethod) == null) {
          DbKgdServiceGrpc.getStartFusionCommSignalMethod = getStartFusionCommSignalMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.FusionProcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartFusionCommSignal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.FusionProcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("StartFusionCommSignal"))
              .build();
        }
      }
    }
    return getStartFusionCommSignalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.FusionProcResponse> getStopFusionCommSignalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopFusionCommSignal",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgd.FusionProcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.FusionProcResponse> getStopFusionCommSignalMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.FusionProcResponse> getStopFusionCommSignalMethod;
    if ((getStopFusionCommSignalMethod = DbKgdServiceGrpc.getStopFusionCommSignalMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getStopFusionCommSignalMethod = DbKgdServiceGrpc.getStopFusionCommSignalMethod) == null) {
          DbKgdServiceGrpc.getStopFusionCommSignalMethod = getStopFusionCommSignalMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.FusionProcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopFusionCommSignal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.FusionProcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("StopFusionCommSignal"))
              .build();
        }
      }
    }
    return getStopFusionCommSignalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.Response> getExportdbDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportdbData",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgd.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.Response> getExportdbDataMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.Response> getExportdbDataMethod;
    if ((getExportdbDataMethod = DbKgdServiceGrpc.getExportdbDataMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getExportdbDataMethod = DbKgdServiceGrpc.getExportdbDataMethod) == null) {
          DbKgdServiceGrpc.getExportdbDataMethod = getExportdbDataMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportdbData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.Response.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("ExportdbData"))
              .build();
        }
      }
    }
    return getExportdbDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.Response> getImportdbDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportdbData",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgd.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.Response> getImportdbDataMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.Response> getImportdbDataMethod;
    if ((getImportdbDataMethod = DbKgdServiceGrpc.getImportdbDataMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getImportdbDataMethod = DbKgdServiceGrpc.getImportdbDataMethod) == null) {
          DbKgdServiceGrpc.getImportdbDataMethod = getImportdbDataMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportdbData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.Response.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("ImportdbData"))
              .build();
        }
      }
    }
    return getImportdbDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.Response> getCleardbDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CleardbData",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgd.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.Response> getCleardbDataMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.Response> getCleardbDataMethod;
    if ((getCleardbDataMethod = DbKgdServiceGrpc.getCleardbDataMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getCleardbDataMethod = DbKgdServiceGrpc.getCleardbDataMethod) == null) {
          DbKgdServiceGrpc.getCleardbDataMethod = getCleardbDataMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CleardbData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.Response.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("CleardbData"))
              .build();
        }
      }
    }
    return getCleardbDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.DbStatsResponse> getGetdbStorageSizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetdbStorageSize",
      requestType = zb.dcts.database.DbKgd.QueryRequest.class,
      responseType = zb.dcts.database.DbKgd.DbStatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest,
      zb.dcts.database.DbKgd.DbStatsResponse> getGetdbStorageSizeMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.DbStatsResponse> getGetdbStorageSizeMethod;
    if ((getGetdbStorageSizeMethod = DbKgdServiceGrpc.getGetdbStorageSizeMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getGetdbStorageSizeMethod = DbKgdServiceGrpc.getGetdbStorageSizeMethod) == null) {
          DbKgdServiceGrpc.getGetdbStorageSizeMethod = getGetdbStorageSizeMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgd.QueryRequest, zb.dcts.database.DbKgd.DbStatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetdbStorageSize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.QueryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgd.DbStatsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("GetdbStorageSize"))
              .build();
        }
      }
    }
    return getGetdbStorageSizeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.EquipmentDatabase.CommEquInfoRequest,
      zb.dcts.database.EquipmentDatabase.CommEquInfoResponse> getAccessCommEquInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AccessCommEquInfo",
      requestType = zb.dcts.database.EquipmentDatabase.CommEquInfoRequest.class,
      responseType = zb.dcts.database.EquipmentDatabase.CommEquInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.EquipmentDatabase.CommEquInfoRequest,
      zb.dcts.database.EquipmentDatabase.CommEquInfoResponse> getAccessCommEquInfoMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.EquipmentDatabase.CommEquInfoRequest, zb.dcts.database.EquipmentDatabase.CommEquInfoResponse> getAccessCommEquInfoMethod;
    if ((getAccessCommEquInfoMethod = DbKgdServiceGrpc.getAccessCommEquInfoMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getAccessCommEquInfoMethod = DbKgdServiceGrpc.getAccessCommEquInfoMethod) == null) {
          DbKgdServiceGrpc.getAccessCommEquInfoMethod = getAccessCommEquInfoMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.EquipmentDatabase.CommEquInfoRequest, zb.dcts.database.EquipmentDatabase.CommEquInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AccessCommEquInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.EquipmentDatabase.CommEquInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.EquipmentDatabase.CommEquInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("AccessCommEquInfo"))
              .build();
        }
      }
    }
    return getAccessCommEquInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.EquipmentDatabase.CommCounterEquInfoRequest,
      zb.dcts.database.EquipmentDatabase.CommCounterEquInfoResponse> getAccessCommCounterEquInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AccessCommCounterEquInfo",
      requestType = zb.dcts.database.EquipmentDatabase.CommCounterEquInfoRequest.class,
      responseType = zb.dcts.database.EquipmentDatabase.CommCounterEquInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.EquipmentDatabase.CommCounterEquInfoRequest,
      zb.dcts.database.EquipmentDatabase.CommCounterEquInfoResponse> getAccessCommCounterEquInfoMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.EquipmentDatabase.CommCounterEquInfoRequest, zb.dcts.database.EquipmentDatabase.CommCounterEquInfoResponse> getAccessCommCounterEquInfoMethod;
    if ((getAccessCommCounterEquInfoMethod = DbKgdServiceGrpc.getAccessCommCounterEquInfoMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getAccessCommCounterEquInfoMethod = DbKgdServiceGrpc.getAccessCommCounterEquInfoMethod) == null) {
          DbKgdServiceGrpc.getAccessCommCounterEquInfoMethod = getAccessCommCounterEquInfoMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.EquipmentDatabase.CommCounterEquInfoRequest, zb.dcts.database.EquipmentDatabase.CommCounterEquInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AccessCommCounterEquInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.EquipmentDatabase.CommCounterEquInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.EquipmentDatabase.CommCounterEquInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("AccessCommCounterEquInfo"))
              .build();
        }
      }
    }
    return getAccessCommCounterEquInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest,
      zb.dcts.database.DbKgdServiceOuterClass.SignalStatResult> getStartStatSignalResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartStatSignalResult",
      requestType = zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest.class,
      responseType = zb.dcts.database.DbKgdServiceOuterClass.SignalStatResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest,
      zb.dcts.database.DbKgdServiceOuterClass.SignalStatResult> getStartStatSignalResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest, zb.dcts.database.DbKgdServiceOuterClass.SignalStatResult> getStartStatSignalResultMethod;
    if ((getStartStatSignalResultMethod = DbKgdServiceGrpc.getStartStatSignalResultMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getStartStatSignalResultMethod = DbKgdServiceGrpc.getStartStatSignalResultMethod) == null) {
          DbKgdServiceGrpc.getStartStatSignalResultMethod = getStartStatSignalResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest, zb.dcts.database.DbKgdServiceOuterClass.SignalStatResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartStatSignalResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgdServiceOuterClass.SignalStatResult.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("StartStatSignalResult"))
              .build();
        }
      }
    }
    return getStartStatSignalResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest,
      zb.dcts.database.DbKgdServiceOuterClass.SignalTimeSeqResult> getStartTimeSeqResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartTimeSeqResult",
      requestType = zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest.class,
      responseType = zb.dcts.database.DbKgdServiceOuterClass.SignalTimeSeqResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest,
      zb.dcts.database.DbKgdServiceOuterClass.SignalTimeSeqResult> getStartTimeSeqResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest, zb.dcts.database.DbKgdServiceOuterClass.SignalTimeSeqResult> getStartTimeSeqResultMethod;
    if ((getStartTimeSeqResultMethod = DbKgdServiceGrpc.getStartTimeSeqResultMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getStartTimeSeqResultMethod = DbKgdServiceGrpc.getStartTimeSeqResultMethod) == null) {
          DbKgdServiceGrpc.getStartTimeSeqResultMethod = getStartTimeSeqResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest, zb.dcts.database.DbKgdServiceOuterClass.SignalTimeSeqResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartTimeSeqResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgdServiceOuterClass.SignalTimeSeqResult.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("StartTimeSeqResult"))
              .build();
        }
      }
    }
    return getStartTimeSeqResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest,
      zb.dcts.database.DbKgdServiceOuterClass.SignalDisciplinarianResult> getStartDisciplinarianResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartDisciplinarianResult",
      requestType = zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest.class,
      responseType = zb.dcts.database.DbKgdServiceOuterClass.SignalDisciplinarianResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest,
      zb.dcts.database.DbKgdServiceOuterClass.SignalDisciplinarianResult> getStartDisciplinarianResultMethod() {
    io.grpc.MethodDescriptor<zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest, zb.dcts.database.DbKgdServiceOuterClass.SignalDisciplinarianResult> getStartDisciplinarianResultMethod;
    if ((getStartDisciplinarianResultMethod = DbKgdServiceGrpc.getStartDisciplinarianResultMethod) == null) {
      synchronized (DbKgdServiceGrpc.class) {
        if ((getStartDisciplinarianResultMethod = DbKgdServiceGrpc.getStartDisciplinarianResultMethod) == null) {
          DbKgdServiceGrpc.getStartDisciplinarianResultMethod = getStartDisciplinarianResultMethod =
              io.grpc.MethodDescriptor.<zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest, zb.dcts.database.DbKgdServiceOuterClass.SignalDisciplinarianResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartDisciplinarianResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  zb.dcts.database.DbKgdServiceOuterClass.SignalDisciplinarianResult.getDefaultInstance()))
              .setSchemaDescriptor(new DbKgdServiceMethodDescriptorSupplier("StartDisciplinarianResult"))
              .build();
        }
      }
    }
    return getStartDisciplinarianResultMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DbKgdServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DbKgdServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DbKgdServiceStub>() {
        @java.lang.Override
        public DbKgdServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DbKgdServiceStub(channel, callOptions);
        }
      };
    return DbKgdServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DbKgdServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DbKgdServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DbKgdServiceBlockingStub>() {
        @java.lang.Override
        public DbKgdServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DbKgdServiceBlockingStub(channel, callOptions);
        }
      };
    return DbKgdServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DbKgdServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DbKgdServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DbKgdServiceFutureStub>() {
        @java.lang.Override
        public DbKgdServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DbKgdServiceFutureStub(channel, callOptions);
        }
      };
    return DbKgdServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DbKgdServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void querySignalProperty(zb.dcts.database.DbKgd.SignalPropQueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.SignalPropResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQuerySignalPropertyMethod(), responseObserver);
    }

    /**
     */
    public void querySpectrumOccupancy(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SpectrumOccupancyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQuerySpectrumOccupancyMethod(), responseObserver);
    }

    /**
     */
    public void querySignalVariation(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalVariationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQuerySignalVariationMethod(), responseObserver);
    }

    /**
     */
    public void querySignalTypes(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalTypesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQuerySignalTypesMethod(), responseObserver);
    }

    /**
     * <pre>
     * rpc QuerySignalTimeSpanFeature(QueryRequest)returns(SignalTimeSpanFeatureResponse){}//统计信号参数
     * </pre>
     */
    public void accessSignalProperty(zb.dcts.database.DbKgd.SignalPropertyRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.SignalPropertyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAccessSignalPropertyMethod(), responseObserver);
    }

    /**
     */
    public void queryFreqBandOccupancyTime(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryFreqBandOccupancyTimeMethod(), responseObserver);
    }

    /**
     */
    public void queryFreqBandOccupancy(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryFreqBandOccupancyMethod(), responseObserver);
    }

    /**
     */
    public void queryFreqConflict(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.FreqConflictResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryFreqConflictMethod(), responseObserver);
    }

    /**
     */
    public void queryRecentFusionTime(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.FusionTimeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryRecentFusionTimeMethod(), responseObserver);
    }

    /**
     */
    public void startFusionCommSignal(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.FusionProcResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartFusionCommSignalMethod(), responseObserver);
    }

    /**
     */
    public void stopFusionCommSignal(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.FusionProcResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopFusionCommSignalMethod(), responseObserver);
    }

    /**
     */
    public void exportdbData(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportdbDataMethod(), responseObserver);
    }

    /**
     */
    public void importdbData(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportdbDataMethod(), responseObserver);
    }

    /**
     */
    public void cleardbData(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCleardbDataMethod(), responseObserver);
    }

    /**
     */
    public void getdbStorageSize(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.DbStatsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetdbStorageSizeMethod(), responseObserver);
    }

    /**
     */
    public void accessCommEquInfo(zb.dcts.database.EquipmentDatabase.CommEquInfoRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.EquipmentDatabase.CommEquInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAccessCommEquInfoMethod(), responseObserver);
    }

    /**
     */
    public void accessCommCounterEquInfo(zb.dcts.database.EquipmentDatabase.CommCounterEquInfoRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.EquipmentDatabase.CommCounterEquInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAccessCommCounterEquInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     *历史数据挖掘服务
     * </pre>
     */
    public void startStatSignalResult(zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalStatResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartStatSignalResultMethod(), responseObserver);
    }

    /**
     */
    public void startTimeSeqResult(zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalTimeSeqResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartTimeSeqResultMethod(), responseObserver);
    }

    /**
     */
    public void startDisciplinarianResult(zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalDisciplinarianResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartDisciplinarianResultMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getQuerySignalPropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.SignalPropQueryRequest,
                zb.dcts.database.DbKgd.SignalPropResponse>(
                  this, METHODID_QUERY_SIGNAL_PROPERTY)))
          .addMethod(
            getQuerySpectrumOccupancyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgdServiceOuterClass.SpectrumOccupancyResponse>(
                  this, METHODID_QUERY_SPECTRUM_OCCUPANCY)))
          .addMethod(
            getQuerySignalVariationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgdServiceOuterClass.SignalVariationResponse>(
                  this, METHODID_QUERY_SIGNAL_VARIATION)))
          .addMethod(
            getQuerySignalTypesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgdServiceOuterClass.SignalTypesResponse>(
                  this, METHODID_QUERY_SIGNAL_TYPES)))
          .addMethod(
            getAccessSignalPropertyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.SignalPropertyRequest,
                zb.dcts.database.DbKgd.SignalPropertyResponse>(
                  this, METHODID_ACCESS_SIGNAL_PROPERTY)))
          .addMethod(
            getQueryFreqBandOccupancyTimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse>(
                  this, METHODID_QUERY_FREQ_BAND_OCCUPANCY_TIME)))
          .addMethod(
            getQueryFreqBandOccupancyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse>(
                  this, METHODID_QUERY_FREQ_BAND_OCCUPANCY)))
          .addMethod(
            getQueryFreqConflictMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgdServiceOuterClass.FreqConflictResponse>(
                  this, METHODID_QUERY_FREQ_CONFLICT)))
          .addMethod(
            getQueryRecentFusionTimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgd.FusionTimeResponse>(
                  this, METHODID_QUERY_RECENT_FUSION_TIME)))
          .addMethod(
            getStartFusionCommSignalMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgd.FusionProcResponse>(
                  this, METHODID_START_FUSION_COMM_SIGNAL)))
          .addMethod(
            getStopFusionCommSignalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgd.FusionProcResponse>(
                  this, METHODID_STOP_FUSION_COMM_SIGNAL)))
          .addMethod(
            getExportdbDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgd.Response>(
                  this, METHODID_EXPORTDB_DATA)))
          .addMethod(
            getImportdbDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgd.Response>(
                  this, METHODID_IMPORTDB_DATA)))
          .addMethod(
            getCleardbDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgd.Response>(
                  this, METHODID_CLEARDB_DATA)))
          .addMethod(
            getGetdbStorageSizeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgd.QueryRequest,
                zb.dcts.database.DbKgd.DbStatsResponse>(
                  this, METHODID_GETDB_STORAGE_SIZE)))
          .addMethod(
            getAccessCommEquInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.EquipmentDatabase.CommEquInfoRequest,
                zb.dcts.database.EquipmentDatabase.CommEquInfoResponse>(
                  this, METHODID_ACCESS_COMM_EQU_INFO)))
          .addMethod(
            getAccessCommCounterEquInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.EquipmentDatabase.CommCounterEquInfoRequest,
                zb.dcts.database.EquipmentDatabase.CommCounterEquInfoResponse>(
                  this, METHODID_ACCESS_COMM_COUNTER_EQU_INFO)))
          .addMethod(
            getStartStatSignalResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest,
                zb.dcts.database.DbKgdServiceOuterClass.SignalStatResult>(
                  this, METHODID_START_STAT_SIGNAL_RESULT)))
          .addMethod(
            getStartTimeSeqResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest,
                zb.dcts.database.DbKgdServiceOuterClass.SignalTimeSeqResult>(
                  this, METHODID_START_TIME_SEQ_RESULT)))
          .addMethod(
            getStartDisciplinarianResultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest,
                zb.dcts.database.DbKgdServiceOuterClass.SignalDisciplinarianResult>(
                  this, METHODID_START_DISCIPLINARIAN_RESULT)))
          .build();
    }
  }

  /**
   */
  public static final class DbKgdServiceStub extends io.grpc.stub.AbstractAsyncStub<DbKgdServiceStub> {
    private DbKgdServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DbKgdServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DbKgdServiceStub(channel, callOptions);
    }

    /**
     */
    public void querySignalProperty(zb.dcts.database.DbKgd.SignalPropQueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.SignalPropResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQuerySignalPropertyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void querySpectrumOccupancy(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SpectrumOccupancyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQuerySpectrumOccupancyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void querySignalVariation(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalVariationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQuerySignalVariationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void querySignalTypes(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalTypesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQuerySignalTypesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * rpc QuerySignalTimeSpanFeature(QueryRequest)returns(SignalTimeSpanFeatureResponse){}//统计信号参数
     * </pre>
     */
    public void accessSignalProperty(zb.dcts.database.DbKgd.SignalPropertyRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.SignalPropertyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAccessSignalPropertyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void queryFreqBandOccupancyTime(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryFreqBandOccupancyTimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void queryFreqBandOccupancy(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryFreqBandOccupancyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void queryFreqConflict(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.FreqConflictResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryFreqConflictMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void queryRecentFusionTime(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.FusionTimeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryRecentFusionTimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void startFusionCommSignal(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.FusionProcResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStartFusionCommSignalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stopFusionCommSignal(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.FusionProcResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopFusionCommSignalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void exportdbData(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportdbDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void importdbData(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportdbDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cleardbData(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCleardbDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getdbStorageSize(zb.dcts.database.DbKgd.QueryRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.DbStatsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetdbStorageSizeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void accessCommEquInfo(zb.dcts.database.EquipmentDatabase.CommEquInfoRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.EquipmentDatabase.CommEquInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAccessCommEquInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void accessCommCounterEquInfo(zb.dcts.database.EquipmentDatabase.CommCounterEquInfoRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.EquipmentDatabase.CommCounterEquInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAccessCommCounterEquInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *历史数据挖掘服务
     * </pre>
     */
    public void startStatSignalResult(zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalStatResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartStatSignalResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void startTimeSeqResult(zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalTimeSeqResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartTimeSeqResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void startDisciplinarianResult(zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest request,
        io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalDisciplinarianResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartDisciplinarianResultMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DbKgdServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DbKgdServiceBlockingStub> {
    private DbKgdServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DbKgdServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DbKgdServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public zb.dcts.database.DbKgd.SignalPropResponse querySignalProperty(zb.dcts.database.DbKgd.SignalPropQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQuerySignalPropertyMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgdServiceOuterClass.SpectrumOccupancyResponse querySpectrumOccupancy(zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQuerySpectrumOccupancyMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgdServiceOuterClass.SignalVariationResponse querySignalVariation(zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQuerySignalVariationMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgdServiceOuterClass.SignalTypesResponse querySignalTypes(zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQuerySignalTypesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * rpc QuerySignalTimeSpanFeature(QueryRequest)returns(SignalTimeSpanFeatureResponse){}//统计信号参数
     * </pre>
     */
    public zb.dcts.database.DbKgd.SignalPropertyResponse accessSignalProperty(zb.dcts.database.DbKgd.SignalPropertyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAccessSignalPropertyMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse queryFreqBandOccupancyTime(zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryFreqBandOccupancyTimeMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse queryFreqBandOccupancy(zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryFreqBandOccupancyMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgdServiceOuterClass.FreqConflictResponse queryFreqConflict(zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryFreqConflictMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgd.FusionTimeResponse queryRecentFusionTime(zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryRecentFusionTimeMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<zb.dcts.database.DbKgd.FusionProcResponse> startFusionCommSignal(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStartFusionCommSignalMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgd.FusionProcResponse stopFusionCommSignal(zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopFusionCommSignalMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgd.Response exportdbData(zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportdbDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgd.Response importdbData(zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportdbDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgd.Response cleardbData(zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCleardbDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgd.DbStatsResponse getdbStorageSize(zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetdbStorageSizeMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.EquipmentDatabase.CommEquInfoResponse accessCommEquInfo(zb.dcts.database.EquipmentDatabase.CommEquInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAccessCommEquInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.EquipmentDatabase.CommCounterEquInfoResponse accessCommCounterEquInfo(zb.dcts.database.EquipmentDatabase.CommCounterEquInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAccessCommCounterEquInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *历史数据挖掘服务
     * </pre>
     */
    public zb.dcts.database.DbKgdServiceOuterClass.SignalStatResult startStatSignalResult(zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartStatSignalResultMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgdServiceOuterClass.SignalTimeSeqResult startTimeSeqResult(zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartTimeSeqResultMethod(), getCallOptions(), request);
    }

    /**
     */
    public zb.dcts.database.DbKgdServiceOuterClass.SignalDisciplinarianResult startDisciplinarianResult(zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartDisciplinarianResultMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DbKgdServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DbKgdServiceFutureStub> {
    private DbKgdServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DbKgdServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DbKgdServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgd.SignalPropResponse> querySignalProperty(
        zb.dcts.database.DbKgd.SignalPropQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQuerySignalPropertyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgdServiceOuterClass.SpectrumOccupancyResponse> querySpectrumOccupancy(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQuerySpectrumOccupancyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgdServiceOuterClass.SignalVariationResponse> querySignalVariation(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQuerySignalVariationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgdServiceOuterClass.SignalTypesResponse> querySignalTypes(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQuerySignalTypesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * rpc QuerySignalTimeSpanFeature(QueryRequest)returns(SignalTimeSpanFeatureResponse){}//统计信号参数
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgd.SignalPropertyResponse> accessSignalProperty(
        zb.dcts.database.DbKgd.SignalPropertyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAccessSignalPropertyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse> queryFreqBandOccupancyTime(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryFreqBandOccupancyTimeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse> queryFreqBandOccupancy(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryFreqBandOccupancyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgdServiceOuterClass.FreqConflictResponse> queryFreqConflict(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryFreqConflictMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgd.FusionTimeResponse> queryRecentFusionTime(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryRecentFusionTimeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgd.FusionProcResponse> stopFusionCommSignal(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopFusionCommSignalMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgd.Response> exportdbData(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportdbDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgd.Response> importdbData(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportdbDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgd.Response> cleardbData(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCleardbDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgd.DbStatsResponse> getdbStorageSize(
        zb.dcts.database.DbKgd.QueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetdbStorageSizeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.EquipmentDatabase.CommEquInfoResponse> accessCommEquInfo(
        zb.dcts.database.EquipmentDatabase.CommEquInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAccessCommEquInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.EquipmentDatabase.CommCounterEquInfoResponse> accessCommCounterEquInfo(
        zb.dcts.database.EquipmentDatabase.CommCounterEquInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAccessCommCounterEquInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *历史数据挖掘服务
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgdServiceOuterClass.SignalStatResult> startStatSignalResult(
        zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartStatSignalResultMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgdServiceOuterClass.SignalTimeSeqResult> startTimeSeqResult(
        zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartTimeSeqResultMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<zb.dcts.database.DbKgdServiceOuterClass.SignalDisciplinarianResult> startDisciplinarianResult(
        zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartDisciplinarianResultMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY_SIGNAL_PROPERTY = 0;
  private static final int METHODID_QUERY_SPECTRUM_OCCUPANCY = 1;
  private static final int METHODID_QUERY_SIGNAL_VARIATION = 2;
  private static final int METHODID_QUERY_SIGNAL_TYPES = 3;
  private static final int METHODID_ACCESS_SIGNAL_PROPERTY = 4;
  private static final int METHODID_QUERY_FREQ_BAND_OCCUPANCY_TIME = 5;
  private static final int METHODID_QUERY_FREQ_BAND_OCCUPANCY = 6;
  private static final int METHODID_QUERY_FREQ_CONFLICT = 7;
  private static final int METHODID_QUERY_RECENT_FUSION_TIME = 8;
  private static final int METHODID_START_FUSION_COMM_SIGNAL = 9;
  private static final int METHODID_STOP_FUSION_COMM_SIGNAL = 10;
  private static final int METHODID_EXPORTDB_DATA = 11;
  private static final int METHODID_IMPORTDB_DATA = 12;
  private static final int METHODID_CLEARDB_DATA = 13;
  private static final int METHODID_GETDB_STORAGE_SIZE = 14;
  private static final int METHODID_ACCESS_COMM_EQU_INFO = 15;
  private static final int METHODID_ACCESS_COMM_COUNTER_EQU_INFO = 16;
  private static final int METHODID_START_STAT_SIGNAL_RESULT = 17;
  private static final int METHODID_START_TIME_SEQ_RESULT = 18;
  private static final int METHODID_START_DISCIPLINARIAN_RESULT = 19;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DbKgdServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DbKgdServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY_SIGNAL_PROPERTY:
          serviceImpl.querySignalProperty((zb.dcts.database.DbKgd.SignalPropQueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.SignalPropResponse>) responseObserver);
          break;
        case METHODID_QUERY_SPECTRUM_OCCUPANCY:
          serviceImpl.querySpectrumOccupancy((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SpectrumOccupancyResponse>) responseObserver);
          break;
        case METHODID_QUERY_SIGNAL_VARIATION:
          serviceImpl.querySignalVariation((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalVariationResponse>) responseObserver);
          break;
        case METHODID_QUERY_SIGNAL_TYPES:
          serviceImpl.querySignalTypes((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalTypesResponse>) responseObserver);
          break;
        case METHODID_ACCESS_SIGNAL_PROPERTY:
          serviceImpl.accessSignalProperty((zb.dcts.database.DbKgd.SignalPropertyRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.SignalPropertyResponse>) responseObserver);
          break;
        case METHODID_QUERY_FREQ_BAND_OCCUPANCY_TIME:
          serviceImpl.queryFreqBandOccupancyTime((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse>) responseObserver);
          break;
        case METHODID_QUERY_FREQ_BAND_OCCUPANCY:
          serviceImpl.queryFreqBandOccupancy((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.FreqBandOccupancyResponse>) responseObserver);
          break;
        case METHODID_QUERY_FREQ_CONFLICT:
          serviceImpl.queryFreqConflict((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.FreqConflictResponse>) responseObserver);
          break;
        case METHODID_QUERY_RECENT_FUSION_TIME:
          serviceImpl.queryRecentFusionTime((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.FusionTimeResponse>) responseObserver);
          break;
        case METHODID_START_FUSION_COMM_SIGNAL:
          serviceImpl.startFusionCommSignal((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.FusionProcResponse>) responseObserver);
          break;
        case METHODID_STOP_FUSION_COMM_SIGNAL:
          serviceImpl.stopFusionCommSignal((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.FusionProcResponse>) responseObserver);
          break;
        case METHODID_EXPORTDB_DATA:
          serviceImpl.exportdbData((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.Response>) responseObserver);
          break;
        case METHODID_IMPORTDB_DATA:
          serviceImpl.importdbData((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.Response>) responseObserver);
          break;
        case METHODID_CLEARDB_DATA:
          serviceImpl.cleardbData((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.Response>) responseObserver);
          break;
        case METHODID_GETDB_STORAGE_SIZE:
          serviceImpl.getdbStorageSize((zb.dcts.database.DbKgd.QueryRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgd.DbStatsResponse>) responseObserver);
          break;
        case METHODID_ACCESS_COMM_EQU_INFO:
          serviceImpl.accessCommEquInfo((zb.dcts.database.EquipmentDatabase.CommEquInfoRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.EquipmentDatabase.CommEquInfoResponse>) responseObserver);
          break;
        case METHODID_ACCESS_COMM_COUNTER_EQU_INFO:
          serviceImpl.accessCommCounterEquInfo((zb.dcts.database.EquipmentDatabase.CommCounterEquInfoRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.EquipmentDatabase.CommCounterEquInfoResponse>) responseObserver);
          break;
        case METHODID_START_STAT_SIGNAL_RESULT:
          serviceImpl.startStatSignalResult((zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalStatResult>) responseObserver);
          break;
        case METHODID_START_TIME_SEQ_RESULT:
          serviceImpl.startTimeSeqResult((zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalTimeSeqResult>) responseObserver);
          break;
        case METHODID_START_DISCIPLINARIAN_RESULT:
          serviceImpl.startDisciplinarianResult((zb.dcts.database.DbKgdServiceOuterClass.SignalStatRequest) request,
              (io.grpc.stub.StreamObserver<zb.dcts.database.DbKgdServiceOuterClass.SignalDisciplinarianResult>) responseObserver);
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

  private static abstract class DbKgdServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DbKgdServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return zb.dcts.database.DbKgdServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DbKgdService");
    }
  }

  private static final class DbKgdServiceFileDescriptorSupplier
      extends DbKgdServiceBaseDescriptorSupplier {
    DbKgdServiceFileDescriptorSupplier() {}
  }

  private static final class DbKgdServiceMethodDescriptorSupplier
      extends DbKgdServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DbKgdServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DbKgdServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DbKgdServiceFileDescriptorSupplier())
              .addMethod(getQuerySignalPropertyMethod())
              .addMethod(getQuerySpectrumOccupancyMethod())
              .addMethod(getQuerySignalVariationMethod())
              .addMethod(getQuerySignalTypesMethod())
              .addMethod(getAccessSignalPropertyMethod())
              .addMethod(getQueryFreqBandOccupancyTimeMethod())
              .addMethod(getQueryFreqBandOccupancyMethod())
              .addMethod(getQueryFreqConflictMethod())
              .addMethod(getQueryRecentFusionTimeMethod())
              .addMethod(getStartFusionCommSignalMethod())
              .addMethod(getStopFusionCommSignalMethod())
              .addMethod(getExportdbDataMethod())
              .addMethod(getImportdbDataMethod())
              .addMethod(getCleardbDataMethod())
              .addMethod(getGetdbStorageSizeMethod())
              .addMethod(getAccessCommEquInfoMethod())
              .addMethod(getAccessCommCounterEquInfoMethod())
              .addMethod(getStartStatSignalResultMethod())
              .addMethod(getStartTimeSeqResultMethod())
              .addMethod(getStartDisciplinarianResultMethod())
              .build();
        }
      }
    }
    return result;
  }
}
