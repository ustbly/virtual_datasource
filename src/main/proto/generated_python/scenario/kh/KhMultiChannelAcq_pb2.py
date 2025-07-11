# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: scenario/kh/KhMultiChannelAcq.proto

from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


import dcts_pb2 as dcts__pb2
from source import source_pb2 as source_dot_source__pb2
from scenario.kh import KhSpectrumAcq_pb2 as scenario_dot_kh_dot_KhSpectrumAcq__pb2
from scenario.FFP import demodulate_pb2 as scenario_dot_FFP_dot_demodulate__pb2


DESCRIPTOR = _descriptor.FileDescriptor(
  name='scenario/kh/KhMultiChannelAcq.proto',
  package='zb.dcts.scenario.kh.commMultiChannel',
  syntax='proto3',
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_pb=b'\n#scenario/kh/KhMultiChannelAcq.proto\x12$zb.dcts.scenario.kh.commMultiChannel\x1a\ndcts.proto\x1a\x13source/source.proto\x1a\x1fscenario/kh/KhSpectrumAcq.proto\x1a\x1dscenario/FFP/demodulate.proto\"\xb3\x01\n\rNarrowChannel\x12\x12\n\nchannel_id\x18\x01 \x01(\x05\x12\r\n\x05width\x18\x02 \x01(\x01\x12\x11\n\tcent_freq\x18\x03 \x01(\x01\x12\x0b\n\x03run\x18\x04 \x01(\x08\x12\x0b\n\x03\x66\x66t\x18\x05 \x01(\x08\x12\r\n\x05\x64\x65mod\x18\x06 \x01(\x08\x12\x31\n\x04type\x18\x07 \x01(\x0e\x32#.zb.dcts.scenario.FFP.AnalogModType\x12\x10\n\x08\x61udio_sr\x18\x08 \x01(\x01\"\x99\x01\n\rMultiAcqParam\x12\x41\n\x05\x62road\x18\x01 \x01(\x0b\x32\x32.zb.dcts.scenario.kh.commSpectrum.SpectrumAcqParam\x12\x45\n\x08\x63hannels\x18\x02 \x03(\x0b\x32\x33.zb.dcts.scenario.kh.commMultiChannel.NarrowChannel\"\xbe\x01\n\x10\x43hannelIQDataDev\x12\x12\n\nchannel_id\x18\x02 \x01(\x05\x12\x11\n\tsignal_id\x18\x03 \x01(\x05\x12\x11\n\tcent_freq\x18\x04 \x01(\x01\x12\x0e\n\x06status\x18\x05 \x01(\x05\x12\x11\n\tsamp_rate\x18\x06 \x01(\x01\x12&\n\ntime_stamp\x18\x07 \x01(\x0b\x32\x12.zb.dcts.Timestamp\x12\x0f\n\x07\x64\x61ta_iq\x18\x08 \x03(\r\x12\x14\n\x0chopping_freq\x18\n \x01(\x01\"\xb3\x03\n\x0eMultiAcqResult\x12Q\n\x06header\x18\x01 \x01(\x0b\x32\x41.zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.ResultHeader\x12\x10\n\x08spectrum\x18\x02 \x03(\x02\x12L\n\x0c\x63hannel_data\x18\x03 \x03(\x0b\x32\x36.zb.dcts.scenario.kh.commMultiChannel.ChannelIQDataDev\x1a\xed\x01\n\x0cResultHeader\x12-\n\x0bresult_from\x18\x01 \x01(\x0b\x32\x18.zb.dcts.source.SourceId\x12\x17\n\x0fsequence_number\x18\x02 \x01(\r\x12&\n\ntime_stamp\x18\x03 \x01(\x0b\x32\x12.zb.dcts.Timestamp\x12*\n\x0f\x64\x65vice_position\x18\x04 \x01(\x0b\x32\x11.zb.dcts.Position\x12\x11\n\tcent_freq\x18\x05 \x01(\x01\x12\x11\n\tsamp_rate\x18\x06 \x01(\x01\x12\x0b\n\x03qtz\x18\x08 \x01(\x01\x12\x0e\n\x06spanIF\x18\t \x01(\x01\x62\x06proto3'
  ,
  dependencies=[dcts__pb2.DESCRIPTOR,source_dot_source__pb2.DESCRIPTOR,scenario_dot_kh_dot_KhSpectrumAcq__pb2.DESCRIPTOR,scenario_dot_FFP_dot_demodulate__pb2.DESCRIPTOR,])




_NARROWCHANNEL = _descriptor.Descriptor(
  name='NarrowChannel',
  full_name='zb.dcts.scenario.kh.commMultiChannel.NarrowChannel',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='channel_id', full_name='zb.dcts.scenario.kh.commMultiChannel.NarrowChannel.channel_id', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='width', full_name='zb.dcts.scenario.kh.commMultiChannel.NarrowChannel.width', index=1,
      number=2, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='cent_freq', full_name='zb.dcts.scenario.kh.commMultiChannel.NarrowChannel.cent_freq', index=2,
      number=3, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='run', full_name='zb.dcts.scenario.kh.commMultiChannel.NarrowChannel.run', index=3,
      number=4, type=8, cpp_type=7, label=1,
      has_default_value=False, default_value=False,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='fft', full_name='zb.dcts.scenario.kh.commMultiChannel.NarrowChannel.fft', index=4,
      number=5, type=8, cpp_type=7, label=1,
      has_default_value=False, default_value=False,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='demod', full_name='zb.dcts.scenario.kh.commMultiChannel.NarrowChannel.demod', index=5,
      number=6, type=8, cpp_type=7, label=1,
      has_default_value=False, default_value=False,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='type', full_name='zb.dcts.scenario.kh.commMultiChannel.NarrowChannel.type', index=6,
      number=7, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='audio_sr', full_name='zb.dcts.scenario.kh.commMultiChannel.NarrowChannel.audio_sr', index=7,
      number=8, type=1, cpp_type=5, label=1,
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
  serialized_start=175,
  serialized_end=354,
)


_MULTIACQPARAM = _descriptor.Descriptor(
  name='MultiAcqParam',
  full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqParam',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='broad', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqParam.broad', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='channels', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqParam.channels', index=1,
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
  serialized_start=357,
  serialized_end=510,
)


_CHANNELIQDATADEV = _descriptor.Descriptor(
  name='ChannelIQDataDev',
  full_name='zb.dcts.scenario.kh.commMultiChannel.ChannelIQDataDev',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='channel_id', full_name='zb.dcts.scenario.kh.commMultiChannel.ChannelIQDataDev.channel_id', index=0,
      number=2, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='signal_id', full_name='zb.dcts.scenario.kh.commMultiChannel.ChannelIQDataDev.signal_id', index=1,
      number=3, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='cent_freq', full_name='zb.dcts.scenario.kh.commMultiChannel.ChannelIQDataDev.cent_freq', index=2,
      number=4, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='status', full_name='zb.dcts.scenario.kh.commMultiChannel.ChannelIQDataDev.status', index=3,
      number=5, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='samp_rate', full_name='zb.dcts.scenario.kh.commMultiChannel.ChannelIQDataDev.samp_rate', index=4,
      number=6, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='time_stamp', full_name='zb.dcts.scenario.kh.commMultiChannel.ChannelIQDataDev.time_stamp', index=5,
      number=7, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='data_iq', full_name='zb.dcts.scenario.kh.commMultiChannel.ChannelIQDataDev.data_iq', index=6,
      number=8, type=13, cpp_type=3, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='hopping_freq', full_name='zb.dcts.scenario.kh.commMultiChannel.ChannelIQDataDev.hopping_freq', index=7,
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
  serialized_start=513,
  serialized_end=703,
)


_MULTIACQRESULT_RESULTHEADER = _descriptor.Descriptor(
  name='ResultHeader',
  full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.ResultHeader',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='result_from', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.ResultHeader.result_from', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='sequence_number', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.ResultHeader.sequence_number', index=1,
      number=2, type=13, cpp_type=3, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='time_stamp', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.ResultHeader.time_stamp', index=2,
      number=3, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='device_position', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.ResultHeader.device_position', index=3,
      number=4, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='cent_freq', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.ResultHeader.cent_freq', index=4,
      number=5, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='samp_rate', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.ResultHeader.samp_rate', index=5,
      number=6, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='qtz', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.ResultHeader.qtz', index=6,
      number=8, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='spanIF', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.ResultHeader.spanIF', index=7,
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
  serialized_start=904,
  serialized_end=1141,
)

_MULTIACQRESULT = _descriptor.Descriptor(
  name='MultiAcqResult',
  full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='header', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.header', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='spectrum', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.spectrum', index=1,
      number=2, type=2, cpp_type=6, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='channel_data', full_name='zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.channel_data', index=2,
      number=3, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[_MULTIACQRESULT_RESULTHEADER, ],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=706,
  serialized_end=1141,
)

_NARROWCHANNEL.fields_by_name['type'].enum_type = scenario_dot_FFP_dot_demodulate__pb2._ANALOGMODTYPE
_MULTIACQPARAM.fields_by_name['broad'].message_type = scenario_dot_kh_dot_KhSpectrumAcq__pb2._SPECTRUMACQPARAM
_MULTIACQPARAM.fields_by_name['channels'].message_type = _NARROWCHANNEL
_CHANNELIQDATADEV.fields_by_name['time_stamp'].message_type = dcts__pb2._TIMESTAMP
_MULTIACQRESULT_RESULTHEADER.fields_by_name['result_from'].message_type = source_dot_source__pb2._SOURCEID
_MULTIACQRESULT_RESULTHEADER.fields_by_name['time_stamp'].message_type = dcts__pb2._TIMESTAMP
_MULTIACQRESULT_RESULTHEADER.fields_by_name['device_position'].message_type = dcts__pb2._POSITION
_MULTIACQRESULT_RESULTHEADER.containing_type = _MULTIACQRESULT
_MULTIACQRESULT.fields_by_name['header'].message_type = _MULTIACQRESULT_RESULTHEADER
_MULTIACQRESULT.fields_by_name['channel_data'].message_type = _CHANNELIQDATADEV
DESCRIPTOR.message_types_by_name['NarrowChannel'] = _NARROWCHANNEL
DESCRIPTOR.message_types_by_name['MultiAcqParam'] = _MULTIACQPARAM
DESCRIPTOR.message_types_by_name['ChannelIQDataDev'] = _CHANNELIQDATADEV
DESCRIPTOR.message_types_by_name['MultiAcqResult'] = _MULTIACQRESULT
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

NarrowChannel = _reflection.GeneratedProtocolMessageType('NarrowChannel', (_message.Message,), {
  'DESCRIPTOR' : _NARROWCHANNEL,
  '__module__' : 'scenario.kh.KhMultiChannelAcq_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commMultiChannel.NarrowChannel)
  })
_sym_db.RegisterMessage(NarrowChannel)

MultiAcqParam = _reflection.GeneratedProtocolMessageType('MultiAcqParam', (_message.Message,), {
  'DESCRIPTOR' : _MULTIACQPARAM,
  '__module__' : 'scenario.kh.KhMultiChannelAcq_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commMultiChannel.MultiAcqParam)
  })
_sym_db.RegisterMessage(MultiAcqParam)

ChannelIQDataDev = _reflection.GeneratedProtocolMessageType('ChannelIQDataDev', (_message.Message,), {
  'DESCRIPTOR' : _CHANNELIQDATADEV,
  '__module__' : 'scenario.kh.KhMultiChannelAcq_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commMultiChannel.ChannelIQDataDev)
  })
_sym_db.RegisterMessage(ChannelIQDataDev)

MultiAcqResult = _reflection.GeneratedProtocolMessageType('MultiAcqResult', (_message.Message,), {

  'ResultHeader' : _reflection.GeneratedProtocolMessageType('ResultHeader', (_message.Message,), {
    'DESCRIPTOR' : _MULTIACQRESULT_RESULTHEADER,
    '__module__' : 'scenario.kh.KhMultiChannelAcq_pb2'
    # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult.ResultHeader)
    })
  ,
  'DESCRIPTOR' : _MULTIACQRESULT,
  '__module__' : 'scenario.kh.KhMultiChannelAcq_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.kh.commMultiChannel.MultiAcqResult)
  })
_sym_db.RegisterMessage(MultiAcqResult)
_sym_db.RegisterMessage(MultiAcqResult.ResultHeader)


# @@protoc_insertion_point(module_scope)
