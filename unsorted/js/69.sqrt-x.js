/*
 * @lc app=leetcode id=69 lang=javascript
 *
 * [69] Sqrt(x)
 */

// @lc code=start
/**
 * @param {number} x
 * @return {number}
 */

//!!!!Remember that the square root of each X must happen within [1, x/2 + 1]

// const mySqrt = function(x){
//     if(x === 1){
//         return 1;
//     }
//     let start = 0, end = x;
//     const eps = 1e-12;
//     while(start + eps < end){
//         const mid = (start + end) /2;
//         if(mid * mid > x){
//             end = mid;
//         }else if(mid * mid < x){
//             start = mid;
//         }else{
//             return Math.trunc(mid);
//         }
//     }
//     return Math.trunc(start);
// }


const mySqrt = function(x) {
	// write your code here
	// corner case:
	if (x < 1) {
		return 0;
	}
	// !!! integer and double could be different
	let start = 1,
		end = Math.floor(x / 2 + 1);
	// !!! please check the question more carefully, here it is integer and integer's value is like only needed    // console.log(PRECISION);
	let mid = start;

	while (start + 1 < end) {
		mid = Math.floor((start + end) / 2);
		if (mid * mid > x) {
			end = mid;
		}
		else if (mid * mid < x) {
			start = mid;
		}
		else {
			return mid;
		}
	}
	return start;
};

//   var mySqrt = function(x) {
//   // Remember that the square root of each X must happen within [1, x/2 + 1]

//   var left = 1;
//   var right = Math.floor(x / 2) + 1;
//   var mid;

//   while (left <= right) {
//     mid = Math.floor((left + right) / 2);

//     if (mid * mid > x) {
//       right = mid - 1;
//     } else if (mid * mid < x) {
//       left = mid + 1;
//     } else {
//       return mid;
//     }
//   }

//   return right;
// };
// mySqrt(4);
// @lc code=end
