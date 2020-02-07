/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

// @lc code=start

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 归置 把当前的和 之前的联系起来
            if (nums[i] == 0) // reset sum to zero when encounters zeros
                sum = 0;
            else // keep update max
                max = Math.max(max, sum);
        }
        return max;
    }
}

class Solution {
    int[] memo;

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return maxones(nums, 0);

    }

    // from[0...n]
    int maxones(int[] nums, int start) {
        if (start == nums.length)
            return 0;
        if (memo[start] != -1)
            return memo[start];

        // 大胆的计算, 但是并没有合理的利用之前的计算
        int res = 0;
        for (int i = start; i < nums.length && nums[i] == 1; i++) {
            res++;
        }
        res = Math.max(res, maxones(nums, start + 1));
        memo[start] = res;
        return res;

    }
}
// @lc code=end
