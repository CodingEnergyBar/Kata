/*
 * @lc app=leetcode.cn id=104 lang=javascript
 *
 * [104] 二叉树的最大深度
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
// 时间复杂度 : O(n)
// 空间复杂度 : 二叉树如果是非常深 O(n) 
var maxDepth = function (root) {
    //不要遍历到根
    if (root === null)
        return 0;
    if (!root.right && !root.left)
        return 1;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
};
// @lc code=end

