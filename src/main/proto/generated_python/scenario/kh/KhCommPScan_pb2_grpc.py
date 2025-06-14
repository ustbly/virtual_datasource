# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

from scenario import detection_pb2 as scenario_dot_detection__pb2
from scenario.kh import KhCommPScan_pb2 as scenario_dot_kh_dot_KhCommPScan__pb2
from scenario import scenario_pb2 as scenario_dot_scenario__pb2
from scenario import spectrum_pb2 as scenario_dot_spectrum__pb2


class CommPScanServiceStub(object):
    """Missing associated documentation comment in .proto file"""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.CreateScenario = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/CreateScenario',
                request_serializer=scenario_dot_kh_dot_KhCommPScan__pb2.CommPScanCreateScenarioRequest.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )
        self.GetPScanResult = channel.unary_stream(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/GetPScanResult',
                request_serializer=scenario_dot_scenario__pb2.ScenarioTaskId.SerializeToString,
                response_deserializer=scenario_dot_kh_dot_KhCommPScan__pb2.CommPScanResult.FromString,
                )
        self.CloseScenario = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/CloseScenario',
                request_serializer=scenario_dot_scenario__pb2.ScenarioId.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )
        self.OpenZoomIn = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/OpenZoomIn',
                request_serializer=scenario_dot_spectrum__pb2.ZoomInRequest.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )
        self.CloseZoomIn = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/CloseZoomIn',
                request_serializer=scenario_dot_scenario__pb2.ScenarioTaskId.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )
        self.OpenDataHold = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/OpenDataHold',
                request_serializer=scenario_dot_spectrum__pb2.DataHoldRequest.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )
        self.ResetDataHold = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/ResetDataHold',
                request_serializer=scenario_dot_spectrum__pb2.DataHoldRequest.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )
        self.CloseDataHold = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/CloseDataHold',
                request_serializer=scenario_dot_spectrum__pb2.DataHoldRequest.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )
        self.OpenDetection = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/OpenDetection',
                request_serializer=scenario_dot_detection__pb2.DetectionRequest.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )
        self.CloseDetection = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/CloseDetection',
                request_serializer=scenario_dot_scenario__pb2.ScenarioTaskId.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )
        self.QuerySignalTable = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/QuerySignalTable',
                request_serializer=scenario_dot_detection__pb2.SignalTableQueryRequest.SerializeToString,
                response_deserializer=scenario_dot_detection__pb2.SignalTableQueryResponse.FromString,
                )
        self.ClearSignalTable = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/ClearSignalTable',
                request_serializer=scenario_dot_scenario__pb2.ScenarioTaskId.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )
        self.SignalGathering = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/SignalGathering',
                request_serializer=scenario_dot_detection__pb2.SignalGatheringRequest.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )
        self.GetGatheringResult = channel.unary_unary(
                '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/GetGatheringResult',
                request_serializer=scenario_dot_scenario__pb2.ScenarioTaskId.SerializeToString,
                response_deserializer=scenario_dot_detection__pb2.SignalSampleList.FromString,
                )


class CommPScanServiceServicer(object):
    """Missing associated documentation comment in .proto file"""

    def CreateScenario(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def GetPScanResult(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def CloseScenario(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def OpenZoomIn(self, request, context):
        """-----zoomin/datahold/detection-----
        """
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def CloseZoomIn(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def OpenDataHold(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def ResetDataHold(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def CloseDataHold(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def OpenDetection(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def CloseDetection(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def QuerySignalTable(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def ClearSignalTable(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def SignalGathering(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def GetGatheringResult(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_CommPScanServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'CreateScenario': grpc.unary_unary_rpc_method_handler(
                    servicer.CreateScenario,
                    request_deserializer=scenario_dot_kh_dot_KhCommPScan__pb2.CommPScanCreateScenarioRequest.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
            'GetPScanResult': grpc.unary_stream_rpc_method_handler(
                    servicer.GetPScanResult,
                    request_deserializer=scenario_dot_scenario__pb2.ScenarioTaskId.FromString,
                    response_serializer=scenario_dot_kh_dot_KhCommPScan__pb2.CommPScanResult.SerializeToString,
            ),
            'CloseScenario': grpc.unary_unary_rpc_method_handler(
                    servicer.CloseScenario,
                    request_deserializer=scenario_dot_scenario__pb2.ScenarioId.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
            'OpenZoomIn': grpc.unary_unary_rpc_method_handler(
                    servicer.OpenZoomIn,
                    request_deserializer=scenario_dot_spectrum__pb2.ZoomInRequest.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
            'CloseZoomIn': grpc.unary_unary_rpc_method_handler(
                    servicer.CloseZoomIn,
                    request_deserializer=scenario_dot_scenario__pb2.ScenarioTaskId.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
            'OpenDataHold': grpc.unary_unary_rpc_method_handler(
                    servicer.OpenDataHold,
                    request_deserializer=scenario_dot_spectrum__pb2.DataHoldRequest.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
            'ResetDataHold': grpc.unary_unary_rpc_method_handler(
                    servicer.ResetDataHold,
                    request_deserializer=scenario_dot_spectrum__pb2.DataHoldRequest.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
            'CloseDataHold': grpc.unary_unary_rpc_method_handler(
                    servicer.CloseDataHold,
                    request_deserializer=scenario_dot_spectrum__pb2.DataHoldRequest.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
            'OpenDetection': grpc.unary_unary_rpc_method_handler(
                    servicer.OpenDetection,
                    request_deserializer=scenario_dot_detection__pb2.DetectionRequest.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
            'CloseDetection': grpc.unary_unary_rpc_method_handler(
                    servicer.CloseDetection,
                    request_deserializer=scenario_dot_scenario__pb2.ScenarioTaskId.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
            'QuerySignalTable': grpc.unary_unary_rpc_method_handler(
                    servicer.QuerySignalTable,
                    request_deserializer=scenario_dot_detection__pb2.SignalTableQueryRequest.FromString,
                    response_serializer=scenario_dot_detection__pb2.SignalTableQueryResponse.SerializeToString,
            ),
            'ClearSignalTable': grpc.unary_unary_rpc_method_handler(
                    servicer.ClearSignalTable,
                    request_deserializer=scenario_dot_scenario__pb2.ScenarioTaskId.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
            'SignalGathering': grpc.unary_unary_rpc_method_handler(
                    servicer.SignalGathering,
                    request_deserializer=scenario_dot_detection__pb2.SignalGatheringRequest.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
            'GetGatheringResult': grpc.unary_unary_rpc_method_handler(
                    servicer.GetGatheringResult,
                    request_deserializer=scenario_dot_scenario__pb2.ScenarioTaskId.FromString,
                    response_serializer=scenario_dot_detection__pb2.SignalSampleList.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'zb.dcts.scenario.kh.commSpectrum.CommPScanService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class CommPScanService(object):
    """Missing associated documentation comment in .proto file"""

    @staticmethod
    def CreateScenario(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/CreateScenario',
            scenario_dot_kh_dot_KhCommPScan__pb2.CommPScanCreateScenarioRequest.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def GetPScanResult(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_stream(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/GetPScanResult',
            scenario_dot_scenario__pb2.ScenarioTaskId.SerializeToString,
            scenario_dot_kh_dot_KhCommPScan__pb2.CommPScanResult.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def CloseScenario(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/CloseScenario',
            scenario_dot_scenario__pb2.ScenarioId.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def OpenZoomIn(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/OpenZoomIn',
            scenario_dot_spectrum__pb2.ZoomInRequest.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def CloseZoomIn(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/CloseZoomIn',
            scenario_dot_scenario__pb2.ScenarioTaskId.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def OpenDataHold(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/OpenDataHold',
            scenario_dot_spectrum__pb2.DataHoldRequest.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def ResetDataHold(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/ResetDataHold',
            scenario_dot_spectrum__pb2.DataHoldRequest.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def CloseDataHold(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/CloseDataHold',
            scenario_dot_spectrum__pb2.DataHoldRequest.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def OpenDetection(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/OpenDetection',
            scenario_dot_detection__pb2.DetectionRequest.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def CloseDetection(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/CloseDetection',
            scenario_dot_scenario__pb2.ScenarioTaskId.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def QuerySignalTable(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/QuerySignalTable',
            scenario_dot_detection__pb2.SignalTableQueryRequest.SerializeToString,
            scenario_dot_detection__pb2.SignalTableQueryResponse.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def ClearSignalTable(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/ClearSignalTable',
            scenario_dot_scenario__pb2.ScenarioTaskId.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def SignalGathering(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/SignalGathering',
            scenario_dot_detection__pb2.SignalGatheringRequest.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def GetGatheringResult(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.kh.commSpectrum.CommPScanService/GetGatheringResult',
            scenario_dot_scenario__pb2.ScenarioTaskId.SerializeToString,
            scenario_dot_detection__pb2.SignalSampleList.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)
