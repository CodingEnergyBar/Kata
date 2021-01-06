/*
 * @lc app=leetcode.cn id=611 lang=javascript
 *
 * [611] 有效三角形的个数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var triangleNumber = function(nums) {

       
        let count = 0;
        nums.sort();
        for (let i = 0; i < nums.length - 2; i++) {
            let k = i + 2;
            for (let j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
        function binarySearch( nums,  l,  r,  x) { // [3, 4] 最后一个一个大于的数
            while (r >= l && r < nums.length) {
                let mid = (l + r) >>> 1;
                if (nums[mid] >= x)
                    r = mid - 1;
                else
                    l = mid + 1; // < sum
            }
            return l;
        }
        

};

triangleNumber([2,2,3,4])
// @lc code=end

