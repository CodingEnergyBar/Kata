/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int[] arr = new int[26];
        for(char c: chars){
            arr[c-'a']+=1;
        }
        int p=0;
        for(int i=0; i< 26; i++){
            if(arr[i] == 0) continue;
           
            chars[p]= (char) ('a' + i);
            p++;
            if (arr[i] != 1){
                char[] charArr = (arr[i] + "").toCharArray();
                for(char c: charArr){
                 chars[p] = c;
                    p++ ;
                }
            }
        }
        return p;
    }
}
// @lc code=end

