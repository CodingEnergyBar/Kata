/*
 * @lc app=leetcode id=297 lang=javascript
 *
 * [297] Serialize and Deserialize Binary Tree
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */

function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}
var serialize = function(root) {
	if (root == null) return '';

	let queue = [ root ];
	let res = [];
	res.push(root.val);
	while (queue.length !== 0) {
		let node = queue.shift();

		if (node.left) {
			queue.push(node.left);
			res.push(node.left.val);
		} else {
			res.push('null');
		}
		if (node.right) {
			queue.push(node.right);
			res.push(node.right.val);
		}
		if (!node.right) {
			res.push('null');
		}
	}
	let i = res.length - 1;
	while (i >= 0 && res[i] === 'null') {
		res.pop();
		i--;
	}
	return res.toString();
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
	if (data == '') return null;

	let arr = data.split(',');
	let root = new TreeNode(parseInt(arr[0]));
	let queue = [];
	queue.push(root);

	for (let i = 1; i < arr.length; i++) {
		let parent = queue.shift();

		// left
		if (arr[i] !== 'null') {
			let left = new TreeNode(parseInt(arr[i]));
			parent.left = left;
			queue.push(left);
		}

		// right
		if (i + 1 < arr.length) {
			i++;
			if (arr[i] !== 'null') {
				let right = new TreeNode(parseInt(arr[i]));
				parent.right = right;
				queue.push(right);
			}
		}
	}
	return root;
};
// console.log(serialize(deserialize('1,2,3,null,null,4,5')));
console.log(deserialize('3,2,4,1'));
console.log(serialize(deserialize('3,2,4,1')));
/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
