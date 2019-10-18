public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k:    An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] < k) {
                left++;
                // System.out.println("left " + left);
            }
            while (left <= right && nums[right] >= k) {
                right--;
            }
            if (left <= right)
                swap(nums, left, right);
        }
        return left;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}