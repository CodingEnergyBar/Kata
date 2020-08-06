/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] shash = getFrequecy(s);
        int[] thash = getFrequecy(t);
        return isEqual(shash, thash);
        
        
    }

    private boolean isEqual(int[] shash, int[] thash) {
        for(int i=0 ; i<26; i++)
            if(shash[i] != thash[i])
                return false;
        return true;
    }

    private int[] getFrequecy(String s) {
        int[] hash = new int[26];
        for(int c: s.toCharArray()){
            hash[c - 'a'] += 1;
        }
        return hash;
    }
}
// @lc code=end

