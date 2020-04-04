/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (45.76%)
 * Likes:    6896
 * Dislikes: 317
 * Total Accepted:    897.9K
 * Total Submissions: 2M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        //the max ended at i)
        int[] f = new int [nums.length+1];
        int max = Integer.MIN_VALUE;
        for(int i=0; i< nums.length;i++){
            f[i+1] = Math.max(f[i]+nums[i] , nums[i]);
            max = Math.max(f[i+1], max);
        }
        return max;
    }
}
// @lc code=end

