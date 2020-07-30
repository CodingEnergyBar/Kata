import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);
        for(int i=0; i< M.length; i++){
            for(int j=i+1; j<M.length; j++){
               if(M[i][j] == 1) uf.unionElements(i, j);
            }
        }
        int res = 0;
        for(int i=0; i<M.length; i++){
            if(uf.parent[i] == i)
                res++;
        }
        return res;
    }
    class UF{
        public int[] parent;
        UF(int size){
            parent = new int[size];
            for(int i=0; i<size; i++){
                parent[i] = i;
            }
            
        }
        boolean isConnected(int i, int j){
            if(find(i) == find(j))
                return true;
            return false;
        }
        int find(int cur){
            if(parent[cur] == cur){
                return cur;
            }
            parent[cur] = find(parent[cur]);
            return parent[cur];
        }
        //是祖先节点的连接
        void unionElements(int i, int j){
            int pi = find(i);
            int pj = find(j);
            parent[pi] = pj;
        }
   
    }
}
// @lc code=end

