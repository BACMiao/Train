package com.bapocalypse.train.service;

import com.bapocalypse.train.dto.Exposer;
import com.bapocalypse.train.dto.TrickExecution;
import com.bapocalypse.train.exception.RepeatBuyException;
import com.bapocalypse.train.exception.TrickCloseException;
import com.bapocalypse.train.exception.TrickException;
import com.bapocalypse.train.po.Trick;

import java.sql.Date;
import java.util.List;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/11/25
 * @Description: 车票操作的服务接口
 */
public interface TrickService {
    List<Trick> findAllTricksByUid(int uid);
    /**
     * @funtion exportBuyTrickUrl
     * @Description 开始购票是输出购票接口地址，否则输出系统时间以及提示。
     * @param tid 列车id
     * @param date 日期
     * @return 暴露购买车票地址DTO
     */
    Exposer exportBuyTrickUrl(String tid, Date date);

    /**
     * @funtion executeBuyTrick
     * @Description 执行购票业务
     * @param trick 车票对象
     * @param level 座位等级
     * @param md5 md5加密方式
     * @return 购买车票后的结果
     * @throws TrickException 购票相关业务异常
     * @throws RepeatBuyException 重复购买异常
     * @throws TrickCloseException 购票关闭异常
     */
    TrickExecution executeBuyTrick(Trick trick, String level, String md5) throws TrickException, RepeatBuyException, TrickCloseException;
}
