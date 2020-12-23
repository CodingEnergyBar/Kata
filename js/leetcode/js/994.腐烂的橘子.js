/*
 * @lc app=leetcode.cn id=994 lang=javascript
 *
 * [994] 腐烂的橘子
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var orangesRotting = function (grid) {
    if (!grid.length || !grid[0].length)
        return -1;
    const N = grid.length;
    const M = grid[0].length;
    let cnt = 0;
    const queue = [];
    // const visited = Array(m).fill(Array(n).fill(false))

    for (let m = 0; m < M; m++) {
        for (let n = 0; n < N; n++) {
            if (grid[m][n] === 1) {
                cnt++;
            } else if (grid[m][n] === 2) {
                queue.push([m, n])
                // visited[m][n] = true;
            }
        }
    }
    let step = 0;
    const dirs = [
        [0, 1], [1, 0],
        [0, -1], [-1, 0]
    ]
    while (queue.length) {
        const size = queue.length;
        for (let i = 0; i < size; i++) {
            const [x, y] = queue.shift();
            for (const dir of dirs) {
                // console.log("dir", dir)
                const nextX = x + dir[0];
                const nextY = y + dir[1];
                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    if (grid[nextX][nextY] === 1) {
                        grid[nextX][nextY] = 2;
                        queue.push([nextX, nextY])
                        cnt--;
                    }
                }
            }

        }
        step++;
    }
    // console.log()
    return cnt === 0 ? (step - 1) : -1;
};

orangesRotting([[0, 2]])
// @lc code=end

