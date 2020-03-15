/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {


    public String minWindow(String s, String t) {

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (char a : t.toCharArray()) {
            if (!tMap.containsKey(a)) {
                tMap.put(a, 1);
            } else {
                tMap.put(a, tMap.get(a) + 1);
            }
        }
        for (char a : s.toCharArray()) {
            sMap.put(a, 0);
        }
        int l = 0, r = -1;
        boolean found = false;
        String res = s;
        while (l < s.length()) {
            if (r + 1 < s.length() && !tMapFilled(sMap, tMap)) {
                r++;
                char cr = s.charAt(r);
                sMap.put(cr, sMap.get(cr) + 1);
            } else {
                char cl = s.charAt(l);
                sMap.put(cl, sMap.get(cl) - 1);
                l++;
            }

            if (tMapFilled(sMap, tMap) && r - l + 1 <= res.length()) {
                found = true;
                res = s.substring(l, r + 1);
                // System.out.println("answer " +res);

            }
        }
        if (found == false) {
            return "";
        } else {
            return res;
        }

    }

    boolean tMapFilled(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Character a : tMap.keySet()) {
            if (!sMap.containsKey(a) || sMap.get(a) < tMap.get(a)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
