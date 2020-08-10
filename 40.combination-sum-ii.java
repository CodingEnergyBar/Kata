import java.util.*;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    TreeMap<Integer, Integer> pool = new TreeMap<>();
    List<Integer> keys;
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(candidates);
        for(int i: candidates){
            if(!pool.containsKey(i)){
                pool.put(i, 0);
            }
            pool.put(i, pool.get(i) + 1);
        }
        keys = new ArrayList<>(pool.keySet());
        dfs(new ArrayList<>(), 0, target);
        return res;

    }
    void dfs(List<Integer> path, int p, int rest){
        if(rest == 0){
            res.add(new ArrayList<>(path));
        }
        for(int i = p;i<candidates.length;i++)
        {
            if (i > p && candidates[i] == candidates[i - 1]) continue; /** skip duplicates */
            int cur = candidates[i];
            if (rest - cur >= 0) {
                path.add(cur);
                dfs(path, i+1, rest - cur);
                path.remove(path.size() - 1);
            }
        }
    }

}
// @lc code=end

