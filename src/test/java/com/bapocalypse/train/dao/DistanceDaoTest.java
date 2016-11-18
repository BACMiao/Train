package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.model.Distance;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: DistanceDao的测试类，即DistanceMapper测试类
 */
public class DistanceDaoTest extends BaseJunit4Test {

    @Autowired
    private DistanceDao distanceDao;

    @Test
    public void distanceDaoShouldBeInjected(){
        Assert.assertNotNull(distanceDao);
    }

    @Test
    public void testInsertDistance() throws Exception{
        Distance distance = new Distance();
        distance.setSid1(1);
        distance.setSid2(4);
        distance.setLength(27);
        boolean result = distanceDao.insertDistance(distance);
        Assert.assertTrue(result);
    }

    @Test
    public void testCountsDistance() throws Exception{
        int count = distanceDao.countsDistance();
        System.out.println(count);
    }
}
