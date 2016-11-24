package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/22
 * @Description: TrainDateDao的测试类，即TrainDateMapper测试类
 */
public class TrainDateDaoTest extends BaseJunit4Test {

    @Autowired
    private TrainDateDao trainDateDao;

    @Test
    public void trainDateDaoShouldBeInjected(){
        Assert.assertNotNull(trainDateDao);
    }

    @Test
    public void testFindAllTrainsByDate() throws Exception {
        System.out.println(trainDateDao.findAllTrainsByDate(DateUtil.strToDate("2016-11-24")));
    }

    @Test
    public void testReduceFirstSeatNumber(){
        java.sql.Date date = DateUtil.strToDate("2016-11-24");
        int updateCount = trainDateDao.reduceFirstSeatNumber("D6332", date);
        Assert.assertEquals(1, updateCount);
    }
}
