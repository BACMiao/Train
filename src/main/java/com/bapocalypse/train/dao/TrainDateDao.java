package com.bapocalypse.train.dao;

import com.bapocalypse.train.model.Train;
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
    List<Train> findAllTrainsByDate(String date) throws Exception;
}
