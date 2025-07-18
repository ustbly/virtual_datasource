# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: scenario/kh/KhSpreadSpectrum.proto

from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


from scenario import scenario_pb2 as scenario_dot_scenario__pb2
from scenario import spectrum_pb2 as scenario_dot_spectrum__pb2
from scenario.kh import KhIQDataAcq_pb2 as scenario_dot_kh_dot_KhIQDataAcq__pb2


DESCRIPTOR = _descriptor.FileDescriptor(
  name='scenario/kh/KhSpreadSpectrum.proto',
  package='zb.dcts.scenario.kh.commSpreadSpectrum',
  syntax='proto3',
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_pb=b'\n\"scenario/kh/KhSpreadSpectrum.proto\x12&zb.dcts.scenario.kh.commSpreadSpectrum\x1a\x17scenario/scenario.proto\x1a\x17scenario/spectrum.proto\x1a\x1dscenario/kh/KhIQDataAcq.proto\"\xdd\x01\n\x1d\x43ommSpreadSpectrumTaskRequest\x12.\n\x08scenario\x18\x01 \x01(\x0b\x32\x1c.zb.dcts.scenario.ScenarioId\x12\x45\n\x0csource_param\x18\x02 \x01(\x0b\x32/.zb.dcts.scenario.kh.commIqData.CommIQAcqSource\x12\x45\n\tacq_param\x18\x03 \x01(\x0b\x32\x32.zb.dcts.scenario.kh.commIqData.CommIQAcquireParam\"\x8e\x02\n\x18\x43ommSpreadSpectrumResult\x12\x31\n\x06header\x18\x01 \x01(\x0b\x32!.zb.dcts.scenario.spectrum.Header\x12\x31\n\x08spectrum\x18\x02 \x01(\x0b\x32\x1f.zb.dcts.scenario.spectrum.View\x12\x0c\n\x04\x66req\x18\x03 \x01(\x01\x12\x12\n\ncode_speed\x18\x04 \x01(\x01\x12\x13\n\x0bsignal_type\x18\x05 \x01(\x05\x12\r\n\x05level\x18\x06 \x01(\x01\x12\n\n\x02\x62w\x18\x07 \x01(\x01\x12\x11\n\tpn_period\x18\x08 \x01(\x01\x12\x11\n\tpn_length\x18\t \x01(\x03\x12\x14\n\x0cpn_chip_rate\x18\n \x01(\x01\x32\xd8\x02\n\x19\x43ommSpreadSpectrumService\x12u\n\tStartTask\x12\x45.zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumTaskRequest\x1a\x1f.zb.dcts.scenario.ScenarioReply\"\x00\x12s\n\tGetResult\x12 .zb.dcts.scenario.ScenarioTaskId\x1a@.zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult\"\x00\x30\x01\x12O\n\x08StopTask\x12 .zb.dcts.scenario.ScenarioTaskId\x1a\x1f.zb.dcts.scenario.ScenarioReply\"\x00\x62\x06proto3'
  ,
  dependencies=[scenario_dot_scenario__pb2.DESCRIPTOR,scenario_dot_spectrum__pb2.DESCRIPTOR,scenario_dot_kh_dot_KhIQDataAcq__pb2.DESCRIPTOR,])




_COMMSPREADSPECTRUMTASKREQUEST = _descriptor.Descriptor(
  name='CommSpreadSpectrumTaskRequest',
  full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumTaskRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='scenario', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumTaskRequest.scenario', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='source_param', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumTaskRequest.source_param', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='acq_param', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumTaskRequest.acq_param', index=2,
      number=3, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=160,
  serialized_end=381,
)


_COMMSPREADSPECTRUMRESULT = _descriptor.Descriptor(
  name='CommSpreadSpectrumResult',
  full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='header', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult.header', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='spectrum', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult.spectrum', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='freq', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult.freq', index=2,
      number=3, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='code_speed', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult.code_speed', index=3,
      number=4, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='signal_type', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult.signal_type', index=4,
      number=5, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='level', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult.level', index=5,
      number=6, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='bw', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult.bw', index=6,
      number=7, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='pn_period', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult.pn_period', index=7,
      number=8, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='pn_length', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult.pn_length', index=8,
      number=9, type=3, cpp_type=2, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='pn_chip_rate', full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult.pn_chip_rate', index=9,
      number=10, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=384,
  serialized_end=654,
)

_COMMSPREADSPECTRUMTASKREQUEST.fields_by_name['scenario'].message_type = scenario_dot_scenario__pb2._SCENARIOID
_COMMSPREADSPECTRUMTASKREQUEST.fields_by_name['source_param'].message_type = scenario_dot_kh_dot_KhIQDataAcq__pb2._COMMIQACQSOURCE
_COMMSPREADSPECTRUMTASKREQUEST.fields_by_name['acq_param'].message_type = scenario_dot_kh_dot_KhIQDataAcq__pb2._COMMIQACQUIREPARAM
_COMMSPREADSPECTRUMRESULT.fields_by_name['header'].message_type = scenario_dot_spectrum__pb2._HEADER
_COMMSPREADSPECTRUMRESULT.fields_by_name['spectrum'].message_type = scenario_dot_spectrum__pb2._VIEW
DESCRIPTOR.message_types_by_name['CommSpreadSpectrumTaskRequest'] = _COMMSPREADSPECTRUMTASKREQUEST
DESCRIPTOR.message_types_by_name['CommSpreadSpectrumResult'] = _COMMSPREADSPECTRUMRESULT
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

CommSpreadSpectrumTaskRequest = _reflection.GeneratedProtocolMessageType('CommSpreadSpectrumTaskRequest', (_message.Message,), {
  'DESCRIPTOR' : _COMMSPREADSPECTRUMTASKREQUEST,
  '__module__' : 'scenario.kh.KhSpreadSpectrum_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumTaskRequest)
  })
_sym_db.RegisterMessage(CommSpreadSpectrumTaskRequest)

CommSpreadSpectrumResult = _reflection.GeneratedProtocolMessageType('CommSpreadSpectrumResult', (_message.Message,), {
  'DESCRIPTOR' : _COMMSPREADSPECTRUMRESULT,
  '__module__' : 'scenario.kh.KhSpreadSpectrum_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumResult)
  })
_sym_db.RegisterMessage(CommSpreadSpectrumResult)



_COMMSPREADSPECTRUMSERVICE = _descriptor.ServiceDescriptor(
  name='CommSpreadSpectrumService',
  full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_start=657,
  serialized_end=1001,
  methods=[
  _descriptor.MethodDescriptor(
    name='StartTask',
    full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumService.StartTask',
    index=0,
    containing_service=None,
    input_type=_COMMSPREADSPECTRUMTASKREQUEST,
    output_type=scenario_dot_scenario__pb2._SCENARIOREPLY,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='GetResult',
    full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumService.GetResult',
    index=1,
    containing_service=None,
    input_type=scenario_dot_scenario__pb2._SCENARIOTASKID,
    output_type=_COMMSPREADSPECTRUMRESULT,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='StopTask',
    full_name='zb.dcts.scenario.kh.commSpreadSpectrum.CommSpreadSpectrumService.StopTask',
    index=2,
    containing_service=None,
    input_type=scenario_dot_scenario__pb2._SCENARIOTASKID,
    output_type=scenario_dot_scenario__pb2._SCENARIOREPLY,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
])
_sym_db.RegisterServiceDescriptor(_COMMSPREADSPECTRUMSERVICE)

DESCRIPTOR.services_by_name['CommSpreadSpectrumService'] = _COMMSPREADSPECTRUMSERVICE

# @@protoc_insertion_point(module_scope)
