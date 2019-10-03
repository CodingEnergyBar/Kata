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
	// take care of passing reference
	helper(root);

	function helper(root){
		if(root === null)
			return null;

		// leaf
		if(root.left === null && root.right === null){
			return root;
		}

		let leftEnd = helper(root.left);
		let rightEnd = helper(root.right);


		if(leftEnd !== null){
			let tmp = root.right;
			root.right = root.left;
			leftEnd.right = tmp;
			root.left = null;
			if(rightEnd){
				return rightEnd;
			}else{
				return leftEnd;
			}
		}else{
			return rightEnd;
		}

	}


};
