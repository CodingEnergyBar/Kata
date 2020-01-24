/*
 * @lc app=leetcode id=153 lang=javascript
 *
 * [153] Find Minimum in Rotated Sorted Array
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
	// smallest now is nums[end];
	// keep the feature for 拐点
	let l = 0,
		r = nums.length - 1;

	while (l + 1 < r) {
		let mid = Math.floor((l + r) / 2);
		if (nums[mid] < nums[r]) {
			r = mid;
		} else {
			l = mid;
		}
	}

	return Math.min(nums[l], nums[r]);
};

findMin([ 3, 4, 5, 1, 2 ]);
