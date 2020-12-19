/*
 * @lc app=leetcode.cn id=605 lang=javascript
 *
 * [605] 种花问题
 */

// @lc code=start
/**
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
// 能中就中的想法不会造成缺失
var canPlaceFlowers = function (flowerbed, n) {

    for (let i = 0; i < flowerbed.length; i++) {
        if (i === 1) continue;
        if (flowerbed[])

    }
    // robber
    // const dp = Array(flowerbed.length + 1).forEach(
    //     arr => Array.fill(arr, [0, 0])
    // )
    // dp[0][0] = 0;
    // dp[0][1] = 0;
    // for (let i = 1; i <= flowerbed.length; i++) {
    //     if (flowerbed[i - 1] === 1) {
    //         dp[0][0] = null;
    //         dp[0][1] = 
    //     }
    // }


    // let pre = -1;
    // let max = 0;
    // for (let i = 0; i < flowerbed.length; i++) {
    //     if (flowerbed[i] === 1) {
    //         let space = i - pre - 1;
    //         if (pre === -1 && flowerbed[0] === 0) space++;
    //         if (space > 0) max += Math.floor((space - 1) / 2)
    //         pre = i;
    //     }
    // }
    // if (flowerbed[flowerbed.length - 1] !== 1) {
    //     const space = flowerbed.length - pre - 1;
    //     if (space > 0) max += Math.floor((space - 1) / 2)
    // }
    // return max >= n;


};
// canPlaceFlowers([1, 0, 0, 0, 1], 1)
canPlaceFlowers([0, 0, 1, 0, 1], 1)
// @lc code=end

