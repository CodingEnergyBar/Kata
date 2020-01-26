/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        // i == j是没有意义的
        while (i < j) {
            if (nums[i] + nums[j] == target)
                return new int[] { i + 1, j + 1 };
            else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        throw new Error("input no solution");
    }
}
// @lc code=end
