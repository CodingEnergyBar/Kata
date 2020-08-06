/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {

    int R;
    int C;
    char[][] board;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
        this.board = board;
         R = board.length;
         if(R == 0) return;

        C = board[0].length;
        if(C == 0) return;
        for(int i=0; i<R; i++){
            if (board[i][0] == 'O') dfs(i, 0);
            if (board[i][C-1] == 'O')dfs(i, C-1);
        }
        for(int j=0; j<C; j++){
            if(board[0][j] == 'O') dfs(0, j);
            if(board[R-1][j] == 'O') dfs(R-1, j);
        }
        for(int i=0; i< R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    void dfs(int x, int y){
        board[x][y] = '#';
        for(int[] dir: dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(inTheGrid(nx, ny) && board[nx][ny] == 'O'){
                dfs(nx, ny);
            }
        }
    }
    boolean inTheGrid(int x, int y){
        return x >=0 && x < R && y >= 0 && y < C;
    }
}
// @lc code=end

