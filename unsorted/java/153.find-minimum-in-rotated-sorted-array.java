/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        // [l...r]
        int l=0, r=nums.length-1;
        while(l+1<r){
            int m = l + (r-l)/2;
            if(nums[m] < nums[nums.length-1]){
                r = m;
            }else{
                l = m;
            }
        }
        return Math.min(nums[r], nums[l]);
        
    }
}
// @lc code=end

