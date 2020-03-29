/*
 * @lc app=leetcode id=13 lang=javascript
 *
 * [13] Roman to Integer
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */

var romanToInt = function(s) {
    const hash = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    }
    let res = 0;
    for(let i = 0; i<s.length-1;i++){
        let ch =s[i];
        let next = s[i+1];
        let val1 = hash[ch];
        const val2 = hash[next];

        if(val1 < val2){
            val1 = -val1;
        }
        res += val1;

    }
    res += hash[s[s.length-1]];
    return res;
    
};
// @lc code=end

