package com.bapocalypse.train.service;

import com.bapocalypse.train.po.Train;

import java.util.List;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/11/30
 * @Description: 列车时刻的服务接口
 */
public interface TrainTimeService {
    List<Train> findTrainByStartSidAndEndSid(Integer sid1, Integer sid2) throws Exception;
}
