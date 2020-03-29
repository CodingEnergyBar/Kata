import java.util.Map;

/*
 * @lc app=leetcode id=1207 lang=java
 *
 * [1207] Unique Number of Occurrences
 */

// @lc code=start
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (Integer f : freq.values()) {
            if (set.contains(f))
                return false;
            else
                set.add(f);
        }
        return true;

    }
}
// @lc code=end
