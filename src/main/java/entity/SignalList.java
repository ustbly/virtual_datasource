package entity;


import common.DOA;

import java.util.List;
import java.util.Map;

public class SignalList {
    private List<FixSignal> fixSignalList;
    private List<HoppingSignalCluster> hoppingSignalList;

    public SignalList() {
    }

    public SignalList(List<FixSignal> fixSignalList, List<HoppingSignalCluster> hoppingSignalList) {
        this.fixSignalList = fixSignalList;
        this.hoppingSignalList = hoppingSignalList;
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
                "fixSignalList=" + fixSignalList +
                ", hoppingSignalList=" + hoppingSignalList +
                '}';
    }
}
