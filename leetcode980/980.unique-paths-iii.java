package leetcode980;
/*
 * @lc app=leetcode id=980 lang=java
 *
 * [980] Unique Paths III
 */

// @lc code=start
class Solution {
    int[][] grid;
    int R, C;
    // bit 代替
    boolean[][] visited;
    int count;
    int startX, startY;
    int res;
    int[][] dirs =new int[][]{{0,1}, {0,-1}, {1, 0}, {-1, 0}};
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        visited = new boolean[R][C];
        for(int i=0; i< R; i++){
            for(int j=0; j<C; j++){
                if(grid[i][j] == -1)
                    continue;
                count++;
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }
            }
        }
        dfs(startX, startY);
        return res;

    }

    void dfs(int x, int y){
        visited[x][y] = true;
        count--;
        if(grid[x][y] == 2){
            if(count == 0)
                res++;
            visited[x][y] = false;
            count++;
            return;
        }
        for(int[] dir: dirs){
            int nx = x+ dir[0], ny= y+ dir[1];
            if(inTheGrid(nx, ny) && !visited[nx][ny] && grid[nx][ny] != -1){
                dfs(nx, ny);
            }
        }
        visited[x][y] = false;
        count++;
    }
    boolean inTheGrid(int x, int y){
        return x >=0 && y>=0 &&x<R && y < C;
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        new Solution().uniquePathsIII(grid);
    }
}

// @lc code=end

