/*
 * @lc app=leetcode.cn id=435 lang=javascript
 *
 * [435] 无重叠区间
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @return {number}
 */
var eraseOverlapIntervals = function (intervals) {
    intervals.sort((a, b) => {
        if (a[1] !== b[1])
            return a[1] - b[1]
        else
            return a[0] - b[0]
    })

    if (intervals.length === 0)
        return 0;

    let max = 1;
    let pre = 0;
    for (let i = 1; i < intervals.length; i++) {
        if (intervals[i][0] >= intervals[pre][1]) {
            max++;
            pre = i;
        }
    }
    return intervals.length - max;
}
var eraseOverlapIntervalsNormal = function (intervals) {
    if (intervals.length === 0)
        return 0;
    intervals.sort((a, b) => a[0] - b[0])

    // memo[i] 表示 使用intervals[ 0... i]的区间能过程的最长不重叠的子序列
    const dp = Array(intervals).fill(1)
    let max = 1;
    for (let i = 1; i < intervals.length; i++) {
        const cur = intervals[i];
        let curMax = 1;
        for (let j = 0; j < i; j++) {
            //前面的 pre end的值越小, end后面可以插入越多
            if (cur[0] >= intervals[j][1]) {
                curMax = Math.max(curMax, dp[j] + 1)
            }

        }
        dp[i] = curMax;
        max = Math.max(max, curMax)
    }
    return intervals.length - max;
};

// eraseOverlapIntervals([[1, 2], [2, 3]])
// @lc code=end

