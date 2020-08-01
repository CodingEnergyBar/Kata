package leetcode739;
import java.util.*;

/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
       
        for(int i=0; i< T.length; i++){
            int t = T[i];
            // if(stack.isEmpty() || T[stack.peek()] >= t){
                
            // }else{
            // stack peek < t
            while(!stack.isEmpty() && T[stack.peek()] < t){
                int pre = stack.pop();
                ans[pre] = i- pre;
            }
            stack.push(i);
            

        }
    
        // for(int i=0; i<ans.length; i++){
        //     ans[i] = res.get(i);
        // }
        return ans;
    }
    public static void main(String[] args) {
        int[] T = new int[]{
            73,74,75,71,69,72,76,73
        };
        new Solution().dailyTemperatures(T);
    }
}
// @lc code=end

