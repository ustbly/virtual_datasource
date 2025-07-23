package utils;

import com.google.protobuf.Any;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import zb.dcts.Dcts;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
import zb.dcts.fusion.networkDomain.NetworkDomain;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NetworkDomainBuilder {

    public static NetworkDomain.NetworkList buildFromXml(String xmlPath) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xmlPath));
        doc.getDocumentElement().normalize();

        NodeList networkNodes = doc.getElementsByTagName("通信网");
        NetworkDomain.NetworkList.Builder networkListBuilder = NetworkDomain.NetworkList.newBuilder();

        for (int i = 0; i < networkNodes.getLength(); i++) {
            Element netElement = (Element) networkNodes.item(i);

            NetworkDomain.Network.Builder networkBuilder = NetworkDomain.Network.newBuilder()
                    .setId(parseInt(netElement, "id"))
                    .setCamp(parseCamp(netElement, "阵营"))
                    .setType(getText(netElement, "类型"))
                    .setTopology(parseTopology(getText(netElement, "拓扑结构")))
                    .setPurposes(getText(netElement, "用途"))
                    .setThrtLvl(parseThreatLevel(netElement))
                    .setReliability(parseInt(netElement, "可信度", 80))
                    .setImportance(parseInt(netElement, "重要性", 0));

            // 关键节点
            TargetOuterClass.Target keyTarget = parseTarget(netElement, "关键节点");
            if (keyTarget != null) networkBuilder.setKeyTarget(keyTarget);

            // 中继节点
            TargetOuterClass.Target relayTarget = parseTarget(netElement, "网关节点");
            if (relayTarget != null) networkBuilder.setRelayTarget(relayTarget);

            // 一般节点
            List<TargetOuterClass.FusionTargetList> users = parseUsers(netElement);
            networkBuilder.addAllTargets(users);

            // 频率集
            List<Double> freqList = parseFreqList(netElement);
            networkBuilder.addAllFreq(freqList);

            networkListBuilder.addNetworks(networkBuilder.build());
        }

        return networkListBuilder.build();
    }

    private static List<Double> parseFreqList(Element parent) {
        List<Double> freqs = new ArrayList<>();
        NodeList freqNodes = parent.getElementsByTagName("频点");
        for (int i = 0; i < freqNodes.getLength(); i++) {
            try {
                String val = freqNodes.item(i).getTextContent().trim();
                freqs.add(Double.parseDouble(val));
            } catch (Exception ignored) {
            }
        }
        return freqs;
    }

    private static int parseInt(Element parent, String tag) {
        return parseInt(parent, tag, 0);
    }

    private static int parseInt(Element parent, String tag, int defaultValue) {
        try {
            String val = getText(parent, tag);
            return (val == null || val.isEmpty()) ? defaultValue : Integer.parseInt(val);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private static Aeronaval.Camp parseCamp(Element parent, String tag) {
        int val = parseInt(parent, tag);
        return (val == 1) ? Aeronaval.Camp.RED_CAMP : Aeronaval.Camp.BLUE_CAMP;
    }

    private static Dcts.ThreatLevel parseThreatLevel(Element parent) {
        if (parent.getElementsByTagName("威胁等级").getLength() == 0) return Dcts.ThreatLevel.NONE;
        int level = parseInt(parent, "威胁等级");
        switch (level) {
            case 1: return Dcts.ThreatLevel.LOW;
            case 2: return Dcts.ThreatLevel.MIDDLE;
            case 3: return Dcts.ThreatLevel.HIGH;
            default: return Dcts.ThreatLevel.NONE;
        }
    }

    private static String parseTopology(String value) {
        return "1".equals(value) ? "中心化" : "分布式";
    }

    private static String getText(Element parent, String tag) {
        NodeList nodes = parent.getElementsByTagName(tag);
        if (nodes.getLength() > 0 && nodes.item(0).getFirstChild() != null) {
            return nodes.item(0).getTextContent().trim();
        }
        return null;
    }

    private static TargetOuterClass.Target parseTarget(Element parent, String tagName) {
        NodeList list = parent.getElementsByTagName(tagName);
        if (list.getLength() == 0) return null;
        Element node = (Element) list.item(0);
        if (node.getElementsByTagName("id").getLength() == 0) return null;

        int id = parseInt(node, "id");
        String name = getText(node, "名称");

        return TargetOuterClass.Target.newBuilder()
                .setId(id)
                .setName(name == null ? "" : name)
                .build();
    }

    private static List<TargetOuterClass.FusionTargetList> parseUsers(Element parent) {
        List<TargetOuterClass.FusionTargetList> users = new ArrayList<>();

        NodeList equips = parent.getElementsByTagName("装备");
        for (int i = 0; i < equips.getLength(); i++) {
            Element equip = (Element) equips.item(i);
            int id = parseInt(equip, "id");
            String name = getText(equip, "名称");

            Aeronaval.Target target = Aeronaval.Target.newBuilder()
                    .setId(id)
                    .setName(name == null ? "" : name)
                    .build();

            TargetOuterClass.FusionTargetList list = TargetOuterClass.FusionTargetList.newBuilder()
                    .setAeronavalTarget(target)
                    .build();

            users.add(list);
        }
        return users;
    }

    public static void main(String[] args) throws Exception {
        NetworkDomain.NetworkList netMsg = NetworkDomainBuilder.buildFromXml("src/main/resources/网络配置.xml");
        Any msg = Any.pack(netMsg);
        String s = MessageAndJsonUtil.parseAnyToJson(msg);
        System.out.println(s);
    }
}
