package com.bapocalypse.train.po;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

/**
 * @package: com.bapocalypse.train.po
 * @Author: 陈淼
 * @Date: 2016/11/20
 * @Description: 列车的模型类
 */
public class Train implements Serializable {
    private String tid;       //列车id
    private int startSid;     //始发站id
    private int endSid;       //终点站id
    private Time startTime;   //始发时间
    private Time endTime;     //终点时间

    private List<TrainTime> trainTimeList;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getStartSid() {
        return startSid;
    }

    public void setStartSid(int startSid) {
        this.startSid = startSid;
    }

    public int getEndSid() {
        return endSid;
    }

    public void setEndSid(int endSid) {
        this.endSid = endSid;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public List<TrainTime> getTrainTimeList() {
        return trainTimeList;
    }

    public void setTrainTimeList(List<TrainTime> trainTimeList) {
        this.trainTimeList = trainTimeList;
    }

    @Override
    public String toString() {
        return "Train{" +
                "tid='" + tid + '\'' +
                ", startSid=" + startSid +
                ", endSid=" + endSid +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
