package com.bapocalypse.train.service;

import com.bapocalypse.train.model.Distance;
import com.bapocalypse.train.model.DistanceCustom;

import java.util.List;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: 距离操作的服务接口
 */
public interface DistanceService {
    boolean createDistance(Distance distance) throws Exception;
    List<DistanceCustom> findAllDistance() throws Exception;
}
