/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        assert amount >=0 ;
        //[0...x]选 amount 的
        if(coins == null || coins.length == 0){
            if(amount == 0)
                return 1;
            else
                return 0;
        }
        int[][] memo = new int[coins.length][amount+1];
        for(int i=0; i<coins.length;i++){
            memo[i][0] = 1;
            int newcoin  = coins[i];
            for(int sum = 0; sum <= amount;sum++){
                int res=0;
                // 取 j 个 newcoin
                for(int j=0; j*newcoin<= sum; j++){
                    if(i-1>=0)
                        res += memo[i-1][sum-j*newcoin];
                    else if(sum -j*newcoin == 0)
                        res=1;
                }
                memo[i][sum] = res;
            }
          
        }
        return memo[coins.length-1][amount];
        
    }
}
// @lc code=end

