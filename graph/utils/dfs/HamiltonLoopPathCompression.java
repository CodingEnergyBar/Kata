package graph.utils.dfs;

import java.util.ArrayList;
import java.util.Collections;

import graph.utils.Graph;

public class HamiltonLoopPathCompression {

    private Graph G;
    // private boolean[] visited;
    int visited;
    private int[] pre;
    private int end;

    public HamiltonLoopPathCompression(Graph G){
        this.G = G;
        // visited = new boolean[G.V()];
        visited = 0;
        pre = new int[G.V()];
        end = -1;
        dfs(0, 0);
    }


    private boolean dfs(int v, int parent){
        //压栈: 入口的时候把 visited 改成 true, 入队的时候
        //000000
        // visited[v] = true;
        // visited = addVisited(visited, v);
        visited += (1 << v);
        pre[v] = parent;

        for(int w: G.adj(v)){
            // if(!visited[w]){
            // if(checkVisited(visited, w)){ 
                //&的优先级非常低 小于 ==
            if((visited & (1 << w)) == 0){
                // pre[w] = v;
                if(dfs(w, v))
                    return true;
                // else // 什么都不应该管
                //     continue;
            }else if(w == 0 && allVisited() == true){
                // 程序的出口
                end = v;
                return true;
            }
        }
        //出栈: 回溯
        // visited[v] = false;
        visited -= (1 << v);
        return false;
    }
    
    boolean allVisited(){
        return visited == ((1 << (G.V() + 1)) - 1);
    }
    int addVisited(int visited, int bit){
        return visited + (1 << bit);
    }
    
    int removeVisited(int visited, int bit) {
        return visited - (1 << bit);
    }
    boolean checkVisited(int visited, int num){
        if((visited & (1 << num)) == 1)
            return true;
        return false;
    }
    public Iterable<Integer> result(){
        ArrayList<Integer> res = new ArrayList<>();
        if(end == -1) return res;
        while( end != 0){
            res.add(end);
            end = pre[end];
        }
        res.add(0);
        Collections.reverse(res);

        return res;
    }



    public static void main(String[] args){
        Graph g = new Graph("graph.txt");
        // System.out.println(g.V());
        HamiltonLoopPathCompression hamiltonLoop = new HamiltonLoopPathCompression(g);
        System.out.println(hamiltonLoop.result());
    }
}
