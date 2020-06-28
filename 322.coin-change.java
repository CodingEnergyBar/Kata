import java.util.Arrays;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        // intialziation
        dp[0] = 0;
        // for(int coin: coins){
        //     dp[coin] = 1;
        // }
        for(int a=1; a <= amount; a++){
            int res = Integer.MAX_VALUE;
            for(int coin: coins){
                if(a - coin >= 0 && dp[a - coin] != -1){
                    res = Math.min(res, dp[a - coin] + 1);
                }
            }
            if(res != Integer.MAX_VALUE)
                dp[a] = res;
        }
        return dp[amount];
    }
}
// @lc code=end

