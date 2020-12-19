/*
 * @lc app=leetcode.cn id=455 lang=javascript
 *
 * [455] 分发饼干
 */

// @lc code=start
/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function (g, s) {
    sortAsc = (a, b) => a - b
    s.sort(sortAsc)
    g.sort(sortAsc)

    let i = 0;
    s.forEach(cookie => {
        if (cookie >= g[i])
            i++;
    })
    return i;

    // let i = 0, j = 0
    // let res = 0;
    // while (true) {
    //     if (i >= g.length || j >= s.length)
    //         break;
    //     if (s[j] >= g[i]) {
    //         res++, j++, i++
    //     } else {
    //         i++;
    //     }
    // }
    return res;

};
// @lc code=end

