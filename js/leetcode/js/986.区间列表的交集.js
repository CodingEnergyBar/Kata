/*
 * @lc app=leetcode.cn id=986 lang=javascript
 *
 * [986] 区间列表的交集
 */

// @lc code=start
/**
 * @param {number[][]} A
 * @param {number[][]} B
 * @return {number[][]}
 */
var intervalIntersection = function (A, B) {
    const res = []
    let i = 0, j = 0;
    /**
     * A = [[0,2],[5,10],[13,23],[24,25]], 
     * B = [[1,5],[8,12],[15,24],[25,26]]
     * C = [0,2] [1,5] [5,10] [8,12],[13,23], [15,24],[24,25], [25, 26]
     * D = [1, 2], [5, 5], [8, 10], []
     */

    while (i < A.length && j < B.length) {
        let [startA, endA] = A[i];
        let [startB, endB] = B[j]

        // 初始值没有考虑进去
        //has interset 1 end, 0 start
        if (endA < startB || endB < startA) {
            // continue;
        } else if (startA >= startB && startA <= endB) {
            res.push([startA, Math.min(endB, endA)])
        } else if (startB <= endA && startA <= startB) {
            res.push([startB, Math.min(endA, endB)])
        }
        // const l = Math.max(startA, startB)
        // const r = Math.min(endA, endB)

        // if (l <= r)
        //     res.push([l, r])

        /**
         startA < endB
         startB < endA 
         startA < endA
         startB < endB
         */
        if (endA < endB) {
            i++;
        } else {
            j++;
        }

    }
    return res;

}
// const A = [[0, 2], [5, 10], [13, 23], [24, 25]];
// const B = [[1, 5], [8, 12], [15, 24], [25, 26]];

const A = [[5, 10]];
const B = [[3, 10]];

// console.log(intervalIntersection(A, B))
// @lc code=end

