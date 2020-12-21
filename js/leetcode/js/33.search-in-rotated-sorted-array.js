/*
 * @lc app=leetcode id=33 lang=javascript
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
// 我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内
var search = function (nums, target) {
    let left = 0, right = nums.length - 1;
    let mid;

    while (left <= right) {
        mid = left + ((right - left) >> 1)
        if (target === nums[mid])
            return mid;
        if (nums[mid] < nums[right]) {
            // mid - right 有序
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } else {
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
    return -1;

};
// @lc code=end

