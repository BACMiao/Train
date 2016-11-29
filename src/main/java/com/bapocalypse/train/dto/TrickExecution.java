package com.bapocalypse.train.dto;

import com.bapocalypse.train.enums.BuyTrickStateEnum;
import com.bapocalypse.train.po.Trick;

import java.sql.Date;

/**
 * @package: com.bapocalypse.train.dto
 * @Author: 陈淼
 * @Date: 2016/11/25
 * @Description: 封装购买车票后的结果
 */
public class TrickExecution {
    private String tid;       //列车id
    private Date date;        //购买的日期
    private int state;        //购买车票后的结果
    private String stateInfo; //状态表示
    private Trick trick;      //购买成功后的车票

    public TrickExecution(String tid, Date date, BuyTrickStateEnum stateEnum) {
        this.tid = tid;
        this.date = date;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public TrickExecution(String tid, Date date, BuyTrickStateEnum stateEnum, Trick trick) {
        this.tid = tid;
        this.date = date;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.trick = trick;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Trick getTrick() {
        return trick;
    }

    public void setTrick(Trick trick) {
        this.trick = trick;
    }

    @Override
    public String toString() {
        return "TrickExecution{" +
                "tid='" + tid + '\'' +
                ", date=" + date +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", trick=" + trick +
                '}';
    }
}
