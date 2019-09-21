/*
 * @lc app=leetcode id=112 lang=javascript
 *
 * [112] Path Sum
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
 * @param {number} sum
 * @return {boolean}
 */

// DFS
var hasPathSum = function(root, sum) {
	if (!root) return false;

	if (!root.left && !root.right) {
		// check leaf
		return sum === root.val;
	} else {
		// continue DFS
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
};
