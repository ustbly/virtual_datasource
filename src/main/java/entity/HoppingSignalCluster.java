package entity;

import common.TimeSpan;

import java.util.List;

public class HoppingSignalCluster {
    private String name;    //跳频系统
    private String activity;
    private TimeSpan timeSpan;
    private List<HoppingSignal> freq_set;   //跳频频率集

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
