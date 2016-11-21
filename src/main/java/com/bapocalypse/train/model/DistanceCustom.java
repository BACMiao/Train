package com.bapocalypse.train.model;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/20
 * @Description: 距离的扩展类
 */
public class DistanceCustom extends Distance {
    private String stationName1;     //站点1的city名
    private String stationName2;     //站点2的city名

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

    @Override
    public String toString() {
        return "DistanceCustom{" +
                "stationName1='" + stationName1 + '\'' +
                ", stationName2='" + stationName2 + '\'' +
                '}';
    }
}
