/*
 * @lc app=leetcode.cn id=633 lang=javascript
 *
 * [633] 平方数之和
 */

// @lc code=start
/**
 * @param {number} c
 * @return {boolean}
 */
var judgeSquareSum = function (c) {
    // c = 0 *0 + square

    // 0      1     2       3       4
    // true true    true    true    yes 
    // 1 4 9 16 25
    // 1 

    // two pointer
    let start = 0, end = Math.floor(c ** 0.5);
    while (start <= end) {
        const sum = start ** 2 + end ** 2;
        if (sum === c)
            return true;
        else if (sum > c)
            end--;
        else
            start++;
    }
    return false;

};
// @lc code=end

