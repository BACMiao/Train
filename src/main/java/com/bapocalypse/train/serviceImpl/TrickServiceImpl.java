package com.bapocalypse.train.serviceImpl;

import com.bapocalypse.train.dto.Exporser;
import com.bapocalypse.train.dto.TrickExecution;
import com.bapocalypse.train.exception.RepeatBuyException;
import com.bapocalypse.train.exception.TrickCloseException;
import com.bapocalypse.train.exception.TrickException;
import com.bapocalypse.train.model.Trick;
import com.bapocalypse.train.service.TrickService;

import java.sql.Date;

/**
 * @package: com.bapocalypse.train.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/11/25
 * @Description: 车票操作的服务接口实现类
 */
public class TrickServiceImpl implements TrickService {
    @Override
    public Exporser exportBuyTrickUrl(String tid, Date date) {
        return null;
    }

    @Override
    public TrickExecution executeBuyTrick(Trick trick, String md5) throws TrickException, RepeatBuyException, TrickCloseException {
        return null;
    }
}
