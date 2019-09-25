/*
 * @lc app=leetcode id=283 lang=javascript
 *
 * [283] Move Zeroes
 */
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    let posNoneZero = 0;
	for (let i = 0; i < nums.length; i++) {
		if (nums[i] !== 0) {
			nums[posNoneZero++] = nums[i];
		}
    }
    for (; posNoneZero<nums.length;posNoneZero++){
        nums[posNoneZero] = 0;
    }
    
	// function floatToTail(index) {
	// 	for (let i = index; i < nums.length - 1; i++) {
	// 		let tmp = nums[i];
	// 		nums[i] = nums[i + 1];
	// 		nums[i + 1] = tmp;
	// 	}
    // }
    
    console.log(nums);
    
};
// moveZeroes([0,1,0,3,12]);
moveZeroes([ 0, 0, 1 ]);
