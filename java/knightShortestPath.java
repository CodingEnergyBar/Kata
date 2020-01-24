/**
 * Definition for a point. class Point { int x; int y; Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; } }
 */

public class Solution {
    /**
     * @param grid:        a chessboard included 0 (false) and 1 (true)
     * @param source:      a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here

        // grid is the barrier

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // HashSet<Point> visited = new HashSet();

        Queue<Point> queue = new LinkedList();
        queue.add(source);
        visited[source.x][source.y] = true;

        // visited.add(source);
        // visited

        int step = 0;

        int[] dx = { 1, 1, -1, -1, 2, 2, -2, -2 };
        int[] dy = { 2, -2, 2, -2, 1, -1, 1, -1 };

        while (!queue.isEmpty()) {
            // System.out.println(Arrays.deepToString(visited));

            int size = queue.size();

            for (int j = 0; j < size; j++) {
                Point cur = queue.poll();

                if (isEqual(cur, destination)) {
                    // System.out.println("cur " + cur.x + cur.y);
                    return step;
                }

                for (int i = 0; i < dx.length; i++) {
                    int x = cur.x + dx[i];
                    int y = cur.y + dy[i];

                    // here is -1 do not forget
                    if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
                        continue;
                    }
                    if (visited[x][y])
                        continue;
                    // barrier 2 do not forget
                    if (grid[x][y] == true)
                        continue;
                    visited[x][y] = true;
                    // visited.add(new Point(x, y));
                    queue.offer(new Point(x, y));
                }
            }
            // step ++ cannot forget
            step++;

        }
        return -1;

    }

    boolean isEqual(Point a, Point b) {
        return a.x == b.x && a.y == b.y;
    }
}