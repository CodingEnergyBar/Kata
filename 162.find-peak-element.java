/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        // if(nums.length == 1)
        //     return 0;
        int start=0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = (end - start) /2 + start;
            if(nums[mid] > nums[mid + 1])
                end = mid;
            else
                start = mid;
        }
        if(nums[start] > nums[end])
            return start;
        else
            return end;

    }
}
// @lc code=end

