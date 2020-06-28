package lintcode629;
import java.util.*;
/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */


public class Solution {
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    int V;
    List<Connection> connections;
    HashMap<String, Integer> cityToPos;
    TreeMap<Integer, Integer>[] adj;
    
    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        // whether it is connected first
        // cityname  -> pos
        this.connections = connections;
        this.cityToPos = new HashMap<>();

        
        List<Connection> res = new ArrayList<>();

        if(init() == false)
            return res;
        
        //edges;
         Collections.sort(connections, (c1, c2)-> (c1.cost - c2.cost));
        UF uf = new UF(this.V);
         for(Connection c: connections){
            String c1 = c.city1;
            String c2 = c.city2;
            int p1 = getPos(c1);
            int p2 = getPos(c2);
            if(!uf.isConnected(p1, p2)){
                res.add(c);
                uf.union(p1, p2);
            }
         }
         return res;
    }
    // find whether connected all of them
    public boolean init(){

        for(Connection c: connections){
            String c1 = c.city1;
            String c2 = c.city2;
            int p1 = getPos(c1);
            int p2 = getPos(c2);
        }
        
        this.V = cityToPos.size();
        this.adj = new TreeMap[V];
        for(int i = 0; i<V; i++){
            adj[i] = new TreeMap<Integer, Integer>();
        }

        for(Connection c: connections){
            String c1 = c.city1;
            String c2 = c.city2;
            int cost = c.cost;
            int p1 = getPos(c1);
            int p2 = getPos(c2);
            adj[p1].put(p2, cost);
            adj[p2].put(p1, cost);
            
        }
        // bfs.
        boolean[] visited = new boolean[this.V];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(Map.Entry<Integer, Integer> entry: adj[cur].entrySet()){
                int v = entry.getKey();
                if(!visited[v]){
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        for(int v=0; v<this.V; v++){
            if(visited[v] == false)
                return false;
        }
        return true;
    }

    
    int getPos(String city){
        int pos = cityToPos.size();
        if(!cityToPos.containsKey(city)){
            cityToPos.put(city, pos);
        }
        return cityToPos.get(city);
    }
    public static void main(String[] args) {
        List<Connection> input = new ArrayList<>();
        input.add(new Connection("Acity","Bcity",1));
        input.add(new Connection("Bcity","Acity",2));
        input.add(new Connection("Ccity","Dcity",3));
        input.add(new Connection("Dcity","Ccity",3));
        new Solution().lowestCost(input);
    }
    
    
}
