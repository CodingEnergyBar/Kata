/*
 * @lc app=leetcode id=235 lang=javascript
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
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

function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

var arrayToTree = function(arr) {
	if (arr == []) return null;

	let root = new TreeNode(arr[0]);
	let queue = [];
	queue.push(root);

	for (let i = 1; i < arr.length; i++) {
		let parent = queue.shift();

		// left
		if (arr[i] !== 'null') {
			let left = new TreeNode(arr[i]);
			parent.left = left;
			queue.push(left);
		}

		// right
		if (i + 1 < arr.length) {
			i++;
			if (arr[i] !== 'null') {
				let right = new TreeNode(arr[i]);
				parent.right = right;
				queue.push(right);
			}
		}
	}
	return root;
};

var lowestCommonAncestor = function(root, p, q) {
	if (root === null) {
		return null;
	}
	// console.log('root', root.val);

	if (root === p || root === q) {
		return root;
	}

	let left = lowestCommonAncestor(root.left, p, q);
	let right = lowestCommonAncestor(root.right, p, q);

	// if (left) console.log('root.left', left.val);
	// else console.log('right', null);
	// if (right) console.log('root.right', right.val);
	// else console.log('right', null);

	if (left && right) {
		return root;
	}
	if (left == null && right != null) {
		return right;
	}
	if (right == null && left != null) {
		return left;
	}
};

// lowestCommonAncestor(arrayToTree([ 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 ]));
