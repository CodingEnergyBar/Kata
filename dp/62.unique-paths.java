import java.lang.WeakPairMap.Pair.Weak;

/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (51.48%)
 * Likes:    2554
 * Dislikes: 182
 * Total Accepted:    409K
 * Total Submissions: 792.1K
 * Testcase Example:  '3\n2'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the
 * bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: m = 7, n = 3
 * Output: 28
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
 * 
 * 
 */

// @lc code=start
class Solution {
    int m,  n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        // 统计一共有多少, 应该 dfs 也行
        int dp[][] = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, 0);
        }
        dp[0][0] = 1;

        // i ---> m
        // j ---> n
        // dp[i][j] =  dp[i-1][j] + dp[i][j-1];

        for(int i=0; i< m; i++){
            for(int j=0; j<n;j++){
                if(isInTheGrid(i-1, j))
                    dp[i][j] += dp[i-1][j];
                if(isInTheGrid(i, j-1))
                    dp[i][j] += dp[i][j-1];

            }
        }
        return dp[m-1][n-1];

      // Todo: Math solution, O(1) space
    }
    boolean isInTheGrid(int i, int j){
        return (i >=0 && j >=0 && i<m && j < n );
    }
}
// @lc code=end

