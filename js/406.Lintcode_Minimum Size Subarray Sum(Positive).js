// const minimumSize = function(nums, s) {
// 	let i = 0,
// 		j = 0;
// 	let min = 100000;
// 	console.log('min', min);
// 	let curSum = 0;
// 	for (i = 0; i < nums.length; i++) {
// 		while (j < nums.length && curSum < s) {
// 			curSum += nums[j];
// 			j++;
// 		}
// 		if (curSum >= s) {
// 			min = Math.min(j - i, min);
// 		}
// 		curSum -= nums[i];
// 	}
// 	if (min == 100000) {
// 		min = -1;
// 	}
// 	console.log('min', min);
// 	return min;
// };


const minimumSize = function (nums, s) {
    let i=0, j=0;
    let curSum  =0;
    let min = 10000000;
    for(;j<nums.length;j++){
        
        curSum += nums[j];
        
        while(curSum >= s && i < nums.length){
            // console.log('------update: j', j, 'i', i);
            min = Math.min(min, j-i+1);
            curSum -= nums[i];
            i++;
        }
    }
    if(min == 10000000){
        min = -1;
    }
    return min;
}

