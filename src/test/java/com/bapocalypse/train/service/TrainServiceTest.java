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
 * @Date: 2016/12/1
 * @Description:
 */
public class TrainServiceTest extends BaseJunit4Test {

    @Autowired
    private TrainService trainService;

    @Test
    public void trainServiceShouldBeInjected(){
        Assert.assertNotNull(trainService);
    }

    @Test
    public void testFindTrainByStartSidAndEndSidAndDate() throws Exception {
        List<Train> list = trainService.findTrainByStartSidAndEndSidAndDate(6, 1, "2016-11-30");
        list.forEach(System.out::println);
    }

}