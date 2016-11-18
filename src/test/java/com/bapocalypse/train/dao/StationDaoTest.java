package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.model.Station;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: StationDao的测试类，即StationMapper测试类
 */
public class StationDaoTest extends BaseJunit4Test {

    @Autowired
    private StationDao stationDao;

    @Test
    public void stationDaoShouldBeInjected(){
        Assert.assertNotNull(stationDao);
    }

    @Test
    public void testFindStationBySid() throws Exception{
        Station station = stationDao.findStationBySid(1);
        Assert.assertEquals("福安站", station.getSname());
    }

    @Test
    public void testFindStationBySname() throws Exception{
        List<Station> stations = stationDao.findStationBySname("福安站");
        Assert.assertEquals("福建省", stations.get(0).getProvince());
    }

    @Test
    public void testInsertStation() throws Exception{
        Station station = new Station();
        station.setSname("宁德站");
        station.setCity("宁德市");
        station.setProvince("福建省");
        station.setLatitude(26.65);
        station.setLongitude(119.52);
        boolean result = stationDao.insertStation(station);
        Assert.assertTrue(result);
    }

    @Test
    public void testCountsStation() throws Exception{
        int count = stationDao.countsStation();
        System.out.println(count);
    }
}
