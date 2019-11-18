/*
 * @lc app=leetcode id=503 lang=javascript
 *
 * [503] Next Greater Element II
 *
 * https://leetcode.com/problems/next-greater-element-ii/description/
 *
 * algorithms
 * Medium (52.28%)
 * Likes:    881
 * Dislikes: 52
 * Total Accepted:    64.1K
 * Total Submissions: 121.5K
 * Testcase Example:  '[1,2,1]'
 *
 * 
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element. The
 * Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2; The number 2 can't find
 * next greater number; The second 1's next greater number needs to search
 * circularly, which is also 2.
 * 
 * 
 * 
 * Note:
 * The length of given array won't exceed 10000.
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
/**
 * @param nums: an array
 * @return: the Next Greater Number for every element
 */
const nextGreaterElements = function (nums) {
	Array.prototype.peek = function () {
		return this[this.length - 1];
	};
	const stack = new Array();
	const res = new Array(nums.length).fill(-1);

	for (let i = nums.length * 2 - 1; i >= 0; i--) {
		while (stack.length && nums[stack.peek() % nums.length] <= nums[i % nums.length]) {
			stack.pop();
			// console.log("stack", stack);
		}
		if (stack.length) res[i % nums.length] = nums[stack.peek()];
		stack.push(i % nums.length);
	}
	return res;
};

// @lc code=end
