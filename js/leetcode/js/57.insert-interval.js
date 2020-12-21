/*
 * @lc app=leetcode id=57 lang=javascript
 *
 * [57] Insert Interval
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */

let intervals = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]];
let newInterval = [4, 8]
var insert = function (intervals, newInterval) {
    const res = [];
    for (let i = 0; i < intervals.length; i++) {
        const cur = intervals[i]
        if (newInterval[0] >= cur[0] && newInterval[0] <= cur[1]) {
            if (newInterval[1] <= cur[1]) {
                // covered and swallow
                return intervals;
            } else { // newInterval[1] > cur[1]
                newInterval[1] = cur[1]
            }
        } else {
            res.push(cur);
        }
    }
    return cur;

};
// @lc code=end

