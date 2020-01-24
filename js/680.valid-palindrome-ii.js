/*
 * @lc app=leetcode id=680 lang=javascript
 *
 * [680] Valid Palindrome II
 */
/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function(s) {
	let count = 1; // allow one time false
	let start = 0,
		end = s.length - 1;

	let [ left, right ] = twoPointer(s, start, end);

	if (left >= right) return true;

	return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);

	function isPalindrome(s, start, end) {
		let [ left, right ] = twoPointer(s, start, end);
		return left >= right;
	}

	// return two values, the first time the two pointer char are different
	function twoPointer(s, start, end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) break;
			start++;
			end--;
		}
		return [ start, end ];
	}

	return true;
};
