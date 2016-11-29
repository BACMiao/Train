package com.bapocalypse.train.listener;

import com.bapocalypse.train.util.SystemTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @package: com.bapocalypse.train.listener
 * @Author: 陈淼
 * @Date: 2016/11/29
 * @Description: 时间监听器
 */
public class TimeListener implements ServletContextListener {
    private Timer timer = new Timer();
    private static ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获取当前应用的上下文对象
        servletContext = servletContextEvent.getServletContext();
        servletContextEvent.getServletContext().log("定时器已启动");
        // 设置在每晚24:00:00执行任务
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24);    //24时
        calendar.set(Calendar.MINUTE, 00);          //00分
        calendar.set(Calendar.SECOND, 0);          //00秒
        Date date = calendar.getTime();
        // 监听器获取网站的根目录
        String path = servletContextEvent.getServletContext().getRealPath("/");
        timer.schedule(new SystemTask(path), date);     //TODO
        servletContextEvent.getServletContext().log("已经添加任务调度表");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        timer.cancel();
    }
}