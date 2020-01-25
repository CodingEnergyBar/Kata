/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int zero = -1, two = nums.length;
        for (int i = 0; i < two;) {
            int cur = nums[i];
            if (cur == 1) {
                i++;
            } else if (cur == 2) {
                // !! two--
                swap(i, --two, nums);
            } else {
                assert (cur == 0);
                // !!! zero++ i++: zero在i的后面, 所以 zero++的项目已经检查过了 要么1
                // 要么是0
                swap(++zero, i++, nums);
            }
            // System.out.println(Arrays.toString(nums));
        }

    }

    void swap(int i, int j, int[] arr) {
        if (i == j)
            return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
// @lc code=end
