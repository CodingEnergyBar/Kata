/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int N) {

        int[] f = new int[N + 1];
        if (N == 0)
            return 0;
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= N; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[N];
    }
}
// @lc code=end
