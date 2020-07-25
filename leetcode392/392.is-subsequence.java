package leetcode392;
/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i =0, spanStart=0;
        //华东窗口....
        while( i< s.length()){
            String span = t.substring(spanStart);
            int j = span.indexOf(s.charAt(i));
            if( j== -1)
                return false;
            else{
                spanStart = spanStart+ j + 1;
            }
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println( new Solution().isSubsequence("aaaaaa", "bbaaaa"));
    }
}
// @lc code=end

