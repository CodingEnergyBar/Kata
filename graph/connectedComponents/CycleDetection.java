import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CycleDetection {

    private Graph G;
    private int s, t;

    private int[] pre;
    private boolean[] visited;

    private boolean hasCycle;

    public CycleDetection(Graph G) {
        visited = new boolean[G.V()];
        pre = new int[G.V()];

        Arrays.fill(pre, -1);
        Arrays.fill(visited, false);

        this.s = s;
        this.t = t;
        this.G = G;

        //dfs 还是要在构造函数里面
        for(int v=0; v<G.V(); v++) {
            if(!visited[v]) {
                if (dfs(v, v)) {
                    hasCycle = true;
                }
            }
        }
    }
    public boolean hasCycle (){
        return hasCycle;
    }
    boolean dfs(int v, int parent){

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
            }else if(w != parent)
                return true;
        }
        return false;
    }



    public static void main(String[] args){

        Graph g = new Graph("g.txt");
        CycleDetection cycleDetection = new CycleDetection(g);
        System.out.println(cycleDetection.hasCycle());

        Graph g2 = new Graph("g2.txt");
        CycleDetection cycleDetection2 = new CycleDetection(g2);
        System.out.println(cycleDetection2.hasCycle());
    }
}