/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    int[] memo;

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        memo = new int[nums.length];
        Arrays.fill(memo, 1);
        memo[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
            }
        }

        return findMax(memo);
        // return findLIS(nums, nums.length - 1);
    }

    int findMax(int[] arr) {
        int res = 1;
        for (int num : arr) {
            if (num > res)
                res = num;
        }
        return res;
    }

    int findLIS(int[] nums, int end) {
        // only have one numebr
        if (end == 0)
            return 1;
        if (memo[end] != -1)
            return memo[end];

        int res = 1;
        for (int i = 0; i < end; i++) {
            if (nums[i] < nums[end]) {
                res = Math.max(res, 1 + findLIS(nums, i));
            }
        }
        memo[end] = res;
        return res;
    }
}
// @lc code=end
