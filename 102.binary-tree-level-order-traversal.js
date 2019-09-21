/*
 * @lc app=leetcode id=102 lang=javascript
 *
 * [102] Binary Tree Level Order Traversal
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
 * @return {number[][]}
 */

// summary: the level order need to be done by queue.length
// conner case:  root == null
var levelOrder = function(root) {
	if (root == null) {
		return [];
	}

	let queue = [];
	queue.push(root);
	let res = [];
	while (queue.length != 0) {
		let level = [];
		// level num is queue.length
		let len = queue.length;
		console.log('len', len);

		for (let i = 0; i < len; i++) {
			let node = queue.shift();
			console.log('node', node);
			if (node != null) level.push(node.val);

			if (node.left) queue.push(node.left);
			if (node.right) queue.push(node.right);
		}
		console.log('queue', queue);
		res.push(level);
	}

	return res;
};
