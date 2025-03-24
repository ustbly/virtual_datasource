package entity;

import common.DOA;

import java.util.Map;

public class FixSignal {
    private String signalId;
    private String activity;
    private double enter_freq;
    private double band_width;
    private double amplitude;
    private int count_num;
    private DOA dir_of_arrival;
    private String classification;
    private Map<String,String> extraInfo;

    public FixSignal() {
    }

    public FixSignal(String signalId, String activity, double enter_freq, double band_width, double amplitude,
                     int count_num, DOA dir_of_arrival, String classification, Map<String, String> extraInfo) {
        this.signalId = signalId;
        this.activity = activity;
        this.enter_freq = enter_freq;
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

    public double getEnter_freq() {
        return enter_freq;
    }

    public void setEnter_freq(double enter_freq) {
        this.enter_freq = enter_freq;
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
                ", enter_freq=" + enter_freq +
                ", band_width=" + band_width +
                ", amplitude=" + amplitude +
                ", count_num=" + count_num +
                ", dir_of_arrival=" + dir_of_arrival +
                ", classification='" + classification + '\'' +
                ", extraInfo=" + extraInfo +
                '}';
    }
}
