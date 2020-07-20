/*
 * @lc app=leetcode id=685 lang=java
 *
 * [685] Redundant Connection II
 */

// @lc code=start
class Solution {
    class UnionFind{
        int parent[];
        UnionFind(int size){
            parent =  new int[size];
        }
        void unionElement(int p, int q){
            parent[q] = p;
        }
        int find(int p){
            while(parent[p] != p){
                p = parent[p];
            }
            return p;
        }
        boolean isConnected(int p, int q){
            return find(p) == find(q);
            
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
    }
}
// @lc code=end

