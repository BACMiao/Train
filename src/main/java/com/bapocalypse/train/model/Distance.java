package com.bapocalypse.train.model;

import java.io.Serializable;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: 两个站点之间的距离实体类
 */
public class Distance implements Serializable {
    private int sid1;     //站点1的id
    private int sid2;     //站点2的id
    private int time;     //两站点的最短路程时间

    public int getSid1() {
        return sid1;
    }

    public void setSid1(int sid1) {
        this.sid1 = sid1;
    }

    public int getSid2() {
        return sid2;
    }

    public void setSid2(int sid2) {
        this.sid2 = sid2;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "sid1=" + sid1 +
                ", sid2=" + sid2 +
                ", time=" + time +
                '}';
    }
}
