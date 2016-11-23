package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(trainDateDao.findAllTrainsByDate(sdf.format(new Date())));
    }
}
