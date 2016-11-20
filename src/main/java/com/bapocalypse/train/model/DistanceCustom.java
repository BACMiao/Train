package com.bapocalypse.train.model;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/20
 * @Description: 距离的自定义模型类
 */
public class DistanceCustom {
    private String stationName1;
    private String stationName2;
    private int time;

    public String getStationName1() {
        return stationName1;
    }

    public void setStationName1(String stationName1) {
        this.stationName1 = stationName1;
    }

    public String getStationName2() {
        return stationName2;
    }

    public void setStationName2(String stationName2) {
        this.stationName2 = stationName2;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "DistanceCustom{" +
                "stationName1='" + stationName1 + '\'' +
                ", stationName2='" + stationName2 + '\'' +
                ", time=" + time +
                '}';
    }
}
