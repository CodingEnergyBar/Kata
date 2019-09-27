/*
 * @lc app=leetcode id=125 lang=javascript
 *
 * [125] Valid Palindrome
 */
/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
	// let sArray = s.replace(',', '').replace(' ', '').toLowerCase().split('');
	// except for
	let sClean = s.toLowerCase().replace(/[^a-z0-9]/g, '');
	console.log(sClean);
	let l = 0,
		r = sClean.length - 1;

	// console.log(sClean.slice(mid));
	// let behind = sClean.slice(mid);
	// let front = sClean.slice(0, mid);
	// console.log(sClean.slice(0, mid));
	// console.log(behind.slice(1));

	while (l < r) {
		if (sClean.charAt(l) === sClean.charAt(r)) {
			l++;
			r--;
		}
		else return false;
	}
	return true;
};

isPalindrome('A man, a plan, 9a canal: Panama');
