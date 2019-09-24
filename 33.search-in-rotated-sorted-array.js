/*
 * @lc app=leetcode id=33 lang=javascript
 *
 * [33] Search in Rotated Sorted Array
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
	let start=0, end= nums.length-1;
	while(start + 1<end){
		console.log('start', start);
		console.log('end', end);
		let mid = Math.trunc((end+start)/2);
		if(target == nums[mid])
		   return mid;
		else if(nums[mid] > nums[start]){
			if(nums[start] <= target && target <= nums[mid]){
				end = mid;
			}else{
				start = mid;
			}
		}else{// mid is in the later half
			if(nums[mid] <= target && target <= nums[end]){
				start = mid;
			}else{
				end = mid;
			}
		}
		console.log('---------');
		console.log('start2', start);
		console.log('end2', end);
		console.log('---------');
	}
	if(nums[start] === target)
		return start;
	if(nums[end] === target)
		return end;
	return -1;
	
};

// console.log(search([ 4, 5, 6, 7, 0, 1, 2 ], 0));
console.log(search([ 1, 3 , 5], 5));
// console.log(search([ 1, 3 ], -1));
// console.log(search([ 1, 3 ], 3));
