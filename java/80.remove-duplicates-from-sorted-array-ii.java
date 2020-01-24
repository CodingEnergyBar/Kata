/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // [0...k) 不重复的
        int k = 0;
        /*
        int buffer = 1;
        for (int el : nums) {
            if (k == 0) {
                nums[k++] = el;
                // buffer--;
                continue;
            }
            if (el == nums[k - 1] && buffer > 0) {
                nums[k++] = el;
                buffer--;
                continue;
            }
            if (el == nums[k - 1] && buffer == 0) {
                continue;
            }
            if (el != nums[k - 1]) {
                nums[k++] = el;
                buffer = 1;
            }
        }
        */

        for (int n : nums) {
            if (k < 2 || n > nums[k - 2]) {
                nums[k++] = n;
            }
        }
        return k;

    }
}
// @lc code=end
