/*
 * @lc app=leetcode id=20 lang=javascript
 *
 * [20] Valid Parentheses
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
	let stack = [];
	const map = { "}": "{", "]": "[", ")": "(" };
	for (const c of s) {
		if ("([{".includes(c)) {
			stack.push(c);
		}
		else {
			if (stack[stack.length - 1] === map[c]) {
				stack.pop();
			}
			else return false;
		}
	}
	if (stack.length !== 0) {
		return false;
	}
	return true;
};

const isValidParentheses = function (s) {
	let map = new Map();
	map.set("(", ")");
	map.set("[", "]");
	map.set("{", "}");

	let stack = [];
	for (let i = 0; i < s.length; i++) {
		// console.log('stack', stack);
		if (map.has(s[i])) {
			stack.push(map.get(s[i]));
		}
		else {
			// here need to check whether the stack empty
			if (stack.length != 0 && stack[stack.length - 1] === s[i]) {
				// stack top is stack.length-1
				stack.pop();
				continue;
			}
			else {
				return false;
			}
		}
		//
	}
	return stack.length === 0;
};

// @lc code=end
