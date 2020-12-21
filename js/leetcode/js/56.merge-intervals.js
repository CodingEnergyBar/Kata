/*
 * @lc app=leetcode id=56 lang=javascript
 *
 * [56] Merge Intervals
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function (intervals) {
    intervals.sort((i, j) => (i[0] - j[0]))
    if (!intervals.length)
        return []
    let res = []
    let pre;
    for (const cur of intervals) {
        if (!pre) {
            pre = cur;
        } else {
            if (pre[1] < cur[0]) {
                res.push(pre)
                pre = cur
            } else { // pre.end >= start 
                pre[1] = Math.max(pre[1], cur[1])
            }
        }
    }
    res.push(pre)
    return res;

};

merge([[1, 3], [2, 6], [8, 10], [15, 18]])
// @lc code=end

