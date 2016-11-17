package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
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
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/10/28
 * @Description: UserDao的测试类，即UserMapper测试类
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
        Assert.assertEquals("zhangsan", user.getUsername());
    }

    @Test
    public void testFindUserByUsername() throws Exception{
        User user = userDao.findUserByUsername("zhangsan");
        Assert.assertEquals("张三", user.getName());
    }

    @Test
    public void testInsertUser() throws Exception{
        User user = new User();
        user.setUsername("lisilin");
        user.setPassword("123456");
        user.setIDType(1);
        user.setPassenger(1);
        user.setName("李四");
        user.setID("345397125864123485");
        user.setTelephone("12354621369");
        boolean result = userDao.insertUser(user);
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdateUser() throws Exception{
        User user = userDao.findUserByUid(1);
        user.setTelephone("12111211111");
        user.setPassword("321231");
        user.setPassenger(2);
        Assert.assertTrue(userDao.updateUser(user));
    }

    @Test
    public void testDeleteUserByUid() throws Exception{
        Assert.assertTrue(userDao.deleteUserByUid(1));
    }

}
