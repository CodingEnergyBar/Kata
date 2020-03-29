/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    public List<Integer> sortArray(int[] nums) {

    }

    void mergeSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1;
        int k;
        for (k = 0; k < end - start + 1; k++) {
            if (i <= mid && j <= end) {
                if (nums[i] < nums[j]) {
                    tmp[k] = nums[i++];
                } else {
                    tmp[k] = nums[j++];
                }
            }
        }
        while (i <= mid)
            tmp[k++] = nums[i++];
        while (j <= end)
            tmp[k++] = nums[j++];

        k = 0;
        // copy
        while (start <= end) {
            nums[start++] = tmp[k++];
        }
    }
}
// @lc code=end
