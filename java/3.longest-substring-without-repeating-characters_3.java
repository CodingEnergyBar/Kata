/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0)
                return 0;
        //如果第一个数要写进去的话, hash 也要改
        int res = 0;
        int l = 0, r = -1;
        int[] hash = new int[256];
        char[] charArr = s.toCharArray();
        while(l< charArr.length){
            if(r+1 < charArr.length && hash[charArr[r+1]] == 0){
                 hash[charArr[++r]] = 1;
                 res =  Math.max(r-l+1, res);
            }else
                 hash[charArr[l++]] = 0;  
           
        }
        return res;
    }
}
// @lc code=end

