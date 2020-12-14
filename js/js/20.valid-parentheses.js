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
const pair = {
    '(': ')',
    '{': '}',
    '[': ']'
}
var isValid = function (s) {
    const stack = [];
    let i=0
    while (i < s.length) {
        switch (s[i]) {
            case '(':
            case '{':
            case '[':
                stack.push(s[i])
                break;
            case ')':
            case '}':
            case ']':
                if (validate(s[i], stack))
                    stack.pop()
                else
                    return false;
            default:
                return false;
        }
    }
    return i === s.length;
};
function validate(ch, stack) {
     return pair[ch] === stack[stack.length-1]
}
// @lc code=end

