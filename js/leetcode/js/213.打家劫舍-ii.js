/*
 * @lc app=leetcode.cn id=213 lang=javascript
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
    if (nums.length === 0)
        return 0;
    if (nums.length === 1)
        return nums[0]
    //n-1 tou he butou de qingkunag dou zhidao 
    // 从第一户偷 不偷最后一户
    // 从第二户开始投, 最后一户磕头可不偷
    const dp = new Array(nums.length + 1)
    let max1, max2
    dp[0] = 0, dp[1] = nums[0];
    for (let i = 2; i < nums.length; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1])
    }
    max1 = dp[nums.length - 1]
    dp[1] = 0;
    for (let i = 2; i <= nums.length; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1])
    }
    max2 = dp[nums.length]

    return Math.max(max1, max2)

};
// @lc code=end

