package leetcode540;
/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length;
        if(nums.length == 1)
            return nums[0];
        // [)
        while(start < end){
            int mid = (end - start) / 2 + start;
            if(mid == 0 && nums[mid] != nums[mid+1])  
                return nums[mid];
            if (mid == nums.length - 1 && nums[mid] != nums[mid - 1])
                return nums[mid];
            if(nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];
            if(mid % 2 == 1){
                if(nums[mid] != nums[mid+1]){
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }else{
                if (nums[mid] != nums[mid + 1]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return nums[start];
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        new Solution().singleNonDuplicate(nums);
    }
}
// @lc code=end

