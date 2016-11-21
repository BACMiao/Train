package com.bapocalypse.train.serviceImpl;

import com.bapocalypse.train.dao.DistanceDao;
import com.bapocalypse.train.dao.StationDao;
import com.bapocalypse.train.model.Distance;
import com.bapocalypse.train.model.DistanceCustom;
import com.bapocalypse.train.model.Station;
import com.bapocalypse.train.service.TrainMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    private Map<String, List<Station>> adj;  //邻接表
    private Map<String, Boolean> marked = new HashMap<>();      //这个顶点调用过dfs()了吗？
    private Map<String, String> edgeTo = new HashMap<>();       //一个顶点所连接的上一个顶点
    private DistanceDao distanceDao;
    private StationDao stationDao;

    @Override
    public void initTrainMap() throws Exception {
        this.V = stationDao.countsStation();
        adj = new HashMap<>();
        List<DistanceCustom> distances = distanceDao.findAllDistance();  //获得所有连接
        List<Station> stations = stationDao.findAllStation();      //获得所有站点
        for (Station station : stations){                          //初始化邻接表和marked表
            adj.put(station.getSname(), new ArrayList<>());
            marked.put(station.getSname(), false);
        }
        for (DistanceCustom distance : distances){
            Station station1 = stationDao.findStationBySname(distance.getStationName1());
            Station station2 = stationDao.findStationBySname(distance.getStationName2());
            addEdge(station1, station2);
        }
    }

    /**
     * @funtion addEdge
     * @Description 向图中添加一条边station1-station2
     * @param station1 站点1
     * @param station2 站点2
     */
    @Override
    public void addEdge(Station station1, Station station2) {
        adj.get(station1.getSname()).add(station2);       //将station2添加到station1的链表中
        adj.get(station2.getSname()).add(station1);       //将station1添加到station2的链表中
        E++;
    }

    /**
     * @funtion dfs
     * @Description 深度优先查找算法
     * @param stationName 指定站点名
     * @throws Exception
     */
    @Override
    public void dfs(String stationName) throws Exception {
        marked.put(stationName, true);
        Station station = stationDao.findStationBySname(stationName);
        //将所有与目标站点相邻的站点标为true，并下一个站点连接的上一个顶点
        for (Station station1 : getAdj(station.getSname())){
            if (!marked.get(station1.getSname())){
                edgeTo.put(station1.getSname(), station.getSname());
                dfs(station1.getSname());
            }
        }
    }

    /**
     * @funtion getAdj
     * @Description 返回和指定站点相邻的所有站点
     * @param stationName 指定站点名
     * @return 站点列表
     */
    public List<Station> getAdj(String stationName) {
        return adj.get(stationName);
    }

    @Override
    public boolean hasPathTo(String stationName){
        return marked.get(stationName);
    }

    /**
     * @funtion pathTo
     * @Description 源站到指定站的路径，如果不存在返回空
     * @param stationName 指定站名
     * @return 路径列表
     * @throws Exception
     */
    @Override
    public Stack<Station> pathTo(String stationName) throws Exception {
        if (!hasPathTo(stationName))
            return null;
        Stack<Station> path = new Stack<>();
        //x = edgeTo.get(x):x顶点所连接的上一个顶点
        for (String x = stationName; marked.get(x); x = edgeTo.get(x)){
            path.push(stationDao.findStationBySname(x));
            if ( edgeTo.get(x) == null){
                break;
            }
        }
        return path;
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
