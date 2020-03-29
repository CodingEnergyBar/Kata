import java.util.Arrays;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        // cannot duplicate
        res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            twoSum(-nums[i], i+1, nums.length-1, nums);
        }
        return res;
        
    }
    void twoSum(int sum, int start, int end, int[] nums){
        while(start < end){
            if(nums[start] + nums[end] > sum)
                end--;
            else if(nums[start] + nums[end] == sum){
                res.add(new ArrayList<Integer>(){sum, nums[start], nums[end]});
                // 有机会完善一下
                while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
            }else{
                start++;
            }
        }
    }


}
// @lc code=end

