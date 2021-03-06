package com.bapocalypse.train.po;

import java.io.Serializable;
import java.sql.Time;

/**
 * @package: com.bapocalypse.train.po
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: 时刻表的模型类
 */
public class TrainTime implements Serializable {
    private int sid;          //站点id
    private String tid;       //列车id
    private Time arriveTime;  //到站时间
    private Time departTime;  //出发时间

    private Station station;  //时刻所对应的车站

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Time getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Time departTime) {
        this.departTime = departTime;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "TrainTime{" +
                "sid=" + sid +
                ", tid='" + tid + '\'' +
                ", arriveTime=" + arriveTime +
                ", departTime=" + departTime +
                '}';
    }
}
