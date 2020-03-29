import java.util.Arrays;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms Medium (50.08%) Likes: 2524 Dislikes: 196 Total Accepted: 457.6K Total Submissions:
 * 906.6K Testcase Example: '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the
 * sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,1,5,6,4] and k = 2 Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4 Output: 4
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 */

// @lc code=start
class Solution {
    // fuck you jiuzhang template
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);

    }

    int findKthLargest(int[] nums, int start, int end, int target) {
        // find smaller to biggest

        int pivotIndex = start, right = end;
        for (int i = start; i < right; i++) {
            if (nums[i] < nums[right])
                swap(nums, pivotIndex++, i);
        }
        // 最后再 swap 一下
        swap(nums, right, pivotIndex);

        if (pivotIndex > target) {
            return findKthLargest(nums, start, pivotIndex - 1, target);
        } else if (pivotIndex < target) {
            return findKthLargest(nums, pivotIndex + 1, end, target);
        } else {
            return nums[pivotIndex];
        }
    }

    void swap(int[] nums, int m, int n) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }
}

// @lc code=end
