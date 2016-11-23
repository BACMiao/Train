package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.model.Station;
import com.bapocalypse.train.model.Train;
import com.bapocalypse.train.model.Trick;
import com.bapocalypse.train.util.UUIDGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/22
 * @Description: TrickDao的测试类，即TrickMapper测试类
 */
public class TrickDaoTest extends BaseJunit4Test {
    @Autowired
    private TrickDao trickDao;
    @Autowired
    private StationDao stationDao;
    @Autowired
    private TrainTimeDao trainTimeDao;
    @Autowired
    private TrainDateDao trainDateDao;

    @Test
    public void trickDaoShouldBeInjected(){
        Assert.assertNotNull(trickDao);
    }

    @Test
    public void testCreateTrick() throws Exception {
        Trick trick = new Trick();
        trick.setTrickId(UUIDGenerator.getUUID());
        trick.setUid(1);
        Station station1 = stationDao.findStationBySname("福安站");
        Station station2 = stationDao.findStationBySname("厦门站");
        trick.setStartSid(station1.getSid());
        trick.setEndSid(station2.getSid());
        trick.setState(1);
        Map<String, Integer> map = new HashMap<>();
        map.put("sid1", station1.getSid());
        map.put("sid2", station2.getSid());
        List<Train> trains = trainTimeDao.findTrainByStartSidAndEndSid(map);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Train> trainList = trainDateDao.findAllTrainsByDate(sdf.format(new Date()));
//        for (Train train : trainList){
//            for (Train train1 : trains){
//                if (train.getTid().equals(train1.getTid())){
//
//                }
//            }
//        }

        trickDao.createTrick(trick);
    }

}
