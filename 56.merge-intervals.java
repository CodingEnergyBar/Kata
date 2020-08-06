import java.util.*;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2)->{
            if(i1[0] != i2[0])
                return i1[0] - i2[0];
            return i1[1]- i2[1];
        });
        ArrayList<int[]> res = new ArrayList<>();
        for(int [] interval: intervals){
            int len = res.size();
            if(len == 0){
                res.add(interval);
            }else{
                int[] last = res.get(len-1);
                if(interval[0] <= last[1]){
                    last[1] = Math.max(last[1], interval[1]);
                }else{
                    res.add(interval);
                }
            }
        }
        return  res.toArray(new int[res.size()][2]);
        
    }
}
// @lc code=end

