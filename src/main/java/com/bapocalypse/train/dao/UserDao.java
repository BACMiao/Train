package com.bapocalypse.train.dao;

import com.bapocalypse.train.model.User;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/10/28
 * @Description: Dao接口，用户管理
 */
public interface UserDao {
    User findUserByUid(int uid) throws Exception;
}
