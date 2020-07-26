import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
  
    int N;
    public List<List<Integer>> permuteUnique(int[] nums) {
        N = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, getPool(nums), new ArrayList<Integer>());
        return res;
    }

    private void dfs(List<List<Integer>> res, Map<Integer, Integer> pool, ArrayList<Integer> path) {
        if(path.size() == N){
            res.add(new ArrayList<>(path));
            return;
        }
        //比较传统的 dfs
        for(Integer key: pool.keySet()){
            if(pool.get(key) == 0)
                continue;
            path.add(key);
            pool.put(key, pool.get(key) - 1);
            dfs(res, pool, path);
            pool.put(key, pool.get(key) + 1);
            path.remove(path.size()-1);
            
        }
    }

    private Map<Integer, Integer> getPool(int[] nums) {
        Map<Integer, Integer> pool = new HashMap<>();
        for(int num: nums){
            if(!pool.containsKey(num))
                pool.put(num, 1);
            else{
                pool.put(num, pool.get(num) + 1);
            }
        }
        return pool;
    }
}
// @lc code=end

