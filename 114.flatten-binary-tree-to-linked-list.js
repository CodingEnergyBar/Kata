/*
 * @lc app=leetcode id=114 lang=javascript
 *
 * [114] Flatten Binary Tree to Linked List
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
 * @return {void} Do not return anything, modify root in-place instead.
 */
// testcase: [1,2,5,3,4,null,6]
// testcase: [1,2,null,3]

var flatten = function(root) {
	console.log('\n');
	helper(root);

	function helper(root) {
		// return the end of the left
		if (root === null) return null;
		if (root.left === null && root.right === null) return root;
		let leftEnd = helper(root.left);
		let rightEnd = helper(root.right);

		let tmp = root.right;
		root.right = root.left;
		root.left = null;

		if (leftEnd) {
			// left is not null
			leftEnd.right = tmp;
		}
		else {
			// left is null
			root.right = tmp;
		}
		// console.log('root', root);
		// console.log('rightEnd', rightEnd);
		if (rightEnd) return rightEnd;
		else return leftEnd;
		// return rightEnd;
	}
};
