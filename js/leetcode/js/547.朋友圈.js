/*
 * @lc app=leetcode.cn id=547 lang=javascript
 *
 * [547] 朋友圈
 */

// @lc code=start
/**
 * @param {number[][]} M
 * @return {number}
 */

class UF {
    constructor(N) {
        this.root = [...Array(N)].map((e, i) => i)
        this.size = N
    }
    connect(i, j) {
        const iRoot = this.findRoot(i)
        const jRoot = this.findRoot(j)
        if (iRoot !== jRoot) {
            this.root[jRoot] = iRoot;
            this.size--;
        }
    }
    findRoot(i) {
        if (this.root[i] !== i) {
            this.root[i] = this.findRoot(this.root[i])
        }
        return this.root[i]
    }

    // size() {
    //     return this.size;
    // }


}
var findCircleNum = function (M) {

    const size = M.length;
    if (size === 0)
        return 0;
    const uf = new UF(size);
    //   1 2 3
    // 1 1 o o
    // 2 0 1 o
    // 3
    for (let i = 0; i < size; i++) {
        for (let j = i + 1; j < size; j++) {
            if (M[i][j] === 1)
                uf.connect(i, j)
        }
    }
    return uf.size
};
let input = [[1, 0, 0], [0, 1, 0], [0, 0, 1]];
input = [[[1, 0, 0, 1], [0, 1, 1,
    0], [0, 1, 1, 1], [1, 0, 1, 1]]];
console.log(findCircleNum(input))
// @lc code=end

