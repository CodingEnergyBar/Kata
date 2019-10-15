public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // write your code here

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        // people's number need to be counted additionally...

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        }

        int day = 0;
        int[] dx = new int[] { 0, 0, 1, -1 };
        int[] dy = new int[] { 1, -1, 0, 0 };

        while (!qx.isEmpty()) {

            int size = qx.size();
            for (int z = 0; z < size; z++) {
                int zombieX = qx.poll();
                int zombieY = qy.poll();

                for (int i = 0; i < 4; i++) {
                    int x = zombieX + dx[i];
                    int y = zombieY + dy[i];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        qx.offer(x);
                        qy.offer(y);
                    }
                }
            }

            day++;
            System.out.println(qx);
            System.out.println(Arrays.deepToString(grid));
            System.out.println(day);
        }
        // before the last queue elements popped actually already polluted
        day--;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    return -1;
                }
            }
        }
        return day;
    }
}