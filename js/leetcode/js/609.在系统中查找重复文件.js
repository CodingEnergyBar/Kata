/*
 * @lc app=leetcode.cn id=609 lang=javascript
 *
 * [609] 在系统中查找重复文件
 */

// @lc code=start
/**
 * @param {string[]} paths
 * @return {string[][]}
 */
var findDuplicate = function (paths) {
    const map = new Map()
    for (const info of paths) {
        const [commen, ...subPath] = info.split(' ')
        for (const s of subPath) {
            const rootPath = commen + '/' + s.slice(0, s.indexOf('('))
            const content = s.slice(s.indexOf('(') + 1, -1)
            if (!map.has(content))
                map.set(content, [])
            map.get(content).push(rootPath)
        }
    }
    return Array.from(map.values()).filter(arr => arr.length > 1)
};
const input = ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
console.log(findDuplicate(input))
// @lc code=end

