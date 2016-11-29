package com.bapocalypse.train.po;

import java.awt.image.BufferedImage;

/**
 * @package: com.bapocalypse.train.po
 * @Author: 陈淼
 * @Date: 2016/11/8
 * @Description: 带有标识的图片缓冲区的模型类，相当于一个画布。
 */
public class BufferedImageWrap {
    private boolean key;                  //用于标识答案（true）或干扰项（false）
    private BufferedImage bufferedImage;  //图片缓冲区

    public BufferedImageWrap(boolean key, BufferedImage bufferedImage) {
        this.key = key;
        this.bufferedImage = bufferedImage;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}
