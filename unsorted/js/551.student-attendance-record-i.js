/*
 * @lc app=leetcode id=551 lang=javascript
 *
 * [551] Student Attendance Record I
 *
 * https://leetcode.com/problems/student-attendance-record-i/description/
 *
 * algorithms
 * Easy (45.76%)
 * Likes:    189
 * Dislikes: 687
 * Total Accepted:    64.5K
 * Total Submissions: 140K
 * Testcase Example:  '"PPALLP"'
 *
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters:
 * 
 * 
 * 
 * 'A' : Absent. 
 * 'L' : Late.
 * ⁠'P' : Present. 
 * 
 * 
 * 
 * 
 * A student could be rewarded if his attendance record doesn't contain more
 * than one 'A' (absent) or more than two continuous 'L' (late).    
 * 
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * 
 * Example 1:
 * 
 * Input: "PPALLP"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "PPALLL"
 * Output: False
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
/**
 * @param {string} s
 * @return {boolean}
 */

//  doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

var checkRecord = function (s) {
	let Acnt = 0,
		Lcnt = 0,
		Pcnt = 0;
	let flagA = false,
		flagL = false;
	let i = 0;
	while (i < s.length) {
		// here is wrong
		while (i < s.length && s[i] === "L") {
			Lcnt++;
			// After adding i, you should validate the 'A'
			i++;
			if (Lcnt > 2) {
				return false;
			}
		}
		if (s[i] === "A") {
			Acnt++;
			if (Acnt > 1) {
				return false;
			}
		}
		Lcnt = 0;
		i++;
	}
	return true;
};
// @lc code=end
