/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int res = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length;j++){
                if(findAnIsland(i, j, grid))
                    res++;
            }
        }
        return res;
        
    }
    boolean findAnIsland(int i, int j, char[][] grid){
        if(grid[i][j] == '0')
            return false;
        int dx[] =  new int []{1, -1, 0, 0};
        int dy[] = new int []{0, 0, 1, -1};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        queue.offer(new Pair(i, j));

        while(!queue.isEmpty()){
            Pair<Integer, Integer> cur = queue.poll();
            Integer x = cur.getKey();
            Integer y = cur.getValue();
           for(int d=0; d<4; d++){
               int newX = x + dx[d];
               int newY = y + dy[d];
               if (inTheBound(newX, newY, grid)&& grid[newX][newY] == '1'){
                   grid[newX][newY] = '0';
                   queue.offer(new Pair(newX, newY));
               }
           }

        }
        return true;
    }
    boolean inTheBound(int i, int j, char[][] grid){
        if(i >= 0 && i < grid.length && j>=0 && j< grid[0].length){
            return true;
        }
        return false;
    }
}
// @lc code=end

