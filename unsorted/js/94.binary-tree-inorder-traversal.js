/*
 * @lc app=leetcode id=94 lang=javascript
 *
 * [94] Binary Tree Inorder Traversal
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
var inorderTraversal = function(root) {
    const inorderTraversalHelper = ( root, res)=>{
        if (root === null)
            return res;
        inorderTraversalHelper(root.left,res)
        res.push(root.val);
        inorderTraversalHelper(root.right,res);
        return res;
    }
    return inorderTraversalHelper(root, []);
};

// @lc code=end

