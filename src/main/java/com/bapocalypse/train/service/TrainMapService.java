package com.bapocalypse.train.service;

import com.bapocalypse.train.po.Station;
import java.util.Stack;

/**
 * @package: com.bapocalypse.train.service
 * @Author: 陈淼
 * @Date: 2016/11/18
 * @Description: 列车地图操作的服务接口
 */
public interface TrainMapService {
    void initTrainMap() throws Exception;
    void addEdge(Station station1, Station station2);
    void dfs(String stationName) throws Exception ;
    boolean hasPathTo(String stationName);
    Stack<Station> pathTo(String stationName) throws Exception;
}
