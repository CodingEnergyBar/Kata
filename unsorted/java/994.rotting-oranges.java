/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    private int m;
    private int n;

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        int minutes = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
        int dx[] = new int[] { 1, -1, 0, 0 };
        int dy[] = new int[] { 0, 0, 1, -1 };

        while (!queue.isEmpty()) {
            int length = queue.size();
            boolean lastRound = true;
            /** solution 里的处理方法 */
            // // count the num of rotten oranges, if it equals to total num, return time;
            // rotten += size;
            // if (rotten == total)
            // return time;

            // // every round, time ++
            // time++;

            for (int l = 0; l < length; l++) {
                Pair<Integer, Integer> cur = queue.poll();
                int i = cur.getKey();
                int j = cur.getValue();
                for (int k = 0; k < 4; k++) {
                    int newN = i + dx[k];
                    int newM = j + dy[k];
                    if (inTheBound(newN, newM, grid) && grid[newN][newM] == 1) {
                        // mark
                        grid[newN][newM] = 2;
                        queue.add(new Pair(newN, newM));
                        lastRound = false;

                    }
                }
            }
            // again 注意应该怎么处理这里
            if (!lastRound)
                minutes++;

        }
        if (allRottened(grid)) {
            return minutes;
        }
        return -1;

        // bfs

    }

    boolean allRottened(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
    // add test

    boolean inTheBound(int x, int y, int[][] grid) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
            return true;
        }
        return false;

    }
}
// @lc code=end
