/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = -1;
        int sum = 0;
        int res = nums.length + 1;
        // 左边的要到头才算是结束
        while (i < nums.length) {
            // j++;
            if (j == nums.length - 1 && sum < s)
                break;
            if (j + 1 < nums.length && sum < s)
                // sum < s
                sum += nums[++j];
            else {
                sum -= nums[i++];
            }
            if (sum >= s) {
                res = Math.min(res, j - i + 1);

            }
        }
        if (res == nums.length + 1)
            return 0;
        else
            return res;

    }
}
// @lc code=end

