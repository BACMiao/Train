package com.bapocalypse.train.po;


import java.sql.Date;

/**
 * @package: com.bapocalypse.train.po
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: 临时票的模型类（退票，改签后的原票）
 */
public class Temporary {
    private String tid;      //列车id
    private int cid;         //车厢id
    private String seatId;   //座位id
    private int startSid;    //开始站点id
    private int endSid;      //到达站点id
    private Date date;       //日期

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Temporary{" +
                "tid='" + tid + '\'' +
                ", cid=" + cid +
                ", seatId='" + seatId + '\'' +
                ", startSid=" + startSid +
                ", endSid=" + endSid +
                ", date=" + date +
                '}';
    }
}
