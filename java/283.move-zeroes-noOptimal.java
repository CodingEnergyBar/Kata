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
        // int[] res = new int[nums.length];
        // int i = 0, j = 0;
        // while (i < nums.length) {
        // if (nums[i] != 0) {
        // res[j] = nums[i];
        // j++;
        // }
        // i++;
        // }
        // while (j < nums.length) {
        // nums[j] = 0;
        // j++;
        // }
        // return res;

        // [start...end]
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == 0) {
                moveToEnd(start, end, nums);
                // console.log(nums)
                // System.out.println(nums.toString());
                System.out.println(Arrays.toString(nums));
                end--;
            } else {
                start++;
            }
        }
    }

    // [start...end]
    void moveToEnd(int start, int end, int[] arr) {
        while (start < end) {
            swap(start, start + 1, arr);
            start++;
        }
    }

    void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
// @lc code=end
