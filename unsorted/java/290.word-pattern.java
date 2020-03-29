import java.util.*;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (str == null || str.equals(""))
            return false;
        String[] strArr = str.split(" ");
        if (strArr.length != pattern.length())
            return false;
        Map<Character, String> helper = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = strArr[i];
            /*
             * "abba" "dog dog dog dog" mapping should be one to one
             */
            if (!helper.containsKey(c)) {
                // only can be one to one
                if (helper.containsValue(s))
                    return false;
                helper.put(c, s);
            } else {

                if (!s.equals(helper.get(c)))
                    return false;
            }
        }
        return true;

    }
}
// @lc code=end
