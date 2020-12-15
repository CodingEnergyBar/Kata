/*
 * @lc app=leetcode.cn id=349 lang=javascript
 *
 * [349] 两个数组的交集
 */

const { resolveSoa } = require('dns');

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
// var intersection = function (nums1, nums2) {
//     // return [...new Set(nums2)].filter(el => new Set(nums1).has(el));
//     // includes O(n^2)
//     // !!! 数组原生方法就可以判断
//     return [...new Set(nums2)].filter(el => nums1.includes(el));

// };

// 字典做一下
var intersection = function (nums1, nums2) {
    const res = [];
    // ma
    const map = new Map()
    for (const n1 of nums1) {
        map.set(n1, true)
    }
    // in 是 key
    // console.log([...map.keys()].includes(2))
    // has  

    for (const n2 of nums2) {
        if (map.has(n2)) {
        // if([...map.keys()].includes(n2)){
            res.push(n2)
            map.delete(n2)
        }
    }
    // console.log(map)
    return res;
};
// @lc code=end

