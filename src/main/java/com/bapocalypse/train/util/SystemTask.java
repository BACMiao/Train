package com.bapocalypse.train.util;

import java.util.TimerTask;

/**
 * @package: com.bapocalypse.train.util
 * @Author: 陈淼
 * @Date: 2016/11/29
 * @Description: 时间任务器
 */
public class SystemTask extends TimerTask {
    private String path;

    public SystemTask(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        try {
            System.out.println("path======" + path);
            for (int i = 0; i < 10; i++) {
                System.out.println("say hello");
            }
            TempImageManager tim = new TempImageManager(path);
            tim.run();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
