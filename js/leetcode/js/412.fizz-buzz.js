/*
 * @lc app=leetcode.cn id=412 lang=javascript
 *
 * [412] Fizz Buzz
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[]}
 */
var fizzBuzz = function (n) {
    const res = [];
    for (let i = 1; i <= n; i++) {
        res.push(output(i))
    }
    return res;
    function output(n) {
        if (n % 3 === 0 && n % 5 === 0) {
            return "FizzBuzz"
        }
        if (n % 3 === 0) {
            return "Fizz"
        }
        if (n % 5 === 0) {
            return "Buzz"
        }
        return n.toString()
    }



};
// @lc code=end

