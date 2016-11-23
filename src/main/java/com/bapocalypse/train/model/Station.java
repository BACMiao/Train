package com.bapocalypse.train.model;

import java.io.Serializable;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/14
 * @Description: 车站的模型类
 */
public class Station implements Serializable {
    private int sid;
    private String sname;     //车站名
    private String province;  //省份
    private String city;      //城市
    private Double latitude;  //纬度
    private Double longitude; //经度

    public Station() {
    }

    public Station(int sid, String sname, String province, String city, Double latitude, Double longitude) {
        this.sid = sid;
        this.sname = sname;
        this.province = province;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
