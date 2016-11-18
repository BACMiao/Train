package com.bapocalypse.train.dao;

import com.bapocalypse.train.model.Station;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: Dao接口，站点管理
 */
@Service
public interface StationDao {
    Station findStationBySid(int sid) throws Exception;
    List<Station> findStationBySname(@Param(value = "sname") String sname) throws Exception;
    boolean insertStation(Station station) throws Exception;
    Integer countsStation() throws Exception;
}
