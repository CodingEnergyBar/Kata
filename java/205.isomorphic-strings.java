import java.util.Map;

/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> helper = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!helper.containsKey(c1)) {
                // one to one
                if (helper.containsValue(c2))
                    return false;
                helper.put(c1, c2);
            } else {
                if (helper.get(c1) != c2)
                    return false;
            }
        }
        return true;

    }
}
// @lc code=end
