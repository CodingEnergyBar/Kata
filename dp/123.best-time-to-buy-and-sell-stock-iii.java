/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms Hard (36.15%) Likes: 1772 Dislikes: 69 Total Accepted: 195.8K Total Submissions: 538K
 * Testcase Example: '[3,3,5,0,0,3,1,4]'
 *
 * Say you have an array for which the i^th element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock
 * before you buy again).
 * 
 * Example 1:
 * 
 * 
 * Input: [3,3,5,0,0,3,1,4] Output: 6 Explanation: Buy on day 4 (price = 0) and sell on day 6 (price
 * = 3), profit = 3-0 = 3. Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1
 * = 3.
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,4,5] Output: 4 Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5),
 * profit = 5-1 = 4. Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no transaction is done, i.e. max profit =
 * 0.
 * 
 */

// @lc code=start
class Solution {
    // !!! two transactions
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        // 五个阶段 每个阶段依赖前一个阶段的状态
        int[][] f = new int[n + 1][5 + 1];
        int i, j, k;
        for (k = 2; k <= 5; k++) {
            f[0][k] = Integer.MIN_VALUE;// impossible
        }
        f[0][1] = 0;// 表示前 0 天状态为 1 的时候 收入

        for (i = 1; i <= n; i++) {
            // 阶段 1, 3,5
            for (j = 1; j <= 5; j += 2) {
                // 维持状态不变 还是不买入, 不持有股票
                f[i][j] = f[i - 1][j];
                if (j > 1 && i > 1 && f[i - 1][j - 1] != Integer.MIN_VALUE) {
                    // 之前持有股票, 然后今天把他卖掉 今天是 i-1 天 + 今天的获利
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            // 阶段 2,4的时候 ---> 有股票: 昨天刚买, 今天有股票的状态
            for (j = 2; j <= 5; j += 2) {
                // 维持状态不变 还是不卖出, 持有现在的股票, 这里等于 i-1 表示卖出了前一天的股票,
                // 这样就不用记住什么时候买的了, 买了又卖了, 相当于没做操作
                f[i][j] = f[i - 1][j - 1];
                if (i > 1 && f[i - 1][j] != Integer.MIN_VALUE) {
                    // 今天继续持有, 要算上今天的获利
                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
            }

        }
        int res = 0;
        for (j = 1; j <= 5; j += 2) {
            res = Math.max(res, f[n][j]);
        }
        return res;

    }
}
// @lc code=end

