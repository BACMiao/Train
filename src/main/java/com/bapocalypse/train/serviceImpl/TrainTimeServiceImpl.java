package com.bapocalypse.train.serviceImpl;

import com.bapocalypse.train.dao.TrainDao;
import com.bapocalypse.train.dao.TrainTimeDao;
import com.bapocalypse.train.po.Train;
import com.bapocalypse.train.service.TrainTimeService;
import com.bapocalypse.train.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package: com.bapocalypse.train.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/11/30
 * @Description: 列车时刻的服务接口的实现类
 */
@Service
public class TrainTimeServiceImpl implements TrainTimeService {

    private TrainTimeDao trainTimeDao;
    private TrainDao trainDao;


    @Override
    public List<Train> findTrainByStartSidAndEndSid(Integer sid1, Integer sid2) throws Exception {
        List<Train> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("sid1", sid1);
        map.put("sid2", sid2);
        List<Train> trainList = trainTimeDao.findTrainByStartSidAndEndSid(map);
        for (Train train : trainList) {
            if (trainTimeDao.getStartTimeBySidAndTid(sid1, train.getTid()) == null ||
                    trainTimeDao.getStartTimeBySidAndTid(sid1, train.getTid()).equals("")) {
                list.add(trainDao.findTrainByTid(train.getTid()));
            } else {
                Time time1 = DateUtil.strToTime(trainTimeDao.getStartTimeBySidAndTid(sid1, train.getTid()));
                Time time2 = DateUtil.strToTime(trainTimeDao.getStartTimeBySidAndTid(sid2, train.getTid()));
                if (time1.getTime() < time2.getTime()) {
                    list.add(trainDao.findTrainByTid(train.getTid()));
                }
            }
        }
        return list;
    }

    @Autowired
    public void setTrainTimeDao(TrainTimeDao trainTimeDao) {
        this.trainTimeDao = trainTimeDao;
    }

    @Autowired
    public void setTrainDao(TrainDao trainDao) {
        this.trainDao = trainDao;
    }
}
