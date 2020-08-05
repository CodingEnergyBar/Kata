package leetcode1297;
import java.util.*;
/*
 * @lc app=leetcode id=1297 lang=java
 *
 * [1297] Maximum Number of Occurrences of a Substring
 */

 //因此一个大于 minSize 长度的字串出现了 n 次，那么该子串其中必定有一个长度为 minSize 的子串出现了 n 次。
// @lc code=start
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        //
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        char[] arr = s.toCharArray();
        int L = arr.length;
        int i,j;
        // for(int len=minSize; len<=maxSize; len++){
       
        for( i = 0, j=i + minSize; j <= L; i++, j++){
            //+minSize 之后的那个位不是最后一位, 而是最后一位的后面那位
            String cur = s.substring(i, j);
            if(map.containsKey(cur)){
                int curOccur = map.get(cur) + 1;
                if(curOccur > max)
                    max = curOccur;
                map.put(cur, curOccur);
            }else{
                if(isValid(cur, maxLetters))
                {
                    map.put(cur, 1);
                    max = Math.max(1, max);
                }
            }
            
        }
        // }
        return max;
        
    }
    boolean isValid(String s, int maxLetter){
        int[] map = new int[26];
        int curLetterNum = 0;
        for(char c: s.toCharArray()){
            if(map[c - 'a'] == 0){
                curLetterNum++;
                if(curLetterNum > maxLetter)
                    return false;
            }
            map[c - 'a'] += 1;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxFreq("aababcaab", 2, 3, 4);
    }
}
// @lc code=end

