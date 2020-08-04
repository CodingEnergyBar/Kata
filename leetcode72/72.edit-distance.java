package leetcode72;
/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    int[][] dp;
    int R, C; // r source character length, c: target character length
    public int minDistance(String word1, String word2) {
        int R = word1.length();
        int C = word2.length();
        dp = new int[R + 1][C + 1];
        // initialze R word[i] -> null
        for(int i = 0; i<=R; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=C; j++){
            dp[0][j] = j;
        }


        for(int i=1; i<=R ; i++){
            for(int j=1; j<=C; j++){
                int res;
                //delete
                res = dp[i][j-1] + 1;
                // add
                res = Math.min(res, dp[i-1][j] + 1);
                //replace 前 i 个s[i-1] 
                int replace = dp[i - 1][j - 1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    replace = dp[i-1][j-1] + 1;
                }
                res = Math.min(res, replace);
                dp[i][j] = res;
            }
        }
        return dp[R][C];
    }
    public static void main(String[] args) {
        new Solution().minDistance("horse", "ros");
    }
}
// @lc code=end

