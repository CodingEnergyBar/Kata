/*
 * @lc app=leetcode.cn id=937 lang=javascript
 *
 * [937] 重新排列日志文件
 */

// @lc code=start
/**
 * @param {string[]} logs
 * @return {string[]}
 */
// 除非加index
var reorderLogFiles = function (logs) {
    const isLetter = (c) => (/[a-zA-Z]/.test(c))
    const isNumber = (c) => (/\d/.test(c))
    logs = logs.map((el, i) => ([el, i]))
    logs.sort((aArr, bArr) => {
        const [a, aIndex] = aArr;
        const [b, bIndex] = bArr;
        const titleA = a.slice(0, a.indexOf(' '))
        const titleB = b.slice(0, b.indexOf(' '))
        const contentA = a.slice((a.indexOf(' ') + 1), a.length)
        const contentB = b.slice((b.indexOf(' ') + 1), b.length)
        const aIsAlphbet = isLetter(contentA[0])
        const bIsAlphbet = isLetter(contentB[0])
        if (aIsAlphbet && bIsAlphbet) {
            const compare = contentA.localeCompare(contentB)
            if (compare !== 0)
                return compare
            else
                return titleA.localeCompare(titleB)
        } else if (!aIsAlphbet && bIsAlphbet) {
            return 1
        } else if (aIsAlphbet && !bIsAlphbet) {
            return -1;
        } else {
            return aIndex - bIndex;
        }
    })// 不应该sort 没有办法按着时间顺序来
    return logs.map(el => el[0])

};
// @lc code=end

