package com.bapocalypse.train.dao;

import com.bapocalypse.train.po.Carriage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @package: com.bapocalypse.train.dao
 * @Author: 陈淼
 * @Date: 2016/11/23
 * @Description: Dao接口，车厢表管理
 */
@Repository
public interface CarriageDao {
    List<Carriage> findCarriageByDescription(String description) throws Exception;
}
