/*
 * @lc app=leetcode id=162 lang=javascript
 *
 * [162] Find Peak Element
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
// var findPeakElement = function(nums) {
// 	let start = 0,
// 		end = nums.length - 1;
// 	while (start + 1 < end) {
// 		let mid = ~~((start + end) / 2);
// 		if (nums[mid] > nums[mid + 1]) {
// 			end = mid;
// 			// console.log('end', end);
// 		} else {
// 			start = mid;
// 			// console.log('start', start);
// 		}
// 	}
// 	if (nums[start] > nums[end]) return start;
// 	else return end;
// };

var findPeakElement = function(nums) {
	// find peak in an array;
	if (nums.length == 1 || nums[0] > nums[1]) return 0;
	if (nums[nums.length - 1] > nums[nums.length - 2]) {
		return nums.length - 1;
	}

	let s = 0,
		e = nums.length - 1;
	while (s + 1 < e) {
		let mid = ~~((s + e) / 2);
		// console.log('s, e', s + ' ' + e.toString());

		if (nums[mid] < nums[mid - 1]) {
			e = mid;
		} else if (nums[mid] < nums[mid + 1]) {
			s = mid;
		} else {
			s = mid;
		}
		// console.log('s, e', s + ' ' + e.toString());
	}
	return nums[s] > nums[e] ? s : e;
};
// findPeakElement([ 1, 3, 2, 1 ]);
// findPeakElement([ 3, 2, 1 ]);
findPeakElement([ 1, 2, 3, 1 ]);
