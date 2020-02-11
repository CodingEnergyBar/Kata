/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        // 一层一层的来

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        assert (matrix.length == matrix[0].length);
        int len = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < len / 2; j++) {
                // !!
                int j2 = len - j - 1;
                int tmp = matrix[i][j2];
                matrix[i][j2] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

    }

}
// @lc code=end
