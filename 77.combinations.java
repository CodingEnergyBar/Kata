import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int N, K;
    public List<List<Integer>> combine(int n, int k) {
        N = n;
        K = k;
        dfs(1, new ArrayList<>());
        return res;
    }
    void dfs(int cur, List<Integer> path){
        if(path.size() == K){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        // 先加进去 然后再 从 i+1 到 N 这里面选一个
        // combine(List<Integer> comb, int start, int n, int k)
        // 从start 到 n 选 k 个
        for(int i = cur; i <= N; i++){
            path.add(i);
            dfs(i+1, path);
            path.remove(path.size() - 1);
        }
      
    }
}
// @lc code=end

