// Generated by the gRPC C++ plugin.
// If you make any local change, they will be lost.
// source: scenario/kh/KhCommChannelCali.proto

#include "scenario/kh/KhCommChannelCali.pb.h"
#include "scenario/kh/KhCommChannelCali.grpc.pb.h"

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
namespace scenario {
namespace kh {
namespace commSpectrum {

static const char* CommChannelCaliService_method_names[] = {
  "/zb.dcts.scenario.kh.commSpectrum.CommChannelCaliService/StartTask",
  "/zb.dcts.scenario.kh.commSpectrum.CommChannelCaliService/GetResult",
  "/zb.dcts.scenario.kh.commSpectrum.CommChannelCaliService/StopTask",
  "/zb.dcts.scenario.kh.commSpectrum.CommChannelCaliService/Change",
};

std::unique_ptr< CommChannelCaliService::Stub> CommChannelCaliService::NewStub(const std::shared_ptr< ::grpc::ChannelInterface>& channel, const ::grpc::StubOptions& options) {
  (void)options;
  std::unique_ptr< CommChannelCaliService::Stub> stub(new CommChannelCaliService::Stub(channel));
  return stub;
}

CommChannelCaliService::Stub::Stub(const std::shared_ptr< ::grpc::ChannelInterface>& channel)
  : channel_(channel), rpcmethod_StartTask_(CommChannelCaliService_method_names[0], ::grpc::internal::RpcMethod::NORMAL_RPC, channel)
  , rpcmethod_GetResult_(CommChannelCaliService_method_names[1], ::grpc::internal::RpcMethod::SERVER_STREAMING, channel)
  , rpcmethod_StopTask_(CommChannelCaliService_method_names[2], ::grpc::internal::RpcMethod::NORMAL_RPC, channel)
  , rpcmethod_Change_(CommChannelCaliService_method_names[3], ::grpc::internal::RpcMethod::NORMAL_RPC, channel)
  {}

::grpc::Status CommChannelCaliService::Stub::StartTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commSpectrum::CommChannelCaliTaskRequest& request, ::zb::dcts::scenario::ScenarioReply* response) {
  return ::grpc::internal::BlockingUnaryCall(channel_.get(), rpcmethod_StartTask_, context, request, response);
}

void CommChannelCaliService::Stub::experimental_async::StartTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commSpectrum::CommChannelCaliTaskRequest* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_StartTask_, context, request, response, std::move(f));
}

void CommChannelCaliService::Stub::experimental_async::StartTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_StartTask_, context, request, response, std::move(f));
}

void CommChannelCaliService::Stub::experimental_async::StartTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commSpectrum::CommChannelCaliTaskRequest* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_StartTask_, context, request, response, reactor);
}

void CommChannelCaliService::Stub::experimental_async::StartTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_StartTask_, context, request, response, reactor);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* CommChannelCaliService::Stub::AsyncStartTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commSpectrum::CommChannelCaliTaskRequest& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::scenario::ScenarioReply>::Create(channel_.get(), cq, rpcmethod_StartTask_, context, request, true);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* CommChannelCaliService::Stub::PrepareAsyncStartTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commSpectrum::CommChannelCaliTaskRequest& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::scenario::ScenarioReply>::Create(channel_.get(), cq, rpcmethod_StartTask_, context, request, false);
}

::grpc::ClientReader< ::zb::dcts::scenario::kh::commSpectrum::SpectrumAcqResult>* CommChannelCaliService::Stub::GetResultRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request) {
  return ::grpc_impl::internal::ClientReaderFactory< ::zb::dcts::scenario::kh::commSpectrum::SpectrumAcqResult>::Create(channel_.get(), rpcmethod_GetResult_, context, request);
}

void CommChannelCaliService::Stub::experimental_async::GetResult(::grpc::ClientContext* context, ::zb::dcts::scenario::ScenarioTaskId* request, ::grpc::experimental::ClientReadReactor< ::zb::dcts::scenario::kh::commSpectrum::SpectrumAcqResult>* reactor) {
  ::grpc_impl::internal::ClientCallbackReaderFactory< ::zb::dcts::scenario::kh::commSpectrum::SpectrumAcqResult>::Create(stub_->channel_.get(), stub_->rpcmethod_GetResult_, context, request, reactor);
}

::grpc::ClientAsyncReader< ::zb::dcts::scenario::kh::commSpectrum::SpectrumAcqResult>* CommChannelCaliService::Stub::AsyncGetResultRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq, void* tag) {
  return ::grpc_impl::internal::ClientAsyncReaderFactory< ::zb::dcts::scenario::kh::commSpectrum::SpectrumAcqResult>::Create(channel_.get(), cq, rpcmethod_GetResult_, context, request, true, tag);
}

::grpc::ClientAsyncReader< ::zb::dcts::scenario::kh::commSpectrum::SpectrumAcqResult>* CommChannelCaliService::Stub::PrepareAsyncGetResultRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncReaderFactory< ::zb::dcts::scenario::kh::commSpectrum::SpectrumAcqResult>::Create(channel_.get(), cq, rpcmethod_GetResult_, context, request, false, nullptr);
}

::grpc::Status CommChannelCaliService::Stub::StopTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::zb::dcts::scenario::ScenarioReply* response) {
  return ::grpc::internal::BlockingUnaryCall(channel_.get(), rpcmethod_StopTask_, context, request, response);
}

void CommChannelCaliService::Stub::experimental_async::StopTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_StopTask_, context, request, response, std::move(f));
}

void CommChannelCaliService::Stub::experimental_async::StopTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_StopTask_, context, request, response, std::move(f));
}

void CommChannelCaliService::Stub::experimental_async::StopTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_StopTask_, context, request, response, reactor);
}

void CommChannelCaliService::Stub::experimental_async::StopTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_StopTask_, context, request, response, reactor);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* CommChannelCaliService::Stub::AsyncStopTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::scenario::ScenarioReply>::Create(channel_.get(), cq, rpcmethod_StopTask_, context, request, true);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* CommChannelCaliService::Stub::PrepareAsyncStopTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::scenario::ScenarioReply>::Create(channel_.get(), cq, rpcmethod_StopTask_, context, request, false);
}

::grpc::Status CommChannelCaliService::Stub::Change(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commSpectrum::ChangeRequest& request, ::zb::dcts::scenario::ScenarioReply* response) {
  return ::grpc::internal::BlockingUnaryCall(channel_.get(), rpcmethod_Change_, context, request, response);
}

void CommChannelCaliService::Stub::experimental_async::Change(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commSpectrum::ChangeRequest* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_Change_, context, request, response, std::move(f));
}

void CommChannelCaliService::Stub::experimental_async::Change(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_Change_, context, request, response, std::move(f));
}

void CommChannelCaliService::Stub::experimental_async::Change(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commSpectrum::ChangeRequest* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_Change_, context, request, response, reactor);
}

void CommChannelCaliService::Stub::experimental_async::Change(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_Change_, context, request, response, reactor);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* CommChannelCaliService::Stub::AsyncChangeRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commSpectrum::ChangeRequest& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::scenario::ScenarioReply>::Create(channel_.get(), cq, rpcmethod_Change_, context, request, true);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* CommChannelCaliService::Stub::PrepareAsyncChangeRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commSpectrum::ChangeRequest& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::scenario::ScenarioReply>::Create(channel_.get(), cq, rpcmethod_Change_, context, request, false);
}

CommChannelCaliService::Service::Service() {
  AddMethod(new ::grpc::internal::RpcServiceMethod(
      CommChannelCaliService_method_names[0],
      ::grpc::internal::RpcMethod::NORMAL_RPC,
      new ::grpc::internal::RpcMethodHandler< CommChannelCaliService::Service, ::zb::dcts::scenario::kh::commSpectrum::CommChannelCaliTaskRequest, ::zb::dcts::scenario::ScenarioReply>(
          std::mem_fn(&CommChannelCaliService::Service::StartTask), this)));
  AddMethod(new ::grpc::internal::RpcServiceMethod(
      CommChannelCaliService_method_names[1],
      ::grpc::internal::RpcMethod::SERVER_STREAMING,
      new ::grpc::internal::ServerStreamingHandler< CommChannelCaliService::Service, ::zb::dcts::scenario::ScenarioTaskId, ::zb::dcts::scenario::kh::commSpectrum::SpectrumAcqResult>(
          std::mem_fn(&CommChannelCaliService::Service::GetResult), this)));
  AddMethod(new ::grpc::internal::RpcServiceMethod(
      CommChannelCaliService_method_names[2],
      ::grpc::internal::RpcMethod::NORMAL_RPC,
      new ::grpc::internal::RpcMethodHandler< CommChannelCaliService::Service, ::zb::dcts::scenario::ScenarioTaskId, ::zb::dcts::scenario::ScenarioReply>(
          std::mem_fn(&CommChannelCaliService::Service::StopTask), this)));
  AddMethod(new ::grpc::internal::RpcServiceMethod(
      CommChannelCaliService_method_names[3],
      ::grpc::internal::RpcMethod::NORMAL_RPC,
      new ::grpc::internal::RpcMethodHandler< CommChannelCaliService::Service, ::zb::dcts::scenario::kh::commSpectrum::ChangeRequest, ::zb::dcts::scenario::ScenarioReply>(
          std::mem_fn(&CommChannelCaliService::Service::Change), this)));
}

CommChannelCaliService::Service::~Service() {
}

::grpc::Status CommChannelCaliService::Service::StartTask(::grpc::ServerContext* context, const ::zb::dcts::scenario::kh::commSpectrum::CommChannelCaliTaskRequest* request, ::zb::dcts::scenario::ScenarioReply* response) {
  (void) context;
  (void) request;
  (void) response;
  return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
}

::grpc::Status CommChannelCaliService::Service::GetResult(::grpc::ServerContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::grpc::ServerWriter< ::zb::dcts::scenario::kh::commSpectrum::SpectrumAcqResult>* writer) {
  (void) context;
  (void) request;
  (void) writer;
  return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
}

::grpc::Status CommChannelCaliService::Service::StopTask(::grpc::ServerContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response) {
  (void) context;
  (void) request;
  (void) response;
  return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
}

::grpc::Status CommChannelCaliService::Service::Change(::grpc::ServerContext* context, const ::zb::dcts::scenario::kh::commSpectrum::ChangeRequest* request, ::zb::dcts::scenario::ScenarioReply* response) {
  (void) context;
  (void) request;
  (void) response;
  return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
}


}  // namespace zb
}  // namespace dcts
}  // namespace scenario
}  // namespace kh
}  // namespace commSpectrum

