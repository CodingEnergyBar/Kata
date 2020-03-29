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
var insert = function(intervals, newInterval) {
	const res = [];
	for (const interval of intervals) {
		if (interval[1] < newInterval[0] || newInterval[1] < interval[0]) {
			console.log('interval[1] < newInterval[0] ', interval[1] < newInterval[0]);
			console.log('newInterval[1] > interval[0 ', newInterval[1] > interval[0]);
			res.push(interval);
		}
		else {
			newInterval[0] = Math.min(newInterval[0], interval[0]);
			newInterval[1] = Math.max(newInterval[1], interval[1]);
		}
		console.log('res', res);
		console.log('newInterval', newInterval);
	}

	res.push(newInterval);
	res.sort((a, b) => a[0] - b[0]);
	return res;
};
// @lc code=end
