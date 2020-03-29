/*
 * @lc app=leetcode id=819 lang=java
 *
 * [819] Most Common Word
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<String>();
        bannedSet.addAll(Arrays.asList(banned));
        String p =  paragraph.replaceAll("\\pP", " ").toLowerCase();
        System.out.println("p " + p);
        String[] words = p.split("\\s+");
        Map<String, Integer> hash = new HashMap<>();
        
        for(String w: words){
            if( bannedSet.contains(w))
                continue;
            if(!hash.containsKey(w)){
                hash.put(w, 1);
            }else{
                hash.put(w, hash.get(w) + 1);
            }
        }
//         PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2)->
//              e2.getValue() - e1.getValue()
//         );
        
//         pq.addAll(hash.entrySet());
//         for(Map.Entry<String, Integer>e: pq){
//             if(!bannedSet.contains(e.getKey()))
//                     return e.getKey();
//         }
        return Collections.max(hash.entrySet(), Map.Entry.comparingByValue()).getKey();

    }

// @lc code=end

