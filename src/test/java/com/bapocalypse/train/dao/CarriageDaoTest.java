package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.po.Carriage;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/23
 * @Description: CarriageDao的测试类，即CarriageMapper测试类
 */
public class CarriageDaoTest extends BaseJunit4Test {
    @Autowired
    private CarriageDao carriageDao;

    @Test
    public void carriageDaoShouldBeInjected(){
        Assert.assertNotNull(carriageDao);
    }

    @Test
    public void testFindCarriageByDescription() throws Exception {
        List<Carriage> carriages = carriageDao.findCarriageByDescription("一等座");
        carriages.forEach(System.out::println);
    }

}
