import java.util.Arrays;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (50.08%)
 * Likes:    2524
 * Dislikes: 196
 * Total Accepted:    457.6K
 * Total Submissions: 906.6K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        System.out.println("nums " + Arrays.toString(nums));
        partition(nums, k - 1, 0, nums.length - 1);
        return nums[k - 1];

    }

    void partition(int[] nums, int targetId, int start, int end) {

        int i = start, j = end;
        if(start == end)
            return;
        System.out.println("i " + i + "j " + j);
        int pivot = nums[(start + end) / 2];
        while (i <= j) {
            while (i <= j && nums[i] > pivot)
                i++;
            while (i <= j && nums[j] < pivot)
                j--;
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        System.out.println("nums " + Arrays.toString(nums));
        System.out.println("j " + j);
        System.out.println("i " + i);
        System.out.println(" ---------- ");

        if (targetId <= j) {
            partition(nums, targetId, start, j);
        }
        if (targetId >= i)
            partition(nums, targetId, i, end);

        return;

    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// @lc code=end
