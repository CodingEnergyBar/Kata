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

// lintcode 175
var invertTree = function(root) {
	//traverse dfs
	if (!root) return null;

	let leftTree = invertTree(root.left);
	let rightTree = invertTree(root.right);

	root.left = rightTree;
	root.right = leftTree;

	return root;
};
