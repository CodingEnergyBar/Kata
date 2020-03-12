/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    // 0 nothing yet, -1 none, 1 yes;
    int[] memo;
    List<String>[] memoData;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        int start = 0;
        Set dict = new HashSet<String>(wordDict);
        memo
        findCombination(0, s, dict, new ArrayList<String>());

        
        
        
    }
    void findCombination(int start, String s, Set<String> dict, ArrayList<String> path){
        if(start == s.length()){
            res.append()
            
        }
        for(int i=start+1; i<s.length();i++){
            String cur = s.substring(start, i);
            if(word.contains(cur)){
                path.add(cur);
                findCombination(i, s, dict);
                path.remove(path.size()-1);
            }
        }
        memo[start] = 0;

    }
}
// @lc code=end

