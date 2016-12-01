package com.bapocalypse.train.serviceImpl;

import com.bapocalypse.train.dao.TrainTimeDao;
import com.bapocalypse.train.po.TrainTime;
import com.bapocalypse.train.service.TrainTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package: com.bapocalypse.train.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/11/30
 * @Description: 列车时刻的服务接口的实现类
 */
@Service
public class TrainTimeServiceImpl implements TrainTimeService {

    private TrainTimeDao trainTimeDao;

    @Override
    public List<TrainTime> findAllTimeByTid(String tid) throws Exception {
        return trainTimeDao.findAllTimeByTid(tid);
    }

    @Autowired
    public void setTrainTimeDao(TrainTimeDao trainTimeDao) {
        this.trainTimeDao = trainTimeDao;
    }
}
