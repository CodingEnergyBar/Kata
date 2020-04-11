import java.util.Arrays;

/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (44.68%)
 * Likes:    2186
 * Dislikes: 169
 * Total Accepted:    248.9K
 * Total Submissions: 557.1K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] f = new int[n+1];
        // 1. 这里的最大值
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        // System.out.println(Arrays.toString(f));
        for(int i=1; i<=n; i++){
            // j* j == i的时候也可以, 请不要想当然
            for(int j=1; j* j <=i ; j++){
                // 2. 这里的最小值
                f[i] = Math.min(f[i], f[i-j*j] + 1);
            }
        }
        return f[n];
        
    }
}
// @lc code=end

