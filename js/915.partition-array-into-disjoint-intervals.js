/*
 * @lc app=leetcode id=915 lang=javascript
 *
 * [915] Partition Array into Disjoint Intervals
 */
/**
 * @param {number[]} A
 * @return {number}
 */
var partitionDisjoint = function(A) {
	let left = 0,
		right = A.length - 1;
	let leftMax = A[left],
		rightMin = A[right];

	while (left <= right && A[right] >= leftMax) {
		right = -1;
		rightMin = Math.min(A[right], rightMin);
	}
	// if(left <= right && A[left] >= )

	return A.length - right;
};
  