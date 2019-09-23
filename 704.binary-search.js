/*
 * @lc app=leetcode id=704 lang=javascript
 *
 * [704] Binary Search
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let start=0, end=nums.length-1;
    while(start+1<end){
        let mid = ~~((start + end)/2);
        if (nums[mid] < target)
           start = mid;
        else if(nums[mid] > target){
            end = mid;
        }
        else
           return mid;
    }
    if(nums[start] == target)
        return start;
    else if(nums[end] == target){
        return end;
    }else
    return -1;
    
};

