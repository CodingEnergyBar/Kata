/*
 * @lc app=leetcode id=9 lang=javascript
 *
 * [9] Palindrome Number
 */

// @lc code=start
/**
 * @param num: a positive number
 * @return: true if it's a palindrome or false
 */
const isPalindrome = function (num) {
    // corner case: number is negative!!!
    if (num < 0){
        return false;
    }
    const orignal = num;
    let reverse = 0;
    while(num){
        // first multiply 10
        reverse *= 10;
        reverse += num % 10;
        //!!! javascript did not have automatically leave out
        num = Math.floor(num/10);
        // console.log('reverse', reverse);
    }
    return reverse === orignal;
    
    
}


// @lc code=end

