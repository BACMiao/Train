package com.bapocalypse.train.dao;

import com.bapocalypse.train.model.Trick;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/22
 * @Description:
 */
@Repository
public interface TrickDao {
    int createTrick(Trick trick);
    Trick findTrickByPrimary(@Param("uid") int uid, @Param("tid") String tid, @Param("date") Date date);
}
