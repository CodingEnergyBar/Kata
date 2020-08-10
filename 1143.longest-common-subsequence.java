/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String A, String B) {

                // write your code here
                int m = A.length(), n = B.length();
                int dp[][] = new int[m + 1][n + 1];
                for (int i = 0; i <= m; i++) {
                    for (int j = 0; j <= n; j++) {
                        if (i == 0 || j == 0)
                            dp[i][j] = 0;
                        else {
                            char lastA = A.charAt(i - 1);
                            char lastB = B.charAt(j - 1);

                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + (lastA == lastB ? 1 : 0));
                        }

                    }
                }
                return dp[m][n];
            }
        
        
    
}
// @lc code=end

