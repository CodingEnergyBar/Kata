/*
 * @lc app=leetcode.cn id=829 lang=javascript
 *
 * [829] 连续整数求和
 */

// @lc code=start
/**
 * @param {number} N
 * @return {number}
 */
var consecutiveNumbersSum = function (N) {

    let i = 1, res = 0;
    // dp(N) could have the group number
    const dp = Array(N).fill(0)
    if (N % 2 === 0)
        return 1;
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    // 3 = 1+2
    for (let i = 1; i < N; i++) {
        // 1 1  1
        // 2 1
        // 3 1+2 2 
        // 4 1
        // 5 2+3 2
        // 6 1+2+3 /2==> 3 1+2+3 3
        // 7: 3+4 / 
        // 8: /3 /5
        // 10: 1, 2, 3, 4 ==> 5 ==> 2
        // 14 2+3+4+5 7-> 14
        // 15 
        // 16 /4==> 
        // 25 /5 ===> 5 5  5 5
        if (N)
    }


};
// @lc code=end

