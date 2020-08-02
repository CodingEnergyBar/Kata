/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    char[][] board;
    String word;
    int R, C;
    boolean[][] visited;
    int[][] dirs = new int[][]{{1,0}, {0, 1}, {-1,0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        R = board.length;
        C = board[0].length;
        visited = new boolean[R][C];
        for( int i=0; i< R; i++){
            for( int j=0; j< C; j++){
                if(dfs(i, j, 0))
                    return true;
            }
        }
        return false;
    }
    boolean dfs(int x, int y, int pos){
        char cur = board[x][y];
        if(pos == word.length()- 1 && cur == word.charAt(pos))
            return true;
        if(cur != word.charAt(pos))
            return false;
        visited[x][y] = true;
       
        for(int[] dir: dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(inTheBoard(nx, ny) && !visited[nx][ny]){
                if(dfs(nx, ny, pos+1))
                    return true;
            }
        }  
        visited[x][y] = false;
        return false; 
    }
    boolean inTheBoard(int x, int y){
        return x < R && y < C && x >=0  && y >=0;
    }
}
// @lc code=end

