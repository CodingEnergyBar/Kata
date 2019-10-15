public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    class Room {
        int x;
        int y;

    }

    public void wallsAndGates(int[][] rooms) {
        // write your code here
        int INF = Integer.MAX_VALUE;
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        int[][] visited = new int[rooms.length][rooms[0].length];

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    qx.offer(i);
                    qy.offer(j);
                    visited[i][j] = -1;
                }
            }
        }

        int[] dx = new int[] { 0, 0, -1, 1 };
        int[] dy = new int[] { 1, -1, 0, 0 };

        int level = 0;
        while (!qx.isEmpty()) {
            // System.out.println(qx);
            // System.out.println(qy);
            level++;

            int size = qx.size();
            // !!! for under the whle to count the level

            for (int z = 0; z < size; z++) {

                int curX = qx.poll();
                int curY = qy.poll();
                for (int i = 0; i < 4; i++) {
                    int x = curX + dx[i];
                    int y = curY + dy[i];
                    if (isValid(x, y, rooms)) {
                        if (rooms[x][y] == INF) {
                            rooms[x][y] = level;
                            qx.offer(x);
                            qy.offer(y);

                        }
                    }
                }
            }

        }
    }

    boolean isValid(int x, int y, int[][] board) {
        if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
            return true;
        }
        return false;
    }
}