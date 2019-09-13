/*
 * @lc app=leetcode id=172 lang=javascript
 *
 * [172] Factorial Trailing Zeroes
 */

const factor2 = function(num) {
	let res2 = 0;
	while (num % 2 == 0 && num != 0) {
		res2++;
		num = num / 2;
	}
	return res2;
};

// factor is not like this, factor is from bottom up
// const factor5 = function(num) {
// 	let res5 = 0;
// 	while (num % 5 == 0 && num != 0) {
// 		res5++;
// 		num = num / 5;
// 	}
// 	return res5;
// };

const factor5 = (num) => {
	// let res5 = 0,
	// 	i = 1;
	// // for (let i = 1; i < num; i *= 5) {
	// // 	res5++;
	// // }
	// while (i < num) {
	// 	res5++;
	// 	i *= 5;
	// }

	let res5 = 0,
		i = 5;
	for (let i = 5; i <= num; i *= 5) {
		res5++;
	}
	// while (i <= num) {
	// 	res5++;
	// 	i *= 5;
	// }
	return res5;
};
/**
 * @param {number} n
 * @return {number}
 */
// Time limit exceed
// var trailingZeroes = function(n) {
// 	let res5 = 0,
// 		res2 = 0;
// 	while (n != 0) {
// 		res5 += factor5(n);
// 		res2 += factor2(n);
// 		n--;
// 	}
// 	return Math.min(res5, res2);
// };

var trailingZeroes = function(n) {
	let res5 = 0;

	// while (n > 0) {
	// 	if (n % 5 == 0) res5++;
	// 	n;
	// }

	// find the factor 5
	return factor5(n);
};

// trailingZeroes(10);
