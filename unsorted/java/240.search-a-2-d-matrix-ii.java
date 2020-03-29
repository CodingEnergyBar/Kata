import java.util.function.IntBinaryOperator;

/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length - 1, m = 0;
        while (n >= 0 && m < matrix[0].length) {
            int cur = matrix[n][m];
            if (cur > target) {
                n--;
            } else if (cur < target) {
                m++;
            } else {
                return true;
            }
        }
        return false;

    }
}
// @lc code=end
