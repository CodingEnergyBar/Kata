/*
 * @lc app=leetcode.cn id=374 lang=javascript
 *
 * [374] 猜数字大小
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param {number} num   your guess
 * @return 	            -1 if num is lower than the guess number
 *			             1 if num is higher than the guess number
 *                       otherwise return 0
 * var guess = function(num) {}
 */

/**
 * @param {number} n
 * @return {number}
 */
var guessNumber = function (n) {
    let mid, start = 1, end = n + 1; // [s end)
    while (start < end) {
        // 必须要有括号 优先级不高啊
        mid = start + ((end - start) >> 1);
        // console.log("mid", mid)
        const g = guess(mid);
        if (g === 0) return mid;
        //这里也是等于
        else if (g === 1) start = mid + 1;
        else end = mid;
    }
    return -1;
};
// @lc code=end

