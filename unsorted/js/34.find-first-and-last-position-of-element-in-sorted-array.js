/*
 * @lc app=leetcode id=34 lang=javascript
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
	let start = 0,
		end = nums.length - 1;

	let first = -1,
		last = -1;

	// find first
	while (start + 1 < end) {
		let mid = Math.floor((start + end) / 2);
		if (nums[mid] == target) end = mid;
		if (nums[mid] < target) start = mid;
		if (nums[mid] > target) end = mid;
	}
	if (nums[start] == target) first = start;
	else if (nums[end] == target) first = end;

	start = 0;
	end = nums.length - 1;
	// find last
	while (start + 1 < end) {
		let mid = Math.floor(start + (end - start) / 2);
		if (nums[mid] == target) start = mid;
		if (nums[mid] < target) start = mid;
		if (nums[mid] > target) end = mid;
	}
	if (nums[end] == target) last = end;
	else if (nums[start] == target) last = start;

	return [ first, last ];
};

let num = [ 5, 7, 7, 8, 8, 10 ];
let target = 8;
searchRange(num, target);
