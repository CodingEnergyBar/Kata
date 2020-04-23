import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphDFSnr {
    Graph g;
    boolean[] visited;

    List<Integer> preOrder;


    GraphDFSnr(Graph g){
        this.g = g;
        visited = new boolean[g.V()];
        preOrder = new ArrayList<>();
        for(int v=0; v<g.V();v++){
            if(!visited[v])
                    dfs(v);
        }
    }

    public List<Integer> pre(){
        return preOrder;
    }

    void dfs(int v){
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;

        while(!stack.isEmpty()){
            int cur = stack.pop();
            //pop 的时候相当于 visited
            preOrder.add(cur);
            for(int n: g.adj(v)){
                if(!visited[n]) {
                    stack.push(n);
                    visited[n] = true;
                }
            }
        }
    }
    public static void main(String[] args){
        Graph g = new Graph("g.txt");
        GraphDFSnr graphDFSnr = new GraphDFSnr(g);
        System.out.println(graphDFSnr.pre());

    }

}
