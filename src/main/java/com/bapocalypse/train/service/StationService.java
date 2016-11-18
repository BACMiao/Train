package com.bapocalypse.train.service;

import com.bapocalypse.train.model.Station;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: 车站操作的服务接口
 */
public interface StationService {
    Station findStationBySid(int sid) throws Exception;
    int countsStation() throws Exception;
}
