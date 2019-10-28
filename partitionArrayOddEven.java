public class Solution {
    /*
     * @param nums: an array of integers
     * 
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        if (nums == null)
            return;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] % 2 == 1)
                left++;
            while (left <= right && nums[right] % 2 == 0)
                right--;
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
    }
}