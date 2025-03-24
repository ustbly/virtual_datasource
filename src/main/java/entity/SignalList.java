package entity;


import common.DOA;

import java.util.List;
import java.util.Map;

public class SignalList {
    private String nodeId;
    private String deviceId;
    private List<FixSignal> fixSignalList;
    private List<HoppingSignalCluster> hoppingSignalList;

    public SignalList() {
    }

    public SignalList(String nodeId, String deviceId, List<FixSignal> fixSignalList, List<HoppingSignalCluster> hoppingSignalList) {
        this.nodeId = nodeId;
        this.deviceId = deviceId;
        this.fixSignalList = fixSignalList;
        this.hoppingSignalList = hoppingSignalList;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<FixSignal> getFixSignalList() {
        return fixSignalList;
    }

    public void setFixSignalList(List<FixSignal> fixSignalList) {
        this.fixSignalList = fixSignalList;
    }

    public List<HoppingSignalCluster> getHoppingSignalList() {
        return hoppingSignalList;
    }

    public void setHoppingSignalList(List<HoppingSignalCluster> hoppingSignalList) {
        this.hoppingSignalList = hoppingSignalList;
    }

    @Override
    public String toString() {
        return "SignalList{" +
                "nodeId='" + nodeId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", fixSignalList=" + fixSignalList +
                ", hoppingSignalList=" + hoppingSignalList +
                '}';
    }
}
