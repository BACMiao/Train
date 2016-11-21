package com.bapocalypse.train.model;

import java.sql.Date;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: 列车安排日期表
 */
public class TrainDate {
    private Date date;    //日期
    private String tid;   //列车id

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

    @Override
    public String toString() {
        return "TrainDate{" +
                "date=" + date +
                ", tid='" + tid + '\'' +
                '}';
    }
}
