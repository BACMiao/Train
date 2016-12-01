package com.bapocalypse.train.serviceImpl;

import com.bapocalypse.train.dao.TrainDao;
import com.bapocalypse.train.dao.TrainDateDao;
import com.bapocalypse.train.dao.TrainTimeDao;
import com.bapocalypse.train.dto.Exposer;
import com.bapocalypse.train.po.Train;
import com.bapocalypse.train.po.TrainDate;
import com.bapocalypse.train.service.TrainService;
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
 * @Date: 2016/12/1
 * @Description: 列车操作的服务接口的实现类
 */
@Service
public class TrainServiceImpl implements TrainService {

    private TrainTimeDao trainTimeDao;
    private TrainDateDao trainDateDao;
    private TrainDao trainDao;


    @Override
    public List<Train> findTrainByStartSidAndEndSidAndDate(Integer sid1, Integer sid2, String date) throws Exception {
        List<Train> list = new ArrayList<>();
        List<Train> list2 = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("sid1", sid1);
        map.put("sid2", sid2);
        List<Train> trainList = trainTimeDao.findTrainByStartSidAndEndSid(map);
        List<TrainDate> trainDateList = trainDateDao.findAllTrainsByDate(DateUtil.strToDate(date));

        for (Train aTrainList : trainList) {
            for (TrainDate aTrainDateList : trainDateList) {
                if (aTrainList.getTid().equals(aTrainDateList.getTid())) {
                    list.add(trainDao.findTrainByTid(aTrainList.getTid()));
                }
            }
        }

        for (Train train : list) {
            if (trainTimeDao.getStartTimeBySidAndTid(sid1, train.getTid()) == null ||
                    trainTimeDao.getStartTimeBySidAndTid(sid1, train.getTid()).equals("")) {
                list2.add(trainDao.findTrainByTid(train.getTid()));
            } else {
                Time time1 = DateUtil.strToTime(trainTimeDao.getStartTimeBySidAndTid(sid1, train.getTid()));
                Time time2 = DateUtil.strToTime(trainTimeDao.getStartTimeBySidAndTid(sid2, train.getTid()));
                if (time1.getTime() < time2.getTime()) {
                    list2.add(trainDao.findTrainByTid(train.getTid()));
                }
            }
        }
        return list2;
    }

    @Autowired
    public void setTrainTimeDao(TrainTimeDao trainTimeDao) {
        this.trainTimeDao = trainTimeDao;
    }

    @Autowired
    public void setTrainDateDao(TrainDateDao trainDateDao) {
        this.trainDateDao = trainDateDao;
    }

    @Autowired
    public void setTrainDao(TrainDao trainDao) {
        this.trainDao = trainDao;
    }
}
