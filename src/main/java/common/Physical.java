package common;

/**
 * @file Physical.java
 * @comment 物理指标信息
 * @date 2025/4/23
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class Physical {
    private int  type;      // 物理指标类型
    private double value;   // 物理指标值
    private String unit;    // 物理指标单位

    public Physical() {
    }

    public Physical(int type, double value, String unit) {
        this.type = type;
        this.value = value;
        this.unit = unit;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Physical{" +
                "type='" + type + '\'' +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }

}
