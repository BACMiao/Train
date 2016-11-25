package com.bapocalypse.train.exception;

/**
 * @package: com.bapocalypse.train.exception
 * @Author: 陈淼
 * @Date: 2016/11/25
 * @Description: 购票关闭异常
 */
public class TrickCloseException extends TrickException {

    public TrickCloseException(String message) {
        super(message);
    }

    public TrickCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
