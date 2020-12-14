package directedGraph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {

    private final Graph G;
    private final boolean[] visited;
    List<Integer> order;

    GraphBFS(final Graph g) {
        this.G = g;
        order = new ArrayList<Integer>();
        visited = new boolean[G.V()];
        bfs();
    }

    void bfs() {
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            final int cur = queue.poll();
            visited[cur] = true;
            order.add(cur);
            for (final int w : G.adj(cur)) {
                if (!visited[w]) {
                    queue.add(w);
                }
            }
        }
    }

    List<Integer> order() {
        return order;
    }

    public static void main(final String args[]) {

        final Graph g = new Graph("ug.txt");
        final GraphBFS graphBFS = new GraphBFS(g);
        System.out.println("BFS Order : " + graphBFS.order());

    }

}
