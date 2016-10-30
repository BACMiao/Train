package com.bapocalypse.train.serviceImpl;

import com.bapocalypse.train.dao.UserDao;
import com.bapocalypse.train.model.User;
import com.bapocalypse.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @package: com.bapocalypse.train.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/10/29
 * @Description: 用户操作实现类
 */
@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Override
    public User findUserByUid(Integer uid) throws Exception {
        return userDao.findUserByUid(uid);
    }

    @Override
    public boolean insertUser(User user) throws Exception {
        return userDao.insertUser(user);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
