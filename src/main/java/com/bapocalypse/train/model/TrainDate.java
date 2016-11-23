package com.bapocalypse.train.model;

import java.sql.Date;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: 列车安排日期表
 */
public class TrainDate {
    private Date date;           //日期
    private String tid;          //列车id
    private int firstSeatNum;    //一等座数量
    private int secondSeatNum;   //二等座数量
    private int standNum;        //站票数量

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getFirstSeatNum() {
        return firstSeatNum;
    }

    public void setFirstSeatNum(int firstSeatNum) {
        this.firstSeatNum = firstSeatNum;
    }

    public int getSecondSeatNum() {
        return secondSeatNum;
    }

    public void setSecondSeatNum(int secondSeatNum) {
        this.secondSeatNum = secondSeatNum;
    }

    public int getStandNum() {
        return standNum;
    }

    public void setStandNum(int standNum) {
        this.standNum = standNum;
    }

    @Override
    public String toString() {
        return "TrainDate{" +
                "date=" + date +
                ", tid='" + tid + '\'' +
                ", firstSeatNum=" + firstSeatNum +
                ", secondSeatNum=" + secondSeatNum +
                ", standNum=" + standNum +
                '}';
    }
}
