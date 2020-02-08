/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // 0
        // if (n <= 2) {

        // }
        int[] memo = new int[n + 2];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
// @lc code=end
