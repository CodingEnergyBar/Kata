/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();
        for(String s: strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String anagram = new String(charArray);
            
            if(!hash.containsKey(anagram)){
               hash.put(anagram, new ArrayList<String>());
            }
            List l = hash.get(anagram);
            l.add(s);
        }
        return new ArrayList<List<String>>(hash.values());
        
    }
}
// @lc code=end

