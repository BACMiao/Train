package com.bapocalypse.train.model;

import java.awt.image.BufferedImage;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/8
 * @Description:
 */
public class BufferedImageWrap {
    private boolean key;
    private BufferedImage bufferedImage;

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
