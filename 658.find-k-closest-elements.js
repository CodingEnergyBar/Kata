/*
 * @lc app=leetcode id=658 lang=javascript
 *
 * [658] Find K Closest Elements
 */
/**
 * @param {number[]} arr
 * @param {number} k
 * @param {number} x
 * @return {number[]}
 */
var findClosestElements = function(arr, k, x) {
    if (k >= arr.length){
        return arr;
    }
	let newArr = [];
	for (let i = 0; i < arr.length; i++) {
		let diff = Math.abs(arr[i] - x);
		let val = arr[i];
		newArr.push({ diff, val });
	}
	newArr.sort((a, b) => {
		if (a.diff !== b.diff) return a.diff - b.diff;
		else return a.val - b.val;
	});
	let res = [];

	for (let i = 0; i < k; i++) {
		res.push(newArr[i].val);
	}

	return res.sort((a,b)=>a-b);
};
// let arr =[0,1,2,2,5,5,7,9,11,11,13,16,16,17,17,17,17,20,21,21,22,23,25,30,30,31,32,32,32,34,34,38,38,39,39,41,41,42,43,44,46,47,48,48,48,49,50,52,54,54,57,57,58,59,59,60,61,63,63,63,63,64,64,64,67,68,71,72,72,73,75,76,76,77,78,78,79,83,83,83,83,84,85,86,90,91,92,93,93,94,96,96,96,97,98,98,98,98,98,99];
// let arr = [0,1,2,2,5,5,7,9,11,11,13,16,16,17,17,17,17,20,21,21,22,23,25,30,30,31,32,32,32,34,34,38,38,39,39,41,41,42,43,44,46,47,48,48,48,49,50,52,54,54,57,57,58,59,59,60,61,63,63,63,63,64,64,64,67,68,71,72,72,73,75,76,76,77,78,78,79,83,83,83,83,84,85,86,90,91,92,93,93,94,96,96,96,97,98,98,98,98,98,99];
// let k = 94;
// let x = 47;
// console.log(arr.length);
// let res = findClosestElements(arr, k, x);
// console.log(res);
