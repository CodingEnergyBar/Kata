/*
 * @lc app=leetcode id=34 lang=javascript
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

const FIRST = 1
const LAST = -1;
var searchRange = function (nums, target) {
    // function findPostion(nums, target, position) {
    //     let low = 0, high = nums.length - 1;

    //     let mid;
    //     while (low + 1 < high) { //[]
    //         mid = low + ((high - low) >> 1)
    //         // 以target 为锚点
    //         if (target < nums[mid]) {
    //             high = mid;
    //         } else if (target > nums[mid]) {
    //             low = mid;
    //         } else {
    //             // 相等的时候 mid
    //             if (position === FIRST) {
    //                 high = mid;
    //             } else {
    //                 low = mid;
    //             }
    //         }
    //     }// left + 1 == right 
    //     if (position === FIRST) {
    //         if (nums[low] === target)
    //             return low;
    //         else if (nums[high] === target)
    //             return high;
    //         else
    //             return -1;
    //     } else {
    //         if (nums[high] === target)
    //             return high;
    //         else if (nums[low] === target)
    //             return low;
    //         else
    //             return -1;
    //     }
    // }
    function findPostion(nums, target, position) {
        let low = 0, high = nums.length;

        let mid;
        while (low < high) { //[]
            mid = low + ((high - low) >> 1)
            // 以target 为锚点
            if (target < nums[mid]) {
                high = mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                // 相等的时候 mid
                if (position === FIRST) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }// left + 1 == right ]

        return low;
        // if (position === FIRST) {
        //     if (nums[low] === target)
        //         return low;
        //     else if (nums[high] === target)
        //         return high;
        //     else
        //         return -1;
        // } else {
        //     if (nums[high] === target)
        //         return high;
        //     else if (nums[low] === target)
        //         return low;
        //     else
        //         return -1;
        // }
    }

    const fP = findPostion(nums, target, FIRST)
    const lP = findPostion(nums, target, LAST)

    if (fP === lP)
        return [-1, -1]
    return [fP, lP - 1]
};
a = [5, 7, 7, 8, 8, 10]
b = 8
console.log(searchRange(a, b))

// @lc code=end

