package com.bapocalypse.train.model;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: 车厢的模型类
 */
public class Carriage {
    private int cid;            //车厢id
    private int tid;            //列车id
    private int totalNumber;    //搭载人数
    private int seatNumber;     //座位数
    private String description; //车厢描述

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "cid=" + cid +
                ", tid=" + tid +
                ", totalNumber=" + totalNumber +
                ", seatNumber=" + seatNumber +
                ", description='" + description + '\'' +
                '}';
    }
}
