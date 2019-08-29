/*
 * @lc app=leetcode id=53 lang=javascript
 *
 * [53] Maximum Subarray
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
  let maxSum = Number.MIN_SAFE_INTEGER;
  console.log(maxSum);
  for (let i = 0; i < nums.length; i++) {
    let subSum = 0;
    for (let j = i; j < nums.length; j++) {
      subSum += nums[j];
      maxSum = Math.max(subSum, maxSum);
    }
  }
  return maxSum;
};

maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]);
