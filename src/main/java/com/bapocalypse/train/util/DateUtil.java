package com.bapocalypse.train.util;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @package: com.bapocalypse.train.util
 * @Author: 陈淼
 * @Date: 2016/11/24
 * @Description: 将字符串转换为java.sql.Date
 */
public class DateUtil {
    public static Date strToDate(String strDate) {
        return Date.valueOf(strDate);
    }

    public static Time strToTime(String strTime) {
        return Time.valueOf(strTime);
    }

    public static void main(String[] args) {
        Time time = strToTime("00:00:00");
        System.out.println(time);
    }
}
