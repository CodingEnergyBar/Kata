/*
 * @lc app=leetcode id=263 lang=javascript
 *
 * [263] Ugly Number
 *
 * https://leetcode.com/problems/ugly-number/description/
 *
 * algorithms
 * Easy (40.98%)
 * Likes:    276
 * Dislikes: 494
 * Total Accepted:    172.1K
 * Total Submissions: 419.9K
 * Testcase Example:  '6'
 *
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * 
 * Example 1:
 * 
 * 
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * 
 * Example 2:
 * 
 * 
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 14
 * Output: false 
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * 
 * 
 * Note:
 * 
 * 
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * 
 */

// @lc code=start
/**
 * @param {number} num
 * @return {boolean}
 */

const isUgly = function (num) {

    
    // corner case  negative and 0 and 1 
    if (num <= 0) return false;  
    if (num == 1) return true;  
    
    // every number has a while
    while (num >= 2 && num % 2 == 0) num /= 2;  
    while (num >= 3 && num % 3 == 0) num /= 3;  
    while (num >= 5 && num % 5 == 0) num /= 5;  
      
    return num == 1;
    
    
 // if(num === 0){
    //     return false;
    // }
    // while(num % 2 === 0 || num % 3 ===0 || num % 5 === 0){
    //     num = defactor(num, 2);
    //     num = defactor(num, 3);
    //     num = defactor(num, 5);
    // }
    
    // if(num === 1){
    //     return true;
    // }else{
    //     return false;
    // }
    
    
    function defactor(num, factor){
        if(num % factor === 0){
            return Math.floor(num / factor);
        }
        return num;
    }
}

// @lc code=end

