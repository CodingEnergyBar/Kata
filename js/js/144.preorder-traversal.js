/*
 * @lc app=leetcode.cn id=144 lang=javascript
 *
 * [144] preorderTraversal
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
var preorderTraversal = function (root) {
    const res = [];
    const stack = [];
    if(root)
        stack.push(root);
    while (stack.length) {
        // visited
        const cur = stack.pop();
        res.push(cur.val);
        // 先访问的后放入stack
        if (cur.right) stack.push(cur.right);
        if (cur.left) stack.push(cur.left);
    }
    return res;
};
// 栈可以模拟递归
// 时间复杂度: O(n) n是树的节点个数
// 空间复杂度 就是 O(n) 最多所有的节点都压进去 
// @lc code=end

