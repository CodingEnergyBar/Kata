/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.88%)
 * Likes:    4339
 * Dislikes: 396
 * Total Accepted:    655.8K
 * Total Submissions: 2.3M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len == 0) {
            return "";
        }
        boolean[][] f = new boolean[len][len];
        int max = 1;
        int start = 0;
        for (int i = 0; i < len; i++) {
            f[i][i] = true;
            if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                f[i][i + 1] = true;
                start = i;
                max = 2;
            }
        }
        for (int l = 3; l <= len; l++) {
            for (int i = 0; i + l - 1 <= len - 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && f[i + 1][j - 1] == true) {
                    f[i][j] = true;
                    start = i;
                    max = l;
                }
            }
        }
        return s.substring(start, start + max);
    }
}
// @lc code=end
