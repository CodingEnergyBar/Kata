/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // int targetIndex = nums.length - k;
        return partition(0, nums.length - 1, nums.length - k, nums);
    }

    public int partition(int left, int right, int target, int[] nums) {
        // int pivot = right;
        int pivotIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[right]) {
                swap(pivotIndex++, i, nums);
            }
        }
        swap(pivotIndex, right, nums);
        if (pivotIndex < target)
            return partition(pivotIndex + 1, right, target, nums);
        else if (pivotIndex == target)
            return nums[pivotIndex];
        else {
            // pivotIndex > target
            return partition(left, pivotIndex - 1, target, nums);
        }
    }

    void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end
