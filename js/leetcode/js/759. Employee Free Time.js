/*
 * @lc app=leetcode.cn id=759 lang=javascript
 *
 * [759] Employee Free Time
 */

// @lc code=start
/**
 * // Definition for an Interval.
 * function Interval(start, end) {
 * this.start = start;
 * this.end = end;
 * };
 * /

/**
 * @param {Interval[][]} schedule
 * @return {Interval[]}
 */
var employeeFreeTime = function (schedule) {
    schedule = schedule.reduce((pre, cur) => pre.concat(cur))

    const merged = [];
    schedule.sort((a, b) => {
        if (a.start !== b.start) {
            return a.start - b.start
        } else {
            return a.end - b.end;
        }
    })
    const freeIntervals = [];

    // free time
    for (let i = 0; i < schedule.length; i++) {
        const cur = schedule[i]
        // last.end > cur.start

        if (!merged.length) {
            merged.push(cur)
        } else {
            const last = merged[merged.length - 1]
            if (last.end >= cur.start) {
                last.end = Math.max(cur.end, last.end)
            } else {
                merged.push(cur)
                freeIntervals.push(new Interval(last.end, cur.start))
            }
        }
    }
    return freeIntervals;

};
schedule =
    [[[1, 2], [5, 6]], [[1, 3]], [[4, 10]]]

// @lc code=end

