/*
 * @lc app=leetcode id=47 lang=javascript
 *
 * [47] Permutations II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function (nums) {
    nums.sort((a, b) => (a - b))

    const used = Array(nums.length).fill(false);
    const len = nums.length;
    function dfs(path, used, res) {
        if (path.length === len)
            res.push(Array.from(path))
        for (let i = 0; i < nums.length; i++) {
            // if (i !== 0 && nums[i] === nums[i - 1])
            //     continue;
            if (!used[i]) {
                used[i] = true;
                path.push(nums[i])
                dfs(path, used, res);
                used[i] = false;
                path.pop()
            }
            if (i !== 0 && nums[i] === nums[i - 1] &&)
                i++;
        }
    }
    const res = []
    dfs([], used, res)
    return res;
};

const nums = [1, 1, 2]
console.log(permuteUnique(nums))
// @lc code=end

