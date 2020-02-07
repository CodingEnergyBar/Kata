import java.util.*;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 看好题啊...
        int[] res = new int[] { -1, -1 };
        Pair<Integer, Integer>[] arr = new Pair<>[nums.length]; 
        for(int i=0; i<nums.length;i++){
            arr[i].first
        }

        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target)
                return new int[] { i, j };
            else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        throw new Error("no result");

    }
}
// @lc code=end
