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
		if (nums[mid] < nums[end]) {
			end = mid;
		} else {
			start = mid;
		}
	}
	let pivot = nums[start] < nums[end] ? start : end;

	console.log('pivot', pivot);
	// end is pivot point
	if (nums[nums.length - 1] >= target && target >= nums[pivot]) {
		// console.log('nums.slice(pivot)', nums.slice(pivot));
		return binarySearch(nums, target, pivot, nums.length - 1);
	} else return binarySearch(nums, target, 0, pivot - 1);
};
var binarySearch = (nums, target, s, e) => {
	console.log('nums', nums);
	let start = s,
		end = e;
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

console.log(search([ 4, 5, 6, 7, 0, 1, 2 ], 0));
// console.log(search([ 1, 3 ], -1));
// console.log(search([ 1, 3 ], 3));
