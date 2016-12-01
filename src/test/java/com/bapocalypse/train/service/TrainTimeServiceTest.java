package com.bapocalypse.train.service;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.po.Train;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/11/30
 * @Description:
 */
public class TrainTimeServiceTest extends BaseJunit4Test {

    @Autowired
    private TrainTimeService trainTimeService;

    @Test
    public void trainTimeServiceShouldBeInjected(){
        Assert.assertNotNull(trainTimeService);
    }


}