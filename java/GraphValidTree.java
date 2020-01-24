import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
    /**
     * @param n:     An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // 题意是给一个图 就是看有没有环
        // dfs / uninion find
        // union find 的理解
        // O(edges * nodes)
        if (n == 0) {
            return false;
        }

        // 在题中 不会表示重复的边[0, 1] [1, 0]不出现
        // 所以用边数去判断也可以
        if (edges.length != n - 1) {
            return false;
        }
        // f
        HashMap<Integer, Set<Integer>> fromTo = new HashMap();
        for (int i = 0; i < n; i++) {
            fromTo.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            // fromTo.putIfAbsent(from, new HashSet<Integer>());
            // fromTo.putIfAbsent(to, new HashSet<Integer>());
            // non-direction graph
            fromTo.get(to).add(from);
            fromTo.get(from).add(to);
        }

        System.out.println("fromTo" + fromTo.toString());

        HashSet<Integer> visited = new HashSet();
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        visited.add(0);
        // 如果一次遍历能访问到n个顶点和n-1条边，则是一棵树

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            // Set<Integer> toPoints = fromTo.get(cur, null);

            // System.out.println("cur "+ cur);
            // System.out.println("toPoints " + toPoints.toString());
            for (Integer t : fromTo.get(cur)) {
                if (visited.contains(t))
                    continue;
                queue.add(t);
                visited.add(t);
            }
        }
        return visited.size() == n;

    }
}