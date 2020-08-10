import java.util.ArrayList;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>());
        return res;
        
    }

    void dfs(int start, int[] nums, List<Integer> path){
        res.add(new ArrayList<>(path));
        int i=start;
        while(i<nums.length){
            path.add(nums[i]);
            dfs(i+1, nums, path);
            path.remove(path.size()-1);
            i++;
            while (i<nums.length  && nums[i] == nums[i - 1]) i++;   
        }

    }
}
// @lc code=end

