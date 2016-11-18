package com.bapocalypse.train.model;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: 两个站点之间的距离实体类
 */
public class Distance {
    private int sid1;
    private int sid2;
    private int length;

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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "sid1=" + sid1 +
                ", sid2=" + sid2 +
                ", length=" + length +
                '}';
    }
}
