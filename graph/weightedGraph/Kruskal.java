package weightedGraph;

import java.util.ArrayList;
import java.util.Collections;

import unionfind.UnionFind4;


public class Kruskal {
    private WeightedGraph G;
    //minimal spanning tree 
    private ArrayList<WeightedEdge> mst;
    private UnionFind4 uf;
    public Kruskal(WeightedGraph g){
        this.G = g;
        mst = new ArrayList<WeightedEdge>();
        CC cc = new CC(G);
        // 图如果不是联通的 就没有最小生成树
        if(cc.count() > 1)  return;
        // Kruskal
        ArrayList<WeightedEdge> edges = new ArrayList<>();
        for(int v=0; v<G.V(); v++){
            for(int w: G.adj(v)){
                //只加一个方向的
                if(v < w)
                    edges.add(new WeightedEdge(v, w, G.getWeight(v, w)));
            }
        }
        Collections.sort(edges);
        //就是最小生成树
        uf = new UnionFind4(G.V());
        for(WeightedEdge edge: edges){
            int v = edge.getV();
            int w = edge.getW();
            if(!uf.isConnected(v, w)){
                uf.unionElements(v, w);
                mst.add(edge);
            }
        }
        //每次新加入的边是否形成环??--->unionfind

    }
    
    public ArrayList<WeightedEdge> result(){
        return mst;
    }

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph("weighedGraph.txt");
        Kruskal kruskal = new Kruskal(g);
        System.out.println(kruskal.result());

    }
}