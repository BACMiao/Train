package com.bapocalypse.train.enums;

/**
 * @package: com.bapocalypse.train.enums
 * @Author: 陈淼
 * @Date: 2016/11/28
 * @Description: 使用枚举表述常量数据字段
 */
public enum BuyTrickStateEnum {
    SUCCESS(1, "购买成功"),
    END(0, "购票结束"),
    REPEAT_BUY(-1, "重复购买"),
    INNER_ERROR(-2, "系统异常"),
    DATE_WRITE(-3, "数据篡改");

    private int state;
    private String stateInfo;

    BuyTrickStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static BuyTrickStateEnum stateOf(int index) {
        for (BuyTrickStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
