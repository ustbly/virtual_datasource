# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: scenario/kh/KhCommChannelCali.proto

from google.protobuf.internal import enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


from source import source_pb2 as source_dot_source__pb2
from scenario import scenario_pb2 as scenario_dot_scenario__pb2
from scenario.kh import KhSpectrumAcq_pb2 as scenario_dot_kh_dot_KhSpectrumAcq__pb2


DESCRIPTOR = _descriptor.FileDescriptor(
  name='scenario/kh/KhCommChannelCali.proto',
  package='zb.dcts.scenario.kh.commSpectrum',
  syntax='proto3',
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_pb=b'\n#scenario/kh/KhCommChannelCali.proto\x12 zb.dcts.scenario.kh.commSpectrum\x1a\x13source/source.proto\x1a\x17scenario/scenario.proto\x1a\x1fscenario/kh/KhSpectrumAcq.proto\"\x95\x03\n\x1a\x43ommChannelCaliTaskRequest\x12+\n\tsource_id\x18\x01 \x01(\x0b\x32\x18.zb.dcts.source.SourceId\x12I\n\x0csource_param\x18\x02 \x01(\x0b\x32\x33.zb.dcts.scenario.kh.commSpectrum.SpectrumAcqSource\x12\x45\n\tacq_param\x18\x03 \x01(\x0b\x32\x32.zb.dcts.scenario.kh.commSpectrum.SpectrumAcqParam\x12;\n\x08\x63\x61l_type\x18\x04 \x01(\x0e\x32).zb.dcts.scenario.kh.commSpectrum.CalType\x12\x43\n\x0c\x63hannel_type\x18\x05 \x01(\x0e\x32-.zb.dcts.scenario.kh.commSpectrum.ChannelType\x12\x13\n\x0b\x64\x61\x63_crystal\x18\x06 \x01(\x05\x12\x0e\n\x06\x64\x61\x63_v1\x18\x07 \x01(\x05\x12\x11\n\tdac_phase\x18\x08 \x01(\x05\"\x9b\x02\n\rChangeRequest\x12\x33\n\tresponser\x18\x01 \x01(\x0b\x32 .zb.dcts.scenario.ScenarioTaskId\x12\x41\n\x0bparam_index\x18\x02 \x01(\x0e\x32,.zb.dcts.scenario.kh.commSpectrum.ParamIndex\x12\x45\n\tacq_param\x18\x03 \x01(\x0b\x32\x32.zb.dcts.scenario.kh.commSpectrum.SpectrumAcqParam\x12\x13\n\x0b\x64\x61\x63_crystal\x18\x06 \x01(\x05\x12\x0e\n\x06\x64\x61\x63_v1\x18\x07 \x01(\x05\x12\x11\n\tdac_phase\x18\x08 \x01(\x05\x12\x13\n\x0b\x63\x65nter_freq\x18\t \x01(\x01*\xa0\x01\n\x07\x43\x61lType\x12\x15\n\x11\x43RYSTAL_CALIBRATE\x10\x00\x12\x11\n\rFREQ_RESPONSE\x10\x01\x12\x10\n\x0cIN_BAND_FLAT\x10\x02\x12\x14\n\x10RF_FREQ_RESPONSE\x10\x03\x12\x0f\n\x0bWINDOW_FUNC\x10\x04\x12\x0f\n\x0bMODULE_TEST\x10\x05\x12\x12\n\x0e\x42\x41NDWIDTH_GAIN\x10\x06\x12\r\n\tZERO_FREQ\x10\x07**\n\x0b\x43hannelType\x12\x0c\n\x08SPECTRUM\x10\x00\x12\r\n\tDIRECTION\x10\x01*\x91\x01\n\nParamIndex\x12\x07\n\x03\x41LL\x10\x00\x12\x0c\n\x08\x41TT_GAIN\x10\x01\x12\x0e\n\nFREQ_RANGE\x10\x02\x12\x0c\n\x08\x46REQ_RBW\x10\x03\x12\x0e\n\nFREQ_TUNER\x10\x04\x12\x0f\n\x0b\x43\x45NTER_FREQ\x10\x05\x12\x0f\n\x0b\x43RYSTAL_DAC\x10\x06\x12\x0c\n\x08ZERO_DAC\x10\x07\x12\x0e\n\nCHANNEL_ID\x10\x08\x32\x9d\x03\n\x16\x43ommChannelCaliService\x12l\n\tStartTask\x12<.zb.dcts.scenario.kh.commSpectrum.CommChannelCaliTaskRequest\x1a\x1f.zb.dcts.scenario.ScenarioReply\"\x00\x12\x66\n\tGetResult\x12 .zb.dcts.scenario.ScenarioTaskId\x1a\x33.zb.dcts.scenario.kh.commSpectrum.SpectrumAcqResult\"\x00\x30\x01\x12O\n\x08StopTask\x12 .zb.dcts.scenario.ScenarioTaskId\x1a\x1f.zb.dcts.scenario.ScenarioReply\"\x00\x12\\\n\x06\x43hange\x12/.zb.dcts.scenario.kh.commSpectrum.ChangeRequest\x1a\x1f.zb.dcts.scenario.ScenarioReply\"\x00\x62\x06proto3'
  ,
  dependencies=[source_dot_source__pb2.DESCRIPTOR,scenario_dot_scenario__pb2.DESCRIPTOR,scenario_dot_kh_dot_KhSpectrumAcq__pb2.DESCRIPTOR,])

_CALTYPE = _descriptor.EnumDescriptor(
  name='CalType',
  full_name='zb.dcts.scenario.kh.commSpectrum.CalType',
  filename=None,
  file=DESCRIPTOR,
  create_key=_descriptor._internal_create_key,
  values=[
    _descriptor.EnumValueDescriptor(
      name='CRYSTAL_CALIBRATE', index=0, number=0,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='FREQ_RESPONSE', index=1, number=1,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='IN_BAND_FLAT', index=2, number=2,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='RF_FREQ_RESPONSE', index=3, number=3,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='WINDOW_FUNC', index=4, number=4,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='MODULE_TEST', index=5, number=5,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='BANDWIDTH_GAIN', index=6, number=6,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='ZERO_FREQ', index=7, number=7,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=847,
  serialized_end=1007,
)
_sym_db.RegisterEnumDescriptor(_CALTYPE)

CalType = enum_type_wrapper.EnumTypeWrapper(_CALTYPE)
_CHANNELTYPE = _descriptor.EnumDescriptor(
  name='ChannelType',
  full_name='zb.dcts.scenario.kh.commSpectrum.ChannelType',
  filename=None,
  file=DESCRIPTOR,
  create_key=_descriptor._internal_create_key,
  values=[
    _descriptor.EnumValueDescriptor(
      name='SPECTRUM', index=0, number=0,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='DIRECTION', index=1, number=1,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=1009,
  serialized_end=1051,
)
_sym_db.RegisterEnumDescriptor(_CHANNELTYPE)

ChannelType = enum_type_wrapper.EnumTypeWrapper(_CHANNELTYPE)
_PARAMINDEX = _descriptor.EnumDescriptor(
  name='ParamIndex',
  full_name='zb.dcts.scenario.kh.commSpectrum.ParamIndex',
  filename=None,
  file=DESCRIPTOR,
  create_key=_descriptor._internal_create_key,
  values=[
    _descriptor.EnumValueDescriptor(
      name='ALL', index=0, number=0,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='ATT_GAIN', index=1, number=1,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='FREQ_RANGE', index=2, number=2,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='FREQ_RBW', index=3, number=3,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='FREQ_TUNER', index=4, number=4,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='CENTER_FREQ', index=5, number=5,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='CRYSTAL_DAC', index=6, number=6,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='ZERO_DAC', index=7, number=7,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='CHANNEL_ID', index=8, number=8,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=1054,
  serialized_end=1199,
)
_sym_db.RegisterEnumDescriptor(_PARAMINDEX)

ParamIndex = enum_type_wrapper.EnumTypeWrapper(_PARAMINDEX)
CRYSTAL_CALIBRATE = 0
FREQ_RESPONSE = 1
IN_BAND_FLAT = 2
RF_FREQ_RESPONSE = 3
WINDOW_FUNC = 4
MODULE_TEST = 5
BANDWIDTH_GAIN = 6
ZERO_FREQ = 7
SPECTRUM = 0
DIRECTION = 1
ALL = 0
ATT_GAIN = 1
FREQ_RANGE = 2
FREQ_RBW = 3
FREQ_TUNER = 4
CENTER_FREQ = 5
CRYSTAL_DAC = 6
ZERO_DAC = 7
CHANNEL_ID = 8



_COMMCHANNELCALITASKREQUEST = _descriptor.Descriptor(
  name='CommChannelCaliTaskRequest',
  full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliTaskRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='source_id', full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliTaskRequest.source_id', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='source_param', full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliTaskRequest.source_param', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='acq_param', full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliTaskRequest.acq_param', index=2,
      number=3, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='cal_type', full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliTaskRequest.cal_type', index=3,
      number=4, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='channel_type', full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliTaskRequest.channel_type', index=4,
      number=5, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='dac_crystal', full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliTaskRequest.dac_crystal', index=5,
      number=6, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='dac_v1', full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliTaskRequest.dac_v1', index=6,
      number=7, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='dac_phase', full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliTaskRequest.dac_phase', index=7,
      number=8, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
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
  serialized_start=153,
  serialized_end=558,
)


_CHANGEREQUEST = _descriptor.Descriptor(
  name='ChangeRequest',
  full_name='zb.dcts.scenario.kh.commSpectrum.ChangeRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='responser', full_name='zb.dcts.scenario.kh.commSpectrum.ChangeRequest.responser', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='param_index', full_name='zb.dcts.scenario.kh.commSpectrum.ChangeRequest.param_index', index=1,
      number=2, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='acq_param', full_name='zb.dcts.scenario.kh.commSpectrum.ChangeRequest.acq_param', index=2,
      number=3, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='dac_crystal', full_name='zb.dcts.scenario.kh.commSpectrum.ChangeRequest.dac_crystal', index=3,
      number=6, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='dac_v1', full_name='zb.dcts.scenario.kh.commSpectrum.ChangeRequest.dac_v1', index=4,
      number=7, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='dac_phase', full_name='zb.dcts.scenario.kh.commSpectrum.ChangeRequest.dac_phase', index=5,
      number=8, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='center_freq', full_name='zb.dcts.scenario.kh.commSpectrum.ChangeRequest.center_freq', index=6,
      number=9, type=1, cpp_type=5, label=1,
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
  serialized_start=561,
  serialized_end=844,
)

_COMMCHANNELCALITASKREQUEST.fields_by_name['source_id'].message_type = source_dot_source__pb2._SOURCEID
_COMMCHANNELCALITASKREQUEST.fields_by_name['source_param'].message_type = scenario_dot_kh_dot_KhSpectrumAcq__pb2._SPECTRUMACQSOURCE
_COMMCHANNELCALITASKREQUEST.fields_by_name['acq_param'].message_type = scenario_dot_kh_dot_KhSpectrumAcq__pb2._SPECTRUMACQPARAM
_COMMCHANNELCALITASKREQUEST.fields_by_name['cal_type'].enum_type = _CALTYPE
_COMMCHANNELCALITASKREQUEST.fields_by_name['channel_type'].enum_type = _CHANNELTYPE
_CHANGEREQUEST.fields_by_name['responser'].message_type = scenario_dot_scenario__pb2._SCENARIOTASKID
_CHANGEREQUEST.fields_by_name['param_index'].enum_type = _PARAMINDEX
_CHANGEREQUEST.fields_by_name['acq_param'].message_type = scenario_dot_kh_dot_KhSpectrumAcq__pb2._SPECTRUMACQPARAM
DESCRIPTOR.message_types_by_name['CommChannelCaliTaskRequest'] = _COMMCHANNELCALITASKREQUEST
DESCRIPTOR.message_types_by_name['ChangeRequest'] = _CHANGEREQUEST
DESCRIPTOR.enum_types_by_name['CalType'] = _CALTYPE
DESCRIPTOR.enum_types_by_name['ChannelType'] = _CHANNELTYPE
DESCRIPTOR.enum_types_by_name['ParamIndex'] = _PARAMINDEX
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

CommChannelCaliTaskRequest = _reflection.GeneratedProtocolMessageType('CommChannelCaliTaskRequest', (_message.Message,), {
  'DESCRIPTOR' : _COMMCHANNELCALITASKREQUEST,
  '__module__' : 'scenario.kh.KhCommChannelCali_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commSpectrum.CommChannelCaliTaskRequest)
  })
_sym_db.RegisterMessage(CommChannelCaliTaskRequest)

ChangeRequest = _reflection.GeneratedProtocolMessageType('ChangeRequest', (_message.Message,), {
  'DESCRIPTOR' : _CHANGEREQUEST,
  '__module__' : 'scenario.kh.KhCommChannelCali_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commSpectrum.ChangeRequest)
  })
_sym_db.RegisterMessage(ChangeRequest)



_COMMCHANNELCALISERVICE = _descriptor.ServiceDescriptor(
  name='CommChannelCaliService',
  full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_start=1202,
  serialized_end=1615,
  methods=[
  _descriptor.MethodDescriptor(
    name='StartTask',
    full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliService.StartTask',
    index=0,
    containing_service=None,
    input_type=_COMMCHANNELCALITASKREQUEST,
    output_type=scenario_dot_scenario__pb2._SCENARIOREPLY,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='GetResult',
    full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliService.GetResult',
    index=1,
    containing_service=None,
    input_type=scenario_dot_scenario__pb2._SCENARIOTASKID,
    output_type=scenario_dot_kh_dot_KhSpectrumAcq__pb2._SPECTRUMACQRESULT,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='StopTask',
    full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliService.StopTask',
    index=2,
    containing_service=None,
    input_type=scenario_dot_scenario__pb2._SCENARIOTASKID,
    output_type=scenario_dot_scenario__pb2._SCENARIOREPLY,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='Change',
    full_name='zb.dcts.scenario.kh.commSpectrum.CommChannelCaliService.Change',
    index=3,
    containing_service=None,
    input_type=_CHANGEREQUEST,
    output_type=scenario_dot_scenario__pb2._SCENARIOREPLY,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
])
_sym_db.RegisterServiceDescriptor(_COMMCHANNELCALISERVICE)

DESCRIPTOR.services_by_name['CommChannelCaliService'] = _COMMCHANNELCALISERVICE

# @@protoc_insertion_point(module_scope)
