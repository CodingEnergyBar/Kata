/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    int R, C;
    int dirs[][] = new int[][]{{0,1}, {1,0}};
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        C = obstacleGrid[0].length;
        R = obstacleGrid.length;
        // path number to x, y
        int paths[][] = new int[R][C];
        //浙西额都是 corner cases
        if(obstacleGrid[0][0] == 1 || obstacleGrid[R-1][C-1]== 1)
            return 0;
        //自己到自己有 1 条路
        paths[R-1][C-1] = 1;
        for(int j=C-1; j>=0; j--){
            for(int i=R-1; i>=0 ; i--){
                if(obstacleGrid[i][j] == 0){
                    for(int[] dir: dirs){
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if(inTheGrid(nx, ny)){
                            paths[i][j] += paths[nx][ny];
                        }
                    }
                }
            }
        }
        return paths[0][0];
    }
    boolean inTheGrid(int x, int y){
        return x >=0 && y >=0 && x < R && y <C;
    }
}
// @lc code=end

