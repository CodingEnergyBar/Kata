/*
 * @lc app=leetcode id=1007 lang=javascript
 *
 * [1007] Minimum Domino Rotations For Equal Row
 *
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description/
 *
 * algorithms
 * Medium (51.31%)
 * Likes:    309
 * Dislikes: 109
 * Total Accepted:    38K
 * Total Submissions: 74.2K
 * Testcase Example:  '[2,1,2,4,2,2]\n[5,2,6,2,3,2]'
 *
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of
 * the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on
 * each half of the tile.)
 * 
 * We may rotate the i-th domino, so that A[i] and B[i] swap values.
 * 
 * Return the minimum number of rotations so that all the values in A are the
 * same, or all the values in B are the same.
 * 
 * If it cannot be done, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation: 
 * The first figure represents the dominoes as given by A and B: before we do
 * any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the
 * top row equal to 2, as indicated by the second figure.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 * Explanation: 
 * In this case, it is not possible to rotate the dominoes to make one row of
 * values equal.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number}
 */
var minDominoRotations = function (A, B) {
	if (A.length === 0) return -1;
	let swapA = 0,
		swapB = 0;
	let i = 0;
	for (; i < A.length; i++) {
		if (A[i] === A[0] || B[i] === A[0]) {
			if (A[i] !== A[0]) swapA++;
			if (B[i] !== A[0]) swapB++;
		}
		else {
			break;
		}
	}
	if (i === A.length) return Math.min(swapA, swapB);

	swapA = 0;
	swapB = 0;
	i = 0;
	for (; i < A.length; i++) {
		if (A[i] === B[0] || B[i] === B[0]) {
			if (A[i] !== B[0]) swapA++;
			if (B[i] !== B[0]) swapB++;
		}
		else {
			break;
		}
	}
	if (i === A.length) return Math.min(swapA, swapB);
	return -1;
};
// @lc code=end
