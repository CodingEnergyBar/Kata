/*
 * @lc app=leetcode.cn id=415 lang=javascript
 *
 * [415] 字符串相加
 */

// @lc code=start
/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var addStrings = function (num1, num2) {
    num2 = (num2).split('')
    num1 = (num1).split('')

    let i = num1.length - 1, j = num2.length - 1;
    let add = 0;
    let res = "";
    while (i >= 0 || j >= 0 || add !== 0) {
        let a = 0, b = 0;
        if (i >= 0)
            a = Number.parseInt(num1[i--])
        if (j >= 0)
            b = Number.parseInt(num2[j--])

        res = ((a + b + add) % 10) + res;
        add = Math.floor((a + b + add) / 10)

    }
    return res;
};
addStrings(
    "9",
    "99"
)
// @lc code=end

