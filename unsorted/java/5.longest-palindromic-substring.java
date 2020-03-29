/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        // [i..i+len(j)) len s.length

        int len = s.length();
        if(len == 0 || len == 1)
            return s;
        int maxLen = 1;
        String maxLenString = s.substring(0,1);

        int[][] dp =  new int[len][len + 1];
        // 1 yes 0 not 

        for(int i=0; i<len; i++){
            dp[i][i] = 1;
            dp[i][i+1] = 1;           
        }
  

        //边界条件很难看
        for(int l=2; l <= len; l++){
            for(int i=0; i <= len - l;i++){
                int j = i+l;
                int endIndex= j - 1;
            
                dp[i][j] = (dp[i+1][j-1] == 1 && s.charAt(i) == s.charAt(endIndex))? 1: 0;
                // j - i 
                if(dp[i][j] ==  1) maxLenString = s.substring(i, j);
            }
        }
        return maxLenString;
        
    }
}
// @lc code=end

