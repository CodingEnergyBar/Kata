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
        int[] freqs = getfreq(s);
        int[] freqt = getfreq(t);
        return isEqual(freqs, freqt);
        
    }
    int[] getfreq(String s){
        int[] res = new int [256];
        for(char c: s.toCharArray()){
            res[c]++;
        }
        return res;
    }
    boolean isEqual(int []a, int[] b){
        assert(a.length == 256);
        assert(b.length == 256);
        for(int i=0; i<256;i++){
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
}
// @lc code=end

