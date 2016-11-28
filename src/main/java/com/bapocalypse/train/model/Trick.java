package com.bapocalypse.train.model;


import java.sql.Date;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: 火车票的模型类
 */
public class Trick {
    private int uid;         //用户id
    private String tid;      //列车id
    private int cid;         //车厢id
    private String seatId;   //座位id
    private int startSid;    //开始站点id
    private int endSid;      //到达站点id
    private Date date;       //日期
    private int state;       //车票状态

    public Trick() {
    }

    public Trick(int uid, String tid, int cid, String seatId, int startSid, int endSid, Date date, int state) {
        this.uid = uid;
        this.tid = tid;
        this.cid = cid;
        this.seatId = seatId;
        this.startSid = startSid;
        this.endSid = endSid;
        this.date = date;
        this.state = state;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Trick{" +
                "uid=" + uid +
                ", tid='" + tid + '\'' +
                ", cid=" + cid +
                ", seatId='" + seatId + '\'' +
                ", startSid=" + startSid +
                ", endSid=" + endSid +
                ", date=" + date +
                ", state=" + state +
                '}';
    }
}
