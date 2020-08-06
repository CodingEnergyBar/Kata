package leetcode179;

import java.util.*;
import java.util.stream.Collector;

/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> numsStr=  new ArrayList<>();
        // List<String> numsStr=  Arrays.asList(nums).stream().map(num->(String(num))).collect(Collector.toList());
        for(int num: nums){
            String cur = Integer.toString(num);
            numsStr.add(cur);
        }
      

        Collections.sort(numsStr, (i, j) ->{
            String s1 = i + j;
            String s2 = j + i;
            return s2.compareTo(s1);
            // char[] iArr = i.toCharArray();
            // char[] jArr = j.toCharArray();
            // int pi =0,  pj=0;
            // while(pi < iArr.length && pj < jArr.length){
            //     if(iArr[pi] != jArr[pj])
            //         return jArr[pj] - iArr[pi];
            //     pi++; pj++;
            // }
            // if(pi ==  pj)
            //     return 1;
            // if(pi == iArr.length) {
            //     // 3 34
            //     if(jArr[pj] > iArr[pi-1])
            //         return 1;
            //     else // 3 30
            //         return -1;
            // }else{
            //      if(iArr[pi] > jArr[pj-1])
            //         return -1;
            //     else // 3 30
            //         return 1;
            // }
        });
        if(numsStr.get(0).charAt(0) == '0') return "0";
        StringBuilder ans = new StringBuilder();
        for(String cur: numsStr){
            ans.append(cur);
        }
        return ans.toString();


        
    }
    public static void main(String[] args) {
        // int[] nums = {10, 2};
        int[] nums = { 3, 30, 34, 5, 9};
        new Solution().largestNumber(nums);
    }
}
// @lc code=end

