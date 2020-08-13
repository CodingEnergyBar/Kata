package weightedGraph;

import java.util.*;
import java.util.Collections;

import unionfind.UnionFind4;


class Node implements Comparable<Node>{
    public int dis, v;
    public Node(int v, int dis){
        this.v = v;
        this.dis = dis;
    }
    @Override
    public int compareTo(Node another) {
        // TODO Auto-generated method stub
        return this.dis - another.dis;
    }
}

public class DijkstraOp {
    private WeightedGraph G;
    private int s;
    private int[] dis;
    private boolean[] visited;

    //从 s 到其他顶点的最短路径
    public DijkstraOp(WeightedGraph g, int s){
        this.G = g;
        this.s = s;
        dis = new int[G.V()];
        visited = new boolean[G.V()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        //原点到原点的距离
        dis[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

        while(!pq.isEmpty()){
            Node cur = pq.remove();
            int v = cur.v;
            if (visited[v])
                continue;
            visited[v] = true;

            for(int w: G.adj(v)){
                if(visited[w] &&  dis[v] + G.getWeight(v, w) <dis[w]){
                    dis[w] =  dis[v] + G.getWeight(v, w);
                    // 优先队列中可能有多份相同顶点
                    pq.add(new Node(w, dis[w]));

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
        Dijkstra dijkstra = new Dijkstra(g, 0);
        for(int v=0; v<g.V(); v++){
            System.out.println(dijkstra.distTo(v));
        }

    }
}