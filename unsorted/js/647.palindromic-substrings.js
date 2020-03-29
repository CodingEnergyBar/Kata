/*
 * @lc app=leetcode id=647 lang=javascript
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function(s) {

     const len = s.length;
    
     // how to annouce a two deminsional array: first column, then row using map and fille
    const dp = [...Array(len)].map(x=>Array(len).fill(0));
    
    let res = 0;
    
    for(let j=0; j<len;j++){
        
        for(let i=0; i<=j; i++){
        
            if(i === j){
            
                dp[i][j] = 1;
            }
            else if((i+1) === j && s[i] === s[j]){

                dp[i][j] = 1;
            }
            else {
                if(dp[i+1][j-1] === 1 && s[i] === s[j]){
            
                dp[i][j] = 1;
                }
            }
            
            res += dp[i][j];
        }
    }
    
    return res;
    
};
// @lc code=end

