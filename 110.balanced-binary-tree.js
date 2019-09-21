/*
 * @lc app=leetcode id=110 lang=javascript
 *
 * [110] Balanced Binary Tree
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
 * @return {boolean}
 */
var isBalanced = function(root) {
	if (!root) return true;
	else if (!root.left && !root.right) return true;

	let left = getHeight(root.left);
	let right = getHeight(root.right);

	if (Math.abs(left - right) > 1) return false;
	else return isBalanced(root.left) && isBalanced(root.right);
};
// -1 is not balanced , otherwise is the
function getHeight(root) {
	if (!root) return 0;
	return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}
