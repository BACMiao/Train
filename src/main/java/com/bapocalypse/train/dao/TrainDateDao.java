package com.bapocalypse.train.dao;

import com.bapocalypse.train.model.Train;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/22
 * @Description: Dao接口，列车日期表管理
 */
@Repository
public interface TrainDateDao {
    List<Train> findAllTrainsByDate(Date date);

    /**
     * @funtion reduceFirstSeatNumber
     * @Description 减一等座票数
     * @param tid 列车id
     * @param date 选择列车的日期
     * @return 如果影响行数>1，表示更新的记录行数
     */
    int reduceFirstSeatNumber(@Param("tid") String tid, @Param("date") Date date);
    int reduceSecondSeatNumber(@Param("tid") String tid, @Param("date") Date date);
    int reduceStandNumber(@Param("tid") String tid, @Param("date") Date date);
}
