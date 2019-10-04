/*
 * @lc app=leetcode id=713 lang=javascript
 *
 * [713] Subarray Product Less Than K
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var numSubarrayProductLessThanK = function(nums, k) {
     let i=0, j = 0;
    
    let curPro = 1;
    let res=0;
    function layer(n){
        let res = 0;
        while(n>0){
            res += n;
            n--;
        }
        console.log('layer',res);
        return res;
    }
     
 
    if(k === 0 || nums.length === 0 || nums === null){
        return 0;
    }
    
    while(j<nums.length){
        curPro *= nums[j];
        while (curPro >= k && i < nums.length) {
            curPro /= nums[i];
            i++;
        }
        //???
        res += j-i+1;
        j++;
    }
    return res;
    
};
// @lc code=end

