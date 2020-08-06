/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        int i=0, j=s.length-1;
        while(i < j){
            swap(s, i,j);
            i++;
            j--;
        }
        
    }
    void swap(char[] s, int i, int j ){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
// @lc code=end

