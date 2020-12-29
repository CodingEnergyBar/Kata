/*
 * @lc app=leetcode.cn id=289 lang=javascript
 *
 * [289] 生命游戏
 */

// @lc code=start
/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var gameOfLife = function (board) {
    /**
     *  Any live cell with fewer than two live neighbors dies, as if caused by under-population.
     *  n(1) < 2 -> 0
        Any live cell with two or three live neighbors lives on to the next generation.
        n(1) = 2| 3 -> 1
        Any live cell with more than three live neighbors dies, as if by over-population.
        n(1) >=3 -> 0
        Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        n(0) =3  => 1
     */
    // in place 
    //   00 -> 00  % 2
    //  01 -> 01
    //  2 -> 10
    // 3 -> 11
    if (!board || !board[0])
        return board;
    const dirs = [[0, 1], [1, 0], [0, -1], [-1, 0],
    [1, 1], [1, -1], [-1, 1], [-1, -1]
    ]
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            let cur = board[i][j]
            let lives = 0;
            for (const dir of dirs) {
                const nx = i + dir[0];
                const ny = j + dir[1];
                if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length)
                    lives += (board[nx][ny]) % 2
            }
            if (cur === 1) {
                if (lives < 2) board[i][j] = 1; // 01
                else if (lives === 2 || lives === 3) board[i][j] = 3; // 11
                else if (lives > 3) board[i][j] = 1; // 01
            } else if (cur === 0 && lives === 3) board[i][j] = 2; //10
        }
    }
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            board[i][j] = Math.floor(board[i][j] / 2)
        }
    }
    return board




};
// @lc code=end

