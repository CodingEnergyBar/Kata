/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (30.91%)
 * Likes:    3364
 * Dislikes: 140
 * Total Accepted:    296.8K
 * Total Submissions: 958.1K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */

// @lc code=start
class Solution {
     public int maxProduct(int[] nums) {
        //  contiguous subarray  larguest product
        // [i...j] Max [i...j-1] [i+1, j] i<=j
        // [i...j]
        int[][] dp = new int[nums.length][nums.length];


        for(int i=0; i< nums.length;i++){
            // Arrays.fill(dp[i], 1);
            dp[i][i] = nums[i];
        }

       
        for(int len=2; len<=nums.length; len++){
            for(int i=0; i<nums.length; i++){
                int j = i + len - 1;
                if ( j< nums.length ){
                    //断开了: need to redo:///
                    // 李同学的: https://www.jiuzhang.com/solution/maximum-product-subarray/#tag-other
                    dp[i][j] = Math.max(dp[i][j-1] * nums[j], dp[i+1][j] * nums[i]);
                    dp[i][j] = Math.max(dp[i][j],dp[i+1][j]);
                    dp[i][j] = Math.max(dp[i][j],dp[i][j-1]);
                    System.out.println("dp["+i +"]["+j+"]: " + Arrays.deepToString(dp));
                }
                

            }
            // for(int j=i; j<nums.length;j++){

            // }
        }
        return dp[0][nums.length-1];
    }
}
// @lc code=end

