package com.bapocalypse.train.dao;

import com.bapocalypse.train.model.Trick;
import org.springframework.stereotype.Repository;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/22
 * @Description:
 */
@Repository
public interface TrickDao {
    boolean createTrick(Trick trick) throws Exception;
}
