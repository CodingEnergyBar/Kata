/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        //跟时间是没有关系的, 只跟数值有关系
        int buyDay = 0;
        int maxProfit = 0;

        for(int i=0; i<prices.length;i++){
            int profit = prices[i]  - prices[buyDay];
            if(profit > maxProfit){
                maxProfit = profit;
            }
            if(prices[i] < prices[buyDay]){
                buyDay = i;
            }
        }
        return maxProfit;
    }
}
// @lc code=end

