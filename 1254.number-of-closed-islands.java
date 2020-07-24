
/*
 * @lc app=leetcode id=1254 lang=java
 *
 * [1254] Number of Closed Islands
 */

// @lc code=start
//先把周围的都填满就好了,,,,囧, 否则边界条件判断的太多
class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int R, C;
    boolean[][] visited; // 0 and visited not byside
    int [][] grid;

    public int closedIsland(int[][] grid) {
        //grid
        R = grid.length;
        C = grid[0].length;
        this.grid = grid;
        int res = 0;
        visited = new boolean[R][C];
        for(int i=0; i < grid.length;i++){
            for(int j=0; j< grid[0].length;j++){
                if(grid[i][j] == 0)
                    if(dfs(i, j))
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

    //dfs 是为了碳变 进来代表起点是可能的
    boolean dfs(int i, int j){
        //是从零过来的
        if(!intheGrid(i, j))
            return false;
        if(grid[i][j] == 1)
            return true;
        grid[i][j] = 1;
        
        // if(!bySide(i, j)){
        //     grid[i][j] = 1;
        // }
        // else{ // if(bySide(i, j)
        //     if(grid[i][j] == 0){
        //         // grid[i][j] = 1;
        //         return false;
        //     }else{
        //         return true;
        //     }
        // }
        boolean res = true;
        for(int[] dir: dirs){
            int nx = i + dir[0];
            int ny = j + dir[1];
            res = res & dfs(nx, ny);

            // if(intheGrid(nx, ny) && grid[nx][ny] == 0){
            //     if (dfs(nx, ny) == false)
            //         return false;
      
                // if(grid[nx][ny] == 0){
                //     grid[nx][ny] = 1;
                //     if(bySide(nx, ny)){
                //         return false;
                //     }else{
                //         if(!dfs(nx, ny))
                //             return false;
                //     }
                // }
            // }
        }
        return res;
    }
    public static void main(String[] args) {
        // int[][] grid = new int[][]

        int [][] grid = new int [][]{{0,0,1,1,0,1,0,0,1,0},{1,1,0,1,1,0,1,1,1,0},{1,0,1,1,1,0,0,1,1,0},{0,1,1,0,0,0,0,1,0,1},{0,0,0,0,0,0,1,1,1,0},{0,1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,0,1},{1,1,1,1,1,1,0,0,0,0},{1,1,1,0,0,1,0,1,0,1},{1,1,1,0,1,1,0,1,1,0}};

        Solution res = new Solution();
        System.out.println(res.closedIsland(grid));

        
    }
}
// @lc code=end

