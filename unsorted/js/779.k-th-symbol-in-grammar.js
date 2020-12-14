/*
 * @lc app=leetcode id=779 lang=javascript
 *
 * [779] K-th Symbol in Grammar
 */

// @lc code=start
/**
 * @param {number} N
 * @param {number} K
 * @return {number}
 */
const kthGrammar = function(N, K) {
    // 0 1
    // 01 2,2
    // 0110  3,3
    // 01101001  4,5
    let sign = 1;
    while(N !== 1){
        sign = K % 2 === 0 ? -sign: sign;
        K = Math.floor((K+1)/2);
        N--;
    }
    if(sign === 1) return 0;
    else return 1;
    
};
console.log(kthGrammar(3,4));
// @lc code=end

