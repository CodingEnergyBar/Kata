/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 *
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 *
 * algorithms
 * Medium (37.23%)
 * Likes:    413
 * Dislikes: 40
 * Total Accepted:    31.3K
 * Total Submissions: 82.4K
 * Testcase Example:  '[[0,1],[1,0]]'
 *
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 * 
 * A clear path from top-left to bottom-right has length k if and only if it is
 * composed of cells C_1, C_2, ..., C_k such that:
 * 
 * 
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are
 * different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] ==
 * 0).
 * 
 * 
 * Return the length of the shortest such clear path from top-left to
 * bottom-right.  If such a path does not exist, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[0,1],[1,0]]
 * 
 * 
 * Output: 2
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[0,0,0],[1,1,0],[1,1,0]]
 * 
 * 
 * Output: 4
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 100
 * grid[r][c] is 0 or 1
 * 
 * 
 */
// @lc code=start
class Solution {

    int R, C;


    public int shortestPathBinaryMatrix(int[][] grid) {

        R = grid.length;
        C = grid[0].length;
        // corner case 是一行一列的时候: 因为下一步肯定不在 area 里, 但是是可以通过的
        if (grid[0][0] == 1)
            return -1;
        if (R == 1 && C == 1)
            return 1;
     
       
        int dirs[][] = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        boolean[][] visited = new boolean[R][C];
        Queue<Point> queue = new LinkedList<>();
         int[][] dis = new int[R][C];

        queue.add(new Point(0, 0));
        visited[0][0] = true;
        //起始点的步数为 1
        dis[0][0] = 1;
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            int x = cur.x;
            int y = cur.y;
         
            for (int i = 0; i < dirs.length; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (inGrid(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    // 还要注意 visited : 入队的时候把 visited 编程 true
                    visited[nx][ny] = true;
                    dis[nx][ny] = dis[x][y] + 1;
                    if (nx == R - 1 && ny == C - 1)
                        return dis[nx][ny];
              
                }
            }
        }
        return -1;
    }

    boolean inGrid(int x, int y) {
        return x >= 0 && y >= 0 && x <= R - 1 && y <= C - 1;
    }

    class Point {
        public int x;
        public int y;

        Point(int a, int b) {
            this.x = a;
            this.y = b;

        }
    }
}
// @lc code=end
