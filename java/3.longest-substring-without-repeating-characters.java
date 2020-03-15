/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = -1;
        //
        int[] hash = new int[256];

        int maxLen = 0;
        while (i < s.length()) {
            if (j + 1 < s.length() && hash[s.charAt(j + 1)] == 0) {
                hash[s.charAt(++j)] = 1;
            } else {// i++
                hash[s.charAt(i++)] = 0;
            }
            if (j - i + 1 > maxLen)
                maxLen = j - i + 1;
        }
        return maxLen;

    }
}
// @lc code=end

