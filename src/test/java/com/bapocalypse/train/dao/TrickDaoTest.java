package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.po.Station;
import com.bapocalypse.train.po.Trick;
import com.bapocalypse.train.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/22
 * @Description: TrickDao的测试类，即TrickMapper测试类
 */
public class TrickDaoTest extends BaseJunit4Test {
    @Autowired
    private TrickDao trickDao;
    @Autowired
    private StationDao stationDao;
    @Autowired
    private TrainTimeDao trainTimeDao;
    @Autowired
    private TrainDateDao trainDateDao;

    @Test
    public void trickDaoShouldBeInjected(){
        Assert.assertNotNull(trickDao);
    }

    @Test
    public void testCreateTrick() throws Exception {
        Trick trick = new Trick();
        trick.setUid(1);
        Station station1 = stationDao.findStationBySname("福安站");
        Station station2 = stationDao.findStationBySname("厦门站");
        trick.setStartSid(station1.getSid());
        trick.setEndSid(station2.getSid());
        trick.setState(1);
        trick.setTid("D6332");
        trick.setDate(DateUtil.strToDate("2016-11-24"));
        trick.setCid(1);
        trick.setSeatId("1A");
        int insertCount = trickDao.createTrick(trick);
        Assert.assertEquals(1, insertCount);
    }

    @Test
    public void testFindTrickByPrimary(){
        Trick trick = trickDao.findTrickByPrimary(1, "D6332", DateUtil.strToDate("2016-11-26"));
        System.out.println(trick);
    }

    @Test
    public void testFindAllTricksByUid(){
        List<Trick> trickList = trickDao.findAllTricksByUid(1);
        trickList.forEach(System.out::println);
    }

}
