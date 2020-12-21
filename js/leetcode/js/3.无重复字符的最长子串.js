/*
 * @lc app=leetcode.cn id=3 lang=javascript
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
// 区别字符串 序列 和 子串
var lengthOfLongestSubstring = function (s) {
    const set = new Set();
    
    let maxLen = 0;
    let l = 0, r = 0; // [i, j]
    // 
    // while(r < s.length){
    //     if (!set.has(s[r])) {
    //         // maxLen = maxLen > len ? maxLen : len;
    //         maxLen = Math.max(maxLen, r - l + 1);
    //         set.add(s[r]);
    //         r++;
    //     } else {
    //         while (s[l] !== s[r]) {
    //             set.delete(s[l]);
    //             len--;
    //             l++;
    //         }
    //     }

    // }
    // 用map 记录就不用搞了, 不用一个一个往外弄

    // "abbcdea"
    // r 已经到a, 但是a还在l里 map不会被删除  --> 被往回拨了 不行
    // 更新的条件
    const map = new Map();
    for (let r = 0; r < s.length; r++){
        //  --> 被往回拨了 不能往回拨
        if (map.has(s[r]) && map.get(s[r]) >= l) {
            l = map.get(s[r]) + 1;
            // 其实要删除 l到new l中所有的字母
        }
        // 刚上来就有一个 [l, r] 所以要判断
        console.log(`l:${l},  r:${r}, window: ${s.slice(l, r+1)}`)
        maxLen = Math.max(maxLen, r - l + 1);
        map.set(s[r], r);
    }

    return maxLen;
    /*
        l:0,  r:0, window: a
        l:0,  r:1, window: ab
        l:0,  r:2, window: abc
        l:1,  r:3, window: bca
        l:2,  r:4, window: cab
        l:3,  r:5, window: abc
        l:5,  r:6, window: cb
        l:7,  r:7, window: b
    */
    
    /**
        l:0,  r:0, window: a
        l:0,  r:1, window: ab
        l:2,  r:2, window: b
        l:2,  r:3, window: bc
        l:2,  r:4, window: bcd
        l:2,  r:5, window: bcde
        l:1,  r:6, window: bbcdea
     */
    
};
// @lc code=end

