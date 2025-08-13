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
 * @file CommunLinkPlanner.java
 * @comment 通联关系规划
 * @date 2025/8/13
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class CommunLinkPlanner {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);
    private final ScheduledExecutorService loopScheduler = Executors.newSingleThreadScheduledExecutor();
    private int roundCounter = 0; // 轮次计数

    private static Map<Integer, NetworkDomain.Network> networkMap = null;
    private static NetworkDomain.NetworkList networkList = null;
    private static final ZmqPublisher publisher = new ZmqPublisher(9999);

    static {
        try {
            networkMap = NetworkDomainBuilder.buildNetworkMap();
            networkList = NetworkDomainBuilder.buildFromXml("src/main/resources/网络配置.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class NetAction {
        int id;
        int status;
        int dstId;

        @Override
        public String toString() {
            return "NetAction{" +
                    "id=" + id +
                    ", status=" + status +
                    ", dstId=" + dstId +
                    '}';
        }
    }

    static class NewMoment {
        int delay;
        List<NetAction> netAct = new ArrayList<>();

        @Override
        public String toString() {
            return "NewMoment{" +
                    "delay=" + delay +
                    ", netAct=" + netAct +
                    '}';
        }
    }

    private final List<NewMoment> newTimetable = new ArrayList<>();

    public boolean loadCommonNetwork(String xmlPath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlPath));

            NodeList moments = doc.getElementsByTagName("时刻");
            for (int i = 0; i < moments.getLength(); i++) {
                Element moment = (Element) moments.item(i);
                NewMoment newMoment = new NewMoment();
                newMoment.delay = Integer.parseInt(moment.getAttribute("delay"));

                NodeList nets = moment.getElementsByTagName("网络");
                for (int j = 0; j < nets.getLength(); j++) {
                    Element net = (Element) nets.item(j);
                    NetAction netAct = new NetAction();
                    netAct.id = Integer.parseInt(net.getAttribute("id"));
//                    System.out.println(netAct.id);

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

    public void runSchedule() {
        for (NewMoment moment : newTimetable) {
            scheduler.schedule(() -> {
                for (NetAction action : moment.netAct) {
                    CommunLinkOuterClass.NetworkCommunLikResult.Builder netComnBuilder = CommunLinkOuterClass.NetworkCommunLikResult.newBuilder(); // protobuf对象应用Builder构建，简化写法示意
                    generateNetworkCommunLink(networkList, action, netComnBuilder);
                }
            }, moment.delay, TimeUnit.SECONDS);
        }
    }

    // 循环执行，每隔 2 秒触发一次 runSchedule()
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

    // 停止所有任务
    public void stop() {
        loopScheduler.shutdown();
        scheduler.shutdown();
    }

    private boolean generateNetworkCommunLink(NetworkDomain.NetworkList networkList, NetAction netAct,
                                              CommunLinkOuterClass.NetworkCommunLikResult.Builder netComnBuilder) {
        NetworkDomain.Network network = networkMap.get(netAct.id);

        netComnBuilder.setId(netAct.id);
        netComnBuilder.setType(network.getType());

        if (netAct.dstId != 0) {
            CommunLinkOuterClass.CommunLink.Builder comlinkBuilder = CommunLinkOuterClass.CommunLink.newBuilder();
            comlinkBuilder.setSrcId(networkMap.get(netAct.id).getRelayTarget().getAeronavalTarget().getId());
            comlinkBuilder.setDesId(networkMap.get(netAct.dstId).getRelayTarget().getAeronavalTarget().getId());
            comlinkBuilder.setCommunState(CommunLinkOuterClass.ConnectParam.newBuilder().setConnet(2));

            netComnBuilder.addCommunLinkResult(comlinkBuilder.build());

            System.out.println("netComnBuilder" + netComnBuilder);

            publisher.publish("NetworkCommunLikResult", netComnBuilder.build().toByteArray());
            System.out.printf("建立点对点通联: 网络[%d] -> 网络[%d], 状态=%d%n",
                    netAct.id, netAct.dstId, netAct.status);
        } else {
            if (network.getTopology().equals("中心化")) {
                if (netAct.id == 5) {
                    System.out.println("航母机群起飞模拟逻辑");
                    // 航母机群起飞模拟逻辑
                    delayConnectFunc(network, 1, 2, 12000, netAct.status, netComnBuilder);
                    delayConnectFunc(network, 2, 3, 10000, netAct.status, netComnBuilder);
                    delayConnectFunc(network, 4, 1, 10000, netAct.status, netComnBuilder);
                    delayConnectFunc(network, 5, 4, 10000, netAct.status, netComnBuilder);
                    delayConnectFunc(network, 3, 6, 10000, netAct.status, netComnBuilder);
                    delayConnectFunc(network, 6, 0, 1000, netAct.status, netComnBuilder);
                    delayConnectFunc(network, 0, 5, 1000, netAct.status, netComnBuilder);
                } else {
                    for (int i = network.getTargetsCount(); i > 0; i--) {
                        CommunLinkOuterClass.CommunLink.Builder comlinkBuilder = CommunLinkOuterClass.CommunLink.newBuilder();

                        int status = netAct.status;
                        switch (status) {
                            case 1:
                                comlinkBuilder.setCommunState(CommunLinkOuterClass.ConnectParam.newBuilder().setConnet(1));
                                break;
                            case 2:
                                comlinkBuilder.setCommunState(CommunLinkOuterClass.ConnectParam.newBuilder().setConnet(2));
                                break;
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
                    publisher.publish("NetworkCommunLikResult", netComnBuilder.build().toByteArray());
                }
            } else {
            }
        }
        return true;
    }

    private void delayConnectFunc(NetworkDomain.Network network, int src, int dst, int timeMs, int status,
                                  zb.dcts.fusion.airDomain.communLink.CommunLinkOuterClass.NetworkCommunLikResult.Builder netComnBuilder) {
        try {
            CommunLinkOuterClass.CommunLink.Builder comlinkBuilder = CommunLinkOuterClass.CommunLink.newBuilder();

            switch (status) {
                case 1:
                    comlinkBuilder.setCommunState(CommunLinkOuterClass.ConnectParam.newBuilder().setConnet(1));
                    break;
                case 2:
                    comlinkBuilder.setCommunState(CommunLinkOuterClass.ConnectParam.newBuilder().setConnet(2));
                    break;
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
            publisher.publish("NetworkCommunLikResult", netComnBuilder.build().toByteArray());
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

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
