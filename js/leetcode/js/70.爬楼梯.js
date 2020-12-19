/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
    // var methods = () => {
    //     if (n === 1 || n === 0 || n === 2)
    //         return n;
    //     return methods(n - 1) + methods(n - 2)
    // }
    const dp = new Array({ length: n + 1 })
    let dp0 = 1;
    let dp1 = 1
    let tmp;
    // dp[0] = 1;
    // dp[1] = 1;
    // O(n) O(n)
    // 没区别呢, 因为是块作用域吧
    for (let i = 2; i <= n; i++) {
        tmp = dp0;
        dp0 = dp1;
        dp1 = dp0 + tmp;
        // dp[i] = dp[i - 1] + dp[i - 2]
    }
    // return dp[n]
    return dp1

};
// @lc code=end

