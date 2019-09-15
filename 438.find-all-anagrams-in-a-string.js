/*
 * @lc app=leetcode id=438 lang=javascript
 *
 * [438] Find All Anagrams in a String
 */
/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function(s, p) {
	function mappingSuccessed(s1, s2) {
		// if (hash(s1) === hash(s2)) return true;??
		// if (hash(s1) === hash(s2)) return true;
		if Object.toJSON(hash(s1) == Object.toJSON(hash(s2)) return true;
		else return false;
	}
	let hash = (s) => {
		let res = {};
		for (let i = 0; i < s.length; i++) {
			let c = s.charAt(i);
			if (res[c] === undefined) res[s.charAt(i)] = 1;
			else res[s[i]]++;
		}
		return res;
	};
	let res = [];
	for (let i = 0; i < s.length - p.length + 1; i++) {
		let s1 = s.slice(i, i + p.length);
		if (mappingSuccessed(s1, p)) res.push(i);
	}
	return res;
};

let s = 'cbaebabacd',
	p = 'abc';

findAnagrams(s, p);
