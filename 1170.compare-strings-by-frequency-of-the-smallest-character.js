/*
 * @lc app=leetcode id=1170 lang=javascript
 *
 * [1170] Compare Strings by Frequency of the Smallest Character
 *
 * https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/description/
 *
 * algorithms
 * Easy (60.17%)
 * Likes:    87
 * Dislikes: 228
 * Total Accepted:    18.4K
 * Total Submissions: 31.5K
 * Testcase Example:  '["cbd"]\n["zaaaz"]'
 *
 * Let's define a function f(s) over a non-empty string s, which calculates the
 * frequency of the smallest character in s. For example, if s = "dcce" then
 * f(s) = 2 because the smallest character is "c" and its frequency is 2.
 * 
 * Now, given string arrays queries and words, return an integer array answer,
 * where each answer[i] is the number of words such that f(queries[i]) < f(W),
 * where W is a word in words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so
 * f("cbd") < f("zaaaz").
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second
 * query both f("aaa") and f("aaaa") are both > f("cc").
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] are English lowercase letters.
 * 
 * 
 */

// @lc code=start
/**
 * @param {string[]} queries
 * @param {string[]} words
 * @return {number[]}
 */
var numSmallerByFrequency = function (queries, words) {
	// const fWords = new Array(words.length);
	// for(let i=0; i<words.length;i++){
	//     fWords[i] = f[words[i]];
	// }
	// fWords.sort((a, b)=>a-b);

	const fWords = words.map(f).sort((a, b) => a - b);
	const res = [];
	console.log("arr", fWords);
	for (const query of queries) {
		const index = upperBoundBST(fWords, f(query));
		console.log("index", index);
		res.push(fWords.length - index - 1 + 1);
	}
	return res;
};

function upperBoundBST (arr, value) {
	// <= value
	// console.log("value", value);
	let start = 0,
		end = arr.length - 1;
	while (start + 1 < end) {
		let mid = Math.floor((start + end) / 2);
		if (arr[mid] > value) {
			end = mid;
		}
		else {
			// query[i] < f(W)
			// 3
			// 1 2 3 3 3 4 4 5 => 4
			// find the first bigger than the target
			// find the [)
			start = mid;
		}
	}
	// find the first element greater than...
	if (value < arr[start]) return start;
	// bigger than...
	if (value < arr[end]) return end;
	return arr.length;
}

// return an integer of the smallest character frequency
function f (word) {
	// str.charCodeAt(0);
	// lower case 65 -
	const arr = new Array(256).fill(0);
	let smallest = 256;
	for (let i = 0; i < word.length; i++) {
		let w = word.charCodeAt(i);
		if (smallest > w) smallest = w;
		arr[w]++;
	}
	return arr[smallest];
}
// @lc code=end
