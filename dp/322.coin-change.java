/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (33.75%)
 * Likes:    3204
 * Dislikes: 106
 * Total Accepted:    337.2K
 * Total Submissions: 994.3K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        // the fewest number of coins 
        // corner case: [2] 3 
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 0 元钱最少要几个硬币
        dp[0] =  0;
        for(int i=1; i<=amount; i++){
            for(int coin: coins){
                if(i-coin >=0 && dp[i-coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            } 
        }
        if(dp[amount] != Integer.MAX_VALUE)
             return dp[amount];
        else 
            return -1;
    }
}
// @lc code=end

