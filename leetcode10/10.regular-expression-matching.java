package leetcode10;
import java.util.Arrays;

/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean dp[][] = new boolean[m+1][n+1];
        int i, j;
        // for(i=0; i<=m;i++ ){
        //     dp[i][0] = false;
        // }
        // for(j=1; j<=n; j++){
        //     dp[0][j] = false;
        // }
        dp[0][0] = true;
        for (j = 1; j <= n; j++) {
            if (p.charAt(j-1) == '*' && dp[0][j - 1]) {
                dp[0][j] = true;
            }
        }
        
        
        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                char pChar = p.charAt(j-1);
                if(pChar != '*'){
                    if(pChar == '.') 
                        dp[i][j] = dp[i-1][j-1];
                    else
                        dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1));
                }else{
                        if(j-1>0)
                            dp[i][j] = dp[i][j-2];
                            //这里比较恶心吧
                        if (i>0 && j>1 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) 
                            dp[i][j] = ( dp[i][j]) || dp[i - 1][j - 2] || dp[i-1][j];

                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }
    public static void main(String[] args) {

        String s =  "aab";
        String p = "c*a*b";
        System.out.println(new Solution().isMatch(s, p));
    }
}
// @lc code=end

