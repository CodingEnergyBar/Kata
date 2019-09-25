/*
 * @lc app=leetcode id=350 lang=javascript
 *
 * [350] Intersection of Two Arrays II
 */
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(nums1, nums2) {
	nums1.sort((a, b) => a - b);
	nums2.sort((a, b) => a - b);
	console.log('nums1', nums1);
	console.log('nums2', nums2);
	let l1 = nums1.length;
	let l2 = nums2.length;
	let i1 = 0,
		i2 = 0,
		res = [];
	while (i1 < l1 && i2 < l2) {
		// console.log('i1', i1);
		// console.log('i2', i2);
		while (nums1[i1] < nums2[i2] && i1 < l1) {
			i1++;
		}
		while (nums2[i2] < nums1[i1] && i2 < l2) {
			i2++;
		}
		if (nums1[i1] === nums2[i2]) {
			res.push(nums1[i1]);
			i1++;
			i2++;
		}
		// console.log('i1', i1);
		// console.log('i2', i2);
		// console.log('----------');
	}
	console.log(res);
	return res;
};
// intersect([ 1, 2, 2, 1 ], [ 2, 2 ]);
