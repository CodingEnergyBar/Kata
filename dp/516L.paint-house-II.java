/**
 * 516. Paint House II There are a row of n houses, each house can be painted with one of the k
 * colors. The cost of painting each house with a certain color is different. You have to paint all
 * the houses such that no two adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For
 * example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of
 * painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 * 
 * Example Example 1
 * 
 * Input: costs = [[14,2,11],[11,14,5],[14,3,10]] Output: 10 Explanation: The three house use color
 * [1,2,1] for each house. The total cost is 10. Example 2
 * 
 * Input: costs = [[5]] Output: 5 Explanation: There is only one color and one house. Challenge
 * Could you solve it in O(nk)?
 */

public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // write your code here
        if (costs.length == 0 || costs[0].length == 0)
            return 0;
        // color
        int n = costs.length;
        int K = costs[0].length;

        int[][] f = new int[n + 1][K];

        int i, j, k, a, b;
        for (i = 0; i < K; ++i) {
            // 初始化表示前面的-1的房子 color 为
            f[0][i] = 0;
        }
        // 前 1 栋到前 n 栋
        for (i = 1; i <= n; i++) {
            // !!! 经常做的事情
            // 在求 f[i][j] 之前要找到 min and second min
            // f[i-1][0], ... f[i-1][K-1]
            // 每次找到
            a = b = -1;
            for (k = 0; k < K; k++) {
                // !!! 现在的是f[i-1][k] 之前的 i-1 栋房子涂成 k 的花费
                // a 是之前涂成 a 时候的值, 且 a 最小 还不够小
                if (a == -1 || f[i - 1][k] < f[i - 1][a]) {
                    // 原来的最小变成现在的第二小: 每次找, 最小值饿
                    b = a;
                    // a 被现在的 k 取代
                    a = k;
                } else {
                    // 第一小被记录下来了, 在 else 之后应该是
                    if (b == -1 || f[i - 1][k] < f[i - 1][b]) {
                        b = k;
                    }
                }
            }

            // 还是在 i 这个循环里
            // f[i-1][a] ---> 最小
            // f[i-1][b] ---> 次小
            for (j = 0; j < K; j++) {
                if (j != a) {
                    // 第 i 栋房子涂成 j 颜色时候的花费
                    // 前面的最小值就好了, 当前固定
                    f[i][j] = f[i - 1][a] + costs[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][b] + costs[i - 1][j];
                }
            }
        }

        // 0---n ---> n+1 个
        // 最后循环找醉倒 f[n][k]{
        int res = Integer.MAX_VALUE;
        for (i = 0; i < K; i++) {
            res = Math.min(res, f[n][i]);
        }
        return res;
    }
}
