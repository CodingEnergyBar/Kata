/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // value, index
        Map<Integer, Integer> hash =  new HashMap<>();
        for(int i=0; i< nums.length;i++){
            int cur = nums[i];
            int rest = target - cur;
            if(hash.containsKey(rest)){
                return new int[]{hash.get(rest), i};
            }else{
                hash.put(cur, i);
            }

        }
        return null;
        
    }
}
// @lc code=end

