import java.util.Arrays;

/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
            //m 0 n 1
            int L = strs.length;
            int[] cnt0 = new int[L];
            int[] cnt1 = new int[L];
            for(int l=0; l<L; l++){
                cnt0[l] = 0;
                cnt1[l] = 0;
                char[] arr = strs[l].toCharArray();
                for(int j=0; j<arr.length;j++){
                    char a = arr[j];
                    if(a == '0') cnt0[l]+=1;
                    else cnt1[l]+=1;
                }
            }

            //前 i 个字符串中 组成 m 个 0 n 个 1 的最多串数
            int[][][] dp = new int[L+1][m+1][n+1];
            for(int i=0; i<=m; i++){
                for(int j=0; j<=n; j++){
                    dp[0][i][j]=0;
                }
            }
            int res = 0;
            for(int l=1; l<=L; l++){
                for (int i = 0; i <= m; i++) {
                    for (int j = 0; j <= n; j++) {
                        int zeroCnt = cnt0[l-1];
                        int oneCnt = cnt1[l-1];
                        dp[l][i][j] = dp[l-1][i][j];
                        if(i-zeroCnt >= 0 && j - oneCnt >=0){
                            dp[l][i][j] = Math.max(dp[l][i][j],  (dp[l-1][i-zeroCnt][j-oneCnt] + 1));
                        }
                        if(l == L){
                            res = Math.max(res, dp[l][i][j]);
                        }
                    }
                }
            }

            // System.out.println(Arrays.deepToString(dp));
            return res;
        
    }
}
// @lc code=end

