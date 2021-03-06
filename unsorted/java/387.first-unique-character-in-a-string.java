/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (50.73%)
 * Likes:    1223
 * Dislikes: 87
 * Total Accepted:    329.2K
 * Total Submissions: 648.4K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] hash = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            hash[ch] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] == 1)
                return i;
        }
        return -1;

    }
}
// @lc code=end
