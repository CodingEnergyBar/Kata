package lintcode92;
class Solution {

        /**
         * @param m: An integer m denotes the size of a backpack
         * @param A: Given n items with size A[i]
         * @return: The maximum size
         */
        public int backPack(int m, int[] A) {
            // write your code here
            int n = A.length;
            boolean[][] dp = new boolean[n + 1][m + 1];

            for (int j = 0; j <= m; j++) {
                // 前0 个物品是否可以拼出 j 重量的背包
                dp[0][j] = false;

            }
            for (int i = 0; i <= n; i++) {

                // 前 i 个物品可以拼出0 重量的背包
                dp[i][0] = true;
            }
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                for (int w = 1; w <= m; w++) {
                    // 前 j 个物品, 看最后一个最后一个是 j-1
                    dp[i][w] = dp[i - 1][w];
                    if (w - A[i - 1] >= 0) {
                        // 还是要看前 i-1 个物品 能拼出来 w 或者拼出来 w- 现在物品重量的
                        dp[i][w] = dp[i][w] || dp[i - 1][(w - A[i - 1])];
                    }
                }
            }
            for (int j = m; j >= 0; j--) {
                if (dp[A.length][j] == true)
                    return j;
            }
            return 0;
        }
    
    
}