/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (53.71%)
 * Likes:    878
 * Dislikes: 117
 * Total Accepted:    407.6K
 * Total Submissions: 757.5K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 * 
 */

// @lc code=start
public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean isAnagram(String s, String t) {
        // write your code here
        // corner case:
        if (s == null || t == null) {
            return false;
        }

        // it is easier to implement
        int[] sHash = new int[256];
        int[] tHash = new int[256];

        for (char c : s.toCharArray()) {
            sHash[c]++;
        }
        for (char c : t.toCharArray()) {
            tHash[c]++;
        }

        // sHash array equal 
        return Arrays.equals(sHash, tHash);

    }
}
// @lc code=end
