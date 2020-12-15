/*
 * @lc app=leetcode.cn id=65 lang=javascript
 *
 * [65] 有效数字
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var isNumber = function (s) {
    // 状态图比较复杂
    /**
     * blank
        shuzi 0 
        数字 0-9
        指数 - "e"
        正/负号 - "+"/"-"
        小数点 - "."
     */

    // 0: blank
    // 1: 

    // 这个图要怎么弄
    // const node = {
    //     0: '',
    //     1: '+-',
    //     2: '.',
    //     6: '[1-9]', // [1-9]
    //     4: 'eE',
    //     5: '[0-9]',
    //     7: '+-',
    //     8: '',
    //     3: '[1-9]' //

    // }
    // 图的表示
    // graph 有个边 hashmap
    // 时间复杂度 n 空间复杂度 就是图 1
    const graph = {
        0: { 'blank': 0, 'sign': 1, '.': 2, 'digit': 6 },
        1: { 'digit': 6, '.': 2 },
        2: { 'digit': 3 },
        3: { 'digit': 3 },
        4: { 'digit': 5, 'sign': 7 },
        5: { 'digit': 5 },
        6: { 'digit': 6, '.': 3, 'e': 4 },
        7: { 'digit': 5 }
    }


    let state = 0;
    for (let c of s.trim()) {
        // 转换
        if (c >= '0' && c <= '9') {
            c = 'digit';
        } else if (c === ' ') {
            c = 'blank'
        } else if (c === '+' || c === '-') {
            c = 'sign'
        }
        state = graph[state][c];
        if (state === undefined)
            return false;
    }
    if (state === 3 || state === 5 || state === 6)
        return true;
    return false;
    // return '356'.includes(state)
};
// @lc code=end

