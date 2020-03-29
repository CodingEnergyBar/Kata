import java.util.*;

/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq1 = new HashMap<>();
        for (int i : nums1) {
            freq1.put(i, freq1.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if (freq1.containsKey(i) && freq1.get(i) != 0) {
                res.add(i);
                freq1.put(i, freq1.get(i) - 1);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
