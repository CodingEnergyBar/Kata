/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        // 一层一层的来
        int len = matrix.len;
        for (int l = len; l > 0; l -= 2) {
            // left up corner x=y=len-l
            rotateLayer(len - l, len, matrix);

        }

    }

    void rotateLayer(int start, int len, int[][] matrix) {
        // 对每一个元素进行交换
        for (int i = 0; i < len; i++) {
            // 每个元素 每圈上面是起始点
            int x = start + i, y = start;

            int tmp = matrix[x][y];

            for (int j = 0; j < len; j++) {
                // int ny = (x + len - 1) % len;
                // int nx = y;
                // int tmp = matrix[x][y];
                int py = x;
                int px = (x - len + 1) % len;

            }
        }

    }
}
// @lc code=end
