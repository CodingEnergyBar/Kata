import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        for(int num: nums){
            if(!hash.containsKey(num)){
                hash.put(num, 1);
            }else{
               hash.put(num, hash.get(num) +  1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(k, 
        (e1, e2)->{
            return e1.getValue() - e2.getValue();
        });
        if(k==0)
            return null;
        for(Map.Entry<Integer, Integer> e: hash.entrySet()){
            if(q.size() == k ){
                Map.Entry<Integer, Integer> top = q.peek();
                if(top.getValue() < e.getValue()){
                      q.poll();
                      q.offer(e);
                }
            }else{
                q.offer(e);
            }
        }
        // q.stream().mapToInt(Integer::intValue).toArray();
        List<Integer> res= new LinkedList<>();
        for(Map.Entry<Integer, Integer> e: q){
            // 在前面插入
            res.add(0,e.getKey());
        }
        return res;

    }
}
// @lc code=end
