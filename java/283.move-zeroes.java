/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (55.10%)
 * Likes:    2380
 * Dislikes: 86
 * Total Accepted:    528.9K
 * Total Submissions: 958.3K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // [0...n)
        // int k = 0; // [0..k)为非零元素 [k...i]为零
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] != 0) {
        // if (i != k) {
        // swap(i, k++, nums);
        // } else {
        // k++;
        // }
        // }
        // }

        // another one
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // if (nums[i] != 0) {
            // k++;
            // } else {
            // if (k != i) {
            // swap(i, k, nums);
            // }

            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (; k < nums.length; k++) {
            nums[k] = 0;
        }

    }

    void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
// @lc code=end
