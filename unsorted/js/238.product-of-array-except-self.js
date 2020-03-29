/*
 * @lc app=leetcode id=238 lang=javascript
 *
 * [238] Product of Array Except Self
 */
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    let res = new Array(nums.length).fill(1);
    // console.log(res);
    for(let i =0; i <nums.length; i++){
       for(let j = 0; j < nums.length; j++){
            if(j === i)
                continue;
            res[j] *= nums[i];
       }
    }
    // console.log(res);
    return res;
};
productExceptSelf([1,2,3,4]);

