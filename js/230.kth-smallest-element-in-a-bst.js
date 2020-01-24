/*
 * @lc app=leetcode id=230 lang=javascript
 *
 * [230] Kth Smallest Element in a BST
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
 * @param {number} k
 * @return {number}
 */

//  testcase:
//  [3,1,4,null,2]\n1

var kthSmallest = function(root, k) {
	let dummy = new TreeNode(0);
	dummy.right = root;
	let stack = [ dummy ];
	// console.log(stack);

	while (stack.length != 0) {
		// console.log('stack', stack);
		let cur = stack.pop();

		if (cur.right) {
			// traverse left
			let left = cur.right;
			while (left) {
				stack.push(left);
				left = left.left;
			}
		}
		if (!stack.length) {
			return null;
		}

		k--;
		// plus dummy
		if (k === 0) {
			break;
		}
	}

	let cur = stack.pop();
	return cur.val;
};
