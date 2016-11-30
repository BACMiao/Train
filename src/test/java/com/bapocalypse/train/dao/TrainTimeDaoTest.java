package com.bapocalypse.train.dao;

import com.bapocalypse.train.BaseJunit4Test;
import com.bapocalypse.train.po.Station;
import com.bapocalypse.train.po.Train;
import com.bapocalypse.train.po.TrainTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/21
 * @Description: TrainTimeDao的测试类，即TrainTimeMapper测试类
 */
public class TrainTimeDaoTest extends BaseJunit4Test {
    @Autowired
    private TrainTimeDao trainTimeDao;

    @Test
    public void trainTimeDaoShouldBeInjected() {
        Assert.assertNotNull(trainTimeDao);
    }

    @Test
    public void testFindAllTime() throws Exception {
        List<TrainTime> trainTimeList = trainTimeDao.findAllTime();
        //lambda表达式
        trainTimeList.forEach(System.out::println);
    }

    @Test
    public void testFindTrainAndTrainTime() throws Exception {
        List<Train> trainList = trainTimeDao.findTrainAndTrainTime();
        for (Train train : trainList) {
            List<TrainTime> tts = train.getTrainTimeList();
            for (TrainTime tt : tts) {
                Station station = tt.getStation();
                System.out.println(station.getSname());
            }
        }
    }

    @Test
    public void testFindTrainByStartSidAndEndSid() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("sid1", 6);
        map.put("sid2", 12);
        List<Train> trains = trainTimeDao.findTrainByStartSidAndEndSid(map);
        trains.forEach(System.out::println);
    }

    @Test
    public void testGetTimeBySidAndTid() {
        String time = trainTimeDao.getStartTimeBySidAndTid(6, "D6332");
        if (time == null || time.equals("")) {
            System.out.println("空");
        } else {
            System.out.println(time);
        }
    }
}
