/*
 * @lc app=leetcode id=18 lang=javascript
 *
 * [18] 4Sum
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function (nums, target) {
    if (nums.length < 4)
        return []
    //默认排序算法迷惑啊
    // [-1, -2, -2, -2, -4, -5, 0, 0, 1,]

    nums.sort((a, b) => (a - b));

    let res = new Set()

    // 重复的数怎么办??
    const getValues = (...args) => {
        let res = [];
        for (const i of args) {
            res.push(nums[i])
        }
        return res;
    }
    let arrRes = [];
    for (let i = 0; i < nums.length - 3; i++) {
        if (i !== 0 && nums[i] === nums[i - 1])
            continue;
        for (let j = i + 1; j < nums.length - 2; j++) {
            if (j !== i + 1 && nums[j] === nums[j - 1])
                continue;
            let left = target - nums[i] - nums[j];
            // two sum
            let m = j + 1, n = nums.length - 1
            // 这里也要去重
            while (m < n) {
                if (nums[m] + nums[n] > left) {
                    n--;
                } else if (nums[m] + nums[n] < left) {
                    m++;
                } else {
                    arrRes.push(getValues(i, j, m, n))
                    // res.add(getValues(i, j, m, n).join(','))
                    while (m < n && nums[m] === nums[m + 1]) m++;
                    while (m < n && nums[n] === nums[n - 1]) n--;
                    m++; n--;
                }
            }
        }
    }

    // res.forEach(s => {
    //     arrRes.push(s.split(',').map(v => Number.parseInt(v)))
    // })
    return arrRes;
};

// console.log(fourSum([1, 0, -1, 0, -2, 2], 0))
// console.log(fourSum([-1, 0, -5, -2, -2, -4, 0, 1, -2], -9))
// console.log(fourSum([0, 0, 0, 0], 0))
console.log(fourSum([-2, -1, -1, 1, 1, 2, 2], 0))
// @lc code=end

