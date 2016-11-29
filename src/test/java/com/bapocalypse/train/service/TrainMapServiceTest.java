package com.bapocalypse.train.service;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.po.Station;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Stack;

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

    @Test
    public void testHasPathTo() throws Exception {
        trainMapService.initTrainMap();
        trainMapService.dfs("福安站");
        boolean result = trainMapService.hasPathTo("罗源站");
        Assert.assertEquals(true, result);
        Stack<Station> path = trainMapService.pathTo("罗源站");
        int count = path.size();
        for (int i = 0; i < count; i++){
            System.out.println(path.pop().getSname() + " ");
        }
    }
}
