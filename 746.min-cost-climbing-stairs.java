/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
   
        int[] dp = new int[cost.length+1];
        //dp[0] 到达这部要付出的 cost 0
        //dp[1] 起始点可以是这里 往下走才会造成 cost
        for(int i=2; i<cost.length+1; i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);            
        }
        return dp[dp.length -1];
    }
}
// @lc code=end

