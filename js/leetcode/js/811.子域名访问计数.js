/*
 * @lc app=leetcode.cn id=811 lang=javascript
 *
 * [811] 子域名访问计数
 */

// @lc code=start
/**
 * @param {string[]} cpdomains
 * @return {string[]}
 */
var subdomainVisits = function (cpdomains) {
    const res = new Map();
    for (const info of cpdomains) {
        let [num, domain] = info.split(' ')
        num = Number.parseInt(num)

        let arr = domain.split('.')
        for (let i = 0; i < arr.length; i++) {
            arr[i] = arr.slice(i, arr.length).join('.')
        }
        for (const c of arr) {
            if (!res.has(c)) {
                res.set(c, 0)
            }
            res.set(c, res.get(c) + num)
        }
    }
    let resArr = []

    for (const [domain, cnt] of res.entries()) {
        resArr.push("" + cnt + " " + domain)
    }
    return resArr

};
// @lc code=end

