package com.bapocalypse.train.model;

import java.util.Set;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/8
 * @Description:
 */
public class ImageResult {
    private String name;
    private Set<Integer> keySet;
    private String uniqueKey;
    private String tip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getKeySet() {
        return keySet;
    }

    public void setKeySet(Set<Integer> keySet) {
        this.keySet = keySet;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
