package com.bapocalypse.train.service;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.model.Distance;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/11/18
 * @Description: DistanceService的测试类
 */
public class DistanceServiceTest extends BaseJunit4Test{
    @Autowired
    private DistanceService distanceService;

    @Test
    public void distanceServiceShouldBeInjected(){
        Assert.assertNotNull(distanceService);
    }

    @Test
    public void testInsertDistance() throws Exception{
        Distance distance = new Distance();
        distance.setSid1(4);
        distance.setSid2(5);
        distance.setLength(27);
        boolean result = distanceService.createDistance(distance);
        Assert.assertTrue(result);
    }


}
