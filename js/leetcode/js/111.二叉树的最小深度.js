/*
 * @lc app=leetcode.cn id=111 lang=javascript
 *
 * [111] 二叉树的最小深度
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
 * @return {number}
 */
var minDepth = function (root) {
    // 为什么不用深度呢? 拿到所有的叶子节点
    // 广度

    if (!root)
        return 0;
    const queue = [root];
    let level = 1;
    while (queue.length) { //逻辑错了
        const lCount = queue.length;
        // console.log('lCount', lCount)
        for (let i = 0; i < lCount; i++) {
            const cur = queue.shift(); //是shift
            // console.log(queue)
            const { left, right } = cur;

            if (!left && !right) {
                return level;
            }
            if (left) queue.push(left);
            if (right) queue.push(right);
        }
        level++;
    } 
    return level;
};
// @lc code=end

