/*
 * @lc app=leetcode.cn id=1249 lang=javascript
 *
 * [1249] 移除无效的括号
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var minRemoveToMakeValid = function (s) {
    // 输入：s = "lee(t(c)o)de)" - permutatiion
    // 输出："lee(t(c)o)de"

    // 输入：s = "a)b(c)d" greedy 
    // 输出："ab(c)d"

    // s = "))(("
    // ""

    // (a(b(c)d)"
    // 输出："a(b(c)d)" // 从什么时候开始无效 0,  []

    cArr = s.split('')
    const stack = [] // ['(', i]
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (s[i] === '(') {
            stack.push(i) // pos
        } else if (s[i] === ')') {
            if (stack.length)
                stack.pop()
            //直接在这里去除这个就好了
            else
                cArr[i] = ''
        }
    }
    // const toRemove = stack.map(el => el[1]) // positions
    // console.log('toRemove', toRemove)
    // const cArr = s.split('')
    for (const i of stack) {
        cArr[i] = ''
    }
    // console.log('s', s)
    return cArr.join('')

};
// @lc code=end

