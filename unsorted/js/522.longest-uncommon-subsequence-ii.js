/*
 * @lc app=leetcode id=522 lang=javascript
 *
 * [522] Longest Uncommon Subsequence II
 */
/**
 * @param {string[]} strs
 * @return {number}
 */
var findLUSlength = function(strs) {
	if (strs === null) return -1;
	strs.sort((a, b) => b.length - a.length);
	// get closure

	for (let i = 0; i < strs.length; i++) {
		let flag = true;
		for (let str of strs) {
			if (str.includes(strs[i])) {
				flag = false;
			}
		}
		if (flag) return strs[i].length;
	}
	return -1;
};

let b = findLUSlength([ 'aba', 'cdc', 'eae' ]);
console.log(b);
// var isSubequence(a, b){
//     return a.includes(b);

// }
