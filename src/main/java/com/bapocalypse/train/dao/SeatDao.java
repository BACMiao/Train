package com.bapocalypse.train.dao;

import com.bapocalypse.train.po.Seat;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/23
 * @Description: Dao接口，座位表管理
 */
@Repository
public interface SeatDao {
    List<Seat> findSeatsByCid(Integer cid) throws Exception;
}
