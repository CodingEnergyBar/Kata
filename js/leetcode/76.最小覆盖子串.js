/*
 * @lc app=leetcode.cn id=76 lang=javascript
 *
 * [76] 最小覆盖子串
 */

const { Z_NEED_DICT } = require('zlib');

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function (s, t) {
    // [0, 0]
    // 移动的策略比较重要
    // let minLen = Number.MAX_SAFE_INTEGER;
    let res = "", needLetterType = 0, r = 0, l = 0;
    const tMap = new Map();

    for (let i = 0; i < t.length; i++){
        const c = t[i];
        tMap.set(c, (tMap.has(c)? tMap.get(c) + 1: 1)); // 表示位置为0 , 需要的长度
    }

     needLetterType = tMap.size;
    // console.log('tMap', tMap)
    // 用一个常量的伸缩啦保持常数的一定
    // "ADOBEACODEBANC", t = "ABCA" --> A:2 B:1 C:1

    for (; r < s.length; r++){
        const cur = s[r];
        // console.log("window", s.substring(l, r+1))
        //&& tMap.get(cur) !== 0 不需要了
        if (tMap.has(cur)) {
            // const preNeedSize = tMap.get(cur);
            // const newNeedSize = preNeedSize - 1;
            // tMap.set(cur, newNeedSize);
            // if (newNeedSize === 0)
            //     needLetterType--;
            tMap.set(cur, tMap.get(cur) - 1);
            if (tMap.get(cur) === 0)
                needLetterType--;
            
            // console.log('needLetterType', needLetterType)
        }

        // 尝试着移动左指针
        while (needLetterType === 0) {
            const  newRes =  s.substring(l, r+1)
            if (!res || newRes.length < res.length) {
                console.log('tMap', tMap)
                res = newRes;
            }
            // minLen = Math.min(minLen, r - l + 1);
            const c2 = s[l];
            if (tMap.has(c2)) {
                if (tMap.get(c2) === 0)
                    needLetterType++;
                tMap.set(c2, tMap.get(c2) + 1);
            //     const preNeedSize = tMap.get(pre);
            //     if (preNeedSize === 0) {
            //         needLetterType++;
            //     }
            //    tMap.set(pre, preNeedSize + 1);
            }
            l++;
        }
    }
  return res;

};
// @lc code=end

