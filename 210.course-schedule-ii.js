/*
 * @lc app=leetcode id=210 lang=javascript
 *
 * [210] Course Schedule II
 */

// @lc code=start
/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {number[]}
 */
var findOrder = function(numCourses, prerequisites) {
	const graph = new Map();
	const courseToindegree = new Map();
	//intialize graph course => []
	//initialize indegree  course => 0
	for (let i = 0; i < numCourses; i++) {
		courseToindegree.set(i, 0);
		graph.set(i, []);
	}
	for (const i of prerequisites) {
		const course = i[0];
		const pre = i[1];

		// do not push directly
		// const nexts = graph.get(pre);
		// nexts.push(course);

		// for array, you donot need to set....
		graph.get(pre).push(course);
		// graph.set(pre, nexts);
		//indegree
		courseToindegree.set(course, courseToindegree.get(course) + 1);
	}
	console.log('graph ', graph);
	console.log('courseToindgree ', courseToindegree);

	let inorder = [];
	let queue = [];
	// get a order from the array
	for (let [ course, indegree ] of courseToindegree.entries()) {
		if (indegree === 0) {
			queue.push(course);
		}
	}

	while (queue.length) {
		const course = queue.shift();
		inorder.push(course);
		// the course 1's indegree could be reduced
		// console.log('graph.get(course)', graph.get(course));
		for (const next of graph.get(course)) {
			const indegree = courseToindegree.get(next) - 1;
			courseToindegree.set(next, indegree);
			if (indegree === 0) {
				queue.push(next);
			}
		}
	}
	// console.log(inorder);
	if (inorder.length === numCourses) {
		return inorder;
	}
	else {
		return [];
	}
};
// @lc code=end
