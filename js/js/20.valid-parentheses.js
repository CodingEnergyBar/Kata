/*
 * @lc app=leetcode.cn id=20 lang=javascript
 *
 * [20] 有效的括号
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
    if (s.length % 2 === 1)
        return false;
    const stack = [];
    let i=0
    while (i < s.length) {
        switch (s[i]) {
            case '(':
            case '{':
            case '[':
                stack.push(s[i])
                break;
            default:
                if (validate(s[i], stack))
                    stack.pop()
                else
                    return false;
        }
        i++;
    }
    return stack.length === 0;
};
var isValid2 = function (s) {
    // 剪枝
    if (s.length % 2 === 1)
        return false;
    const stack = [];
    let i=0
    while (i < s.length) {
        // 用 in 会快很多
        if (s[i] in pair) {
            stack.push(s[i]);
        } else {
            if (pair[stack[stack.length - 1]] === s[i])
                stack.pop();
            else
                return false;
        }
        i++;
    }
    return stack.length === 0;
};
function validate(ch, stack) {
     return pair[stack[stack.length - 1]] === ch
}
// @lc code=end

