package entity;

/**
 * @file HoppingSignal.java
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class HoppingSignal {
    private double center_freq;
    private double band_width;
    private double amplitude;
    private int count_num;

    public HoppingSignal() {
    }

    public HoppingSignal(double center_freq, double band_width, double amplitude, int count_num) {
        this.center_freq = center_freq;
        this.band_width = band_width;
        this.amplitude = amplitude;
        this.count_num = count_num;
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

    @Override
    public String toString() {
        return "HoppingSignal{" +
                "center_freq=" + center_freq +
                ", band_width=" + band_width +
                ", amplitude=" + amplitude +
                ", count_num=" + count_num +
                '}';
    }
}
