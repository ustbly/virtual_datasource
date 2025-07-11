# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

from scenario import auto_pb2 as scenario_dot_auto__pb2
from scenario import scenario_pb2 as scenario_dot_scenario__pb2


class AutoScenarioServiceStub(object):
    """3. 观察原始测量数据开启或关闭
    不带参数

    """

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.CreateAutoMCPScenario = channel.unary_unary(
                '/zb.dcts.scenario.automatic.AutoScenarioService/CreateAutoMCPScenario',
                request_serializer=scenario_dot_auto__pb2.CreateAutoMCPRequest.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )
        self.CloseAutoScenario = channel.unary_unary(
                '/zb.dcts.scenario.automatic.AutoScenarioService/CloseAutoScenario',
                request_serializer=scenario_dot_scenario__pb2.ScenarioId.SerializeToString,
                response_deserializer=scenario_dot_scenario__pb2.ScenarioReply.FromString,
                )


class AutoScenarioServiceServicer(object):
    """3. 观察原始测量数据开启或关闭
    不带参数

    """

    def CreateAutoMCPScenario(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def CloseAutoScenario(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_AutoScenarioServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'CreateAutoMCPScenario': grpc.unary_unary_rpc_method_handler(
                    servicer.CreateAutoMCPScenario,
                    request_deserializer=scenario_dot_auto__pb2.CreateAutoMCPRequest.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
            'CloseAutoScenario': grpc.unary_unary_rpc_method_handler(
                    servicer.CloseAutoScenario,
                    request_deserializer=scenario_dot_scenario__pb2.ScenarioId.FromString,
                    response_serializer=scenario_dot_scenario__pb2.ScenarioReply.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'zb.dcts.scenario.automatic.AutoScenarioService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class AutoScenarioService(object):
    """3. 观察原始测量数据开启或关闭
    不带参数

    """

    @staticmethod
    def CreateAutoMCPScenario(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.automatic.AutoScenarioService/CreateAutoMCPScenario',
            scenario_dot_auto__pb2.CreateAutoMCPRequest.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def CloseAutoScenario(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/zb.dcts.scenario.automatic.AutoScenarioService/CloseAutoScenario',
            scenario_dot_scenario__pb2.ScenarioId.SerializeToString,
            scenario_dot_scenario__pb2.ScenarioReply.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)
