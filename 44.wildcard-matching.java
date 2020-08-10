/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];


        dp[0][0] = true;
        for(int j=1; j<=n; j++){
            dp[0][j] = dp[0][j-1] && (p.charAt(j-1) == '*');
        }


        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
             char charP = p.charAt(j-1);
                if(charP == '?' || charP == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else if(charP == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-1] || dp[i][j-1];
                }

            }
        }
        return dp[m][n];
        
    }
}
// @lc code=end

