package com.bapocalypse.train.service;

import com.bapocalypse.train.po.User;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/10/29
 * @Description: 用户操作的服务接口
 */
public interface UserService {
    User findUserByUid(Integer uid) throws Exception;
    User findUserByUsername(String username) throws Exception;
    boolean loginUser(String username, String password) throws Exception;
    boolean insertUser(User user) throws Exception;
    boolean updateUser(User user) throws Exception;
    boolean deleteUserByUid(Integer uid) throws Exception;
}
