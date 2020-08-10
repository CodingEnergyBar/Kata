/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
        
    }
    void dfs(int[] nums, int start, List<Integer> path){
        //这里直接就上来放进去了
        //后面这段就可以不可以的
        res.add(new ArrayList<>(path));
        for(int i=start; i<nums.length; i++){
            //not added
            int cur = nums[i];
            path.add(cur);
            dfs(nums, i+1, path);
            path.remove(path.size()-1);
        }

    }
}
// @lc code=end

