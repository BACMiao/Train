package com.bapocalypse.train.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @package: com.bapocalypse.train.util
 * @Author: 陈淼
 * @Date: 2016/11/24
 * @Description: 将字符串转换为java.sql.Date
 */
public class DateUtil {
    public static Date strToDate(String strDate){
        return Date.valueOf(strDate);
    }

    public static void main(String[] args) {
        Date date = DateUtil.strToDate("2016-11-24");
        System.out.println(date);
    }
}
