/*
 * @lc app=leetcode id=226 lang=javascript
 *
 * [226] Invert Binary Tree
 */
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
var invertTree = function(root) {
	// nice one
	if (root == null) return null;
	let temp = root.left;
	root.left = invertTree(root.right);
	root.right = invertTree(temp);
	return root;
};
