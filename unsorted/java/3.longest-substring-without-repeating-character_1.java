/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int[] freq =  new int [256];
        int[] freq = new int[256];
        int l=0, r=-1; //sliding window is [l..r]
        char[] sArr = s.toCharArray();
        int len = sArr.length;

        int maxLen = 0;

        while(l < len){

            if(r+1 < len && freq[sArr[r+1]] == 0){
                r++;
                freq[sArr[r]] =  1;
            }else{
                freq[sArr[l]]--;
                l++;
            }
            //在这里可以放心的找最大 实际上是因为这个最大也不会
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
        
    }
}
// @lc code=end

