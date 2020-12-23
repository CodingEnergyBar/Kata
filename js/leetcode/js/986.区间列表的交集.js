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
    let i = 1, j = 0;
    const C = [...A, ...B].sort((a, b) => a[0] - b[0])
    while (i < C.length) {
        if (C[i][0] >= C[j][1] && i !== j) { // end, start
            res.push([C[j][1], C[i][0]])
            j++;
        } else if (i === j) {
            i++;
        } else {
            j++;
        }
    }

    /**
     * A = [[0,2],[5,10],[13,23],[24,25]], 
     * B = [[1,5],[8,12],[15,24],[25,26]]
     * C = [0,2] [1,5] [5,10] [8,12],[13,23], [15,24],[24,25], [25, 26]
     * D = [1, 2], [5, 5], [8, 10], []
     */

    // while (i < A.length && j < B.length) {
    //     const curA = A[i];
    //     const curB = B[j];
    //     //has interset
    //     if (curA[1] >= curB[0]) {
    //         if (curA[1] >= curB[1]) {
    //             res.push([...curB])
    //             j++;
    //         } else { // curA.edn < curB.end
    //             res.push([curB[0], curA[1]])
    //             i++;
    //         }
    //     } else if (curB[1] >= curA[0]) {
    //         //B.end >= A.start
    //         if (curB[1] >= curA[1]) { // B.end> A.end
    //             res.push([...curA])
    //             i++;
    //         } else {
    //             res.push([curA[0], curB[1]])
    //             j++;
    //         }
    //     } else {
    //         if (curA[0] >= curB[0]) i++;
    //         else j++;
    //     }
    // }
    return res;

}
// @lc code=end

