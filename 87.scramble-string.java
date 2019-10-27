/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 *
 * https://leetcode.com/problems/scramble-string/description/
 *
 * algorithms
 * Hard (32.31%)
 * Likes:    357
 * Dislikes: 567
 * Total Accepted:    97.7K
 * Total Submissions: 301.5K
 * Testcase Example:  '"great"\n"rgeat"'
 *
 * Given a string s1, we may represent it as a binary tree by partitioning it
 * to two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 * 
 * 
 * ⁠   great
 * ⁠  /    \
 * ⁠ gr    eat
 * ⁠/ \    /  \
 * g   r  e   at
 * ⁠          / \
 * ⁠         a   t
 * 
 * 
 * To scramble the string, we may choose any non-leaf node and swap its two
 * children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it
 * produces a scrambled string "rgeat".
 * 
 * 
 * ⁠   rgeat
 * ⁠  /    \
 * ⁠ rg    eat
 * ⁠/ \    /  \
 * r   g  e   at
 * ⁠          / \
 * ⁠         a   t
 * 
 * 
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it
 * produces a scrambled string "rgtae".
 * 
 * 
 * ⁠   rgtae
 * ⁠  /    \
 * ⁠ rg    tae
 * ⁠/ \    /  \
 * r   g  ta  e
 * ⁠      / \
 * ⁠     t   a
 * 
 * 
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a
 * scrambled string of s1.
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 * 
 */

// @lc code=start
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        // string join just new string (char[])
        if (!new String(c1).equals(new String(c2)))
            return false;

        int len = s1.length();
        for (int i = 1; i < s1.length(); i++) {
            boolean res = (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                    || (isScramble(s1.substring(0, i), s2.substring(len - i))
                            && isScramble(s1.substring(i), s2.substring(0, len - i)));
            if (res == true)
                return true;
        }
        return false;

    }
}
// @lc code=end
