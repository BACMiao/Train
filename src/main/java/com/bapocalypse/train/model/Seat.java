package com.bapocalypse.train.model;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: 座位的模型类
 */
public class Seat {
    private String seatId;       //座位id
    private int cid;             //车厢id
    private String description;  //座位描述

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
