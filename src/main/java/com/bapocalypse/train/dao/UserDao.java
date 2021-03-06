package com.bapocalypse.train.dao;

import com.bapocalypse.train.po.User;
import org.springframework.stereotype.Repository;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/10/28
 * @Description: Dao接口，用户管理
 */
@Repository
public interface UserDao {
    User findUserByUid(int uid) throws Exception;
    User findUserByUsername(String username) throws Exception;
    boolean insertUser(User user) throws Exception;
    boolean updateUser(User user) throws Exception;
    boolean deleteUserByUid(int uid) throws Exception;
}
