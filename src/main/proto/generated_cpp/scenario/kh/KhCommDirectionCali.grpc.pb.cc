// Generated by the gRPC C++ plugin.
// If you make any local change, they will be lost.
// source: scenario/kh/KhCommDirectionCali.proto

#include "scenario/kh/KhCommDirectionCali.pb.h"
#include "scenario/kh/KhCommDirectionCali.grpc.pb.h"

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
namespace commDirection {

static const char* CommDirectionCaliService_method_names[] = {
  "/zb.dcts.scenario.kh.commDirection.CommDirectionCaliService/StartTask",
  "/zb.dcts.scenario.kh.commDirection.CommDirectionCaliService/GetFixResult",
  "/zb.dcts.scenario.kh.commDirection.CommDirectionCaliService/StopTask",
  "/zb.dcts.scenario.kh.commDirection.CommDirectionCaliService/Change",
};

std::unique_ptr< CommDirectionCaliService::Stub> CommDirectionCaliService::NewStub(const std::shared_ptr< ::grpc::ChannelInterface>& channel, const ::grpc::StubOptions& options) {
  (void)options;
  std::unique_ptr< CommDirectionCaliService::Stub> stub(new CommDirectionCaliService::Stub(channel));
  return stub;
}

CommDirectionCaliService::Stub::Stub(const std::shared_ptr< ::grpc::ChannelInterface>& channel)
  : channel_(channel), rpcmethod_StartTask_(CommDirectionCaliService_method_names[0], ::grpc::internal::RpcMethod::NORMAL_RPC, channel)
  , rpcmethod_GetFixResult_(CommDirectionCaliService_method_names[1], ::grpc::internal::RpcMethod::SERVER_STREAMING, channel)
  , rpcmethod_StopTask_(CommDirectionCaliService_method_names[2], ::grpc::internal::RpcMethod::NORMAL_RPC, channel)
  , rpcmethod_Change_(CommDirectionCaliService_method_names[3], ::grpc::internal::RpcMethod::NORMAL_RPC, channel)
  {}

::grpc::Status CommDirectionCaliService::Stub::StartTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commDirection::CommDirectionCaliTaskRequest& request, ::zb::dcts::scenario::ScenarioReply* response) {
  return ::grpc::internal::BlockingUnaryCall(channel_.get(), rpcmethod_StartTask_, context, request, response);
}

void CommDirectionCaliService::Stub::experimental_async::StartTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commDirection::CommDirectionCaliTaskRequest* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_StartTask_, context, request, response, std::move(f));
}

void CommDirectionCaliService::Stub::experimental_async::StartTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_StartTask_, context, request, response, std::move(f));
}

void CommDirectionCaliService::Stub::experimental_async::StartTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commDirection::CommDirectionCaliTaskRequest* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_StartTask_, context, request, response, reactor);
}

void CommDirectionCaliService::Stub::experimental_async::StartTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_StartTask_, context, request, response, reactor);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* CommDirectionCaliService::Stub::AsyncStartTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commDirection::CommDirectionCaliTaskRequest& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::scenario::ScenarioReply>::Create(channel_.get(), cq, rpcmethod_StartTask_, context, request, true);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* CommDirectionCaliService::Stub::PrepareAsyncStartTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commDirection::CommDirectionCaliTaskRequest& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::scenario::ScenarioReply>::Create(channel_.get(), cq, rpcmethod_StartTask_, context, request, false);
}

::grpc::ClientReader< ::zb::dcts::scenario::kh::commDirection::CommDirectionResult>* CommDirectionCaliService::Stub::GetFixResultRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request) {
  return ::grpc_impl::internal::ClientReaderFactory< ::zb::dcts::scenario::kh::commDirection::CommDirectionResult>::Create(channel_.get(), rpcmethod_GetFixResult_, context, request);
}

void CommDirectionCaliService::Stub::experimental_async::GetFixResult(::grpc::ClientContext* context, ::zb::dcts::scenario::ScenarioTaskId* request, ::grpc::experimental::ClientReadReactor< ::zb::dcts::scenario::kh::commDirection::CommDirectionResult>* reactor) {
  ::grpc_impl::internal::ClientCallbackReaderFactory< ::zb::dcts::scenario::kh::commDirection::CommDirectionResult>::Create(stub_->channel_.get(), stub_->rpcmethod_GetFixResult_, context, request, reactor);
}

::grpc::ClientAsyncReader< ::zb::dcts::scenario::kh::commDirection::CommDirectionResult>* CommDirectionCaliService::Stub::AsyncGetFixResultRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq, void* tag) {
  return ::grpc_impl::internal::ClientAsyncReaderFactory< ::zb::dcts::scenario::kh::commDirection::CommDirectionResult>::Create(channel_.get(), cq, rpcmethod_GetFixResult_, context, request, true, tag);
}

::grpc::ClientAsyncReader< ::zb::dcts::scenario::kh::commDirection::CommDirectionResult>* CommDirectionCaliService::Stub::PrepareAsyncGetFixResultRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncReaderFactory< ::zb::dcts::scenario::kh::commDirection::CommDirectionResult>::Create(channel_.get(), cq, rpcmethod_GetFixResult_, context, request, false, nullptr);
}

::grpc::Status CommDirectionCaliService::Stub::StopTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::zb::dcts::scenario::ScenarioReply* response) {
  return ::grpc::internal::BlockingUnaryCall(channel_.get(), rpcmethod_StopTask_, context, request, response);
}

void CommDirectionCaliService::Stub::experimental_async::StopTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_StopTask_, context, request, response, std::move(f));
}

void CommDirectionCaliService::Stub::experimental_async::StopTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_StopTask_, context, request, response, std::move(f));
}

void CommDirectionCaliService::Stub::experimental_async::StopTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_StopTask_, context, request, response, reactor);
}

void CommDirectionCaliService::Stub::experimental_async::StopTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_StopTask_, context, request, response, reactor);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* CommDirectionCaliService::Stub::AsyncStopTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::scenario::ScenarioReply>::Create(channel_.get(), cq, rpcmethod_StopTask_, context, request, true);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* CommDirectionCaliService::Stub::PrepareAsyncStopTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::scenario::ScenarioReply>::Create(channel_.get(), cq, rpcmethod_StopTask_, context, request, false);
}

::grpc::Status CommDirectionCaliService::Stub::Change(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commDirection::CaliChangeRequest& request, ::zb::dcts::scenario::ScenarioReply* response) {
  return ::grpc::internal::BlockingUnaryCall(channel_.get(), rpcmethod_Change_, context, request, response);
}

void CommDirectionCaliService::Stub::experimental_async::Change(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commDirection::CaliChangeRequest* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_Change_, context, request, response, std::move(f));
}

void CommDirectionCaliService::Stub::experimental_async::Change(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)> f) {
  ::grpc_impl::internal::CallbackUnaryCall(stub_->channel_.get(), stub_->rpcmethod_Change_, context, request, response, std::move(f));
}

void CommDirectionCaliService::Stub::experimental_async::Change(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commDirection::CaliChangeRequest* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_Change_, context, request, response, reactor);
}

void CommDirectionCaliService::Stub::experimental_async::Change(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) {
  ::grpc_impl::internal::ClientCallbackUnaryFactory::Create(stub_->channel_.get(), stub_->rpcmethod_Change_, context, request, response, reactor);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* CommDirectionCaliService::Stub::AsyncChangeRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commDirection::CaliChangeRequest& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::scenario::ScenarioReply>::Create(channel_.get(), cq, rpcmethod_Change_, context, request, true);
}

::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* CommDirectionCaliService::Stub::PrepareAsyncChangeRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::kh::commDirection::CaliChangeRequest& request, ::grpc::CompletionQueue* cq) {
  return ::grpc_impl::internal::ClientAsyncResponseReaderFactory< ::zb::dcts::scenario::ScenarioReply>::Create(channel_.get(), cq, rpcmethod_Change_, context, request, false);
}

CommDirectionCaliService::Service::Service() {
  AddMethod(new ::grpc::internal::RpcServiceMethod(
      CommDirectionCaliService_method_names[0],
      ::grpc::internal::RpcMethod::NORMAL_RPC,
      new ::grpc::internal::RpcMethodHandler< CommDirectionCaliService::Service, ::zb::dcts::scenario::kh::commDirection::CommDirectionCaliTaskRequest, ::zb::dcts::scenario::ScenarioReply>(
          std::mem_fn(&CommDirectionCaliService::Service::StartTask), this)));
  AddMethod(new ::grpc::internal::RpcServiceMethod(
      CommDirectionCaliService_method_names[1],
      ::grpc::internal::RpcMethod::SERVER_STREAMING,
      new ::grpc::internal::ServerStreamingHandler< CommDirectionCaliService::Service, ::zb::dcts::scenario::ScenarioTaskId, ::zb::dcts::scenario::kh::commDirection::CommDirectionResult>(
          std::mem_fn(&CommDirectionCaliService::Service::GetFixResult), this)));
  AddMethod(new ::grpc::internal::RpcServiceMethod(
      CommDirectionCaliService_method_names[2],
      ::grpc::internal::RpcMethod::NORMAL_RPC,
      new ::grpc::internal::RpcMethodHandler< CommDirectionCaliService::Service, ::zb::dcts::scenario::ScenarioTaskId, ::zb::dcts::scenario::ScenarioReply>(
          std::mem_fn(&CommDirectionCaliService::Service::StopTask), this)));
  AddMethod(new ::grpc::internal::RpcServiceMethod(
      CommDirectionCaliService_method_names[3],
      ::grpc::internal::RpcMethod::NORMAL_RPC,
      new ::grpc::internal::RpcMethodHandler< CommDirectionCaliService::Service, ::zb::dcts::scenario::kh::commDirection::CaliChangeRequest, ::zb::dcts::scenario::ScenarioReply>(
          std::mem_fn(&CommDirectionCaliService::Service::Change), this)));
}

CommDirectionCaliService::Service::~Service() {
}

::grpc::Status CommDirectionCaliService::Service::StartTask(::grpc::ServerContext* context, const ::zb::dcts::scenario::kh::commDirection::CommDirectionCaliTaskRequest* request, ::zb::dcts::scenario::ScenarioReply* response) {
  (void) context;
  (void) request;
  (void) response;
  return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
}

::grpc::Status CommDirectionCaliService::Service::GetFixResult(::grpc::ServerContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::grpc::ServerWriter< ::zb::dcts::scenario::kh::commDirection::CommDirectionResult>* writer) {
  (void) context;
  (void) request;
  (void) writer;
  return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
}

::grpc::Status CommDirectionCaliService::Service::StopTask(::grpc::ServerContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response) {
  (void) context;
  (void) request;
  (void) response;
  return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
}

::grpc::Status CommDirectionCaliService::Service::Change(::grpc::ServerContext* context, const ::zb::dcts::scenario::kh::commDirection::CaliChangeRequest* request, ::zb::dcts::scenario::ScenarioReply* response) {
  (void) context;
  (void) request;
  (void) response;
  return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
}


}  // namespace zb
}  // namespace dcts
}  // namespace scenario
}  // namespace kh
}  // namespace commDirection

