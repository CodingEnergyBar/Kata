/*
 * @lc app=leetcode id=367 lang=javascript
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function (num) {
    let low = 1, high = num
    while (low <= high) {
        const mid = low + ((high - low) >> 1)
        const pow = mid ** 2;
        if (pow > num) {
            high = mid - 1;
        } else if (pow < num) {
            low = mid + 1
        } else
            return true;
    }
    return false;

};
isPerfectSquare(16)
// @lc code=end

