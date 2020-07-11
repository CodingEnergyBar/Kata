package graph.dfs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=980 lang=java
 *
 * [980] Unique Paths III
 */

// @lc code=start
class Solution {
    int[] pre;
    int R, C;
    int start;
    int left;
    boolean[] visited; // [R][C]
    int[][] dirs;
    int[][] grid;
    List<List<int[]>> result;
    int end;
    public int uniquePathsIII(final int[][] grid) {
        //two dimension to one dimension
        R = grid.length; 
        C = grid[0].length;
        pre = new int[R*C];
        visited = new boolean[R*C];
        dirs = new int[][]{{0,1}, {1}, {0,-1}, {-1,0}};
        this.grid = grid;
        result =  new ArrayList<>();
        //1, 2
        init(grid);
        dfs(start, start, left+1);
        // printResult();
        return result.size();
    }
    void  dfs(int cur, int parent, int left){
        // if(visited[cur]) return;
        // else if(visited)
        visited[cur] = true;
        pre[cur] = parent;
        left--; // think through what left means
        int[] curGrid = getGrid(cur);

      
        for(int dir[]: dirs){
            int nx = curGrid[0] + dir[0];
            int ny = curGrid[1] + dir[1];
            int nextNum = getGridNum(nx, ny);
            if(inArea(nx, ny) && !visited[nextNum] && grid[nx][ny] == 0){
                dfs(nextNum, cur, left);
            }else if(nextNum == end && left == 0){
                result.add(getPath(parent));
            }
        }
        visited[cur] = false;
        // left++;
    }
    void init(int[][] grid){
        //start, left
        for(int i=0; i< R; i++){
            for(int j=0; j< C; j++){
                if(grid[i][j] == 1){
                    start = getGridNum(i, j);
                }
                else if (grid[i][j] == 2) {
                    end = getGridNum(i, j);
                }
                else if (grid[i][j] == 0) {
                    left++;
                }
            }
        }
    }
    boolean inArea(int x, int y){
        return x >=0  && y >=0 && x < R && y < C;
    }
    List<int[]> getPath(int last){
       List<int[]> res = new ArrayList<>();
       res.add(getGrid(end));
        while(last != start){
            res.add(getGrid(last));
            last = pre[last];
        }
        res.add(getGrid(start));
        Collections.reverse(res);
        return res;
    }
    void printResult(){
        for(List<int[]> path: result){
            for(int[]num: path){
                System.out.print("[" + num[0] + "," + num[1] +"]");
            }
            System.out.println();
        }
    }
    //one to two 
    int getGridNum(int x, int y){
        return x * C + y;
    }
    int[] getGrid(int num){
        int x = num / C;
        int y = num % C;
        return new int[]{x, y};
    }
    public static void main(String[] args) {
        // int[][] grid = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        // int[][] grid = new int[][]{{1,0,0,0},{0,0,0,0},{ 0, 0, 0, 2}};// 7, 4
        int[][] grid = new int[][]{{1,2}};// 7, 4

        System.out.println(new Solution().uniquePathsIII(grid));
        // System.out.println(new Solution().uniquePathsIII(grid));
    
    }

}
// @lc code=end

