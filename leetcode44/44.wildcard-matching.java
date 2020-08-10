package leetcode44;
/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.equals("*"))
            return true;
        if(p.length() > s.length() && !p.contains("*"))
            return false;
        int i=0, k=0;
        for(; i<p.length(); i++, k++){
            char patternLetter = p.charAt(i);
            if(patternLetter == '?'){
                 continue;
            }else if(patternLetter != '*'){
                if(patternLetter != s.charAt(i))
                    return false;
            }else{ // '*' s[i] p[i]*
                for(int j=i; j<=s.length();j++){
                    if(isMatch(s.substring(j), p.substring(i+1)))
                        return true;
                    
                }
                return false;
            }
        }
        return k == s.length();
    }
    
    public static void main(String[] args) {
        // int[][] grid = new int[][]
     
        String s = "acdcb";
        String p = "a*c?b";
        
        System.out.println(new Solution().isMatch(s, p));

    }
}
// @lc code=end

