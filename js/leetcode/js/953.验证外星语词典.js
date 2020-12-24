/*
 * @lc app=leetcode.cn id=953 lang=javascript
 *
 * [953] 验证外星语词典
 */

// @lc code=start
/**
 * @param {string[]} words
 * @param {string} order
 * @return {boolean}
 */
var isAlienSorted = function (words, order) {
    if (words.length <= 1)
        return true;
    const dic = new Map();
    for (let i = 0; i < order.length; i++) {
        dic.set(order[i], i);
    }

    for (let i = 1; i < words.length; i++) {
        if (!isValid(words[i - 1], words[i]))
            return false;
    }
    return true;

    function isValid(a, b) {
        let i = 0, j = 0;
        for (; i < a.length && j < b.length; i++, j++) {
            if (dic.get(a[i]) < dic.get(b[j]))
                return true;
            else if (dic.get(a[i]) > dic.get(b[j]))
                return false;
        }
        // // hello he
        // // hello hellow
        // if (a.length <= b.length)
        //     return true;
        // else
        //     return false;
        return a.length <= b.length

    }

};

isAlienSorted(
    ["word", "world", "row"],
    "worldabcefghijkmnpqstuvxyz"
)
// @lc code=end

