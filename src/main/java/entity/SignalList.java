package entity;


import java.util.List;

/**
 * @file SignalList.java
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

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
