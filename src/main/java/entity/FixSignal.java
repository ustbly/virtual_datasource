package entity;

import common.DOA;

import java.util.Map;

/**
 * @file FixSignal.java
 * @date 2025/4/21
 * @comment 定频信号类
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class FixSignal {
    private String signalId;                // 信号ID
    private String activity;                // 信号活跃度
    private double center_freq;              // 中心频率，单位Hz
    private double band_width;              // 带宽，单位Hz
    private double amplitude;               // 幅度，单位dBm
    private int count_num;                  // 出现次数
    private DOA dir_of_arrival;             // 信号的到达角，测向信息
    private String classification;          // 信号分类，一般为调制识别或体制识别的结果
    private Map<String,String> extraInfo;   // 信号额外的描述信息

    public FixSignal() {
    }

    public FixSignal(String signalId, String activity, double center_freq, double band_width, double amplitude,
                     int count_num, DOA dir_of_arrival, String classification, Map<String, String> extraInfo) {
        this.signalId = signalId;
        this.activity = activity;
        this.center_freq = center_freq;
        this.band_width = band_width;
        this.amplitude = amplitude;
        this.count_num = count_num;
        this.dir_of_arrival = dir_of_arrival;
        this.classification = classification;
        this.extraInfo = extraInfo;
    }

    public String getSignalId() {
        return signalId;
    }

    public void setSignalId(String signalId) {
        this.signalId = signalId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getCenter_freq() {
        return center_freq;
    }

    public void setCenter_freq(double center_freq) {
        this.center_freq = center_freq;
    }

    public double getBand_width() {
        return band_width;
    }

    public void setBand_width(double band_width) {
        this.band_width = band_width;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    public int getCount_num() {
        return count_num;
    }

    public void setCount_num(int count_num) {
        this.count_num = count_num;
    }

    public DOA getDir_of_arrival() {
        return dir_of_arrival;
    }

    public void setDir_of_arrival(DOA dir_of_arrival) {
        this.dir_of_arrival = dir_of_arrival;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Map<String, String> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Map<String, String> extraInfo) {
        this.extraInfo = extraInfo;
    }

    @Override
    public String toString() {
        return "FixSignalList{" +
                "signalId='" + signalId + '\'' +
                ", activity='" + activity + '\'' +
                ", center_freq=" + center_freq +
                ", band_width=" + band_width +
                ", amplitude=" + amplitude +
                ", count_num=" + count_num +
                ", dir_of_arrival=" + dir_of_arrival +
                ", classification='" + classification + '\'' +
                ", extraInfo=" + extraInfo +
                '}';
    }
}
