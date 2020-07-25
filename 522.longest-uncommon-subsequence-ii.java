import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=522 lang=java
 *
 * [522] Longest Uncommon Subsequence II
 */

// @lc code=start
class Solution {
    public int findLUSlength(String[] strs) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, strs);
        int cnt = 0;
        for(String str: strs){
            if(str.length() > cnt)
                cnt = str.length();
            set.add(str);
        }
        //find whether is subcommon subseuqnce 
        
        if(set.size() == 1)
            return -1;
        return cnt;
        // set.addA(strs);
        
        
    }
}
// @lc code=end

