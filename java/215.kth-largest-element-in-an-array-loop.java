/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 第 k 大的 的 角标 sortedArray
        int t = nums.length - k;
        int start = 0, end = nums.length - 1;
        int p = start;

        while (start <= end) {
            p = partition(nums, start, end);
            if (p == t)
                return nums[t];
            else if (p < t) {
                start = p + 1;
            } else {
                end = p - 1;
            }
            System.out.println(Arrays.toString(nums));
        }
        return nums[t];

    }

    // return inardex of the pivot [left, right]
    int partition(int[] nums, int left, int right) {
        int pivot = left + (right - left) / 2;
        int pivotVal = nums[pivot];

        swap(right, pivot, nums);
        // from[left, right)
        // [left, targetIndex) < pivotVal
        int targetIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotVal) {
                swap(i, targetIndex++, nums);
                // nums[targetIndex] = nums[i];
                // targetIndex++;
            }
        }
        // 把pivotval 放到制定的slot中
        swap(right, targetIndex, nums);
        return targetIndex;
    }

    void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end
