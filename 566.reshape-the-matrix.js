/*
 * @lc app=leetcode id=566 lang=javascript
 *
 * [566] Reshape the Matrix
 */

// @lc code=start
/**
 * @param {number[][]} nums
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */
var matrixReshape = function(nums, r, c) {
     if(nums.length === 0 || nums[0].length === 0){
         return nums;
     }
    const row  = nums.length;
    const col = nums[0].length;

    if(row * col !== r * c){
        return nums;
    }

    const res = new Array(r).fill().map(_=>new Array(c).fill());

    let x = 0;
    let y = 0;
    for(let i=0; i < row; i++){
        for(let j=0; j < col; j++){
            res[x][y++] = nums[i][j];
            if(y === c){
                y=0;
                x++;
            }
        }
    }
    return res;
   
    
    
};
// @lc code=end

