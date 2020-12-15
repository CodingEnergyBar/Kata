/*
 * @lc app=leetcode.cn id=417 lang=javascript
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var pacificAtlantic = function (matrix) {
    if (!matrix || !matrix[0])
        return [];
    // 用矩阵记录 --> 或者set呢 ==> 用矩阵就不需要visited了
    const m = matrix.length;
    const n = matrix[0].length;
    const flow1 = Array.from({ length: m }, () => new Array(n).fill(false))
    // const flow1 = Array.from(Array(m), () => new Array(n).fill(false))
    const flow2 = Array.from(Array(m), () => new Array(n).fill(false))

    const dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

    // 挺好的 有矩阵的 都可以用矩阵的形式visited

    const dfs = (r, c, flow) => {
        flow[r][c] = true; // 这里先设置成true 就省略了初始化的过程
        dirs.forEach(dir => {
            const nr = r + dir[0];
            const nc = c + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n
                && !flow[nr][nc]
                && matrix[nr][nc] >= matrix[r][c])
                dfs(nr, nc, flow);
        })
    }
    // 沿着海岸线 r第一行 c=0
    for (let r = 0; r < m; r++) {
        dfs(r, 0, flow1)
        dfs(r, n - 1, flow2)
    }

    for (let c = 0; c < n; c++) {
        dfs(0, c, flow1)
        dfs(m - 1, c, flow2)
    }


    const res = [];
    for (let r = 0; r < m; r++) {
        for (let c = 0; c < n; c++) {
            if (flow1[r][c] && flow2[r][c])
                res.push([r, c])
        }
    }
    return res;

    /**
     * in java
     * double[][] matrix = new double[20][4];

        // Fill each row with 1.0
        for (double[] row: matrix)
            Arrays.fill(row, 1.0);
     */

    // const flow1 = new Set();


};
// @lc code=end

