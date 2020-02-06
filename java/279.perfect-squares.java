/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    int[] memo;

    public int numSquares(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return findSquares(n);

    }

    // 0 9
    int findSquares(int cur) {
        if (cur == 0)
            return 0;

        if (cur == 1)
            return 1;

        if (memo[cur] != -1)
            return memo[cur];
        int step = Integer.MAX_VALUE;
        for (int i = 1; i * i <= cur; i++) {

            step = Math.min(step, findSquares(cur - i * i) + 1);
        }
        memo[cur] = step;
        return step;
    }
}
// @lc code=end
