package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.model.Seat;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/23
 * @Description: SeatDao的测试类，即SeatMapper测试类
 */
public class SeatDaoTest extends BaseJunit4Test {
    @Autowired
    private SeatDao seatDao;

    @Test
    public void seatDaoShouldBeInjected(){
        Assert.assertNotNull(seatDao);
    }

    @Test
    public void testFindSeatsByCid() throws Exception {
        List<Seat> seatList = seatDao.findSeatsByCid(1);
        seatList.forEach(System.out::println);
    }
}
