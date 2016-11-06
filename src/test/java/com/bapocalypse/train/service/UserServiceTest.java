package com.bapocalypse.train.service;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @package: com.bapocalypse.train
 * @Author: 陈淼
 * @Date: 2016/10/30
 * @Description: UserService的测试类
 */
public class UserServiceTest extends BaseJunit4Test {

    @Autowired
    private UserService userService;

    @Test
    public void userServiceShouldBeInjected(){
        Assert.assertNotNull(userService);
    }

    @Test
    public void testFindUserByUid() throws Exception {
        User user = userService.findUserByUid(1);
        Assert.assertEquals("张三", user.getName());
    }

    @Test
    public void testFindUserByUsername() throws Exception {
        User user = userService.findUserByUsername("zhangsan");
        Assert.assertEquals("张三", user.getName());
    }

    @Test
    public  void testLoginUser() throws Exception{
        Assert.assertTrue(userService.loginUser("zhangsan", "123456"));
    }
    @Test
    public void testInsertUser() throws Exception {
        User user = new User();
        user.setUsername("lisilin");
        user.setPassword("123456");
        user.setIDType(1);
        user.setPassenger(1);
        user.setName("李四");
        user.setID("345397125864123485");
        user.setTelephone("12354621369");
        Assert.assertTrue(userService.insertUser(user));
    }

    @Test
    public void testUpdateUser() throws Exception{
        User user = userService.findUserByUid(1);
        user.setTelephone("12111211111");
        user.setPassword("321231");
        user.setPassenger(3);
        Assert.assertTrue(userService.updateUser(user));
    }

    @Test
    public void testDeleteUserByUid() throws Exception{
        Assert.assertTrue(userService.deleteUserByUid(1));
    }
}
