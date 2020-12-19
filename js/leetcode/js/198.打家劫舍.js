/*
 * @lc app=leetcode.cn id=198 lang=javascript
 *
 * [198] 打家劫舍
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {

    // const dp = new Array(nums.length + 1);
    // console.log(dp)

    // dp[0] = 0; //
    // dp[1] = nums[0]
    if (!nums.length) return 0;

    let dp0 = 0, dp1 = nums[0];

    for (let i = 2; i <= nums.length; i++) {
        const dp2 = Math.max(dp1, nums[i - 1] + dp0)
        dp0 = dp1;
        dp1 = dp2;
    }

    return dp1;

};
// @lc code=end

