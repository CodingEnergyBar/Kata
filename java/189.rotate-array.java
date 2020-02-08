/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // from the right [len -k, len-1] [0...len-k-1]
        int len = nums.length;

        k = k % len;
        rotateArray(nums, 0, len-k-1);
        rotateArray(nums, len-k, len-1);
        rotateArray(nums, 0, len-1);
        
    }
    void rotateArray(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
// @lc code=end

