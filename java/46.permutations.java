import java.util.*;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {

    Map<Integer, Integer> hash;
    List<Integer> path;
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        hash = new HashMap<Integer, Integer>(nums.length);
        for (int i : nums) {
            hash.put(i, 0);
        }
        path = new ArrayList<Integer>();
        res = new ArrayList<List<Integer>>();

        findPermute(nums, 0);
        return res;
    }

    void findPermute(int[] nums, int start) {
        if (start == nums.length) {
            res.add(new ArrayList<Integer>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (hash.get(nums[i]) == 0) {
                path.add(nums[i]);
                hash.put(nums[i], 1);
                findPermute(nums, start + 1);
                hash.put(nums[i], 0);
                path.remove(path.size() - 1);
            }
        }
    }

}
// @lc code=end
