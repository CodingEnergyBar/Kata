/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // [0...lt) [lt gt], (gt len-1]
        int len = nums.length;
        int lt=0, gt= len-1, p=lt;
        while(p<=gt){
            if(nums[p]<1){
                swap(lt, p, nums);
                lt++;
                   p++;
            }else if(nums[p]>1){
                swap(gt, p, nums);
                gt--;
            }else{
                p++;
            }
            // System.out.println("nums "+ Arrays.toString(nums));
        }
    }
    void swap(int n, int m, int[] nums){
        int tmp = nums[n];
        nums[n] = nums[m];
        nums[m] = tmp;
    }
}
// @lc code=end

