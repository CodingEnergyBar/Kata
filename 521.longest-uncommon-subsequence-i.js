/*
 * @lc app=leetcode id=521 lang=javascript
 *
 * [521] Longest Uncommon Subsequence I 
 */
/**
 * @param {string} a
 * @param {string} b
 * @return {number}
 */
// var findLUSlength = function(a, b) {
//     let res;
// 	if (a >= b) {
// 		res = findUncommon(a, b);
// 	}else{
//        res = findUncommon(b, a);
//     }
//     return res;
// };
// var findUncommon(a, b){
//     let subLen = a.length;
//     for(let i=0; i < a.length-subLen; i++){
//         if(a.slice(i, i+subLen))
//     }

// }

var findLUSlength = function(a, b) {
	if (a === b) return -1;
	else return Math.max(a.length, b.length);
};
