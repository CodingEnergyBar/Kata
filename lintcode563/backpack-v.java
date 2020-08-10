package lintcode563;

 class Solution {
    /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    int res;
    public int backPackV(int[] nums, int target) {
         int n = nums.length, m = target;
         int[][] dp = new int[n+1][m+1];
         int i, w;
        //  前 n 个物品有多少用方式拼出 m
        for(i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        // 前 0 个物品多少种方式拼出 j ==> 0?? ==>1
        dp[0][0] = 1;
        for(i=1; i<=n; i++){
            for(w=1; w<=m; w++){
                int last = nums[i-1];
                dp[i][w] = dp[i-1][w];
                if(w - last >=0 )
                    dp[i][w] += dp[i-1][w-last];
            }
        }
        return dp[n][m];
    }
}