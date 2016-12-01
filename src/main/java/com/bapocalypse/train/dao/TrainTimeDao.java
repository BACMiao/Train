package com.bapocalypse.train.dao;

import com.bapocalypse.train.po.Train;
import com.bapocalypse.train.po.TrainTime;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
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
    List<TrainTime> findAllTimeByTid(String tid) throws Exception;
    List<Train> findTrainAndTrainTime() throws Exception;
    List<Train> findTrainByStartSidAndEndSid(Map<String, Integer> map);
    String getStartTimeBySidAndTid(@Param("sid") int sid, @Param("tid") String tid);
}
