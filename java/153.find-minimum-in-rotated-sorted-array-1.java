/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        // [left..right]
        while (left < right) {
            // 递减 逐渐往左 right-1 [0,1]
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                // [left...mid]
                right = mid;
            } else {
                // mid > right [mid+1...right]
                // [mid+1...right]
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
// @lc code=end
