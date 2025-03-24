package common;

public class DOA {
    private double azimuth;     //水平角 正北方向夹角-顺时针为正(0°~360°)
    private double quality;     //测向质量，百分比[0,1]

    public DOA() {
    }

    public DOA(double azimuth, double quality) {
        this.azimuth = azimuth;
        this.quality = quality;
    }

    public double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "DOA{" +
                "azimuth=" + azimuth +
                ", quality=" + quality +
                '}';
    }
}
