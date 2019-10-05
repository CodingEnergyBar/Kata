/*
 * @lc app=leetcode id=20 lang=javascript
 *
 * [20] Valid Parentheses
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let stack = [];
    const map = {'}':'{', ']':'[',')':'('};
    for(const c of s){
        if("([{".includes(c)){
            stack.push(c);
        }else{
            if(stack[stack.length-1] === map[c]){
                stack.pop();
            }
            else 
            return false;
        }
    }
    if(stack.length !== 0){
        return false;
    }
    return true;
    
};
// @lc code=end

