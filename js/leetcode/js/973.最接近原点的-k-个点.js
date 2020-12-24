/*
 * @lc app=leetcode.cn id=973 lang=javascript
 *
 * [973] 最接近原点的 K 个点
 */

// @lc code=start
/**
 * @param {number[][]} points
 * @param {number} K-+
 * @return {number[][]}
 */
var kClosest = function (points, K) {
    points.sort((a, b) => {
        const [xa, ya] = a;
        const [xb, yb] = b
        return xa * xa + ya * ya - xb * xb - yb * yb
    })
    return points.slice(0, K)
};
// @lc code=end

