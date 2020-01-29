import java.util.Map.Entry;
import java.util.*;

/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        TreeMap<Character, Integer> freq = new TreeMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        List<Entry<Character, Integer>> rank = new ArrayList<Entry<Character, Integer>>(freq.entrySet());

        rank.sort((a, b) -> b.getValue() - a.getValue());

        ArrayList<Character> res = new ArrayList<>();
        for (Entry<Character, Integer> el : rank) {
            int count = el.getValue();
            Character c = el.getKey();
            for (int i = 0; i < count; i++) {
                res.add(c);
            }
        }
        return res.toString().replaceAll("[,\\s\\[\\]]", "");

    }
}
// @lc code=end
