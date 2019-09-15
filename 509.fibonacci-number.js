/*
 * @lc app=leetcode id=509 lang=javascript
 *
 * [509] Fibonacci Number
 */

/**
 * @param {number} n
 * @return {number}
 */
var fib = function(n) {
	if (n === 0) return 0;
	if (n === 1) return 1;
	let f = [ 0, 1 ];
	let i = 2;
	while (i <= n) {
		f.push(f[i - 1] + f[i - 2]);
		i++;
	}
	return f[n];
};
fib(2);
