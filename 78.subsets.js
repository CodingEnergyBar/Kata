/*
 * @lc app=leetcode id=78 lang=javascript
 *
 * [78] Subsets
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    const res = [];
    const subset = [];
    function helper(res, subset, pool){

        res.push([...subset]);
        for(let i=0; i<pool.length;i++){
            subset.push(pool[i]);
            helper(res, subset, pool.slice(i+1, pool.length));
            subset.pop();
        }
    }
        console.log(res);
    helper(res, subset, nums);
    return res;
    
};
subsets([1,2,3]);
// @lc code=end

