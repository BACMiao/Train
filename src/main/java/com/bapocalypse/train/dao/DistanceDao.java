package com.bapocalypse.train.dao;

import com.bapocalypse.train.model.Distance;
import org.springframework.stereotype.Service;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: Dao接口，距离管理
 */
@Service
public interface DistanceDao {
    boolean insertDistance(Distance distance) throws Exception;
    Integer countsDistance() throws Exception;
}
