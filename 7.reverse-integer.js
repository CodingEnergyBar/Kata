/*
 * @lc app=leetcode id=7 lang=javascript
 *
 * [7] Reverse Integer
 */
/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
	let res = 0;
	let isNagative = false;
	if (x < 0) {
		isNagative = true;
		x = -x;
	}
	while (x != 0) {
		res = res * 10 + x % 10;
		// add floor
		x = Math.trunc(x / 10);
	}
	return isNagative ? -res : res;
};
