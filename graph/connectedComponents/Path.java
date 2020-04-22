import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Path {

    private Graph G;
    private int s, t;

    private int[] pre;
    private boolean[] visited;

    public Path(Graph G, int s, int t) {
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        Arrays.fill(pre, -1);
        Arrays.fill(visited, false);
        this.s = s;
        this.t = t;
        this.G = G;

        dfs(this.s, this.s);
    }

    boolean dfs(int v, int parent){
        //在这里记住 就可以避免函数外赋初始值
        visited[v] =  true;
        pre[v] = parent;

        if(v == t){
            return true;
        }

        for(int w: G.adj(v)){
            if(!visited[w]){
                //还要再有个逻辑去判断 true/false
                if(dfs(w, v))
                    return true;
            }
        }
        return false;
    }

    boolean isConnected() {
        //dfs遍历过了 就是connected 否则不 connected
        return visited[t];
    }

    public List<Integer> path(){
        List<Integer> res = new LinkedList<>();
        if(!isConnected()) {

            return res;
        }
        int cur = t;
        //类似 union find 的思想
        while(cur != pre[cur]){
            res.add(0, cur);
            cur = pre[cur];
        }
        res.add( 0, cur);
        return res;
    }

    public static void main(String[] args){

        Graph g = new Graph("graph.txt");
        Path path = new Path(g, 0, 6);
        System.out.println("0 -> 6 : " + path.path());

        Path path2 = new Path(g, 0, 5);
        System.out.println("0 -> 5 : " + path2.path());

        Path path3 = new Path(g, 0, 1);
        System.out.println("0 -> 1 : " + path3.path());
    }
}