package com.bapocalypse.train.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.bapocalypse.train.model
 * @Author: 陈淼
 * @Date: 2016/11/18
 * @Description:
 */
public class TrainMap {
    private int V;    //顶点数目
    private int E;    //边的数目
    private List<Integer>[] adj;

    public TrainMap(int V){
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for (int v = 0; v < V; v++){
            adj[v] = new ArrayList<>();
        }
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }
}
