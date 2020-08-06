package leetcode215;
/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int[] nums, int start, int end, int k) {
        int pivotIdx = start + (end - start) / 2;
        int pivot = nums[pivotIdx];
        int j = end;
        int i = start;
        swap(nums, i, pivotIdx);// 把pivot交换至数组头
        while (i < j) {
            while (i < j && nums[j] <= pivot) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] >= pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[j] = pivot;
        if ((j - start) == k - 1) {
            return pivot;
        } else if ((j - start) > k - 1) {
            return partition(nums, start, j - 1, k);
        } else {
            return partition(nums, j + 1, end, k - j + start - 1);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, k);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        new Solution().findKthLargest(nums, k);
        
    }
    
}
// @lc code=end

