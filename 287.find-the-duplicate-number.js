/*
 * @lc app=leetcode id=287 lang=javascript
 *
 * [287] Find the Duplicate Number
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
// Solution 1: O(n^2)
// var findDuplicate = function(nums) {
//     let len = nums.length;
//     for(let i=0; i<len;i++){
//         for (let j=i+1; j<len;j++){
//             if(nums[i] == nums[j]){
//                 return nums[i];
//             }
//         }
//     }

// };

// Solution2 PigeonHole (binary search)

var findDuplicate = function(nums) {
	let len = nums.length;

	let start = 1,
		end = len - 1;

	while (start < end) {
		// console.log('start', start);
		// console.log('end', end);

		let mid = Math.trunc((start + end) / 2);
		// console.log('mid', mid);
		let counts = countsNoGreaterThan(mid);
		// console.log('counts ', counts);
		if (counts > mid) {
			end = mid;
		} else {
			// should be the same
			start = mid + 1;
		}
		// console.log('start', start);
		// console.log('end', end);
		// console.log('---------');
	}
	// start == end;
	return start;

	function countsNoGreaterThan(num) {
		let count = 0;
		// console.log('   start', start);

		for (let i = 0; i <= len; i++) {
			if (nums[i] <= num) {
				count++;
			}
		}
		return count;
	}
};
findDuplicate([ 1, 3, 4, 2, 2 ]);
