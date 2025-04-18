package common;


public class Physical {
    private int  type;
    private double value;
    private String unit;

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
