/*
 * @lc app=leetcode id=169 lang=javascript
 *
 * [169] Majority Element
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    if(nums === null || nums.length === 0){
        return null;
    }
	let res = {};
	for (let i = 0; i < nums.length; i++) {
		let e = nums[i];
		if (res[e] === undefined) {
			res[e] = 1;
		} else {
            res[e]++;
        
		}
	}
	// let ele = -1;
	for (let i in res) {
		if (res[i] > Math.floor(nums.length / 2)) {
              console.log(i);
            return i;
		}
    }
    // console.log(ele);

};
majorityElement([3,2,3]);
majorityElement([2,2,1,1,1,2,2]);
