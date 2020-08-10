import java.util.*;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, new ArrayList<>(), target, res);
        return res;
    }

    private void dfs(int[] candidates, int p, List<Integer> path, int rest, List<List<Integer>> res) {
        if(rest == 0){
            res.add(new ArrayList<Integer>(path));
        }
        for(int i=p; i<candidates.length; i++){
            if(rest - candidates[i] >= 0 ){
                path.add(candidates[i]);
                dfs(candidates, i, path, rest-candidates[i], res);
                path.remove(path.size()-1);
            }
        }
    }

}
// @lc code=end

