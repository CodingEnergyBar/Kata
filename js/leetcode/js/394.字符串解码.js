/*
 * @lc app=leetcode.cn id=394 lang=javascript
 *
 * [394] 字符串解码
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var decodeString = function (s) {
    // console.log(s.match(/\d\[\w+\]/g))
    while (s.match(/\d+\[\w+\]/g)) {
        s = flatOneLayer(s)
    }
    return s;
    function flatOneLayer(s) {
        return s.replace(/\d+\[\w+\]/g, (e) => {
            const i1 = e.indexOf('[')
            // const i2 = e.indexOf(']')
            const cnt = Number.parseInt(e.slice(0, i1))

            const content = e.slice(i1 + 1, -1);

            return [...Array(cnt)].reduce(e => (e + content), "")
            // console.log("res", res)
            // return res
        })
    }
    // const arr2 = [...s.matchAll(/\d[\w+]/)]
    // console.log(arr)
    // console.log(arr2)

};
let s = "100[leetcode]"
console.log(decodeString(s))
// @lc code=end

