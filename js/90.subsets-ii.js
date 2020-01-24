/*
 * @lc app=leetcode id=90 lang=javascript
 *
 * [90] Subsets II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    nums.sort((a,b)=> a-b);
    const res = [], subset = [];
    search(res, subset, nums);
    
    function search(res, subset, pool){
        console.log('subset', subset);
        console.log('pool', pool);
        res.push([...subset]);


        for(let i=0; i<pool.length;i++){

            if(i!== 0 && pool[i] === pool[i-1]){
                // console.log('pool[i]',pool[i]);
                // console.log('pool[i-1]', pool[i-1]);
                // !!!! here when break the loop this time using continue instead of break;
                continue;
            }

            subset.push(pool[i]);
            search(res, subset, pool.filter((c,index)=>index > i));
            subset.pop();
        }
    }
    return res;
};
// @lc code=end

