package weightedGraph;
import java.util.*;

public class BellmanFord {
    private WeightedGraph G;
    private int s;
    private int[] dis;
    private int[] pre;
    private boolean hasNegativeCycle;

    public BellmanFord(WeightedGraph G, int s){
        this.G = G;
        G.validateVertex(s);
        this.s = s;

        dis = new int[G.V()];
        pre = new int[G.V()];

        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(pre, Integer.MAX_VALUE);
        dis[s] = 0;
        pre[s] = s;
        for(int pass=1; pass<G.V(); pass++){
            for(int v=0; v<G.V(); v++)
                for(int w: G.adj(v)){
                    if(dis[v] != Integer.MAX_VALUE && dis[v] + G.getWeight(v, w) < dis[w]){
                        dis[w] = dis[v] + G.getWeight(v, w);  
                        pre[w] = v;
                    }
                }
        }
        //第V次
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v)) {
                if (dis[v] != Integer.MAX_VALUE && dis[v] + G.getWeight(v, w) < dis[w]) {
                    dis[w] = dis[v] + G.getWeight(v, w);
                    hasNegativeCycle = true;
                    break;
                }
            }
    }

    // 
    public Iterable<Integer> path(int t){
        ArrayList<Integer> res = new ArrayList<>();
        
        
    }

    
}