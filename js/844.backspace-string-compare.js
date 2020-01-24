/*
 * @lc app=leetcode id=844 lang=javascript
 *
 * [844] Backspace String Compare
 *
 * https://leetcode.com/problems/backspace-string-compare/description/
 *
 * algorithms
 * Easy (46.66%)
 * Likes:    876
 * Dislikes: 54
 * Total Accepted:    84.9K
 * Total Submissions: 181.6K
 * Testcase Example:  '"ab#c"\n"ad#c"'
 *
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * 
 * 
 * Follow up:
 * 
 * 
 * Can you solve it in O(N) time and O(1) space?
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
/**
 * @param {string} S
 * @param {string} T
 * @return {boolean}
 */
/**
 * @param {string} S
 * @param {string} T
 * @return {boolean}
 */
var backspaceCompare = function (S, T) {
	let i = S.length - 1,
		j = T.length - 1;
	let countS = 0,
		countT = 0; // for the # machanism
	// here they have to be in the loop till the end, so using ||
	while (i >= 0 || j >= 0) {
		console.log(i, j);
		while (i >= 0 && (S[i] === "#" || countS > 0)) {
			if (S[i] === "#") {
				countS++;
			}
			else {
				countS--;
			}
			i--;
		}

		while (j >= 0 && (T[j] === "#" || countT > 0)) {
			if (T[j] === "#") {
				countT++;
			}
			else {
				countT--;
			}
			j--;
		}
		if (S[i] === T[j]) {
			i--;
			j--;
		}
		else {
			return false;
		}
	}
	if (i < 0 && j < 0) return true;
	return false;
};
// @lc code=end
