package com.bapocalypse.train;

import com.bapocalypse.train.dao.UserDao;
import com.bapocalypse.train.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @package: com.bapocalypse.train
 * @Author: 陈淼
 * @Date: 2016/10/28
 * @Description:
 */
public class UserTest {
    private ApplicationContext applicationContext;
    @Before
    public void before() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");
    }

    @Test
    public void testFindUserById() throws Exception{
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = userDao.findUserByUid(1);
        System.out.println(user.getName());
    }
}
