/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int i=0, j=i, k=nums.length-1;
        int pivot = nums[j];
        while(i<=j){
            while(nums[i] == 0 && i <= j){
                i++;
            }
            while(nums[j] == 2 && i <= j)
                j--;
            swap(i, j, nums);
            i++;
            j--;
        }
        
    }
    void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

