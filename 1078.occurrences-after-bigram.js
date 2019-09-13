/*
 * @lc app=leetcode id=1078 lang=javascript
 *
 * [1078] Occurrences After Bigram
 */
/**
 * @param {string} text
 * @param {string} first
 * @param {string} second
 * @return {string[]}
 */
var findOcurrences = function(text, first, second) {
	let third = 0;
	let res = [];
	let words = text.split(' ');
	// for (let i in words) {
	// 	if (words[i] === first && words[i + 1] === second) {
	// 		if (words[i + 2] != undefined) {
	// 			res.push(words[i + 1]);
	// 		}
	// 	}
	// }
	//???
	for (let i = 0; i < words.length; i++) {
		if (words[i] === first && words[i + 1] === second) {
			if (words[i + 2] != undefined) {
				res.push(words[i + 2]);
			}
		}
	}
	return res;
};
findOcurrences('alice is a good girl she is a good student', 'a', 'good');
