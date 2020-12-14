package directedGraph;
import java.util.ArrayList;

public class GraphDFS {

    private Graph G;
    private boolean[] visited;

    private ArrayList<Integer> order = new ArrayList<>();
    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();

    public GraphDFS(Graph G){

        this.G = G;
        visited = new boolean[G.V()];
        dfs(0);
    }

    private void dfs(int v){

        visited[v] = true;
        pre.add(v);
        for(int w: G.adj(v))
            if(!visited[w])
                dfs(w);
        post.add(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }


    public static void main(String[] args){

        Graph g = new Graph("ug.txt", true);
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println(graphDFS.pre());
        System.out.println(graphDFS.post());
    }
}
