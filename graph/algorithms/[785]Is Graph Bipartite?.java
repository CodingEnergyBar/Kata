//Given an undirected graph, return true if and only if it is bipartite. 
//
// Recall that a graph is bipartite if we can split it's set of nodes into two i
//ndependent subsets A and B such that every edge in the graph has one node in A a
//nd another node in B. 
//
// The graph is given in the following form: graph[i] is a list of indexes j for
// which the edge between nodes i and j exists. Each node is an integer between 0 
//and graph.length - 1. There are no self edges or parallel edges: graph[i] does n
//ot contain i, and it doesn't contain any element twice. 
//
// 
//Example 1:
//Input: [[1,3], [0,2], [1,3], [0,2]]
//Output: true
//Explanation: 
//The graph looks like this:
//0----1
//|    |
//|    |
//3----2
//We can divide the vertices into two groups: {0, 2} and {1, 3}.
// 
//
// 
//Example 2:
//Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
//Output: false
//Explanation: 
//The graph looks like this:
//0----1
//| \  |
//|  \ |
//3----2
//We cannot find a way to divide the set of nodes into two independent subsets.
// 
//
// 
//
// Note: 
//
// 
// graph will have length in range [1, 100]. 
// graph[i] will contain integers in range [0, graph.length - 1]. 
// graph[i] will not contain i or duplicate values. 
// The graph is undirected: if any element j is in graph[i], then i will be in g
//raph[j]. 
// 
// Related Topics Depth-first Search Breadth-first Search Graph


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //Example 1:
    //Input: [[1,3], [0,2], [1,3], [0,2]]
    //Output: true
    //Explanation:
    //The graph looks like this:
    //0----1
    //|    |
    //|    |
    //3----2
    boolean[] visited;
    int[] color;
    int V;
    public boolean isBipartite(int[][] graph) {
        V = graph.length;
        // 这里的 corner case 被包含了
        // if(V <= 1)
        // return false;
        color = new int[V];
        visited = new boolean[V];


        for(int v=0; v<V; v++)
            if(!visited[v]) // 是用 v 带入, 不连通也没问题
                if(!dfs(v, 0, graph))
                    return false;

        return true;
    }
    boolean dfs(int v, int c, int[][] graph){
        //要 visisted
        visited[v] = true;
        color[v] = c;
        for(int w: graph[v]){
            if(!visited[w]){
                if(!dfs(w, 1-c, graph))
                    return false;
            }else if(color[w] == color[v])  // visited[w]
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
