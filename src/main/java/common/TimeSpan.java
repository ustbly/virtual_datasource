package common;

/**
 * @file TimeSpan.java
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

import java.sql.Timestamp;

public class TimeSpan {
    private Timestamp startTime;
    private Timestamp stopTime;

    public TimeSpan() {}

    public TimeSpan(Timestamp startTime, Timestamp stopTime) {
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getStopTime() {
        return stopTime;
    }

    public void setStopTime(Timestamp stopTime) {
        this.stopTime = stopTime;
    }

    @Override
    public String toString() {
        return "TimeSpan{" +
                "startTime=" + startTime +
                ", stopTime=" + stopTime +
                '}';
    }
}
