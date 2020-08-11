package weightedGraph;

import java.util.ArrayList;
import java.util.Collections;

import unionfind.UnionFind4;


public class Prim {
    private WeightedGraph G;
    //minimal spanning tree 
    private ArrayList<WeightedEdge> mst;
    public Prim(WeightedGraph g){
        this.G = g;
        mst = new ArrayList<WeightedEdge>();
        CC cc = new CC(G);
        // 图如果不是联通的 就没有最小生成树
        if(cc.count() > 1)  return;
       
        // prim: 从一个切分开始, 一遍只有一个顶点, 另外一遍有 n-1 个点
        boolean[] visited = new boolean[G.V()];
        visited[0] = true;

        for(int i=1; i<G.V(); i++){
            // 每次扫密爱一遍所有的边
            WeightedEdge minEdge = new WeightedEdge(-1, -1, Integer.MAX_VALUE);
            for(int v=0; v<G.V(); v++){ //一个端点的 visited 是 true 一个是 false
                if(visited[v] == true){
                    for(int w: G.adj(v)){
                        int curWeight = G.getWeight(v, w);
                        if(!visited[w] && curWeight < minEdge.getWeight()){
                            minEdge = new WeightedEdge(v, w, curWeight);
                        }
                    }
                }
            }
            mst.add(minEdge);
            visited[minEdge.getV()] = true;
            visited[minEdge.getW()] = true;
        }
    }
    
    public ArrayList<WeightedEdge> result(){
        return mst;
    }

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph("weighedGraph.txt");
        Prim prim = new Prim(g);
        System.out.println(prim.result());

    }
}