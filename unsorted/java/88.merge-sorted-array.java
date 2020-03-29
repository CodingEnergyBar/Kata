/*
 * @lc app=leetcode id=88 lang=java
 *
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int k = m + n - 1;
        int i = m - 1, j = n - 1;

        // 考虑到 m == 0的情况
        while (i >= 0 && j >= 0 && k >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
            // System.out.println(Arrays.toString(nums1));
        }

        while (j >= 0 && k >= 0) {
            nums1[k--] = nums2[j--];
        }

    }
}
// @lc code=end
