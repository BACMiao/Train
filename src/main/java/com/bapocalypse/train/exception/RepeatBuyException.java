package com.bapocalypse.train.exception;

/**
 * @package: com.bapocalypse.train.exception
 * @Author: 陈淼
 * @Date: 2016/11/25
 * @Description: 重复购买异常（运行期异常）
 */
public class RepeatBuyException extends TrickException {

    public RepeatBuyException(String message) {
        super(message);
    }

    public RepeatBuyException(String message, Throwable cause) {
        super(message, cause);
    }
}
