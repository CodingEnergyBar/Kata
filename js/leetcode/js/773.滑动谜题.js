/*
 * @lc app=leetcode.cn id=773 lang=javascript
 *
 * [773] 滑动谜题
 */

// @lc code=start
/**
 * @param {number[][]} board
 * @return {number}
 */
var slidingPuzzle = function (board) {
    // 华容道把...
    // 0 与一个相邻的数字
    /**
     * [1,2,3]
     * [5,4,0]
     */
    /**
     * [4,1,2]
     * [5,0,3]
     */
    const M = 2;
    const N = 3;
    const des = '123450'
    const initState = encodedBoard(board)
    if (initState === des)
        return 0;

    let step = 1;
    const queue = [initState];
    const visited = new Set();
    visited.add(initState)

    const dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]


    // 每次都写错 不是
    while (queue.length) {
        const size = queue.length;
        for (let i = 0; i < size; i++) {
            const cur = queue.shift();

            let { x0, y0, board } = decodeBoard(cur)
            for (const dir of dirs) {
                const nx0 = x0 + dir[0]
                const ny0 = y0 + dir[1]
                if (isValid(nx0, ny0)) {
                    moveBoard(board, x0, y0, nx0, ny0)
                    const nBoardStr = encodedBoard(board)
                    if (!visited.has(nBoardStr)) {
                        if (nBoardStr === des)
                            return step;
                        visited.add(nBoardStr)
                        queue.push(nBoardStr)
                    }
                    moveBoard(board, x0, y0, nx0, ny0)
                }
            }
        }
        step++;
    }
    return -1;
    function moveBoard(board, x, y, nx, ny) {
        const tmp = board[nx][ny]
        board[nx][ny] = board[x][y]
        board[x][y] = tmp;
    }

    function encodedBoard(board) {
        let res = ''
        for (let i = 0; i < M; i++)
            for (let j = 0; j < N; j++)
                res += board[i][j]
        return res;
    }

    function isValid(x, y) {
        return x >= 0 && y >= 0 && x < M && y < N
    }

    function decodeBoard(cur) {
        const arr = cur.split('')
        const board = [...Array(M)].map(r => (new Array(N)))
        let x0, y0;
        for (let i = 0; i < M * N; i++) {
            const num = arr[i]; // parseInt...
            const curRow = Math.floor(i / N);
            const curCol = i % N;
            board[curRow][curCol] = num;
            if (num === '0') { x0 = curRow; y0 = curCol }
        }

        return {
            x0, y0, board
        }
    }
}
let board = [[1, 2, 3], [4, 5, 0]];
board = [[1, 2, 3], [4, 0, 5]];
console.log(slidingPuzzle(board))




// @lc code=end

