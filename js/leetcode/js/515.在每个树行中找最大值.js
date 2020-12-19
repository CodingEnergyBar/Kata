/*
 * @lc app=leetcode.cn id=515 lang=javascript
 *
 * [515] 在每个树行中找最大值
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function (root) {
    if (!root) return []
    const queue = [root]
    const res = []

    while (queue.length) {
        const layerSize = queue.length;
        let max = -Infinity;
        for (let i = 0; i < layerSize; i++) {
            const cur = queue.shift();
            max = Math.max(cur.val, max);
            if (cur.left) queue.push(cur.left)
            if (cur.right) queue.push(cur.right)
        }
        res.push(max)
    }
    return res;
};
// @lc code=end

