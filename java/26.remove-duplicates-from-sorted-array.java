/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        //[0...k) 是不重复的
        if(nums == null || nums.length == 0)
            return 0;
        

       int k=0;
       for(int i=0;i<nums.length;i++){
           if(k==0 || nums[i] > nums[k-1]){
               nums[k++] = nums[i];
           }
        //    if(k==0){
        //        nums[k++] = nums[i];
        //        continue;
        //    }
        //    if(nums[i] != nums[k-1])
        //         nums[k++] = nums[i];
       }
       return k;
    }
}
// @lc code=end

