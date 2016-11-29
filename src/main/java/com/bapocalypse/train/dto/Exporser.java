package com.bapocalypse.train.dto;

import java.sql.Date;

/**
 * @package: com.bapocalypse.train.dto
 * @Author: 陈淼
 * @Date: 2016/11/25
 * @Description: 暴露购买车票地址DTO
 */
public class Exporser {
    private boolean exposed;  //是否开启售票
    private String md5;       //使用md5加密
    private String tid;       //列车id
    private Date date;        //用户选择日期
    private long now;         //当前系统时间（毫秒）

    public Exporser(boolean exposed, String md5, String tid) {
        this.exposed = exposed;
        this.md5 = md5;
        this.tid = tid;
    }

    public Exporser(boolean exposed, String tid, Date date, long now) {
        this.exposed = exposed;
        this.tid = tid;
        this.date = date;
        this.now = now;
    }

    public Exporser(boolean exposed, Date date, long now) {
        this.exposed = exposed;
        this.date = date;
        this.now = now;
    }

    public Exporser(boolean exposed, Date date) {
        this.exposed = exposed;
        this.date = date;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
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

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    @Override
    public String toString() {
        return "Exporser{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", tid='" + tid + '\'' +
                ", date=" + date +
                ", now=" + now +
                '}';
    }
}
