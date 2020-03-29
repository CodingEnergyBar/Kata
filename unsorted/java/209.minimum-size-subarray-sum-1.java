/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (35.49%)
 * Likes:    1290
 * Dislikes: 78
 * Total Accepted:    192.4K
 * Total Submissions: 542.1K
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example: 
 * 
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution of
 * which the time complexity is O(n log n). 
 * 
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // write your code here
        int i = 0, j = 0, s1 = 0;
        int curLen = Integer.MAX_VALUE;
        for (; j < nums.length; j++) {

            s1 += nums[j];
            while (s1 >= s && i < nums.length) {

                curLen = Math.min(curLen, j - i + 1);
                s1 -= nums[i];
                i++;
            }

        }
        if (curLen == Integer.MAX_VALUE)
            return 0;
        return curLen;
    }
}
// @lc code=end
