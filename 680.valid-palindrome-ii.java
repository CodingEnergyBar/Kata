/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (34.86%)
 * Likes:    906
 * Dislikes: 63
 * Total Accepted:    93.4K
 * Total Submissions: 267.4K
 * Testcase Example:  '"aba"'
 *
 * 
 * Given a non-empty string s, you may delete at most one character.  Judge
 * whether you can make it a palindrome.
 * 
 * 
 * Example 1:
 * 
 * Input: "aba"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * 
 * 
 * Note:
 * 
 * The string will only contain lowercase characters a-z.
 * The maximum length of the string is 50000.
 * 
 * 
 */

// @lc code=start
public class Solution {
    /**
     * @param s: a string
     * @return boolean: whether you can make s a palindrome by deleting at most one
     *         character
     */
    public boolean validPalindrome(String s) {
        // Write your code here
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // substring need to include the border
                return validPalindromeSub(s.substring(left + 1, right + 1))
                        || validPalindromeSub(s.substring(left, right - 1 + 1));
            }
            left++;
            right--;
        }
        return true;
    }

    boolean validPalindromeSub(String s) {

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
// @lc code=end
