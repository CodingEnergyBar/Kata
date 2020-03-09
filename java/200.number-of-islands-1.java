/*
 * @lc app=leetcode id=200 lang=java
*/
// @lc code=start
class Solution {
    boolean visited[][];
    int res = 0;
    int[][] d = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numIslands(char[][] grid) {
        // ??
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return res;

        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && searchIsland(grid, i, j) == true) {
                    res++;
                }
            }
        }
        return res;

    }

    // 标记
    boolean searchIsland(char[][] grid, int x, int y) {

        visited[x][y] = true;

        if (grid[x][y] == '0') {
            return false;
        }
        if (grid[x][y] == '1') {
            for (int i = 0; i < 4; i++) {
                int newx = x + d[i][0];
                int newy = y + d[i][1];
                if (intheGrid(newx, newy, grid) && !visited[newx][newy]) {
                    searchIsland(grid, newx, newy);
                }
            }
        }
        return true;
    }

    boolean intheGrid(int x, int y, char[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
// @lc code=end
