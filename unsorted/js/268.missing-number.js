/*
 * @lc app=leetcode id=268 lang=javascript
 *
 * [268] Missing Number
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
	// for (let i = 0; i < Math.floor((nums.length + 1) / 2); i++) {
	// 	if (nums.indexOf(i) == -1) return i;
	// 	if (nums.indexOf(nums.length + 1 - i) == -1) return nums.length + 1 - i;
	// }
	for (let i = 0; i <= nums.length; i++) {
		if (nums.indexOf(i) == -1) return i;
	}
};
missingNumber([ 3, 0, 1 ]);
