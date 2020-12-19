/*
 * @lc app=leetcode.cn id=226 lang=javascript
 *
 * [226] 翻转二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
// 时间 O(n) 树的
// 空间O(H) 树的高度
function invertTree(root) {
    if (!root)
        return root;
    if (!root.left && !root.right)
        return root;
    return {
        val: root.val,
        left: invertTree(root.right),
        right: invertTree(root.left)
    }
    // const left = invertTree(root.left)
    // const right = invertTree(root.right)
    // root.left = right;
    // root.right = left;
    // return root;

};
// @lc code=end

