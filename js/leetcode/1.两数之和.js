/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// var twoSum = function (nums, target) {
    // 要保持有序先
//     let i = 0, j = nums.length - 1;
//     while (i < j) {
//         if (nums[i] + nums[j] === target)
//             return [i, j];
//         else {
            
//         }
//     }
// };

// 字典
var twoSum = function (nums, target) {
    const map = new Map();
    let cur;
    // 时间复杂度 O(n) | 空间复杂度也是 O(n)
    for (let i = 0; i < nums.length; i++){
        cur = nums[i];
        if (map.has(target - cur)) {
            return [map.get(target - cur), i];
        } else {
            map.set(cur, i);
        }
    }
    return [-1, -1];
}
// @lc code=end

