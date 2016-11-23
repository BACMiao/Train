package com.bapocalypse.train.dao;

import com.bapocalypse.train.model.Train;
import com.bapocalypse.train.model.TrainTime;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: Dao接口，列车时刻表管理
 */
@Repository
public interface TrainTimeDao {
    List<TrainTime> findAllTime() throws Exception;
    List<Train> findTrainAndTrainTime() throws Exception;
    List<Train> findTrainByStartSidAndEndSid(Map<String, Integer> map) throws Exception;
}
