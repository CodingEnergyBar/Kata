/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        String t = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        char[] arr = t.toCharArray();
        int len =  arr.length;
        for(int i=0; i<len/2;i++){
            if(arr[i] != arr[len-i-1]){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

