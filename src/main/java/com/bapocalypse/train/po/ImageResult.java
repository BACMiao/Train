package com.bapocalypse.train.po;

import java.util.Set;

/**
 * @package: com.bapocalypse.train.po
 * @Author: 陈淼
 * @Date: 2016/11/8
 * @Description: 验证码图片的模型类
 */
public class ImageResult {
    private String name;               //验证码图片名称（UUID + '.jepg'）
    private Set<Integer> keySet;       //答案图片所在验证码图片中的位置
    private String uniqueKey;          //放在Cookie中的独有标识，值为图片名称中的UUID
    private String tip;                //验证码需要选择的实物名称

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
