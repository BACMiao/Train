package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.po.Train;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: TrainDao的测试类，即TrainMapper测试类
 */
public class TrainDaoTest extends BaseJunit4Test {
    @Autowired
    private TrainDao trainDao;

    @Test
    public void trainDaoShouldBeInjected(){
        Assert.assertNotNull(trainDao);
    }

    @Test
    public void testFindTrainByTid() throws Exception {
        Train train = trainDao.findTrainByTid("D6332");
        System.out.println(train);
    }
}
