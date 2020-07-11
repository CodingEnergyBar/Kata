package graph.utils.dfs;

import java.util.ArrayList;
import java.util.Collections;

import graph.utils.Graph;

public class HamiltonLoop {

    private Graph G;
    private boolean[] visited;
    private int[] pre;
    private int end;

    public HamiltonLoop(Graph G){
        this.G = G;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        end = -1;
        dfs(0, 0);
    }


    private boolean dfs(int v, int parent){
        //压栈: 入口的时候把 visited 改成 true, 入队的时候
        visited[v] = true;
        pre[v] = parent;

        for(int w: G.adj(v)){
            if(!visited[w]){
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
        visited[v] = false;
        return false;
    }
    boolean allVisited(){
        for(boolean i: visited){
            if(i == false) return false;
        }
        return true;
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
        System.out.println(g.V());
        HamiltonLoop hamiltonLoop = new HamiltonLoop(g);
        System.out.println(hamiltonLoop.result());
    }
}
