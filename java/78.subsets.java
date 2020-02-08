import java.util.*;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());

        // for(int )
        // [0...i]

        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> pre = res.get(j);
                List<Integer> cp = new ArrayList<Integer>(pre);
                cp.add(nums[i]);
                res.add(cp);
            }
        }
        return res;
    }

    // public static void main(String[] args) {
    // int[] nums = new int[] { 1, 2, 3 };

    // }

}
// @lc code=end
