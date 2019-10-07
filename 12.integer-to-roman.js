/*
 * @lc app=leetcode id=12 lang=javascript
 *
 * [12] Integer to Roman
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string}
 */
var intToRoman = function(n) {
	const nums = [ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 ];
	const symbols = [ 'M', 'CM', 'D', 'CD', 'C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I' ];
	// for javascript need to be very careful about divide /
	let res = '';
	for (let i = 0; i < nums.length; i++) {
		if (Math.floor(n / nums[i]) >= 1) {
			let cnt = Math.floor(n / nums[i]);
			n = n - nums[i] * cnt;

			while (cnt) {
				res += symbols[i];
				cnt--;
			}

			console.log('res', res);
		}
	}

	return res;
};
// @lc code=end
