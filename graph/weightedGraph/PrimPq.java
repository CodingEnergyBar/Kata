package weightedGraph;

import java.util.*;
import java.util.Collections;

import unionfind.UnionFind4;


public class PrimPq {
    private WeightedGraph G;
    //minimal spanning tree 
    private ArrayList<WeightedEdge> mst;
    public PrimPq(WeightedGraph g){
        this.G = g;
        mst = new ArrayList<WeightedEdge>();
        CC cc = new CC(G);
        // 图如果不是联通的 就没有最小生成树
        if(cc.count() > 1)  return;
       
        // prim: 从一个切分开始, 一遍只有一个顶点, 另外一遍有 n-1 个点
        boolean[] visited = new boolean[G.V()];
        visited[0] = true;
        Queue<WeightedEdge> pq = new PriorityQueue<WeightedEdge>();
        for(int w: G.adj(0))
            pq.add(new WeightedEdge(0, w, G.getWeight(0, w)));

        while(!pq.isEmpty()){
            WeightedEdge minEdge = pq.remove();
            if(visited[minEdge.getV()] && visited[minEdge.getW()])
                continue;
            mst.add(minEdge);
            int newv = visited[minEdge.getV()]? minEdge.getW(): minEdge.getV();
            visited[newv] = true ;
            for(int w: G.adj(newv)){
                if(!visited[w])
                    pq.add(new WeightedEdge(w, newv, G.getWeight(w, newv)));
            }

        }
    }
    
    public ArrayList<WeightedEdge> result(){
        return mst;
    }

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph("weighedGraph.txt");
        PrimPq primPq = new PrimPq(g);
        System.out.println(primPq.result());

    }
}