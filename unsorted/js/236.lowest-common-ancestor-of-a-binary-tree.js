/*
 * @lc app=leetcode id=236 lang=javascript
 *
 * [236] Lowest Common Ancestor of a Binary Tree
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
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */

//  test:[3,5,1,6,2,0,8,null,null,7,4]\n5\n1
// assume not p, q in the binary tree
var lowestCommonAncestor = function(root, p, q) {
	const [ a, b, lca ] = helper(root, p, q);
	if (a && b) {
		console.log('lca', lca.val);
		return lca;
	} else return null;

	function helper(root, p, q) {
		// return a, b and lca
		if (root == null) {
			return [ false, false, null ];
		}
		let [ left_a, left_b, left_exist ] = helper(root.left, p, q);
		console.log('left_a, left_b, left_exist', left_a, left_b, left_exist);
		let [ right_a, right_b, right_exist ] = helper(root.right, p, q);
		console.log('right_a, right_b, right_exist', right_a, right_b, right_exist);

		let a = left_a || right_a || root == p;
		let b = left_b || right_b || root == q;

		// if(a && b){// a and b exist together in left and right
		//     return [a, b, root];
		// }
		if (root == p || root == q) {
			// a
			return [ a, b, root ];
		}
		if (left_exist && right_exist) {
			return [ a, b, root ];
		}
		if (left_exist) {
			return [ a, b, left_exist ];
		}
		if (right_exist) {
			return [ a, b, right_exist ];
		} else {
			return [ a, b, null ];
		}
	}
};
