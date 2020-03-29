/*
 * @lc app=leetcode id=107 lang=javascript
 *
 * [107] Binary Tree Level Order Traversal II
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
		if (arr[i] !== null) {
			let left = new TreeNode(arr[i]);
			parent.left = left;
			queue.push(left);
		}

		// right
		if (i + 1 < arr.length) {
			i++;
			if (arr[i] !== null) {
				let right = new TreeNode(arr[i]);
				parent.right = right;
				queue.push(right);
			}
		}
	}
	return root;
};

const testArray = [ 3, 9, 20, null, null, 15, 7 ];
let root = arrayToTree(testArray);

var levelOrderBottom = function(root) {
	// res
	// queue[root]
	// while !queue
	// level = queue.length;

	// for i in level:
	//     node = queue.shift()
	//     res = res.push(node.val)
	//     queue.push(node)

	// return res
	if (root === null) return [];

	let res = [];
	let queue = [ root ];
	while (queue.length !== 0) {
		let levelNum = queue.length;
		let level = [];
		for (let i = 0; i < levelNum; i++) {
			let node = queue.shift();
			level.push(node.val);
			if (node.left) queue.push(node.left);
			if (node.right) queue.push(node.right);
		}
		res.unshift(level);
	}
	return res;
};

levelOrderBottom(root);
