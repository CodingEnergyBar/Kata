/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        // [left,right]
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            // nums[left] nums[right]
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return nums[left];

    }
}
// @lc code=end
