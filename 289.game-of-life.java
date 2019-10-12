/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 *
 * https://leetcode.com/problems/game-of-life/description/
 *
 * algorithms
 * Medium (48.27%)
 * Likes:    1159
 * Dislikes: 214
 * Total Accepted:    134.8K
 * Total Submissions: 278.3K
 * Testcase Example:  '[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]'
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply
 * as Life, is a cellular automaton devised by the British mathematician John
 * Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal,
 * vertical, diagonal) using the following four rules (taken from the above
 * Wikipedia article):
 * 
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population.
 * Any live cell with two or three live neighbors lives on to the next
 * generation.
 * Any live cell with more than three live neighbors dies, as if by
 * over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if
 * by reproduction.
 * 
 * 
 * Write a function to compute the next state (after one update) of the board
 * given its current state. The next state is created by applying the above
 * rules simultaneously to every cell in the current state, where births and
 * deaths occur simultaneously.
 * 
 * Example:
 * 
 * 
 * Input: 
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * Output: 
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 * 
 * 
 * Follow up:
 * 
 * 
 * Could you solve it in-place? Remember that the board needs to be updated at
 * the same time: You cannot update some cells first and then use their updated
 * values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the
 * board is infinite, which would cause problems when the active area
 * encroaches the border of the array. How would you address these problems?
 * 
 * 
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        int[][] summary = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                summary[i][j] = getNeighbors(board, i, j);

            }
        }
        // have to traverse twice...

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveNeighbors = summary[i][j];
                if (board[i][j] == 0) {
                    if (liveNeighbors == 3)
                        board[i][j] = 1;
                } else {
                    if (liveNeighbors < 2 || liveNeighbors > 3)
                        board[i][j] = 0;
                }
            }
        }

    }

    int getNeighbors(int[][] board, int i, int j) {

        int r = board.length, c = board[0].length;

        int neighbor = 0;

        int[] Dx = new int[] { -1, 0, 1 };
        int[] Dy = new int[] { -1, 0, 1 };

        for (int dx : Dx) {
            for (int dy : Dy) {
                int x = i + dx;
                int y = j + dy;

                if (x >= 0 && x < r && y >= 0 && y < c) {

                    if (x == i && y == j)
                        continue;
                    neighbor += board[x][y];

                }

            }
        }
        return neighbor;

    }
}
// @lc code=end
