/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int start=0, end= nums.length-1, mid;
        // [start...end] => start start+-1> start 
        while(start < end){ // / 
            mid = (start + end)/2;
            if(nums[mid] > nums[end]){ // mid+1... end
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return nums[start];
        
    }
}
// @lc code=end

