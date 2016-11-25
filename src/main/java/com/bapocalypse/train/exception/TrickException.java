package com.bapocalypse.train.exception;

/**
 * @package: com.bapocalypse.train.exception
 * @Author: 陈淼
 * @Date: 2016/11/25
 * @Description: 购票相关业务异常
 */
public class TrickException extends RuntimeException {
    public TrickException(String message) {
        super(message);
    }

    public TrickException(String message, Throwable cause) {
        super(message, cause);
    }
}
