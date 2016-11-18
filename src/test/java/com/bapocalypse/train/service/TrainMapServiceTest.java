package com.bapocalypse.train.service;

import com.bapocalypse.train.BaseJunit4Test;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/11/18
 * @Description:
 */
public class TrainMapServiceTest extends BaseJunit4Test {
    @Autowired
    private TrainMapService trainMapService;

    @Test
    public void trainMapServiceShouldBeInjected(){
        Assert.assertNotNull(trainMapService);
    }

    @Test
    public void testInitTrainMap() throws Exception {
        trainMapService.initTrainMap();
    }
}
