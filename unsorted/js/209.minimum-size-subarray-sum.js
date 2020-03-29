/*
 * @lc app=leetcode id=209 lang=javascript
 *
 * [209] Minimum Size Subarray Sum
 */
/**
 * @param {number} s
 * @param {number[]} nums
 * @return {number}
 */

var minSubArrayLen = function(s, nums) {
    // corner case
    if(nums.length == 0) {return 0;}

    // let minLen = Number.MAX_SAFE_INTEGER;
    let minLen =  Number.MAX_SAFE_INTEGER;

    let curSum = 0;
    let l=0, r=0;
    curSum = nums[r];
    
    for(l=0; l<nums.length;l++){
        while(r < nums.length ){
            if(curSum < s){
                r++;
                curSum += nums[r];
            }else{
                //curSum >= s
                
                break;
            }
        }
        if(curSum >= s){
            minLen = Math.min(minLen, r-l+1);
        }
        curSum -= nums[l];
    }
    if(minLen == Number.MAX_SAFE_INTEGER)
        return 0;

    return minLen;
};

// test
let nums = [2,3,1,2,4,3];
minSubArrayLen(7, nums);

