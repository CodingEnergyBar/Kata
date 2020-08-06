package lintcode515;
class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        int len = costs.length;
        if(len == 0)    return 0;
        int[][] dp = new int[len][3]; // the mimum to paint until including i when the color is j

        for(int j=0; j<3;j++)
            dp[0][j] = costs[0][j];
        for(int i=1; i<len; i++){
            // dp[i][j];
            for(int j=0; j<3;j++){
                dp[i][j] = costs[i][j];
                int min = Integer.MAX_VALUE;
                for(int k=0; k < 3; k++){
                    if(k == j) continue;
                    min = Math.min(min, dp[i-1][k]);
                }
                dp[i][j] += min;
            }
        }
         int min = Integer.MAX_VALUE;
        for(int j=0; j<3;j++)
           min = Math.min(dp[len-1][j], min);
        return min;
    }
}