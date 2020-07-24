/*
 * @lc app=leetcode id=1254 lang=java
 *
 * [1254] Number of Closed Islands
 */

// @lc code=start
class Solution3 {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int R, C;
    boolean[][] visited; // 0 and visited not byside
    int [][] grid;
    public int closedIsland(int[][] grid) {
        //grid
        R = grid.length;
        C = grid[0].length;
        this.grid = grid;
        int res =0;
        visited = new boolean[R][C];
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(!bySide(i, j) && !visited[i][j] && grid[i][j] == 0 && dfs(i, j))
                    res++;
            }
        }
        return res;
    }

    boolean bySide(int i, int j){
        return i == R-1 || i==0 || j == 0 || j == C - 1;
    }
    boolean intheGrid(int i, int j){
        return i <= R-1 && i>=0 && j >= 0 && j <= C - 1;
    }

    //dfs 是为了碳变
    boolean dfs(int i, int j){
        boolean res = true;
        for(int[] dir: dirs){
            int nx = i + dir[0];
            int ny = j + dir[1];
            if(intheGrid(nx, ny)){
                if(grid[nx][ny] == 1) continue; //happy path find the bound, find the bound 
                if(grid[nx][ny] == 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(bySide(nx, ny))
                        return false;
                    res = (res && dfs(nx, ny));
                }
            }
        }
        return res;
       
    }
    public static void main(String[] args) {
        // int[][] grid = new int[][]

        int [][] grid = new int [][]{{0,0,1,1,0,1,0,0,1,0},{1,1,0,1,1,0,1,1,1,0},{1,0,1,1,1,0,0,1,1,0},{0,1,1,0,0,0,0,1,0,1},{0,0,0,0,0,0,1,1,1,0},{0,1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,0,1},{1,1,1,1,1,1,0,0,0,0},{1,1,1,0,0,1,0,1,0,1},{1,1,1,0,1,1,0,1,1,0}};

        System.out.println(new Solution3().closedIsland(grid));

        
    }
}
// @lc code=end

