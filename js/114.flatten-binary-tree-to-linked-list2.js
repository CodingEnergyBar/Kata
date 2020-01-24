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
// testcase: [1,2,5,3,4,null,6];
// [1,null,2,null,3,null,4,null,5,null,6]
//[1,2,null,3,4,5]
//
var flatten = function(root) {
	// let tmp = root.left;
	// root.right = root.left;
	// console.log(root);
	// let [ end, newroot ] = helper(root);
	// return newroot;
	helper(root);

	function helper(root) {
		// console.log('root', root === null ? 'null' : root.val);
		// return right end and root
		if (root === null) return [ null, null ];

		// if (root.left == null && root.right == null) {
		// 	return [ root, root ];
		// }
		let [ left_end, left ] = helper(root.left);
		let [ right_end, right ] = helper(root.right);

		// let tmp = new TreeNode(0);
		// tmp.right = right;

		if (left_end) {
			left_end.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		if (right_end) {
			return [ right_end, root ];
		}
		if (left_end) {
			return [ left_end, root ];
		}
		return [ root, root ];

		// if (left) {
		// 	root.right = left;
		// }
		// //!!!!
		// root.left = null;

		// if (left_end) {
		// 	left_end.right = right;
		// }

		// console.log('endroot', root);
		// return [ right_end, root ];

		// left.right = ;
	}
};
