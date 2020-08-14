package weightedGraph;

import java.util.*;
import java.util.Collections;

import unionfind.UnionFind4;


public class Dijkstra {
    private WeightedGraph G;
    private int s;
    private int[] dis;
    private boolean[] visited;

    //从 s 到其他顶点的最短路径
    public Dijkstra(WeightedGraph g, int s){
        this.G = g;
        this.s = s;
        dis = new int[G.V()];
        visited = new boolean[G.V()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        //原点到原点的距离
        dis[s] = 0;

        while(true){
            //最小的 dis 值对应的顶点值
            int curdis = Integer.MAX_VALUE, cur=-1;
            for(int v=0; v<G.V(); v++){
                if(!visited[v] && dis[v] < curdis){
                    curdis = dis[v];
                    cur = v;
                }
            }
            if(cur == -1) break;
            //哪些顶点的最短路径已经求出来了
            visited[cur] = true;
            for(int w: G.adj(cur)){
                if(!visited[w]){
                    if(dis[cur] + G.getWeight(cur, w) < dis[w]) {
                        dis[w] = dis[cur] + G.getWeight(cur, w);
                    }
                }
            }
        }
    }

    public boolean isConnectedTo(int v){
        G.validateVertex(v);
        return visited[v];
    }

    public int distTo(int v){
        G.validateVertex(v);
        return dis[v];
    }

    

    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph("weighedGraph.txt");
        DijkstraOpPath dijkstra = new DijkstraOpPath(g, 0);
        for(int v=0; v<g.V(); v++){
            System.out.println(dijkstra.distTo(v));
        }

    }
}