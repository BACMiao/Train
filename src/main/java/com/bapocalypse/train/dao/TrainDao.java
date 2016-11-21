package com.bapocalypse.train.dao;

import com.bapocalypse.train.model.Train;
import org.springframework.stereotype.Repository;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: Dao接口，列车管理
 */
@Repository
public interface TrainDao {
    Train findTrainByTid(String tid) throws Exception;
}
