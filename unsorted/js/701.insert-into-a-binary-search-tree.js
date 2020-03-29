/*
 * @lc app=leetcode id=701 lang=javascript
 *
 * [701] Insert into a Binary Search Tree
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
 * @param {number} val
 * @return {TreeNode}
 */
const insertIntoBST = (root, val) => {
	if (!root) {
		root = new TreeNode(val);
	}
	else {
		let cur = root;
		while (cur) {
			if (cur.val < val) {
				if (cur.right === null) {
					cur.right = new TreeNode(val);
					break;
				}
				else {
					cur = cur.right;
				}
			}
			else {
				if (cur.left === null) {
					cur.left = new TreeNode(val);
					break;
				}
				else {
					cur = cur.left;
				}
			}
		}
	}

	return root;
};
