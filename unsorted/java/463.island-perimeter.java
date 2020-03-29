/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

// @lc code=start
class Solution {
    // neighbor +2 new island + 4
    // 如何判断是 new island : 内行每列 往前推,
    // 不对: 如果是新开的一行: 如果上面和左边都不是 1 那么就是新的 island, 但右边是

    // the result is islands * 4 - neighbours * 2: 统计所有的内联, 和有 neighbor 的

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return res;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1)
                        res -= 2;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1)
                        res -= 2;
                }
            }
        }
        return res;
    }

    // boolean hasNeighbor(int[][] grid, int i, int j) {
    // if w

    // }

    // boolean isNewIsland(int[][] grid, int i, int j) {

    // if (i - 1 >= 0 && grid[i - 1][j] == 1)
    // return false;
    // if (j - 1 >= 0 && grid[i][j - 1] == 1)
    // return false;
    // return true;
    // }
}
// @lc code=end
