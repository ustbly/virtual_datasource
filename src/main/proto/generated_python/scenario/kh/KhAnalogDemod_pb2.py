# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: scenario/kh/KhAnalogDemod.proto

from google.protobuf.internal import enum_type_wrapper
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
  name='scenario/kh/KhAnalogDemod.proto',
  package='zb.dcts.scenario.kh.commAnalogDemod',
  syntax='proto3',
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_pb=b'\n\x1fscenario/kh/KhAnalogDemod.proto\x12#zb.dcts.scenario.kh.commAnalogDemod\x1a\x17scenario/scenario.proto\x1a\x17scenario/spectrum.proto\x1a\x1dscenario/kh/KhIQDataAcq.proto\"\xc2\x01\n\x0c\x44\x65modChannel\x12\n\n\x02id\x18\x01 \x01(\t\x12:\n\x0bsignal_band\x18\x02 \x01(\x0b\x32%.zb.dcts.scenario.spectrum.SignalBand\x12\x19\n\x11\x61udio_sample_rate\x18\x03 \x01(\x01\x12\x0b\n\x03\x62\x66o\x18\x05 \x01(\x01\x12\x42\n\ndemod_type\x18\x06 \x01(\x0e\x32..zb.dcts.scenario.kh.commAnalogDemod.DemodType\"\x98\x02\n\x14\x43ommDemodTaskRequest\x12.\n\x08scenario\x18\x01 \x01(\x0b\x32\x1c.zb.dcts.scenario.ScenarioId\x12\x45\n\x0csource_param\x18\x02 \x01(\x0b\x32/.zb.dcts.scenario.kh.commIqData.CommIQAcqSource\x12\x45\n\tacq_param\x18\x03 \x01(\x0b\x32\x32.zb.dcts.scenario.kh.commIqData.CommIQAcquireParam\x12\x42\n\x07\x63hannel\x18\x04 \x01(\x0b\x32\x31.zb.dcts.scenario.kh.commAnalogDemod.DemodChannel\"#\n\nAudioBlock\x12\x15\n\rpcm_bitstream\x18\x03 \x03(\x05\"[\n\x0c\x43hannelAudio\x12\n\n\x02id\x18\x01 \x01(\t\x12?\n\x06\x62locks\x18\x02 \x03(\x0b\x32/.zb.dcts.scenario.kh.commAnalogDemod.AudioBlock\"\xc7\x01\n\x0f\x43ommDemodResult\x12\x31\n\x06header\x18\x01 \x01(\x0b\x32!.zb.dcts.scenario.spectrum.Header\x12H\n\rchannel_audio\x18\x02 \x01(\x0b\x32\x31.zb.dcts.scenario.kh.commAnalogDemod.ChannelAudio\x12\x37\n\x0espectrum_views\x18\x03 \x01(\x0b\x32\x1f.zb.dcts.scenario.spectrum.View\"\xd0\x01\n\x14\x43hangeChannelRequest\x12\x33\n\tresponser\x18\x01 \x01(\x0b\x32 .zb.dcts.scenario.ScenarioTaskId\x12?\n\x04type\x18\x02 \x01(\x0e\x32\x31.zb.dcts.scenario.kh.commIqData.ChangeRequestType\x12\x42\n\x07\x63hannel\x18\x03 \x01(\x0b\x32\x31.zb.dcts.scenario.kh.commAnalogDemod.DemodChannel*c\n\tDemodType\x12\x08\n\x04NONE\x10\x00\x12\x06\n\x02\x41M\x10\x01\x12\x06\n\x02\x46M\x10\x02\x12\x06\n\x02\x43W\x10\x03\x12\x07\n\x03LSB\x10\x04\x12\x07\n\x03USB\x10\x05\x12\t\n\x05PULSE\x10\x06\x12\x07\n\x03ISB\x10\x07\x12\x06\n\x02PM\x10\x08\x12\x06\n\x02IQ\x10\t2\xa8\x03\n\x12\x41nalogDemodService\x12i\n\tStartTask\x12\x39.zb.dcts.scenario.kh.commAnalogDemod.CommDemodTaskRequest\x1a\x1f.zb.dcts.scenario.ScenarioReply\"\x00\x12g\n\tGetResult\x12 .zb.dcts.scenario.ScenarioTaskId\x1a\x34.zb.dcts.scenario.kh.commAnalogDemod.CommDemodResult\"\x00\x30\x01\x12m\n\rChangeChannel\x12\x39.zb.dcts.scenario.kh.commAnalogDemod.ChangeChannelRequest\x1a\x1f.zb.dcts.scenario.ScenarioReply\"\x00\x12O\n\x08StopTask\x12 .zb.dcts.scenario.ScenarioTaskId\x1a\x1f.zb.dcts.scenario.ScenarioReply\"\x00\x62\x06proto3'
  ,
  dependencies=[scenario_dot_scenario__pb2.DESCRIPTOR,scenario_dot_spectrum__pb2.DESCRIPTOR,scenario_dot_kh_dot_KhIQDataAcq__pb2.DESCRIPTOR,])

_DEMODTYPE = _descriptor.EnumDescriptor(
  name='DemodType',
  full_name='zb.dcts.scenario.kh.commAnalogDemod.DemodType',
  filename=None,
  file=DESCRIPTOR,
  create_key=_descriptor._internal_create_key,
  values=[
    _descriptor.EnumValueDescriptor(
      name='NONE', index=0, number=0,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='AM', index=1, number=1,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='FM', index=2, number=2,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='CW', index=3, number=3,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='LSB', index=4, number=4,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='USB', index=5, number=5,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='PULSE', index=6, number=6,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='ISB', index=7, number=7,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='PM', index=8, number=8,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='IQ', index=9, number=9,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=1176,
  serialized_end=1275,
)
_sym_db.RegisterEnumDescriptor(_DEMODTYPE)

DemodType = enum_type_wrapper.EnumTypeWrapper(_DEMODTYPE)
NONE = 0
AM = 1
FM = 2
CW = 3
LSB = 4
USB = 5
PULSE = 6
ISB = 7
PM = 8
IQ = 9



_DEMODCHANNEL = _descriptor.Descriptor(
  name='DemodChannel',
  full_name='zb.dcts.scenario.kh.commAnalogDemod.DemodChannel',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='id', full_name='zb.dcts.scenario.kh.commAnalogDemod.DemodChannel.id', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='signal_band', full_name='zb.dcts.scenario.kh.commAnalogDemod.DemodChannel.signal_band', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='audio_sample_rate', full_name='zb.dcts.scenario.kh.commAnalogDemod.DemodChannel.audio_sample_rate', index=2,
      number=3, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='bfo', full_name='zb.dcts.scenario.kh.commAnalogDemod.DemodChannel.bfo', index=3,
      number=5, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='demod_type', full_name='zb.dcts.scenario.kh.commAnalogDemod.DemodChannel.demod_type', index=4,
      number=6, type=14, cpp_type=8, label=1,
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
  serialized_start=154,
  serialized_end=348,
)


_COMMDEMODTASKREQUEST = _descriptor.Descriptor(
  name='CommDemodTaskRequest',
  full_name='zb.dcts.scenario.kh.commAnalogDemod.CommDemodTaskRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='scenario', full_name='zb.dcts.scenario.kh.commAnalogDemod.CommDemodTaskRequest.scenario', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='source_param', full_name='zb.dcts.scenario.kh.commAnalogDemod.CommDemodTaskRequest.source_param', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='acq_param', full_name='zb.dcts.scenario.kh.commAnalogDemod.CommDemodTaskRequest.acq_param', index=2,
      number=3, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='channel', full_name='zb.dcts.scenario.kh.commAnalogDemod.CommDemodTaskRequest.channel', index=3,
      number=4, type=11, cpp_type=10, label=1,
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
  serialized_start=351,
  serialized_end=631,
)


_AUDIOBLOCK = _descriptor.Descriptor(
  name='AudioBlock',
  full_name='zb.dcts.scenario.kh.commAnalogDemod.AudioBlock',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='pcm_bitstream', full_name='zb.dcts.scenario.kh.commAnalogDemod.AudioBlock.pcm_bitstream', index=0,
      number=3, type=5, cpp_type=1, label=3,
      has_default_value=False, default_value=[],
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
  serialized_start=633,
  serialized_end=668,
)


_CHANNELAUDIO = _descriptor.Descriptor(
  name='ChannelAudio',
  full_name='zb.dcts.scenario.kh.commAnalogDemod.ChannelAudio',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='id', full_name='zb.dcts.scenario.kh.commAnalogDemod.ChannelAudio.id', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='blocks', full_name='zb.dcts.scenario.kh.commAnalogDemod.ChannelAudio.blocks', index=1,
      number=2, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
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
  serialized_start=670,
  serialized_end=761,
)


_COMMDEMODRESULT = _descriptor.Descriptor(
  name='CommDemodResult',
  full_name='zb.dcts.scenario.kh.commAnalogDemod.CommDemodResult',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='header', full_name='zb.dcts.scenario.kh.commAnalogDemod.CommDemodResult.header', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='channel_audio', full_name='zb.dcts.scenario.kh.commAnalogDemod.CommDemodResult.channel_audio', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='spectrum_views', full_name='zb.dcts.scenario.kh.commAnalogDemod.CommDemodResult.spectrum_views', index=2,
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
  serialized_start=764,
  serialized_end=963,
)


_CHANGECHANNELREQUEST = _descriptor.Descriptor(
  name='ChangeChannelRequest',
  full_name='zb.dcts.scenario.kh.commAnalogDemod.ChangeChannelRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='responser', full_name='zb.dcts.scenario.kh.commAnalogDemod.ChangeChannelRequest.responser', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='type', full_name='zb.dcts.scenario.kh.commAnalogDemod.ChangeChannelRequest.type', index=1,
      number=2, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='channel', full_name='zb.dcts.scenario.kh.commAnalogDemod.ChangeChannelRequest.channel', index=2,
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
  serialized_start=966,
  serialized_end=1174,
)

_DEMODCHANNEL.fields_by_name['signal_band'].message_type = scenario_dot_spectrum__pb2._SIGNALBAND
_DEMODCHANNEL.fields_by_name['demod_type'].enum_type = _DEMODTYPE
_COMMDEMODTASKREQUEST.fields_by_name['scenario'].message_type = scenario_dot_scenario__pb2._SCENARIOID
_COMMDEMODTASKREQUEST.fields_by_name['source_param'].message_type = scenario_dot_kh_dot_KhIQDataAcq__pb2._COMMIQACQSOURCE
_COMMDEMODTASKREQUEST.fields_by_name['acq_param'].message_type = scenario_dot_kh_dot_KhIQDataAcq__pb2._COMMIQACQUIREPARAM
_COMMDEMODTASKREQUEST.fields_by_name['channel'].message_type = _DEMODCHANNEL
_CHANNELAUDIO.fields_by_name['blocks'].message_type = _AUDIOBLOCK
_COMMDEMODRESULT.fields_by_name['header'].message_type = scenario_dot_spectrum__pb2._HEADER
_COMMDEMODRESULT.fields_by_name['channel_audio'].message_type = _CHANNELAUDIO
_COMMDEMODRESULT.fields_by_name['spectrum_views'].message_type = scenario_dot_spectrum__pb2._VIEW
_CHANGECHANNELREQUEST.fields_by_name['responser'].message_type = scenario_dot_scenario__pb2._SCENARIOTASKID
_CHANGECHANNELREQUEST.fields_by_name['type'].enum_type = scenario_dot_kh_dot_KhIQDataAcq__pb2._CHANGEREQUESTTYPE
_CHANGECHANNELREQUEST.fields_by_name['channel'].message_type = _DEMODCHANNEL
DESCRIPTOR.message_types_by_name['DemodChannel'] = _DEMODCHANNEL
DESCRIPTOR.message_types_by_name['CommDemodTaskRequest'] = _COMMDEMODTASKREQUEST
DESCRIPTOR.message_types_by_name['AudioBlock'] = _AUDIOBLOCK
DESCRIPTOR.message_types_by_name['ChannelAudio'] = _CHANNELAUDIO
DESCRIPTOR.message_types_by_name['CommDemodResult'] = _COMMDEMODRESULT
DESCRIPTOR.message_types_by_name['ChangeChannelRequest'] = _CHANGECHANNELREQUEST
DESCRIPTOR.enum_types_by_name['DemodType'] = _DEMODTYPE
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

DemodChannel = _reflection.GeneratedProtocolMessageType('DemodChannel', (_message.Message,), {
  'DESCRIPTOR' : _DEMODCHANNEL,
  '__module__' : 'scenario.kh.KhAnalogDemod_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commAnalogDemod.DemodChannel)
  })
_sym_db.RegisterMessage(DemodChannel)

CommDemodTaskRequest = _reflection.GeneratedProtocolMessageType('CommDemodTaskRequest', (_message.Message,), {
  'DESCRIPTOR' : _COMMDEMODTASKREQUEST,
  '__module__' : 'scenario.kh.KhAnalogDemod_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commAnalogDemod.CommDemodTaskRequest)
  })
_sym_db.RegisterMessage(CommDemodTaskRequest)

AudioBlock = _reflection.GeneratedProtocolMessageType('AudioBlock', (_message.Message,), {
  'DESCRIPTOR' : _AUDIOBLOCK,
  '__module__' : 'scenario.kh.KhAnalogDemod_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commAnalogDemod.AudioBlock)
  })
_sym_db.RegisterMessage(AudioBlock)

ChannelAudio = _reflection.GeneratedProtocolMessageType('ChannelAudio', (_message.Message,), {
  'DESCRIPTOR' : _CHANNELAUDIO,
  '__module__' : 'scenario.kh.KhAnalogDemod_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commAnalogDemod.ChannelAudio)
  })
_sym_db.RegisterMessage(ChannelAudio)

CommDemodResult = _reflection.GeneratedProtocolMessageType('CommDemodResult', (_message.Message,), {
  'DESCRIPTOR' : _COMMDEMODRESULT,
  '__module__' : 'scenario.kh.KhAnalogDemod_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commAnalogDemod.CommDemodResult)
  })
_sym_db.RegisterMessage(CommDemodResult)

ChangeChannelRequest = _reflection.GeneratedProtocolMessageType('ChangeChannelRequest', (_message.Message,), {
  'DESCRIPTOR' : _CHANGECHANNELREQUEST,
  '__module__' : 'scenario.kh.KhAnalogDemod_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commAnalogDemod.ChangeChannelRequest)
  })
_sym_db.RegisterMessage(ChangeChannelRequest)



_ANALOGDEMODSERVICE = _descriptor.ServiceDescriptor(
  name='AnalogDemodService',
  full_name='zb.dcts.scenario.kh.commAnalogDemod.AnalogDemodService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_start=1278,
  serialized_end=1702,
  methods=[
  _descriptor.MethodDescriptor(
    name='StartTask',
    full_name='zb.dcts.scenario.kh.commAnalogDemod.AnalogDemodService.StartTask',
    index=0,
    containing_service=None,
    input_type=_COMMDEMODTASKREQUEST,
    output_type=scenario_dot_scenario__pb2._SCENARIOREPLY,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='GetResult',
    full_name='zb.dcts.scenario.kh.commAnalogDemod.AnalogDemodService.GetResult',
    index=1,
    containing_service=None,
    input_type=scenario_dot_scenario__pb2._SCENARIOTASKID,
    output_type=_COMMDEMODRESULT,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='ChangeChannel',
    full_name='zb.dcts.scenario.kh.commAnalogDemod.AnalogDemodService.ChangeChannel',
    index=2,
    containing_service=None,
    input_type=_CHANGECHANNELREQUEST,
    output_type=scenario_dot_scenario__pb2._SCENARIOREPLY,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='StopTask',
    full_name='zb.dcts.scenario.kh.commAnalogDemod.AnalogDemodService.StopTask',
    index=3,
    containing_service=None,
    input_type=scenario_dot_scenario__pb2._SCENARIOTASKID,
    output_type=scenario_dot_scenario__pb2._SCENARIOREPLY,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
])
_sym_db.RegisterServiceDescriptor(_ANALOGDEMODSERVICE)

DESCRIPTOR.services_by_name['AnalogDemodService'] = _ANALOGDEMODSERVICE

# @@protoc_insertion_point(module_scope)
