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
        int res = 0;
        if(prices.length < 2){
            return res;
        }
        
        for(int i=0; i<prices.length-1;i++){
            for(int j=i; j<prices.length;j++){
                if(prices[j] - prices[i] > res){
                    res = prices[j] - prices[i];
                }
            }
        }
        return res;
    }
}
// @lc code=end

