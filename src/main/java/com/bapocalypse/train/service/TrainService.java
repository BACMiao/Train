package com.bapocalypse.train.service;

import com.bapocalypse.train.po.Train;

import java.util.List;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/12/1
 * @Description: 列车操作的服务接口
 */
public interface TrainService {
    List<Train> findTrainByStartSidAndEndSidAndDate(Integer sid1, Integer sid2, String date) throws Exception;
}
