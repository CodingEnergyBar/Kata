/*
 * @lc app=leetcode id=167 lang=javascript
 *
 * [167] Two Sum II - Input array is sorted
 */
/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
	//不是追击类的，相遇类的
	var i = 0,
		j = numbers.length - 1;
	while (i < j) {
		if (target == numbers[i] + numbers[j]) return [ i + 1, j + 1 ];
		else if (target > numbers[i] + numbers[j]) i++;
		else j--;
	}
	return [];
};
