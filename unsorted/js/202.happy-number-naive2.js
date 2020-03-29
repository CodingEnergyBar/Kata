/*
 * @lc app=leetcode id=202 lang=javascript
 *
 * [202] Happy Number
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
/**
 * @param n: An integer
 * @return: true if this is a happy number or false
 */
const isHappy = function(n) {
	// corner case
	if (n === 1) {
		return true;
	}

	const nums = new Set([ n ]);

	while (true) {
		const nextNumer = getNextNumer(n);

		console.log('nextNumer', nextNumer);

		if (nums.has(nextNumer)) {
			return false;
		}
		if (nextNumer === 1) {
			return true;
		}
		nums.add(nextNumer);
		n = nextNumer;
	}
};
function getNextNumer(n) {
	let res = 0;
	const digits = getDigits(n);

	console.log('digits', digits);

	for (const d of digits) {
		res += d * d;
	}
	return res;
}

function getDigits(n) {
	const digits = [];
	while (n) {
		digits.push(n % 10);
		n = Math.floor(n / 10);
	}
	return digits;
}

// @lc code=end
