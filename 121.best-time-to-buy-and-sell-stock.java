/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // write your code here
        int minBuy = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price - minBuy > max)
                max = price - minBuy;
            if (price < minBuy)
                minBuy = price;
        }
        return max;
    }
}
// @lc code=end

