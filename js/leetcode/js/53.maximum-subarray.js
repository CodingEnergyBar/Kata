/*
 * @lc app=leetcode id=53 lang=javascript
 *
 * [53] Maximum Subarray
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function (nums) {
    // const dp = Array(nums.length + 1).fill(0)
    let minSum = 0
    let max = -Infinity
    const sum = Array(nums.length + 1).fill(0)
    // first i sum
    for (let i = 1; i <= nums.length; i++) {
        sum[i] = sum[i - 1] + nums[i - 1]
        const curMaxSum = sum[i] - minSum
        minSum = Math.min(minSum, sum[i])
        max = Math.max(max, curMaxSum)
    }
    return max;
};

console.log(maxSubArray([-2, -1]))
// console.log(maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
// @lc code=end

