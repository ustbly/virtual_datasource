package entity;

import common.TimeSpan;

import java.util.List;

/**
 * @file HoppingSignalCluster.java
 * @date 2025/4/21
 * @comment 跳频信号集
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class HoppingSignalCluster {
    private String name;            // 跳频系统
    private String activity;        // 信号活跃度
    private TimeSpan timeSpan;      // 信号的出现时间和消失时间
    private List<HoppingSignal> freq_set;   // 跳频频率集

    public HoppingSignalCluster() {
    }

    public HoppingSignalCluster(String name, String activity, TimeSpan timeSpan, List<HoppingSignal> freq_set) {
        this.name = name;
        this.activity = activity;
        this.timeSpan = timeSpan;
        this.freq_set = freq_set;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public TimeSpan getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(TimeSpan timeSpan) {
        this.timeSpan = timeSpan;
    }

    public List<HoppingSignal> getFreq_set() {
        return freq_set;
    }

    public void setFreq_set(List<HoppingSignal> freq_set) {
        this.freq_set = freq_set;
    }

    @Override
    public String toString() {
        return "HoppingSignalCluster{" +
                "name='" + name + '\'' +
                ", activity='" + activity + '\'' +
                ", timeSpan=" + timeSpan +
                ", freq_set=" + freq_set +
                '}';
    }
}
