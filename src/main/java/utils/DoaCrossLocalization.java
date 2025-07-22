package utils;

/**
 * @file DoaCrossLocalization.java
 * @comment 上述 Java 程序实现了以下功能：
 *              computeDOA：根据目标位置与测向站位置，计算正北为基准的 DOA 方位角（单位：度）。
 *              intersectDOA：根据两个测向站的位置和 DOA 角，采用平面近似方式求交汇定位点。
 *              haversine：基于 Haversine 公式计算球面距离，用于误差评估。
 *              main：示例测试，从两个站点对目标进行定位并输出误差。
 * @date 2025/7/15
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

import java.awt.geom.Point2D;

public class DoaCrossLocalization {
    // 地球半径 (单位: 米)
    private static final double EARTH_RADIUS = 6371000.0;

    // 经纬度转墨卡托投影 (近似平面坐标，单位：米)
    public static Point2D.Double latLonToMeters(double lat, double lon) {
        double x = Math.toRadians(lon) * EARTH_RADIUS;
        double y = Math.log(Math.tan(Math.PI / 4 + Math.toRadians(lat) / 2)) * EARTH_RADIUS;
        return new Point2D.Double(x, y);
    }

    // 墨卡托坐标转回经纬度
    public static double[] metersToLatLon(Point2D.Double p) {
        double lon = Math.toDegrees(p.x / EARTH_RADIUS);
        double lat = Math.toDegrees(2 * Math.atan(Math.exp(p.y / EARTH_RADIUS)) - Math.PI / 2);
        return new double[]{lat, lon};
    }

    // 根据站和目标的坐标计算 DOA 角度（单位：度，正北为0，顺时针）
    public static double computeDOA(double[] station, double[] target) {
        double deltaLat = Math.toRadians(target[0] - station[0]);
        double deltaLon = Math.toRadians(target[1] - station[1]);
        double angle = Math.atan2(deltaLon, deltaLat);
        double degree = Math.toDegrees(angle);
        return (degree + 360) % 360;
    }

    // 根据两个测向站及其 DOA 计算交汇位置
    public static Point2D.Double computeIntersection(Point2D.Double p1, double doa1Deg,
                                                     Point2D.Double p2, double doa2Deg) {
        double angle1 = Math.toRadians(doa1Deg);
        double angle2 = Math.toRadians(doa2Deg);

        double dx1 = Math.sin(angle1);
        double dy1 = Math.cos(angle1);
        double dx2 = Math.sin(angle2);
        double dy2 = Math.cos(angle2);

        double denominator = dx1 * dy2 - dy1 * dx2;
        if (Math.abs(denominator) < 1e-6) {
            throw new RuntimeException("测向线几乎平行，无法精确交汇");
        }

        double dx = p2.x - p1.x;
        double dy = p2.y - p1.y;
        double t = (dx * dy2 - dy * dx2) / denominator;

        return new Point2D.Double(p1.x + t * dx1, p1.y + t * dy1);
    }

    // Haversine公式计算两个经纬度之间的球面距离
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.pow(Math.sin(dLon / 2), 2);
        return 2 * EARTH_RADIUS * Math.asin(Math.sqrt(a));
    }

    public static void main(String[] args) {
//        double[] station1LatLon = {25.0, 123.5};
//        double[] station2LatLon = {26.5, 125.0};
//        double[] targetLatLon   = {25.5, 125.0};

//        double[] station1LatLon = {25.000009122379222, 119.99497077214882};
//        double[] station2LatLon = {24.99996091848166, 119.99943766446688};
        double[] targetLatLon = {26.489999771118164, 123.52000427246094};

//        double doa1 = computeDOA(station1LatLon, targetLatLon);
//        double doa2 = computeDOA(station2LatLon, targetLatLon);
        double doa1 = 37.4314811019986;
        double doa2 = 37.21927425614666;

//        Point2D.Double p1 = latLonToMeters(station1LatLon[0], station1LatLon[1]);
//        Point2D.Double p2 = latLonToMeters(station2LatLon[0], station2LatLon[1]);
        Point2D.Double p1 = new Point2D.Double(25.00000092125286, 119.99852509758014);
        Point2D.Double p2 = new Point2D.Double(24.99998936556054, 120.00730190981244);

        Point2D.Double estMeters = computeIntersection(p1, doa1, p2, doa2);

        double[] estLatLon = metersToLatLon(estMeters);
        double error = haversine(targetLatLon[0], targetLatLon[1], estLatLon[0], estLatLon[1]);

        System.out.printf("DOA1: %.2f°, DOA2: %.2f°\n", doa1, doa2);
        System.out.printf("Estimated Position: (%.6f, %.6f)\n", estLatLon[0], estLatLon[1]);
        System.out.printf("Real Target Position: (%.6f, %.6f)\n", targetLatLon[0], targetLatLon[1]);
        System.out.printf("Position Error: %.2f km\n", error / 1000);
    }
}
