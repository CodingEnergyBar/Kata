/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[mid + 1])
                start = mid+1;
            else{
                end = mid;
            }
            
        }
        if(nums[start]> nums[end])
                return start;
        else
            return end;
        
    }
}
// @lc code=end

