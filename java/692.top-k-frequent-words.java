import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> wordToFreq=  new TreeMap<>((a, b)-> b.getValue() - a.getValue());
        for(String w: words){
            if(!wordToFreq.containsKey(w)){
                wordToFreq.put(w, 1);
            }else{
                wordToFreq.put(w, wordToFreq.get(w)+1);
            }
        }
        // if(k > words.)
        List<String> res = new ArrayList<>();
        for(int i=0; i<k; i++){
            Map.Entry<String, Integer> cur =  wordToFreq.pollFirstEntry();
            res.add(cur.getKey());
        }
        return res;
        
        
    }
}
// @lc code=end

