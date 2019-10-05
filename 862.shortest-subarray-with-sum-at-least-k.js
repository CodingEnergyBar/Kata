/*
 * @lc app=leetcode id=862 lang=javascript
 *
 * [862] Shortest Subarray with Sum at Least K
 */

// @lc code=start
/**
 * @param {number[]} A
 * @param {number} K
 * @return {number}
 */
var shortestSubarray = function(A, K) {
    let j = 0;
    let curSum = 0;
    let min = Number.MAX_VALUE;
    for(let i=0; i<A.length;i++){
        while(j<A.length && curSum < K){
            curSum += A[j];
            j++;
        }
        if(curSum >= K){
            min = Math.min(j-i, min);
        }
        curSum -= A[i];
    }
    if(min === Number.MAX_VALUE){
        min = -1;
    }
    return min;
    
};
// @lc code=end

