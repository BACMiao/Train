package com.bapocalypse.train.po;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @package: com.bapocalypse.train.po
 * @Author: 陈淼
 * @Date: 2016/11/8
 * @Description:  小图片组的模型类，用于初始化每一组小图片
 */
public class ImageGroup {
    private String name;         //小图片的实物名字
    private int count;           //小图片的数量
    private Set<String> images;  //小图片路径和文件名

    public ImageGroup(String name, int count, String... imageNames) {
        this.name = name;
        this.count = count;
        this.images = new HashSet<>();
        this.images.addAll(Arrays.asList(imageNames));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }
}
