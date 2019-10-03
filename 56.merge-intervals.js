/*
 * @lc app=leetcode id=56 lang=javascript
 *
 * [56] Merge Intervals
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    intervals.sort((a, b)=>(a[0]- b[0]));
    let last = null;
    let res = [];
    for(let cur of intervals){
        
        if(last === null || cur[0] > last[1]){
            last = cur;
            res.push(last);
        }else{
            last[1] = Math.max(last[1], cur[1]);
        }
        // console.log('last', last);
        // console.log('cur', cur);
    }
    return res;
    
};
// @lc code=end

