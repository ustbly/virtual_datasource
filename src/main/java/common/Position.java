package common;

/**
 * @file Position.java
 * @comment 位置信息
 * @date 2025/4/23
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class Position {
    private double latitude;        // 经度
    private double longitude;       // 纬度
    private double altitude;        // 海拔

    public Position() {}

    public Position(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "Position{latitude=" + latitude + ", longitude=" + longitude + ", altitude=" + altitude + "}";
    }
}
