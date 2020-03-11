/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    int [] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        // substring[)
        Set<String> set = new HashSet<>(wordDict);
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return checkBreak(0, s, set);
        
    }
    boolean checkBreak(int start, String s, Set<String> set){
        if(start == s.length()){
            return true;
        }
        if(memo[start] == 0)
            return false;
        if(memo[start] == 1)
            return true;

        for(int i=start+1;i <= s.length(); i++ ){
          
            if(set.contains(s.substring(start, i))){
                if(checkBreak(i,s, set)){
                    memo[start] =  1;
                    return true;
                }
            }
        }
        memo[start] = 0;
        return false;

    }
}
// @lc code=end

