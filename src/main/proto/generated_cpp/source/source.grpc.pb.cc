// Generated by the gRPC C++ plugin.
// If you make any local change, they will be lost.
// source: source/source.proto

#include "source/source.pb.h"
#include "source/source.grpc.pb.h"

#include <functional>
#include <grpcpp/impl/codegen/async_stream.h>
#include <grpcpp/impl/codegen/async_unary_call.h>
#include <grpcpp/impl/codegen/channel_interface.h>
#include <grpcpp/impl/codegen/client_unary_call.h>
#include <grpcpp/impl/codegen/client_callback.h>
#include <grpcpp/impl/codegen/message_allocator.h>
#include <grpcpp/impl/codegen/method_handler.h>
#include <grpcpp/impl/codegen/rpc_service_method.h>
#include <grpcpp/impl/codegen/server_callback.h>
#include <grpcpp/impl/codegen/server_callback_handlers.h>
#include <grpcpp/impl/codegen/server_context.h>
#include <grpcpp/impl/codegen/service_type.h>
#include <grpcpp/impl/codegen/sync_stream.h>
namespace zb {
namespace dcts {
namespace source {

static const char* SourceControlService_method_names[] = {
  "/zb.dcts.source.SourceControlService/ListAllSources",
  "/zb.dcts.source.SourceControlService/SendSourceCommand",
  "/zb.dcts.source.SourceControlService/SubscribeSourceMessage",
};

std::unique_ptr< SourceControlService::Stub> SourceControlService::NewStub(const std::shared_ptr< ::grpc::ChannelInterface>& channel, const ::grpc::StubOptions& options) {
  (void)options;
  std::unique_ptr< SourceControlService::Stub> stub(new SourceControlService::Stub(channel));
  return stub;
}

SourceControlService::Stub::Stub(const std::shared_ptr< ::grpc::ChannelInterface>& channel)
  : channel_(channel), rpcmethod_ListAllSources_(SourceControlService_method_names[0], ::grpc::internal::RpcMethod::NORMAL_RPC, channel)
  , rpcmethod_SendSourceCommand_(SourceControlService_method_names[1], ::grpc::internal::RpcMethod::NORMAL_RPC, channel)
  , rpcmethod_SubscribeSourceMessage_(SourceControlService_method_names[2], ::grpc::internal::RpcMethod::SERVER_STREAMING, channel)
  {}

::grpc::Status SourceControlService::Stub::ListAllSources(::grpc::ClientContext* context, const ::google::protobuf::Empty& request, ::zb::dcts::source::SourceSetInfo* response) {
  return ::grpc::internal::BlockingUnaryCall(channel_.get(), rpcmethod_ListAllSources_, context, request, response);
}

void SourceControlService::Stub::experimental_async::ListAllSources(::grpc::ClientContext* context, const ::google::protobuf::Empty* request, ::zb::dcts::source::SourceSetInfo* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_ListAllSources_, context, request, response, std::move(f));
}

void SourceControlService::Stub::experimental_async::ListAllSources(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::source::SourceSetInfo* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_ListAllSources_, context, request, response, std::move(f));
}

void SourceControlService::Stub::experimental_async::ListAllSources(::grpc::ClientContext* context, const ::google::protobuf::Empty* request, ::zb::dcts::source::SourceSetInfo* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_ListAllSources_, context, request, response, reactor);
}

void SourceControlService::Stub::experimental_async::ListAllSources(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::source::SourceSetInfo* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_ListAllSources_, context, request, response, reactor);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::source::SourceSetInfo>* SourceControlService::Stub::AsyncListAllSourcesRaw(::grpc::ClientContext* context, const ::google::protobuf::Empty& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::source::SourceSetInfo>::Create(channel_.get(), cq, rpcmethod_ListAllSources_, context, request, true);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::source::SourceSetInfo>* SourceControlService::Stub::PrepareAsyncListAllSourcesRaw(::grpc::ClientContext* context, const ::google::protobuf::Empty& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::source::SourceSetInfo>::Create(channel_.get(), cq, rpcmethod_ListAllSources_, context, request, false);
}

::grpc::Status SourceControlService::Stub::SendSourceCommand(::grpc::ClientContext* context, const ::zb::dcts::source::SourceCommand& request, ::zb::dcts::source::SourceCommandReply* response) {
  return ::grpc::internal::BlockingUnaryCall(channel_.get(), rpcmethod_SendSourceCommand_, context, request, response);
}

void SourceControlService::Stub::experimental_async::SendSourceCommand(::grpc::ClientContext* context, const ::zb::dcts::source::SourceCommand* request, ::zb::dcts::source::SourceCommandReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_SendSourceCommand_, context, request, response, std::move(f));
}

void SourceControlService::Stub::experimental_async::SendSourceCommand(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::source::SourceCommandReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_SendSourceCommand_, context, request, response, std::move(f));
}

void SourceControlService::Stub::experimental_async::SendSourceCommand(::grpc::ClientContext* context, const ::zb::dcts::source::SourceCommand* request, ::zb::dcts::source::SourceCommandReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_SendSourceCommand_, context, request, response, reactor);
}

void SourceControlService::Stub::experimental_async::SendSourceCommand(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::source::SourceCommandReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_SendSourceCommand_, context, request, response, reactor);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::source::SourceCommandReply>* SourceControlService::Stub::AsyncSendSourceCommandRaw(::grpc::ClientContext* context, const ::zb::dcts::source::SourceCommand& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::source::SourceCommandReply>::Create(channel_.get(), cq, rpcmethod_SendSourceCommand_, context, request, true);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::source::SourceCommandReply>* SourceControlService::Stub::PrepareAsyncSendSourceCommandRaw(::grpc::ClientContext* context, const ::zb::dcts::source::SourceCommand& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::source::SourceCommandReply>::Create(channel_.get(), cq, rpcmethod_SendSourceCommand_, context, request, false);
}

::grpc::ClientReader< ::google::protobuf::Any>* SourceControlService::Stub::SubscribeSourceMessageRaw(::grpc::ClientContext* context, const ::zb::dcts::source::SubscribeRequest& request) {
  return ::grpc_impl::internal::ClientReaderFactory< ::google::protobuf::Any>::Create(channel_.get(), rpcmethod_SubscribeSourceMessage_, context, request);
}

void SourceControlService::Stub::experimental_async::SubscribeSourceMessage(::grpc::ClientContext* context, ::zb::dcts::source::SubscribeRequest* request, ::grpc::experimental::ClientReadReactor< ::google::protobuf::Any>* reactor) {
  ::grpc_impl::internal::ClientCallbackReaderFactory< ::google::protobuf::Any>::Create(stub_->channel_.get(), stub_->rpcmethod_SubscribeSourceMessage_, context, request, reactor);
}

::grpc::ClientAsyncReader< ::google::protobuf::Any>* SourceControlService::Stub::AsyncSubscribeSourceMessageRaw(::grpc::ClientContext* context, const ::zb::dcts::source::SubscribeRequest& request, ::grpc::CompletionQueue* cq, void* tag) {
  return ::grpc_impl::internal::ClientAsyncReaderFactory< ::google::protobuf::Any>::Create(channel_.get(), cq, rpcmethod_SubscribeSourceMessage_, context, request, true, tag);
}

::grpc::ClientAsyncReader< ::google::protobuf::Any>* SourceControlService::Stub::PrepareAsyncSubscribeSourceMessageRaw(::grpc::ClientContext* context, const ::zb::dcts::source::SubscribeRequest& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncReaderFactory< ::google::protobuf::Any>::Create(channel_.get(), cq, rpcmethod_SubscribeSourceMessage_, context, request, false, nullptr);
}

SourceControlService::Service::Service() {
  AddMethod(new ::grpc::internal::RpcServiceMethod(
      SourceControlService_method_names[0],
      ::grpc::internal::RpcMethod::NORMAL_RPC,
      new ::grpc::internal::RpcMethodHandler< SourceControlService::Service, ::google::protobuf::Empty, ::zb::dcts::source::SourceSetInfo>(
          std::mem_fn(&SourceControlService::Service::ListAllSources), this)));
  AddMethod(new ::grpc::internal::RpcServiceMethod(
      SourceControlService_method_names[1],
      ::grpc::internal::RpcMethod::NORMAL_RPC,
      new ::grpc::internal::RpcMethodHandler< SourceControlService::Service, ::zb::dcts::source::SourceCommand, ::zb::dcts::source::SourceCommandReply>(
          std::mem_fn(&SourceControlService::Service::SendSourceCommand), this)));
  AddMethod(new ::grpc::internal::RpcServiceMethod(
      SourceControlService_method_names[2],
      ::grpc::internal::RpcMethod::SERVER_STREAMING,
      new ::grpc::internal::ServerStreamingHandler< SourceControlService::Service, ::zb::dcts::source::SubscribeRequest, ::google::protobuf::Any>(
          std::mem_fn(&SourceControlService::Service::SubscribeSourceMessage), this)));
}

SourceControlService::Service::~Service() {
}

::grpc::Status SourceControlService::Service::ListAllSources(::grpc::ServerContext* context, const ::google::protobuf::Empty* request, ::zb::dcts::source::SourceSetInfo* response) {
  (void) context;
  (void) request;
  (void) response;
  return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
}

::grpc::Status SourceControlService::Service::SendSourceCommand(::grpc::ServerContext* context, const ::zb::dcts::source::SourceCommand* request, ::zb::dcts::source::SourceCommandReply* response) {
  (void) context;
  (void) request;
  (void) response;
  return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
}

::grpc::Status SourceControlService::Service::SubscribeSourceMessage(::grpc::ServerContext* context, const ::zb::dcts::source::SubscribeRequest* request, ::grpc::ServerWriter< ::google::protobuf::Any>* writer) {
  (void) context;
  (void) request;
  (void) writer;
  return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
}


}  // namespace zb
}  // namespace dcts
}  // namespace source

