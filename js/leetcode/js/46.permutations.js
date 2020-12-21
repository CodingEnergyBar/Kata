/*
 * @lc app=leetcode id=46 lang=javascript
 *
 * [46] Permutations
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// 也可以用个数组 记录 used
var permute = function (nums) {
    function dfs(nums, path, res) {
        if (path.length === nums.length) {
            // console.log("path", path)
            Array.of(...path)
            res.push(Array.of(...path))
            return;
        }
        for (let i = 0; i < nums.length; i++) {
            if (nums[i] !== null) {
                const store = nums[i];
                path.push(nums[i]);
                nums[i] = null;
                dfs(nums, path, res)
                nums[i] = store;
                path.pop()
            }
        }

    }
    const res = [];
    dfs(nums, [], res)
    return res;

};
// @lc code=end

