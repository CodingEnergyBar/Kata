/*
 * @lc app=leetcode id=207 lang=javascript
 *
 * [207] Course Schedule
 */
/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function(numCourses, prerequisites) {
	// the thing is numCourses and prerequisites could be not that related
	// graph and indegree is better to have the consistent
	let graph = new Map();

	let courseToDegree = new Array(numCourses);
	courseToDegree.fill(0);

	for (let pair of prerequisites) {
		let course = pair[0];
		let pre = pair[1];
		// this is not based on graph
		courseToDegree[course]++;

		if (graph.has(pre)) {
			graph.set(pre, graph.get(pre).concat(course));
		}
		else {
			graph.set(pre, [ course ]);
		}
	}

	// bfs
	let order = [];
	let queue = [];
	// for array also entries
	for (let [ course, degree ] of courseToDegree.entries()) {
		if (degree == 0) {
			queue.push(course);
		}
	}

	// console.log('graph', graph);
	while (queue.length) {
		let course = queue.shift();
		order.push(course);

		if (graph.has(course)) {
			for (let next of graph.get(course)) {
				courseToDegree[next]--;
				if (courseToDegree[next] === 0) {
					queue.push(next);
				}
			}
		}
	}

	// compare the indegree array instead of comparing the length
	for (let i = 0; i < courseToDegree.length; i++) {
		if (courseToDegree[i] !== 0) {
			return false;
		}
	}
	return true;

	// console.log(courseToDegree);

	// get the degree of course
};
