package com.bapocalypse.train.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @package: com.bapocalypse.train.util
 * @Author: 陈淼
 * @Date: 2016/11/17
 * @Description: 图表测试类
 */
public class Graph {
    private int V;          //顶点数目
    private int E;          //边的数目
    List<Integer>[] adj;    //邻接表
    public Graph(int V){
        this.V = V;
        this.E = 0;
        for (int v =0; v < V; v++){
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public List<Integer> adj(int v){
        return adj[v];
    }
}
