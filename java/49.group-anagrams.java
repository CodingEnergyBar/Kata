import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash =  new HashMap<>();
        for(String str: strs){
            String normalStr =  getNormalized(str);
            if(!hash.containsKey(normalStr)){
                hash.compute(normalStr, new ArrayList<String>());
            }
            hash.get(normalStr).add(str);
        }
        List<> res = new ArrayList<List>();
        for(String key: hash.keySet()){
            res.add(hash.get(key));
        }
        return res;
        
    }

    // quick sort template
    String getNormalized(String str){
        char[] arr = str.toCharArray();
        int lo=0, hi=arr.length-1;
        while(lo <= hi){
            int pivot = lo + (hi- lo)/2; 
            while(arr[lo] < arr[pivot] && lo <= hi) lo++;
            while(arr[hi] > arr[pivot] && lo <= hi) hi--;
            if(lo <= hi){
                char tmp = arr[lo];
                arr[lo] = arr[hi];
                arr[hi] = tmp;
                lo++;
                hi--;
            }
        }
        return new String(arr);
    }
}
// @lc code=end

