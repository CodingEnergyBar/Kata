/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

// @lc code=start
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currentMax = 0;
        for (int i : nums) {
            if (i == 1) {
                currentMax++;
                if (currentMax > max) {
                    max = currentMax;
                }
            } else {
                currentMax = 0;
            }
        }
        return max;
    }
}
// @lc code=end
