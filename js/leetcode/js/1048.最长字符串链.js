/*
 * @lc app=leetcode.cn id=1048 lang=javascript
 *
 * [1048] 最长字符串链
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {number}
 */
var longestStrChain = function (words) {
    if (!words.length)
        return 0;
    let max = 1;
    let maxEndWithCur = Array(words.length).fill(1)
    words.sort((a, b) => a.length - b.length)
    for (let i = 1; i < words.length; i++) {
        for (let j = 0; j < i; j++) {
            if (isPrefix(words[j], words[i])) {
                maxEndWithCur[i] = Math.max(maxEndWithCur[i], maxEndWithCur[j] + 1);
                max = Math.max(maxEndWithCur[i], max);
            }
        }
    }
    // console.log(maxEndWithCur)
    return max;
    function isPrefix(s1, s2) {
        if (s1.length + 1 !== s2.length)
            return false;
        let cnt = 1;
        for (let i = 0, j = 0; i < s2.length; i++, j++) {
            if (s2[i] !== s1[j]) {
                if (cnt === 0)
                    return false;
                cnt--;
                j--;
            }
        }
        return true;
    }
};

// console.log(longestStrChain(["xbc", "pcxbcf", "xb", "cxbc", "pcxbc"]))
// @lc code=end

