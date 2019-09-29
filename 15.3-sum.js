/*
 * @lc app=leetcode id=15 lang=javascript
 *
 * [15] 3Sum
 */
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
	let res = [];
	if (nums.length <= 2) {
		return res;
	}

	nums.sort((a, b) => a - b);
	console.log('nums', nums);

	for (let i = 0; i < nums.length - 2; i++) {
		let target = -nums[i];
        if (i != 0 && nums[i] == nums[i - 1]) continue;
        
		// console.log('target, left, right', target, i + 1, nums.length - 1);

		findTwoSum(target, i + 1, nums.length - 1);
		// console.log(res);
	}
	return res;

	function findTwoSum(target, left, right) {
		if (nums[left] + nums[right] > target) {
			return;
		}
		// console.log('target, left, right', target, nums[left], nums[right]);
		while (left < right) {
			if (nums[left] + nums[right] === target) {
				res.push([ -target, nums[left], nums[right] ]); // from small to big
				left++;
				right--;
				while (left < right && nums[left] == nums[left - 1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right + 1]) {
					right--;
				}
			}
			else if (nums[left] + nums[right] < target) {
				left++;
			}
			else {
				right--;
			}
		}
	}
};
