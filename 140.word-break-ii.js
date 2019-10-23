/*
 * @lc app=leetcode id=140 lang=javascript
 *
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (28.37%)
 * Likes:    1231
 * Dislikes: 277
 * Total Accepted:    180K
 * Total Submissions: 630.7K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * 
 */

// @lc code=start
/**
 * @param s: A string
 * @param wordDict: A array of words.
 * @return: All possible sentences.
 */
const wordBreak = function (s, wordDict) {
	// write your code here
	const memo = new Map(); // string to decoding lint=> [li nt] lin t

	// memo.set("", [""]);

	return dfs(s, wordDict, memo);
};

function dfs (s, wordDict, memo) {
	if (memo.has(s)) {
		return memo.get(s);
	}
	let res = [];

	if (s.length === 0) {
		return res;
	}

	if (wordDict.includes(s)) {
		res.push(s);
	}

	for (let i = 1; i < s.length; i++) {
		const sub = s.substring(0, i);
		const remain = s.substring(i);

		if (!wordDict.includes(sub)) {
			continue;
		}

		let methods = dfs(remain, wordDict, memo);

		for (let m of methods) {
			res.push(sub + " " + m);
		}
	}

	memo.set(s, res);
	console.log("memo", memo);

	return res;
}

// @lc code=end
