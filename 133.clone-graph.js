/*
 * @lc app=leetcode id=133 lang=javascript
 *
 * [133] Clone Graph
 */
/**
 * // Definition for a Node.
 * function Node(val,neighbors) {
 *    this.val = val;
 *    this.neighbors = neighbors;
 * };
 */
/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function(node) {
	if (node === null) return null;

	let visited = new Set();
	let dummy = new Node(0, []);

	let clone = new Node(node.val, []);
	node.clone = clone;

	dummy.neighbors.push(clone);

	let queue = [ node ];
	// let pre = dummy;

	while (queue.length !== 0) {
		// console.log('queue', queue);
		let cur = queue.shift();
		if (!visited.has(cur)) {
			for (let node of cur.neighbors) {
				if (node.clone === undefined) {
					let c = new Node(node.val, []);
					node.clone = c;
				}
				cur.clone.neighbors.push(node.clone);
				queue.push(node);
			}
			visited.add(cur);
		}
	}

	return dummy.neighbors[0];
};

// function cloneGraph(graph) {
//   var map = {};
//   return traverse(graph);

//   function traverse(node) {
//     if (!node) return node;
//     if (!map[node.label]) {
//       map[node.label] = new Node(node.label);
//       map[node.label].neighbors = node.neighbors.map(traverse);
//     }
//     return map[node.label];
//   }
// }
