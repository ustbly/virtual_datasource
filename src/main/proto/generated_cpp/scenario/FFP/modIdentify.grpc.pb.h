// Generated by the gRPC C++ plugin.
// If you make any local change, they will be lost.
// source: scenario/FFP/modIdentify.proto
#ifndef GRPC_scenario_2fFFP_2fmodIdentify_2eproto__INCLUDED
#define GRPC_scenario_2fFFP_2fmodIdentify_2eproto__INCLUDED

#include "scenario/FFP/modIdentify.pb.h"

#include <functional>
#include <grpc/impl/codegen/port_platform.h>
#include <grpcpp/impl/codegen/async_generic_service.h>
#include <grpcpp/impl/codegen/async_stream.h>
#include <grpcpp/impl/codegen/async_unary_call.h>
#include <grpcpp/impl/codegen/client_callback.h>
#include <grpcpp/impl/codegen/client_context.h>
#include <grpcpp/impl/codegen/completion_queue.h>
#include <grpcpp/impl/codegen/message_allocator.h>
#include <grpcpp/impl/codegen/method_handler.h>
#include <grpcpp/impl/codegen/proto_utils.h>
#include <grpcpp/impl/codegen/rpc_method.h>
#include <grpcpp/impl/codegen/server_callback.h>
#include <grpcpp/impl/codegen/server_callback_handlers.h>
#include <grpcpp/impl/codegen/server_context.h>
#include <grpcpp/impl/codegen/service_type.h>
#include <grpcpp/impl/codegen/status.h>
#include <grpcpp/impl/codegen/stub_options.h>
#include <grpcpp/impl/codegen/sync_stream.h>

namespace zb {
namespace dcts {
namespace scenario {
namespace FFP {

class ModulationIdentifyService final {
 public:
  static constexpr char const* service_full_name() {
    return "zb.dcts.scenario.FFP.ModulationIdentifyService";
  }
  class StubInterface {
   public:
    virtual ~StubInterface() {}
    virtual ::grpc::Status StartModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest& request, ::zb::dcts::scenario::ScenarioReply* response) = 0;
    std::unique_ptr< ::grpc::ClientAsyncResponseReaderInterface< ::zb::dcts::scenario::ScenarioReply>> AsyncStartModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest& request, ::grpc::CompletionQueue* cq) {
      return std::unique_ptr< ::grpc::ClientAsyncResponseReaderInterface< ::zb::dcts::scenario::ScenarioReply>>(AsyncStartModIdentifyTaskRaw(context, request, cq));
    }
    std::unique_ptr< ::grpc::ClientAsyncResponseReaderInterface< ::zb::dcts::scenario::ScenarioReply>> PrepareAsyncStartModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest& request, ::grpc::CompletionQueue* cq) {
      return std::unique_ptr< ::grpc::ClientAsyncResponseReaderInterface< ::zb::dcts::scenario::ScenarioReply>>(PrepareAsyncStartModIdentifyTaskRaw(context, request, cq));
    }
    // rpc GetModIdentifyResult(ScenarioTaskId) returns (ModIdentifyResult) {}
    // rpc GetModIdentifySpectrum(ScenarioTaskId) returns (stream ModIdentifyResult) {}
    virtual ::grpc::Status StopModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::zb::dcts::scenario::ScenarioReply* response) = 0;
    std::unique_ptr< ::grpc::ClientAsyncResponseReaderInterface< ::zb::dcts::scenario::ScenarioReply>> AsyncStopModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) {
      return std::unique_ptr< ::grpc::ClientAsyncResponseReaderInterface< ::zb::dcts::scenario::ScenarioReply>>(AsyncStopModIdentifyTaskRaw(context, request, cq));
    }
    std::unique_ptr< ::grpc::ClientAsyncResponseReaderInterface< ::zb::dcts::scenario::ScenarioReply>> PrepareAsyncStopModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) {
      return std::unique_ptr< ::grpc::ClientAsyncResponseReaderInterface< ::zb::dcts::scenario::ScenarioReply>>(PrepareAsyncStopModIdentifyTaskRaw(context, request, cq));
    }
    class experimental_async_interface {
     public:
      virtual ~experimental_async_interface() {}
      virtual void StartModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)>) = 0;
      virtual void StartModIdentifyTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)>) = 0;
      #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      virtual void StartModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::ClientUnaryReactor* reactor) = 0;
      #else
      virtual void StartModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) = 0;
      #endif
      #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      virtual void StartModIdentifyTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::ClientUnaryReactor* reactor) = 0;
      #else
      virtual void StartModIdentifyTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) = 0;
      #endif
      // rpc GetModIdentifyResult(ScenarioTaskId) returns (ModIdentifyResult) {}
      // rpc GetModIdentifySpectrum(ScenarioTaskId) returns (stream ModIdentifyResult) {}
      virtual void StopModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)>) = 0;
      virtual void StopModIdentifyTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)>) = 0;
      #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      virtual void StopModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::ClientUnaryReactor* reactor) = 0;
      #else
      virtual void StopModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) = 0;
      #endif
      #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      virtual void StopModIdentifyTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::ClientUnaryReactor* reactor) = 0;
      #else
      virtual void StopModIdentifyTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) = 0;
      #endif
    };
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
    typedef class experimental_async_interface async_interface;
    #endif
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
    async_interface* async() { return experimental_async(); }
    #endif
    virtual class experimental_async_interface* experimental_async() { return nullptr; }
  private:
    virtual ::grpc::ClientAsyncResponseReaderInterface< ::zb::dcts::scenario::ScenarioReply>* AsyncStartModIdentifyTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest& request, ::grpc::CompletionQueue* cq) = 0;
    virtual ::grpc::ClientAsyncResponseReaderInterface< ::zb::dcts::scenario::ScenarioReply>* PrepareAsyncStartModIdentifyTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest& request, ::grpc::CompletionQueue* cq) = 0;
    virtual ::grpc::ClientAsyncResponseReaderInterface< ::zb::dcts::scenario::ScenarioReply>* AsyncStopModIdentifyTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) = 0;
    virtual ::grpc::ClientAsyncResponseReaderInterface< ::zb::dcts::scenario::ScenarioReply>* PrepareAsyncStopModIdentifyTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) = 0;
  };
  class Stub final : public StubInterface {
   public:
    Stub(const std::shared_ptr< ::grpc::ChannelInterface>& channel);
    ::grpc::Status StartModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest& request, ::zb::dcts::scenario::ScenarioReply* response) override;
    std::unique_ptr< ::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>> AsyncStartModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest& request, ::grpc::CompletionQueue* cq) {
      return std::unique_ptr< ::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>>(AsyncStartModIdentifyTaskRaw(context, request, cq));
    }
    std::unique_ptr< ::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>> PrepareAsyncStartModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest& request, ::grpc::CompletionQueue* cq) {
      return std::unique_ptr< ::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>>(PrepareAsyncStartModIdentifyTaskRaw(context, request, cq));
    }
    ::grpc::Status StopModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::zb::dcts::scenario::ScenarioReply* response) override;
    std::unique_ptr< ::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>> AsyncStopModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) {
      return std::unique_ptr< ::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>>(AsyncStopModIdentifyTaskRaw(context, request, cq));
    }
    std::unique_ptr< ::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>> PrepareAsyncStopModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) {
      return std::unique_ptr< ::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>>(PrepareAsyncStopModIdentifyTaskRaw(context, request, cq));
    }
    class experimental_async final :
      public StubInterface::experimental_async_interface {
     public:
      void StartModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)>) override;
      void StartModIdentifyTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)>) override;
      #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      void StartModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::ClientUnaryReactor* reactor) override;
      #else
      void StartModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) override;
      #endif
      #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      void StartModIdentifyTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::ClientUnaryReactor* reactor) override;
      #else
      void StartModIdentifyTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) override;
      #endif
      void StopModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)>) override;
      void StopModIdentifyTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, std::function<void(::grpc::Status)>) override;
      #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      void StopModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::ClientUnaryReactor* reactor) override;
      #else
      void StopModIdentifyTask(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) override;
      #endif
      #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      void StopModIdentifyTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::ClientUnaryReactor* reactor) override;
      #else
      void StopModIdentifyTask(::grpc::ClientContext* context, const ::grpc::ByteBuffer* request, ::zb::dcts::scenario::ScenarioReply* response, ::grpc::experimental::ClientUnaryReactor* reactor) override;
      #endif
     private:
      friend class Stub;
      explicit experimental_async(Stub* stub): stub_(stub) { }
      Stub* stub() { return stub_; }
      Stub* stub_;
    };
    class experimental_async_interface* experimental_async() override { return &async_stub_; }

   private:
    std::shared_ptr< ::grpc::ChannelInterface> channel_;
    class experimental_async async_stub_{this};
    ::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* AsyncStartModIdentifyTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest& request, ::grpc::CompletionQueue* cq) override;
    ::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* PrepareAsyncStartModIdentifyTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest& request, ::grpc::CompletionQueue* cq) override;
    ::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* AsyncStopModIdentifyTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) override;
    ::grpc::ClientAsyncResponseReader< ::zb::dcts::scenario::ScenarioReply>* PrepareAsyncStopModIdentifyTaskRaw(::grpc::ClientContext* context, const ::zb::dcts::scenario::ScenarioTaskId& request, ::grpc::CompletionQueue* cq) override;
    const ::grpc::internal::RpcMethod rpcmethod_StartModIdentifyTask_;
    const ::grpc::internal::RpcMethod rpcmethod_StopModIdentifyTask_;
  };
  static std::unique_ptr<Stub> NewStub(const std::shared_ptr< ::grpc::ChannelInterface>& channel, const ::grpc::StubOptions& options = ::grpc::StubOptions());

  class Service : public ::grpc::Service {
   public:
    Service();
    virtual ~Service();
    virtual ::grpc::Status StartModIdentifyTask(::grpc::ServerContext* context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* request, ::zb::dcts::scenario::ScenarioReply* response);
    // rpc GetModIdentifyResult(ScenarioTaskId) returns (ModIdentifyResult) {}
    // rpc GetModIdentifySpectrum(ScenarioTaskId) returns (stream ModIdentifyResult) {}
    virtual ::grpc::Status StopModIdentifyTask(::grpc::ServerContext* context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response);
  };
  template <class BaseClass>
  class WithAsyncMethod_StartModIdentifyTask : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    WithAsyncMethod_StartModIdentifyTask() {
      ::grpc::Service::MarkMethodAsync(0);
    }
    ~WithAsyncMethod_StartModIdentifyTask() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status StartModIdentifyTask(::grpc::ServerContext* /*context*/, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    void RequestStartModIdentifyTask(::grpc::ServerContext* context, ::zb::dcts::scenario::FFP::ModIdentifyRequest* request, ::grpc::ServerAsyncResponseWriter< ::zb::dcts::scenario::ScenarioReply>* response, ::grpc::CompletionQueue* new_call_cq, ::grpc::ServerCompletionQueue* notification_cq, void *tag) {
      ::grpc::Service::RequestAsyncUnary(0, context, request, response, new_call_cq, notification_cq, tag);
    }
  };
  template <class BaseClass>
  class WithAsyncMethod_StopModIdentifyTask : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    WithAsyncMethod_StopModIdentifyTask() {
      ::grpc::Service::MarkMethodAsync(1);
    }
    ~WithAsyncMethod_StopModIdentifyTask() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status StopModIdentifyTask(::grpc::ServerContext* /*context*/, const ::zb::dcts::scenario::ScenarioTaskId* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    void RequestStopModIdentifyTask(::grpc::ServerContext* context, ::zb::dcts::scenario::ScenarioTaskId* request, ::grpc::ServerAsyncResponseWriter< ::zb::dcts::scenario::ScenarioReply>* response, ::grpc::CompletionQueue* new_call_cq, ::grpc::ServerCompletionQueue* notification_cq, void *tag) {
      ::grpc::Service::RequestAsyncUnary(1, context, request, response, new_call_cq, notification_cq, tag);
    }
  };
  typedef WithAsyncMethod_StartModIdentifyTask<WithAsyncMethod_StopModIdentifyTask<Service > > AsyncService;
  template <class BaseClass>
  class ExperimentalWithCallbackMethod_StartModIdentifyTask : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    ExperimentalWithCallbackMethod_StartModIdentifyTask() {
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      ::grpc::Service::
    #else
      ::grpc::Service::experimental().
    #endif
        MarkMethodCallback(0,
          new ::grpc_impl::internal::CallbackUnaryHandler< ::zb::dcts::scenario::FFP::ModIdentifyRequest, ::zb::dcts::scenario::ScenarioReply>(
            [this](
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
                   ::grpc::CallbackServerContext*
    #else
                   ::grpc::experimental::CallbackServerContext*
    #endif
                     context, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* request, ::zb::dcts::scenario::ScenarioReply* response) { return this->StartModIdentifyTask(context, request, response); }));}
    void SetMessageAllocatorFor_StartModIdentifyTask(
        ::grpc::experimental::MessageAllocator< ::zb::dcts::scenario::FFP::ModIdentifyRequest, ::zb::dcts::scenario::ScenarioReply>* allocator) {
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      ::grpc::internal::MethodHandler* const handler = ::grpc::Service::GetHandler(0);
    #else
      ::grpc::internal::MethodHandler* const handler = ::grpc::Service::experimental().GetHandler(0);
    #endif
      static_cast<::grpc_impl::internal::CallbackUnaryHandler< ::zb::dcts::scenario::FFP::ModIdentifyRequest, ::zb::dcts::scenario::ScenarioReply>*>(handler)
              ->SetMessageAllocator(allocator);
    }
    ~ExperimentalWithCallbackMethod_StartModIdentifyTask() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status StartModIdentifyTask(::grpc::ServerContext* /*context*/, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
    virtual ::grpc::ServerUnaryReactor* StartModIdentifyTask(
      ::grpc::CallbackServerContext* /*context*/, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/)
    #else
    virtual ::grpc::experimental::ServerUnaryReactor* StartModIdentifyTask(
      ::grpc::experimental::CallbackServerContext* /*context*/, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/)
    #endif
      { return nullptr; }
  };
  template <class BaseClass>
  class ExperimentalWithCallbackMethod_StopModIdentifyTask : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    ExperimentalWithCallbackMethod_StopModIdentifyTask() {
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      ::grpc::Service::
    #else
      ::grpc::Service::experimental().
    #endif
        MarkMethodCallback(1,
          new ::grpc_impl::internal::CallbackUnaryHandler< ::zb::dcts::scenario::ScenarioTaskId, ::zb::dcts::scenario::ScenarioReply>(
            [this](
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
                   ::grpc::CallbackServerContext*
    #else
                   ::grpc::experimental::CallbackServerContext*
    #endif
                     context, const ::zb::dcts::scenario::ScenarioTaskId* request, ::zb::dcts::scenario::ScenarioReply* response) { return this->StopModIdentifyTask(context, request, response); }));}
    void SetMessageAllocatorFor_StopModIdentifyTask(
        ::grpc::experimental::MessageAllocator< ::zb::dcts::scenario::ScenarioTaskId, ::zb::dcts::scenario::ScenarioReply>* allocator) {
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      ::grpc::internal::MethodHandler* const handler = ::grpc::Service::GetHandler(1);
    #else
      ::grpc::internal::MethodHandler* const handler = ::grpc::Service::experimental().GetHandler(1);
    #endif
      static_cast<::grpc_impl::internal::CallbackUnaryHandler< ::zb::dcts::scenario::ScenarioTaskId, ::zb::dcts::scenario::ScenarioReply>*>(handler)
              ->SetMessageAllocator(allocator);
    }
    ~ExperimentalWithCallbackMethod_StopModIdentifyTask() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status StopModIdentifyTask(::grpc::ServerContext* /*context*/, const ::zb::dcts::scenario::ScenarioTaskId* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
    virtual ::grpc::ServerUnaryReactor* StopModIdentifyTask(
      ::grpc::CallbackServerContext* /*context*/, const ::zb::dcts::scenario::ScenarioTaskId* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/)
    #else
    virtual ::grpc::experimental::ServerUnaryReactor* StopModIdentifyTask(
      ::grpc::experimental::CallbackServerContext* /*context*/, const ::zb::dcts::scenario::ScenarioTaskId* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/)
    #endif
      { return nullptr; }
  };
  #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
  typedef ExperimentalWithCallbackMethod_StartModIdentifyTask<ExperimentalWithCallbackMethod_StopModIdentifyTask<Service > > CallbackService;
  #endif

  typedef ExperimentalWithCallbackMethod_StartModIdentifyTask<ExperimentalWithCallbackMethod_StopModIdentifyTask<Service > > ExperimentalCallbackService;
  template <class BaseClass>
  class WithGenericMethod_StartModIdentifyTask : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    WithGenericMethod_StartModIdentifyTask() {
      ::grpc::Service::MarkMethodGeneric(0);
    }
    ~WithGenericMethod_StartModIdentifyTask() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status StartModIdentifyTask(::grpc::ServerContext* /*context*/, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
  };
  template <class BaseClass>
  class WithGenericMethod_StopModIdentifyTask : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    WithGenericMethod_StopModIdentifyTask() {
      ::grpc::Service::MarkMethodGeneric(1);
    }
    ~WithGenericMethod_StopModIdentifyTask() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status StopModIdentifyTask(::grpc::ServerContext* /*context*/, const ::zb::dcts::scenario::ScenarioTaskId* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
  };
  template <class BaseClass>
  class WithRawMethod_StartModIdentifyTask : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    WithRawMethod_StartModIdentifyTask() {
      ::grpc::Service::MarkMethodRaw(0);
    }
    ~WithRawMethod_StartModIdentifyTask() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status StartModIdentifyTask(::grpc::ServerContext* /*context*/, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    void RequestStartModIdentifyTask(::grpc::ServerContext* context, ::grpc::ByteBuffer* request, ::grpc::ServerAsyncResponseWriter< ::grpc::ByteBuffer>* response, ::grpc::CompletionQueue* new_call_cq, ::grpc::ServerCompletionQueue* notification_cq, void *tag) {
      ::grpc::Service::RequestAsyncUnary(0, context, request, response, new_call_cq, notification_cq, tag);
    }
  };
  template <class BaseClass>
  class WithRawMethod_StopModIdentifyTask : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    WithRawMethod_StopModIdentifyTask() {
      ::grpc::Service::MarkMethodRaw(1);
    }
    ~WithRawMethod_StopModIdentifyTask() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status StopModIdentifyTask(::grpc::ServerContext* /*context*/, const ::zb::dcts::scenario::ScenarioTaskId* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    void RequestStopModIdentifyTask(::grpc::ServerContext* context, ::grpc::ByteBuffer* request, ::grpc::ServerAsyncResponseWriter< ::grpc::ByteBuffer>* response, ::grpc::CompletionQueue* new_call_cq, ::grpc::ServerCompletionQueue* notification_cq, void *tag) {
      ::grpc::Service::RequestAsyncUnary(1, context, request, response, new_call_cq, notification_cq, tag);
    }
  };
  template <class BaseClass>
  class ExperimentalWithRawCallbackMethod_StartModIdentifyTask : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    ExperimentalWithRawCallbackMethod_StartModIdentifyTask() {
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      ::grpc::Service::
    #else
      ::grpc::Service::experimental().
    #endif
        MarkMethodRawCallback(0,
          new ::grpc_impl::internal::CallbackUnaryHandler< ::grpc::ByteBuffer, ::grpc::ByteBuffer>(
            [this](
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
                   ::grpc::CallbackServerContext*
    #else
                   ::grpc::experimental::CallbackServerContext*
    #endif
                     context, const ::grpc::ByteBuffer* request, ::grpc::ByteBuffer* response) { return this->StartModIdentifyTask(context, request, response); }));
    }
    ~ExperimentalWithRawCallbackMethod_StartModIdentifyTask() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status StartModIdentifyTask(::grpc::ServerContext* /*context*/, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
    virtual ::grpc::ServerUnaryReactor* StartModIdentifyTask(
      ::grpc::CallbackServerContext* /*context*/, const ::grpc::ByteBuffer* /*request*/, ::grpc::ByteBuffer* /*response*/)
    #else
    virtual ::grpc::experimental::ServerUnaryReactor* StartModIdentifyTask(
      ::grpc::experimental::CallbackServerContext* /*context*/, const ::grpc::ByteBuffer* /*request*/, ::grpc::ByteBuffer* /*response*/)
    #endif
      { return nullptr; }
  };
  template <class BaseClass>
  class ExperimentalWithRawCallbackMethod_StopModIdentifyTask : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    ExperimentalWithRawCallbackMethod_StopModIdentifyTask() {
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
      ::grpc::Service::
    #else
      ::grpc::Service::experimental().
    #endif
        MarkMethodRawCallback(1,
          new ::grpc_impl::internal::CallbackUnaryHandler< ::grpc::ByteBuffer, ::grpc::ByteBuffer>(
            [this](
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
                   ::grpc::CallbackServerContext*
    #else
                   ::grpc::experimental::CallbackServerContext*
    #endif
                     context, const ::grpc::ByteBuffer* request, ::grpc::ByteBuffer* response) { return this->StopModIdentifyTask(context, request, response); }));
    }
    ~ExperimentalWithRawCallbackMethod_StopModIdentifyTask() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable synchronous version of this method
    ::grpc::Status StopModIdentifyTask(::grpc::ServerContext* /*context*/, const ::zb::dcts::scenario::ScenarioTaskId* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    #ifdef GRPC_CALLBACK_API_NONEXPERIMENTAL
    virtual ::grpc::ServerUnaryReactor* StopModIdentifyTask(
      ::grpc::CallbackServerContext* /*context*/, const ::grpc::ByteBuffer* /*request*/, ::grpc::ByteBuffer* /*response*/)
    #else
    virtual ::grpc::experimental::ServerUnaryReactor* StopModIdentifyTask(
      ::grpc::experimental::CallbackServerContext* /*context*/, const ::grpc::ByteBuffer* /*request*/, ::grpc::ByteBuffer* /*response*/)
    #endif
      { return nullptr; }
  };
  template <class BaseClass>
  class WithStreamedUnaryMethod_StartModIdentifyTask : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    WithStreamedUnaryMethod_StartModIdentifyTask() {
      ::grpc::Service::MarkMethodStreamed(0,
        new ::grpc::internal::StreamedUnaryHandler< ::zb::dcts::scenario::FFP::ModIdentifyRequest, ::zb::dcts::scenario::ScenarioReply>(std::bind(&WithStreamedUnaryMethod_StartModIdentifyTask<BaseClass>::StreamedStartModIdentifyTask, this, std::placeholders::_1, std::placeholders::_2)));
    }
    ~WithStreamedUnaryMethod_StartModIdentifyTask() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable regular version of this method
    ::grpc::Status StartModIdentifyTask(::grpc::ServerContext* /*context*/, const ::zb::dcts::scenario::FFP::ModIdentifyRequest* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    // replace default version of method with streamed unary
    virtual ::grpc::Status StreamedStartModIdentifyTask(::grpc::ServerContext* context, ::grpc::ServerUnaryStreamer< ::zb::dcts::scenario::FFP::ModIdentifyRequest,::zb::dcts::scenario::ScenarioReply>* server_unary_streamer) = 0;
  };
  template <class BaseClass>
  class WithStreamedUnaryMethod_StopModIdentifyTask : public BaseClass {
   private:
    void BaseClassMustBeDerivedFromService(const Service* /*service*/) {}
   public:
    WithStreamedUnaryMethod_StopModIdentifyTask() {
      ::grpc::Service::MarkMethodStreamed(1,
        new ::grpc::internal::StreamedUnaryHandler< ::zb::dcts::scenario::ScenarioTaskId, ::zb::dcts::scenario::ScenarioReply>(std::bind(&WithStreamedUnaryMethod_StopModIdentifyTask<BaseClass>::StreamedStopModIdentifyTask, this, std::placeholders::_1, std::placeholders::_2)));
    }
    ~WithStreamedUnaryMethod_StopModIdentifyTask() override {
      BaseClassMustBeDerivedFromService(this);
    }
    // disable regular version of this method
    ::grpc::Status StopModIdentifyTask(::grpc::ServerContext* /*context*/, const ::zb::dcts::scenario::ScenarioTaskId* /*request*/, ::zb::dcts::scenario::ScenarioReply* /*response*/) override {
      abort();
      return ::grpc::Status(::grpc::StatusCode::UNIMPLEMENTED, "");
    }
    // replace default version of method with streamed unary
    virtual ::grpc::Status StreamedStopModIdentifyTask(::grpc::ServerContext* context, ::grpc::ServerUnaryStreamer< ::zb::dcts::scenario::ScenarioTaskId,::zb::dcts::scenario::ScenarioReply>* server_unary_streamer) = 0;
  };
  typedef WithStreamedUnaryMethod_StartModIdentifyTask<WithStreamedUnaryMethod_StopModIdentifyTask<Service > > StreamedUnaryService;
  typedef Service SplitStreamedService;
  typedef WithStreamedUnaryMethod_StartModIdentifyTask<WithStreamedUnaryMethod_StopModIdentifyTask<Service > > StreamedService;
};

}  // namespace FFP
}  // namespace scenario
}  // namespace dcts
}  // namespace zb


#endif  // GRPC_scenario_2fFFP_2fmodIdentify_2eproto__INCLUDED
