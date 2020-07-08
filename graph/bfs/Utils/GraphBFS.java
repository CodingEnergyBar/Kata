import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {

    private Graph G;
    private boolean[] visited;
    List<Integer> order;

    GraphBFS(Graph g){
        this.G = g;
        order = new ArrayList<Integer>();
        visited = new boolean[G.V()];
        bfs();
    }
    void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            visited[cur] = true;
            order.add(cur);
            for(int w: G.adj(cur)){
                if(!visited[w]){
                    queue.add(w);
                }
            }
        }
    }

    List<Integer> order(){
        return order;
    }

    public static void main(String args[]){

        Graph g = new Graph("g.txt");
        GraphBFS graphBFS = new GraphBFS(g);
        System.out.println("BFS Order : " + graphBFS.order());

    }

}
