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
var permute = function(nums) {
    const res = [];
    const list = [];
    // [], [], []
    helper(res, list, nums);
    function helper(res, list, pool){
        if(pool.length ===  0){
            res.push(list);
        }
        for(const num of pool){
            //there is already a new list coming
            // do not use filter : incase the same case happening here....

            helper(res, [...list, num], pool.filter(x=> num != x););
        }
    }
    // function helper(res, list, nums){
    //     if(list.length === nums){
    //         res.push([...list]);
    //     }
    //     for(let num of nums){
    //         // array using include
    //         // set map has // java; contain/ containsKey
    //         if(!list.includes(num)){
    //             nums
    //         }
    //     }
    // }
    return res;
};
// @lc code=end

