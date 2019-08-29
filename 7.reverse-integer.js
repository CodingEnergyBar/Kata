/*
 * @lc app=leetcode id=7 lang=javascript
 *
 * [7] Reverse Integer
 */
/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
   
    
    //
    var res = 0;
    var isNagative = false;
    if(x < 0){
        isNagative = true;
        x = -x;
    }
    while (x != 0){
        res = res * 10 + x % 10;
        x = Math.trunc(x / 10);
    }
    return isNagative? -res: res;
};
// reverse(123);

