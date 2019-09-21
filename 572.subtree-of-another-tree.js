/*
 * @lc app=leetcode id=572 lang=javascript
 *
 * [572] Subtree of Another Tree
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} s
 * @param {TreeNode} t
 * @return {boolean}
 * 
 */

// two layer of dfs
var isSubtree = function(s, t) {
	// if(!s) return !t;

	if (s === null) return t === null;
	else if (isEqual(s, t)) return true;
	else if (isSubtree(s.left, t)) return true;
	else if (isSubtree(s.right, t)) return true;
	else return false;
};

const isEqual = (a, b) => {
	if (a === null) return b === null;
	else if (b === null) return false;
	else if (a.val === b.val) return isEqual(a.left, b.left) && isEqual(a.right, b.right);
	else return false;
};
