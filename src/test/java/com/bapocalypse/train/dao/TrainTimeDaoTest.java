package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.model.Train;
import com.bapocalypse.train.model.TrainTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: TrainTimeDao的测试类，即TrainTimeMapper测试类
 */
public class TrainTimeDaoTest extends BaseJunit4Test{
    @Autowired
    private TrainTimeDao trainTimeDao;

    @Test
    public void trainTimeDaoShouldBeInjected(){
        Assert.assertNotNull(trainTimeDao);
    }

    @Test
    public void testFindAllTime() throws Exception {
        List<TrainTime> trainTimeList = trainTimeDao.findAllTime();
        for (TrainTime trainTime : trainTimeList){
            System.out.println(trainTime);
        }
    }
}
