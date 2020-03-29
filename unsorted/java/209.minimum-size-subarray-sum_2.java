/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = -1;
        int len = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0; // [0..-1]

        // while(i < len){
        // // [i..j]

        // while( j+1 < len && sum <= s){
        // j++;
        // sum = sum + nums[j];
        // }
        // minLen = Math.min(minLen, j-i+1);
        // while( sum > s && i < len){
        // sum = sum - nums[i];
        // i++;
        // }
        // if(sum == s)
        // minLen = Math.min(minLen, j-i+1);
        // if(i == j && i == len-1)
        // break;
        // System.out.println("i " + i + " j " + j );
        // }
        int sum = 0;
        while (i < len) {
            if (sum < s && j + 1 < len)
                sum += nums[++j];
            else
                sum -= nums[i++];
            if (sum >= s)
                minLen = Math.min(minLen, j - i + 1);
        }

        if (minLen == Integer.MAX_VALUE)
            return 0;
        return minLen;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        System.out.println(new Solution().minSubArrayLen(s, nums));
    }

    // 会增加复杂度
    int sum(int i, int j, int[] nums) {
        int s = 0;
        for (; i <= j; i++) {
            s += nums[i];
        }
        return s;
    }
}
// @lc code=end
