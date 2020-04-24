//In an N by N square grid, each cell is either empty (0) or blocked (1).
//
// A clear path from top-left to bottom-right has length k if and only if it is
//composed of cells C_1, C_2, ..., C_k such that:
//
//
// Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are d
//ifferent and share an edge or corner)
// C_1 is at location (0, 0) (ie. has value grid[0][0])
// C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
// If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
//
//
//
// Return the length of the shortest such clear path from top-left to bottom-rig
//ht. If such a path does not exist, return -1.
//
//
//
// Example 1:
//
//
//Input: [[0,1],[1,0]]
//
//
//Output: 2
//
//
//
//
// Example 2:
//
//
//Input: [[0,0,0],[1,1,0],[1,1,0]]
//
//
//Output: 4
//
//
//
//
//
//
// Note:
//
//
// 1 <= grid.length == grid[0].length <= 100
// grid[r][c] is 0 or 1
//
// Related Topics Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 用 row -R  col - C 命名
    int R;
    int C;

    Queue<Integer> queue;
    boolean[][] visited;
    // 这里直接赋值
    private int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1},
            {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        // corner cases
        if(grid[0][0] ==1) return -1;
        if(R==0 && C == 0) return 1;

        visited = new boolean[R][C];
        queue = new LinkedList<>();
        int[][] dis = new int[R][C];

        // initialize
        queue.add(0);
        dis[0][0] = 1;
        // isEmpty not empty
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int curX = cur / C,  curY = cur % C;
            //入队的的时候 visisted 变, 这样减少 corner case
            visited[curX][curY] = true;
            if(curX == R-1 && curY == C-1){
                return  dis[curX][curY];
            }

            for(int[] dir: dirs){
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];
                if(inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 0 ){
                    int next = nextX * C + nextY;
                    queue.offer(next);
                    visited[nextX][nextY] = true;
                    dis[nextX][nextY] = dis[curX][curY] + 1;

                }
            }
        }
        return -1;
    }
    boolean inArea(int x, int y){
        return x<R && y< C && x>=0 && y>=0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
