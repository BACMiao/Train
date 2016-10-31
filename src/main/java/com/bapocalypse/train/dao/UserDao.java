package com.bapocalypse.train.dao;

import com.bapocalypse.train.model.User;
import org.springframework.stereotype.Service;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/10/28
 * @Description: Dao接口，用户管理
 */
@Service
public interface UserDao {
    User findUserByUid(int uid) throws Exception;
    boolean insertUser(User user) throws Exception;
    boolean updateUser(User user) throws Exception;
    boolean deleteUserByUid(int uid) throws Exception;
}
