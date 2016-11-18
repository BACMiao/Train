package com.bapocalypse.train.serviceImpl;

import com.bapocalypse.train.dao.DistanceDao;
import com.bapocalypse.train.model.Distance;
import com.bapocalypse.train.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @package: com.bapocalypse.train.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: 距离操作实现类
 */
@Service
public class DistanceServiceImpl implements DistanceService {
    private DistanceDao distanceDao;

    @Override
    public boolean createDistance(Distance distance) throws Exception {
        return distanceDao.insertDistance(distance);
    }

    public DistanceDao getDistanceDao() {
        return distanceDao;
    }

    @Autowired
    public void setDistanceDao(DistanceDao distanceDao) {
        this.distanceDao = distanceDao;
    }
}
