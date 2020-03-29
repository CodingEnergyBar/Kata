/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
       
        return isEqual(getFreq(s), getFreq(t));
        
    }
    int[] getFreq(String s){
        int[] res = new int[256];
        for(char a: s.toCharArray()){
            res[a]++;
        }
        return res;
    }
    boolean isEqual(int[] a, int[] b){
        for(int i=0; i<256; i++){
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
}
// @lc code=end

