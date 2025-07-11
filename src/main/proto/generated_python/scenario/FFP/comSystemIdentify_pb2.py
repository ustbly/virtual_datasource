# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: scenario/FFP/comSystemIdentify.proto

from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


import dcts_pb2 as dcts__pb2
from source import source_pb2 as source_dot_source__pb2
from scenario import scenario_pb2 as scenario_dot_scenario__pb2
from scenario import spectrum_pb2 as scenario_dot_spectrum__pb2


DESCRIPTOR = _descriptor.FileDescriptor(
  name='scenario/FFP/comSystemIdentify.proto',
  package='zb.dcts.scenario.FFP',
  syntax='proto3',
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_pb=b'\n$scenario/FFP/comSystemIdentify.proto\x12\x14zb.dcts.scenario.FFP\x1a\ndcts.proto\x1a\x13source/source.proto\x1a\x17scenario/scenario.proto\x1a\x17scenario/spectrum.proto\"s\n\x0f\x43omSystemSource\x12$\n\x02id\x18\x01 \x01(\x0b\x32\x18.zb.dcts.source.SourceId\x12\x0f\n\x07\x61\x64\x64ress\x18\x02 \x01(\t\x12\x18\n\x10\x61ttenuation_gain\x18\x03 \x01(\x05\x12\x0f\n\x07\x61ntenna\x18\x04 \x01(\x05\"B\n\x0e\x43omSystemParam\x12\x30\n\x04\x62\x61nk\x18\x03 \x01(\x0b\x32\".zb.dcts.scenario.spectrum.DDCBank\"\xbf\x03\n\x17\x43omSystemIdentifyResult\x12\x44\n\x06header\x18\x01 \x01(\x0b\x32\x34.zb.dcts.scenario.FFP.ComSystemIdentifyResult.Header\x12I\n\x04type\x18\x02 \x01(\x0e\x32;.zb.dcts.scenario.FFP.ComSystemIdentifyResult.ComSystemType\x12\x18\n\x10spectrum_samples\x18\x03 \x03(\x02\x1a\xa2\x01\n\x06Header\x12-\n\x0bresult_from\x18\x01 \x01(\x0b\x32\x18.zb.dcts.source.SourceId\x12\x17\n\x0fsequence_number\x18\x02 \x01(\r\x12$\n\ttime_span\x18\x03 \x01(\x0b\x32\x11.zb.dcts.TimeSpan\x12*\n\x0f\x64\x65vice_position\x18\x04 \x01(\x0b\x32\x11.zb.dcts.Position\"T\n\rComSystemType\x12\x0b\n\x07UNKNOWN\x10\x00\x12\x07\n\x03\x44ME\x10\x01\x12\t\n\x05TACAN\x10\x02\x12\n\n\x06Link4A\x10\x03\x12\n\n\x06Link11\x10\x04\x12\n\n\x06Link16\x10\x05\"\xae\x01\n\x10\x43omSystemRequest\x12.\n\x08scenario\x18\x01 \x01(\x0b\x32\x1c.zb.dcts.scenario.ScenarioId\x12\x35\n\x06source\x18\x02 \x01(\x0b\x32%.zb.dcts.scenario.FFP.ComSystemSource\x12\x33\n\x05param\x18\x03 \x01(\x0b\x32$.zb.dcts.scenario.FFP.ComSystemParam2\xe5\x01\n\x18\x43omSystemIdentifyService\x12g\n\x1aStartComSystemIdentifyTask\x12&.zb.dcts.scenario.FFP.ComSystemRequest\x1a\x1f.zb.dcts.scenario.ScenarioReply\"\x00\x12`\n\x19StopComSystemIdentifyTask\x12 .zb.dcts.scenario.ScenarioTaskId\x1a\x1f.zb.dcts.scenario.ScenarioReply\"\x00\x62\x06proto3'
  ,
  dependencies=[dcts__pb2.DESCRIPTOR,source_dot_source__pb2.DESCRIPTOR,scenario_dot_scenario__pb2.DESCRIPTOR,scenario_dot_spectrum__pb2.DESCRIPTOR,])



_COMSYSTEMIDENTIFYRESULT_COMSYSTEMTYPE = _descriptor.EnumDescriptor(
  name='ComSystemType',
  full_name='zb.dcts.scenario.FFP.ComSystemIdentifyResult.ComSystemType',
  filename=None,
  file=DESCRIPTOR,
  create_key=_descriptor._internal_create_key,
  values=[
    _descriptor.EnumValueDescriptor(
      name='UNKNOWN', index=0, number=0,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='DME', index=1, number=1,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='TACAN', index=2, number=2,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='Link4A', index=3, number=3,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='Link11', index=4, number=4,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
    _descriptor.EnumValueDescriptor(
      name='Link16', index=5, number=5,
      serialized_options=None,
      type=None,
      create_key=_descriptor._internal_create_key),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=694,
  serialized_end=778,
)
_sym_db.RegisterEnumDescriptor(_COMSYSTEMIDENTIFYRESULT_COMSYSTEMTYPE)


_COMSYSTEMSOURCE = _descriptor.Descriptor(
  name='ComSystemSource',
  full_name='zb.dcts.scenario.FFP.ComSystemSource',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='id', full_name='zb.dcts.scenario.FFP.ComSystemSource.id', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='address', full_name='zb.dcts.scenario.FFP.ComSystemSource.address', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='attenuation_gain', full_name='zb.dcts.scenario.FFP.ComSystemSource.attenuation_gain', index=2,
      number=3, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='antenna', full_name='zb.dcts.scenario.FFP.ComSystemSource.antenna', index=3,
      number=4, type=5, cpp_type=1, label=1,
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
  serialized_start=145,
  serialized_end=260,
)


_COMSYSTEMPARAM = _descriptor.Descriptor(
  name='ComSystemParam',
  full_name='zb.dcts.scenario.FFP.ComSystemParam',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='bank', full_name='zb.dcts.scenario.FFP.ComSystemParam.bank', index=0,
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
  serialized_start=262,
  serialized_end=328,
)


_COMSYSTEMIDENTIFYRESULT_HEADER = _descriptor.Descriptor(
  name='Header',
  full_name='zb.dcts.scenario.FFP.ComSystemIdentifyResult.Header',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='result_from', full_name='zb.dcts.scenario.FFP.ComSystemIdentifyResult.Header.result_from', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='sequence_number', full_name='zb.dcts.scenario.FFP.ComSystemIdentifyResult.Header.sequence_number', index=1,
      number=2, type=13, cpp_type=3, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='time_span', full_name='zb.dcts.scenario.FFP.ComSystemIdentifyResult.Header.time_span', index=2,
      number=3, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='device_position', full_name='zb.dcts.scenario.FFP.ComSystemIdentifyResult.Header.device_position', index=3,
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
  serialized_start=530,
  serialized_end=692,
)

_COMSYSTEMIDENTIFYRESULT = _descriptor.Descriptor(
  name='ComSystemIdentifyResult',
  full_name='zb.dcts.scenario.FFP.ComSystemIdentifyResult',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='header', full_name='zb.dcts.scenario.FFP.ComSystemIdentifyResult.header', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='type', full_name='zb.dcts.scenario.FFP.ComSystemIdentifyResult.type', index=1,
      number=2, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='spectrum_samples', full_name='zb.dcts.scenario.FFP.ComSystemIdentifyResult.spectrum_samples', index=2,
      number=3, type=2, cpp_type=6, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[_COMSYSTEMIDENTIFYRESULT_HEADER, ],
  enum_types=[
    _COMSYSTEMIDENTIFYRESULT_COMSYSTEMTYPE,
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=331,
  serialized_end=778,
)


_COMSYSTEMREQUEST = _descriptor.Descriptor(
  name='ComSystemRequest',
  full_name='zb.dcts.scenario.FFP.ComSystemRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='scenario', full_name='zb.dcts.scenario.FFP.ComSystemRequest.scenario', index=0,
      number=1, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='source', full_name='zb.dcts.scenario.FFP.ComSystemRequest.source', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='param', full_name='zb.dcts.scenario.FFP.ComSystemRequest.param', index=2,
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
  serialized_start=781,
  serialized_end=955,
)

_COMSYSTEMSOURCE.fields_by_name['id'].message_type = source_dot_source__pb2._SOURCEID
_COMSYSTEMPARAM.fields_by_name['bank'].message_type = scenario_dot_spectrum__pb2._DDCBANK
_COMSYSTEMIDENTIFYRESULT_HEADER.fields_by_name['result_from'].message_type = source_dot_source__pb2._SOURCEID
_COMSYSTEMIDENTIFYRESULT_HEADER.fields_by_name['time_span'].message_type = dcts__pb2._TIMESPAN
_COMSYSTEMIDENTIFYRESULT_HEADER.fields_by_name['device_position'].message_type = dcts__pb2._POSITION
_COMSYSTEMIDENTIFYRESULT_HEADER.containing_type = _COMSYSTEMIDENTIFYRESULT
_COMSYSTEMIDENTIFYRESULT.fields_by_name['header'].message_type = _COMSYSTEMIDENTIFYRESULT_HEADER
_COMSYSTEMIDENTIFYRESULT.fields_by_name['type'].enum_type = _COMSYSTEMIDENTIFYRESULT_COMSYSTEMTYPE
_COMSYSTEMIDENTIFYRESULT_COMSYSTEMTYPE.containing_type = _COMSYSTEMIDENTIFYRESULT
_COMSYSTEMREQUEST.fields_by_name['scenario'].message_type = scenario_dot_scenario__pb2._SCENARIOID
_COMSYSTEMREQUEST.fields_by_name['source'].message_type = _COMSYSTEMSOURCE
_COMSYSTEMREQUEST.fields_by_name['param'].message_type = _COMSYSTEMPARAM
DESCRIPTOR.message_types_by_name['ComSystemSource'] = _COMSYSTEMSOURCE
DESCRIPTOR.message_types_by_name['ComSystemParam'] = _COMSYSTEMPARAM
DESCRIPTOR.message_types_by_name['ComSystemIdentifyResult'] = _COMSYSTEMIDENTIFYRESULT
DESCRIPTOR.message_types_by_name['ComSystemRequest'] = _COMSYSTEMREQUEST
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

ComSystemSource = _reflection.GeneratedProtocolMessageType('ComSystemSource', (_message.Message,), {
  'DESCRIPTOR' : _COMSYSTEMSOURCE,
  '__module__' : 'scenario.FFP.comSystemIdentify_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.FFP.ComSystemSource)
  })
_sym_db.RegisterMessage(ComSystemSource)

ComSystemParam = _reflection.GeneratedProtocolMessageType('ComSystemParam', (_message.Message,), {
  'DESCRIPTOR' : _COMSYSTEMPARAM,
  '__module__' : 'scenario.FFP.comSystemIdentify_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.FFP.ComSystemParam)
  })
_sym_db.RegisterMessage(ComSystemParam)

ComSystemIdentifyResult = _reflection.GeneratedProtocolMessageType('ComSystemIdentifyResult', (_message.Message,), {

  'Header' : _reflection.GeneratedProtocolMessageType('Header', (_message.Message,), {
    'DESCRIPTOR' : _COMSYSTEMIDENTIFYRESULT_HEADER,
    '__module__' : 'scenario.FFP.comSystemIdentify_pb2'
    # @@protoc_insertion_point(class_scope:zb.dcts.scenario.FFP.ComSystemIdentifyResult.Header)
    })
  ,
  'DESCRIPTOR' : _COMSYSTEMIDENTIFYRESULT,
  '__module__' : 'scenario.FFP.comSystemIdentify_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.FFP.ComSystemIdentifyResult)
  })
_sym_db.RegisterMessage(ComSystemIdentifyResult)
_sym_db.RegisterMessage(ComSystemIdentifyResult.Header)

ComSystemRequest = _reflection.GeneratedProtocolMessageType('ComSystemRequest', (_message.Message,), {
  'DESCRIPTOR' : _COMSYSTEMREQUEST,
  '__module__' : 'scenario.FFP.comSystemIdentify_pb2'
  # @@protoc_insertion_point(class_scope:zb.dcts.scenario.FFP.ComSystemRequest)
  })
_sym_db.RegisterMessage(ComSystemRequest)



_COMSYSTEMIDENTIFYSERVICE = _descriptor.ServiceDescriptor(
  name='ComSystemIdentifyService',
  full_name='zb.dcts.scenario.FFP.ComSystemIdentifyService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_start=958,
  serialized_end=1187,
  methods=[
  _descriptor.MethodDescriptor(
    name='StartComSystemIdentifyTask',
    full_name='zb.dcts.scenario.FFP.ComSystemIdentifyService.StartComSystemIdentifyTask',
    index=0,
    containing_service=None,
    input_type=_COMSYSTEMREQUEST,
    output_type=scenario_dot_scenario__pb2._SCENARIOREPLY,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
  _descriptor.MethodDescriptor(
    name='StopComSystemIdentifyTask',
    full_name='zb.dcts.scenario.FFP.ComSystemIdentifyService.StopComSystemIdentifyTask',
    index=1,
    containing_service=None,
    input_type=scenario_dot_scenario__pb2._SCENARIOTASKID,
    output_type=scenario_dot_scenario__pb2._SCENARIOREPLY,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
])
_sym_db.RegisterServiceDescriptor(_COMSYSTEMIDENTIFYSERVICE)

DESCRIPTOR.services_by_name['ComSystemIdentifyService'] = _COMSYSTEMIDENTIFYSERVICE

# @@protoc_insertion_point(module_scope)
