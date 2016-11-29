package com.bapocalypse.train.service;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.dto.Exporser;
import com.bapocalypse.train.dto.TrickExecution;
import com.bapocalypse.train.po.Trick;
import com.bapocalypse.train.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/11/28
 * @Description: TrickService的测试类
 */
public class TrickServiceTest extends BaseJunit4Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TrickService trickService;

    @Test
    public void trickServiceShouldBeInjected(){
        Assert.assertNotNull(trickService);
    }

    @Test
    public void testFindAllTricksByUid() throws Exception{
        List<Trick> trickList = trickService.findAllTricksByUid(1);
        logger.info("list={}", trickList);
    }

    @Test
    public void exportBuyTrickUrl() throws Exception {
        Exporser exporser = trickService.exportBuyTrickUrl("D6332", DateUtil.strToDate("2016-11-30"));
        System.out.println(exporser);
    }

    @Test
    public void executeBuyTrick() throws Exception {
        Trick trick = new Trick(1,"D6332", 1, "1A", 4, 1, DateUtil.strToDate("2016-11-30"), 1);
        TrickExecution execution = trickService.executeBuyTrick(trick, "一等座", "8cffc1e4abe74818319cb0b8ce1bf1bd");
        System.out.println(execution);
    }

}