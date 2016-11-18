package com.bapocalypse.train.serviceImpl;

import com.bapocalypse.train.dao.StationDao;
import com.bapocalypse.train.model.Station;
import com.bapocalypse.train.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @package: com.bapocalypse.train.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: 车站操作实现类
 */
@Service
public class StationServiceImpl implements StationService {
    private StationDao stationDao;

    @Override
    public Station findStationBySid(int sid) throws Exception {
        return stationDao.findStationBySid(sid);
    }

    @Override
    public int countsStation() throws Exception {
        return 0;
    }

    public StationDao getStationDao() {
        return stationDao;
    }

    @Autowired
    public void setStationDao(StationDao stationDao) {
        this.stationDao = stationDao;
    }
}
