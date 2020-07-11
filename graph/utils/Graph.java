package graph.utils;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;
import java.util.Scanner;


/// 暂时只支持无向无权图
public class Graph {

    private int V;
    private int E;
    private TreeSet<Integer>[] adj;

    public Graph(String pathStr){

        File file = new File(pathStr);

        try (Scanner scanner = new Scanner(file)) {

            V = scanner.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("V must be non-negative");
            adj = new TreeSet[V];
            for (int i = 0; i < V; i++)
                adj[i] = new TreeSet<Integer>();

            E = scanner.nextInt();
            if (E < 0)
                throw new IllegalArgumentException("E must be non-negative");

            for (int i = 0; i < E; i++) {
                final int a = scanner.nextInt();
                validateVertex(a);
                final int b = scanner.nextInt();
                validateVertex(b);

                if (a == b)
                    throw new IllegalArgumentException("Self Loop is Detected!");
                if (adj[a].contains(b))
                    throw new IllegalArgumentException("Parallel Edges are Detected!");

                adj[a].add(b);
                adj[b].add(a);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void validateVertex(final  int v){
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + "is invalid");
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public boolean hasEdge(final int v,  final int w){
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }

    public Iterable<Integer> adj(final  int v){
        validateVertex(v);
        return adj[v];
    }

    public int degree(final  int v){
        validateVertex(v);
        return adj[v].size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int v = 0; v < V; v++) {
            sb.append(String.format("%d : ", v));
            for (final int w : adj[v])
                sb.append(String.format("%d ", w));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(final String[]  args){

        final Graph g = new Graph("g.txt");
        System.out.print(g);
    }
}
