package com.bapocalypse.train.service;

import com.bapocalypse.train.po.Train;
import com.bapocalypse.train.po.TrainTime;

import java.util.List;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/11/30
 * @Description: 列车时刻的服务接口
 */
public interface TrainTimeService {
    List<TrainTime> findAllTimeByTid(String tid) throws Exception;
}
