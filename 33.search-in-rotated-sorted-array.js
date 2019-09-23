/*
 * @lc app=leetcode id=33 lang=javascript
 *
 * [33] Search in Rotated Sorted Array
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
	let start = 0,
		end = nums.length - 1;
	while (start + 1 < end) {
		let mid = Math.trunc((start + end) / 2);
		if (nums[mid] > end) {
			start = mid;
		} else {
			end = mid;
		}
	}
	console.log('end', end);
	// end is pivot point
	if (nums[end] >= target) {
		let res = binarySearch(nums.slice(end), target);
		if (res === -1) return -1;
		else return res + end;
	} else return binarySearch(nums.slice(0, end), target);
};
var binarySearch = (nums, target) => {
	console.log('nums', nums);
	let start = 0,
		end = nums.length - 1;
	while (start + 1 < end) {
		let mid = Math.trunc((start + end) / 2);
		if (nums[mid] > target) {
			end = mid;
		} else if (nums[mid] < target) {
			start = mid;
		} else return mid;
	}
	if (nums[start] === target) return start;
	if (nums[end] === target) return end;
	return -1;
};

// console.log(search([ 4, 5, 6, 7, 0, 1, 2 ], 0));
console.log(search([ 1, 3 ], -1));
