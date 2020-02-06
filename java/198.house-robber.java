/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    int res = -1;
    int[] memo;

    public int rob(int[] nums) {
        // [0...nums.length-1]
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return getBest(nums, 0);

    }

    int getBest(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }

        int res = 0;

        for (int i = start; i < nums.length; i++) {

            res = Math.max(res, nums[i] + getBest(nums, i + 2));
        }
        memo[start] = res;
        return res;
    }
}
// @lc code=end
