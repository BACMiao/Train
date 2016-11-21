package com.bapocalypse.train.model;

import java.sql.Time;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: 时刻表的模型类
 */
public class TrainTime {
    private int sid;          //站点id
    private String tid;       //列车id
    private Time arriveTime;  //到站时间
    private Time departTime;  //出发时间

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
