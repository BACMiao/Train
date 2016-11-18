package com.bapocalypse.train.service;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.model.Station;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: StationService的测试类
 */
public class StationServiceTest extends BaseJunit4Test {
    @Autowired
    private StationService stationService;

    @Test
    public void stationServiceShouldBeInjected(){
        Assert.assertNotNull(stationService);
    }

    @Test
    public void testFindStationBySid() throws Exception {
        Station station = stationService.findStationBySid(1);
        Assert.assertEquals("福安站", station.getSname());
    }
}
