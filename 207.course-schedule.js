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
	function Node(val, neighbors = []) {
		this.val = val;
		this.neighbors = neighbors;
		this.toDegree = 0;
	}

	let courses = new Set();
	let courseNodes = new Set();

	for (let info of prerequisites) {
		let course = info[0];
		let prerequisite = info[1];

		if (!courses.has(course)) {
			let cNode = new Node(course);
			course.neighbors.push(prerequisite);
			cNode.toDegree++;
			courses.add(course);
		}
    }
    let queue = courseNodes[0];
    
    for (let c of courseNodes){
        while()
    }
};
