/*
 * @lc app=leetcode id=104 lang=javascript
 *
 * [104] Maximum Depth of Binary Tree
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
 * @return {number}
 */
// import Tree from './Tree';

var maxDepth = function(root) {
	if (root === null || root === undefined) return 0;

	// let left = maxDepth(root.left);
	// let right = maxDepth(root.right);

	// return Math.max(left, right);
	return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
};

