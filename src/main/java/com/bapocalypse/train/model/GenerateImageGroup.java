package com.bapocalypse.train.model;

import java.util.List;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/8
 * @Description: 生成验证码的图片组，即组成验证码的小图片
 */
public class GenerateImageGroup {
    private ImageGroup keyGroup;      //所需要选取的图片的组（答案）
    private List<ImageGroup> groups;  //验证码图片中除去答案的图片的组（干扰项）

    public GenerateImageGroup(ImageGroup keyGroup, List<ImageGroup> groups) {
        this.keyGroup = keyGroup;
        this.groups = groups;
    }

    public ImageGroup getKeyGroup() {
        return keyGroup;
    }

    public void setKeyGroup(ImageGroup keyGroup) {
        this.keyGroup = keyGroup;
    }

    public List<ImageGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<ImageGroup> groups) {
        this.groups = groups;
    }
}
