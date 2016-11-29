package com.bapocalypse.train.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @package: com.bapocalypse.train.util
 * @Author: 陈淼
 * @Date: 2016/11/29
 * @Description: 删除服务器图片
 */
public class TempImageManager implements Runnable {
    private String path;//路径
    private static String RETENTION_TIME = "";// 文件保存的时间
    static {
        Properties prop = new Properties();
        InputStream inStrem = TempImageManager.class.getClassLoader()
                .getResourceAsStream("image.properties");
        try {
            prop.load(inStrem);
            RETENTION_TIME = prop.getProperty("file_retention_time");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inStrem.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public TempImageManager(String path) {
        this.path = path;
        System.out.println("path____________________" + path);
    }

    @Override
    public void run() {
        System.out.println("文件管理开始=========");
        path = path + "exportExcel";
        System.out.println("path?????" + path);
        File file = new File(path);
        deletefiles(file);
    }

    private void deletefiles(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                deleteFile(file);
            }
        }
    }

    private void deleteFile(File file) {
        try {
            if (file.isFile()) {
                // 删除符合条件的文件
                if (canDeleteFile(file)) {
                    if (file.delete()) {
                        System.out.println("文件" + file.getName() + "删除成功!");
                    } else {
                        System.out.println("文件" + file.getName()
                                + "删除失败!此文件可能正在被使用");
                    }
                }
            } else {
                System.out.println("没有可以删除的文件了");
            }

        } catch (Exception e) {
            System.out.println("删除文件失败========");
            e.printStackTrace();
        }
    }

    private boolean canDeleteFile(File file) {
        Date fileDate = getfileDate(file);
        Date date = new Date();
        long time = (date.getTime() - fileDate.getTime()) / 1000 / 60
                - Integer.parseInt(RETENTION_TIME);// 当前时间与文件间隔的分钟
        return time > 0;
    }

    private Date getfileDate(File file) {
        long modifiedTime = file.lastModified();
        return new Date(modifiedTime);
    }
}
