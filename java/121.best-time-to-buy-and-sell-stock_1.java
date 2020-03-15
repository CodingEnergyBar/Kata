/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
          /*  the price bought and the price sell
          Now the next element is 2 which have lower price than the stock 
          we bought previously which was 5. 
          So if we buy this stock at price $2 and 
          sells it in future then 
          we will surely earn more profit than the stock 
          we bought at price 5. So we bought stock at $2.
        */
        if(prices == null || prices.length < 2)
            return 0;

        int bought = prices[0], sold;
        int maxDiff=0; // sold - bought;

        for(int i=1; i<prices.length; i++){
            sold = prices[i];
            if(sold - bought > maxDiff)
                maxDiff = sold - bought;
            if(sold  < bought){
                bought = sold;
            }
        }
        return maxDiff;
        
    }
}
// @lc code=end

