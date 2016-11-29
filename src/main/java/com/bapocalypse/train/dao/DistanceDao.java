package com.bapocalypse.train.dao;

import com.bapocalypse.train.po.Distance;
import com.bapocalypse.train.po.DistanceCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: Dao接口，距离管理
 */
@Repository
public interface DistanceDao {
    boolean insertDistance(Distance distance) throws Exception;
    Integer countsDistance() throws Exception;
    List<DistanceCustom> findAllDistance() throws Exception;
}
