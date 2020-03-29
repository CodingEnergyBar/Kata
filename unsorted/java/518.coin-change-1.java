/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    int[][] memo;

    public int change(int amount, int[] coins) {
        // [0...amount]
        // Arrays.sort(coins);
        memo = new int[coins.length][amount + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        // Arrays.sort(coins);

        // from [start...len-1] 选 amount 中方案的方法

        int res = plans(coins, 0, amount);
        System.out.println(Arrays.deepToString(memo));
        return res;

    }

    // [0...]
    // 从[start...len-1]选的方案
    int plans(int[] coins, int start, int amount) {

        // if (start >= coins.length) {
        // // System.out.println("was wrong");
        // return 0;
        // }
        if (start >= coins.length) {
            if (amount == 0)
                return 1;
            else
                return 0;
        }
        if (amount == 0) {
            // memo[start][amount] = 1;
            return 1;
        }

        if (memo[start][amount] != -1)
            return memo[start][amount];

        int res = 0;
        int cur = coins[start];

        // select cur 进入的时候已经保证不会
        for (int i = 0; i * cur <= amount; i++) {
            res += plans(coins, start + 1, amount - i * cur);

        }
        System.out.println("从现在 " + start + " 取" + amount + "有方法:" + res);
        memo[start][amount] = res;
        return res;
    }

}
// @lc code=end
