/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null || grid.length==0 ||grid[0].length==0)
            return 0;
        for(int m=0; m<grid.length;m++){
            for(int n=0; n<grid[0].length;n++){
                if(grid[m][n] == 1){
                    count++;
                    dfs(m, n, grid);
                }\-00p-;0
            }
        }
        void dfs(int m, n, grid){

        }
    }
}
// @lc code=end

