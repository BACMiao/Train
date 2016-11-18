package com.bapocalypse.train.serviceImpl;

import com.bapocalypse.train.dao.DistanceDao;
import com.bapocalypse.train.dao.StationDao;
import com.bapocalypse.train.model.Distance;
import com.bapocalypse.train.model.Station;
import com.bapocalypse.train.service.TrainMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package: com.bapocalypse.train.serviceImpl
 * @Author: 陈淼
 * @Date: 2016/11/18
 * @Description: 列车地图操作的实现类
 */
@Service
public class TrainMapServiceImpl implements TrainMapService {
    private int V;    //顶点数目
    private int E;    //边的数目
    private Map<Station, List<Station>> adj;
    private DistanceDao distanceDao;
    private StationDao stationDao;
    @Override
    public void initTrainMap() throws Exception {
        this.V = stationDao.countsStation();
        adj = new HashMap<>();
        List<Distance> distances = distanceDao.findAllDistance();
        for (Distance distance : distances){
            Station station1 = stationDao.findStationBySid(distance.getSid1());
            Station station2 = stationDao.findStationBySid(distance.getSid2());
            addEdge(station1, station2);
        }
    }

    @Override
    public void addEdge(Station station1, Station station2) {
        adj.put(station1, new  ArrayList<>());
        adj.put(station2, new  ArrayList<>());
        adj.get(station1).add(station2);       //将station2添加到station1的链表中
        adj.get(station2).add(station1);       //将station1添加到station2的链表中
        E++;
    }

    @Autowired
    public void setDistanceDao(DistanceDao distanceDao) {
        this.distanceDao = distanceDao;
    }

    @Autowired
    public void setStationDao(StationDao stationDao) {
        this.stationDao = stationDao;
    }
}
