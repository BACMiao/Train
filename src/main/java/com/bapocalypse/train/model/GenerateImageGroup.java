package com.bapocalypse.train.model;

import java.util.List;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/8
 * @Description:
 */
public class GenerateImageGroup {
    private ImageGroup keyGroup;
    private List<ImageGroup> groups;

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
