import java.util.ArrayList;
import java.util.Arrays;

public class CC {

    private Graph G;
    private int[] visited;
    private int cccount = 0;

    public CC(Graph G){

        this.G = G;
        visited = new int[G.V()];

        Arrays.fill(visited, -1);
        for(int v = 0; v < G.V(); v ++)
            if(visited[v] == -1){
                dfs(v, cccount);
                cccount ++;
            }
    }

    private void dfs(int v, int ccid){

        visited[v] = ccid;
        for(int w: G.adj(v))
            if(visited[w] == -1)
                dfs(w, ccid);
    }

    public int count(){
        for(int ccid: visited){
            System.out.print(ccid + " ");
        }
        System.out.println();
        return cccount;
    }
    public boolean isConnected(int v, int w){
        return visited[v] == visited[w];
    }

    public ArrayList<Integer>[] components(){
        ArrayList<Integer>[] res = new ArrayList[cccount];
        Arrays.fill(res, new ArrayList<Integer>());
        for(int v=0; v< G.V(); v++){
            int ccid = visited[v];
            res[ccid].add(v);
        }
        return res;
    }

    public static void main(String[] args){

        Graph g = new Graph("graph.txt");
        CC cc = new CC(g);
        System.out.println(cc.count());
    }
}
