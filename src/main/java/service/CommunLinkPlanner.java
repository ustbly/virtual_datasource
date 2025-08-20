package service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.NetworkDomainBuilder;
import utils.ZmqPublisher;
import zb.dcts.fusion.airDomain.communLink.CommunLinkOuterClass;
import zb.dcts.fusion.networkDomain.NetworkDomain;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 林跃
 * @file CommunLinkPlanner.java
 * @comment 通联关系规划
 * @date 2025/8/13
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class CommunLinkPlanner {
    // 定时任务线程池，负责调度各个时刻的网络动作
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);
    // 单线程定时任务池，用于循环调度
    private final ScheduledExecutorService loopScheduler = Executors.newSingleThreadScheduledExecutor();
    // 轮次计数器
    private int roundCounter = 0;

    // 网络映射表，网络ID到网络对象
    private static Map<Integer, NetworkDomain.Network> networkMap = null;
    // 网络列表对象
    private static NetworkDomain.NetworkList networkList = null;
    // ZeroMQ发布器，端口9999
    private static final ZmqPublisher publisher = new ZmqPublisher(9999);

    // 静态代码块，初始化网络映射和网络列表
    static {
        try {
            networkMap = NetworkDomainBuilder.buildNetworkMap();
            networkList = NetworkDomainBuilder.buildFromXml("src/main/resources/网络配置.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 网络动作类，表示一次网络状态或通联关系的变更
    static class NetAction {
        int id;      // 网络ID
        int status;  // 网络状态
        int dstId;   // 目标网络ID

        @Override
        public String toString() {
            return "NetAction{" +
                    "id=" + id +
                    ", status=" + status +
                    ", dstId=" + dstId +
                    '}';
        }
    }

    // 新时刻类，表示一个调度时刻及其包含的网络动作
    static class NewMoment {
        int delay;                // 延迟时间（秒）
        List<NetAction> netAct = new ArrayList<>(); // 本时刻的所有网络动作

        @Override
        public String toString() {
            return "NewMoment{" +
                    "delay=" + delay +
                    ", netAct=" + netAct +
                    '}';
        }
    }

    // 所有调度时刻的列表
    private final List<NewMoment> newTimetable = new ArrayList<>();

    /**
     * 加载网络通联配置XML，解析出所有时刻和动作
     *
     * @param xmlPath XML文件路径
     * @return 是否加载成功
     */
    public boolean loadCommonNetwork(String xmlPath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlPath));

            // 获取所有“时刻”节点
            NodeList moments = doc.getElementsByTagName("时刻");
            for (int i = 0; i < moments.getLength(); i++) {
                Element moment = (Element) moments.item(i);
                NewMoment newMoment = new NewMoment();
                newMoment.delay = Integer.parseInt(moment.getAttribute("delay"));

                // 获取本时刻下的所有“网络”节点
                NodeList nets = moment.getElementsByTagName("网络");
                for (int j = 0; j < nets.getLength(); j++) {
                    Element net = (Element) nets.item(j);
                    NetAction netAct = new NetAction();
                    netAct.id = Integer.parseInt(net.getAttribute("id"));

                    // 情况1: 设置网络状态
                    if (net.hasAttribute("网络状态")) {
                        netAct.status = Integer.parseInt(net.getAttribute("网络状态"));
                    }

                    // 情况2: 建立通联关系
                    if (net.hasAttribute("目标网络id")) {
                        netAct.dstId = Integer.parseInt(net.getAttribute("目标网络id"));
                    }
                    System.out.println("netAct:" + netAct);
                    newMoment.netAct.add(netAct);
                }

                newTimetable.add(newMoment);
            }
            System.out.println("newTimetable:" + newTimetable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 按照调度表执行所有时刻的网络动作
     */
    public void runSchedule() {
        for (NewMoment moment : newTimetable) {
            // 按照delay延迟调度每个时刻
            scheduler.schedule(() -> {
                for (NetAction action : moment.netAct) {
                    // 构建protobuf对象
                    CommunLinkOuterClass.NetworkCommunLikResult.Builder netComnBuilder = CommunLinkOuterClass.NetworkCommunLikResult.newBuilder();
                    // 生成通联关系并发布
                    generateNetworkCommunLink(networkList, action, netComnBuilder);
                }
            }, moment.delay, TimeUnit.SECONDS);
        }
    }

    /**
     * 循环执行调度，每隔60秒触发一次runSchedule()
     */
    public void startLoop() {
        loopScheduler.scheduleAtFixedRate(() -> {
            try {
                roundCounter++;
                System.out.println("[Scheduler] 第 " + roundCounter + " 轮任务开始...");
                runSchedule();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 60, TimeUnit.SECONDS);
    }

    /**
     * 停止所有调度任务
     */
    public void stop() {
        loopScheduler.shutdown();
        scheduler.shutdown();
    }

    /**
     * 生成网络通联关系，并通过ZMQ发布
     *
     * @param networkList    网络列表
     * @param netAct         当前网络动作
     * @param netComnBuilder protobuf构建器
     * @return 是否成功
     */
    private boolean generateNetworkCommunLink(NetworkDomain.NetworkList networkList, NetAction netAct,
                                              CommunLinkOuterClass.NetworkCommunLikResult.Builder netComnBuilder) {
        NetworkDomain.Network network = networkMap.get(netAct.id);

        // 设置网络ID和类型
        netComnBuilder.setId(netAct.id);
        netComnBuilder.setType(network.getType());

        // 如果有目标网络ID，建立点对点通联
        if (netAct.dstId != 0) {
            CommunLinkOuterClass.CommunLink.Builder comlinkBuilder = CommunLinkOuterClass.CommunLink.newBuilder();
            comlinkBuilder.setSrcId(networkMap.get(netAct.id).getRelayTarget().getAeronavalTarget().getId());
            comlinkBuilder.setDesId(networkMap.get(netAct.dstId).getRelayTarget().getAeronavalTarget().getId());
            comlinkBuilder.setCommunState(CommunLinkOuterClass.ConnectParam.newBuilder().setConnet(2));

            netComnBuilder.addCommunLinkResult(comlinkBuilder.build());

            System.out.println("netComnBuilder" + netComnBuilder);

            // 发布protobuf消息
            publisher.publish("NetworkCommunLikResult", netComnBuilder.build().toByteArray());
            System.out.printf("建立点对点通联: 网络[%d] -> 网络[%d], 状态=%d%n",
                    netAct.id, netAct.dstId, netAct.status);
        } else {
            // 如果是中心化拓扑，执行特殊逻辑
            if (network.getTopology().equals("中心化")) {
                if (netAct.id == 5) {
                    System.out.println("航母机群起飞模拟逻辑");
                    // 航母机群起飞模拟逻辑，依次建立多条通联关系并延迟
                    delayConnectFunc(network, 1, 2, 12000, netAct.status, netComnBuilder);
                    delayConnectFunc(network, 2, 3, 10000, netAct.status, netComnBuilder);
                    delayConnectFunc(network, 4, 1, 10000, netAct.status, netComnBuilder);
                    delayConnectFunc(network, 5, 4, 10000, netAct.status, netComnBuilder);
                    delayConnectFunc(network, 3, 6, 10000, netAct.status, netComnBuilder);
                    delayConnectFunc(network, 6, 0, 1000, netAct.status, netComnBuilder);
                    delayConnectFunc(network, 0, 5, 1000, netAct.status, netComnBuilder);
                } else {
                    // 其他中心化网络，遍历所有目标，建立通联关系
                    for (int i = network.getTargetsCount(); i > 0; i--) {
                        CommunLinkOuterClass.CommunLink.Builder comlinkBuilder = CommunLinkOuterClass.CommunLink.newBuilder();

                        int status = netAct.status;
                        // 根据状态设置通联参数
                        switch (status) {
                            case 1:
                                comlinkBuilder.setCommunState(CommunLinkOuterClass.ConnectParam.newBuilder().setConnet(1));
                                break;
                            case 2:
                            case 3:
                                comlinkBuilder.setCommunState(CommunLinkOuterClass.ConnectParam.newBuilder().setConnet(2));
                                break;
                            case 4:
                                comlinkBuilder.setCommunState(CommunLinkOuterClass.ConnectParam.newBuilder().setConnet(0));
                                break;
                        }
                        comlinkBuilder.setSrcId(network.getTargets(i % network.getTargetsCount()).getAeronavalTarget().getId());
                        comlinkBuilder.setDesId(network.getTargets((i - 1)).getAeronavalTarget().getId());
                        netComnBuilder.addCommunLinkResult(comlinkBuilder.build());
                    }
                    // 发布所有通联结果
                    publisher.publish("NetworkCommunLikResult", netComnBuilder.build().toByteArray());
                }
            } else {
                // 非中心化拓扑暂未实现
            }
        }
        return true;
    }

    /**
     * 延迟建立通联关系，并发布消息
     *
     * @param network        网络对象
     * @param src            源目标索引
     * @param dst            目标索引
     * @param timeMs         延迟时间（毫秒）
     * @param status         通联状态
     * @param netComnBuilder protobuf构建器
     */
    private void delayConnectFunc(NetworkDomain.Network network, int src, int dst, int timeMs, int status,
                                  zb.dcts.fusion.airDomain.communLink.CommunLinkOuterClass.NetworkCommunLikResult.Builder netComnBuilder) {
        try {
            CommunLinkOuterClass.CommunLink.Builder comlinkBuilder = CommunLinkOuterClass.CommunLink.newBuilder();

            // 根据状态设置通联参数
            switch (status) {
                case 1:
                    comlinkBuilder.setCommunState(CommunLinkOuterClass.ConnectParam.newBuilder().setConnet(1));
                    break;
                case 2:
                case 3:
                    comlinkBuilder.setCommunState(CommunLinkOuterClass.ConnectParam.newBuilder().setConnet(2));
                    break;
                case 4:
                    comlinkBuilder.setCommunState(CommunLinkOuterClass.ConnectParam.newBuilder().setConnet(0));
                    break;
            }

            comlinkBuilder.setSrcId(network.getTargets(src).getAeronavalTarget().getId());
            comlinkBuilder.setDesId(network.getTargets(dst).getAeronavalTarget().getId());

            netComnBuilder.addCommunLinkResult(comlinkBuilder.build());
            // 发布消息
            publisher.publish("NetworkCommunLikResult", netComnBuilder.build().toByteArray());
            // 延迟指定时间
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 主函数，入口
     *
     * @param args 命令行参数
     * @throws Exception 异常
     */
    public static void main(String[] args) throws Exception {

        CommunLinkPlanner planner = new CommunLinkPlanner();

        String xmlPath = "src/main/resources/网络通联.xml"; // 这里改成你的文件路径
        if (!planner.loadCommonNetwork(xmlPath)) {
            System.err.println("加载网络通联配置失败！");
            return;
        }

        System.out.println("启动调度执行...");
        planner.startLoop();
    }
}