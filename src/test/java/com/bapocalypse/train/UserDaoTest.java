package com.bapocalypse.train;

import com.bapocalypse.train.dao.UserDao;
import com.bapocalypse.train.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @package: com.bapocalypse.train
 * @Author: 陈淼
 * @Date: 2016/10/28
 * @Description:
 */
public class UserDaoTest extends BaseJunit4Test {

    @Autowired
    private UserDao userDao;

    @Test
    public void userDaoShouldBeInjected(){
        Assert.assertNotNull(userDao);
    }

    @Test
    public void testFindUserById() throws Exception{
        User user = userDao.findUserByUid(1);
        System.out.println(user.getName());
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
