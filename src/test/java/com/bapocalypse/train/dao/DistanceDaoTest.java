package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.po.Distance;
import com.bapocalypse.train.po.DistanceCustom;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: DistanceDao的测试类，即DistanceMapper测试类
 */
@Transactional
@Rollback(value = false)
public class DistanceDaoTest extends BaseJunit4Test {

    @Autowired
    private DistanceDao distanceDao;

    @Autowired
    private StationDao stationDao;

    @Test
    public void distanceDaoShouldBeInjected(){
        Assert.assertNotNull(distanceDao);
    }

    @Test
    public void testInsertDistance() throws Exception{
        String s1 = "福州站";
        String s2 = "福清站";
        int time = 27;
        Distance distance = new Distance();
        distance.setSid1(stationDao.findStationBySname(s1).getSid());
        distance.setSid2(stationDao.findStationBySname(s2).getSid());
        distance.setTime(time);
        boolean result = distanceDao.insertDistance(distance);
        Assert.assertTrue(result);
    }

    @Test
    public void testCountsDistance() throws Exception{
        int count = distanceDao.countsDistance();
        System.out.println(count);
    }

    @Test
    public void testFindAllDistance() throws Exception {
        List<DistanceCustom> distances = distanceDao.findAllDistance();
        for (DistanceCustom distance : distances){
            System.out.println(distance +" "+ distance.getTime());
        }
    }
}
