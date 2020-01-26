/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        // char[] arr = s.replaceAll("\\s|,|:", "").toLowerCase().toCharArray();
        char[] arr = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase().toCharArray();
        int start = 0, end = arr.length - 1;
        while (start < end && arr[start++] == arr[end--])
            ;
        if (start < end)
            return false;
        return true;

    }
}
// @lc code=end
