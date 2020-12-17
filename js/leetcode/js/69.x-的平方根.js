/*
 * @lc app=leetcode.cn id=69 lang=javascript
 *
 * [69] x 的平方根
 */

// @lc code=start
/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function (x) {
    let start = 0, end = x, mid; // [1, x]
    while (start + 1 < end) {
        mid = Math.floor((end + start) / 2)
        if (mid ** 2 === x)
            return mid;
        else if (mid ** 2 > x) {
            end = mid
        } else {
            // 有问题的
            start = mid;
        }
    }
    if (end ** 2 === x)
        return end;
    return start;
};
// @lc code=end

