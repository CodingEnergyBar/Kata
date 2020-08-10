/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(n + m != s3.length())
            return false;
        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=1; i<=m; i++){
            dp[i][0] = dp[i-1][0] && s3.charAt(i-1) == s1.charAt(i-1);
            if(dp[i][0] == false) break;
        }
        for(int j=1; j<=n; j++){
            dp[0][j] = dp[0][j-1] && s3.charAt(j-1) == s2.charAt(j-1);
            if (dp[0][j] == false)  break;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                           (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                           
                        // 没有这部
                        //    (dp[i-1][j-1] && (s1.charAt(i-1) == s3.charAt(i+j-2) && s2.charAt(j-1) == s3.charAt(i+j-1)) ||
                        //                     (s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) == s3.charAt(i+j-2)));
                

            }
        }
        return dp[m][n];
    }
}
// @lc code=end

