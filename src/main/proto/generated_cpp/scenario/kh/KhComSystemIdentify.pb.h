// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: scenario/kh/KhComSystemIdentify.proto

#ifndef GOOGLE_PROTOBUF_INCLUDED_scenario_2fkh_2fKhComSystemIdentify_2eproto
#define GOOGLE_PROTOBUF_INCLUDED_scenario_2fkh_2fKhComSystemIdentify_2eproto

#include <limits>
#include <string>

#include <google/protobuf/port_def.inc>
#if PROTOBUF_VERSION < 3012000
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers. Please update
#error your headers.
#endif
#if 3012000 < PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers. Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/port_undef.inc>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/arena.h>
#include <google/protobuf/arenastring.h>
#include <google/protobuf/generated_message_table_driven.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/inlined_string_field.h>
#include <google/protobuf/metadata_lite.h>
#include <google/protobuf/generated_message_reflection.h>
#include <google/protobuf/message.h>
#include <google/protobuf/repeated_field.h>  // IWYU pragma: export
#include <google/protobuf/extension_set.h>  // IWYU pragma: export
#include <google/protobuf/unknown_field_set.h>
#include "scenario/scenario.pb.h"
#include "scenario/kh/KhIQDataAcq.pb.h"
#include "scenario/FFP/comSystemIdentify.pb.h"
// @@protoc_insertion_point(includes)
#include <google/protobuf/port_def.inc>
#define PROTOBUF_INTERNAL_EXPORT_scenario_2fkh_2fKhComSystemIdentify_2eproto
PROTOBUF_NAMESPACE_OPEN
namespace internal {
class AnyMetadata;
}  // namespace internal
PROTOBUF_NAMESPACE_CLOSE

// Internal implementation detail -- do not use these members.
struct TableStruct_scenario_2fkh_2fKhComSystemIdentify_2eproto {
  static const ::PROTOBUF_NAMESPACE_ID::internal::ParseTableField entries[]
    PROTOBUF_SECTION_VARIABLE(protodesc_cold);
  static const ::PROTOBUF_NAMESPACE_ID::internal::AuxillaryParseTableField aux[]
    PROTOBUF_SECTION_VARIABLE(protodesc_cold);
  static const ::PROTOBUF_NAMESPACE_ID::internal::ParseTable schema[1]
    PROTOBUF_SECTION_VARIABLE(protodesc_cold);
  static const ::PROTOBUF_NAMESPACE_ID::internal::FieldMetadata field_metadata[];
  static const ::PROTOBUF_NAMESPACE_ID::internal::SerializationTable serialization_table[];
  static const ::PROTOBUF_NAMESPACE_ID::uint32 offsets[];
};
extern const ::PROTOBUF_NAMESPACE_ID::internal::DescriptorTable descriptor_table_scenario_2fkh_2fKhComSystemIdentify_2eproto;
namespace zb {
namespace dcts {
namespace scenario {
namespace kh {
namespace CommSystemIdentify {
class CommSystemIdentifyTaskRequest;
class CommSystemIdentifyTaskRequestDefaultTypeInternal;
extern CommSystemIdentifyTaskRequestDefaultTypeInternal _CommSystemIdentifyTaskRequest_default_instance_;
}  // namespace CommSystemIdentify
}  // namespace kh
}  // namespace scenario
}  // namespace dcts
}  // namespace zb
PROTOBUF_NAMESPACE_OPEN
template<> ::zb::dcts::scenario::kh::CommSystemIdentify::CommSystemIdentifyTaskRequest* Arena::CreateMaybeMessage<::zb::dcts::scenario::kh::CommSystemIdentify::CommSystemIdentifyTaskRequest>(Arena*);
PROTOBUF_NAMESPACE_CLOSE
namespace zb {
namespace dcts {
namespace scenario {
namespace kh {
namespace CommSystemIdentify {

// ===================================================================

class CommSystemIdentifyTaskRequest PROTOBUF_FINAL :
    public ::PROTOBUF_NAMESPACE_ID::Message /* @@protoc_insertion_point(class_definition:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest) */ {
 public:
  inline CommSystemIdentifyTaskRequest() : CommSystemIdentifyTaskRequest(nullptr) {};
  virtual ~CommSystemIdentifyTaskRequest();

  CommSystemIdentifyTaskRequest(const CommSystemIdentifyTaskRequest& from);
  CommSystemIdentifyTaskRequest(CommSystemIdentifyTaskRequest&& from) noexcept
    : CommSystemIdentifyTaskRequest() {
    *this = ::std::move(from);
  }

  inline CommSystemIdentifyTaskRequest& operator=(const CommSystemIdentifyTaskRequest& from) {
    CopyFrom(from);
    return *this;
  }
  inline CommSystemIdentifyTaskRequest& operator=(CommSystemIdentifyTaskRequest&& from) noexcept {
    if (GetArena() == from.GetArena()) {
      if (this != &from) InternalSwap(&from);
    } else {
      CopyFrom(from);
    }
    return *this;
  }

  static const ::PROTOBUF_NAMESPACE_ID::Descriptor* descriptor() {
    return GetDescriptor();
  }
  static const ::PROTOBUF_NAMESPACE_ID::Descriptor* GetDescriptor() {
    return GetMetadataStatic().descriptor;
  }
  static const ::PROTOBUF_NAMESPACE_ID::Reflection* GetReflection() {
    return GetMetadataStatic().reflection;
  }
  static const CommSystemIdentifyTaskRequest& default_instance();

  static void InitAsDefaultInstance();  // FOR INTERNAL USE ONLY
  static inline const CommSystemIdentifyTaskRequest* internal_default_instance() {
    return reinterpret_cast<const CommSystemIdentifyTaskRequest*>(
               &_CommSystemIdentifyTaskRequest_default_instance_);
  }
  static constexpr int kIndexInFileMessages =
    0;

  friend void swap(CommSystemIdentifyTaskRequest& a, CommSystemIdentifyTaskRequest& b) {
    a.Swap(&b);
  }
  inline void Swap(CommSystemIdentifyTaskRequest* other) {
    if (other == this) return;
    if (GetArena() == other->GetArena()) {
      InternalSwap(other);
    } else {
      ::PROTOBUF_NAMESPACE_ID::internal::GenericSwap(this, other);
    }
  }
  void UnsafeArenaSwap(CommSystemIdentifyTaskRequest* other) {
    if (other == this) return;
    GOOGLE_DCHECK(GetArena() == other->GetArena());
    InternalSwap(other);
  }

  // implements Message ----------------------------------------------

  inline CommSystemIdentifyTaskRequest* New() const final {
    return CreateMaybeMessage<CommSystemIdentifyTaskRequest>(nullptr);
  }

  CommSystemIdentifyTaskRequest* New(::PROTOBUF_NAMESPACE_ID::Arena* arena) const final {
    return CreateMaybeMessage<CommSystemIdentifyTaskRequest>(arena);
  }
  void CopyFrom(const ::PROTOBUF_NAMESPACE_ID::Message& from) final;
  void MergeFrom(const ::PROTOBUF_NAMESPACE_ID::Message& from) final;
  void CopyFrom(const CommSystemIdentifyTaskRequest& from);
  void MergeFrom(const CommSystemIdentifyTaskRequest& from);
  PROTOBUF_ATTRIBUTE_REINITIALIZES void Clear() final;
  bool IsInitialized() const final;

  size_t ByteSizeLong() const final;
  const char* _InternalParse(const char* ptr, ::PROTOBUF_NAMESPACE_ID::internal::ParseContext* ctx) final;
  ::PROTOBUF_NAMESPACE_ID::uint8* _InternalSerialize(
      ::PROTOBUF_NAMESPACE_ID::uint8* target, ::PROTOBUF_NAMESPACE_ID::io::EpsCopyOutputStream* stream) const final;
  int GetCachedSize() const final { return _cached_size_.Get(); }

  private:
  inline void SharedCtor();
  inline void SharedDtor();
  void SetCachedSize(int size) const final;
  void InternalSwap(CommSystemIdentifyTaskRequest* other);
  friend class ::PROTOBUF_NAMESPACE_ID::internal::AnyMetadata;
  static ::PROTOBUF_NAMESPACE_ID::StringPiece FullMessageName() {
    return "zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest";
  }
  protected:
  explicit CommSystemIdentifyTaskRequest(::PROTOBUF_NAMESPACE_ID::Arena* arena);
  private:
  static void ArenaDtor(void* object);
  inline void RegisterArenaDtor(::PROTOBUF_NAMESPACE_ID::Arena* arena);
  public:

  ::PROTOBUF_NAMESPACE_ID::Metadata GetMetadata() const final;
  private:
  static ::PROTOBUF_NAMESPACE_ID::Metadata GetMetadataStatic() {
    ::PROTOBUF_NAMESPACE_ID::internal::AssignDescriptors(&::descriptor_table_scenario_2fkh_2fKhComSystemIdentify_2eproto);
    return ::descriptor_table_scenario_2fkh_2fKhComSystemIdentify_2eproto.file_level_metadata[kIndexInFileMessages];
  }

  public:

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  enum : int {
    kScenarioFieldNumber = 1,
    kSourceParamFieldNumber = 2,
    kAcqParamFieldNumber = 3,
  };
  // .zb.dcts.scenario.ScenarioId scenario = 1;
  bool has_scenario() const;
  private:
  bool _internal_has_scenario() const;
  public:
  void clear_scenario();
  const ::zb::dcts::scenario::ScenarioId& scenario() const;
  ::zb::dcts::scenario::ScenarioId* release_scenario();
  ::zb::dcts::scenario::ScenarioId* mutable_scenario();
  void set_allocated_scenario(::zb::dcts::scenario::ScenarioId* scenario);
  private:
  const ::zb::dcts::scenario::ScenarioId& _internal_scenario() const;
  ::zb::dcts::scenario::ScenarioId* _internal_mutable_scenario();
  public:
  void unsafe_arena_set_allocated_scenario(
      ::zb::dcts::scenario::ScenarioId* scenario);
  ::zb::dcts::scenario::ScenarioId* unsafe_arena_release_scenario();

  // .zb.dcts.scenario.kh.commIqData.CommIQAcqSource source_param = 2;
  bool has_source_param() const;
  private:
  bool _internal_has_source_param() const;
  public:
  void clear_source_param();
  const ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource& source_param() const;
  ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* release_source_param();
  ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* mutable_source_param();
  void set_allocated_source_param(::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* source_param);
  private:
  const ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource& _internal_source_param() const;
  ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* _internal_mutable_source_param();
  public:
  void unsafe_arena_set_allocated_source_param(
      ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* source_param);
  ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* unsafe_arena_release_source_param();

  // .zb.dcts.scenario.kh.commIqData.CommIQAcquireParam acq_param = 3;
  bool has_acq_param() const;
  private:
  bool _internal_has_acq_param() const;
  public:
  void clear_acq_param();
  const ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam& acq_param() const;
  ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* release_acq_param();
  ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* mutable_acq_param();
  void set_allocated_acq_param(::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* acq_param);
  private:
  const ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam& _internal_acq_param() const;
  ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* _internal_mutable_acq_param();
  public:
  void unsafe_arena_set_allocated_acq_param(
      ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* acq_param);
  ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* unsafe_arena_release_acq_param();

  // @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest)
 private:
  class _Internal;

  template <typename T> friend class ::PROTOBUF_NAMESPACE_ID::Arena::InternalHelper;
  typedef void InternalArenaConstructable_;
  typedef void DestructorSkippable_;
  ::zb::dcts::scenario::ScenarioId* scenario_;
  ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* source_param_;
  ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* acq_param_;
  mutable ::PROTOBUF_NAMESPACE_ID::internal::CachedSize _cached_size_;
  friend struct ::TableStruct_scenario_2fkh_2fKhComSystemIdentify_2eproto;
};
// ===================================================================


// ===================================================================

#ifdef __GNUC__
  #pragma GCC diagnostic push
  #pragma GCC diagnostic ignored "-Wstrict-aliasing"
#endif  // __GNUC__
// CommSystemIdentifyTaskRequest

// .zb.dcts.scenario.ScenarioId scenario = 1;
inline bool CommSystemIdentifyTaskRequest::_internal_has_scenario() const {
  return this != internal_default_instance() && scenario_ != nullptr;
}
inline bool CommSystemIdentifyTaskRequest::has_scenario() const {
  return _internal_has_scenario();
}
inline const ::zb::dcts::scenario::ScenarioId& CommSystemIdentifyTaskRequest::_internal_scenario() const {
  const ::zb::dcts::scenario::ScenarioId* p = scenario_;
  return p != nullptr ? *p : *reinterpret_cast<const ::zb::dcts::scenario::ScenarioId*>(
      &::zb::dcts::scenario::_ScenarioId_default_instance_);
}
inline const ::zb::dcts::scenario::ScenarioId& CommSystemIdentifyTaskRequest::scenario() const {
  // @@protoc_insertion_point(field_get:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.scenario)
  return _internal_scenario();
}
inline void CommSystemIdentifyTaskRequest::unsafe_arena_set_allocated_scenario(
    ::zb::dcts::scenario::ScenarioId* scenario) {
  if (GetArena() == nullptr) {
    delete reinterpret_cast<::PROTOBUF_NAMESPACE_ID::MessageLite*>(scenario_);
  }
  scenario_ = scenario;
  if (scenario) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_unsafe_arena_set_allocated:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.scenario)
}
inline ::zb::dcts::scenario::ScenarioId* CommSystemIdentifyTaskRequest::release_scenario() {
  auto temp = unsafe_arena_release_scenario();
  if (GetArena() != nullptr) {
    temp = ::PROTOBUF_NAMESPACE_ID::internal::DuplicateIfNonNull(temp);
  }
  return temp;
}
inline ::zb::dcts::scenario::ScenarioId* CommSystemIdentifyTaskRequest::unsafe_arena_release_scenario() {
  // @@protoc_insertion_point(field_release:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.scenario)
  
  ::zb::dcts::scenario::ScenarioId* temp = scenario_;
  scenario_ = nullptr;
  return temp;
}
inline ::zb::dcts::scenario::ScenarioId* CommSystemIdentifyTaskRequest::_internal_mutable_scenario() {
  
  if (scenario_ == nullptr) {
    auto* p = CreateMaybeMessage<::zb::dcts::scenario::ScenarioId>(GetArena());
    scenario_ = p;
  }
  return scenario_;
}
inline ::zb::dcts::scenario::ScenarioId* CommSystemIdentifyTaskRequest::mutable_scenario() {
  // @@protoc_insertion_point(field_mutable:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.scenario)
  return _internal_mutable_scenario();
}
inline void CommSystemIdentifyTaskRequest::set_allocated_scenario(::zb::dcts::scenario::ScenarioId* scenario) {
  ::PROTOBUF_NAMESPACE_ID::Arena* message_arena = GetArena();
  if (message_arena == nullptr) {
    delete reinterpret_cast< ::PROTOBUF_NAMESPACE_ID::MessageLite*>(scenario_);
  }
  if (scenario) {
    ::PROTOBUF_NAMESPACE_ID::Arena* submessage_arena =
      reinterpret_cast<::PROTOBUF_NAMESPACE_ID::MessageLite*>(scenario)->GetArena();
    if (message_arena != submessage_arena) {
      scenario = ::PROTOBUF_NAMESPACE_ID::internal::GetOwnedMessage(
          message_arena, scenario, submessage_arena);
    }
    
  } else {
    
  }
  scenario_ = scenario;
  // @@protoc_insertion_point(field_set_allocated:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.scenario)
}

// .zb.dcts.scenario.kh.commIqData.CommIQAcqSource source_param = 2;
inline bool CommSystemIdentifyTaskRequest::_internal_has_source_param() const {
  return this != internal_default_instance() && source_param_ != nullptr;
}
inline bool CommSystemIdentifyTaskRequest::has_source_param() const {
  return _internal_has_source_param();
}
inline const ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource& CommSystemIdentifyTaskRequest::_internal_source_param() const {
  const ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* p = source_param_;
  return p != nullptr ? *p : *reinterpret_cast<const ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource*>(
      &::zb::dcts::scenario::kh::commIqData::_CommIQAcqSource_default_instance_);
}
inline const ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource& CommSystemIdentifyTaskRequest::source_param() const {
  // @@protoc_insertion_point(field_get:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.source_param)
  return _internal_source_param();
}
inline void CommSystemIdentifyTaskRequest::unsafe_arena_set_allocated_source_param(
    ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* source_param) {
  if (GetArena() == nullptr) {
    delete reinterpret_cast<::PROTOBUF_NAMESPACE_ID::MessageLite*>(source_param_);
  }
  source_param_ = source_param;
  if (source_param) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_unsafe_arena_set_allocated:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.source_param)
}
inline ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* CommSystemIdentifyTaskRequest::release_source_param() {
  auto temp = unsafe_arena_release_source_param();
  if (GetArena() != nullptr) {
    temp = ::PROTOBUF_NAMESPACE_ID::internal::DuplicateIfNonNull(temp);
  }
  return temp;
}
inline ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* CommSystemIdentifyTaskRequest::unsafe_arena_release_source_param() {
  // @@protoc_insertion_point(field_release:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.source_param)
  
  ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* temp = source_param_;
  source_param_ = nullptr;
  return temp;
}
inline ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* CommSystemIdentifyTaskRequest::_internal_mutable_source_param() {
  
  if (source_param_ == nullptr) {
    auto* p = CreateMaybeMessage<::zb::dcts::scenario::kh::commIqData::CommIQAcqSource>(GetArena());
    source_param_ = p;
  }
  return source_param_;
}
inline ::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* CommSystemIdentifyTaskRequest::mutable_source_param() {
  // @@protoc_insertion_point(field_mutable:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.source_param)
  return _internal_mutable_source_param();
}
inline void CommSystemIdentifyTaskRequest::set_allocated_source_param(::zb::dcts::scenario::kh::commIqData::CommIQAcqSource* source_param) {
  ::PROTOBUF_NAMESPACE_ID::Arena* message_arena = GetArena();
  if (message_arena == nullptr) {
    delete reinterpret_cast< ::PROTOBUF_NAMESPACE_ID::MessageLite*>(source_param_);
  }
  if (source_param) {
    ::PROTOBUF_NAMESPACE_ID::Arena* submessage_arena =
      reinterpret_cast<::PROTOBUF_NAMESPACE_ID::MessageLite*>(source_param)->GetArena();
    if (message_arena != submessage_arena) {
      source_param = ::PROTOBUF_NAMESPACE_ID::internal::GetOwnedMessage(
          message_arena, source_param, submessage_arena);
    }
    
  } else {
    
  }
  source_param_ = source_param;
  // @@protoc_insertion_point(field_set_allocated:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.source_param)
}

// .zb.dcts.scenario.kh.commIqData.CommIQAcquireParam acq_param = 3;
inline bool CommSystemIdentifyTaskRequest::_internal_has_acq_param() const {
  return this != internal_default_instance() && acq_param_ != nullptr;
}
inline bool CommSystemIdentifyTaskRequest::has_acq_param() const {
  return _internal_has_acq_param();
}
inline const ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam& CommSystemIdentifyTaskRequest::_internal_acq_param() const {
  const ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* p = acq_param_;
  return p != nullptr ? *p : *reinterpret_cast<const ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam*>(
      &::zb::dcts::scenario::kh::commIqData::_CommIQAcquireParam_default_instance_);
}
inline const ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam& CommSystemIdentifyTaskRequest::acq_param() const {
  // @@protoc_insertion_point(field_get:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.acq_param)
  return _internal_acq_param();
}
inline void CommSystemIdentifyTaskRequest::unsafe_arena_set_allocated_acq_param(
    ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* acq_param) {
  if (GetArena() == nullptr) {
    delete reinterpret_cast<::PROTOBUF_NAMESPACE_ID::MessageLite*>(acq_param_);
  }
  acq_param_ = acq_param;
  if (acq_param) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_unsafe_arena_set_allocated:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.acq_param)
}
inline ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* CommSystemIdentifyTaskRequest::release_acq_param() {
  auto temp = unsafe_arena_release_acq_param();
  if (GetArena() != nullptr) {
    temp = ::PROTOBUF_NAMESPACE_ID::internal::DuplicateIfNonNull(temp);
  }
  return temp;
}
inline ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* CommSystemIdentifyTaskRequest::unsafe_arena_release_acq_param() {
  // @@protoc_insertion_point(field_release:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.acq_param)
  
  ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* temp = acq_param_;
  acq_param_ = nullptr;
  return temp;
}
inline ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* CommSystemIdentifyTaskRequest::_internal_mutable_acq_param() {
  
  if (acq_param_ == nullptr) {
    auto* p = CreateMaybeMessage<::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam>(GetArena());
    acq_param_ = p;
  }
  return acq_param_;
}
inline ::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* CommSystemIdentifyTaskRequest::mutable_acq_param() {
  // @@protoc_insertion_point(field_mutable:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.acq_param)
  return _internal_mutable_acq_param();
}
inline void CommSystemIdentifyTaskRequest::set_allocated_acq_param(::zb::dcts::scenario::kh::commIqData::CommIQAcquireParam* acq_param) {
  ::PROTOBUF_NAMESPACE_ID::Arena* message_arena = GetArena();
  if (message_arena == nullptr) {
    delete reinterpret_cast< ::PROTOBUF_NAMESPACE_ID::MessageLite*>(acq_param_);
  }
  if (acq_param) {
    ::PROTOBUF_NAMESPACE_ID::Arena* submessage_arena =
      reinterpret_cast<::PROTOBUF_NAMESPACE_ID::MessageLite*>(acq_param)->GetArena();
    if (message_arena != submessage_arena) {
      acq_param = ::PROTOBUF_NAMESPACE_ID::internal::GetOwnedMessage(
          message_arena, acq_param, submessage_arena);
    }
    
  } else {
    
  }
  acq_param_ = acq_param;
  // @@protoc_insertion_point(field_set_allocated:zb.dcts.scenario.kh.CommSystemIdentify.CommSystemIdentifyTaskRequest.acq_param)
}

#ifdef __GNUC__
  #pragma GCC diagnostic pop
#endif  // __GNUC__

// @@protoc_insertion_point(namespace_scope)

}  // namespace CommSystemIdentify
}  // namespace kh
}  // namespace scenario
}  // namespace dcts
}  // namespace zb

// @@protoc_insertion_point(global_scope)

#include <google/protobuf/port_undef.inc>
#endif  // GOOGLE_PROTOBUF_INCLUDED_GOOGLE_PROTOBUF_INCLUDED_scenario_2fkh_2fKhComSystemIdentify_2eproto
