package com.bapocalypse.train.dao;

import com.bapocalypse.train.model.Station;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: Dao接口，站点管理
 */
@Repository
public interface StationDao {
    Station findStationBySid(int sid) throws Exception;
    Station findStationBySname(String sname) throws Exception;
    List<Station> findSomeStationBySname(@Param(value = "sname") String sname) throws Exception;
    List<Station> findAllStation() throws Exception;
    boolean insertStation(Station station) throws Exception;
    Integer countsStation() throws Exception;
}
