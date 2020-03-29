/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    int[][] memo;
    public int change(int amount, int[] coins) {
    //     //[0...amount] 有多少种
    //    int[] memo = new int [amount+1];
    //    // intialize
    //    memo[0] = 1;
    //    for(int coin: coins){
    //        if(coin <= amount)
    //         memo[coin]++;
    //    }
        
    //    for(int i=0; i<=amount;i++){
    //        for(int j=0; j<coins.length;j++){
    //             if(i-coins[j] >= 0)
    //                 // 不能只是相加的关系, 要有一个范围
    //                 memo[i] += memo[i-coins[j]];
    //        }
    //    }
         //在有[x..len-1]coins  中 找 amount的
         memo = new int[coins.length][amount+1];
         for(int[] arr: memo){
             Arrays.fill(arr, -1);
         }

         return findCoin(0, coins, amount);
        //  System.out.println(Arrays.deepToString(memo));
         

    }
    int findCoin(int start, int[] coins, int amount){
        // coins[start] 取 1,2,3,
        if(amount <0)
            return 0;
        if(amount == 0){
            return 1;
        }
        if(start > coins.length-1)
            return 0;

        if(memo[start][amount] != -1)
            return memo[start][amount];
        int res = 0;
        for(int j=0; j*coins[start] <= amount; j++){
            res +=  findCoin(start+1, coins, amount- j*coins[start]);
        }
        memo[start][amount] = res;
        return res;
    }
    
}
// @lc code=end

