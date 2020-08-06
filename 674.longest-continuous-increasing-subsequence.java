/*
 * @lc app=leetcode id=674 lang=java
 *
 * [674] Longest Continuous Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int max = 1;
        // int dp[] = new int[nums.length];
        // !!! 不用 数组也可以不需要只到每个包含 nums[i]的最长 LCIS, 只需要知道上一个
        // // including the nums[i], longest 
        // dp[0] = 1;
        // for(int i=1; i<dp.length; i++){
        //     dp[i] = (nums[i] > nums[i-1])? dp[i-1] + 1: 1;
        //     max = Math.max(dp[i], max);
        // }

       int lastLCIScount = 1;
        // 不用 数组也可以不需要只到每个包含 nums[i]的最长 LCIS, 只需要知道上一个
        // including the nums[i], longest
        for (int i = 1; i < nums.length; i++) {
            lastLCIScount = (nums[i] > nums[i - 1]) ? lastLCIScount + 1 : 1;
            max = Math.max(lastLCIScount, max);
        }
        return max;
        
    }
}
// @lc code=end

