/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    int[] memo;

    public int maxSubArray(int[] nums) {
        memo = new int[nums.length];
        if (nums == null || nums.length == 0)
            return 0;
        memo[0] = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            memo[i] = sum;
        }
        int max = memo[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(memo[i], max);
        }
        return max;

    }
}
// @lc code=end
