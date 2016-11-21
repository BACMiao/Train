package com.bapocalypse.train.dao;

import com.bapocalypse.train.model.Train;
import com.bapocalypse.train.model.TrainTime;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: Dao接口，列车时刻表管理
 */
@Repository
public interface TrainTimeDao {
    List<TrainTime> findAllTime() throws Exception;
}
