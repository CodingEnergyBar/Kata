/*
 * @lc app=leetcode id=202 lang=javascript
 *
 * [202] Happy Number
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
/**
 * @param n: An integer
 * @return: true if this is a happy number or false
 */
const isHappy = function(n) {


	const nums = new Set();

    // not using while true
    // if there is 1, you dont need the corner case
	while (n !== 1) {
        // first n 
        // whether this one is in...
		if (nums.has(n)) {
			return false;
		}
        nums.add(n);
        // then happy number 
        n =  getNextNumer(n);;
    }

    return true;
};
// could be reduced
function getNextNumer(n) {
	let res = 0;
    while(n){
        // while you dequer, you process
        res += (n%10) *  (n%10);
        n = Math.floor(n/10);
    }

	return res;
}

// function getDigits(n) {
// 	const digits = [];
// 	while (n) {
// 		digits.push(n % 10);
// 		n = Math.floor(n / 10);
// 	}
// 	return digits;
// }

// @lc code=end
