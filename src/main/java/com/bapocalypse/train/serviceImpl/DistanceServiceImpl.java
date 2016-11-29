package com.bapocalypse.train.serviceImpl;

import com.bapocalypse.train.dao.DistanceDao;
import com.bapocalypse.train.dao.StationDao;
import com.bapocalypse.train.po.Distance;
import com.bapocalypse.train.po.DistanceCustom;
import com.bapocalypse.train.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package: com.bapocalypse.train.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: 距离操作实现类
 */
@Service
public class DistanceServiceImpl implements DistanceService {
    private DistanceDao distanceDao;
    private StationDao stationDao;

    @Override
    public boolean createDistance(Distance distance) throws Exception {
        return distanceDao.insertDistance(distance);
    }

    public List<DistanceCustom> findAllDistance() throws Exception {
        return distanceDao.findAllDistance();
    }

    @Autowired
    public void setDistanceDao(DistanceDao distanceDao) {
        this.distanceDao = distanceDao;
    }

    @Autowired
    public void setStationDao(StationDao stationDao) {
        this.stationDao = stationDao;
    }
}
